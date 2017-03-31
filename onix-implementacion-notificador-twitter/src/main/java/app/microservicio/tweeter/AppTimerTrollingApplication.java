package app.microservicio.tweeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppTimerTrollingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTimerTrollingApplication.class, args);
	}
}    

