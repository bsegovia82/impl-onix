package com.onix.modulo.servicio.mantenimiento.aplicacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgSolicitudUsoAplicacion;
import com.onix.modulo.eao.aplicacion.OmgSolicitudUsoAplicacionEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorSolicitud
		extends ServicioMantenimientoEntidad<OmgSolicitudUsoAplicacionEAO, OmgSolicitudUsoAplicacion, Long> {

	@EJB
	private OmgSolicitudUsoAplicacionEAO crud;

	protected OmgSolicitudUsoAplicacionEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmgSolicitudUsoAplicacion entidad) throws ErrorServicioNegocio {
		OmgSolicitudUsoAplicacion entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmail", entidad.getlEmail(),
				OmgSolicitudUsoAplicacion.class);
		if (entidadBase != null) {
			throw new ErrorServicioNegocio("Ya se encuentra registrado el correo electrónico " + entidad.getlEmail()
					);

		}
	}

	@Override
	protected void validacionesConBaseGuardar(OmgSolicitudUsoAplicacion entidad) throws ErrorServicioNegocio {
		OmgSolicitudUsoAplicacion entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmail", entidad.getlEmail(),
				OmgSolicitudUsoAplicacion.class);
		if (entidadBase != null) {
			throw new ErrorServicioNegocio("Ya se encuentra registrado el correo electrónico " + entidad.getlEmail()
					);

		}
	}

}
