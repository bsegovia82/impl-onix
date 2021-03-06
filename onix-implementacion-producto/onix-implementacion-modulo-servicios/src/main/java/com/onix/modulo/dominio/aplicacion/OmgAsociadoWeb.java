package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMG_ASOCIADO_WEB")
@NamedQuery(name = "OmgAsociadoWeb.findAll", query = "SELECT p FROM OmgAsociadoWeb p")
public class OmgAsociadoWeb extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String lIdSolicitud;
	private String lResponsable;
	private String lTelefonoContacto;
	private String lEmailResponsable;
	private Integer lVigenciaMeses;
	private String lUsuarioAdministrador;
	private String lClaveAdministrador;
	private String lRolAsignado;
	private TIPO_ASOCIADO lTipoAsociado; 
	private Date lFechaInicio;
	private Date lFechaFinal;
	private Integer lNumeroEmpresas;
	private Integer lNumeroUsuarios;
	private Integer lNumeroTransacciones;
	
	
	public OmgAsociadoWeb() {
	}

	@Override
	@GeneratedValue(generator = "secAsociadoWeb", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secAsociadoWeb", allocationSize = 1, initialValue = 1, sequenceName = "SEC_ASOCIADO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	
	@Column(name="ID_SOLICITUD")
	public String getlIdSolicitud() {
		return lIdSolicitud;
	}

	public void setlIdSolicitud(String lIdSolicitud) {
		this.lIdSolicitud = lIdSolicitud;
	}

	@Column(name="NOMBRE_RESPONSABLE")
	public String getlResponsable() {
		return lResponsable;
	}

	public void setlResponsable(String lResponsable) {
		this.lResponsable = lResponsable;
	}
	
	@Column(name="EMAIL_RESPONSABLE")
	public String getlEmailResponsable() {
		return lEmailResponsable;
	}
	
	public void setlEmailResponsable(String lEmailResponsable) {
		this.lEmailResponsable = lEmailResponsable;
	}

	@Column(name="TELEFONO_RESPONSABLE")
	public String getlTelefonoContacto() {
		return lTelefonoContacto;
	}

	public void setlTelefonoContacto(String lTelefonoContacto) {
		this.lTelefonoContacto = lTelefonoContacto;
	}

	@Column(name="VIGENCIA_MESES")
	public Integer getlVigenciaMeses() {
		return lVigenciaMeses;
	}

	public void setlVigenciaMeses(Integer lVigenciaMeses) {
		this.lVigenciaMeses = lVigenciaMeses;
	}

	@Column(name="USUARIO_ADMINISTRADOR")
	public String getlUsuarioAdministrador() {
		return lUsuarioAdministrador;
	}

	public void setlUsuarioAdministrador(String lUsuarioAdministrador) {
		this.lUsuarioAdministrador = lUsuarioAdministrador;
	}
	
	@Column(name="CLAVE_ADMINISTRADOR")
	public String getlClaveAdministrador() {
		return lClaveAdministrador;
	}
	
	public void setlClaveAdministrador(String lClaveAdministrador) {
		this.lClaveAdministrador = lClaveAdministrador;
	}

	@Column(name="ROL_ASIGNADO")
	public String getlRolAsignado() {
		return lRolAsignado;
	}

	public void setlRolAsignado(String lRolAsignado) {
		this.lRolAsignado = lRolAsignado;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_ASOCIADO")
	public TIPO_ASOCIADO getlTipoAsociado() {
		return lTipoAsociado;
	}

	public void setlTipoAsociado(TIPO_ASOCIADO lTipoAsociado) {
		this.lTipoAsociado = lTipoAsociado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INICIO")
	public Date getlFechaInicio() {
		return lFechaInicio;
	}

	public void setlFechaInicio(Date lFechaInicio) {
		this.lFechaInicio = lFechaInicio;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_FIN")
	public Date getlFechaFinal() {
		return lFechaFinal;
	}

	public void setlFechaFinal(Date lFechaFinal) {
		this.lFechaFinal = lFechaFinal;
	}

	@Column(name="NUMERO_EMPRESAS")
	public Integer getlNumeroEmpresas() {
		return lNumeroEmpresas;
	}

	public void setlNumeroEmpresas(Integer lNumeroEmpresas) {
		this.lNumeroEmpresas = lNumeroEmpresas;
	}

	@Column(name="NUMERO_USUARIOS")
	public Integer getlNumeroUsuarios() {
		return lNumeroUsuarios;
	}

	public void setlNumeroUsuarios(Integer lNumeroUsuarios) {
		this.lNumeroUsuarios = lNumeroUsuarios;
	}

	@Column(name="NUMERO_TRANSACCIONES")
	public Integer getlNumeroTransacciones() {
		return lNumeroTransacciones;
	}

	public void setlNumeroTransacciones(Integer lNumeroTransacciones) {
		this.lNumeroTransacciones = lNumeroTransacciones;
	}

	public enum TIPO_ASOCIADO {
	    DEMOSTRADO,
	    COMUNITARIO,
	    CONTRATADO	}
}
