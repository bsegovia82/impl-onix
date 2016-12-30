package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgSolicitudUsoAplicacion;
import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.eao.aplicacion.OmgSolicitudUsoAplicacionEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorSolicitud extends ServicioMantenimientoEntidad<OmgSolicitudUsoAplicacionEAO, OmgSolicitudUsoAplicacion, Long> {

	@EJB
	private OmgSolicitudUsoAplicacionEAO crud;

	protected OmgSolicitudUsoAplicacionEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmgSolicitudUsoAplicacion entidad) throws ErrorServicioNegocio {
		OmgSolicitudUsoAplicacion entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmail", entidad.getlEmail(), OmgSolicitudUsoAplicacion.class);
		if (entidadBase != null) {
				throw new ErrorServicioNegocio("Ya se encuentra registrado el correo electrónico " + entidad.getlEmail()
						+ ", ya se encuentra registrado para otra persona");
			
		}
	}

	@Override
	protected void validacionesBasicasActualizar(OmgSolicitudUsoAplicacion entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION : entidad
				.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria().length() < 2 ? REFERENCIA : entidad.getAuditoria());
	}

	@Override
	protected void validacionesConBaseGuardar(OmgSolicitudUsoAplicacion entidad) throws ErrorServicioNegocio {
		OmgSolicitudUsoAplicacion entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmail", entidad.getlEmail(), OmgSolicitudUsoAplicacion.class);
		if (entidadBase != null) {
				throw new ErrorServicioNegocio("Ya se encuentra registrado el correo electrónico " + entidad.getlEmail()
						+ ", ya se encuentra registrado para otra persona");
			
		}
	}

	@Override
	protected void validacionesBasicasGuardar(OmgSolicitudUsoAplicacion entidad) throws ErrorValidacionGeneral {

		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION : entidad
				.getObservacion());
		entidad.setAuditoria(REFERENCIA);
	}

	protected void actualizacionPrevia(OmsOpcione entidad) {
		System.out.println("Sin nada que hacer actualizacion previa");

	}

}