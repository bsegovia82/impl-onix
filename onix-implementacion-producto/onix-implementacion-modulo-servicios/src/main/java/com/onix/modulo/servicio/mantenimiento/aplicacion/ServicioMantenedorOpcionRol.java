package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsOpcionesRole;
import com.onix.modulo.eao.aplicacion.OmsOpcionesRoleEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorOpcionRol
		extends ServicioMantenimientoEntidad<OmsOpcionesRoleEAO, OmsOpcionesRole, Long> {

	@EJB
	private OmsOpcionesRoleEAO crud;

	protected OmsOpcionesRoleEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmsOpcionesRole entidad) throws ErrorServicioNegocio {
		System.out.println("Sin nada que hacer");
	}

	@Override
	protected void validacionesBasicasActualizar(OmsOpcionesRole entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2
				? OBSERVACION_APLICACION : entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());
	}

	@Override
	protected void validacionesConBaseGuardar(OmsOpcionesRole entidad) throws ErrorServicioNegocio {
		System.out.println("Sin nada que hacer");
	}

	@Override
	protected void validacionesBasicasGuardar(OmsOpcionesRole entidad) throws ErrorValidacionGeneral {

		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2
				? OBSERVACION_APLICACION : entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());
	}

	public void eliminarOpcionesRole(Long idRol) {
		crud.eliminarOpcionesRol(idRol);
	}

	public List<OmsOpcione> listaOpcionesEjecutablesRol(Long idRol, String tipo) {
		return crud.obtenerListaOpcionesEjecutablesRol(idRol, tipo);  
	}  

}
