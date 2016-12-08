package com.onix.modulo.eao.aplicacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.onix.modulo.dominio.aplicacion.OmsUsuariosRole;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsUsuariosRoleEAO extends OnixEAO<OmsUsuariosRole, Long> {

	public void eliminarUsuarioRol(Long idUsuario) {
		String lsQuery = "delete from " + "Oms_Usuarios_Roles where id_usuario = :idUsuario ";
		Query query = adminEntidad.createNativeQuery(lsQuery);
		query.setParameter("idUsuario", idUsuario);
		query.executeUpdate();
	}

}
