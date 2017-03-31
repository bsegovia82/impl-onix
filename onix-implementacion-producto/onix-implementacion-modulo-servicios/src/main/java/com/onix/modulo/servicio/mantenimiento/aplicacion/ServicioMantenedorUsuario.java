package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.dominio.aplicacion.OmsUsuariosRole;
import com.onix.modulo.eao.aplicacion.OmsUsuarioEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.generales.UtilEncriptarDataSource;
import com.onix.modulo.librerias.servicio.oyentes.AccionTransaccionalListener;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionSimpleListener;
import com.onix.modulo.librerias.servicio.oyentes.PreLlenadoRegistroListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorUsuario extends ServicioMantenedorControlAuditoria<OmsUsuarioEAO, OmsUsuario, Long> {

	@EJB
	private OmsUsuarioEAO crud;

	@EJB
	private ServicioMantenedorRol servicioRol;

	@EJB
	private ServicioMantenedorUsuarioRol servicioUsuarioRol;

	protected OmsUsuarioEAO getCrud() {
		return crud;
	}

	public List<OmsRole> listaRoles() {
		return servicioRol.listaObjetosActivos(OmsRole.class);
	}

	public OmsRole obtenerRolPorID(Long idRol) {
		return servicioRol.buscarRolPorID(idRol);
	}

	public List<OmsUsuario> listaUsuarioPorRol(Long pIdRol) {
		return crud.listaUsuarioPorRol(pIdRol);
	}

	@Override
	protected void cargarConfiguracionServicio() {

		addPostInsertListener(new AccionTransaccionalListener<OmsUsuario, Long>() {

			@Override
			public void controlTransaccional(OmsUsuario entidad) throws ErrorServicioNegocio, ErrorValidacionGeneral {
				List<OmsUsuariosRole> listaUsuarioRoles = entidad.getPriUsuariosRoles();
				if (listaUsuarioRoles != null && !listaUsuarioRoles.isEmpty())
					for (OmsUsuariosRole usuariosRoleRol : listaUsuarioRoles) {
						usuariosRoleRol.setAuditoria(entidad.getAuditoria());
						servicioUsuarioRol.guardarActualizar(usuariosRoleRol);
					}

			}
		});

		addDatosRegistroUpdateListener(new PreLlenadoRegistroListener<OmsUsuario, Long>() {

			@Override
			public void preCargaDatosRegistro(OmsUsuario entidad) {
				entidad.setEsNuevo(ES_NUEVO);
			}
		});

		addDatosRegistroInsertListener(new PreLlenadoRegistroListener<OmsUsuario, Long>() {
			@Override
			public void preCargaDatosRegistro(OmsUsuario entidad) {
				entidad.setEsNuevo(ES_NUEVO);

			}

		});

		addValidacionSimpleInsertListener(new AccionValidacionSimpleListener<OmsUsuario, Long>() {

			@Override
			public void validacionDatos(OmsUsuario entidad) throws ErrorValidacionGeneral {
				if (entidad.getClave().length() < 8)
					throw new ErrorValidacionGeneral("La clave del usuario debe tener más de ocho caracteres");
				try {
					entidad.setClave(UtilEncriptarDataSource.encode(entidad.getClave()));
				} catch (Throwable e) {
					throw new ErrorValidacionGeneral("Eror al encriptar la clave");
				}
			}
		});

		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmsUsuario, Long>() {

			@Override
			public void validacionTransaccional(OmsUsuario entidad) throws ErrorServicioNegocio {
				OmsUsuario usuario = crud.buscarUsuario(entidad.getUsuario());
				if (usuario != null)
					throw new ErrorServicioNegocio(
							"El usuario " + usuario.getUsuario() + ", ya se encuentra registrado");

			}
		});

		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmsUsuario, Long>() {

			@Override
			public void validacionTransaccional(OmsUsuario entidad) throws ErrorServicioNegocio {
				OmsUsuario usuario = crud.buscarUsuario(entidad.getUsuario());
				if (usuario != null && !entidad.getId().equals(usuario.getId()))
					throw new ErrorServicioNegocio(
							"El usuario " + usuario.getUsuario() + ", ya se encuentra registrado para otra persona");

			}

		});

	}

	public List<String> obtenerRolesAsignados(Long id) {
		String lQuery = "select b.ROL from OMS_USUARIOS_ROLES a, OMS_ROLES b " + "where a.ID_USUARIO = :idUsuario  "
				+ "and a.ESTADO = 'A' " + "and b.id = a.ID_ROL " + "and b.ESTADO = 'A'";
		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idUsuario", id);
		return crud.ejecutarNativeQueryList(lQuery, lParametros, String.class);
	}

	public List<String> obtenerRolesPorAsignar(String usuarioAutenticado, Long id) {
		String lQuery = "select e.ROL from OMS_USUARIOS_ROLES c, OMS_ROLES e "
				+ "where c.ID_USUARIO in (select d.id from OMS_USUARIOS d where d.usuario = :usuario and d.ESTADO = 'A') "
				+ "and C.ESTADO = 'A' " + "and e.id = c.ID_ROL " + "and e.estado = 'A' " + "and  e.id not in ( "
				+ "select b.id from OMS_USUARIOS_ROLES a, OMS_ROLES b " + "where a.ID_USUARIO = :idUsuario  "
				+  "and b.id = a.ID_ROL " + "and b.estado = 'A' " + ")";

		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("usuario", usuarioAutenticado);
		lParametros.put("idUsuario", id);
		return crud.ejecutarNativeQueryList(lQuery, lParametros, String.class);
	}

	public void asigarRoles(List<String> lRolesTransferidas, String usuarioAutenticado, Long id, Long referencia)
			throws ErrorServicioNegocio, ErrorValidacionGeneral {
		for (String lRol : lRolesTransferidas) {

			OmsUsuariosRole lOmsUsuariosRole = servicioUsuarioRol.obtenerUsuarioRolPorRolUsuario(lRol, id);

			if (lOmsUsuariosRole != null) {
				lOmsUsuariosRole.setAuditoria(usuarioAutenticado);
				lOmsUsuariosRole.setFechaActualizacion(new Date());
				lOmsUsuariosRole.setEstado(GenericEAO.ESTADO_ACTIVO);
				lOmsUsuariosRole
						.setObservacion("ACTIVACION DE OPCION DESDE LA WEB POR EL USUARIO " + usuarioAutenticado);
			} else {
				OmsRole lOmsRol = servicioRol.obtenerObjetoPropiedad("rol", lRol, OmsRole.class);
				lOmsUsuariosRole = new OmsUsuariosRole();
				lOmsUsuariosRole.setEstado(GenericEAO.ESTADO_ACTIVO);
				lOmsUsuariosRole.setObservacion("REGISTRO DE OPCION DESDE LA WEB POR EL USUARIO " + usuarioAutenticado);
				lOmsUsuariosRole.setFechaRegistro(new Date());
				lOmsUsuariosRole.setIdReferencia(referencia);
				lOmsUsuariosRole.setAuditoria(usuarioAutenticado);
				lOmsUsuariosRole.setPriUsuario(getCrud().find(id, OmsUsuario.class));
				lOmsUsuariosRole.setPriRole(lOmsRol);
			}
			servicioUsuarioRol.guardarActualizar(lOmsUsuariosRole);
		}

	}

	public boolean permitirEliminarUsuarioRol(Long idUsuario) throws ErrorServicioNegocio, ErrorValidacionGeneral {
		return servicioUsuarioRol.obtenerListaUsuarioRolIdUsuario(idUsuario).size() > 1;
	}

	public Integer inactivarRoles(List<String> lRolesTransferidas, String usuarioAutenticado, Long id)
			throws ErrorServicioNegocio, ErrorValidacionGeneral {
		Integer lResultado = 0;
		for (String lRol : lRolesTransferidas) {

			OmsUsuariosRole lOmsUsuariosRole = servicioUsuarioRol.obtenerUsuarioRolPorRolUsuario(lRol, id);
			if (!permitirEliminarUsuarioRol(id)) {
				lResultado = 1;
				break;
			}
			if (lOmsUsuariosRole != null) {
				lOmsUsuariosRole.setAuditoria(usuarioAutenticado);
				lOmsUsuariosRole.setFechaActualizacion(new Date());
				lOmsUsuariosRole.setEstado(GenericEAO.ESTADO_INACTIVO);
				lOmsUsuariosRole
						.setObservacion("INACTIVACION DE OPCION DESDE LA WEB POR EL USUARIO " + usuarioAutenticado);
				servicioUsuarioRol.guardarActualizar(lOmsUsuariosRole);
			}
		}
		return lResultado;

	}

}
