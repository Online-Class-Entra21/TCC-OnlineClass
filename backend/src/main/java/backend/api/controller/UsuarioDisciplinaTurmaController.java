package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.UsuarioDisciplinaTurma;
import persistencia.jdbc.UsuarioDisciplinaTurmaDAO;

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
	 * @author André
	 */
	@GetMapping(path = "/api/usuarioDisciplinaTurma/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDao = new UsuarioDisciplinaTurmaDAO();
		UsuarioDisciplinaTurma usuarioDisciplinaTurma;
		try {
			usuarioDisciplinaTurma = usuarioDisciplinaTurmaDao.buscarId(codigo);
		} catch (SQLException e) {
			usuarioDisciplinaTurma = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(usuarioDisciplinaTurma);
		return json;
	}
	
	/**
	 * Retorna a lista dos usuarioDisciplinaTurma registrados no sistema {GET}
	 * @return lista de usuariosDisciplinasTurmas registradas no banco
	 * @author André
	 */
	@GetMapping(path = "/api/turmasUsuariosDisciplinas")
	public List<UsuarioDisciplinaTurma> consultar(){
		List<UsuarioDisciplinaTurma> lista;
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDao = new UsuarioDisciplinaTurmaDAO();
		try {
			lista = usuarioDisciplinaTurmaDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere um novo usuarioDisciplinaTurma no banco de dados {POST}
	 * @param String json
	 * @author André
	 */
	@PostMapping(path = "api/usuarioDisciplinaTurma/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		UsuarioDisciplinaTurma usuarioDisciplinaTurma = gson.fromJson(json, UsuarioDisciplinaTurma.class);
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDAO = new UsuarioDisciplinaTurmaDAO();
		try {
			usuarioDisciplinaTurmaDAO.insert(usuarioDisciplinaTurma);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração do usuarioDisciplinaTurma que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author André
	 */
	@PutMapping(path = "api/usuarioDisciplinaTurma/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		UsuarioDisciplinaTurma usuarioDisciplinaTurma = gson.fromJson(json, UsuarioDisciplinaTurma.class);
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDAO = new UsuarioDisciplinaTurmaDAO();
		try {
			usuarioDisciplinaTurmaDAO.update(usuarioDisciplinaTurma);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão do usuarioDisciplinaTurma que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author André
	 */
	@DeleteMapping(path = "/api/usuarioDisciplinaTurma/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDAO = new UsuarioDisciplinaTurmaDAO();
		try {
			usuarioDisciplinaTurmaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
