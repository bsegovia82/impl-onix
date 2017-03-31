package com.onix.modulo.dominio.persona.social;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name="OMSO_CUENTAS_RED_SOCIAL")
public class OmsoCuentaRedSocial extends EntidadBaseAuditable<Long> implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String lUsuarioRedSocial;
	private String lClaveUsuarioRedSocial;
	private String lEmailAsociadoCuenta;
	private String lCelularAsociadoCuenta;
	private RED_SOCIAL lTipoRed;
	private List<OmsoCredencialRegistradaCuenta> lListaAplicacionesCuenta;
	
	
	@GeneratedValue(generator = "secCuenta", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secCuenta", allocationSize = 1, initialValue = 1, sequenceName = "SEC_CUENTA_RED_SOC")
	@Id
	@Column(name = "ID")
	@Override
	public Long getId() {
		return id;
	}

	@Column(name="USUARIO_RED_SOCIAL")
	public String getlUsuarioRedSocial() {
		return lUsuarioRedSocial;
	}

	public void setlUsuarioRedSocial(String lUsuarioRedSocial) {
		this.lUsuarioRedSocial = lUsuarioRedSocial;
	}

	@Column(name="CLAVE_RED_SOCIAL")
	public String getlClaveUsuarioRedSocial() {
		return lClaveUsuarioRedSocial;
	}

	public void setlClaveUsuarioRedSocial(String lClaveUsuarioRedSocial) {
		this.lClaveUsuarioRedSocial = lClaveUsuarioRedSocial;
	}

	

	@Column(name="EMAIL_CUENTA")
	public String getlEmailAsociadoCuenta() {
		return lEmailAsociadoCuenta;
	}

	public void setlEmailAsociadoCuenta(String lEmailAsociadoCuenta) {
		this.lEmailAsociadoCuenta = lEmailAsociadoCuenta;
	}

	@Column(name="CELULAR_CUENTA")
	public String getlCelularAsociadoCuenta() {
		return lCelularAsociadoCuenta;
	}

	public void setlCelularAsociadoCuenta(String lCelularAsociadoCuenta) {
		this.lCelularAsociadoCuenta = lCelularAsociadoCuenta;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_RED_SOCIAL")
	public RED_SOCIAL getlTipoRed() {
		return lTipoRed;
	}
	
	public void setlTipoRed(RED_SOCIAL lTipoRed) {
		this.lTipoRed = lTipoRed;
	}
	
	@OneToMany(mappedBy="lCuentaRedSocial")
	public List<OmsoCredencialRegistradaCuenta> getlListaAplicacionesCuenta() {
		return lListaAplicacionesCuenta;
	}
	
	public void setlListaAplicacionesCuenta(List<OmsoCredencialRegistradaCuenta> lListaAplicacionesCuenta) {
		this.lListaAplicacionesCuenta = lListaAplicacionesCuenta;
	}
	
	
}
