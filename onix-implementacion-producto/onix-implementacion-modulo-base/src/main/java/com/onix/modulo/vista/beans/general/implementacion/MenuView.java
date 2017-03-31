package com.onix.modulo.vista.beans.general.implementacion;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.librerias.vista.anotaciones.ITestParseMenu;
import com.onix.modulo.librerias.vista.anotaciones.ITestServicioMenuOpcionesHorizontal;
import com.onix.modulo.librerias.vista.interfaces.IServiciosMenu;

@Named("menuView")
@RequestScoped
public class MenuView implements Serializable {

	/**
	 * 
	 */

	private String descripcionOpcion;

	private static final long serialVersionUID = 1L;

	@Inject
	@ITestServicioMenuOpcionesHorizontal
	private IServiciosMenu<OmsOpcione> opcionesMenu;

	@Inject
	@ITestParseMenu
	private TestParseMenu parseMenu;

	private MenuModel model;

	@PostConstruct
	public void init() {
		model = new DefaultMenuModel();

		// <p:menuitem id="sm_dashboard" value="Dashboard"
		// icon="icon-home-outline" outcome="/ejemplo/dashboard"
		// containerStyleClass=""/>

		model = parseMenu.parseMenuOpciones(opcionesMenu.getMenuOpciones());

	}

	public void displayList(ActionEvent event) {
		MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
		descripcionOpcion = menuItem.getParams().get("descripcion").get(0);
		System.out.println(descripcionOpcion);
	}

	public MenuModel getModel() {
		return model;
	}

	public void Mensaje() {
		addMessage("Exito", "Ud a dado un clik");
	}

	public void metodoPostSeleccionMenu() {

	}

	public void save() {
		addMessage("Success", "Data saved");
	}

	public void update() {
		addMessage("Success", "Data updated");
	}

	public void delete() {
		addMessage("Success", "Data deleted");
	}

	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String getDescripcionOpcion() {
		return descripcionOpcion;
	}

	public void setDescripcionOpcion(String descripcionOpcion) {
		this.descripcionOpcion = descripcionOpcion;
	}
}
