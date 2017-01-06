package com.onix.modulo.eao.aplicacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgAsociadoWeb;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmgAsociadoWebEAO  extends OnixEAO<OmgAsociadoWeb, Long>
{

}
