package backend.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.UsuarioDisciplinaTurma;

/**
 * Metodo controller do usuarioDisciplinaTurma para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class UsuarioDisciplinaTurmaController {
	
	/**
	 * Retorna o usuarioDisciplinaTurma que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/usuarioDisciplinaTurma/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		return null;
	}
	
	/**
	 * Retorna a lista dos usuarioDisciplinaTurma registrados no sistema {GET}
	 * @return lista de usuariosDisciplinasTurmas registradas no banco
	 */
	@GetMapping(path = "/api/turmasUsuariosDisciplinas")
	public List<UsuarioDisciplinaTurma> consultar(){
		return null;
	}
	
	/**
	 * Insere um novo usuarioDisciplinaTurma no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/usuarioDisciplinaTurma/inserir/{json}")
	public void inserir(@PathVariable("json") String json) {
		//Completar com o código
	}

	/**
	 * Metodo para alteração do usuarioDisciplinaTurma que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/usuarioDisciplinaTurma/alterar/{codigo}/{json}")
	public void alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		//Completar com o código
	}
	
	/**
	 * Método de exclusão do usuarioDisciplinaTurma que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/usuarioDisciplinaTurma/deletar/{codigo}")
	public void deletar(@PathVariable("codigo") int codigo) {
		//Completar com o código
	}
}
