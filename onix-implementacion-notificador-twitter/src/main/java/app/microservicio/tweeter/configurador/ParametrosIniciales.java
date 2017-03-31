package app.microservicio.tweeter.configurador;

import org.springframework.stereotype.Component;

@Component
public class ParametrosIniciales 
{

	private String lidProceso;
	
	public void setLidProceso(String lidProceso) {
		this.lidProceso = lidProceso;
	}
	
	public String getLidProceso() {
		return lidProceso;
	}
	
}
