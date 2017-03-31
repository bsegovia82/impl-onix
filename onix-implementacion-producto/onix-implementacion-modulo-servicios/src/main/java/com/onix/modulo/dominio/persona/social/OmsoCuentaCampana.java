package com.onix.modulo.dominio.persona.social;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;


@Entity
@Table(name="OMSO_CUENTAS_CAMPANA")
public class OmsoCuentaCampana extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private OmsoConfiguracionNotificacionAutomatica lConfiguracion;
	private OmsoCredencialRegistradaCuenta lCuentaRedSocial;
	
	
	@GeneratedValue(generator = "secCuentaCampana", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secCuentaCampana", allocationSize = 1, initialValue = 1, sequenceName = "SEC_CUENTA_CAMPANA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}


	@ManyToOne
	@JoinColumn(name="ID_CONFIGURACION")
	public OmsoConfiguracionNotificacionAutomatica getlConfiguracion() {
		return lConfiguracion;
	}


	public void setlConfiguracion(OmsoConfiguracionNotificacionAutomatica lConfiguracion) {
		this.lConfiguracion = lConfiguracion;
	}


	@ManyToOne
	@JoinColumn(name="ID_CUENTA_RED")
	public OmsoCredencialRegistradaCuenta getlCuentaRedSocial() {
		return lCuentaRedSocial;
	}


	public void setlCuentaRedSocial(OmsoCredencialRegistradaCuenta lCuentaRedSocial) {
		this.lCuentaRedSocial = lCuentaRedSocial;
	}
	
	
	
	
}
