package com.onix.modulo.servicio.mantenimiento.aplicacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgParametro;
import com.onix.modulo.eao.aplicacion.OmgParametroEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorParametro
		extends ServicioMantenedorControlAuditoria<OmgParametroEAO, OmgParametro, Long> {
	@EJB
	private OmgParametroEAO crud;

	protected OmgParametroEAO getCrud() {
		return crud;
	}

	public String obtenerValorParametro(String lNombreParametro) {
		OmgParametro lParametroBase = this.obtenerObjetoPropiedad("lNombreParametro", lNombreParametro,
				OmgParametro.class);
		return lParametroBase == null ? null : lParametroBase.getlValorParametro();
	}

	@Override
	protected void cargarConfiguracionServicio() {
		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmgParametro, Long>() {

			@Override
			public void validacionTransaccional(OmgParametro entidad) throws ErrorServicioNegocio {
				OmgParametro entidadBase = crud.obtenerObjetoPorCampoGenerico("lNombreParametro",
						entidad.getlNombreParametro(), OmgParametro.class);
				if (entidadBase != null)
					throw new ErrorServicioNegocio(
							"Ya se encuentra registrado el correo electrónico " + entidad.getlNombreParametro());

			}
		});
		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmgParametro, Long>() {

			@Override
			public void validacionTransaccional(OmgParametro entidad) throws ErrorServicioNegocio {
				OmgParametro entidadBase = crud.obtenerObjetoPorCampoGenerico("lNombreParametro",
						entidad.getlNombreParametro(), OmgParametro.class);
				if (entidadBase != null)
					throw new ErrorServicioNegocio(
							"Ya se encuentra registrado el correo electrónico " + entidad.getlNombreParametro());
			}
		});

	}

}
