package com.onix.modulo.eao.aplicacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.aplicacion.OmgDetallePlan;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmgDetallePlanEAO  extends OnixEAO<OmgDetallePlan, Long>
{

}