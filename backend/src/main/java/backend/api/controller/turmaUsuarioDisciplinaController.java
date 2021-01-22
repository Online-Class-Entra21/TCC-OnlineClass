package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.TurmaUsuarioDisciplina;

/**
 * Metodo controller da turmaUsuarioDisciplina para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class turmaUsuarioDisciplinaController {
	
	/**
	 * Retorna a turmaUsuarioDisciplina que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/turmaUsuarioDisciplina/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista das turmasUsuariosDisciplinas registrados no sistema {GET}
	 * @return TurmaUsuarioDisciplina lista
	 */
	@GetMapping(path = "/api/turmasUsuariosDisciplinas")
	public List<TurmaUsuarioDisciplina> consultar(){
		return null;
	}
	
	/**
	 * Insere uma nova turmaUsuarioDisciplina no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/turmaUsuarioDisciplina/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração da turmaUsuarioDisciplina que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/turmaUsuarioDisciplina/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão da turmaUsuarioDisciplina que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/turmaUsuarioDisciplina/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
