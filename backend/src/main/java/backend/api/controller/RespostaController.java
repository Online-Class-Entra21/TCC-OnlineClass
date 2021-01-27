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

import entidade.Resposta;
import persistencia.jdbc.RespostaDAO;

/**
 * Metodo controller do resposta para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class RespostaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a resposta que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/resposta/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Resposta codigo {} iniciada", codigo);
		RespostaDAO respostaDao = new RespostaDAO();
		Resposta resposta;
		try {
			resposta = respostaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(resposta);
			LOGGER.info("Requisição Resposta codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Resposta Mal Sucedida - Resposta {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das respostas registrados no sistema {GET}
	 * @return lista de respostas registrados no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/respostas")
	public List<Resposta> consultar(){
		LOGGER.info("Requisição List<Resposta>");
		List<Resposta> lista;
		RespostaDAO respostaDao = new RespostaDAO();
		try {
			lista = respostaDao.buscarTodos();
			LOGGER.info("Requisição List<Resposta> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Resposta Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova resposta no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/resposta/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Resposta - {}",json);
		Gson gson = new Gson();
		Resposta resposta = gson.fromJson(json, Resposta.class);
		RespostaDAO respostaDAO = new RespostaDAO();
		try {
			respostaDAO.insert(resposta);
			LOGGER.info("Requisição Inserir Resposta - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Resposta Mal Sucedida - Resposta {} - erro - {}",json,e.toString());
			return false;
		}
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
		LOGGER.info("Requisição Atualizar Resposta - {}",json);
		Gson gson = new Gson();
		Resposta resposta = gson.fromJson(json, Resposta.class);
		RespostaDAO respostaDAO = new RespostaDAO();
		try {
			respostaDAO.update(resposta);
			LOGGER.info("Requisição Atualizar Resposta - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Resposta Mal Sucedida - Resposta {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da resposta que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/resposta/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Resposta id - {}",codigo);
		RespostaDAO respostaDAO = new RespostaDAO();
		try {
			respostaDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Resposta id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Resposta Mal Sucedida - Resposta {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
