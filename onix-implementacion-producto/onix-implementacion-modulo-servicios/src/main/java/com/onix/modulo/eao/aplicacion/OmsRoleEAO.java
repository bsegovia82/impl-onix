package com.onix.modulo.eao.aplicacion;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.onix.modulo.dominio.aplicacion.OmsOpcionesRole;
import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsRoleEAO extends OnixEAO<OmsRole, Long> {

	@SuppressWarnings("unchecked")
	public List<OmsRole> listaRolesActivos() {
		Query query = adminEntidad.createNativeQuery("select * from oms_roles a where a.estado = 'A' ", OmsRole.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<OmsRole> listarRolesDisponibles() {
		Query query = adminEntidad.createNativeQuery("SELECT * FROM oms_roles R", OmsRole.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Integer codRolAsesor() {
		TypedQuery<BigDecimal> qr = (TypedQuery<BigDecimal>) adminEntidad
				.createNativeQuery(" select ro.id from oms_roles ro " + " where ro.estado = 'A' "
						+ " and ro.rol = 'ASESOR' ");
		BigDecimal bd = qr.getSingleResult();
		return bd.intValue();
	}

	public boolean verificarSiExisteRolOpcion(Long idRol, Long idOpcion)
	{
		String sql = "select * from oms_opciones_roles t1 "
				+ "where t1.id_rol = :rol "
				+ "and t1.id_opcion = :opcion "
				+ "and t1.estado = 'A'";
		Query query = adminEntidad.createNativeQuery(sql, OmsOpcionesRole.class);
		query.setParameter("rol", idRol);
		query.setParameter("opcion", idOpcion);
		List<OmsOpcionesRole> resultado = query.getResultList();
		if (resultado.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public OmsRole obtenerRoles(Long idRoles) {
		String sql = "select * from oms_roles r where r.id!=1 and r.id= :idRol";
		Query query = adminEntidad.createNativeQuery(sql, OmsRole.class);
		query.setParameter("idRol", idRoles);

		List<OmsRole> resultado = query.getResultList();
		if (resultado.isEmpty()) {
			return null;
		} else {
			return resultado.get(0);
		}
	}
}
