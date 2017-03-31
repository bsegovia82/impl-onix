package com.onix.modulo.eao.aplicacion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsOpcionesRole;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsOpcionesRoleEAO extends OnixEAO<OmsOpcionesRole, Long> {

	public static final String OPCIONES_PADRE = "OPCIONES_ROLES.OPCIONES_PADRE";

	@SuppressWarnings("unchecked")
	public List<OmsOpcione> obtenerListaOpcionesRol(Long usuario, String orientacion) {
		Query query = adminEntidad.createNamedQuery(OPCIONES_PADRE);
		query.setParameter(1, usuario);
		query.setParameter(2, orientacion);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public OmsOpcionesRole obtenerOpcionRol(Integer idOpcion, Integer idRol) {
		Query query = adminEntidad.createNativeQuery(
				"select op.* from OMS_OPCIONES_ROLES op " + " where op.id_opcion = ? " + " and op.id_rol = ? ",
				OmsOpcionesRole.class);
		query.setParameter(1, idOpcion);
		query.setParameter(2, idRol);
		List<OmsOpcionesRole> resultado = query.getResultList();
		if (!resultado.isEmpty()) {
			return resultado.get(0);
		} else {
			return null;
		}
	}

	public void actualizarOpcionesRol(String estado, Integer idOpRol) {
		String lsQuery = " update OMS_OPCIONES_ROLES b " + " set b.estado = ?, b.fecha_actualizacion=sysdate "
				+ " where b.id = ? ";
		Query query = adminEntidad.createNativeQuery(lsQuery);
		query.setParameter(1, estado);
		query.setParameter(2, idOpRol);
		query.executeUpdate();
	}

	public void eliminarOpcionesRol(Long idRol) {
		String lsQuery = " delete OMS_OPCIONES_ROLES b " + " where b.ID_ROL = :idRol ";
		Query query = adminEntidad.createNativeQuery(lsQuery);
		query.setParameter("idRol", idRol);
		query.executeUpdate();
	}

	public void ingresarOpcionRol(OmsOpcionesRole opcRol) {
		adminEntidad.persist(opcRol);
	}

	public List<OmsOpcione> obtenerListaOpcionesEjecutablesRol(String lUsuario, String tipo) {
		String lsQuery = " select f.* from oms_opciones f, oms_opciones_roles s " + "where f.id = s.id_opcion "
				+ "and f.estado = 'A' " + "and f.accion is not null " + "and f.tipo = :tipo " + "and s.id_rol in (  "
				+ "select id_rol from OMS_USUARIOS_ROLES f " + "where f.id_usuario in ( "
				+ "select g.id from oms_usuarios g " + "where g.usuario = :usuario " + "and g.estado = 'A' " + " ) "
				+ "and estado = 'A' " + ") ";
		Query query = adminEntidad.createNativeQuery(lsQuery, OmsOpcione.class);
		query.setParameter("usuario", lUsuario);
		query.setParameter("tipo", tipo);
		return query.getResultList();
	}

}
