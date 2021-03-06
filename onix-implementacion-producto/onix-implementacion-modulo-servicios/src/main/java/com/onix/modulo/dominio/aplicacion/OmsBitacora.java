package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

/**
 * The persistent class for the PRI_USUARIOS database table.
 * 
 */
@Entity
@Table(name = "OMS_BITACORA")
@NamedQuery(name = "OmsBitacora.findAll", query = "SELECT p FROM OmsBitacora p")
public class OmsBitacora extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String proceso;
	private String usuario;

	private TIPO_BITACORA lTipoBitacora;

	public OmsBitacora() {
	}

	@GeneratedValue(generator = "secBitacora", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secBitacora", allocationSize = 1, initialValue = 1, sequenceName = "SEC_BITACORA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PROCESO")
	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	@Column(name = "USUARIO")
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_BITACORA")
	public TIPO_BITACORA getlTipoBitacora() {
		return lTipoBitacora;
	}
	
	public void setlTipoBitacora(TIPO_BITACORA lTipoBitacora) {
		this.lTipoBitacora = lTipoBitacora;
	}
	
	public enum TIPO_BITACORA {
		NOVEDAD, INFORMACION, ALERTA, ERROR, FATAL
	}

}