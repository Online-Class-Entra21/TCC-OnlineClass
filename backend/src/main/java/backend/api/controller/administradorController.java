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
	 * Retorna o administrador que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/administrador/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista de administradores registrados no sistema {GET}
	 * @return Administrador lista
	 */
	@GetMapping(path = "/api/administradores")
	public List<Administrador> consultar(){
		return null;
	}

	/**
	 * Metodo para alteração das informações do usuario administrador {PUT}
	 * @param codigo
	 */
	@PutMapping(path = "api/administrador/alterar/{codigo}")
	public void alterar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 3 principais 
	//------------------------------------------------------------------
}
