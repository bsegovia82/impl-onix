package com.onix.modulo.servicio.mantenimiento.aplicacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgTipoPlan;
import com.onix.modulo.eao.aplicacion.OmgTipoPlanEAO;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorTipoPlan 
extends ServicioMantenedorControlAuditoria<OmgTipoPlanEAO, OmgTipoPlan, Long>
{

	@EJB
	private OmgTipoPlanEAO crud;
	
	@Override
	protected void cargarConfiguracionServicio() {
		System.out.println("NO EXISTE CONFIGURACION SERVICIO");
		
	}

	@Override
	protected OmgTipoPlanEAO getCrud() {
		return crud;
	}

}
