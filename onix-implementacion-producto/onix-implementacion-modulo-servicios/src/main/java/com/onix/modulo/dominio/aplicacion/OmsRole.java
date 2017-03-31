package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

/**
 * The persistent class for the PRI_ROLES database table.
 * 
 */
@Entity
@Table(name = "OMS_ROLES")
@NamedQuery(name = "OmsRole.findAll", query = "SELECT p FROM OmsRole p")
public class OmsRole extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String aplicaAud;

	private String rol;

	private String tipoRol;
	
	

	private List<OmsOpcionesRole> listaOpcionesRoles;

	// bi-directional many-to-one association to PriUsuariosRole

	private List<OmsUsuariosRole> priUsuariosRoles;
	
	private String lPaginaPrincipal;

	public OmsRole() {
	}

	@GeneratedValue(generator = "secRole", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secRole", allocationSize = 1, initialValue = 1, sequenceName = "SEC_ROLE")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "APLICA_AUD")
	public String getAplicaAud() {
		return this.aplicaAud;
	}

	public void setAplicaAud(String aplicaAud) {
		this.aplicaAud = aplicaAud;
	}

	@Column(name = "ROL")
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Column(name = "TIPO_ROL")
	public String getTipoRol() {
		return this.tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}

	@OneToMany(mappedBy = "priRole")
	public List<OmsUsuariosRole> getPriUsuariosRoles() {
		return this.priUsuariosRoles;
	}

	public void setPriUsuariosRoles(List<OmsUsuariosRole> priUsuariosRoles) {
		this.priUsuariosRoles = priUsuariosRoles;
	}

	public OmsUsuariosRole addPriUsuariosRole(OmsUsuariosRole priUsuariosRole) {
		getPriUsuariosRoles().add(priUsuariosRole);
		priUsuariosRole.setPriRole(this);

		return priUsuariosRole;
	}

	public OmsUsuariosRole removePriUsuariosRole(OmsUsuariosRole priUsuariosRole) {
		getPriUsuariosRoles().remove(priUsuariosRole);
		priUsuariosRole.setPriRole(null);

		return priUsuariosRole;
	}

	@OneToMany(mappedBy = "idRol")
	public List<OmsOpcionesRole> getListaOpcionesRoles() {
		return listaOpcionesRoles;
	}

	public void setListaOpcionesRoles(List<OmsOpcionesRole> listaOpcionesRoles) {
		this.listaOpcionesRoles = listaOpcionesRoles;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.rol;
	}

	public void agregarOpcionesRoles(OmsOpcionesRole opcionRole) {
		if (listaOpcionesRoles == null) 
		{
			listaOpcionesRoles = new ArrayList<>();
		}
		opcionRole.setIdRol(this);
		this.listaOpcionesRoles.add(opcionRole);
	}

	public void agregarOpcionesRoles(List<OmsOpcionesRole> opcionesRoles) {
		for (OmsOpcionesRole opcionRol : opcionesRoles) {
			agregarOpcionesRoles(opcionRol);
		}
	}

	public void agregarOpciones(List<OmsOpcione> opciones) {
		for (OmsOpcione opcion : opciones) {
			OmsOpcionesRole opcionesRoles = new OmsOpcionesRole();
			opcionesRoles.setEstado("A");
			opcionesRoles.setFechaRegistro(new Date());
			opcionesRoles.setObservacion("DESCRIPCION ASIGNACION: " + this.getRol() + " - " + opcion.getDescripcion());
			opcionesRoles.setPriOpcione(opcion);
			agregarOpcionesRoles(opcionesRoles);
		}
	}

	public void agregarOpciones(OmsOpcione opcion) {

		OmsOpcionesRole opcionesRoles = new OmsOpcionesRole();
		opcionesRoles.setEstado("A");
		opcionesRoles.setFechaRegistro(new Date());
		opcionesRoles.setObservacion("DESCRIPCION ASIGNACION: " + this.getRol() + " - " + opcion.getDescripcion());
		opcionesRoles.setPriOpcione(opcion);
		agregarOpcionesRoles(opcionesRoles);

	}
	
	@Column(name="PAGINA_PRINCIPAL")
	public String getlPaginaPrincipal() {
		return lPaginaPrincipal;
	}
	
	public void setlPaginaPrincipal(String lPaginaPrincipal) {
		this.lPaginaPrincipal = lPaginaPrincipal;
	}

	
	
}