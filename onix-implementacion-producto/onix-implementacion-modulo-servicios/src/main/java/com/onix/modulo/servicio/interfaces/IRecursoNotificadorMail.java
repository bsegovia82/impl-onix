package com.onix.modulo.servicio.interfaces;

import javax.ejb.Local;
import javax.mail.Session;


@Local
public interface IRecursoNotificadorMail 
{
	public Session obtenerSessionMail();
}
