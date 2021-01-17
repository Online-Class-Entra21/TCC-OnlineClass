package backend.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Testa a conexão com a API
 * @author Breno
 *
 */
@RestController
public class statusController {
	
	@GetMapping(path = "/api/status")
	public String check() {
		return "Online";
	}
}
