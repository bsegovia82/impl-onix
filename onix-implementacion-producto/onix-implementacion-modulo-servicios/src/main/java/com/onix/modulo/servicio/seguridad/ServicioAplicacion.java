package com.onix.modulo.servicio.seguridad;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.eao.aplicacion.OmsOpcioneEAO;
import com.onix.modulo.eao.aplicacion.OmsOpcionesRoleEAO;
import com.onix.modulo.eao.aplicacion.OmsUsuarioEAO;




@Stateless
public class ServicioAplicacion
{

	@EJB
	private OmsOpcionesRoleEAO opcionesRolesEAO;
	
	@EJB
	private OmsOpcioneEAO opcionesEAO;
	

	
	
	
	@EJB
	private OmsUsuarioEAO usuarioEAO;
	
	
	
	public List<OmsOpcione> obtenerMenu(OmsUsuario usuario, String orientacion) 
	{
		return opcionesRolesEAO.obtenerListaOpcionesRol(usuario.getId(), orientacion);
	}
	
	
	public boolean verificarPermisoOpcion(OmsOpcione opcion, OmsUsuario usuario)
	{
		return opcionesEAO.permitirAccesoOpcion(opcion, usuario);
	}
	
	
}