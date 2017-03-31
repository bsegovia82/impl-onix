package com.cnel.modulo.eao.bitacora;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.cnel.modulo.dominio.bitacora.CnelBitacora;
import com.cnel.modulo.eao.CnelEAO;

@Stateless
@LocalBean
public class CnelBitacoraEAO extends CnelEAO<CnelBitacora, Long> {

}
