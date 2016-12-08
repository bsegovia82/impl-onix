package com.onix.modulo.vista.beans.general.implementacion;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IUsuarioSession;



@ITestUsuarioSession
@SessionScoped
public class TestUsuarioSession implements IUsuarioSession<OmsUsuario>, Serializable
{
	private static final long serialVersionUID = 1L;
	private OmsUsuario usuario;

	
	public void setUsuarioSession(OmsUsuario usuario) {
		this.usuario = usuario;
	}
	
	public OmsUsuario getUsuarioSession() {
		
		return this.usuario;
	}

}
