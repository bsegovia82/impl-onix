package com.onix.modulo.eao.persona;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.persona.OmsgTipoDocumentoIdentificacion;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmsgTipoDocumentoIdentificacionEAO extends OnixEAO<OmsgTipoDocumentoIdentificacion, Long> {

}
