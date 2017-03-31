package com.cnel.modulo.vista.bean.medidor;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.cnel.modulo.dominio.bitacora.CnelBitacora;
import com.cnel.modulo.eao.bitacora.CnelBitacoraEAO;
import com.cnel.modulo.servicio.bitacora.ServicioBitacoraEjecucion;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.beans.NombresEtiquetas;
import com.onix.modulo.librerias.vista.beans.oyentes.PostConstructListener;

@ManagedBean
@ViewScoped
public class BeanTomaLecturaMedidor
		extends BeanMantenedorGenerico<ServicioBitacoraEjecucion, Long, CnelBitacora, CnelBitacoraEAO> {

	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioBitacoraEjecucion lServicioBitacora;

	public BeanTomaLecturaMedidor() {
		super(CnelBitacora.class);
		addPostConstructuListener(new PostConstructListener() {

			public void metodoPostConstruct() {
			

			}
		});
	}

	/**
	 * 
	 */

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Toma Lectura Medidores");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Toma de lectura medidores");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(),
				"Registre la lectura de los medidores");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Medidores");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Lista de registros");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Registro de lectura medidor");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos Medidores");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Lista de registro medidores");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);

	}

	public void resgistar(ActionEvent lEvento) {
		entidadRegistrar = (CnelBitacora) lEvento.getComponent().getAttributes().get("dato");
		guardarOActualizar();
	}
   
	@Override
	protected ServicioBitacoraEjecucion getServicioMantenedor() {
		return lServicioBitacora;
	}

}
