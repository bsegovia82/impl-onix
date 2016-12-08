package com.onix.modulo.vista.beans.modulo.aplicacion.empresa;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.onix.modulo.dominio.empresa.OmseEmpresa;
import com.onix.modulo.eao.empresa.OmseEmpresaEAO;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.exceptions.ErrorValidacionVisual;
import com.onix.modulo.servicio.mantenimiento.empresa.ServicioMantenedorEmpresa;

@ManagedBean
@ViewScoped
public class BeanMantenedorEmpresa extends
		BeanMantenedorGenerico<ServicioMantenedorEmpresa, Long, OmseEmpresa, OmseEmpresaEAO> {
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioMantenedorEmpresa servicioMantenedor;

	protected ServicioMantenedorEmpresa getServicioMantenedor() {
		return servicioMantenedor;
	}

	public BeanMantenedorEmpresa() {
		super(new OmseEmpresa(), OmseEmpresa.class);
	}

	protected void metodoPostErrorTransaccion() {
		System.out.println("Error al realizar la operacion " + this.getClass().getCanonicalName());
	}

	protected void validacionesIngreso()throws ErrorValidacionVisual 
	{
		if (!JsfUtil.validarCedulaORUC(entidadRegistrar.getRuc()))
		{
			throw new ErrorValidacionVisual("El ruc es invalido");
		}
	}
	
	@Override
	public void accionesPreTransaccionServicio() {
		System.out.println("Sin acciones que realizar en mantenimiento cargo");
		
	}

	@Override
	public String getTituloPagina() {
		// TODO Auto-generated method stub
		return "Mantenimiento Empresas";
	}

	@Override
	public String getDescripcionPagina() {
		// TODO Auto-generated method stub
		return "Mantenedor Empresas";
	}

	@Override
	public String getAyudaPagina() {
		// TODO Auto-generated method stub
		return "Cree o edite Empresas";
	}

	@Override
	public String getTab() {
		// TODO Auto-generated method stub
		return "Datos Empresa";
	}

	@Override
	public String getCabeceraTabla() {
		// TODO Auto-generated method stub
		return "Empresas registradas";
	}

	@Override
	protected void metodoPostTransaccion() {
		super.metodoPostTransaccion();// trae la lista de entidades
		OmseEmpresa obj = new OmseEmpresa();
		setEntidadRegistrar(obj);
	}

	@Override
	public String getMensajeTablaVacia() {
		// TODO Auto-generated method stub
		return JsfUtil.MENSAJE_INFO_SINRESULTADO;
	}

	@Override
	public String getCabeceraDialogo() {
		// TODO Auto-generated method stub
		return "Actualización de Empresa";
	}

	@Override
	public String getCabeceraPanelDialogo() {
		// TODO Auto-generated method stub
		return "Datos Empresa";
	}

	@Override
	protected void metodoPostConstruct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void postSeleccionRegistro(OmseEmpresa entidadRegistrar2) {
		System.out.println("sin nada que hacer postSeleccionRegistro(OmseEmpresa");
		
	}

	

}
