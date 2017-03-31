package com.onix.modulo.servicio.mantenimiento.empresa;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.empresa.OmseEmpresa;
import com.onix.modulo.eao.empresa.OmseEmpresaEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorEmpresa extends ServicioMantenedorControlAuditoria<OmseEmpresaEAO, OmseEmpresa, Long> {

	@EJB
	private OmseEmpresaEAO crud;

	protected OmseEmpresaEAO getCrud() {
		return crud;
	}

	@Override
	protected void cargarConfiguracionServicio() {

		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmseEmpresa, Long>() {
			@Override
			public void validacionTransaccional(OmseEmpresa entidad) throws ErrorServicioNegocio {
				OmseEmpresa empresa = crud.obtenerObjetoPorCampoGenerico("ruc", entidad.getRuc(), OmseEmpresa.class);
				if (empresa != null && !entidad.getId().equals(empresa.getId()))
					throw new ErrorServicioNegocio(
							"La empresa con número de ruc " + empresa.getRuc() + ", ya se encuentra registrado");
				empresa = crud.obtenerObjetoPorCampoGenerico("razonSocial", entidad.getRazonSocial(),
						OmseEmpresa.class);
				if (empresa != null && !entidad.getId().equals(empresa.getId()))
					throw new ErrorServicioNegocio(
							"La empresa con razón social " + empresa.getRazonSocial() + ", ya se encuentra registrado");

				empresa = crud.obtenerObjetoPorCampoGenerico("nombreComercial", entidad.getNombreComercial(),
						OmseEmpresa.class);
				if (empresa != null && !entidad.getId().equals(empresa.getId()))
					throw new ErrorServicioNegocio("La empresa con nombre comercial " + empresa.getNombreComercial()
							+ ", ya se encuentra registrado");

			}

		});

		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmseEmpresa, Long>() {

			@Override
			public void validacionTransaccional(OmseEmpresa entidad) throws ErrorServicioNegocio {
				OmseEmpresa empresa = crud.obtenerObjetoPorCampoGenerico("ruc", entidad.getRuc(), OmseEmpresa.class);
				if (empresa != null)
					throw new ErrorServicioNegocio(
							"La empresa con número de ruc " + empresa.getRuc() + ", ya se encuentra registrado");
				empresa = crud.obtenerObjetoPorCampoGenerico("razonSocial", entidad.getRazonSocial(),
						OmseEmpresa.class);
				if (empresa != null)
					throw new ErrorServicioNegocio(
							"La empresa con razón social " + empresa.getRazonSocial() + ", ya se encuentra registrado");

				empresa = crud.obtenerObjetoPorCampoGenerico("nombreComercial", entidad.getNombreComercial(),
						OmseEmpresa.class);
				if (empresa != null)
					throw new ErrorServicioNegocio("La empresa con nombre comercial " + empresa.getNombreComercial()
							+ ", ya se encuentra registrado");

			}
		});
	}

}
