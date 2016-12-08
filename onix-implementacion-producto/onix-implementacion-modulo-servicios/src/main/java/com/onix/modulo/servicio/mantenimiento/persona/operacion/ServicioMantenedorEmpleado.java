package com.onix.modulo.servicio.mantenimiento.persona.operacion;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.dominio.aplicacion.OmsUsuariosRole;
import com.onix.modulo.dominio.persona.OmsgPersona;
import com.onix.modulo.dominio.persona.operacion.OmsoCargo;
import com.onix.modulo.dominio.persona.operacion.OmsoEmpleado;
import com.onix.modulo.dominio.persona.operacion.OmsoEspecialidad;
import com.onix.modulo.eao.persona.OmsgPersonaEAO;
import com.onix.modulo.eao.persona.operacion.OmsoEmpleadoEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuarioRol;

@Stateless
public class ServicioMantenedorEmpleado extends ServicioMantenimientoEntidad<OmsoEmpleadoEAO, OmsoEmpleado, Long> {

	private static final String SEMILLA_CODIGO_EMPLEADO = "EMP-";

	@EJB
	private OmsoEmpleadoEAO crud;

	@EJB
	private OmsgPersonaEAO personaEAO;

	@EJB
	private ServicioMantenedorUsuarioRol servicioUsuarioRol;

	@EJB
	private ServicioMantenedorCargo servicioCargo;

	@EJB
	private ServicioMantenedorUsuario servicioMantenedorUsuario;

	@EJB
	private ServicioMantenedorEspecialidad servicioEspecialidad;

	protected OmsoEmpleadoEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmsoEmpleado entidad) throws ErrorServicioNegocio {

		OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO,
				entidad.getPersona().getNumeroDocumento(), OmsgPersona.class);
		if (personaBase != null) {
			if (!personaBase.getId().equals(entidad.getId())) {
				throw new ErrorServicioNegocio(
						"La identificación " + personaBase.getNumeroDocumento() + ", ya se encuentra registrado");
			}
		}
	}

	@Override
	protected void validacionesBasicasActualizar(OmsoEmpleado entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2
				? OBSERVACION_APLICACION : entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());
	}

	@Override
	protected void validacionesConBaseGuardar(OmsoEmpleado entidad) throws ErrorServicioNegocio {
		OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico("numeroDocumento",
				entidad.getPersona().getNumeroDocumento(), OmsgPersona.class);
		if (personaBase != null) {
			throw new ErrorServicioNegocio(
					"La identificación " + personaBase.getNumeroDocumento() + ", ya se encuentra registrado");
		}
	}

	@Override
	protected void validacionesBasicasGuardar(OmsoEmpleado entidad) throws ErrorValidacionGeneral {

		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2
				? OBSERVACION_APLICACION : entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null ? REFERENCIA : entidad.getAuditoria());
	}

	
	protected void actualizacionPrevia(OmsoEmpleado entidad) {
		// TODO Auto-generated method stub
		System.out.println("Sin nada que hacer");
	}


	protected void persistenciaPrevia(OmsoEmpleado entidad) {
		// entidad.setCodigoEmpleado(generadorCodigoEmpleado());
		OmsUsuario usuario = entidad.getPersona().getUsuario();
		usuario.setClave(OmsUsuario.CLAVE_INICIAL_DEFAULT);
		usuario.setAuditoria(entidad.getAuditoria());
		usuario.setObservacion(entidad.getPersona().getNombres() + " " + entidad.getPersona().getApellidos());
		usuario.setCorreo(entidad.getPersona().getDireccionCorreo());
		OmsoCargo cargoBase = 
				servicioCargo.obtenerObjtoPK(entidad.getCargo().getId(), OmsoCargo.class);
		OmsUsuariosRole usuarioRol = new OmsUsuariosRole();
		usuarioRol.setPriRole(cargoBase.getRolDefault());
		usuarioRol.setEstado("A");
		usuarioRol.setAuditoria(entidad.getAuditoria());
		usuarioRol.setObservacion("POR CREACIÓN DE EMPLEADO");
		try {
			servicioMantenedorUsuario.guardarActualizar(usuario);
			entidad.getPersona().setUsuario(usuario);
			personaEAO.insertar(entidad.getPersona());
			usuarioRol.setPriUsuario(usuario);
			servicioUsuarioRol.guardarActualizar(usuarioRol);
		} catch (ErrorServicioNegocio e) {
			e.printStackTrace();
		} catch (ErrorValidacionGeneral e) {
			e.printStackTrace();
		}

	}

	public static String generadorCodigoEmpleado() {
		return SEMILLA_CODIGO_EMPLEADO + new Date().getTime();
	}

	public List<OmsoCargo> obtenerListaCargos() {
		return servicioCargo.listaObjetosActivos(OmsoCargo.class);
	}

	public List<OmsoEspecialidad> obtenerListaEspecialidad() {
		return servicioEspecialidad.listaObjetosActivos(OmsoEspecialidad.class);
	}

	@Override
	protected void postActualizacion(OmsoEmpleado entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void postPersistencia(OmsoEmpleado entidad) {
		// TODO Auto-generated method stub

	}

	public OmsoEmpleado cargarEmpleadoPorIdentificacion(String numeroIdentificacion) {
		OmsgPersona personaBase = buscarPersonaIdentificacion(numeroIdentificacion);
		OmsoEmpleado empleadoNew = new OmsoEmpleado();
		empleadoNew.setPersona(personaBase);
		return empleadoNew;
	}

	public OmsoEmpleado buscarEmpleadoPorIdentificacion(String numeroIdentificacion) {
		OmsgPersona personaBase = buscarPersonaIdentificacion(numeroIdentificacion);
		return getCrud().buscarEmpleadoPorIdPersona(personaBase.getId());
	}

	public OmsgPersona buscarPersonaIdentificacion(String numeroIdentificacion) {
		OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO,
				numeroIdentificacion, OmsgPersona.class);
		return personaBase;
	}

}
