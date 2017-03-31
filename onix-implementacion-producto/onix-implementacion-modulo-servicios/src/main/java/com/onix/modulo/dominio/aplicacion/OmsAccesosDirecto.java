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
 * The persistent class for the PRI_ACCESOS_DIRECTOS database table.
 *   
 */
@Entity
@Table(name = "OMS_ACCESOS_DIRECTOS")
@NamedQuery(name = "OmsAccesosDirecto.findAll", query = "SELECT p FROM OmsAccesosDirecto p")
public class OmsAccesosDirecto extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private OmsOpcione priOpcione;

	private OmsUsuario priUsuario;

	public OmsAccesosDirecto() {
	}

	@GeneratedValue(generator = "secIDAcceso", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secIDAcceso", allocationSize = 1, initialValue = 1, sequenceName = "SEC_IDACCESO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	@ManyToOne
	@JoinColumn(name = "ID_OPCION")
	public OmsOpcione getPriOpcione() {
		return priOpcione;
	}

	public void setPriOpcione(OmsOpcione priOpcione) {
		this.priOpcione = priOpcione;
	}

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	public OmsUsuario getPriUsuario() {
		return priUsuario;
	}

	public void setPriUsuario(OmsUsuario priUsuario) {
		this.priUsuario = priUsuario;
	}

}