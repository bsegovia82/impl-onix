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

@Entity
@Table(name = "OMG_DETALLE_PLAN")
@NamedQuery(name = "OmgDetallePlan.findAll", query = "SELECT p FROM OmgDetallePlan p")
public class OmgDetallePlan extends EntidadBaseAuditable<Long> implements Serializable
{

	private String lCaracteristica;
	private String lValor;
	private OmgTipoPlan lTipoPlan;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	@GeneratedValue(generator = "secDetallePlan", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secDetallePlan", allocationSize = 1, initialValue = 1, sequenceName = "SEC_DETALLE_PLAN")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Column(name = "CARACTERISTICA")
	public String getlCaracteristica() {
		return lCaracteristica;
	}

	public void setlCaracteristica(String lCaracteristica) {
		this.lCaracteristica = lCaracteristica;
	}

	@Column(name = "VALOR")
	public String getlValor() {
		return lValor;
	}

	public void setlValor(String lValor) {
		this.lValor = lValor;
	}

	@ManyToOne
	@JoinColumn(name = "ID_TIPO_PLAN")
	public OmgTipoPlan getlTipoPlan() {
		return lTipoPlan;
	}
	
	public void setlTipoPlan(OmgTipoPlan lTipoPlan) {
		this.lTipoPlan = lTipoPlan;
	}
	
	
	
}
