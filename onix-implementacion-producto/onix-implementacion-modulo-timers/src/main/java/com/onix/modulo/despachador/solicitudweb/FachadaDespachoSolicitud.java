package com.onix.modulo.despachador.solicitudweb;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.onix.modulo.dominio.aplicacion.OmgDetallePlan;
import com.onix.modulo.dominio.aplicacion.OmgSolicitudUsoAplicacion;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorDetallePlan;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorSolicitud;

@Stateless
public class FachadaDespachoSolicitud {

	
	
	
	@EJB
	private ServicioMantenedorSolicitud lServicioSolicitud;

	@EJB
	private ServicioDespachoSolicitud lServicioAsignacionAsociado;
	
	@EJB
	private ServicioMantenedorDetallePlan lServicioDetallePlan;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void despacharSolitudesWeb() {
		for (OmgSolicitudUsoAplicacion lSolicitud : lServicioSolicitud.obtenerSolicitudesPendientes())
			try {
				HashMap<String, String> lParametrosCreacionSolicitud = obtenerCaracteristicasPlan(lSolicitud);
				lServicioAsignacionAsociado.procesarSolicitud(lSolicitud, lParametrosCreacionSolicitud);
			} catch (Throwable lError) {
				lError.printStackTrace();
			}

	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public HashMap<String, String> obtenerCaracteristicasPlan(OmgSolicitudUsoAplicacion lSolicitud)
	{
		HashMap<String, String> lCaracteristicasPlan = new HashMap<>();
		
		List<OmgDetallePlan> lListaDetalles = lServicioDetallePlan.obtenerDetallesPlan(lSolicitud.getIdTipoPlan());
		
		for (OmgDetallePlan lDetallePlan : lListaDetalles)
		{
			lCaracteristicasPlan.put(lDetallePlan.getlCaracteristica(), lDetallePlan.getlValor());
		}
		
		return lCaracteristicasPlan;
 	}
	
}
