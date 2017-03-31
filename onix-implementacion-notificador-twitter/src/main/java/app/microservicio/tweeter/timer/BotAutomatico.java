package app.microservicio.tweeter.timer;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import app.microservicio.tweeter.componente.GestorVictima;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;

@Component
public class BotAutomatico {

	@Value("${app.tweeter.mensaje}")
	private String mensaje;
	
	@Value("${app.tweeter.htg}")
	private String hashTag;
	
	@Value("${app.tweeter.ruta}")
	private String ruta;
	
	@Value("${app.tweeter.mensaje2}")
	private String mensaje2;
	
	@Autowired
	private Twitter tweeter;

	@Autowired
	private GestorVictima lGestorVictima;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Scheduled(fixedDelay=3600000)
	public void actualizacionEstado() {
		
		try {
			System.out.println("Procesando Ataque");
			
			Resource resource = resourceLoader.getResource("classpath:evidencia.jpg");
			
			for (String lVictima : lGestorVictima.getListaVictimas())
			{
				String semilla = Long.toString((new Date()).getTime());
				String estado = ". " + lVictima +  " " + mensaje + " " + hashTag + " donde esta el #IVA14 @MashiRafael @JorgeGlas " +  semilla.substring(semilla.length()-3, semilla.length()) ;
				System.out.println(estado);
				StatusUpdate status = new StatusUpdate(estado);
				
				
				
				tweeter.updateStatus(
						status);
				
				Thread.sleep(60000);
				
				estado = ". " + lVictima +  " " + mensaje2 + " " + hashTag + " " +  semilla.substring(semilla.length()-3, semilla.length()) ;
				System.out.println(estado);
				status = new StatusUpdate(estado);
				status.setMedia(resource.getFile());		
				tweeter.updateStatus(
						status);
				
				
				Thread.sleep(60000);
				
				estado = ". " + lVictima +  "  ojo con este meco asilvestrado, defensor de corruptos y violadores #Botaloscontuvoto " +  semilla.substring(semilla.length()-3, semilla.length()) ;
				System.out.println(estado);
				status = new StatusUpdate(estado);
				status.setMedia(resource.getFile());		
				tweeter.updateStatus(
						status);
				
				Thread.sleep(60000);
				
			}
			
			
//			StatusUpdate status = new StatusUpdate("Para el común de los mortales, como éste hp @OposicionTruch2, tweeter es sólo una red social "+ Long.toString((new Date()).getTime()).substring(0, 4));
//	        status.setMedia(new File("C:\\Users\\jbravo\\Desktop\\documentos\\mecoT.jpg"));
//	        
//	        tweeter.updateStatus(
//					status);
//	        
//	        status = new StatusUpdate("Para el común de los mortales, como éste hp @OposicionTruch2, tweeter es sólo una red social "+ Long.toString((new Date()).getTime()).substring(0, 4));
//	        status.setMedia(new File("C:\\Users\\jbravo\\Desktop\\documentos\\mecoT.jpg"));
//	        
//	        tweeter.updateStatus(
//					status);
	        
			System.out.println("Tweet enviado");
		} catch (Throwable error) {
			error.printStackTrace();  
		}

	}

}
