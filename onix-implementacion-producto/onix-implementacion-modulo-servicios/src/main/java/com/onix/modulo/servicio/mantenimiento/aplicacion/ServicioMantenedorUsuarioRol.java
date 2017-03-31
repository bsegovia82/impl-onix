package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsUsuariosRole;
import com.onix.modulo.eao.aplicacion.OmsUsuariosRoleEAO;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorUsuarioRol
		extends ServicioMantenedorControlAuditoria<OmsUsuariosRoleEAO, OmsUsuariosRole, Long> {

	@EJB
	private OmsUsuariosRoleEAO crud;

	protected OmsUsuariosRoleEAO getCrud() {
		return crud;
	}

	public void eliminarRolesUsuario(Long idUsuario) {
		crud.eliminarUsuarioRol(idUsuario);
	}
	
	

	@Override
	protected void cargarConfiguracionServicio() {
		System.out.println("NO EXISTEN CONFIGURACIONES PARA EL SEVICIO ServicioMantenedorUsuarioRol");

	}

	public List<OmsUsuariosRole> obtenerListaUsuarioRolIdUsuario(Long pIdUsuario)
	{
		return getCrud().ejecutarQueryNativo("select * from oms_usuarios_roles where id_usuario = :idUsuario "
				+ "and estado = 'A'",
		new HashMap<String, Object>() {
			static final long serialVersionUID = 1L;
			{
				put("idUsuario", pIdUsuario);
			}
		}, OmsUsuariosRole.class); 
		
		
		
	}
	
	public OmsUsuariosRole obtenerUsuarioRolPorRolUsuario(String pRol, Long pIdUsuario ) {
		List<OmsUsuariosRole> lListaOpcionesRoles = obtenerListaUsuarioRolPorRolUsuario(pRol, pIdUsuario);
		return lListaOpcionesRoles.isEmpty() ? null : lListaOpcionesRoles.get(0);
	}
	
	public List<OmsUsuariosRole>  obtenerListaUsuarioRolPorRolUsuario(String lRol, Long id) {
		
		return getCrud().ejecutarQueryNativo("select * from oms_usuarios_roles where id_usuario = :idUsuario "
				+ "and id_rol = (select ID from oms_roles where rol = :nombreRol)",
		new HashMap<String, Object>() {
			static final long serialVersionUID = 1L;
			{
				put("idUsuario", id);
				put("nombreRol", lRol);
			}
		}, OmsUsuariosRole.class); 
	}
}
