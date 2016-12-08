package com.onix.modulo.dominio.persona.operacion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.onix.modulo.dominio.persona.OmsgPersona;
import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;

@Entity
@Table(name = "OMSO_EMPLEADO")
public class OmsoEmpleado extends EntidadBaseAuditable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codigoEmpleado;

	private OmsoCargo cargo;

	private Date fechaInicio;

	private Date fechaFin;

	private OmsoEmpleado jefe;

	private List<OmsoEmpleado> subOrdinados;

	private OmsoEspecialidad especialidad;

	private OmsgPersona persona;

	@GeneratedValue(generator = "secEmpleado", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "secEmpleado", allocationSize = 1, initialValue = 1, sequenceName = "SEC_EMPLEADO")
	@Id
	@Column(name = "ID")
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(Long arg0) {
		// TODO Auto-generated method stub
		id = arg0;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CARGO")
	public OmsoCargo getCargo() {
		return cargo;
	}

	public void setCargo(OmsoCargo cargo) {
		this.cargo = cargo;
	}

	@ManyToOne
	@JoinColumn(name = "ID_ESPECIALIDAD")
	public OmsoEspecialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(OmsoEspecialidad especialidad) {
		this.especialidad = especialidad;
	}

	@ManyToOne
	@JoinColumn(name = "ID_JEFE")
	public OmsoEmpleado getJefe() {
		return jefe;
	}

	public void setJefe(OmsoEmpleado jefe) {
		this.jefe = jefe;
	}

	@OneToMany(mappedBy = "jefe")
	public List<OmsoEmpleado> getSubOrdinados() {
		return subOrdinados;
	}

	public void setSubOrdinados(List<OmsoEmpleado> subOrdinados) {
		this.subOrdinados = subOrdinados;
	}

	@Column(name = "CODIGO_EMPLEADO")
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}

	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INGRESO")
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_SALIDA")
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@OneToOne
	@JoinColumn(name = "ID_PERSONA", nullable = true)
	public OmsgPersona getPersona() {
		return persona;
	}

	public void setPersona(OmsgPersona persona) {
		this.persona = persona;
	}
}
