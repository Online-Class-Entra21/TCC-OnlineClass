package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.ArquivoUsuario;

/**
 * Metodo controller do arquivoUsuario para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class arquivoUsuarioController {
	
	/**
	 * Retorna o arquivoUsuario que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/arquivoUsuario/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista de arquivosUsuarios registrados no sistema {GET}
	 * @return ArquivoUsuario lista
	 */
	@GetMapping(path = "/api/arquivosUsuarios")
	public List<ArquivoUsuario> consultar(){
		return null;
	}
	
	/**
	 * Insere uma novo arquivosUsuario no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/aluno/arquivosUsuario/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração do arquivoUsuario que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/arquivoUsuario/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão do arquivoUsuario que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/arquivoUsuario/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
