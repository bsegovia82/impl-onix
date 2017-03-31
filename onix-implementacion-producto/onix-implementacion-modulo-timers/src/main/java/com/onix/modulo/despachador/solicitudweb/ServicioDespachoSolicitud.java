package com.onix.modulo.despachador.solicitudweb;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.onix.modulo.dominio.aplicacion.OmgAsociadoWeb;
import com.onix.modulo.dominio.aplicacion.OmgAsociadoWeb.TIPO_ASOCIADO;
import com.onix.modulo.dominio.aplicacion.OmgSolicitudUsoAplicacion;
import com.onix.modulo.dominio.aplicacion.OmsRole;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.dominio.aplicacion.OmsUsuariosRole;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorAsociadoWeb;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorRol;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorSolicitud;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuarioRol;
import com.onix.modulo.servicio.notificacion.ServicioNotificacionMail;

@Stateless
public class ServicioDespachoSolicitud {

	private String USUARIO_WEB = "@USUARIO@";
	private String CLAVE_WEB = "@CLAVE@";
	
	
	private String lParametroTiempoVigenciaDiasUsuario = "LONG_DIAS_VIGENCIA";

	private String lParametroClaveDefault = "STRING_CLAVE_USUARIO_DEFAULT";

	private String lParametroPrefijoUsuario = "STRING_PREFIJO_USUARIO";

	private String lParametroRolDemo = "LONG_ROL";

	private String lParametroNumeroEmpresa = "INTEGER_NO_EMPRESAS";

	private String lParametroNumeroTransaccion = "INTEGER_NO_TRANSACCION";

	private String lParametroNumeroUsuario = "INTEGER_NO_USUARIO";

	private String lParametroVigenciaMeses = "INTEGER_VIGENCIA_MESES";

	private String lParametroMailDemo = "STRING_MAIL";

	private String lParametroAsuntoMailDemo = "STRING_ASUNTO_MAIL";

	private String lParametroCuentaCopiaMailDemo = "STRING_COPIA_MAIL";

	@EJB
	private ServicioMantenedorSolicitud lServicioSolicitud;

	
	@EJB
	private ServicioMantenedorAsociadoWeb lServicioAsociadoWeb;

	@EJB
	private ServicioMantenedorUsuario lServicioUsuario;

	@EJB
	private ServicioMantenedorRol lServicioRol;

	@EJB
	private ServicioMantenedorUsuarioRol lServicioMantenedorUsuarioRol;

