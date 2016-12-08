package com.onix.modulo.dominio.persona;

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

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;


@Entity
@Table(name="OMSG_TELEFONOS")
public class OmsgTelefonoPersona extends EntidadBaseAuditable<Long> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private OmsgTipoTelefono tipoTelefono;
	private OmsgPersona persona;
	private String numero;
	
	@GeneratedValue(generator = "secTelefono", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secTelefono", allocationSize = 1, initialValue = 1, sequenceName = "SEC_TELEFONO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id =id;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_TELEFONO",nullable=false)
	public OmsgTipoTelefono getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(OmsgTipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_PERSONA",nullable=false)
	public OmsgPersona getPersona() {
		return persona;
	}
	public void setPersona(OmsgPersona persona) {
		this.persona = persona;
	}
	
	@Column(name="NUMERO",nullable=false,length=64)
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	

}