package com.onix.modulo.dominio.empresa;

import java.io.Serializable;
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
@Table(name="OMSE_SUCURSALES") 
public class OmseSucursal extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String direccion;
	private String telefono;
	private String extension;
	private String emailContacto;
	private OmseEmpresa empresa;
	private String codigoLocalidad;
	
	private List<OmseSucursalPersona> listaPersonas;
	
	@GeneratedValue(generator = "secSucursal", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secSucursal", allocationSize = 1, initialValue = 1, sequenceName = "SEC_SUCURSAL")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="DIRECCION")
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name="TELEFONO")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name="EMAIL_CONTACTO")
	public String getEmailContacto() {
		return emailContacto;
	}

	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}

	@ManyToOne
	@JoinColumn(name="ID_EMPRESA")
	public OmseEmpresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(OmseEmpresa empresa) {
		this.empresa = empresa;
	}

	@Column(name="EXTENSION")
	public String getExtension() {
		return extension;
	}
	
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Column(name="CODIGO_LOCALIDAD")
	public String getCodigoLocalidad() {
		return codigoLocalidad;
	}
	
	public void setCodigoLocalidad(String codigoLocalidad) {
		this.codigoLocalidad = codigoLocalidad;
	}
	
	@OneToMany(mappedBy="persona")
	public List<OmseSucursalPersona> getListaPersonas() {
		return listaPersonas;
	}
	
	public void setListaPersonas(List<OmseSucursalPersona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
}