	@EJB
	private ServicioNotificacionMail lServicioEmail;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void procesarSolicitud(OmgSolicitudUsoAplicacion lSolicitud, HashMap<String, String> lParametros) {
		
		
		// Obtener parámetros
		String lDiasVigente = lParametros.get(lParametroTiempoVigenciaDiasUsuario);
		Integer lDiasVigenteUsuario = Integer.valueOf(lDiasVigente);
		String lClaveDefault = lParametros.get(lParametroClaveDefault);
		String lPrefijoUsuario = lParametros.get(lParametroPrefijoUsuario);
		String lRolDemo = lParametros.get(lParametroRolDemo);
		String lNumeroEmpresa = lParametros.get(lParametroNumeroEmpresa);
		Integer lNumeroEmpresasPermitidas = Integer.valueOf(lNumeroEmpresa);
		String lNummeroUsuario = lParametros.get(lParametroNumeroUsuario);
		Integer lTotalUsuarioCrear = Integer.valueOf(lNummeroUsuario);
		String lNumeroTransaccion = lParametros.get(lParametroNumeroTransaccion);
		Integer lTotalTransaccion = Integer.valueOf(lNumeroTransaccion);
		String lVigenciaMeses = lParametros.get(lParametroVigenciaMeses);
		Integer lMeses = Integer.valueOf(lVigenciaMeses);
		Long lIdRolDemo = Long.valueOf(lRolDemo);
		Calendar lCalendario = Calendar.getInstance();
		lCalendario.add(Calendar.DATE, lDiasVigenteUsuario);
		String lCuerpoEmail = lParametros.get(lParametroMailDemo);
		String lAsuntoEmail = lParametros.get(lParametroAsuntoMailDemo);
		String lCuentaCopiaEmail = lParametros.get(lParametroCuentaCopiaMailDemo);
		
		// Creación de usuario
		OmsUsuario lUsuario = new OmsUsuario();
		lUsuario.setCorreo(lSolicitud.getlEmail());
		lUsuario.setEsNuevo("S");
		lUsuario.setlFechaVencimiento(lCalendario.getTime());
		lUsuario.setClave(lClaveDefault);
		lUsuario.setUsuario(lPrefijoUsuario + new Date().getTime());
		lUsuario.setAuditoria(lSolicitud.getAuditoria());
		lUsuario.setIdReferencia(lSolicitud.getIdReferencia());
		lUsuario.setObservacion("CREACIÓN AUTOMÁTICA DE USUARIO, POR MEDIO DE SOLICITUD WEB");
		lUsuario.setlDescripcion(lSolicitud.getlNombre());
		
		OmsRole lRol = lServicioRol.buscarRolPorID(lIdRolDemo);

		OmsUsuariosRole lUsuarioRol = new OmsUsuariosRole();
		lUsuarioRol.setPriRole(lRol);
		lUsuarioRol.setPriUsuario(lUsuario);
		lUsuarioRol.setAuditoria(lSolicitud.getAuditoria());
		lUsuarioRol.setIdReferencia(lSolicitud.getIdReferencia());
		
		OmgAsociadoWeb lAsociado = new OmgAsociadoWeb();
		lAsociado.setlEmailResponsable(lSolicitud.getlEmail());
		lAsociado.setlClaveAdministrador(lClaveDefault);
		lAsociado.setlFechaInicio(new Date());
		lAsociado.setlFechaFinal(lUsuario.getlFechaVencimiento());
		lAsociado.setlIdSolicitud(lSolicitud.getId() + "");
		lAsociado.setlNumeroEmpresas(lNumeroEmpresasPermitidas);
		lAsociado.setlNumeroTransacciones(lTotalTransaccion);
		lAsociado.setlNumeroUsuarios(lTotalUsuarioCrear);
		lAsociado.setlResponsable(lSolicitud.getlNombre());
		lAsociado.setlRolAsignado((lRol.getId() + ""));
		lAsociado.setlTelefonoContacto(lSolicitud.getlCelular());
		lAsociado.setlTipoAsociado(TIPO_ASOCIADO.DEMOSTRADO);
		lAsociado.setlUsuarioAdministrador(lUsuario.getUsuario());
		lAsociado.setlVigenciaMeses(lMeses);
		lAsociado.setAuditoria(lSolicitud.getAuditoria());
		lAsociado.setIdReferencia(lSolicitud.getIdReferencia());

		lSolicitud.setlUsuarioDemoCreado(lUsuario.getUsuario());
		lSolicitud.setlEmailEnviado("S");
		lSolicitud.setEstado("D");

		try {
			lServicioUsuario.guardarActualizar(lUsuario);
			lServicioMantenedorUsuarioRol.guardarActualizar(lUsuarioRol);
			lServicioAsociadoWeb.guardarActualizar(lAsociado);
			lServicioSolicitud.guardarActualizar(lSolicitud);
			lServicioEmail.enviarEmail(Arrays.asList(new String[] { lUsuario.getCorreo(), lCuentaCopiaEmail }),
					lAsuntoEmail, lCuerpoEmail.replaceAll(USUARIO_WEB, lUsuario.getUsuario()).replaceAll(CLAVE_WEB, lClaveDefault) );
			System.out.println("Creación de usuario realizada correctamente");
		} catch (ErrorServicioNegocio | ErrorValidacionGeneral lError) {
			System.out.println("Error al crear el usuario web");
			lError.printStackTrace();
		} catch (Throwable e) {
			System.out.println("Error al enviar el email");
			e.printStackTrace();
		}
	}

}
