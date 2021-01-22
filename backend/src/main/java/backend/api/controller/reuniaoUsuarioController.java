package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.ReuniaoUsuario;

/**
 * Metodo controller da reuniaoUsuario para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class reuniaoUsuarioController {
	
	/**
	 * Retorna a reuniaoUsuario que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/reuniaoUsuario/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista das reunioesUsuarios registrados no sistema {GET}
	 * @return ReuniaoUsuario lista
	 */
	@GetMapping(path = "/api/reunioesUsuarios")
	public List<ReuniaoUsuario> consultar(){
		return null;
	}
	
	/**
	 * Insere uma nova reuniaoUsuario no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/reuniaoUsuario/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração da reuniaoUsuario que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/reuniaoUsuario/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão da reuniaoUsuario que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/reuniaoUsuario/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
