package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import entidade.Atividade;
import persistencia.jdbc.AtividadeDAO;

/**
 * Metodo controller da atividade para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class AtividadeController {
	
	/**
	 * Retorna a atividade que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andrey
	 */
	@GetMapping(path = "/api/atividade/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		Atividade atividade;
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			atividade = atividadeDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(atividade);
			return json;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de atividades registrados no sistema {GET}
	 * @return lista de atividades registradas no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/atividades")
	public List<Atividade> consultar(){
		List<Atividade> lista;
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			lista = atividadeDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insere uma nova atividade no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PostMapping(path = "api/atividade/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Atividade atividade = gson.fromJson(json.toString(), Atividade.class);
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			atividadeDao.insert(atividade);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo para alteração da atividade que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "api/atividade/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Atividade atividade = gson.fromJson(json.toString(), Atividade.class);
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			atividadeDao.update(atividade);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Método de exclusão da atividade que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@DeleteMapping(path = "/api/atividade/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			atividadeDao.deleteId(codigo);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
