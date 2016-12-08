package com.onix.modulo.servicio.seguridad;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.eao.aplicacion.OmsUsuarioEAO;






@Stateless
public class ServicioAutenticacion
{
	@EJB
	private OmsUsuarioEAO pbUsuario;



	
	
	public OmsUsuario autenticar(String pUsuario, String pClave) {
		
		
		OmsUsuario usuario = pbUsuario.buscarUsuario(pUsuario);
		
		if(usuario==null){
			System.err.println("El usuario no existe");
			return null;
		}
		
		if (usuario.getUsuario()==null || usuario.getUsuario()=="")
		{
			System.err.println("El usuario no existe");
			return null;
		}
		
		if (!usuario.getClave().equals(pClave))
		{
			System.err.println("La clave no es la correcta");
			return null;
		}
		return usuario;
	}

}
