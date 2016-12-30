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
import com.onix.modulo.librerias.vista.beans.NombresEtiquetas;
import com.onix.modulo.librerias.vista.beans.oyentes.PostConstructListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PostSeleccionEntidadListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PostTransaccionListener;
import com.onix.modulo.librerias.vista.beans.oyentes.PreTransaccionListener;
import com.onix.modulo.librerias.vista.exceptions.ErrorAccionesPreTransaccion;
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

	public BeanMantenedorUsuario() {
		super(new OmsUsuario(), OmsUsuario.class);
		super.entidadRegistrar.setClave(JsfUtil.CLAVE_INICIAL_DEFAULT);
		addPostTransaccion(new PostTransaccionListener() {
			
			@Override
			public void metodoPostTransaccion() {
				entidadRegistrar = new OmsUsuario();
				entidadRegistrar.setClave(JsfUtil.CLAVE_INICIAL_DEFAULT);
				entidadSelecionable = new OmsUsuario();
				rolesSeleccionadas = null;
				
			}
		});
		
		addPostSeleccionRegistroListener(new PostSeleccionEntidadListener<OmsUsuario, Long>() {
			
			@Override
			public void postSeleccionRegistro(OmsUsuario pEntidadSeleccionada) {
				rolesSeleccionadas = null;
			}
		});
		
		addPreTransaccionServicioListener(new PreTransaccionListener() {
			
			@Override
			public void accionPreTransaccion() throws ErrorAccionesPreTransaccion {
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
		});
		
		addPostConstructuListener(new PostConstructListener() {
			
			@Override
			public void metodoPostConstruct() {
				listaRoles = getServicioMantenedor().listaRoles();
			}
		});
	}
	
	protected ServicioMantenedorUsuario getServicioMantenedor() {
		return servicioMantenedor;
	}

	public OmsUsuario getUsuarioActual() {
		return getEntidadRegistrar();
	}

	public void setUsuarioActual(OmsUsuario usuarioActual) {
		setEntidadRegistrar(usuarioActual);
	}

	public List<OmsRole> getListaRoles() {
		return listaRoles;
	}

	public void setListaRoles(List<OmsRole> listaRoles) {
		this.listaRoles = listaRoles;
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

	public void subir(FileUploadEvent event) {
       avatar = event.getFile().getContents();
    }

	@Override
	protected void cargarListaEtiquetas() {
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TITULOPAGINA.toString(), "Mantenimiento Usuarios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.DESCRIPCIONPAGINA.toString(), "Mantenedor Usuarios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.AYUDAPAGINA.toString(), "Desde esta opción, se pueden editar o crear usuarios");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TAB.toString(), "Datos Usuario");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERATABLA.toString(), "Usuarios registrados");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERADIALOGO.toString(), "Actualización Usuario");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.CABECERAPANELDIALOGO.toString(), "Datos usuario");
		this.listaEtiquetasPantalla.put(NombresEtiquetas.TABLAVACIA.toString(), JsfUtil.MENSAJE_INFO_SINRESULTADO);
		
		
	}
	
	
	
	
}