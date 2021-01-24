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

import entidade.PeriodoAvaliacao;
import persistencia.jdbc.PeriodoAvaliacaoDAO;

/**
 * Metodo controller do periodoAvaliacao para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class PeriodoAvaliacaoController {
	
	/**
	 * Retorna o periodoAvaliacao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/periodoAvaliacao/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		PeriodoAvaliacaoDAO periodoAvaliacaoDao = new PeriodoAvaliacaoDAO();
		PeriodoAvaliacao periodoAvaliacao;
		try {
			periodoAvaliacao = periodoAvaliacaoDao.buscarId(codigo);
		} catch (SQLException e) {
			periodoAvaliacao = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(periodoAvaliacao);
		return json;
	}
	
	/**
	 * Retorna a lista dos periodosAvaliacoes registrados no sistema {GET}
	 * @return lista de periodosAvaliacoes registrados no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/periodosAvaliacoes")
	public List<PeriodoAvaliacao> consultar(){
		List<PeriodoAvaliacao> lista;
		PeriodoAvaliacaoDAO periodoAvaliacaoDao = new PeriodoAvaliacaoDAO();
		try {
			lista = periodoAvaliacaoDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere um novo periodoAvaliacao no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 */
	@PostMapping(path = "api/periodoAvaliacao/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		PeriodoAvaliacao periodoAvaliacao = gson.fromJson(json, PeriodoAvaliacao.class);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.insert(periodoAvaliacao);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração do periodoAvaliacao que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @author Andre
	 * @param String json
	 */
	@PutMapping(path = "api/periodoAvaliacao/alterar/{codigo}/{json}")
	public boolean  alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		PeriodoAvaliacao periodoAvaliacao = gson.fromJson(json, PeriodoAvaliacao.class);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.update(periodoAvaliacao);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão do periodoAvaliacao que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 */
	@DeleteMapping(path = "/api/periodoAvaliacao/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
}
