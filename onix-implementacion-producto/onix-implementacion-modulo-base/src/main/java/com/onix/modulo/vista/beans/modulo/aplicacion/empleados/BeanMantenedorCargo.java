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
import com.onix.modulo.librerias.vista.beans.NombresEtiquetas;
import com.onix.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
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

	public BeanMantenedorCargo() {
		super(OmsoCargo.class);
		this.entidadRegistrar.setRolDefault(new OmsRole());
		addPostConstructuListener(new PostConstructListener() {
			@Override
			public void metodoPostConstruct() {
				listaRoles = servicioMantenedorRol.listaObjetosActivos(OmsRole.class);
			}
		});

		addPostTransaccion(new PostTransaccionListener() {

			@Override
			public void metodoPostTransaccion() {
				entidadRegistrar.setRolDefault(new OmsRole());

			}
		});

	}

	@Override
	protected ServicioMantenedorCargo getServicioMantenedor() {
		return servicioMantenedor;
	}

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Cargos");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Cargos registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Cargos registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}

	public List<OmsRole> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<OmsRole> listaRoles) {
		this.listaRoles = listaRoles;
	}
}