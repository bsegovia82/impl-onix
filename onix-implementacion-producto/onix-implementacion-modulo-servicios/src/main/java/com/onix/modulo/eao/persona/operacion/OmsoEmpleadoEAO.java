package com.onix.modulo.eao.persona.operacion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.onix.modulo.dominio.persona.operacion.OmsoEmpleado;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsoEmpleadoEAO extends OnixEAO<OmsoEmpleado, Long> 
{

	public OmsoEmpleado buscarEmpleadoPorIdPersona (Long idPersona)
	{
		String query = "select modelo from OmsoEmpleado modelo "
				+ "where modelo.persona.id = :idPersona";
		
		Query qry =  getAdminEntidad().createQuery(query);
		
		qry.setParameter("idPersona", idPersona);
		
		List<OmsoEmpleado> listaEmpleados = qry.getResultList();
		
		if(!listaEmpleados.isEmpty())
		{
			return listaEmpleados.get(0);
		}else
		{
			return null;
		}
		
	}
	
}
