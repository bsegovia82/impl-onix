package com.onix.modulo.servicio.mantenimiento.aplicacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgAsociadoWeb;
import com.onix.modulo.eao.aplicacion.OmgAsociadoWebEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorAsociadoWeb
		extends ServicioMantenedorControlAuditoria<OmgAsociadoWebEAO, OmgAsociadoWeb, Long> {
	@EJB
	private OmgAsociadoWebEAO crud;
	protected OmgAsociadoWebEAO getCrud() {
		return crud;
	}

	
	
	@Override
	protected void cargarConfiguracionServicio() {
		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmgAsociadoWeb, Long>() {

			@Override
			public void validacionTransaccional(OmgAsociadoWeb entidad) throws ErrorServicioNegocio {
				OmgAsociadoWeb entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmailResponsable",
						entidad.getlEmailResponsable(), OmgAsociadoWeb.class);
				if (entidadBase != null)
					throw new ErrorServicioNegocio(
							"Ya se encuentra registrado el correo electrónico " + entidad.getlEmailResponsable());

			}
		});
		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmgAsociadoWeb, Long>() {

			@Override
			public void validacionTransaccional(OmgAsociadoWeb entidad) throws ErrorServicioNegocio {
				OmgAsociadoWeb entidadBase = crud.obtenerObjetoPorCampoGenerico("lEmailResponsable",
						entidad.getlEmailResponsable(), OmgAsociadoWeb.class);
				if (entidadBase != null)
					throw new ErrorServicioNegocio(
							"Ya se encuentra registrado el correo electrónico " + entidad.getlEmailResponsable());
			}
		});

	}

}
