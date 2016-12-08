package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

/**
 * The persistent class for the PRI_USUARIOS_ROLES database table.
 * 
 */
@Entity
@Table(name = "OMS_USUARIOS_ROLES")
@NamedQuery(name = "OmsUsuariosRole.findAll", query = "SELECT p FROM OmsUsuariosRole p")
public class OmsUsuariosRole extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String descripcion;

	private OmsRole priRole;

	private OmsUsuario priUsuario;

	public OmsUsuariosRole() {
	}

	@GeneratedValue(generator = "secUsuarioRol", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secUsuarioRol", allocationSize = 1, initialValue = 1, sequenceName = "SEC_USUARIOROL")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "DESCRIPCION")
	/**/
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@ManyToOne
	@JoinColumn(name = "ID_ROL")
	public OmsRole getPriRole() {
		return this.priRole;
	}

	public void setPriRole(OmsRole priRole) {
		this.priRole = priRole;
	}

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	public OmsUsuario getPriUsuario() {
		return this.priUsuario;
	}

	public void setPriUsuario(OmsUsuario priUsuario) {
		this.priUsuario = priUsuario;
	}

}