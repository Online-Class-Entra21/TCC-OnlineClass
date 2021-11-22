package backend.api;

import java.io.IOException;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Executa a API Rest através de uma aplicação SpringBoot
 * @author Breno
 * 
 */
@SpringBootApplication
public class BackendApplication {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(BackendApplication.class);
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		SpringApplication.run(BackendApplication.class, args);
		LOGGER.info("Iniciado com sucesso");
	}
	
	
}
