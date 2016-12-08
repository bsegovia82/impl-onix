package com.onix.modulo.eao.aplicacion;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.eao.OnixEAO;



@Stateless
@LocalBean
public class OmsUsuarioEAO extends OnixEAO<OmsUsuario, Long>{
	
/*
	public PriUsuarioEAO() 
	{	
		super(PriUsuario.class);
		
	}*/
	@SuppressWarnings("unchecked")
	public List<OmsUsuario> obtenerUsuarios(Long idUsuario) {
		String sql = "select * from oms_usuarios u where u.id= :idUsr";

		Query query = adminEntidad.createNativeQuery(sql, OmsUsuario.class );
		query.setParameter("idUsr",idUsuario );
		List<OmsUsuario> resultado = query.getResultList();
		return resultado;
		}
	
	@SuppressWarnings("unchecked")
	public List<OmsUsuario> obtenerUsuariosActivos() {
		String sql = "select * from oms_usuarios u where u.estado = 'A' order by u.id desc";

		Query query = adminEntidad.createNativeQuery(sql, OmsUsuario.class );
		
		List<OmsUsuario> resultado = query.getResultList();
		return resultado;
		}
	
	@SuppressWarnings("unchecked")
	public OmsUsuario buscarUsuario(String usuario) {
		String sql = "select * from oms_usuarios u where u.usuario = :usuario";

		Query query = adminEntidad.createNativeQuery(sql, OmsUsuario.class );
		query.setParameter("usuario",usuario );
		List<OmsUsuario> resultado = query.getResultList();
		return resultado.isEmpty()?null:resultado.get(0);
		}
	
	public void actualizaDatosUsuario(OmsUsuario usr){
		adminEntidad.merge(usr);
		adminEntidad.flush();
		adminEntidad.clear();
	}
	
	public void cambioClaveUsuario(OmsUsuario usuario) 
	{
		String lsQuery = "update oms_usuarios a " + "set a.clave = ?, "
				+ "a.fecha_actualizacion = sysdate, a.es_nuevo = ?, a.estado = ? " + "where a.id = ? ";
		Query query = adminEntidad.createNativeQuery(lsQuery);
		query.setParameter(1, usuario.getClave());
		query.setParameter(2, usuario.getEs_nuevo());
		query.setParameter(3, usuario.getEstado());
		query.setParameter(4, usuario.getId());
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<OmsUsuario> listaUsuarioPorRol(Long pIdRol) {
		// TODO Auto-generated method stub
		return adminEntidad.createNativeQuery
				("select * from oms_usuarios u "
						+ "where u.id in ( "
						+ "select d.id_usuario from oms_usuarios_roles d "
						+ "where d.id_rol = :idRol "
						+ "and d.estado = 'A' ) and u.estado = 'A' ", OmsUsuario.class)
				.setParameter("idRol", pIdRol).getResultList();
	}
	
}
