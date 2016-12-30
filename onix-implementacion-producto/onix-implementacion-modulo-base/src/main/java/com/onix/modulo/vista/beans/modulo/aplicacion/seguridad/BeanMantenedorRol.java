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
import com.onix.modulo.librerias.vista.beans.NombresEtiquetas;
import com.onix.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PostSeleccionEntidadListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import com.onix.modulo.librerias.vista.beans.oyentes.ValidadorIngresoDatosListener;
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

	public BeanMantenedorRol() {
		super(new OmsRole(), OmsRole.class);

		addValidacionListener(new ValidadorIngresoDatosListener() {

			@Override
			public void validarDatosIngreso() throws ErrorValidacionVisual {
				try {
					if (opcionesSeleccionadas != null && opcionesSeleccionadas.length != 0) {
						for (Long descripcionOpcion : opcionesSeleccionadas)
							entidadRegistrar.agregarOpciones(servicioMantenedor.obtenerOpcionPorID(descripcionOpcion));
					}

				} catch (Throwable e) {
					e.printStackTrace();
					throw new ErrorValidacionVisual("Imposible registrar los roles");
				}

			}
		});

		addPostTransaccion(new PostTransaccionListener() {
			@Override
			public void metodoPostTransaccion() {
				entidadRegistrar = new OmsRole();
				opcionesSeleccionadas = null;

			}
		});

		addPostConstructuListener(new PostConstructListener() {

			@Override
			public void metodoPostConstruct() {
				listaOpcionesTerminales = servicioMantenedor.listaOpcionesEjecutables();
			}
		});

		addPostSeleccionRegistroListener(new PostSeleccionEntidadListener<OmsRole, Long>() {

			@Override
			public void postSeleccionRegistro(OmsRole pEntidadSeleccionada) {
				opcionesSeleccionadas = null;

			}
		});
	}

	protected ServicioMantenedorRol getServicioMantenedor() {
		return servicioMantenedor;
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

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Roles");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Roles");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite los Roles");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Rol");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Roles registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización Rol");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Rol");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
	}
}