package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Chamada;

/**
 * Metodo controller da chamada para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class chamadaController {
	
	/**
	 * Retorna a chamada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/chamada/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista de chamadas registrados no sistema {GET}
	 * @return Chamada lista
	 */
	@GetMapping(path = "/api/chamadas")
	public List<Chamada> consultar(){
		return null;
	}
	
	/**
	 * Insere uma nova chamada no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/chamada/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração da chamada que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/chamada/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão da chamada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/chamada/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
