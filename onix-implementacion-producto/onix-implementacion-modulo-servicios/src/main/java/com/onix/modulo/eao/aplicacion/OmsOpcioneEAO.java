package com.onix.modulo.eao.aplicacion;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.onix.modulo.dominio.aplicacion.OmsAccesosDirecto;
import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsOpcionesRole;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsOpcioneEAO extends OnixEAO<OmsOpcione, Long> {

	public boolean permitirAccesoOpcion(OmsOpcione opcion, OmsUsuario usuario) {
		String querySql = "select * " + " "
				+ "from oms_opciones_roles f " 
				+ " where f.id_rol in "
				+ "     (select d.id_rol "
				+ "from oms_usuarios_roles d where d.id_usuario = ? " + " and d.estado = 'A'"
				+ "      ) " + " and f.id_opcion in ( select id from "
						+ "oms_opciones where id = ? and tipo = 'P' )  " 
				+ " and f.estado = 'A'";

		Query query = adminEntidad.createNativeQuery(querySql, OmsOpcionesRole.class);
		query.setParameter(1, usuario.getId());
		query.setParameter(2, opcion.getId());
		return query.getResultList().size() > 0;
	}

	@SuppressWarnings("unchecked")
	public List<OmsOpcione> obtieneOpcionesPorUsuario(String usuario) {
		Query query = adminEntidad.createNativeQuery("SELECT OP.* " + "FROM oms_usuarios        U, "
				+ "oms_USUARIOS_ROLES UR, " + "oms_OPCIONES       OP, " + "oms_OPCIONES_ROLES OPR "
				+ "WHERE U.ID = UR.ID_USUARIO " + "AND UR.ID_ROL = OPR.ID_ROL " + "AND OPR.ID_OPCION = OP.ID "
				+ "AND OPR.ESTADO = 'A' " + "AND OP.ACCION IS NOT NULL " + "AND UPPER(U.USUARIO) = ?",
				OmsOpcione.class);
		query.setParameter(1, usuario);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<OmsOpcione> listaOpcionesTerminales(String usuario) 
	{
		Query query = adminEntidad.createNativeQuery(
				"SELECT OP.* " + "FROM oms_usuarios        U, "
				+ "oms_USUARIOS_ROLES UR, " + "oms_OPCIONES       OP, " + "oms_OPCIONES_ROLES OPR "
				+ "WHERE U.ID = UR.ID_USUARIO " + "AND UR.ID_ROL = OPR.ID_ROL " + "AND OPR.ID_OPCION = OP.ID "
				+ "AND OPR.ESTADO = 'A' " + "AND OP.ACCION IS NOT NULL " + "AND UPPER(U.USUARIO) = ? and op.ESTADO = 'A'",
				OmsOpcione.class).setParameter(1, usuario);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<OmsOpcione> listaOpcionesAsignada(String rol) {
		Query query = adminEntidad.createNativeQuery(
				" select op.* from oms_opciones_roles opr, oms_opciones op, oms_roles r "
						+ " where opr.id_opcion = op.id and opr.id_rol = r.id "
						+ " and op.Modulo_Padre is not null and upper(r.rol) = upper(?) and opr.estado='A' ",
				OmsOpcione.class);
		query.setParameter(1, rol);
		return query.getResultList();
	}

	public OmsOpcione obtenerOpcionPadre(Integer opcion) {
		Query query = adminEntidad
				.createNativeQuery(" select b.* from oms_opciones b where b.id = ? and b.estado = 'A' "
						+ "and b.Modulo_Padre is not null  ", OmsOpcione.class);
		query.setParameter(1, opcion);
		return (OmsOpcione) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public Integer cantidadOpcionesPorPadre(Integer rol, Integer opcion) {
		TypedQuery<BigDecimal> qr = (TypedQuery<BigDecimal>) adminEntidad
				.createNativeQuery(" select count(*) from oms_opciones_roles ro " + " where ro.id_rol = ? "
						+ " and ro.estado = 'A' " + " and ro.id_opcion in( " + " select o.id from oms_opciones o "
						+ " where o.modulo_padre = (select o.id " + "     from oms_opciones o "
						+ "     where o.Modulo_Padre is null " + "      and o.id = ?)) ");
		qr.setParameter(1, rol);
		qr.setParameter(2, opcion);
		BigDecimal bd = qr.getSingleResult();
		return bd.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<OmsAccesosDirecto> obtenerOpcionUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		String sql = " select * from oms_accesos_directos f " + "where f.id_usuario = :idUsuario "
				+ "and f.estado = 'A'";
		Query query = adminEntidad.createNativeQuery(sql, OmsAccesosDirecto.class);
		query.setParameter("idUsuario", idUsuario);
		return query.getResultList();
	}

	public void eliminarAccesosUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		String sql = "delete from oms_accesos_directos where id_usuario = :idUsuario";
		Query query = adminEntidad.createNativeQuery(sql, OmsAccesosDirecto.class);
		query.setParameter("idUsuario", idUsuario);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<OmsOpcione> obtenerOpcionNoAsignadaUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
		String sql = " select * " + "from oms_opciones r " + "where r.id not in (select f.id_opcion "
				+ "from oms_accesos_directos f  where f.id_usuario = :idUsuario "
				+ " and f.estado = 'A') and r.estado = 'A' and r.accion is not null " + "and r.id in ( "
				+ " SELECT OP.id  FROM oms_usuarios        U, " + "oms_USUARIOS_ROLES UR, " + "oms_OPCIONES       OP, "
				+ "oms_OPCIONES_ROLES OPR " + "WHERE U.ID = UR.ID_USUARIO " + "AND UR.ID_ROL = OPR.ID_ROL "
				+ "AND OPR.ID_OPCION = OP.ID " + "AND OP.ACCION IS NOT NULL " + "AND U.id = :idUsuario " + ") ";
		Query query = adminEntidad.createNativeQuery(sql, OmsOpcione.class);
		query.setParameter("idUsuario", idUsuario);
		return query.getResultList();
	}

	public void guardarAccesoDirecto(OmsAccesosDirecto acceso) {
		adminEntidad.persist(acceso);
		adminEntidad.flush();
	}

	public OmsOpcione buscarOpcionPorNombre(String nombre) {
		String sql = "SELECT * FROM oms_OPCIONES t " + "where upper(t.opcion) = upper(:opcion) " + "and t.estado = 'A'";
		Query query = adminEntidad.createNativeQuery(sql, OmsOpcione.class);
		query.setParameter("opcion", nombre);
		@SuppressWarnings("unchecked")
		List<OmsOpcione> lista = query.getResultList();

		if (lista.isEmpty()) {
			return null;
		} else {
			return lista.get(0);
		}
	}

}
