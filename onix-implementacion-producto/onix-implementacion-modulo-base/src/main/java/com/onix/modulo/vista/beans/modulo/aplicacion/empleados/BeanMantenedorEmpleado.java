package com.onix.modulo.vista.beans.modulo.aplicacion.empleados;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.dominio.persona.OmsgPersona;
import com.onix.modulo.dominio.persona.OmsgTipoDocumentoIdentificacion;
import com.onix.modulo.dominio.persona.operacion.OmsoCargo;
import com.onix.modulo.dominio.persona.operacion.OmsoEmpleado;
import com.onix.modulo.dominio.persona.operacion.OmsoEspecialidad;
import com.onix.modulo.eao.persona.operacion.OmsoEmpleadoEAO;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.exceptions.ErrorValidacionVisual;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;
import com.onix.modulo.servicio.mantenimiento.persona.operacion.ServicioMantenedorEmpleado;

@ManagedBean
@ViewScoped
public class BeanMantenedorEmpleado
		extends BeanMantenedorGenerico<ServicioMantenedorEmpleado, Long, OmsoEmpleado, OmsoEmpleadoEAO> {
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioMantenedorEmpleado servicioMantenedor;

	@EJB
	private ServicioMantenedorUsuario servicioMantenedorUsuario;

	private List<OmsoCargo> listaCargos;

	private List<OmsoEspecialidad> listaEspecialidad;

	protected ServicioMantenedorEmpleado getServicioMantenedor() {
		return servicioMantenedor;
	}

	public BeanMantenedorEmpleado() {
		super(new OmsoEmpleado(), OmsoEmpleado.class);
		OmsgTipoDocumentoIdentificacion tipoDoc = new OmsgTipoDocumentoIdentificacion();
		OmsgPersona persona = new OmsgPersona();
		persona.setUsuario(new OmsUsuario());
		entidadRegistrar.setPersona(persona);
		entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
		OmsoCargo cargo = new OmsoCargo();
		OmsoEspecialidad especialidad = new OmsoEspecialidad();
		entidadRegistrar.setCargo(cargo);
		entidadRegistrar.setEspecialidad(especialidad);

	}

	protected void metodoPostErrorTransaccion() {
		System.out.println("Error al realizar la operacion " + this.getClass().getCanonicalName());
	}

	protected void validacionesIngreso() throws ErrorValidacionVisual {
		System.out.println("Sin nada que validar en mantenimiento empleado");
	}

	public void accionesPreTransaccionServicio() {
		System.out.println("Sin acciones que realizar en mantenimiento empleado");

	}

	@Override
	public String getTituloPagina() {
		// TODO Auto-generated method stub
		return "Mantenimiento Empleado";
	}

	@Override
	public String getDescripcionPagina() {
		// TODO Auto-generated method stub
		return "Mantenedor Empleado";
	}

	@Override
	public String getAyudaPagina() {
		// TODO Auto-generated method stub
		return "Cree o edite Empleados";
	}

	@Override
	public String getTab() {
		// TODO Auto-generated method stub
		return "Datos Empleados";
	}

	@Override
	public String getCabeceraTabla() {
		// TODO Auto-generated method stub
		return "Empleados registrados";
	}

	@Override
	protected void metodoPostTransaccion() {
		super.metodoPostTransaccion();// trae la lista de entidades
		// EstPaciente obj = new EstPaciente();
		// OmsgPersona persona = new OmsgPersona();
		// obj.setPersona(persona);
		// setEntidadRegistrar(obj);
		this.entidadRegistrar = new OmsoEmpleado();
		OmsgTipoDocumentoIdentificacion tipoDoc = new OmsgTipoDocumentoIdentificacion();
		OmsgPersona persona = new OmsgPersona();
		OmsoCargo cargo = new OmsoCargo();
		OmsoEspecialidad especialida = new OmsoEspecialidad();
		persona.setUsuario(new OmsUsuario());
		entidadRegistrar.setPersona(persona);
		entidadRegistrar.getPersona().setTipoDocumentoIdentificacion(tipoDoc);
		entidadRegistrar.setCargo(cargo);
		entidadRegistrar.setEspecialidad(especialida);
	}

	@Override
	public String getMensajeTablaVacia() {
		// TODO Auto-generated method stub
		return JsfUtil.MENSAJE_INFO_SINRESULTADO;
	}

	@Override
	public String getCabeceraDialogo() {
		// TODO Auto-generated method stub
		return "Actualización de Empleados";
	}

	@Override
	public String getCabeceraPanelDialogo() {
		// TODO Auto-generated method stub
		return "Datos Empleado";
	}

	@Override
	protected void metodoPostConstruct() {
		// TODO Auto-generated method stub
		try {
			listaCargos = servicioMantenedor.obtenerListaCargos();

		} catch (Throwable e) {
			listaCargos = new ArrayList<>();
			e.printStackTrace();
		}
		try {
			listaEspecialidad = servicioMantenedor.obtenerListaEspecialidad();
		} catch (Throwable e) {
			listaEspecialidad = new ArrayList<>();
		}
	}

	public List<OmsoCargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<OmsoCargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	public List<OmsoEspecialidad> getListaEspecialidad() {
		return listaEspecialidad;
	}

	public void setListaEspecialidad(List<OmsoEspecialidad> listaEspecialidad) {
		this.listaEspecialidad = listaEspecialidad;
	}

	@Override
	protected void postSeleccionRegistro(OmsoEmpleado entidadRegistrar2) {

	}

	public void buscarCodigoDisponible(AjaxBehaviorEvent event) {
		OmsoEmpleado empleadoBase = servicioMantenedor.obtenerObjetoPropiedad("codigoEmpleado",
				this.entidadRegistrar.getCodigoEmpleado(), OmsoEmpleado.class);

		if (empleadoBase != null) {
			addMensaje("Ya se encuentra registrado un empleado con el codigo : "
					+ this.entidadRegistrar.getCodigoEmpleado());
			this.entidadRegistrar.setCodigoEmpleado("");
		}

	}

	public void buscarUsuarioDisponible(AjaxBehaviorEvent event) {
		OmsUsuario usuarioBase = servicioMantenedorUsuario.obtenerObjetoPropiedad("usuario",
				this.entidadRegistrar.getPersona().getUsuario().getUsuario(), OmsUsuario.class);

		if (usuarioBase != null) {
			addMensaje("Ya se encuentra registrado el usuario : "
					+ this.entidadRegistrar.getPersona().getUsuario().getUsuario());
			this.entidadRegistrar.getPersona().setUsuario(new OmsUsuario());
		}
	}

	public void buscarPersonaIdentificacion(AjaxBehaviorEvent event) {

		OmsgPersona persona = servicioMantenedor
				.buscarPersonaIdentificacion(this.entidadRegistrar.getPersona().getNumeroDocumento());
		if (persona != null) {
			if (servicioMantenedor
					.buscarEmpleadoPorIdentificacion(this.entidadRegistrar.getPersona().getNumeroDocumento()) == null) {
				entidadRegistrar = servicioMantenedor
						.cargarEmpleadoPorIdentificacion(this.entidadRegistrar.getPersona().getNumeroDocumento());
				entidadRegistrar.setEstado(persona.getEstado());
			} else {
				this.entidadRegistrar.getPersona().setNumeroDocumento("");
				addMensaje("Ya se encuentra registrado un empleado con el número de identificación: "
						+ this.entidadRegistrar.getPersona().getNumeroDocumento());
			}
		}
		else
		{
			System.out.println("No hay persona registrada");
		}
	}

}