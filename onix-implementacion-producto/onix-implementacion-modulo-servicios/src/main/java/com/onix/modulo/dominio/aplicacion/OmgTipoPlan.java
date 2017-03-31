package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMG_TIPO_PLAN")
@NamedQuery(name = "OmgTipoPlan.findAll", query = "SELECT p FROM OmgTipoPlan p")
public class OmgTipoPlan extends EntidadBaseAuditable<Long> implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	private String lNombreTipoPlan;
	private List<OmgDetallePlan> lListaDetallePlan;
	
	
	@Override
	@GeneratedValue(generator = "secTipoPlan", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secTipoPlan", allocationSize = 1, initialValue = 1, sequenceName = "SEC_TIPO_PLAN")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}


	@Column(name = "NOMBRE_TIPO_PLAN")
	public String getlNombreTipoPlan() {
		return lNombreTipoPlan;
	}


	public void setlNombreTipoPlan(String lNombreTipoPlan) {
		this.lNombreTipoPlan = lNombreTipoPlan;
	}


	@OneToMany(mappedBy = "lTipoPlan")
	public List<OmgDetallePlan> getlListaDetallePlan() {
		return lListaDetallePlan;
	}


	public void setlListaDetallePlan(List<OmgDetallePlan> lListaDetallePlan) {
		this.lListaDetallePlan = lListaDetallePlan;
	}
	
	
	
	

}
