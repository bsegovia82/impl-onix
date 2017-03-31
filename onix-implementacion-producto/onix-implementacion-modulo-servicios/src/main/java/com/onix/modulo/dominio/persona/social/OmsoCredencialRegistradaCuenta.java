package com.onix.modulo.dominio.persona.social;

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
@Table(name="OMSO_APLICACION_RED_SOCIAL")
public class OmsoCredencialRegistradaCuenta extends EntidadBaseAuditable<Long> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lCustomerKey;
	private String lCustomerSecret;
	private String lAccessTokenId;
	private String lAccessTokenSecret;
	private List<OmsoCuentaCampana> lListaConfiguracion;
	private OmsoCuentaRedSocial lCuentaRedSocial;
	
	@GeneratedValue(generator = "secAppCuenta", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secAppCuenta", allocationSize = 1, initialValue = 1, sequenceName = "SEC_APP_CUENTA_RED_SOC")
	@Id
	@Column(name = "ID")
	@Override
	public Long getId() {
		return id;
	}
	
	@Column(name="CUSTOMER_KEY")
	public String getlCustomerKey() {
		return lCustomerKey;
	}

	public void setlCustomerKey(String lCustomerKey) {
		this.lCustomerKey = lCustomerKey;
	}

	@Column(name="CUSTOMER_SECRET")
	public String getlCustomerSecret() {
		return lCustomerSecret;
	}

	public void setlCustomerSecret(String lCustomerSecret) {
		this.lCustomerSecret = lCustomerSecret;
	}

	@Column(name="ACCESS_TOKEN_ID")
	public String getlAccessTokenId() {
		return lAccessTokenId;
	}

	public void setlAccessTokenId(String lAccessTokenId) {
		this.lAccessTokenId = lAccessTokenId;
	}

	@Column(name="ACCESS_TOKEN_SECRET")
	public String getlAccessTokenSecret() {
		return lAccessTokenSecret;
	}

	public void setlAccessTokenSecret(String lAccessTokenSecret) {
		this.lAccessTokenSecret = lAccessTokenSecret;
	}
	
	@OneToMany(mappedBy="lCuentaRedSocial")
	public List<OmsoCuentaCampana> getlListaConfiguracion() {
		return lListaConfiguracion;
	}
	
	public void setlListaConfiguracion(List<OmsoCuentaCampana> lListaConfiguracion) {
		this.lListaConfiguracion = lListaConfiguracion;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_CUENTA_RED_SOCIAL")
	public OmsoCuentaRedSocial getlCuentaRedSocial() {
		return lCuentaRedSocial;
	}
	
	public void setlCuentaRedSocial(OmsoCuentaRedSocial lCuentaRedSocial) {
		this.lCuentaRedSocial = lCuentaRedSocial;
	}
}
