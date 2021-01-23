package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Administrador;

/**
 * Metodo controller do administrador para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class administradorController {
	
	/**
	 * Retorna a lista de administradores registrados no sistema {GET}
	 * @return lista de administradores registrados no banco 
	 */
	@GetMapping(path = "/api/administradores")
	public List<Administrador> consultar(){
		return null;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 3 principais 
	//------------------------------------------------------------------
}
