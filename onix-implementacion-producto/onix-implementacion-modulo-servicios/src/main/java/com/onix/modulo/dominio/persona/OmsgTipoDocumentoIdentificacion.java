package com.onix.modulo.dominio.persona;

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
@Table(name = "OMSG_TIPOS_DOCUMENTOS_IDENT")
public class OmsgTipoDocumentoIdentificacion extends EntidadBaseAuditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String nombreCorto;

	@GeneratedValue(generator = "secTipoDoc", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secTipoDoc", allocationSize = 1, initialValue = 1, sequenceName = "SEC_TIPO_DOC")
	@Id
	@Column(name = "ID")
	public Long getId() {

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

	@Column(name = "NOMBRE_CORTO", length = 8, nullable = false)
	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	

}
