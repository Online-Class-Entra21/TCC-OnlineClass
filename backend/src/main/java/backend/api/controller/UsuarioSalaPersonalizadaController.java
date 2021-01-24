package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.UsuarioSalaPersonalizada;

/**
 * Metodo controller do usuarioSalaPersonalizada para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class UsuarioSalaPersonalizadaController {
	
	/**
	 * Retorna o usuarioSalaPersonalizada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/usuarioSalaPersonalizada/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista dos usuariosSalasPersonalizadas registrados no sistema {GET}
	 * @return lista de usuariosSalasPersonalizadas registrados no banco
	 */
	@GetMapping(path = "/api/usuariosSalasPersonalizadas")
	public List<UsuarioSalaPersonalizada> consultar(){
		return null;
	}
	
	/**
	 * Insere um novo usuarioSalaPersonalizada no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/usuarioSalaPersonalizada/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração do usuarioSalaPersonalizada que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/usuarioSalaPersonalizada/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão do usuarioSalaPersonalizada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/usuarioSalaPersonalizada/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
}
