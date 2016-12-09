package com.onix.modulo.vista.beans.general.implementacion;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.librerias.generales.UtilEncriptarDataSource;
import com.onix.modulo.librerias.vista.anotaciones.ITestAutenticacion;
import com.onix.modulo.librerias.vista.interfaces.IServiciosAutenticacion;
import com.onix.modulo.servicio.seguridad.ServicioAutenticacion;
import com.onix.modulo.vista.beans.general.autenticacion.BeanLogin;



@ITestAutenticacion
@RequestScoped
public class TestAutenticar implements IServiciosAutenticacion<OmsUsuario, BeanLogin>
{
	@EJB
	private ServicioAutenticacion autenticar;
	
	public OmsUsuario autenticar(BeanLogin datosAutenticar) throws Exception
	{
		OmsUsuario usuari = null;
		try{
			
			
			usuari = autenticar.autenticar(datosAutenticar.getUsuario().toUpperCase(),  UtilEncriptarDataSource.encode(datosAutenticar.getClave()));
		
		
		}catch(Exception e){
			throw new Exception("No existe");
		}
		
		return usuari;
		
	}
	
	public boolean autenticarDominio(BeanLogin datosAutenticar){
		
		return true;
	}
}
