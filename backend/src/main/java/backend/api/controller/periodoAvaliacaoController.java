package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.PeriodoAvaliacao;

/**
 * Metodo controller do periodoAvaliacao para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class periodoAvaliacaoController {
	
	/**
	 * Retorna o periodoAvaliacao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/periodoAvaliacao/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista dos periodoAvaliacoes registrados no sistema {GET}
	 * @return PeriodoAvaliacao lista
	 */
	@GetMapping(path = "/api/periodoAvaliacoes")
	public List<PeriodoAvaliacao> consultar(){
		return null;
	}
	
	/**
	 * Insere uma nova escola no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/escola/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração do periodoAvaliacao que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/periodoAvaliacao/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão do periodoAvaliacao que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/periodoAvaliacao/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
