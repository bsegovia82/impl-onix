package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

//import java.math.BigDecimal;

/**
 * The persistent class for the PRI_OPCIONES database table.
 * 
 */
@Entity
@Table(name = "OMS_OPCIONES")
@NamedQuery(name = "OmsOpcione.findAll", query = "SELECT p FROM OmsOpcione p")
public class OmsOpcione extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String accion;

	private String descripcion;

	private OmsOpcione moduloPadre;

	private String opcion;

	private Long orden;

	private String orientacion;

	private String rutaimagen;

	private String tipo;

	private List<OmsOpcionesRole> priOpcionesRoles;

	private List<OmsOpcione> opcionesHijas;

	public OmsOpcione() {
	}

	@GeneratedValue(generator = "secOpciones", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secOpciones", allocationSize = 1, initialValue = 1, sequenceName = "SEC_OPCIONES")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ACCION")
	/**/
	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	@Column(name = "DESCRIPCION")
	/**/
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@ManyToOne
	@JoinColumn(name = "MODULO_PADRE")
	public OmsOpcione getModuloPadre() {
		return moduloPadre;
	}

	public void setModuloPadre(OmsOpcione moduloPadre) {
		this.moduloPadre = moduloPadre;
	}

	@Column(name = "OPCION")
	public String getOpcion() {
		return this.opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	@Column(name = "ORDEN")
	/**/
	public Long getOrden() {
		return this.orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	@Column(name = "ORIENTACION")
	/**/
	public String getOrientacion() {
		return this.orientacion;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	@Column(name = "RUTAIMAGEN")
	/**/
	public String getRutaimagen() {
		return this.rutaimagen;
	}

	public void setRutaimagen(String rutaimagen) {
		this.rutaimagen = rutaimagen;
	}

	@Column(name = "TIPO")
	/**/
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// bi-directional many-to-one association to PriOpcionesRole
	@OneToMany(mappedBy = "priOpcione")
	public List<OmsOpcionesRole> getPriOpcionesRoles() {
		return this.priOpcionesRoles;
	}

	public void setPriOpcionesRoles(List<OmsOpcionesRole> priOpcionesRoles) {
		this.priOpcionesRoles = priOpcionesRoles;
	}

	public OmsOpcionesRole addPriOpcionesRole(OmsOpcionesRole priOpcionesRole) {
		getPriOpcionesRoles().add(priOpcionesRole);
		priOpcionesRole.setPriOpcione(this);

		return priOpcionesRole;
	}

	public OmsOpcionesRole removePriOpcionesRole(OmsOpcionesRole priOpcionesRole) {
		getPriOpcionesRoles().remove(priOpcionesRole);
		priOpcionesRole.setPriOpcione(null);

		return priOpcionesRole;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "moduloPadre")
	@OrderBy("orden ASC")
	public List<OmsOpcione> getOpcionesHijas() {
		return opcionesHijas;
	}

	public void setOpcionesHijas(List<OmsOpcione> opcionesHijas) {
		this.opcionesHijas = opcionesHijas;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return descripcion;
	}
	
}