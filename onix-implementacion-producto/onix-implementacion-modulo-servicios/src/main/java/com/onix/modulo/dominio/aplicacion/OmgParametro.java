package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMG_PARAMETRO")
@NamedQuery(name = "OmgParametro.findAll", query = "SELECT p FROM OmgParametro p")
public class OmgParametro extends EntidadBaseAuditable<Long> implements Serializable{

	
	/**
	 * 
	 */
	
	private String lNombreParametro;
	private String lValorParametro;
	private TIPO_DATO_PARAMETRO lTipoDatoParametro;
	private OmgTipoParametro lOmgTipoParametro;
	
	
	private static final long serialVersionUID = 1L;

	@GeneratedValue(generator = "secParametro", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secParametro", allocationSize = 1, initialValue = 1, sequenceName = "SEC_PARAMETRO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}
	
	public enum TIPO_DATO_PARAMETRO {
		NUMERO, FECHA, STRING, BOOLEAN, LONG, INTEGER
	}

	@Column(name = "NOMBRE_PARAMETRO")
	public String getlNombreParametro() {
		return lNombreParametro;
	}

	public void setlNombreParametro(String lNombreParametro) {
		this.lNombreParametro = lNombreParametro;
	}

	@Column(name = "VALOR_PARAMETRO")
	public String getlValorParametro() {
		return lValorParametro;
	}

	public void setlValorParametro(String lValorParametro) {
		this.lValorParametro = lValorParametro;
	}

	@Column(name = "TIPO_DATO_PARAMETRO")
	@Enumerated(EnumType.STRING)
	public TIPO_DATO_PARAMETRO getlTipoDatoParametro() {
		return lTipoDatoParametro;
	}

	public void setlTipoDatoParametro(TIPO_DATO_PARAMETRO lTipoDatoParametro) {
		this.lTipoDatoParametro = lTipoDatoParametro;
	}

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PARAMETRO")
	public OmgTipoParametro getlOmgTipoParametro() {
		return lOmgTipoParametro;
	}

	public void setlOmgTipoParametro(OmgTipoParametro lOmgTipoParametro) {
		this.lOmgTipoParametro = lOmgTipoParametro;
	}
	
}
