package app.microservicio.tweeter.componente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class GestorVictima {

	private List<String> listaVictimas;

	@Autowired
	private ResourceLoader resourceLoader;

	@PostConstruct
	public void inicializarListaVictimas() {

		listaVictimas = new ArrayList<>();
		Resource resource = resourceLoader.getResource("classpath:victimas.txt");

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
			String lVictima = null;
			while ((lVictima = br.readLine()) != null) {
				listaVictimas.add(lVictima);
			}
		} catch (Exception error) {
			error.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<String> getListaVictimas() {
		return listaVictimas;
	}

}
