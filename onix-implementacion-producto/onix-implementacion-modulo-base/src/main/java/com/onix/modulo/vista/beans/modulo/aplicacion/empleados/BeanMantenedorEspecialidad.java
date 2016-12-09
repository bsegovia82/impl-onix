package com.onix.modulo.vista.beans.modulo.aplicacion.empleados;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onix.modulo.dominio.persona.operacion.OmsoEspecialidad;
import com.onix.modulo.eao.persona.operacion.OmsoEspecialidadEAO;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.exceptions.ErrorValidacionVisual;
import com.onix.modulo.servicio.mantenimiento.persona.operacion.ServicioMantenedorEspecialidad;

@ManagedBean
@ViewScoped
public class BeanMantenedorEspecialidad extends BeanMantenedorGenerico<ServicioMantenedorEspecialidad, Long, OmsoEspecialidad, OmsoEspecialidadEAO> {
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioMantenedorEspecialidad servicioMantenedor;

	protected ServicioMantenedorEspecialidad getServicioMantenedor() {
		return servicioMantenedor;
	}

	public BeanMantenedorEspecialidad() {
		super(new OmsoEspecialidad(), OmsoEspecialidad.class);
	}

	protected void metodoPostErrorTransaccion() {
		System.out.println("Error al realizar la operacion " + this.getClass().getCanonicalName());
	}

	protected void validacionesIngreso() throws ErrorValidacionVisual {
		System.out.println("Sin nada que validar en mantenimiento especialidad");	
	}

	@Override
	public void accionesPreTransaccionServicio() {
		System.out.println("Sin acciones que realizar en mantenimiento cargo");
		
	}
	
	@Override
	public String getTituloPagina() {
		// TODO Auto-generated method stub
		return "Mantenimiento Especialidad";
	}

	@Override
	public String getDescripcionPagina() {
		// TODO Auto-generated method stub
		return "Mantenedor Especialidad";
	}

	@Override
	public String getAyudaPagina() {
		// TODO Auto-generated method stub
		return "Cree o edite Especialidad";
	}

	@Override
	public String getTab() {
		// TODO Auto-generated method stub
		return "Datos Especialidad";
	}

	@Override
	public String getCabeceraTabla() {
		// TODO Auto-generated method stub
		return "Empleados Especialidad";
	}

	@Override
	protected void metodoPostTransaccion() {
		super.metodoPostTransaccion();// trae la lista de entidades
		// EstPaciente obj = new EstPaciente();
		// OmsgPersona persona = new OmsgPersona();
		// obj.setPersona(persona);
		// setEntidadRegistrar(obj);
		this.entidadRegistrar = new OmsoEspecialidad();
	}

	@Override
	public String getMensajeTablaVacia() {
		// TODO Auto-generated method stub
		return JsfUtil.MENSAJE_INFO_SINRESULTADO;
	}

	@Override
	public String getCabeceraDialogo() {
		// TODO Auto-generated method stub
		return "Actualización de Especialidad";
	}

	@Override
	public String getCabeceraPanelDialogo() {
		// TODO Auto-generated method stub
		return "Datos Especialidad";
	}

	@Override
	protected void metodoPostConstruct() {
	}

	@Override
	protected void postSeleccionRegistro(OmsoEspecialidad entidadRegistrar2) {

	}

	

}
