package com.onix.modulo.dominio.persona.operacion;

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
@Table(name="OMSO_ESPECIALIDADES")  
public class OmsoEspecialidad extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nombreEspecialidad;
	
	@GeneratedValue(generator = "secEspecialidades", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secEspecialidades", allocationSize = 1, initialValue = 1, sequenceName = "SEC_ESPECIALIDAD")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id =  id;
	}
	
	@Column(name="NOMBRE_ESPECIALIDAD")
	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}
	
	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombreEspecialidad;
	}
}
