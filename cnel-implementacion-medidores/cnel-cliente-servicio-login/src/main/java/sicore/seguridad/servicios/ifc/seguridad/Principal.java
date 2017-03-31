package sicore.seguridad.servicios.ifc.seguridad;

import bpe.common.servicios.peticiones.Peticion;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Seguridad_Service servicioSeguridad = new Seguridad_Service();
		Seguridad endPointSeguridad = servicioSeguridad.getBasicHttpBindingSeguridad();
		
		Peticion lPeticion = new Peticion();
		
		ConsultarLoginRespuesta lResultado = endPointSeguridad.consultaLogin(lPeticion, "TECNIELEC", "TECNIELEC");
		
		System.out.println(lResultado.getCodigo());
		System.out.println(lResultado.getDescripcion());
		System.out.println(lResultado.getDuracionTarea());
		System.out.println(lResultado.getTipo());
		System.out.println(lResultado.getIdMensaje());
		System.out.println(lResultado.getUsuario().getCodigoContratista());
		System.out.println(lResultado.getUsuario().getUserNombre());
		
	}

}
