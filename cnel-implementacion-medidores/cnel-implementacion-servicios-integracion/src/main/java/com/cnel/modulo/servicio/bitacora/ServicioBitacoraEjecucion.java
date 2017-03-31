package com.cnel.modulo.servicio.bitacora;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.cnel.modulo.dominio.bitacora.CnelBitacora;
import com.cnel.modulo.eao.bitacora.CnelBitacoraEAO;
import com.cnel.modulo.servicio.ServicioMantenedorCnel;

@Stateless
public class ServicioBitacoraEjecucion 
extends ServicioMantenedorCnel<CnelBitacoraEAO, CnelBitacora, Long>
{
	@EJB
	private CnelBitacoraEAO crud;
	
	@Override
	protected CnelBitacoraEAO getCrud() {
		return crud;
	}

	@Override
	protected void cargarConfiguracionServicio() 
	{
		
	}

}
