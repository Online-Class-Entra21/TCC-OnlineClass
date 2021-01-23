package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Reuniao;

/**
 * Metodo controller da reuniao para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class ReuniaoController {
	
	/**
	 * Retorna a reuniao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/reuniao/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista das reunioes registrados no sistema {GET}
	 * @return lista de reunioes registradas no banco
	 */
	@GetMapping(path = "/api/reunioes")
	public List<Reuniao> consultar(){
		return null;
	}
	
	/**
	 * Insere uma nova reuniao no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/reuniao/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração da reuniao que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/reuniao/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão da reuniao que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/reuniao/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
}
