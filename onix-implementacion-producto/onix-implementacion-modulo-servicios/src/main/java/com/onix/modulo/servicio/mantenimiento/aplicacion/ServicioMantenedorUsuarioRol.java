package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsUsuariosRole;
import com.onix.modulo.eao.aplicacion.OmsUsuariosRoleEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorUsuarioRol extends
		ServicioMantenimientoEntidad<OmsUsuariosRoleEAO, OmsUsuariosRole, Long> {

	@EJB
	private OmsUsuariosRoleEAO crud;

	protected OmsUsuariosRoleEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmsUsuariosRole entidad) throws ErrorServicioNegocio {
		System.out.println("sin nada que hacer");
	}

	@Override
	protected void validacionesBasicasActualizar(OmsUsuariosRole entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION
				: entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());
	}

	@Override
	protected void validacionesConBaseGuardar(OmsUsuariosRole entidad) throws ErrorServicioNegocio {
		System.out.println("sin nada que hacer");
	}

	@Override
	protected void validacionesBasicasGuardar(OmsUsuariosRole entidad) throws ErrorValidacionGeneral {

		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion() == null || entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION
				: entidad.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria() == null || entidad.getAuditoria().length() < 2 ? REFERENCIA
				: entidad.getAuditoria());
	}

	protected void actualizacionPrevia(OmsUsuariosRole entidad) {
		System.out.println("Sin nada que hacer actualizacion previa");

	}

	
	protected void persistenciaPrevia(OmsUsuariosRole entidad) {
		System.out.println("Sin nada que hacer actualizacion previa");
	}

	
	protected void postActualizacion(OmsUsuariosRole entidad) {
		// TODO Auto-generated method stub

	}

	
	protected void postPersistencia(OmsUsuariosRole entidad) {
		// TODO Auto-generated method stub

	}

	public void eliminarRolesUsuario(Long idUsuario) {
		crud.eliminarUsuarioRol(idUsuario);
	}
}
