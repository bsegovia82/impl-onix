package com.onix.modulo.vista.servlet.servicio;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface ServicioServletConsulta {

	public void delegacionServletConsulta(HttpServletRequest request, HttpServletResponse response, 
			Connection lConexionBaseDatos);
	
}
