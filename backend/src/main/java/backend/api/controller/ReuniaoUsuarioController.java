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

import entidade.ReuniaoUsuario;
import persistencia.jdbc.ReuniaoUsuarioDAO;

/**
 * Metodo controller da reuniaoUsuario para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class ReuniaoUsuarioController {
	
	/**
	 * Retorna a reuniaoUsuario que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author André
	 */
	@GetMapping(path = "/api/reuniaoUsuario/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		ReuniaoUsuarioDAO reuniaoUsuarioDao = new ReuniaoUsuarioDAO();
		ReuniaoUsuario reuniaoUsuario;
		try {
			reuniaoUsuario = reuniaoUsuarioDao.buscarId(codigo);
		} catch (SQLException e) {
			reuniaoUsuario = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(reuniaoUsuario);
		return json;
	}
	
	/**
	 * Retorna a lista das reunioesUsuarios registrados no sistema {GET}
	 * @return lista de reunioesUsuarios registradas no banco
	 * @author André
	 */
	@GetMapping(path = "/api/reunioesUsuarios")
	public List<ReuniaoUsuario> consultar(){
		List<ReuniaoUsuario> lista;
		ReuniaoUsuarioDAO reuniaoUsuarioDao = new ReuniaoUsuarioDAO();
		try {
			lista = reuniaoUsuarioDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere uma nova reuniaoUsuario no banco de dados {POST}
	 * @param String json
	 * @author André
	 */
	@PostMapping(path = "api/reuniaoUsuario/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		ReuniaoUsuario reuniaoUsuario = gson.fromJson(json, ReuniaoUsuario.class);
		ReuniaoUsuarioDAO reuniaoUsuarioDAO = new ReuniaoUsuarioDAO();
		try {
			reuniaoUsuarioDAO.insert(reuniaoUsuario);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da reuniaoUsuario que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author André
	 */
	@PutMapping(path = "api/reuniaoUsuario/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		ReuniaoUsuario reuniaoUsuario = gson.fromJson(json, ReuniaoUsuario.class);
		ReuniaoUsuarioDAO reuniaoUsuarioDAO = new ReuniaoUsuarioDAO();
		try {
			reuniaoUsuarioDAO.update(reuniaoUsuario);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	/**
	 * Método de exclusão da reuniaoUsuario que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author André
	 */
	@DeleteMapping(path = "/api/reuniaoUsuario/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		ReuniaoUsuarioDAO reuniaoUsuarioDAO = new ReuniaoUsuarioDAO();
		try {
			reuniaoUsuarioDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
