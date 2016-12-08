package com.onix.modulo.eao.aplicacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmsAccesosDirecto;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsAccesosDirectoEAO extends OnixEAO<OmsAccesosDirecto, Long> {

	public OmsAccesosDirecto obtenerAcceso(Long idAcceso) {
		return obtenerObjetoPorPk(idAcceso, OmsAccesosDirecto.class);
	}

}
