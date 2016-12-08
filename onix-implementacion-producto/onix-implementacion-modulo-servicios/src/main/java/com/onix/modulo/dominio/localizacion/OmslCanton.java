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

import com.onix.modulo.dominio.persona.OmsgDireccionPersona;
import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;




@Entity
@Table(name="OMSL_CANTONES")
public class OmslCanton extends EntidadBaseAuditable<Long> implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OmslProvincia provincia;
	private String nombre;
	private List<OmsgDireccionPersona> direccionesPersonas=new ArrayList<OmsgDireccionPersona>();

	@GeneratedValue(generator = "secCanton", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secCanton", allocationSize = 1, initialValue = 1, sequenceName = "SEC_CANTON")
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
	
	@ManyToOne
	@JoinColumn(name="ID_PROVINCIA",nullable=false)
	public OmslProvincia getProvincia() {
		return provincia;
	}

	public void setProvincia(OmslProvincia provincia) {
		this.provincia = provincia;
	}

	@Column(name="NOMBRE",length=64,nullable=false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy="canton")
	public List<OmsgDireccionPersona> getDireccionesPersonas() {
		return direccionesPersonas;
	}

	public void setDireccionesPersonas(List<OmsgDireccionPersona> direccionesPersonas) {
		this.direccionesPersonas = direccionesPersonas;
	}
}