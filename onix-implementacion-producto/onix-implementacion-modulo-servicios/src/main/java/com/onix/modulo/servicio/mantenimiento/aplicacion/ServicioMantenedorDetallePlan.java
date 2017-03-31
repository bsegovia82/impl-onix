package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgDetallePlan;
import com.onix.modulo.eao.aplicacion.OmgDetallePlanEAO;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorDetallePlan 
extends ServicioMantenedorControlAuditoria<OmgDetallePlanEAO, OmgDetallePlan, Long>
{

	@EJB
	private OmgDetallePlanEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		System.out.println("NO EXISTE CONFIGURACION SERVICIO");
		
	}

	@Override
	protected OmgDetallePlanEAO getCrud() {
		return crud;
	}
	
	public List<OmgDetallePlan> obtenerDetallesPlan (Long pIdTipoPlan)
	{
		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("ID_TIPO_PLAN", pIdTipoPlan);
		lParametros.put("ESTADO", "A");
		
		return crud.ejecutarQueryNativo("select * from OMG_DETALLE_PLAN where ESTADO = :ESTADO and ID_TIPO_PLAN = :ID_TIPO_PLAN ", lParametros, OmgDetallePlan.class);
	}

}
