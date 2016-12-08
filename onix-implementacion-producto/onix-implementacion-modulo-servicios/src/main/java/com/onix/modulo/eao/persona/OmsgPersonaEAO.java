package com.onix.modulo.eao.persona;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.persona.OmsgPersona;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsgPersonaEAO extends OnixEAO<OmsgPersona, Long> {

}
