package com.onix.modulo.vista.beans.general.implementacion;



import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.librerias.vista.anotaciones.ITestServicioAutorizacion;
import com.onix.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IServicioAutorizacion;
import com.onix.modulo.librerias.vista.interfaces.IUsuarioSession;
import com.onix.modulo.servicio.seguridad.ServiciosMantenimientoSeguridad;



@ITestServicioAutorizacion
@RequestScoped
public class ServicioAutorizacion implements IServicioAutorizacion
{

	@EJB
	private ServiciosMantenimientoSeguridad serviciosMantenimientoSeguridad;
	
	@Inject
	@ITestUsuarioSession
	private IUsuarioSession<OmsUsuario> usuarioSession;
	
	@Override
	public boolean validarOpcionUsuario(String url, String usuario, String contextPath) {
		// TODO Auto-generated method stub
		System.out.println("Se debe controlar los usuarios");
		
		List<OmsOpcione> listaOpciones = serviciosMantenimientoSeguridad.obtenerOpcionesPorUsuario(usuario);
		for (OmsOpcione cfOpciones : listaOpciones) {
			if ((contextPath + cfOpciones.getAccion()).equals(url)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String obtenerUsuarioAutenticado() {
		// TODO Auto-generated method stub
		return usuarioSession.getUsuarioSession().getUsuario();
	}
	
}
