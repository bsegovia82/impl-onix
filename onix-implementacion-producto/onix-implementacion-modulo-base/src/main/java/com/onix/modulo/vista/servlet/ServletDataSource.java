package com.onix.modulo.vista.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/servicio_consultas.do")
public class ServletDataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup = "java:/ONIX-ORCL")
	private DataSource lConexion;
	
    public ServletDataSource() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
