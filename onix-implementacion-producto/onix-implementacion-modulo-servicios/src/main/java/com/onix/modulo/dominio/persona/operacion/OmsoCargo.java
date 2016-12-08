package com.onix.modulo.dominio.persona.operacion;

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

import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;


@Entity
@Table(name="OMSO_CARGOS_EMPLEADOS")
public class OmsoCargo extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nombreCargo;
	
	private OmsRole rolDefault;
	
	@GeneratedValue(generator = "secCargo", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secCargo", allocationSize = 1, initialValue = 1, sequenceName = "SEC_CARGO_EMPLEADO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id =  id;
	}
	
	@Column(name="NOMBRE_CARGO")
	public String getNombreCargo() {
		return nombreCargo;
	}
	
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo = nombreCargo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombreCargo;
	}
	
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	public OmsRole getRolDefault() {
		return rolDefault;
	}
	
	public void setRolDefault(OmsRole rolDefault) {
		this.rolDefault = rolDefault;
	}
}
