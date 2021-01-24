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

import entidade.Turma;
import persistencia.jdbc.TurmaDAO;

/**
 * Metodo controller da turma para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class TurmaController {
	
	/**
	 * Retorna a turma que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author André
	 */
	@GetMapping(path = "/api/turma/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		TurmaDAO turmaDao = new TurmaDAO();
		Turma turma;
		try {
			turma = turmaDao.buscarId(codigo);
		} catch (SQLException e) {
			turma = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(turma);
		return json;
	}
	
	/**
	 * Retorna a lista das turmas registrados no sistema {GET}
	 * @return lista de turmas registradas no banco
	 * @author André
	 */
	@GetMapping(path = "/api/turmas")
	public List<Turma> consultar(){
		List<Turma> lista;
		TurmaDAO turmaDao = new TurmaDAO();
		try {
			lista = turmaDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere uma nova turma no banco de dados {POST}
	 * @param String json
	 * @author André
	 */
	@PostMapping(path = "api/turma/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Turma turma = gson.fromJson(json, Turma.class);
		TurmaDAO turmaDAO = new TurmaDAO();
		try {
			turmaDAO.insert(turma);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da turma que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author André
	 */
	@PutMapping(path = "api/turma/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Turma turma = gson.fromJson(json, Turma.class);
		TurmaDAO turmaDAO = new TurmaDAO();
		try {
			turmaDAO.update(turma);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão da turma que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author André
	 */
	@DeleteMapping(path = "/api/turma/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		TurmaDAO turmaDAO = new TurmaDAO();
		try {
			turmaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
}
