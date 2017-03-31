package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name="OMG_ICONOS")
public class OmgIcono extends EntidadBaseAuditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String lIconoFontPrimefaces;


	@GeneratedValue(generator = "secIcono", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secIcono", allocationSize = 1, initialValue = 1, sequenceName = "SEC_ICONOS")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	
	public String getlIconoFontPrimefaces() {
		return lIconoFontPrimefaces;
	}
	
	public void setlIconoFontPrimefaces(String lIconoFontPrimefaces) {
		this.lIconoFontPrimefaces = lIconoFontPrimefaces;
	}
	
	
}
