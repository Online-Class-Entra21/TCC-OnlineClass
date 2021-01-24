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

import entidade.SalaPersonalizada;
import persistencia.jdbc.SalaPersonalizadaDAO;

/**
 * Metodo controller da salaPersonalizada para consulta no banco de dados através da API Rest
 * @author Breno
 *
 * @author André
 */
@RestController
public class SalaPersonalizadaController {
	
	/**
	 * Retorna a salaPersonalizada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author André
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
		}
		Gson gson = new Gson();
		String json = gson.toJson(salaPersonalizada);
		return json;
	}
	
	/**
	 * Retorna a lista das salasPersonalizadas registrados no sistema {GET}
	 * @return lista de salasPersonalizadas registradas no banco
	 * @author André
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
		}
		return lista;
	}
	
	/**
	 * Insere uma nova salaPersonalizada no banco de dados {POST}
	 * @param String json
	 * @author André
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
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da salaPersonalizada que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author André
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
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão da salaPersonalizada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author André
	 */
	@DeleteMapping(path = "/api/salaPersonalizada/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		SalaPersonalizadaDAO salaPersonalizadaDAO = new SalaPersonalizadaDAO();
		try {
			salaPersonalizadaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
