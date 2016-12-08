package com.onix.modulo.vista.beans.general.implementacion;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.librerias.generales.UtilEncriptarDataSource;
import com.onix.modulo.librerias.vista.anotaciones.ITestGuardiaSession;
import com.onix.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IGuardiaUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IUsuarioSession;


@ITestGuardiaSession
@RequestScoped
public class TestGuardiaUsuarioSession implements IGuardiaUsuarioSession 
{
	@Inject
	@ITestUsuarioSession
	private IUsuarioSession<OmsUsuario> usuarioSession;
	
	public boolean usuarioEnSession() 
	{
		if (usuarioSession == null || usuarioSession.getUsuarioSession()==null)
		{
			return false;
		}
		return true;
		
	}
	
	public boolean validarSemilla(String semilla) {
		try {
				String semillaReal =   UtilEncriptarDataSource.encode(usuarioSession.getUsuarioSession().getClave().toUpperCase()+usuarioSession.getUsuarioSession().getUsuario().toUpperCase());
				return semillaReal.equals(semilla);
		} catch (Exception e) {

			return false;
		}
	}
	

	
}
