package com.onix.modulo.eao.localizacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.localizacion.OmslCanton;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmslCantonEAO extends OnixEAO<OmslCanton, Long> {

}
