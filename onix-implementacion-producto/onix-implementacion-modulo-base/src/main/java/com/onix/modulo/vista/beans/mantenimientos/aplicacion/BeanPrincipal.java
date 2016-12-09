package com.onix.modulo.vista.beans.mantenimientos.aplicacion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;


@ManagedBean(name="beanPrincipal")
@ViewScoped
public class BeanPrincipal 
{
	private ScheduleModel modelo;
	
	
	@PostConstruct
	public void init()
	{
		modelo = new DefaultScheduleModel();
	}
	
	public ScheduleModel getModelo() {
		return modelo;
	}
	
	public void setModelo(ScheduleModel modelo) {
		this.modelo = modelo;
	}
}
