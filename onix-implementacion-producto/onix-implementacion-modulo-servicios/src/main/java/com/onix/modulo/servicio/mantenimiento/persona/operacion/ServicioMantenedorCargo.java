package com.onix.modulo.servicio.mantenimiento.persona.operacion;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.persona.operacion.OmsoCargo;
import com.onix.modulo.eao.persona.operacion.OmsoCargoEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorCargo extends 
ServicioMantenimientoEntidad<OmsoCargoEAO, OmsoCargo, Long> {

	@EJB
	private OmsoCargoEAO crud;

	protected OmsoCargoEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmsoCargo entidad) throws ErrorServicioNegocio {

		OmsoCargo cargoBase = crud.
				obtenerObjetoPorCampoGenerico(
						"nombreCargo",
				entidad.getNombreCargo(), OmsoCargo.class);
		if (cargoBase != null) {
			if (!cargoBase.getId().equals(entidad.getId())) {
				throw new ErrorServicioNegocio("El nombre del cargo " + cargoBase.getNombreCargo()
						+ ", ya se encuentra registrado");
			}
		}
	}

	@Override
	protected void validacionesBasicasActualizar(OmsoCargo entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION
				: entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());
	}

	@Override
	protected void validacionesConBaseGuardar(OmsoCargo entidad) throws ErrorServicioNegocio {
		OmsoCargo cargoBase = crud.
				obtenerObjetoPorCampoGenerico(
						"nombreCargo",
				entidad.getNombreCargo(), OmsoCargo.class);
		if (cargoBase != null) {
			throw new ErrorServicioNegocio("El nombre del cargo " + cargoBase.getNombreCargo()
					+ ", ya se encuentra registrado");
		}
	}

	@Override
	protected void validacionesBasicasGuardar(OmsoCargo entidad) throws ErrorValidacionGeneral {

		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION
				: entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null ? REFERENCIA : entidad.getAuditoria());
	}


	protected void actualizacionPrevia(OmsoCargo entidad) {
		// TODO Auto-generated method stub
		System.out.println("actualizacionPrevia Sin nada que hacer");
	}

	
	protected void persistenciaPrevia(OmsoCargo entidad) {
		System.out.println("persistenciaPrevia Sin nada que hacer");
	}


	protected void postActualizacion(OmsoCargo entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void postPersistencia(OmsoCargo entidad) {
		// TODO Auto-generated method stub
		
	}

}
