package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.SalaPersonalizada;
import persistencia.jdbc.SalaPersonalizadaDAO;

/**
 * Metodo controller da salaPersonalizada para consulta no banco de dados através da API Rest
 * @author Breno
 * 
 */
@RestController
@RequestMapping("salapersonalizadas")
public class SalaPersonalizadaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a salaPersonalizada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição SalaPersonalizada codigo {} iniciada", codigo);
		SalaPersonalizadaDAO salaPersonalizadaDao = new SalaPersonalizadaDAO();
		SalaPersonalizada salaPersonalizada;
		try {
			salaPersonalizada = salaPersonalizadaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(salaPersonalizada);
			LOGGER.info("Requisição SalaPersonalizada codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar SalaPersonalizada Mal Sucedida - SalaPersonalizada {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das salasPersonalizadas registrados no sistema {GET}
	 * @return lista de salasPersonalizadas registradas no banco
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping
	public List<SalaPersonalizada> consultar(){
		LOGGER.info("Requisição List<SalaPersonalizada>");
		List<SalaPersonalizada> lista;
		SalaPersonalizadaDAO salaPersonalizadaDao = new SalaPersonalizadaDAO();
		try {
			lista = salaPersonalizadaDao.buscarTodos();
			LOGGER.info("Requisição List<SalaPersonalizada> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos SalaPersonalizada Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova salaPersonalizada no banco de dados {POST}
	 * @param SalaPersonalizada salaPersonalizada
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody SalaPersonalizada salaPersonalizada) {
		Gson gson = new Gson();
		String json = gson.toJson(salaPersonalizada);
		LOGGER.info("Requisição Inserir SalaPersonalizada - {}",json);
		SalaPersonalizadaDAO salaPersonalizadaDAO = new SalaPersonalizadaDAO();
		try {
			salaPersonalizadaDAO.insert(salaPersonalizada);
			LOGGER.info("Requisição Inserir SalaPersonalizada - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir SalaPersonalizada Mal Sucedida - SalaPersonalizada {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da salaPersonalizada que corresponde ao codigo informado {PUT}
	 * @param SalaPersonalizada salaPersonalizada
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping("/alterar")
	public boolean alterar(@RequestBody SalaPersonalizada salaPersonalizada) {
		Gson gson = new Gson();
		String json = gson.toJson(salaPersonalizada);
		LOGGER.info("Requisição Atualizar SalaPersonalizada - {}",json);
		SalaPersonalizadaDAO salaPersonalizadaDAO = new SalaPersonalizadaDAO();
		try {
			salaPersonalizadaDAO.update(salaPersonalizada);
			LOGGER.info("Requisição Atualizar SalaPersonalizada - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar SalaPersonalizada Mal Sucedida - SalaPersonalizada {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da salaPersonalizada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@DeleteMapping
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar SalaPersonalizada id - {}",codigo);
		SalaPersonalizadaDAO salaPersonalizadaDAO = new SalaPersonalizadaDAO();
		try {
			salaPersonalizadaDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar SalaPersonalizada id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar SalaPersonalizada Mal Sucedida - SalaPersonalizada {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
