package com.onix.modulo.dominio.empresa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.dominio.persona.OmsgPersona;
import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMSE_SUCURSAL_PERSONAS")
public class OmseSucursalPersona  extends EntidadBaseAuditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	private OmsgPersona persona;
	private OmseSucursal sucursal;
	
	@GeneratedValue(generator = "secSucursalPersona", 
			strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secSucursalPersona", 
	allocationSize = 1, initialValue = 1, 
	sequenceName = "SEC_SUCURSAL_PERSONA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long arg0) {
		this.id = arg0;
	}

	@ManyToOne
	@JoinColumn(name="ID_PERSONA")
	public OmsgPersona getPersona() {
		return persona;
	}

	public void setPersona(OmsgPersona persona) {
		this.persona = persona;
	}

	@ManyToOne
	@JoinColumn(name="ID_SUCURSAL")
	public OmseSucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(OmseSucursal sucursal) {
		this.sucursal = sucursal;
	}
	
	

}
