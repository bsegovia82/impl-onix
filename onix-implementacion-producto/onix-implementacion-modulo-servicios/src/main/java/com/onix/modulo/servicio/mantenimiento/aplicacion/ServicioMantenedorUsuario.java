package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.Date;
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
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorUsuario extends ServicioMantenimientoEntidad<OmsUsuarioEAO, OmsUsuario, Long> {

	@EJB
	private OmsUsuarioEAO crud;

	@EJB
	private ServicioMantenedorRol servicioRol;
	
	@EJB
	private ServicioMantenedorUsuarioRol servicioUsuarioRol;
	

	protected OmsUsuarioEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmsUsuario entidad) throws ErrorServicioNegocio {
		OmsUsuario usuario = crud.buscarUsuario(entidad.getUsuario());
		if (usuario != null) {
			if (!entidad.getId().equals(usuario.getId())) {
				throw new ErrorServicioNegocio("El usuario " + usuario.getUsuario()
						+ ", ya se encuentra registrado para otra persona");
			}
		}
	}

	@Override
	protected void validacionesBasicasActualizar(OmsUsuario entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION : entidad
				.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria().length() < 2 ? REFERENCIA : entidad.getAuditoria());
		entidad.setEs_nuevo(ES_NUEVO);
	}

	@Override
	protected void validacionesConBaseGuardar(OmsUsuario entidad) throws ErrorServicioNegocio {
		OmsUsuario usuario = crud.buscarUsuario(entidad.getUsuario());
		if (usuario != null) {
			throw new ErrorServicioNegocio("El usuario " + usuario.getUsuario() + ", ya se encuentra registrado");
		}
	}

	@Override
	protected void validacionesBasicasGuardar(OmsUsuario entidad) throws ErrorValidacionGeneral {

		if (entidad.getClave().length() < 8) {
			throw new ErrorValidacionGeneral("La clave del usuario debe tener más de ocho caracteres");
		}
		try {
			entidad.setClave(UtilEncriptarDataSource.encode(entidad.getClave()));
		} catch (Throwable e) {
			throw new ErrorValidacionGeneral("Eror al encriptar la clave");
		}
		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION
				: entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());
		entidad.setEs_nuevo(ES_NUEVO);
	}

	public List<OmsRole> listaRoles() {
		return servicioRol.listaObjetosActivos(OmsRole.class);
	}

	
	protected void actualizacionPrevia(OmsUsuario entidad) {
		// TODO Auto-generated method stub

	}

	
	protected void persistenciaPrevia(OmsUsuario entidad) {
		// TODO Auto-generated method stub

	}

	
	protected void postActualizacion(OmsUsuario entidad) 
	throws ErrorServicioNegocio, ErrorValidacionGeneral
	{
//		// Quitar las opciones del rol
//		servicioUsuarioRol.eliminarRolesUsuario(entidad.getId());
//		// Asignar las nuevas opciones
//		List<OmsUsuariosRole> listaUsuarioRoles = entidad.getPriUsuariosRoles();
//		if (listaUsuarioRoles != null && listaUsuarioRoles.size() > 0) {
//			for (OmsUsuariosRole usuariosRoleRol : listaUsuarioRoles) {
//				usuariosRoleRol.setAuditoria(entidad.getAuditoria());
//				servicioUsuarioRol.guardarActualizar(usuariosRoleRol);
//			}
//		}
		System.out.println("No voy a actualizar los roles");
		

	}

	
	protected void postPersistencia(OmsUsuario entidad) throws ErrorServicioNegocio, ErrorValidacionGeneral 
	{
		// TODO Auto-generated method stub
		List<OmsUsuariosRole> listaUsuarioRoles = entidad.getPriUsuariosRoles();
		if (listaUsuarioRoles != null && listaUsuarioRoles.size() > 0) {
			for (OmsUsuariosRole usuariosRoleRol : listaUsuarioRoles) {
				usuariosRoleRol.setAuditoria(entidad.getAuditoria());
				servicioUsuarioRol.guardarActualizar(usuariosRoleRol);
			}
		}
	}

	public OmsRole obtenerRolPorID(Long idRol) {
		return servicioRol.buscarRolPorID(idRol);
	}
	
	public List<OmsUsuario> listaUsuarioPorRol(Long pIdRol)
	{
		return crud.listaUsuarioPorRol(pIdRol);
	}

}
