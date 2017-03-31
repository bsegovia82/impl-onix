package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgSolicitudUsoAplicacion;
import com.onix.modulo.eao.aplicacion.OmgSolicitudUsoAplicacionEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.oyentes.AccionTransaccionalListener;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorSolicitud
		extends ServicioMantenedorControlAuditoria<OmgSolicitudUsoAplicacionEAO, OmgSolicitudUsoAplicacion, Long> {

	@EJB
	private OmgSolicitudUsoAplicacionEAO crud;

	protected OmgSolicitudUsoAplicacionEAO getCrud() {
		return crud;
	}

	

	public List<OmgSolicitudUsoAplicacion> obtenerSolicitudesPendientes() {
		return getCrud().ejecutarQueryNativo(
				"select * from OMG_SOLICITUD_USO_APLICACION where " + " USUARIO_DEMO is null and EMAIL_ENVIADO is null",
				new HashMap<>(), OmgSolicitudUsoAplicacion.class);
	}

	@Override
	protected void cargarConfiguracionServicio() {
		
		addPreInsertListener(new AccionTransaccionalListener<OmgSolicitudUsoAplicacion, Long>() {
			
			@Override
			public void controlTransaccional(OmgSolicitudUsoAplicacion arg0)
					throws ErrorServicioNegocio, ErrorValidacionGeneral {
				arg0.setIdReferencia(new Date().getTime());
			}
		});
		
		
		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmgSolicitudUsoAplicacion, Long>() {

			@Override
			public void validacionTransaccional(OmgSolicitudUsoAplicacion entidad) throws ErrorServicioNegocio {
				OmgSolicitudUsoAplicacion entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmail",
						entidad.getlEmail(), OmgSolicitudUsoAplicacion.class);
				if (entidadBase != null)
					throw new ErrorServicioNegocio(
							"Ya se encuentra registrado el correo electrónico " + entidad.getlEmail());

			}
		});

	}

}
