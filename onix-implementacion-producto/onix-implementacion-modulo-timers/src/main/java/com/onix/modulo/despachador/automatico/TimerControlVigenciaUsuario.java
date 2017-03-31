package com.onix.modulo.despachador.automatico;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.onix.modulo.despachador.vigenciausuario.FachadaControlVigenciaUsuario;
import com.onix.modulo.librerias.timer.DatosEjecucionTimer;
import com.onix.modulo.librerias.timer.TimerEjecutorIntervaloTiempo;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorParametro;

@Singleton
@Startup
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class TimerControlVigenciaUsuario extends TimerEjecutorIntervaloTiempo {

	private String lTiempoMinutosEjecucion = "LONG_MINUTOS_EJECUCION_CONTROL_VIGENCIA";
	
	private String lTimerActivo = "STRING_TIMER_ACTIVO_VIGENCIA_USUARIO";
	
	@EJB
	private ServicioMantenedorParametro lServicioParametro;
	
	@EJB
	private FachadaControlVigenciaUsuario lFachadaControlVigencia;
	
	@Override
	protected void ejecutarAccionRecurrente() throws Throwable 
	{
		String lEjecutarTimer = lServicioParametro.obtenerValorParametro(lTimerActivo);
		lEjecutarTimer = lEjecutarTimer == null ? "N" : lEjecutarTimer;
		if (lEjecutarTimer.equals("S"))
		{
		lFachadaControlVigencia.inactivacionUsuariosVigencia();
		}else
		{
			System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("TIMER : TimerControlVigenciaUsuario, desactivado");
			System.out.println("------------------------------------------------------------------------------------------");
		}
	}

	@Override
	protected DatosEjecucionTimer inicializacionTimer() {
		String lMinutosEjecucion = lServicioParametro.obtenerValorParametro(lTiempoMinutosEjecucion);
		return new DatosEjecucionTimer(lMinutosEjecucion == null ? 5L : Long.valueOf(lMinutosEjecucion),
				"CONTROLADOR_VIGENCIA_USUARIO", false);
	}

}