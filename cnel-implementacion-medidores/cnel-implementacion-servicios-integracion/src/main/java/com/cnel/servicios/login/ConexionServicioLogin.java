package com.cnel.servicios.login;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.cnel.servicios.configuracion.ConfiguracionServicios;
import com.cnel.servicios.sesion.GestorObjetosSesion;
import com.onix.api.cliente.login.ApiLogin;
import com.onix.api.cliente.login.ExtensionLogin;
import com.onix.api.configuracion.ConfiguracionLogin;
import com.onix.api.dtosesion.AlmacenSesion;

import bpe.common.servicios.peticiones.Peticion;
import sicore.seguridad.servicios.ifc.seguridad.ConsultarLoginRespuesta;
import sicore.seguridad.servicios.ifc.seguridad.Seguridad;
import sicore.seguridad.servicios.ifc.seguridad.Seguridad_Service;

@ExtensionLogin
@RequestScoped
public class ConexionServicioLogin implements ApiLogin {

	@Inject
	@AlmacenSesion
	private GestorObjetosSesion lGestorSesion;

	public void ejecutarExtensionLogin(Map<String, Object> pParametros) {

		String lUsuario = pParametros.get(ConfiguracionLogin.CAMPO_USUARIO).toString();
		String lClave = pParametros.get(ConfiguracionLogin.CAMPO_CLAVE).toString();
		
		try {
			ConsultarLoginRespuesta lResultado = consumoServicioExternoLogin(lUsuario, lClave);
			lGestorSesion.almacenarObjetoSesion(ConfiguracionServicios.NOMBRE_OBJETO_RESULTANTE, lResultado);
		} catch (Throwable lError) {
			System.err.println("IMPOSIBLE REALIZAR LA EXTENSION DEL LOGIN");
			lError.printStackTrace();
		}
	}

	private ConsultarLoginRespuesta consumoServicioExternoLogin(String pUsuario, String pClaveSinEncriptar) {
		Seguridad_Service servicioSeguridad = new Seguridad_Service();
		Seguridad endPointSeguridad = servicioSeguridad.getBasicHttpBindingSeguridad();
		Peticion lPeticion = new Peticion();
		return endPointSeguridad.consultaLogin(lPeticion, pUsuario, pClaveSinEncriptar);
	}

}
