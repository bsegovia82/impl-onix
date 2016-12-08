package com.onix.modulo.vista.beans.modulo.aplicacion.empleados;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.dominio.persona.operacion.OmsoCargo;
import com.onix.modulo.eao.persona.operacion.OmsoCargoEAO;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.exceptions.ErrorValidacionVisual;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorRol;
import com.onix.modulo.servicio.mantenimiento.persona.operacion.ServicioMantenedorCargo;

@ManagedBean
@ViewScoped
public class BeanMantenedorCargo
		extends BeanMantenedorGenerico<ServicioMantenedorCargo, Long, OmsoCargo, OmsoCargoEAO> {
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioMantenedorCargo servicioMantenedor;

	@EJB
	private ServicioMantenedorRol servicioMantenedorRol;

	private List<OmsRole> listaRoles;

	protected ServicioMantenedorCargo getServicioMantenedor() {
		return servicioMantenedor;
	}

	public BeanMantenedorCargo() {
		super(new OmsoCargo(), OmsoCargo.class);
		this.entidadRegistrar.setRolDefault(new OmsRole());
	}

	protected void metodoPostErrorTransaccion() {
		System.out.println("Error al realizar la operacion " + this.getClass().getCanonicalName());
	}

	protected void validacionesIngreso() throws ErrorValidacionVisual {
		System.out.println("Sin nada que validar en mantenimiento cargo");
	}

	public void accionesPreTransaccionServicio() {
		System.out.println("Sin acciones que realizar en mantenimiento cargo");
	}

	@Override
	public String getTituloPagina() {
		// TODO Auto-generated method stub
		return "Mantenimiento Cargo";
	}

	@Override
	public String getDescripcionPagina() {
		// TODO Auto-generated method stub
		return "Mantenedor Cargo";
	}

	@Override
	public String getAyudaPagina() {
		// TODO Auto-generated method stub
		return "Cree o edite Cargos";
	}

	@Override
	public String getTab() {
		// TODO Auto-generated method stub
		return "Datos Cargo";
	}

	@Override
	public String getCabeceraTabla() {
		// TODO Auto-generated method stub
		return "Cargos registrados";
	}

	@Override
	protected void metodoPostTransaccion() {
		super.metodoPostTransaccion();// trae la lista de entidades
		// EstPaciente obj = new EstPaciente();
		// OmsgPersona persona = new OmsgPersona();
		// obj.setPersona(persona);
		// setEntidadRegistrar(obj);
		this.entidadRegistrar = new OmsoCargo();
		this.entidadRegistrar.setRolDefault(new OmsRole());
	}

	@Override
	public String getMensajeTablaVacia() {
		// TODO Auto-generated method stub
		return JsfUtil.MENSAJE_INFO_SINRESULTADO;
	}

	@Override
	public String getCabeceraDialogo() {
		// TODO Auto-generated method stub
		return "Actualización de Cargo";
	}

	@Override
	public String getCabeceraPanelDialogo() {
		// TODO Auto-generated method stub
		return "Datos Cargo";
	}

	@Override
	protected void metodoPostConstruct() {
		listaRoles = servicioMantenedorRol.listaObjetosActivos(OmsRole.class);
	}

	@Override
	protected void postSeleccionRegistro(OmsoCargo entidadRegistrar2) {

	}

	public List<OmsRole> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<OmsRole> listaRoles) {
		this.listaRoles = listaRoles;
	}

}
