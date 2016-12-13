package com.onix.modulo.vista.beans.modulo.aplicacion.seguridad;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.eao.aplicacion.OmsUsuarioEAO;
import com.onix.modulo.librerias.vista.JsfUtil;
import com.onix.modulo.librerias.vista.beans.BeanMantenedorGenerico;
import com.onix.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
import com.onix.modulo.librerias.vista.exceptions.ErrorValidacionVisual;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;

@ManagedBean
@ViewScoped
public class BeanMantenedorUsuario
		extends BeanMantenedorGenerico<ServicioMantenedorUsuario, Long, OmsUsuario, OmsUsuarioEAO> {
	private static final long serialVersionUID = 1L;

	@EJB
	private ServicioMantenedorUsuario servicioMantenedor;

	private byte[] avatar;

	private Long[] rolesSeleccionadas;

	private List<OmsRole> listaRoles;

	protected ServicioMantenedorUsuario getServicioMantenedor() {
		return servicioMantenedor;
	}

	public BeanMantenedorUsuario() {
		super(new OmsUsuario(), OmsUsuario.class);
		super.entidadRegistrar.setClave(JsfUtil.CLAVE_INICIAL_DEFAULT);
	}

	public OmsUsuario getUsuarioActual() {
		return getEntidadRegistrar();
	}

	public void setUsuarioActual(OmsUsuario usuarioActual) {
		setEntidadRegistrar(usuarioActual);
	}

	protected void metodoPostErrorTransaccion() {
		System.out.println("Error al realizar la operacion " + this.getClass().getCanonicalName());
	}

	// Aqui deben poner las validaciones y demas previo al envio a la base de
	// datos
	protected void validacionesIngreso() throws ErrorValidacionVisual {

		System.out.println("Si nada que validar en mantenimiento de usuario");
	}

	@Override
	public String getTituloPagina() {
		// TODO Auto-generated method stub
		return "Mantenimiento Usuarios";
	}

	@Override
	public String getDescripcionPagina() {
		// TODO Auto-generated method stub
		return "Mantenedor Usuarios";
	}

	@Override
	public String getAyudaPagina() {
		// TODO Auto-generated method stub
		return "Desde esta opción, se pueden editar o crear usuarios";
	}

	@Override
	public String getTab() {
		// TODO Auto-generated method stub
		return "Datos Usuario";
	}

	@Override
	public String getCabeceraTabla() {
		// TODO Auto-generated method stub
		return "Usuarios registrados";
	}

	@Override
	protected void metodoPostTransaccion() {
		super.metodoPostTransaccion();// trae la lista de entidades
		super.entidadRegistrar = new OmsUsuario();
		super.entidadRegistrar.setClave(JsfUtil.CLAVE_INICIAL_DEFAULT);
		super.entidadSelecionable = new OmsUsuario();
		rolesSeleccionadas = null;
	}

	@Override
	public String getMensajeTablaVacia() {
		// TODO Auto-generated method stub
		return JsfUtil.MENSAJE_INFO_SINRESULTADO;
	}

	@Override
	public String getCabeceraDialogo() {
		// TODO Auto-generated method stub
		return "Actualización Usuario";
	}

	@Override
	public String getCabeceraPanelDialogo() {
		// TODO Auto-generated method stub
		return "Datos usuario";
	}

	@Override
	protected void metodoPostConstruct() {
		listaRoles = getServicioMantenedor().listaRoles();

	}

	public List<OmsRole> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<OmsRole> listaRoles) {
		this.listaRoles = listaRoles;
	}

	@Override
	protected void postSeleccionRegistro(OmsUsuario entidadRegistrar2) {
		// List<OmsRole> rolesActios = servicioMantenedor.listaRoles();
		// rolesSeleccionadas = new Long[rolesActios.size()];
		// int i = 0;
		// for (OmsRole role : rolesActios) {
		// rolesSeleccionadas[i] = role.getId();
		// i++;
		// }
		rolesSeleccionadas = null;
		System.out.println("Sin nada que hacer despues de la seleccion");

	}

	public Long[] getRolesSeleccionadas() {
		return rolesSeleccionadas;
	}

	public void setRolesSeleccionadas(Long[] rolesSeleccionadas) {
		this.rolesSeleccionadas = rolesSeleccionadas;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	@Override
	public void accionesPreTransaccionServicio() throws ErrorAccionesPreTransaccion {

		try {
			if (rolesSeleccionadas != null && rolesSeleccionadas.length != 0) {
				for (Long idRol : rolesSeleccionadas) {
					entidadRegistrar.agregarRol(servicioMantenedor.obtenerRolPorID(idRol));
				}
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new ErrorAccionesPreTransaccion("Imposible registrar los roles");
		}

		if (avatar != null) {

			entidadRegistrar.setImagenReferencia(avatar);

		} else {
			System.out.println("No registra avatar");
		}

	}
	
	public void subir(FileUploadEvent event) {
       avatar = event.getFile().getContents();
    }
	
	
}