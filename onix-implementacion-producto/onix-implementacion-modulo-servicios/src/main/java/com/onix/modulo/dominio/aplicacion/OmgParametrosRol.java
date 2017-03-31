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
@Table(name = "OMS_PARAMETROS_ROLES")
@NamedQuery(name = "OmgParametrosRol.findAll", query = "SELECT p FROM OmgParametrosRol p")
public class OmgParametrosRol extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;
	private OmsRole lRol;
	private OmgParametro lParametro;
	
	public OmgParametrosRol() {
	}

	@GeneratedValue(generator = "secParametroRol", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secParametroRol", allocationSize = 1, initialValue = 1, sequenceName = "SEC_PARAMETROROL")
	@Id
	@Column(name = "ID")
	@Override
	public Long getId() {
		return this.id;
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
	public OmsRole getlRol() {
		return lRol;
	}

	public void setlRol(OmsRole lRol) {
		this.lRol = lRol;
	}

	@ManyToOne
	@JoinColumn(name = "ID_PARAMETRO")
	public OmgParametro getlParametro() {
		return lParametro;
	}

	public void setlParametro(OmgParametro lParametro) {
		this.lParametro = lParametro;
	}

}