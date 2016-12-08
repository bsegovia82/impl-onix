package com.onix.modulo.dominio.localizacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name="OMSL_PROVINCIAS")
public class OmslProvincia extends EntidadBaseAuditable<Long> implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OmslPais pais;
	private String nombre;
	private List<OmslCanton> cantones=new ArrayList<OmslCanton>();

	@GeneratedValue(generator = "secProvincia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secProvincia", allocationSize = 1, initialValue = 1, sequenceName = "SEC_PROVINCIA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne
	@JoinColumn(name="ID_PAIS",nullable=false)
	public OmslPais getPais() {
		return pais;
	}

	public void setPais(OmslPais pais) {
		this.pais = pais;
	}

	
	@Column(name="NOMBRE",length=64,nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@OneToMany(mappedBy="provincia")
	public List<OmslCanton> getCantones() {
		return cantones;
	}

	public void setCantones(List<OmslCanton> cantones) {
		this.cantones = cantones;
	}

	

}
