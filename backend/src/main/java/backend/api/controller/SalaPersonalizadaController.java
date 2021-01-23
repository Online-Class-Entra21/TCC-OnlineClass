package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.SalaPersonalizada;

/**
 * Metodo controller da salaPersonalizada para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class SalaPersonalizadaController {
	
	/**
	 * Retorna a salaPersonalizada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/salaPersonalizada/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista das salasPersonalizadas registrados no sistema {GET}
	 * @return lista de salasPersonalizadas registradas no banco
	 */
	@GetMapping(path = "/api/salasPersonalizadas")
	public List<SalaPersonalizada> consultar(){
		return null;
	}
	
	/**
	 * Insere uma nova salaPersonalizada no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/salaPersonalizada/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração da salaPersonalizada que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/salaPersonalizada/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão da salaPersonalizada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/salaPersonalizada/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
}
