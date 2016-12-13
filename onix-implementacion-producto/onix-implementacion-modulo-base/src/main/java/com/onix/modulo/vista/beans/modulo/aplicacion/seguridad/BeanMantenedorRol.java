package com.onix.modulo.vista.beans.modulo.aplicacion.seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsOpcionesRole;
import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.eao.aplicacion.OmsRoleEAO;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.exceptions.ErrorValidacionVisual;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorRol;

@ManagedBean
@ViewScoped
public class BeanMantenedorRol extends BeanMantenedorGenerico<ServicioMantenedorRol, Long, OmsRole, OmsRoleEAO> {
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioMantenedorRol servicioMantenedor;

	private Long[] opcionesSeleccionadas;

	private List<OmsOpcione> listaOpcionesTerminales;

	protected ServicioMantenedorRol getServicioMantenedor() {
		return servicioMantenedor;
	}

	public BeanMantenedorRol() {
		super(new OmsRole(), OmsRole.class);
	}

	protected void metodoPostErrorTransaccion() {
		System.out.println("Error al realizar la operacion " + this.getClass().getCanonicalName());
	}

	protected void validacionesIngreso() throws ErrorValidacionVisual {

		try {
			if (opcionesSeleccionadas!=null && opcionesSeleccionadas.length != 0) {
				for (Long descripcionOpcion : opcionesSeleccionadas) {
					entidadRegistrar.agregarOpciones(servicioMantenedor.obtenerOpcionPorID(descripcionOpcion));
				}
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new ErrorValidacionVisual("Imposible registrar los roles");
		}
	}

	@Override
	public void accionesPreTransaccionServicio() {
		System.out.println("Sin acciones que realizar en mantenimiento cargo");
		
	}
	
	@Override
	public String getTituloPagina() {
		// TODO Auto-generated method stub
		return "Mantenimiento Roles";
	}

	@Override
	public String getDescripcionPagina() {
		// TODO Auto-generated method stub
		return "Mantenedor Roles";
	}

	@Override
	public String getAyudaPagina() {
		// TODO Auto-generated method stub
		return "Cree o edite los Roles";
	}

	@Override
	public String getTab() {
		// TODO Auto-generated method stub
		return "Datos Rol";
	}

	@Override
	public String getCabeceraTabla() {
		// TODO Auto-generated method stub
		return "Roles registrados";
	}

	@Override
	protected void metodoPostTransaccion() {
		super.metodoPostTransaccion();// trae la lista de entidades
		super.entidadRegistrar = new OmsRole();
		opcionesSeleccionadas = null;
	}

	@Override
	public String getMensajeTablaVacia() {
		// TODO Auto-generated method stub
		return JsfUtil.MENSAJE_INFO_SINRESULTADO;
	}

	@Override
	public String getCabeceraDialogo() {
		// TODO Auto-generated method stub
		return "Actualización Rol";
	}

	@Override
	public String getCabeceraPanelDialogo() {
		// TODO Auto-generated method stub
		return "Datos Rol";
	}

	@Override
	protected void metodoPostConstruct() {
		listaOpcionesTerminales = servicioMantenedor.listaOpcionesEjecutables();
	}

	public List<OmsOpcione> getListaOpcionesTerminales() {
		return listaOpcionesTerminales;
	}

	public void setListaOpcionesTerminales(List<OmsOpcione> listaOpcionesTerminales) {
		this.listaOpcionesTerminales = listaOpcionesTerminales;
	}

	public Long[] getOpcionesSeleccionadas() {
		return opcionesSeleccionadas;
	}

	public void setOpcionesSeleccionadas(Long[] opcionesSeleccionadas) {
		this.opcionesSeleccionadas = opcionesSeleccionadas;
	}

	public List<OmsOpcione> obtenerOpcionesAsignadasRol(List<OmsOpcionesRole> opcionesRoles) {
		List<OmsOpcione> opcionesRolesAsig = new ArrayList<>();
		for (OmsOpcionesRole opcionRol : opcionesRoles) {
			if (opcionRol.getPriOpcione().getAccion() != null) {
				opcionRol.getPriOpcione().setAuditoria(opcionRol.getAuditoria());
				opcionesRolesAsig.add(opcionRol.getPriOpcione());
			}
		}
		return opcionesRolesAsig;
	}

	protected void postSeleccionRegistro(OmsRole entidadRegistrar2) {
		// aqui debo seleccionar los roles asignados
//		List<OmsOpcione> opcionesSeleccionadasRol = servicioMantenedor.listaOpcionesEjecutables(entidadRegistrar2);
//		opcionesSeleccionadas = new Long[opcionesSeleccionadasRol.size()];
//		int i = 0;
//		for (OmsOpcione opcion : opcionesSeleccionadasRol) {
//			opcionesSeleccionadas[i] = opcion.getId();
//			i++;
//		}
		opcionesSeleccionadas = null;
		System.out.println("Sin actualizar las opciones");
		
	}

	

}