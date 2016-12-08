package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsOpcionesRole;
import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.eao.aplicacion.OmsRoleEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorRol extends ServicioMantenimientoEntidad<OmsRoleEAO, OmsRole, Long> {

	@EJB
	private OmsRoleEAO crud;

	@EJB
	private ServicioMantenedorOpcion servicioOpcion;

	@EJB
	private ServicioMantenedorOpcionRol servicioOpcionRol;

	protected OmsRoleEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmsRole entidad) throws ErrorServicioNegocio {
		OmsRole rol = crud.obtenerObjetoPorCampoGenerico("rol", entidad.getRol(), OmsRole.class);
		if (rol != null) {
			if (!entidad.getId().equals(rol.getId())) {
				throw new ErrorServicioNegocio("El rol " + entidad.getRol() + ", ya se encuentra registrado");
			}
		}
	}

	@Override
	protected void validacionesBasicasActualizar(OmsRole entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(
				entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION : entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria().length() < 2 ? REFERENCIA : entidad.getAuditoria());
	}

	@Override
	protected void validacionesConBaseGuardar(OmsRole entidad) throws ErrorServicioNegocio {
		OmsRole rol = crud.obtenerObjetoPorCampoGenerico("rol", entidad.getRol(), OmsRole.class);
		if (rol != null) {
			throw new ErrorServicioNegocio("El rol " + entidad.getRol() + ", ya se encuentra registrado");
		}
	}

	@Override
	protected void validacionesBasicasGuardar(OmsRole entidad) throws ErrorValidacionGeneral {

		if (entidad.getRol().length() < 3) {
			throw new ErrorValidacionGeneral("La rol debe tener más de tres caracteres");
		}

		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2
				? OBSERVACION_APLICACION : entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());

	}

	
	protected void actualizacionPrevia(OmsRole entidad) {
		System.out.println("Sin nada que hacer actualizacionPrevia");
	}

	
	protected void persistenciaPrevia(OmsRole entidad) {
		System.out.println("Sin nada que hacer persistenciaPrevia");

	}

	public List<OmsOpcione> listaOpcionesEjecutables() {
		return servicioOpcion.listaOpcionesEjecutables();
	}

	@Override
	protected void postActualizacion(OmsRole entidad) throws ErrorServicioNegocio, ErrorValidacionGeneral {
		// // Quitar las opciones del rol
		// servicioOpcionRol.eliminarOpcionesRole(entidad.getId());
		// // Asignar las nuevas opciones
		// List<OmsOpcionesRole> listaOpcionesRoles =
		// entidad.getListaOpcionesRoles();
		//
		// for (OmsOpcionesRole opcionRol : listaOpcionesRoles) {
		// opcionRol.setAuditoria(entidad.getAuditoria());
		// servicioOpcionRol.guardarActualizar(opcionRol);
		// }
		System.out.println("No voy a actualizar los roles");

	}

	private OmsOpcionesRole registrarPadres(OmsRole rol, OmsOpcione opcionRol)
			throws ErrorServicioNegocio, ErrorValidacionGeneral {
		OmsOpcionesRole opcionRolPdre = new OmsOpcionesRole();
		if (opcionRol != null) {
			opcionRolPdre.setAuditoria(rol.getAuditoria());
			opcionRolPdre.setObservacion("DESCRIPCION ASIGNACION: " +rol.getRol() + " - " + opcionRol.getDescripcion());
			opcionRolPdre.setEstado("A");
			opcionRolPdre.setFechaRegistro(new Date());
			opcionRolPdre.setIdRol(rol);
			opcionRolPdre.setPriOpcione(opcionRol);
			if (!existeRolOpcion(opcionRolPdre)) {
				servicioOpcionRol.guardarActualizar(opcionRolPdre);
			}
			return registrarPadres(rol, opcionRol.getModuloPadre());
		} else {

			return null;
		}
	}

	private boolean existeRolOpcion(OmsOpcionesRole opcionRolPdre) {
		return getCrud().verificarSiExisteRolOpcion(opcionRolPdre.getIdRol().getId(),
				opcionRolPdre.getPriOpcione().getId());
	}

	protected void postPersistencia(OmsRole entidad) throws ErrorServicioNegocio, ErrorValidacionGeneral {
		List<OmsOpcionesRole> listaOpcionesRoles = entidad.getListaOpcionesRoles();
		if (listaOpcionesRoles != null && listaOpcionesRoles.size() > 0) {
			for (OmsOpcionesRole opcionRol : listaOpcionesRoles) {
				opcionRol.setAuditoria(entidad.getAuditoria());
				servicioOpcionRol.guardarActualizar(opcionRol);
				registrarPadres(entidad, 
						opcionRol.getPriOpcione().getModuloPadre());
			}
		}
	}

	public OmsOpcione obtenerOpcionPorID(Long idOpcion) {
		return servicioOpcion.obtenerObjtoPK(idOpcion, OmsOpcione.class);
	}

	public List<OmsOpcione> listaOpcionesEjecutables(OmsRole entidad, String tipo) {
		return servicioOpcionRol.listaOpcionesEjecutablesRol(entidad.getId(), tipo);
	}

	public OmsRole buscarRolPorID(Long idRol) {
		return crud.obtenerObjetoPorPk(idRol, OmsRole.class);
	}

}
