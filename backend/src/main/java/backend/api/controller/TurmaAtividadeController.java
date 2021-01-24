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

import entidade.TurmaAtividade;
import persistencia.jdbc.TurmaAtividadeDAO;

/**
 * Metodo controller da turmaAtividade para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class TurmaAtividadeController {
	
	/**
	 * Retorna a turmaAtividade que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@GetMapping(path = "/api/turmaAtividade/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		TurmaAtividadeDAO turmaAtividadeDao = new TurmaAtividadeDAO();
		TurmaAtividade turmaAtividade;
		try {
			turmaAtividade = turmaAtividadeDao.buscarId(codigo);
		} catch (SQLException e) {
			turmaAtividade = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(turmaAtividade);
		return json;
	}
	
	/**
	 * Retorna a lista das turmasAtividades registrados no sistema {GET}
	 * @return lista de turmasAtividades registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/turmasAtividades")
	public List<TurmaAtividade> consultar(){
		List<TurmaAtividade> lista;
		TurmaAtividadeDAO turmaAtividadeDao = new TurmaAtividadeDAO();
		try {
			lista = turmaAtividadeDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere uma nova turmaAtividade no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/turmaAtividade/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		TurmaAtividade turmaAtividade = gson.fromJson(json, TurmaAtividade.class);
		TurmaAtividadeDAO turmaAtividadeDAO = new TurmaAtividadeDAO();
		try {
			turmaAtividadeDAO.insert(turmaAtividade);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da turmaAtividade que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/turmaAtividade/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		TurmaAtividade turmaAtividade = gson.fromJson(json, TurmaAtividade.class);
		TurmaAtividadeDAO turmaAtividadeDAO = new TurmaAtividadeDAO();
		try {
			turmaAtividadeDAO.update(turmaAtividade);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão da turmaAtividade que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/turmaAtividade/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		TurmaAtividadeDAO turmaAtividadeDAO = new TurmaAtividadeDAO();
		try {
			turmaAtividadeDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
