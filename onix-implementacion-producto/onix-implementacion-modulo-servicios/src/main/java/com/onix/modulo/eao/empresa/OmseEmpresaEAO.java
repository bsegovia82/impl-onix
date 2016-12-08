package com.onix.modulo.eao.empresa;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.onix.modulo.dominio.empresa.OmseEmpresa;
import com.onix.modulo.eao.OnixEAO;

@Stateless
@LocalBean
public class OmseEmpresaEAO extends OnixEAO<OmseEmpresa, Long> {

}
