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

import entidade.Resposta;
import persistencia.jdbc.RespostaDAO;

/**
 * Metodo controller do resposta para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class RespostaController {
	
	/**
	 * Retorna a resposta que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/resposta/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		RespostaDAO respostaDao = new RespostaDAO();
		Resposta resposta;
		try {
			resposta = respostaDao.buscarId(codigo);
		} catch (SQLException e) {
			resposta = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(resposta);
		return json;
	}
	
	/**
	 * Retorna a lista das respostas registrados no sistema {GET}
	 * @return lista de respostas registrados no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/respostas")
	public List<Resposta> consultar(){
		List<Resposta> lista;
		RespostaDAO respostaDao = new RespostaDAO();
		try {
			lista = respostaDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere uma nova resposta no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/resposta/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Resposta resposta = gson.fromJson(json, Resposta.class);
		RespostaDAO respostaDAO = new RespostaDAO();
		try {
			respostaDAO.insert(resposta);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da resposta que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/resposta/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Resposta resposta = gson.fromJson(json, Resposta.class);
		RespostaDAO respostaDAO = new RespostaDAO();
		try {
			respostaDAO.update(resposta);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão da resposta que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/resposta/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		RespostaDAO respostaDAO = new RespostaDAO();
		try {
			respostaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
