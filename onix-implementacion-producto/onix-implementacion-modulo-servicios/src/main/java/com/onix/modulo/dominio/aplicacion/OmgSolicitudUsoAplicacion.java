package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMG_SOLICITUD_USO_APLICACION")
@NamedQuery(name = "OmgSolicitudUsoAplicacion.findAll", query = "SELECT p FROM OmgSolicitudUsoAplicacion p")
public class OmgSolicitudUsoAplicacion extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String lNombre;
	private String lNombreEmpresa;
	private String lPais;
	private String lCiudad;
	private String lEmail;
	private String lCelular;  
	private String lSolicitud;
	private String lEmailEnviado;
	private String lUsuarioDemoCreado;
	

	private CANAL_REGISTRO lCanalRegistro;

	private Long idTipoPlan;
	
	
	public OmgSolicitudUsoAplicacion()
	{}
	
	@GeneratedValue(generator = "secSolicitud", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secSolicitud", allocationSize = 1, initialValue = 1, sequenceName = "SEC_SOLICITUD")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	@Column(name="NOMBRE")
	public String getlNombre() {
		return lNombre;
	}

	public void setlNombre(String lNombre) {
		this.lNombre = lNombre;
	}

	@Column(name="NOMBRE_EMPRESA")
	public String getlNombreEmpresa() {
		return lNombreEmpresa;
	}

	public void setlNombreEmpresa(String lNombreEmpresa) {
		this.lNombreEmpresa = lNombreEmpresa;
	}

	@Column(name="PAIS")
	public String getlPais() {
		return lPais;
	}

	public void setlPais(String lPais) {
		this.lPais = lPais;
	}

	@Column(name="CIUDAD")
	public String getlCiudad() {
		return lCiudad;
	}

	public void setlCiudad(String lCiudad) {
		this.lCiudad = lCiudad;
	}

	@Column(name="EMAIL")
	public String getlEmail() {
		return lEmail;
	}

	public void setlEmail(String lEmail) {
		this.lEmail = lEmail;
	}

	@Column(name="CELULAR")
	public String getlCelular() {
		return lCelular;
	}

	public void setlCelular(String lCelular) {
		this.lCelular = lCelular;
	}

	@Column(name="SOLICITUD")
	public String getlSolicitud() {
		return lSolicitud;
	}

	public void setlSolicitud(String lSolicitud) {
		this.lSolicitud = lSolicitud;
	}

	@Column(name="EMAIL_ENVIADO")
	public String getlEmailEnviado() {
		return lEmailEnviado;
	}

	public void setlEmailEnviado(String lEmailEnviado) {
		this.lEmailEnviado = lEmailEnviado;
	}

	@Column(name="USUARIO_DEMO")
	public String getlUsuarioDemoCreado() {
		return lUsuarioDemoCreado;
	}

	public void setlUsuarioDemoCreado(String lUsuarioDemoCreado) {
		this.lUsuarioDemoCreado = lUsuarioDemoCreado;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="CANAL_REGISTRO")
	public CANAL_REGISTRO getlCanalRegistro() {
		return lCanalRegistro;
	}
	
	public void setlCanalRegistro(CANAL_REGISTRO lCanalRegistro) {
		this.lCanalRegistro = lCanalRegistro;
	}
	
	@Column(name="ID_TIPO_PLAN")
	public Long getIdTipoPlan() {
		return idTipoPlan;
	}
	
	public void setIdTipoPlan(Long idTipoPlan) {
		this.idTipoPlan = idTipoPlan;
	}
	
	public enum CANAL_REGISTRO {
	    WEB,
	    APP	
	}
	     
	
	
}
