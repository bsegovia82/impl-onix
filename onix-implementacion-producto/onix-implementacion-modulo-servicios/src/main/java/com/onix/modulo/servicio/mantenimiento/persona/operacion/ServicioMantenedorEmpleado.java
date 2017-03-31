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
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.oyentes.AccionTransaccionalListener;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.librerias.servicio.oyentes.PreLlenadoRegistroListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuarioRol;

@Stateless
public class ServicioMantenedorEmpleado
		extends ServicioMantenedorControlAuditoria<OmsoEmpleadoEAO, OmsoEmpleado, Long> {

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

	public static String generadorCodigoEmpleado() {
		return SEMILLA_CODIGO_EMPLEADO + new Date().getTime();
	}

	public List<OmsoCargo> obtenerListaCargos() {
		return servicioCargo.listaObjetosActivos(OmsoCargo.class);
	}

	public List<OmsoEspecialidad> obtenerListaEspecialidad() {
		return servicioEspecialidad.listaObjetosActivos(OmsoEspecialidad.class);
	}

	public OmsoEmpleado cargarEmpleadoPorIdentificacion(String numeroIdentificacion) {
		OmsgPersona personaBase = buscarPersonaIdentificacion(numeroIdentificacion);
		OmsoEmpleado empleadoNew = new OmsoEmpleado();
		empleadoNew.setPersona(personaBase);
		return empleadoNew;
	}

	public OmsoEmpleado buscarEmpleadoPorIdentificacion(String numeroIdentificacion) {
		return getCrud().buscarEmpleadoPorIdPersona(buscarPersonaIdentificacion(numeroIdentificacion).getId());
	}

	public OmsgPersona buscarPersonaIdentificacion(String numeroIdentificacion) {
		return personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO, numeroIdentificacion,
				OmsgPersona.class);
	}

	@Override
	protected void cargarConfiguracionServicio() {

		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmsoEmpleado, Long>() {

			@Override
			public void validacionTransaccional(OmsoEmpleado entidad) throws ErrorServicioNegocio {
				OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico(OmsgPersona.NUMERODOCUMENTO,
						entidad.getPersona().getNumeroDocumento(), OmsgPersona.class);
				if (personaBase != null && !personaBase.getId().equals(entidad.getId())) {
					throw new ErrorServicioNegocio(
							"La identificación " + personaBase.getNumeroDocumento() + ", ya se encuentra registrado");
				}

			}
		});

		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmsoEmpleado, Long>() {

			@Override
			public void validacionTransaccional(OmsoEmpleado entidad) throws ErrorServicioNegocio {
				OmsgPersona personaBase = personaEAO.obtenerObjetoPorCampoGenerico("numeroDocumento",
						entidad.getPersona().getNumeroDocumento(), OmsgPersona.class);
				if (personaBase != null) {
					throw new ErrorServicioNegocio(
							"La identificación " + personaBase.getNumeroDocumento() + ", ya se encuentra registrado");
				}

			}
		});

		addDatosRegistroInsertListener(new PreLlenadoRegistroListener<OmsoEmpleado, Long>() {

			@Override
			public void preCargaDatosRegistro(OmsoEmpleado entidad) {
				entidad.setCodigoEmpleado(generadorCodigoEmpleado());

			}
		});

		addPreInsertListener(new AccionTransaccionalListener<OmsoEmpleado, Long>() {

			@Override
			public void controlTransaccional(OmsoEmpleado entidad) throws ErrorServicioNegocio, ErrorValidacionGeneral {
				OmsUsuario usuario = entidad.getPersona().getUsuario();
				usuario.setClave(OmsUsuario.CLAVE_INICIAL_DEFAULT);
				usuario.setAuditoria(entidad.getAuditoria());
				usuario.setObservacion(entidad.getPersona().getNombres() + " " + entidad.getPersona().getApellidos());
				usuario.setCorreo(entidad.getPersona().getDireccionCorreo());
				OmsoCargo cargoBase = servicioCargo.obtenerObjtoPK(entidad.getCargo().getId(), OmsoCargo.class);
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
					throw e;
				} catch (ErrorValidacionGeneral e) {
					throw e;
				}

			}
		});

	}

}
