package com.onix.modulo.vista.beans.modulo.aplicacion.empleados;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onix.modulo.dominio.persona.operacion.OmsoEspecialidad;
import com.onix.modulo.eao.persona.operacion.OmsoEspecialidadEAO;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.beans.NombresEtiquetas;
import com.onix.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import com.onix.modulo.servicio.mantenimiento.persona.operacion.ServicioMantenedorEspecialidad;

@ManagedBean
@ViewScoped
public class BeanMantenedorEspecialidad
		extends BeanMantenedorGenerico<ServicioMantenedorEspecialidad, Long, OmsoEspecialidad, OmsoEspecialidadEAO> {
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioMantenedorEspecialidad servicioMantenedor;

	private List<OmsoEspecialidad> lListaEspecialidad;

	public BeanMantenedorEspecialidad() {
		super(OmsoEspecialidad.class);
		addPostTransaccion(new PostTransaccionListener() {
			@Override
			public void metodoPostTransaccion() {
				
			}
		});

		addPostConstructuListener(new PostConstructListener() {

			@Override
			public void metodoPostConstruct() {
				lListaEspecialidad = servicioMantenedor.listaObjetosActivos(OmsoEspecialidad.class);
			}
		});
	}

	protected ServicioMantenedorEspecialidad getServicioMantenedor() {
		return servicioMantenedor;
	}

	@Override
	protected void cargarListaEtiquetas() {

		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Cree o edite Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Empleados Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización de Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Especialidad");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);

	}

	public List<OmsoEspecialidad> getlListaEspecialidad() {
		return lListaEspecialidad;
	}

	public void setlListaEspecialidad(List<OmsoEspecialidad> lListaEspecialidad) {
		this.lListaEspecialidad = lListaEspecialidad;
	}

}