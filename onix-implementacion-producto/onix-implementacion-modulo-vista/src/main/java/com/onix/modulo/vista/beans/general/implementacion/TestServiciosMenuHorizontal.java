package com.onix.modulo.vista.beans.general.implementacion;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.librerias.vista.anotaciones.ITestServicioMenuOpcionesHorizontal;
import com.onix.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IGuardiaUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IServiciosMenu;
import com.onix.modulo.librerias.vista.interfaces.IUsuarioSession;
import com.onix.modulo.servicio.seguridad.ServicioAplicacion;


@ITestServicioMenuOpcionesHorizontal
@RequestScoped
public class TestServiciosMenuHorizontal implements IServiciosMenu<OmsOpcione>
{

	@Inject
	@ITestUsuarioSession
	private IUsuarioSession<OmsUsuario> parametroObtenerOpciones;
	
	@EJB
	private ServicioAplicacion servicioAplicacion;
	
	public List<OmsOpcione> getMenuOpciones() 
	{
		return servicioAplicacion.obtenerMenu(parametroObtenerOpciones.getUsuarioSession(), IGuardiaUsuarioSession.TIPO_MENU);
	}

	
}
