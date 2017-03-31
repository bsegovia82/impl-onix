package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsOpcionesRole;
import com.onix.modulo.eao.aplicacion.OmsOpcionesRoleEAO;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorOpcionRol
		extends ServicioMantenedorControlAuditoria<OmsOpcionesRoleEAO, OmsOpcionesRole, Long> {

	@EJB
	private OmsOpcionesRoleEAO crud;

	protected OmsOpcionesRoleEAO getCrud() {
		return crud;
	}

	public void eliminarOpcionesRole(Long idRol) {
		crud.eliminarOpcionesRol(idRol);
	} 

	public List<OmsOpcione> listaOpcionesEjecutablesRol(String lUsuario, String tipo) {
		return crud.obtenerListaOpcionesEjecutablesRol(lUsuario, tipo);
	}

	@Override
	protected void cargarConfiguracionServicio() {
		System.out.println("NO EXISTEN CONFIGURACIONES PREVIAS DEL SERVICIO");

	}

	public OmsOpcionesRole obtenerOpcionRolPorOpcionRol(String pNobreOpcion, Long idRol) {
		List<OmsOpcionesRole> lListaOpcionesRoles = obtenerListaOpcionRolPorOpcionRol(pNobreOpcion, idRol);
		return lListaOpcionesRoles.isEmpty() ? null : lListaOpcionesRoles.get(0);
	}

	public List<OmsOpcionesRole> obtenerListaOpcionRolPorOpcionRol(String pNobreOpcion, Long idRol) {
		return getCrud().ejecutarQueryNativo("select * from oms_opciones_roles  " + "where id_rol = :idRol  "
				+ "and id_opcion = (select ID from OMS_OPCIONES where OPCION = :nombreOpcion )",
		new HashMap<String, Object>() {
			static final long serialVersionUID = 1L;
			{
				put("idRol", idRol);
				put("nombreOpcion", pNobreOpcion);
			}
		}, OmsOpcionesRole.class);
	}

}
