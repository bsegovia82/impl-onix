package com.onix.modulo.servicio.mantenimiento.aplicacion;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsAccesosDirecto;
import com.onix.modulo.dominio.aplicacion.OmsOpcione;
import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.eao.aplicacion.OmsAccesosDirectoEAO;
import com.onix.modulo.librerias.eao.GenericEAO;
import com.onix.modulo.librerias.exceptions.ErrorServicioNegocio;
import com.onix.modulo.librerias.exceptions.ErrorValidacionGeneral;
import com.onix.modulo.servicio.ServicioMantenedorControlAuditoria;

@Stateless
public class ServicioMantenedorAccesoDirecto
		extends ServicioMantenedorControlAuditoria<OmsAccesosDirectoEAO, OmsAccesosDirecto, Long> {
	@EJB
	private OmsAccesosDirectoEAO crud;

	@EJB
	private ServicioMantenedorUsuario lServicioUsuario;
	
	@EJB
	private ServicioMantenedorOpcion lServicioOpcion;
	
	@Override
	protected void cargarConfiguracionServicio() {
		System.out.println("No existen configuraciones del servicios");

	}

	@Override
	protected OmsAccesosDirectoEAO getCrud() {
		return crud;
	}

	public List<String> obtenerAccesosAsignadosActivos(Long id) {

		String lQuery = "select (select opcion from oms_opciones where id = id_opcion ) opcion  "
				+ "from OMS_ACCESOS_DIRECTOS where id_usuario = :idUsuario  and estado = 'A'";
		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idUsuario", id);
		return crud.ejecutarNativeQueryList(lQuery, lParametros, String.class);
	}
	
	public List<OmsAccesosDirecto> obtenerAccesosDirectosUsuario(Long id) {

		String lQuery = "select * "
				+ "from OMS_ACCESOS_DIRECTOS where id_usuario = :idUsuario  and estado = 'A'";
		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idUsuario", id);
		return crud.ejecutarQueryNativo(lQuery, lParametros, OmsAccesosDirecto.class);
	}
	
	public List<String> obtenerAccesosPorAsignar(Long id) {
		String lQuery = "select opcion from oms_opciones pOpciones  " + "where pOpciones.id in ( "
				+ "select id_opcion from oms_opciones_roles rDato where rDato.id_rol in ( "
				+ "select id_rol from oms_usuarios_roles tDato " + "where tDato.id_usuario = :idUsuario"
				+ "	and tDato.estado = 'A' ) " + "and rDato.estado = 'A' ) " + "and pOpciones.estado = 'A' "
				+ "and pOpciones.accion is not null " + "and pOpciones.id not in ( "
				+ "select id_opcion from OMS_ACCESOS_DIRECTOS where id_usuario = :idUsuario  and estado = 'A' )";

		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idUsuario", id);
		return crud.ejecutarNativeQueryList(lQuery, lParametros, String.class);
	}

	public void asigarAcceso(List<String> lAccesosSeleccionados, Long id, Long referencia, String usuarioAutenticado) throws ErrorServicioNegocio, ErrorValidacionGeneral
	{

		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idUsuario", id);

		for (String opcion : lAccesosSeleccionados) {
			lParametros.put("opcion", opcion);
			List<OmsAccesosDirecto> lAccesoBase = crud.ejecutarQueryNativo(
					"select * from OMS_ACCESOS_DIRECTOS where id_usuario = :idUsuario "
							+ "and id_opcion in (select id from oms_opciones where opcion = :opcion )",
					lParametros, OmsAccesosDirecto.class);
			OmsAccesosDirecto lAcceso = null;
			if (!lAccesoBase.isEmpty()) {
				lAcceso = lAccesoBase.get(0);
				lAcceso.setAuditoria(usuarioAutenticado);
				lAcceso.setFechaActualizacion(new Date());
				lAcceso.setEstado(GenericEAO.ESTADO_ACTIVO);
				lAcceso.setObservacion("ACTIVACION DE OPCION DESDE LA WEB POR EL USUARIO " + usuarioAutenticado);
			} else {
				lAcceso = new OmsAccesosDirecto();
				lAcceso.setAuditoria(usuarioAutenticado);
				lAcceso.setEstado(GenericEAO.ESTADO_ACTIVO);
				lAcceso.setFechaRegistro(new Date());
				lAcceso.setIdReferencia(referencia);
				lAcceso.setObservacion("REGISTRO DE OPCION DESDE LA WEB POR EL USUARIO " + usuarioAutenticado);
				lAcceso.setPriOpcione(lServicioOpcion.obtenerObjetoPropiedad("opcion", opcion, OmsOpcione.class));
				lAcceso.setPriUsuario(lServicioUsuario.obtenerObjetoPropiedad("usuario", usuarioAutenticado, OmsUsuario.class));
				
			}
			guardarActualizar(lAcceso);
		}

	}

	public void inactivarAcceso(List<String> lAccesosSeleccionados, Long id, String usuarioAutenticado)throws ErrorServicioNegocio, ErrorValidacionGeneral 
	{
		HashMap<String, Object> lParametros = new HashMap<>();
		lParametros.put("idUsuario", id);

		for (String opcion : lAccesosSeleccionados) {
			lParametros.put("opcion", opcion);
			List<OmsAccesosDirecto> lAccesoBase = crud.ejecutarQueryNativo(
					"select * from OMS_ACCESOS_DIRECTOS where id_usuario = :idUsuario "
							+ "and id_opcion in (select id from oms_opciones where opcion = :opcion )",
					lParametros, OmsAccesosDirecto.class);
			if (!lAccesoBase.isEmpty())
			{
				OmsAccesosDirecto lAcceso = lAccesoBase.get(0);			
				lAcceso.setAuditoria(usuarioAutenticado);
				lAcceso.setFechaActualizacion(new Date());
				lAcceso.setEstado(GenericEAO.ESTADO_INACTIVO);
				lAcceso.setObservacion("INACTIVACION DE OPCION DESDE LA WEB POR EL USUARIO " + usuarioAutenticado);
				guardarActualizar(lAcceso);
			}
		}
		
	}

}
