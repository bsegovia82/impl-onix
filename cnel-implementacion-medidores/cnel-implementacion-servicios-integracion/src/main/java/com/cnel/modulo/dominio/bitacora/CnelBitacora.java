package com.cnel.modulo.dominio.bitacora;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "CNEL_BITACORA")
@NamedQuery(name = "CnelBitacora.findAll", query = "SELECT p FROM CnelBitacora p")
public class CnelBitacora extends EntidadBaseAuditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String lDescripcionEvento;
	private String lValorAlterado;
	
	@GeneratedValue(generator = "secBitacoraEjecucion", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secBitacoraEjecucion", allocationSize = 1, initialValue = 1, sequenceName = "SEC_BIT_EJECUCION")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	@Column(name = "DESCRIPCION_EVENTO")
	public String getlDescripcionEvento() {
		return lDescripcionEvento;
	}

	public void setlDescripcionEvento(String lDescripcionEvento) {
		this.lDescripcionEvento = lDescripcionEvento;
	}

	@Column(name = "VALOR_ALTERADO")
	public String getlValorAlterado() {
		return lValorAlterado;
	}

	public void setlValorAlterado(String lValorAlterado) {
		this.lValorAlterado = lValorAlterado;
	}		
	
}
