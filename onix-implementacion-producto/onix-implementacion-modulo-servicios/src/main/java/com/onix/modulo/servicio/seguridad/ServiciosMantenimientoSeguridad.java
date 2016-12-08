package com.onix.modulo.servicio.seguridad;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsOpcionesRole;
import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.eao.aplicacion.OmsOpcioneEAO;
import com.onix.modulo.eao.aplicacion.OmsOpcionesRoleEAO;
import com.onix.modulo.eao.aplicacion.OmsRoleEAO;
import com.onix.modulo.eao.aplicacion.OmsUsuarioEAO;
import com.onix.modulo.eao.aplicacion.OmsUsuariosRoleEAO;

@Stateless
public class ServiciosMantenimientoSeguridad {
	@EJB
	private OmsUsuarioEAO usuarioEAO;
	@EJB
	private OmsRoleEAO rolEAO;
	@EJB
	private OmsOpcioneEAO opcionEAO;
	@EJB
	private OmsUsuariosRoleEAO usuarioRolEAO;
	@EJB
	private OmsOpcionesRoleEAO rolesOpcionEAO;

	public List<OmsOpcione> obtenerOpcionesPorUsuario(String usuario) {
		return opcionEAO.obtieneOpcionesPorUsuario(usuario);
	}

	

	public List<OmsRole> listaRolesActivos() {
		return rolEAO.listaRolesActivos();
	}

	public List<OmsRole> listarRolesDisponibles() {
		return rolEAO.listarRolesDisponibles();
	}

	public List<OmsOpcione> listaOpcionesTerminales() {
		return opcionEAO.listaOpcionesTerminales();
	}

	public List<OmsOpcione> listaOpcionesAsignada(String rol) {
		return opcionEAO.listaOpcionesAsignada(rol);
	}

	public OmsOpcionesRole obtenerOpcionRol(Integer idOpcion, Integer idRol) {
		return rolesOpcionEAO.obtenerOpcionRol(idOpcion, idRol);
	}

	public void actualizarOpcionesRol(String estado, Integer idOpRol) {
		rolesOpcionEAO.actualizarOpcionesRol(estado, idOpRol);
	}

	public void ingresarOpcionRol(OmsOpcionesRole opcRol) {
		rolesOpcionEAO.ingresarOpcionRol(opcRol);
	}

	public OmsOpcione obtenerOpcionPadre(Integer opcion) {
		return opcionEAO.obtenerOpcionPadre(opcion);
	}

	public Integer cantidadOpcionesPorPadre(Integer rol, Integer opcion) {
		return opcionEAO.cantidadOpcionesPorPadre(rol, opcion);
	}

	public void guardarRol(OmsRole rol) {
		rolEAO.insertar(rol);
	}

	public OmsRole actualizarRol(OmsRole rol) {
		return rolEAO.actualizar(rol);
	}

	public void crearUsuario(OmsUsuario usuario) {
		usuarioEAO.insertar(usuario);
	}

	public Integer codRolAsesor() {
		return rolEAO.codRolAsesor();
	}
	
	public OmsUsuario obtenerUsuarioTot(String usuario) {
		return usuarioEAO.buscarUsuario(usuario);
	}
	
	public void cambioClaveUsuario(OmsUsuario usuario) throws Throwable {
		usuarioEAO.cambioClaveUsuario(usuario);
	}


}
