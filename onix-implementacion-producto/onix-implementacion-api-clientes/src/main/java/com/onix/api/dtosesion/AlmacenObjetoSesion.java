package com.onix.api.dtosesion;

public interface AlmacenObjetoSesion 
{

	public void almacenarObjetoSesion(String lNombre, Object lObjetoSesion);
	
	public Object obtenerObjetoSesion(String lNombre);
}
