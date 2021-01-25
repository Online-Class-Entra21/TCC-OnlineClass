package backend.api;

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
	public static void main(String[] args) {
		LOGGER.info("Teste Erro");
		SpringApplication.run(BackendApplication.class, args);
	}
}
