package com.onix.modulo.despachador.vigenciausuario;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.onix.modulo.dominio.aplicacion.OmsUsuario;
import com.onix.modulo.servicio.mantenimiento.aplicacion.ServicioMantenedorUsuario;

@Stateless
public class FachadaControlVigenciaUsuario {

	@EJB
	private ServicioMantenedorUsuario lServicioUsuario;

	@EJB
	private ServicioControlVigencia lServicioControlVigencia;

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void inactivacionUsuariosVigencia() {
		for (OmsUsuario lUsuario : lServicioUsuario.listaObjetosActivos(OmsUsuario.class))
			try {
				lServicioControlVigencia.verificacionVigenciaUsuario(lUsuario);
			} catch (Throwable lError) {
				lError.printStackTrace();
			}
	}

}
