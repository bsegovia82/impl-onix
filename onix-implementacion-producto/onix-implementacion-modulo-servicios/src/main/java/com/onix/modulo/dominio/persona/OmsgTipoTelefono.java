package com.onix.modulo.dominio.persona;

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
@Table(name = "OMSG_TIPOS_TELEFONOS")
public class OmsgTipoTelefono extends EntidadBaseAuditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nombre;
	private List<OmsgTelefonoPersona> telefonos = new ArrayList<OmsgTelefonoPersona>();

	@GeneratedValue(generator = "secTiposTelefono", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secTiposTelefono", allocationSize = 1, initialValue = 1, sequenceName = "SEC_TIPO_TELEF")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

	}
	
	@Column(name = "NOMBRE", length = 64, nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(mappedBy = "tipoTelefono")
	public List<OmsgTelefonoPersona> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<OmsgTelefonoPersona> telefonos) {
		this.telefonos = telefonos;
	}

	
}
