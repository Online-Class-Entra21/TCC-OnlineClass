package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Endereco;

/**
 * Metodo controller do endereco para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class enderecoController {
	
	/**
	 * Retorna o endereco que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/endereco/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista de enderecos registrados no sistema {GET}
	 * @return Endereco lista
	 */
	@GetMapping(path = "/api/enderecos")
	public List<Endereco> consultar(){
		return null;
	}
	
	/**
	 * Insere um novo endereco no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/endereco/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração do endereco que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/endereco/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão do endereco que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/endereco/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
