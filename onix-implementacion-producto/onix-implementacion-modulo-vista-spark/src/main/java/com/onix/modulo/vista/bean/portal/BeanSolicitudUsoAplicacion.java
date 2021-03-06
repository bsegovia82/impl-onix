package com.onix.modulo.vista.bean.portal;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onix.modulo.dominio.aplicacion.OmgSolicitudUsoAplicacion;
import com.onix.modulo.dominio.aplicacion.OmgSolicitudUsoAplicacion.CANAL_REGISTRO;
import com.onix.modulo.eao.aplicacion.OmgSolicitudUsoAplicacionEAO;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.beans.NombresEtiquetas;
import com.onix.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PreTransaccionListener;
import com.onix.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorSolicitud;

@ManagedBean
@ViewScoped
public class BeanSolicitudUsoAplicacion 
extends BeanMantenedorGenerico<ServicioMantenedorSolicitud, Long, OmgSolicitudUsoAplicacion, OmgSolicitudUsoAplicacionEAO> {
	
	@EJB
	private ServicioMantenedorSolicitud servicioMantenedor;
	
	private static final long serialVersionUID = 1L;
	
	public BeanSolicitudUsoAplicacion() {
		super(OmgSolicitudUsoAplicacion.class);
		addPostConstructuListener(new PostConstructListener() {
			
			@Override
			public void metodoPostConstruct() {
				
				
			}
		});
		
		addPostTransaccion(new PostTransaccionListener() {
			
			@Override
			public void metodoPostTransaccion() {
			
			}
		});
		
		addPreTransaccionServicioListener(new PreTransaccionListener() {
			
			public void accionPreTransaccion() throws ErrorAccionesPreTransaccion {
				entidadRegistrar.setlCanalRegistro(CANAL_REGISTRO.WEB);
				entidadRegistrar.setIdTipoPlan(new Long(1));
			}
		});
	}
	
	@Override
	protected ServicioMantenedorSolicitud getServicioMantenedor() 
	{
		return servicioMantenedor;
	}

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Solicitud de uso de demo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Solicitud de uso de demo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Solicitud de uso de demo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Solicitud de uso de demo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Solicitud de uso de demo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Solicitud de uso de demo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Cargo");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
		this.listaEtiquetasPantalla.put(NombresEtiquetas.MENSAJE_TRANSACCION.toString(), "Solicitud registrada correctamente");
	}
	

}
