package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o periodoAvaliacao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/periodoAvaliacao/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Arquivo codigo {} iniciada", codigo);
		PeriodoAvaliacaoDAO periodoAvaliacaoDao = new PeriodoAvaliacaoDAO();
		PeriodoAvaliacao periodoAvaliacao;
		try {
			periodoAvaliacao = periodoAvaliacaoDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(periodoAvaliacao);
			LOGGER.info("Requisição Arquivo codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar PeriodoAvaliacao Mal Sucedida - PeriodoAvaliacao {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista dos periodosAvaliacoes registrados no sistema {GET}
	 * @return lista de periodosAvaliacoes registrados no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/periodosAvaliacoes")
	public List<PeriodoAvaliacao> consultar(){
		LOGGER.info("Requisição List<PeriodoAvaliacao>");
		List<PeriodoAvaliacao> lista;
		PeriodoAvaliacaoDAO periodoAvaliacaoDao = new PeriodoAvaliacaoDAO();
		try {
			lista = periodoAvaliacaoDao.buscarTodos();
			LOGGER.info("Requisição List<PeriodoAvaliacao> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos PeriodoAvaliacao Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere um novo periodoAvaliacao no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/periodoAvaliacao/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir PeriodoAvaliacao - {}",json);
		Gson gson = new Gson();
		PeriodoAvaliacao periodoAvaliacao = gson.fromJson(json, PeriodoAvaliacao.class);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.insert(periodoAvaliacao);
			LOGGER.info("Requisição Inserir PeriodoAvaliacao - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir PeriodoAvaliacao Mal Sucedida - PeriodoAvaliacao {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do periodoAvaliacao que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @author Andre
	 * @param String json
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/periodoAvaliacao/alterar/{codigo}/{json}")
	public boolean  alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar PeriodoAvaliacao - {}",json);
		Gson gson = new Gson();
		PeriodoAvaliacao periodoAvaliacao = gson.fromJson(json, PeriodoAvaliacao.class);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.update(periodoAvaliacao);
			LOGGER.info("Requisição Atualizar PeriodoAvaliacao - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar PeriodoAvaliacao Mal Sucedida - PeriodoAvaliacao {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do periodoAvaliacao que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/periodoAvaliacao/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Arquivo id - {}",codigo);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Arquivo id - {} - Bem Sucedida",codigo);
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar PeriodoAvaliacao Mal Sucedida - PeriodoAvaliacao {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
