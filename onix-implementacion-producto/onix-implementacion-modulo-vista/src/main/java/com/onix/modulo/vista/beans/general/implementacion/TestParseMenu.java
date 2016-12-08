package com.onix.modulo.vista.beans.general.implementacion;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuElement;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.librerias.vista.anotaciones.ITestParseMenu;
import com.onix.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IGuardiaUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IParseMenu;
import com.onix.modulo.librerias.vista.interfaces.IUsuarioSession;
import com.onix.modulo.servicio.seguridad.ServicioAplicacion;

@ITestParseMenu
@SessionScoped
public class TestParseMenu implements IParseMenu<OmsOpcione, DefaultMenuModel>,
		ActionListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioAplicacion servicioAplicacion;

	@Inject
	@ITestUsuarioSession
	private IUsuarioSession<OmsUsuario> parametroObtenerOpciones;

	public DefaultMenuModel parseMenuOpciones(List<OmsOpcione> opciones) {
		MenuModel model = new DefaultMenuModel();

		DefaultMenuItem menItm = new DefaultMenuItem("Principal");
		menItm.setIcon("fa fa-home");//fa-home
		menItm.setTitle("Pagina Principal");
		menItm.setUrl(IGuardiaUsuarioSession.PAGINA_PRINCIPAL);
		menItm.setPartialSubmit(true);
		menItm.setProcess("@this");
		//menItm.setContainerStyleClass("layout-menubar-active");
		
		
		model.addElement(menItm);
		
		model.addElement(new org.primefaces.model.menu.DefaultSeparator() );

		
		for (OmsOpcione opcion : opciones) {
			DefaultSubMenu submenu = new DefaultSubMenu(opcion.getOpcion());
			// submenu.setLabel(opcion.getOpcion());
			System.out.println(opcion.getOpcion()
					+ "----------------------------");
			submenu.setId("OPTH" + opcion.getId());
			submenu.setIcon(opcion.getRutaimagen());
			Iterator<OmsOpcione> opcionesHijas = opcion.getOpcionesHijas()
					.iterator();

			while (opcionesHijas.hasNext()) {
				OmsOpcione opcionHija = opcionesHijas.next();

				// Solo si hay permisos para esa opcion
				if (servicioAplicacion.verificarPermisoOpcion(opcionHija,
						parametroObtenerOpciones.getUsuarioSession())) {
					if (opcionHija.getEstado().equals("A"))
						 {
						submenu.getElements().add(getMenuHija(opcionHija));
					}
				}
			}
			model.addElement(submenu);
			model.addElement(new org.primefaces.model.menu.DefaultSeparator() );
		}

		return (DefaultMenuModel) model;
	}

	private MenuElement getMenuHija(OmsOpcione opcionPadre) {

		if (opcionPadre.getOpcionesHijas() == null
				|| opcionPadre.getOpcionesHijas().size() < 1) {

			DefaultMenuItem menItm = new DefaultMenuItem(
					opcionPadre.getOpcion());
			// menItm.setValue(opcionPadre.getOpcion());
			menItm.setIcon(opcionPadre.getRutaimagen());
			// menItm.setAjax(true);
			menItm.setTitle(opcionPadre.getDescripcion());
			// menItm.setOncomplete("showDialogProceso("+opcionPadre.getOnComplete()+");");

			// menItm.getAttributes().put("cfOpcion", opcionPadre);
//
//			if (opcionPadre.getTipo().equals("P")) {
//				// menItm.setUpdate(":MAIN_TARGET");
//			} else {
//				menItm.setOnclick("pantalla.show()");
//			}
			// menItm.setImmediate(true);
			// menItm.setUrl(opcionPadre.getAccion());
//			menItm.setCommand("#{verticalMenu.navegarUrl('"
//					+  + "')}");
			System.out.println("Accion " + opcionPadre.getAccion());
			menItm.setUrl(opcionPadre.getAccion());
			menItm.setPartialSubmit(true);
			menItm.setProcess("@this");
			
			/*
			 * menItm.setProcess("@all"); menItm.setUpdate("@all");
			 */
			// menItm.addActionListener(this);
			return menItm;

		} else {

			DefaultSubMenu menItm = new DefaultSubMenu(opcionPadre.getOpcion());
			menItm.setIcon(opcionPadre.getRutaimagen());
			// menItm.setLabel(opcionPadre.getOpcion());

			Iterator<OmsOpcione> opcionesHijas = opcionPadre.getOpcionesHijas()
					.iterator();

			while (opcionesHijas.hasNext()) {
				OmsOpcione opcionHija = opcionesHijas.next();
				// Solo voy a recorrer si hay permisos para esa opcion
				if (servicioAplicacion.verificarPermisoOpcion(opcionHija,
						parametroObtenerOpciones.getUsuarioSession())) {
					menItm.getElements().add(getMenuHija(opcionHija));
				}
			}
			return menItm;
		}

	}

	@SuppressWarnings("unused")
	public void processAction(ActionEvent event)
			throws AbortProcessingException {
		System.out.println("Ejecucion");
		if (event.getSource().getClass() == MenuItem.class) {
			MenuItem sourceItem = (MenuItem) event.getSource();
			/*
			 * CfOpciones opcionActual = (CfOpciones)
			 * sourceItem.getAttributes().get("cfOpcion"); if
			 * (opcionActual.getTipo().equals("P")) {
			 * beanTarget.setCabecera(getRutaOpcion(opcionActual)); }
			 */
		}
	}

	@SuppressWarnings("unused")
	private String getRutaOpcion(OmsOpcione opcionActual) {
		String rutaOpcion = "";
		rutaOpcion = getOpcionPadre(opcionActual, rutaOpcion);
		rutaOpcion = rutaOpcion.substring(0, rutaOpcion.length() - 2);
		return "OPCION ACTUAL : " + rutaOpcion.toUpperCase();
	}

	private String getOpcionPadre(OmsOpcione opcion, String nombre) {

		if (opcion.getModuloPadre() != null) {
			nombre = opcion.getOpcion() + " - " + nombre;
			return getOpcionPadre(opcion.getModuloPadre(), nombre);
		}
		return opcion.getOpcion() + " - " + nombre;
	}

}
