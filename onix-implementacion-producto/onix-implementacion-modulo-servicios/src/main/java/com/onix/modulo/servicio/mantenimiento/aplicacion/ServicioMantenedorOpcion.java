package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.eao.aplicacion.OmsOpcioneEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.servicio.oyentes.AccionValidacionListener;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorOpcion extends ServicioMantenedorControlAuditoria<OmsOpcioneEAO, OmsOpcione, Long> {

	@EJB
	private OmsOpcioneEAO crud;

	protected OmsOpcioneEAO getCrud() {
		return crud;
	}

	public List<OmsOpcione> listaOpcionesEjecutables(String pUsuario) {
		return crud.listaOpcionesTerminales(pUsuario);
	}

	public List<OmsOpcione> listaOpcionesPadre(Long lReferencia) {
		HashMap<String, Object> listaParametros = new HashMap<>();
		listaParametros.put("referencia", lReferencia);
		return crud.ejecutarQueryNativo(
				"select g.* from OMS_OPCIONES g where g.id_referencia = :referencia and g.modulo_padre is null",
				listaParametros, OmsOpcione.class);
	}
	
	public List<OmsOpcione> listaOpcionesSubmenu(Long lReferencia) {
		HashMap<String, Object> listaParametros = new HashMap<>();
		listaParametros.put("referencia", lReferencia);
		return crud.ejecutarQueryNativo(
				"select g.* from OMS_OPCIONES g where g.id_referencia = :referencia  and g.accion is null",
				listaParametros, OmsOpcione.class);
	}
	
	public List<OmsOpcione> listaOpciones(Long lReferencia) {
		HashMap<String, Object> listaParametros = new HashMap<>();
		listaParametros.put("referencia", lReferencia);
		return crud.ejecutarQueryNativo(
				"select g.* from OMS_OPCIONES g where g.id_referencia = :referencia",
				listaParametros, OmsOpcione.class);
	}

	@Override
	protected void cargarConfiguracionServicio() {
		addValidacionTransaccionalInsertListener(new AccionValidacionListener<OmsOpcione, Long>() {

			@Override
			public void validacionTransaccional(OmsOpcione entidad) throws ErrorServicioNegocio {
				OmsOpcione opcion = crud.buscarOpcionPorNombre(entidad.getDescripcion());
				if (opcion != null)
					throw new ErrorServicioNegocio(
							"La opción " + opcion.getDescripcion() + ", ya se encuentra registrado");
			}
		});

		addValidacionTransaccionalUpdateListener(new AccionValidacionListener<OmsOpcione, Long>() {

			@Override
			public void validacionTransaccional(OmsOpcione entidad) throws ErrorServicioNegocio {
				OmsOpcione opcion = crud.buscarOpcionPorNombre(entidad.getDescripcion());
				if (opcion != null && !entidad.getId().equals(opcion.getId()))
					throw new ErrorServicioNegocio(
							"La opción " + opcion.getDescripcion() + ", ya se encuentra registrado para otra persona");
			}
		});
	}

}
