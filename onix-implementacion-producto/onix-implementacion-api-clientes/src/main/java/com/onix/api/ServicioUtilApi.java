package com.onix.api;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class ServicioUtilApi {

	private ServicioUtilApi(){}
	
	public static Map<String, Object> parseObjetoMapa(Object obj) throws Exception {
	    Map<String, Object> lResultado = new HashMap<String, Object>();
	    BeanInfo lInformacinBean = Introspector.getBeanInfo(obj.getClass());
	    for (PropertyDescriptor lDescriptorPropiedad : lInformacinBean.getPropertyDescriptors()) {
	        Method lLectorClase = lDescriptorPropiedad.getReadMethod();
	        if (lLectorClase != null)
	            lResultado.put(lDescriptorPropiedad.getName(), lLectorClase.invoke(obj));
	    }
	    return lResultado;
	}
	
}
