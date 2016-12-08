package com.onix.modulo.eao.persona.operacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.persona.operacion.OmsoCliente;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsoClienteEAO extends OnixEAO<OmsoCliente, Long> {

}
