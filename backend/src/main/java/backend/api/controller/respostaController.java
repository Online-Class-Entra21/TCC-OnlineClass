package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Resposta;

/**
 * Metodo controller do resposta para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class respostaController {
	
	/**
	 * Retorna a resposta que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/resposta/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista das respostas registrados no sistema {GET}
	 * @return Resposta lista
	 */
	@GetMapping(path = "/api/respostas")
	public List<Resposta> consultar(){
		return null;
	}
	
	/**
	 * Insere uma nova resposta no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/resposta/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração da resposta que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/resposta/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão da resposta que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/resposta/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
