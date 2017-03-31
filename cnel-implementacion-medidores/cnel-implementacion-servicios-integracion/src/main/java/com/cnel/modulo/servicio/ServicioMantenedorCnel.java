package com.cnel.modulo.servicio;

import java.io.Serializable;

import com.onix.modulo.librerias.dominio.entidades.base.EntidadBaseAuditable;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

public abstract class ServicioMantenedorCnel<EAO extends GenericEAO<ENTIDAD, Id>, ENTIDAD extends EntidadBaseAuditable<Id>, Id extends Serializable>

		extends ServicioMantenimientoEntidad<EAO, ENTIDAD, Id> {
	

	@Override
	protected void validarControlAuditoriaExistente(ENTIDAD arg0) throws ErrorServicioNegocio {
		System.out.println("REGISTRO DE BITACORA");
	}   

}
