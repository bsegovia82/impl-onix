package com.onix.modulo.servicio.notificacion;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Session;

import com.onix.modulo.librerias.notificacion.NotificadorMail;

@Stateless
public class ServicioNotificacionMail extends NotificadorMail
{

	@Resource(lookup = "java:jboss/mail/gmail")
	private Session lSession;

	@Override
	protected Session getSession() {
		return lSession;
	}
	
	public void enviarEmail(String pDireccionesDestino, String pAsunto, String pMensaje) throws Throwable
	{
		super.enviarEmailTextoSimple(pDireccionesDestino, pAsunto, pMensaje);
	}
	
	public void enviarEmail(List<String> pDireccionesDestino, String pAsunto, String pMensaje) throws Throwable
	{
		super.enviarEmailTextoMultiple(pDireccionesDestino, pAsunto, pMensaje);
	}

}
