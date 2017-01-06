package com.onix.modulo.servicio.mantenimiento.aplicacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgAsociadoWeb;
import com.onix.modulo.eao.aplicacion.OmgAsociadoWebEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorAsociadoWeb
		extends ServicioMantenimientoEntidad<OmgAsociadoWebEAO, OmgAsociadoWeb, Long> {

	@EJB
	private OmgAsociadoWebEAO crud;

	protected OmgAsociadoWebEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmgAsociadoWeb entidad) throws ErrorServicioNegocio {
		OmgAsociadoWeb entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmail", entidad.getlEmailResponsable(),
				OmgAsociadoWeb.class);
		if (entidadBase != null) {
			throw new ErrorServicioNegocio("Ya se encuentra registrado el correo electrónico " + entidad.getlEmailResponsable()
					);

		}
	}

	@Override
	protected void validacionesConBaseGuardar(OmgAsociadoWeb entidad) throws ErrorServicioNegocio {
		OmgAsociadoWeb entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmail", entidad.getlEmailResponsable(),
				OmgAsociadoWeb.class);
		if (entidadBase != null) {
			throw new ErrorServicioNegocio("Ya se encuentra registrado el correo electrónico " + entidad.getlEmailResponsable()
					);

		}
	}

}
