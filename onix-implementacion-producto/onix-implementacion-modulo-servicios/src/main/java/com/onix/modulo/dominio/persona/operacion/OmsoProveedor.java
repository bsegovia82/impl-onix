package com.onix.modulo.dominio.persona.operacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.dominio.persona.OmsgPersona;
import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMSO_PROVEEDOR")
@Inheritance(strategy = InheritanceType.JOINED)
public class OmsoProveedor extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigoProveedor;
	private OmsgPersona persona;

	@GeneratedValue(generator = "secProveedor", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secProveedor", allocationSize = 1, initialValue = 1, sequenceName = "SEC_PROVEEDOR")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(Long arg0) {
		// TODO Auto-generated method stub
		id = arg0;
	}

	@Column(name = "CODIGO_PROVEEDOR")
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	@OneToOne
	@JoinColumn(name = "ID_PERSONA", nullable = true)
	public OmsgPersona getPersona() {
		return persona;
	}

	public void setPersona(OmsgPersona persona) {
		this.persona = persona;
	}

}
