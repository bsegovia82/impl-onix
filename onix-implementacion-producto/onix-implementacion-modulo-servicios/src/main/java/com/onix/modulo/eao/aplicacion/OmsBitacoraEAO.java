package com.onix.modulo.eao.aplicacion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.onix.modulo.dominio.aplicacion.OmsBitacora;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsBitacoraEAO extends OnixEAO<OmsBitacora, Long> {
	
	@SuppressWarnings("unchecked")
	public List<OmsBitacora> obtenerListaBitacoras()
	{
		String strQuery = "select * from oms_bitacora g where g.fecha_registro > sysdate - 3 order by g.fecha_registro desc ";
		Query query = adminEntidad.createNativeQuery(strQuery, OmsBitacora.class);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<OmsBitacora> obtenerListaBitacorasHoy()
	{
		String strQuery = "select * from oms_bitacora g where g.fecha_registro > sysdate - 1 order by g.fecha_registro desc ";
		Query query = adminEntidad.createNativeQuery(strQuery, OmsBitacora.class);
		return query.getResultList();
	}
	
}
