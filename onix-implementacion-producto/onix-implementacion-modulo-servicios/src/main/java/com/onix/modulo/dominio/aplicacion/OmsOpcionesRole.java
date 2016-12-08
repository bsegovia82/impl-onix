package com.onix.modulo.dominio.aplicacion;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

//import java.math.BigDecimal;

/**
 * The persistent class for the PRI_OPCIONES_ROLES database table.
 * 
 */
//PRI
@Entity
@Table(name = "OMS_OPCIONES_ROLES")
@NamedNativeQueries(@NamedNativeQuery(name = "OPCIONES_ROLES.OPCIONES_PADRE", query = "select * "
		+ " from OMS_OPCIONES d " 
		+ " where exists (select 'X' " 
		+ "        from oms_opciones_roles s "
		+ "       where exists (select 'X' " + "                from oms_usuarios_ROLES t "
		+ "               where t.id_usuario = ? " + "                 and t.estado = 'A' "
		+ "                 and t.id_rol = s.id_rol) " + "         and s.estado = 'A' "
		+ "         and s.id_opcion = d.id) " 
		+ " and d.modulo_padre is null " 
		+ " and d.estado = 'A'"
		+ " and d.orientacion = ? order by d.orden asc", resultClass = OmsOpcione.class))
public class OmsOpcionesRole extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private OmsRole idRol;

	private OmsOpcione priOpcione;

	public OmsOpcionesRole() {
	}

	@GeneratedValue(generator = "secOpcionesRol", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secOpcionesRol", allocationSize = 1, initialValue = 1, sequenceName = "SEC_OPCIONESROL")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "ID_ROL")
	public OmsRole getIdRol() {
		return idRol;
	}

	public void setIdRol(OmsRole idRol) {
		this.idRol = idRol;
	}

	@ManyToOne
	@JoinColumn(name = "ID_OPCION")
	public OmsOpcione getPriOpcione() {
		return this.priOpcione;
	}

	public void setPriOpcione(OmsOpcione priOpcione) {
		this.priOpcione = priOpcione;
	}

}