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
@Table(name = "OMG_TIPO_PARAMETRO")
@NamedQuery(name = "OmgTipoParametro.findAll", query = "SELECT p FROM OmgTipoParametro p")
public class OmgTipoParametro extends EntidadBaseAuditable<Long> implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String lNombreTipo;
	private String lModificableWeb;
	private List<OmgParametro> lListaParametro;
	
	
	@GeneratedValue(generator = "secTipoParametro", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secTipoParametro", allocationSize = 1, initialValue = 1, sequenceName = "SEC_TIPO_PARAMETRO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}


	@Column(name="NOMBRE_TIPO")
	public String getlNombreTipo() {
		return lNombreTipo;
	}


	public void setlNombreTipo(String lNombreTipo) {
		this.lNombreTipo = lNombreTipo;
	}

	@Column(name="MODIFICABLE_WEB")
	public String getlModificableWeb() {
		return lModificableWeb;
	}
	
	public void setlModificableWeb(String lModificableWeb) {
		this.lModificableWeb = lModificableWeb;
	}
	
	@OneToMany(mappedBy = "lOmgTipoParametro")
	public List<OmgParametro> getlListaParametro() {
		return lListaParametro;
	}
	
	public void setlListaParametro(List<OmgParametro> lListaParametro) {
		this.lListaParametro = lListaParametro;
	}
}
