package com.onix.modulo.servicio.mantenimiento.aplicacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgTipoParametro;
import com.onix.modulo.eao.aplicacion.OmgTipoParametroEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorTipoParametro
		extends ServicioMantenedorControlAuditoria<OmgTipoParametroEAO, OmgTipoParametro, Long> {
	@EJB
	private OmgTipoParametroEAO crud;
	protected OmgTipoParametroEAO getCrud() {
		return crud;
	}

	@Override
	protected void cargarConfiguracionServicio() {
		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmgTipoParametro, Long>() {

			@Override
			public void validacionTransaccional(OmgTipoParametro entidad) throws ErrorServicioNegocio {
				OmgTipoParametro entidadBase = crud.obtenerObjetoPorCampoGenerico("lNombreTipo",
						entidad.getlNombreTipo(), OmgTipoParametro.class);
				if (entidadBase != null)
					throw new ErrorServicioNegocio(
							"Ya se encuentra registrado el correo electrónico " + entidad.getlNombreTipo());

			}
		});
		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmgTipoParametro, Long>() {

			@Override
			public void validacionTransaccional(OmgTipoParametro entidad) throws ErrorServicioNegocio {
				OmgTipoParametro entidadBase = crud.obtenerObjetoPorCampoGenerico("lNombreTipo",
						entidad.getlNombreTipo(), OmgTipoParametro.class);
				if (entidadBase != null)
					throw new ErrorServicioNegocio(
							"Ya se encuentra registrado el correo electrónico " + entidad.getlNombreTipo());
			}
		});

	}

}
