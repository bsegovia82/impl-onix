package com.onix.modulo.servicio.mantenimiento.persona.operacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.persona.operacion.OmsoCargo;
import com.onix.modulo.eao.persona.operacion.OmsoCargoEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorCargo extends 
ServicioMantenedorControlAuditoria<OmsoCargoEAO, OmsoCargo, Long> {

	@EJB
	private OmsoCargoEAO crud;

	protected OmsoCargoEAO getCrud() {
		return crud;
	}

	@Override
	protected void cargarConfiguracionServicio() {
		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmsoCargo, Long>() {
		
		@Override
		public void validacionTransaccional(OmsoCargo entidad) throws ErrorServicioNegocio {
			OmsoCargo cargoBase = crud.
					obtenerObjetoPorCampoGenerico(
							"nombreCargo",
					entidad.getNombreCargo(), OmsoCargo.class);
			if (cargoBase != null && !cargoBase.getId().equals(entidad.getId()))
				throw new ErrorServicioNegocio(
						"El nombre del cargo " + cargoBase.getNombreCargo() + ", ya se encuentra registrado");
			
		}
		
		});
		
		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmsoCargo, Long>() {
			
			@Override
			public void validacionTransaccional(OmsoCargo entidad) throws ErrorServicioNegocio {
				OmsoCargo cargoBase = crud.
						obtenerObjetoPorCampoGenerico(
								"nombreCargo",
						entidad.getNombreCargo(), OmsoCargo.class);
				if (cargoBase != null)
					throw new ErrorServicioNegocio(
							"El nombre del cargo " + cargoBase.getNombreCargo() + ", ya se encuentra registrado");
				
			}
		});
		
	}

	


	

}
