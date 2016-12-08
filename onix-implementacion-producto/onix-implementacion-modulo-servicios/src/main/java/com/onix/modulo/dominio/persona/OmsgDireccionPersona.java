package com.onix.modulo.dominio.persona;

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
import javax.persistence.Transient;



import com.onix.modulo.dominio.localizacion.OmslCanton;
import com.onix.modulo.dominio.localizacion.OmslPais;
import com.onix.modulo.dominio.localizacion.OmslProvincia;
import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name="OMSG_DIRECCIONES_PERSONA")
public class OmsgDireccionPersona extends EntidadBaseAuditable<Long> implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OmslCanton canton;
	private OmsgTipoDireccion tipoDireccion;
	private OmsgPersona persona;
	private String direccion;
	private String referencia;

	@GeneratedValue(generator = "secDireccionPersona", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secDireccionPersona", allocationSize = 1, initialValue = 1, sequenceName = "SEC_DIR_PERSONA")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@ManyToOne
	@JoinColumn(name="ID_CANTON",nullable=false)
	public OmslCanton getCanton() {
		return canton;
	}

	public void setCanton(OmslCanton canton) {
		this.canton = canton;
	}

	@ManyToOne
	@JoinColumn(name="ID_TIPO_DIRECCION",nullable=false)
	public OmsgTipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(OmsgTipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	@ManyToOne
	@JoinColumn(name="ID_PERSONA",nullable=false)
	public OmsgPersona getPersona() {
		return persona;
	}

	public void setPersona(OmsgPersona persona) {
		this.persona = persona;
	}

	
	@Column(name="DIRECCION",length=512,nullable=false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	@Column(name="REFERENCIA",length=512,nullable=true)
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	@Transient
	public OmslProvincia getProvincia() {
		try{
			return getCanton().getProvincia();
		}catch (NullPointerException e) {
			return null;
		}
	}

	public void setProvincia(OmslProvincia provincia) {
		try{
			getCanton().setProvincia(provincia);
		}catch (NullPointerException e) {
		}
	}
	
	@Transient
	public OmslPais getPais() {
		try{
			return getProvincia().getPais();
		}catch (NullPointerException e) {
			return null;
		}
	}

	public void setPais(OmslPais pais) {
		try{
			getProvincia().setPais(pais);
		}catch (NullPointerException e) {
		}
	}

	
	
	

	
	
}
