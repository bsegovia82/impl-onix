package com.onix.modulo.servicio.mantenimiento.empresa;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.empresa.OmseEmpresa;
import com.onix.modulo.eao.empresa.OmseEmpresaEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.librerias.servicio.ServicioMantenimientoEntidad;

@Stateless
public class ServicioMantenedorEmpresa extends ServicioMantenimientoEntidad<OmseEmpresaEAO, OmseEmpresa, Long> {

	@EJB
	private OmseEmpresaEAO crud;

	protected OmseEmpresaEAO getCrud() {
		return crud;
	}

	@Override
	protected void validacionesConBaseActualizar(OmseEmpresa entidad) throws ErrorServicioNegocio {
		OmseEmpresa empresa = crud.obtenerObjetoPorCampoGenerico("ruc", entidad.getRuc(), OmseEmpresa.class);
		if (empresa != null) {
			if (!entidad.getId().equals(empresa.getId())) {
				throw new ErrorServicioNegocio("La empresa con número de ruc " + empresa.getRuc()
						+ ", ya se encuentra registrado");
			}
		}
		empresa = crud.obtenerObjetoPorCampoGenerico("razonSocial", entidad.getRazonSocial(), OmseEmpresa.class);
		if (empresa != null) {
			if (!entidad.getId().equals(empresa.getId())) {
				throw new ErrorServicioNegocio("La empresa con razón social " + empresa.getRazonSocial()
						+ ", ya se encuentra registrado");
			}
		}

		empresa = crud
				.obtenerObjetoPorCampoGenerico("nombreComercial", entidad.getNombreComercial(), OmseEmpresa.class);
		if (empresa != null) {
			if (!entidad.getId().equals(empresa.getId())) {
				throw new ErrorServicioNegocio("La empresa con nombre comercial " + empresa.getNombreComercial()
						+ ", ya se encuentra registrado");
			}
		}
	}

	@Override
	protected void validacionesBasicasActualizar(OmseEmpresa entidad) throws ErrorValidacionGeneral {
		entidad.setFechaActualizacion(new Date());
		entidad.setObservacion(entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION : entidad
				.getObservacion());
		entidad.setAuditoria(entidad.getAuditoria().length() < 2 ? REFERENCIA : entidad.getAuditoria());
	}

	@Override
	protected void validacionesConBaseGuardar(OmseEmpresa entidad) throws ErrorServicioNegocio {
		OmseEmpresa empresa = crud.obtenerObjetoPorCampoGenerico("ruc", entidad.getRuc(), OmseEmpresa.class);
		if (empresa != null) {
			throw new ErrorServicioNegocio("La empresa con número de ruc " + empresa.getRuc()
					+ ", ya se encuentra registrado");

		}
		empresa = crud.obtenerObjetoPorCampoGenerico("razonSocial", entidad.getRazonSocial(), OmseEmpresa.class);
		if (empresa != null) {

			throw new ErrorServicioNegocio("La empresa con razón social " + empresa.getRazonSocial()
					+ ", ya se encuentra registrado");

		}

		empresa = crud
				.obtenerObjetoPorCampoGenerico("nombreComercial", entidad.getNombreComercial(), OmseEmpresa.class);
		if (empresa != null) {
			throw new ErrorServicioNegocio("La empresa con nombre comercial " + empresa.getNombreComercial()
					+ ", ya se encuentra registrado");

		}
	}

	@Override
	protected void validacionesBasicasGuardar(OmseEmpresa entidad) throws ErrorValidacionGeneral {

		entidad.setEstado(GenericEAO.ESTADO_ACTIVO);
		entidad.setFechaRegistro(new Date());
		entidad.setObservacion(entidad.getObservacion().length() < 2 ? OBSERVACION_APLICACION : entidad
				.getObservacion());
		entidad.setAuditoria(REFERENCIA);

	}


	protected void actualizacionPrevia(OmseEmpresa entidad) {
		// TODO Auto-generated method stub
		
	}

	protected void persistenciaPrevia(OmseEmpresa entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void postActualizacion(OmseEmpresa entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void postPersistencia(OmseEmpresa entidad) {
		// TODO Auto-generated method stub
		
	}

}
