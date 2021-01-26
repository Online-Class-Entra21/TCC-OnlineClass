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

import entidade.SalaPersonalizada;
import persistencia.jdbc.SalaPersonalizadaDAO;

/**
 * Metodo controller da salaPersonalizada para consulta no banco de dados através da API Rest
 * @author Breno
 * 
 */
@RestController
public class SalaPersonalizadaController {
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	/**
	 * Retorna a salaPersonalizada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@GetMapping(path = "/api/salaPersonalizada/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		SalaPersonalizadaDAO salaPersonalizadaDao = new SalaPersonalizadaDAO();
		SalaPersonalizada salaPersonalizada;
		try {
			salaPersonalizada = salaPersonalizadaDao.buscarId(codigo);
		} catch (SQLException e) {
			salaPersonalizada = null;
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar SalaPersonalizada Mal Sucedida - SalaPersonalizada {} - erro - {}",codigo,e.toString());
		}
		Gson gson = new Gson();
		String json = gson.toJson(salaPersonalizada);
		return json;
	}
	
	/**
	 * Retorna a lista das salasPersonalizadas registrados no sistema {GET}
	 * @return lista de salasPersonalizadas registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/salasPersonalizadas")
	public List<SalaPersonalizada> consultar(){
		List<SalaPersonalizada> lista;
		SalaPersonalizadaDAO salaPersonalizadaDao = new SalaPersonalizadaDAO();
		try {
			lista = salaPersonalizadaDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos SalaPersonalizada Mal Sucedida - erro - {}",e.toString());
		}
		return lista;
	}
	
	/**
	 * Insere uma nova salaPersonalizada no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/salaPersonalizada/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		SalaPersonalizada salaPersonalizada = gson.fromJson(json, SalaPersonalizada.class);
		SalaPersonalizadaDAO salaPersonalizadaDAO = new SalaPersonalizadaDAO();
		try {
			salaPersonalizadaDAO.insert(salaPersonalizada);
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir SalaPersonalizada Mal Sucedida - SalaPersonalizada {} - erro - {}",json,e.toString());
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da salaPersonalizada que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/salaPersonalizada/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		SalaPersonalizada salaPersonalizada = gson.fromJson(json, SalaPersonalizada.class);
		SalaPersonalizadaDAO salaPersonalizadaDAO = new SalaPersonalizadaDAO();
		try {
			salaPersonalizadaDAO.update(salaPersonalizada);
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar SalaPersonalizada Mal Sucedida - SalaPersonalizada {} - erro - {}",json,e.toString());
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão da salaPersonalizada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/salaPersonalizada/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		SalaPersonalizadaDAO salaPersonalizadaDAO = new SalaPersonalizadaDAO();
		try {
			salaPersonalizadaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar SalaPersonalizada Mal Sucedida - SalaPersonalizada {} - erro - {}",codigo,e.toString());
			return false;
		}
		return true;
	}
}
