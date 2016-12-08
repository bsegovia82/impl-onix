package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

/**
 * The persistent class for the OMS_USUARIOS database table.
 * 
 */
@Entity
@Table(name = "OMS_USUARIOS")
@NamedQuery(name = "OmsUsuario.findAll", query = "SELECT p FROM OmsUsuario p")
public class OmsUsuario extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final String CLAVE_INICIAL_DEFAULT = "123456789";
	
	private String clave;

	private String usuario;

	private String correo;

	private String es_nuevo;

	private List<OmsUsuariosRole> priUsuariosRoles;

	private String rolesAsignados;

	private byte[] imagenReferencia;

	public OmsUsuario() {
	}

	@GeneratedValue(generator = "secUsuario", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secUsuario", allocationSize = 1, initialValue = 1, sequenceName = "SEC_USUARIO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CLAVE")
	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Column(name = "USUARIO")
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@OneToMany(mappedBy = "priUsuario", fetch = FetchType.EAGER)
	public List<OmsUsuariosRole> getPriUsuariosRoles() {
		return this.priUsuariosRoles;
	}

	public void setPriUsuariosRoles(List<OmsUsuariosRole> priUsuariosRoles) {
		this.priUsuariosRoles = priUsuariosRoles;
	}

	@Transient
	public String getRolesAsignados() {
		return rolesAsignados;
	}

	public void setRolesAsignados(String rolesAsignados) {
		this.rolesAsignados = rolesAsignados;
	}

	@Column(name = "CORREO")
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setEs_nuevo(String es_nuevo) {
		this.es_nuevo = es_nuevo;
	}

	@Column(name = "ES_NUEVO")
	public String getEs_nuevo() {
		return es_nuevo;
	}

	public void agregarRol(OmsUsuariosRole usuarioRol) {
		if (priUsuariosRoles == null) {
			priUsuariosRoles = new ArrayList<>();
		}
		usuarioRol.setPriUsuario(this);
		priUsuariosRoles.add(usuarioRol);
	}

	public void agregarRol(OmsRole rol) {
		OmsUsuariosRole usuarioRol = new OmsUsuariosRole();
		usuarioRol.setEstado("A");
		usuarioRol.setFechaRegistro(new Date());
		usuarioRol.setObservacion("DESCRIPCION ASIGNACION: " + this.getUsuario() + " - " + rol.getRol());
		usuarioRol.setPriRole(rol);
		agregarRol(usuarioRol);
	}

	@Lob
	@Column(name = "IMAGEN_REFERENCIA")
	public byte[] getImagenReferencia() {
		return imagenReferencia;
	}

	public void setImagenReferencia(byte[] imagenReferencia) {
		this.imagenReferencia = imagenReferencia;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return usuario;
	}
}