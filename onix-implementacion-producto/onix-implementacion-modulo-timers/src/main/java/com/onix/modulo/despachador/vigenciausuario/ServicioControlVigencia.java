package com.onix.modulo.despachador.vigenciausuario;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;

@Stateless
public class ServicioControlVigencia {

	@EJB
	private ServicioMantenedorUsuario lServicioUsuario;
	
	private String lMensajeInactivacion = "Se realiza la inactivación automática del usuario, la vegencia del usuario expiró";
	
	public void verificacionVigenciaUsuario(OmsUsuario lUsuario) throws ErrorServicioNegocio, ErrorValidacionGeneral
	{
		
		if (!lUsuario.getlFechaVencimiento().after(new Date()))
			return;
		lUsuario.setFechaActualizacion(new Date());
		lUsuario.setEstado("I");
		lUsuario.setObservacion(lMensajeInactivacion);
		lServicioUsuario.guardarActualizar(lUsuario);
		
	}
}
