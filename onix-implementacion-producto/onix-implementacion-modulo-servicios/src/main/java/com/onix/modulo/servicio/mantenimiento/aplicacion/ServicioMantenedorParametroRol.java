package com.onix.modulo.servicio.mantenimiento.aplicacion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgParametrosRol;
import com.onix.modulo.eao.aplicacion.OmgParametrosRolEAO;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorParametroRol
		extends ServicioMantenedorControlAuditoria<OmgParametrosRolEAO, OmgParametrosRol, Long> {
	@EJB
	private OmgParametrosRolEAO crud;

	protected OmgParametrosRolEAO getCrud() {
		return crud;
	}

	@Override
	protected void cargarConfiguracionServicio() {
		System.out.println("NO EXISTEN CONFIGURACIONES A REALIZAR EN EL SERVICIO");
	}

}
