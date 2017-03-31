package com.cnel.servicios.sesion;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.SessionScoped;

import com.onix.api.dtosesion.AlmacenObjetoSesion;
import com.onix.api.dtosesion.AlmacenSesion;
import java.io.Serializable;

@AlmacenSesion
@SessionScoped
public class GestorObjetosSesion implements Serializable, AlmacenObjetoSesion
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> lObjetosSesion;
	

	
	
	public void almacenarObjetoSesion(String lNombre, Object lObjetoSesion) {
		if(lObjetosSesion==null)
			lObjetosSesion = new HashMap<String, Object>();
		lObjetosSesion.put(lNombre, lObjetoSesion);
		
	}

	public Object obtenerObjetoSesion(String lNombre) {
		return lObjetosSesion.get(lNombre);
	}

}
