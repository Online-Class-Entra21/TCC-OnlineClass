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

import entidade.UsuarioSalaPersonalizada;
import persistencia.jdbc.UsuarioSalaPersonalizadaDAO;

/**
 * Metodo controller do usuarioSalaPersonalizada para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class UsuarioSalaPersonalizadaController {
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	/**
	 * Retorna o usuarioSalaPersonalizada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@GetMapping(path = "/api/usuarioSalaPersonalizada/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		UsuarioSalaPersonalizadaDAO usuarioSalaPersonalizadaDao = new UsuarioSalaPersonalizadaDAO();
		UsuarioSalaPersonalizada usuarioSalaPersonalizada;
		try {
			usuarioSalaPersonalizada = usuarioSalaPersonalizadaDao.buscarId(codigo);
		} catch (SQLException e) {
			usuarioSalaPersonalizada = null;
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar UsuarioSalaPersonalizada Mal Sucedida - UsuarioSalaPersonalizada {} - erro - {}",codigo,e.toString());
		}
		Gson gson = new Gson();
		String json = gson.toJson(usuarioSalaPersonalizada);
		return json;
	}
	
	/**
	 * Retorna a lista dos usuariosSalasPersonalizadas registrados no sistema {GET}
	 * @return lista de usuariosSalasPersonalizadas registrados no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/usuariosSalasPersonalizadas")
	public List<UsuarioSalaPersonalizada> consultar(){
		List<UsuarioSalaPersonalizada> lista;
		UsuarioSalaPersonalizadaDAO usuarioSalaPersonalizadaDao = new UsuarioSalaPersonalizadaDAO();
		try {
			lista = usuarioSalaPersonalizadaDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos UsuarioSalaPersonalizada Mal Sucedida - erro - {}",e.toString());
		}
		return lista;
	}
	
	/**
	 * Insere um novo usuarioSalaPersonalizada no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/usuarioSalaPersonalizada/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		UsuarioSalaPersonalizada usuarioSalaPersonalizada = gson.fromJson(json, UsuarioSalaPersonalizada.class);
		UsuarioSalaPersonalizadaDAO usuarioSalaPersonalizadaDAO = new UsuarioSalaPersonalizadaDAO();
		try {
			usuarioSalaPersonalizadaDAO.insert(usuarioSalaPersonalizada);
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir UsuarioSalaPersonalizada Mal Sucedida - UsuarioSalaPersonalizada {} - erro - {}",json,e.toString());
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração do usuarioSalaPersonalizada que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/usuarioSalaPersonalizada/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		UsuarioSalaPersonalizada usuarioSalaPersonalizada = gson.fromJson(json, UsuarioSalaPersonalizada.class);
		UsuarioSalaPersonalizadaDAO usuarioSalaPersonalizadaDAO = new UsuarioSalaPersonalizadaDAO();
		try {
			usuarioSalaPersonalizadaDAO.update(usuarioSalaPersonalizada);
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar UsuarioSalaPersonalizada Mal Sucedida - UsuarioSalaPersonalizada {} - erro - {}",json,e.toString());
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão do usuarioSalaPersonalizada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/usuarioSalaPersonalizada/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		UsuarioSalaPersonalizadaDAO usuarioSalaPersonalizadaDAO = new UsuarioSalaPersonalizadaDAO();
		try {
			usuarioSalaPersonalizadaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar UsuarioSalaPersonalizada Mal Sucedida - UsuarioSalaPersonalizada {} - erro - {}",codigo,e.toString());
			return false;
		}
		return true;
	}
}
