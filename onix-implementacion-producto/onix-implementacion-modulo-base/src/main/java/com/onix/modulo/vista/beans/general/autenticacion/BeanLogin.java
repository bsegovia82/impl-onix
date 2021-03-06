package com.onix.modulo.vista.beans.general.autenticacion;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import com.onix.api.cliente.login.ApiLogin;
import com.onix.api.cliente.login.ExtensionLogin;
import com.onix.api.configuracion.ConfiguracionLogin;
import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.dominio.aplicacion.OmsUsuariosRole;
import com.onix.modulo.librerias.generales.UtilEncriptarDataSource;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.anotaciones.ITestAutenticacion;
import com.onix.modulo.librerias.vista.anotaciones.ITestUsuarioSession;
import com.onix.modulo.librerias.vista.beans.ManagedBeanGenerico;
import com.onix.modulo.librerias.vista.interfaces.IGuardiaUsuarioSession;
import com.onix.modulo.librerias.vista.interfaces.IServiciosAutenticacion;
import com.onix.modulo.librerias.vista.interfaces.IUsuarioSession;
import com.onix.modulo.servicio.seguridad.ServiciosMantenimientoSeguridad;

@ManagedBean(name = "beanLogin")
@ViewScoped
public class BeanLogin extends ManagedBeanGenerico {
	/**
	 * 
	 */

	@Inject
	@ITestUsuarioSession
	private IUsuarioSession<OmsUsuario> usuarioSession;

	@Inject
	@ExtensionLogin
	private ApiLogin lExtensionLogin;

	private String cambContrase1;
	private String cambContrase2;

	@Inject
	@ITestAutenticacion
	private IServiciosAutenticacion<OmsUsuario, BeanLogin> autenticador;

	@EJB
	private ServiciosMantenimientoSeguridad serviciosMantenimientoSeguridad;

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String clave;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String login() {
		try {
			if (this.isAutenticado())
				this.getHttpServletRequest().logout();
			this.getHttpServletRequest().login(usuario.toUpperCase(), UtilEncriptarDataSource.encode(clave));
			OmsUsuario usuario = autenticador.autenticar(this);
			if (usuario == null) {
				addError("USUARIO/CLAVE Invalidos");
				return "";
			}
			if ("I".equals(usuario.getEstado())) {
				addError("Usuario Inactivo");
				return "";
			}
			usuario.setRolesAsignados(rolesUsuario(usuario));
			OmsRole lRolPrincipal = rolPrincipalUsuario(usuario);
			usuario.setRolPrincipal(lRolPrincipal == null ? "SIN ROL PRINCIPAL " : lRolPrincipal.getRol());
			usuarioSession.setUsuarioSession(usuario);
			generarSemillaSegura(usuario);

			agregarObjetoSesion(JsfUtil.REFERENCIA_SESION, usuario.getIdReferencia());

//			lExtensionLogin.ejecutarExtensionLogin(
//
//					new HashMap<String, Object>() {
//						static final long serialVersionUID = 1L;
//						{
//							put(ConfiguracionLogin.CAMPO_USUARIO, usuario);
//							put(ConfiguracionLogin.CAMPO_CLAVE, clave);
//						}
//					});

			return lRolPrincipal != null && lRolPrincipal.getlPaginaPrincipal() != null
					? lRolPrincipal.getlPaginaPrincipal() : IGuardiaUsuarioSession.PAGINA_PRINCIPAL_RED;

		} catch (Throwable e) {

			addError("USUARIO/CLAVE Invalidos");
			e.printStackTrace();
		}
		return "";
	}

	public void recuperarClave(ActionEvent evento) {

	}

	public void contactarAdmin(ActionEvent evento) {

	}

	private String rolesUsuario(OmsUsuario usuario) {

		List<OmsUsuariosRole> listaUsuariosRoles = usuario.getPriUsuariosRoles();
		String roles = "";
		for (OmsUsuariosRole rol : listaUsuariosRoles) {
			if (rol.getEstado().equals("A")) {
				roles = roles + rol.getPriRole().getRol() + ", ";
			}
		}

		return roles;
	}

	private OmsRole rolPrincipalUsuario(OmsUsuario usuario) {

		List<OmsUsuariosRole> listaUsuariosRoles = usuario.getPriUsuariosRoles();
		OmsRole lRol = null;
		for (OmsUsuariosRole rol : listaUsuariosRoles) {
			String lTipoRol = rol.getPriRole().getTipoRol() == null ? "" : rol.getPriRole().getTipoRol();

			if (lTipoRol.equals("P")) {
				lRol = rol.getPriRole();
			}
		}

		return lRol;
	}

	private void generarSemillaSegura(OmsUsuario usuario) {
		try {
			((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).setAttribute(
					IGuardiaUsuarioSession.SEMILLA, UtilEncriptarDataSource.encode(usuario.getUsuario().toUpperCase()));
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public IUsuarioSession<OmsUsuario> getUsuarioSession() {
		return usuarioSession;
	}

	public void setUsuarioSession(IUsuarioSession<OmsUsuario> usuarioSession) {
		this.usuarioSession = usuarioSession;
	}

	public void logout() throws IOException {

		try {
			this.getHttpServletRequest().logout();
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.invalidateSession();
		ec.redirect(ec.getRequestContextPath() + IGuardiaUsuarioSession.PAGINA_LOGIN_RED);
	}

	public void cerrarVentana(ActionEvent evento) {

		// if
		// (!serviciosMantenimientoSeguridad.obtenerUsuarioTot(usuarioSession.getUsuarioSession().getUsuario())
		// .getClave().equals(usuarioSession.getUsuarioSession().getClave()))
		if (!("S").equals(serviciosMantenimientoSeguridad
				.obtenerUsuarioTot(usuarioSession.getUsuarioSession().getUsuario()).getEsNuevo()))

			try {
				logout();
			} catch (IOException e) {
				e.printStackTrace();
			}

		else
			RequestContext.getCurrentInstance().execute("PF('dlg2')."
					+ (("S".equals(usuarioSession.getUsuarioSession().getEsNuevo()) ? "show" : "hide") + "();"));

	}

	public void cambiarContrasenia(ActionEvent evento) {

		if (!cambContrase1.equals(cambContrase2)) {
			addError("Las contraseñas no coninciden");
			return;
		}

		if (cambContrase1.length() < 8) {
			addError("Ingrese una contraseña de 8 caracteres mínimo");
			return;
		}

		try {
			OmsUsuario usuarioBASE = serviciosMantenimientoSeguridad
					.obtenerUsuarioTot(usuarioSession.getUsuarioSession().getUsuario());
			usuarioBASE.setClave(UtilEncriptarDataSource.encode(cambContrase1));
			usuarioBASE.setEsNuevo("N");
			serviciosMantenimientoSeguridad.cambioClaveUsuario(usuarioBASE);
			addMensaje("Su contraseña fue cambiada con éxito");
		} catch (Throwable e) {
			addError("Imposible realizar el cambio de contraseña");
			e.printStackTrace();
		}
	}

	public String getCambContrase1() {
		return cambContrase1;
	}

	public void setCambContrase1(String cambContrase1) {
		this.cambContrase1 = cambContrase1;
	}

	public String getCambContrase2() {
		return cambContrase2;
	}

	public void setCambContrase2(String cambContrase2) {
		this.cambContrase2 = cambContrase2;
	}
}
