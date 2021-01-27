package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import entidade.Endereco;
import persistencia.jdbc.EnderecoDAO;

/**
 * Metodo controller do endereco para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class EnderecoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o endereco que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@GetMapping(path = "/api/endereco/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Endereco codigo {} iniciada", codigo);
		EnderecoDAO enderecoDao = new EnderecoDAO();
		Endereco endereco;
		try {
			endereco = enderecoDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(endereco);
			LOGGER.info("Requisição Endereco codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Endereco Mal Sucedida - Endereco {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista de enderecos registrados no sistema {GET}
	 * @return lista de enderecos registrados no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/enderecos")
	public List<Endereco> consultar() {
		LOGGER.info("Requisição List<Endereco>");
		List<Endereco> lista;
		EnderecoDAO enderecoDao = new EnderecoDAO();
		try {
			lista = enderecoDao.buscarTodos();
			LOGGER.info("Requisição List<Endereco> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Endereco Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}

	/**
	 * Insere um novo endereco no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/endereco/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Endereco - {}",json);
		Gson gson = new Gson();
		Endereco endereco = gson.fromJson(json, Endereco.class);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			enderecoDAO.insert(endereco);
			LOGGER.info("Requisição Inserir Endereco - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Endereco Mal Sucedida - Endereco {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do endereco que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/endereco/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Endereco - {}",json);
		Gson gson = new Gson();
		Endereco endereco = gson.fromJson(json, Endereco.class);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			enderecoDAO.update(endereco);
			LOGGER.info("Requisição Atualizar Endereco - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Endereco Mal Sucedida - Endereco {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do endereco que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/endereco/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Endereco id - {}",codigo);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			enderecoDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Endereco id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Endereco Mal Sucedida - Endereco {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
