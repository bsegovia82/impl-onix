package com.onix.modulo.dominio.localizacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name="OMSL_PAISES")
public class OmslPais extends EntidadBaseAuditable<Long> implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<OmslProvincia> provincias=new ArrayList<OmslProvincia>();
	//no se debe ensuciar las tablas con otro detalles
//	private List<OmsgNacionalidad> nacionalidades=new ArrayList<OmsgNacionalidad>();

	@GeneratedValue(generator = "secPais", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secPais", allocationSize = 1, initialValue = 1, sequenceName = "SEC_PAIS")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	@Column(name="NOMBRE",length=64,nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy="pais")
	public List<OmslProvincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<OmslProvincia> provincias) {
		this.provincias = provincias;
	}

	//No relacionarlas por que eso corresponde a otra implementacion
//	@OneToMany(mappedBy="pais")
//	public List<OmsgNacionalidad> getNacionalidades() {
//		return nacionalidades;
//	}
//
//	public void setNacionalidades(List<OmsgNacionalidad> nacionalidades) {
//		this.nacionalidades = nacionalidades;
//	}
}
