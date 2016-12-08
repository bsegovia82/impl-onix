package com.onix.modulo.dominio.empresa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMSE_EMPRESAS")
public class OmseEmpresa extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nombreComercial;
	private String razonSocial;
	private String ruc;
	private String claveCertificado;
	private byte [] certificado;
	private byte [] logo;
	private String cuentaCorreo;
	
	private List<OmseSucursal> sucursales;
	

	private String paginaWeb;

	@GeneratedValue(generator = "secEmpresa", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secEmpresa", allocationSize = 1, initialValue = 1, sequenceName = "SEC_EMPRESA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NOMBRE_COMERCIAL")
	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	@Column(name = "RAZON_SOCIAL")
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Column(name = "RUC")
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	@OneToMany(mappedBy = "empresa")
	public List<OmseSucursal> getSucursales() {
		return sucursales;
	}

	public void setSucursales(List<OmseSucursal> sucursales) {
		this.sucursales = sucursales;
	}

	@Column(name="PAGINA_WEB")
	public String getPaginaWeb() {
		return paginaWeb;
	}
	
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	@Column(name="CLAVE_CERTIFICADO")
	public String getClaveCertificado() {
		return claveCertificado;
	}

	public void setClaveCertificado(String claveCertificado) {
		this.claveCertificado = claveCertificado;
	}

	@Lob
	@Column(name="CERTIFICADO")
	public byte[] getCertificado() {
		return certificado;
	}

	public void setCertificado(byte[] certificado) {
		this.certificado = certificado;
	}

	@Lob
	@Column(name="LOGO")
	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	@Column(name="CUENTA_CORREO")
	public String getCuentaCorreo() {
		return cuentaCorreo;
	}

	public void setCuentaCorreo(String cuentaCorreo) {
		this.cuentaCorreo = cuentaCorreo;
	}
	
	
	
}
