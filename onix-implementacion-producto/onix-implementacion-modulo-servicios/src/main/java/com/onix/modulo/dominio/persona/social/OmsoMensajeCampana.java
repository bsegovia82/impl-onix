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
@Table(name="OMSO_CARGOS_EMPLEADOS")
public class OmsoMensajeCampana extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String lMensajeCampana;
	private OmsoConfiguracionNotificacionAutomatica lConfiguracionNotificacion;	
	
	@GeneratedValue(generator = "secMensaje", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secMensaje", allocationSize = 1, initialValue = 1, sequenceName = "SEC_MENSAJE_CAMPANA")
	@Id
	@Column(name = "ID")
	@Override
	public Long getId() {
		return id;
	}
	
	@Column(name="MENSAJE")
	public String getlMensajeCampana() {
		return lMensajeCampana;
	}
	public void setlMensajeCampana(String lMensajeCampana) {
		this.lMensajeCampana = lMensajeCampana;
	}

	@ManyToOne
	@JoinColumn(name="ID_CONFIGURACION")
	public OmsoConfiguracionNotificacionAutomatica getlConfiguracionNotificacion() {
		return lConfiguracionNotificacion;
	}
	public void setlConfiguracionNotificacion(OmsoConfiguracionNotificacionAutomatica lConfiguracionNotificacion) {
		this.lConfiguracionNotificacion = lConfiguracionNotificacion;
	}
	
}
