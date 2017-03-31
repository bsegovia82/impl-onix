package com.onix.modulo.servicio.mantenimiento.persona.social;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.persona.social.OmsoCuentaRedSocial;
import com.onix.modulo.eao.persona.social.OmsoCuentaRedSocialEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorCuentaRedSocial
		extends ServicioMantenedorControlAuditoria<OmsoCuentaRedSocialEAO, OmsoCuentaRedSocial, Long> {

	@EJB
	private OmsoCuentaRedSocialEAO crud;

	@Override
	protected OmsoCuentaRedSocialEAO getCrud() {
		return crud;
	}

	@Override
	protected void cargarConfiguracionServicio() {
		addValidacionTransaccionalUpdateListener((OmsoCuentaRedSocial entidad) -> {

			OmsoCuentaRedSocial entidadBase = crud.obtenerObjetoPorCampoGenerico("lUsuarioRedSocial",
					entidad.getlUsuarioRedSocial(), OmsoCuentaRedSocial.class);
			if (entidadBase != null && !entidadBase.getId().equals(entidad.getId()))
				throw new ErrorServicioNegocio(
						"El nombre del usuario " + entidadBase.getlUsuarioRedSocial() + ", ya se encuentra registrado");

		});

		addValidacionTransaccionalInsertListener((OmsoCuentaRedSocial entidad) -> {
			OmsoCuentaRedSocial entidadBase = crud.obtenerObjetoPorCampoGenerico("lUsuarioRedSocial",
					entidad.getlUsuarioRedSocial(), OmsoCuentaRedSocial.class);
			if (entidadBase != null)
				throw new ErrorServicioNegocio(
						"El nombre del cargo " + entidadBase.getlUsuarioRedSocial() + ", ya se encuentra registrado");

		});

	}

}
