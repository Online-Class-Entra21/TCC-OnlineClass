package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Sala;

/**
 * Metodo controller da salaPadrao para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class SalaPadraoController {
	
	/**
	 * Retorna a salaPadrao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/salaPadrao/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista das salasPadroes registrados no sistema {GET}
	 * @return lista de salasPadroes registradas no banco
	 */
	@GetMapping(path = "/api/salasPadroes")
	public List<Sala> consultar(){
		return null;
	}
	
	/**
	 * Insere uma nova salaPadrao no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/salaPadrao/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração da salaPadrao que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/salaPadrao/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão da salaPadrao que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/salaPadrao/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
}
