package com.onix.modulo.servicio.mantenimiento.persona.operacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.persona.operacion.OmsoEspecialidad;
import com.onix.modulo.eao.persona.operacion.OmsoEspecialidadEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorEspecialidad
		extends ServicioMantenedorControlAuditoria<OmsoEspecialidadEAO, OmsoEspecialidad, Long> {

	@EJB
	private OmsoEspecialidadEAO crud;

	protected OmsoEspecialidadEAO getCrud() {
		return crud;
	}

	@Override
	protected void cargarConfiguracionServicio() {

		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmsoEspecialidad, Long>() {

			@Override
			public void validacionTransaccional(OmsoEspecialidad entidad) throws ErrorServicioNegocio {
				OmsoEspecialidad especilidad = crud.obtenerObjetoPorCampoGenerico("nombreEspecialidad",
						entidad.getNombreEspecialidad(), OmsoEspecialidad.class);
				if (especilidad != null) {
					throw new ErrorServicioNegocio(
							"La especialidad " + especilidad.getNombreEspecialidad() + ", ya se encuentra registrado");
				}

			}
		});
		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmsoEspecialidad, Long>() {

			@Override
			public void validacionTransaccional(OmsoEspecialidad entidad) throws ErrorServicioNegocio {
				OmsoEspecialidad especilidad = crud.obtenerObjetoPorCampoGenerico("nombreEspecialidad",
						entidad.getNombreEspecialidad(), OmsoEspecialidad.class);
				if (especilidad != null) {
					if (!especilidad.getId().equals(entidad.getId())) {
						throw new ErrorServicioNegocio("La especialidad " + especilidad.getNombreEspecialidad()
								+ ", ya se encuentra registrado");
					}
				}

			}
		});
	}

}
