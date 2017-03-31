package com.onix.modulo.servicio;

import java.io.Serializable;

import javax.ejb.EJB;

import com.onix.modulo.eao.aplicacion.OmsUsuarioEAO;
import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

public abstract class ServicioMantenedorControlAuditoria<EAO extends GenericEAO<ENTIDAD, Id>, ENTIDAD extends EntidadBaseAuditable<Id>, Id extends Serializable>

		extends ServicioMantenimientoEntidad<EAO, ENTIDAD, Id> {
	@EJB
	private OmsUsuarioEAO lCrudUsuario;

	@Override
	protected void validarControlAuditoriaExistente(ENTIDAD arg0) throws ErrorServicioNegocio {
		if ("USR_WEB".equals(arg0.getAuditoria()))
			if (lCrudUsuario.buscarUsuario(arg0.getAuditoria()) == null) {
				throw new ErrorServicioNegocio("EL USUARIO RESPONSABLE NO EXISTE");
			}
	}

}
