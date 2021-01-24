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

import entidade.Sala;
import persistencia.jdbc.SalaDAO;

/**
 * Metodo controller da sala para consulta no banco de dados através da API Rest
 * @author Breno
 *
 * @author André
 */
@RestController
public class SalaController {
	
	/**
	 * Retorna a sala que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author André
	 */
	@GetMapping(path = "/api/sala/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		SalaDAO salaDao = new SalaDAO();
		Sala sala;
		try {
			sala = salaDao.buscarId(codigo);
		} catch (SQLException e) {
			sala = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(sala);
		return json;
	}
	
	/**
	 * Retorna a lista das salas registrados no sistema {GET}
	 * @return lista de salas registradas no banco
	 * @author André
	 */
	@GetMapping(path = "/api/salas")
	public List<Sala> consultar(){
		List<Sala> lista;
		SalaDAO salaDao = new SalaDAO();
		try {
			lista = salaDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere uma nova sala no banco de dados {POST}
	 * @param String json
	 * @author André
	 */
	@PostMapping(path = "api/sala/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Sala sala = gson.fromJson(json, Sala.class);
		SalaDAO salaDAO = new SalaDAO();
		try {
			salaDAO.insert(sala);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da sala que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author André
	 */
	@PutMapping(path = "api/sala/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Sala sala = gson.fromJson(json, Sala.class);
		SalaDAO salaDAO = new SalaDAO();
		try {
			salaDAO.update(sala);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão da sala que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author André
	 */
	@DeleteMapping(path = "/api/sala/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		SalaDAO salaDAO = new SalaDAO();
		try {
			salaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
