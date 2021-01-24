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

import entidade.UsuarioDisciplina;
import persistencia.jdbc.UsuarioDisciplinaDAO;

/**
 * Metodo controller do usuarioDisciplina para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class UsuarioDisciplinaController {
	
	/**
	 * Retorna o usuarioDisciplina que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@GetMapping(path = "/api/usuarioDisciplina/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		UsuarioDisciplinaDAO usuarioDisciplinaDao = new UsuarioDisciplinaDAO();
		UsuarioDisciplina usuarioDisciplina;
		try {
			usuarioDisciplina = usuarioDisciplinaDao.buscarId(codigo);
		} catch (SQLException e) {
			usuarioDisciplina = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(usuarioDisciplina);
		return json;
	}
	
	/**
	 * Retorna a lista dos usuariosDisciplinas registrados no sistema {GET}
	 * @return lista de usuariosDisciplinas registrados no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/usuariosDisciplinas")
	public List<UsuarioDisciplina> consultar(){
		List<UsuarioDisciplina> lista;
		UsuarioDisciplinaDAO usuarioDisciplinaDao = new UsuarioDisciplinaDAO();
		try {
			lista = usuarioDisciplinaDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere um novo usuarioDisciplina no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/usuarioDisciplina/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		UsuarioDisciplina usuarioDisciplina = gson.fromJson(json, UsuarioDisciplina.class);
		UsuarioDisciplinaDAO usuarioDisciplinaDAO = new UsuarioDisciplinaDAO();
		try {
			usuarioDisciplinaDAO.insert(usuarioDisciplina);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração do usuarioDisciplina que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/usuarioDisciplina/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		UsuarioDisciplina usuarioDisciplina = gson.fromJson(json, UsuarioDisciplina.class);
		UsuarioDisciplinaDAO usuarioDisciplinaDAO = new UsuarioDisciplinaDAO();
		try {
			usuarioDisciplinaDAO.update(usuarioDisciplina);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão do usuarioDisciplina que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/usuarioDisciplina/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		UsuarioDisciplinaDAO usuarioDisciplinaDAO = new UsuarioDisciplinaDAO();
		try {
			usuarioDisciplinaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
