package com.onix.modulo.servicio.mantenimiento.persona.operacion;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.persona.operacion.OmsoEspecialidad;
import com.onix.modulo.eao.persona.operacion.OmsoEspecialidadEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorEspecialidad extends ServicioMantenimientoEntidad<OmsoEspecialidadEAO, OmsoEspecialidad, Long> {

	
	@EJB
	private OmsoEspecialidadEAO crud;

	
	protected OmsoEspecialidadEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmsoEspecialidad entidad) throws ErrorServicioNegocio {

		OmsoEspecialidad especilidad = crud.obtenerObjetoPorCampoGenerico(
				"nombreEspecialidad",
				entidad.getNombreEspecialidad(), 
				OmsoEspecialidad.class);
		if (especilidad != null) {
			if (!especilidad.getId().equals(entidad.getId())) {
				throw new ErrorServicioNegocio("La especialidad " 
			+ especilidad.getNombreEspecialidad()
						+ ", ya se encuentra registrado");
			}
		}
	}

	@Override
	protected void validacionesBasicasActualizar(OmsoEspecialidad entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION
				: entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());
	}

	@Override
	protected void validacionesConBaseGuardar(OmsoEspecialidad entidad) throws ErrorServicioNegocio {
		OmsoEspecialidad especilidad = crud.obtenerObjetoPorCampoGenerico(
				"nombreEspecialidad",
				entidad.getNombreEspecialidad(), 
				OmsoEspecialidad.class);
		if (especilidad != null) {
			throw new ErrorServicioNegocio("La especialidad " + especilidad.getNombreEspecialidad()
					+ ", ya se encuentra registrado");
		}
	}

	@Override
	protected void validacionesBasicasGuardar(OmsoEspecialidad entidad) throws ErrorValidacionGeneral {

		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION
				: entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null ? REFERENCIA : entidad.getAuditoria());
	}


	protected void actualizacionPrevia(OmsoEspecialidad entidad) {
		// TODO Auto-generated method stub
		System.out.println("Sin nada que actualizar previamente");
	}


	protected void persistenciaPrevia(OmsoEspecialidad entidad) {
		System.out.println("Sin nada que persistir previamente");
	}

	protected void postActualizacion(OmsoEspecialidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void postPersistencia(OmsoEspecialidad entidad) {
		// TODO Auto-generated method stub
		
	}
	

}
