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

import entidade.ArquivoUsuario;
import persistencia.jdbc.ArquivoUsuarioDAO;

/**
 * Metodo controller do arquivoUsuario para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class ArquivoUsuarioController {
	public static final Logger LOGGER = LoggerFactory.getLogger(ArquivoUsuarioController.class);  
	/**
	 * Retorna o arquivoUsuario que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andrey
	 */
	@GetMapping(path = "/api/arquivoUsuario/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição de Arquivo codigo {} Iniciada",codigo);
		ArquivoUsuario arquivoUsuario = new ArquivoUsuario();
		ArquivoUsuarioDAO arquivoUsuarioDao = new ArquivoUsuarioDAO();
		try {
			arquivoUsuario = arquivoUsuarioDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(arquivoUsuario);
			LOGGER.info("Requisição de Arquivo Bem sucedida");
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição de Arquivo codigo {} Mal sucedida {}",codigo,e.toString());
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de arquivosUsuarios registrados no sistema {GET}
	 * @return lista de arquivosUsuarios registrados no banco
	 * @author Andrey 
	 */
	@GetMapping(path = "/api/arquivosUsuarios")
	public List<ArquivoUsuario> consultar(){
		List<ArquivoUsuario> lista;
		ArquivoUsuarioDAO arquivoUsuarioDao = new ArquivoUsuarioDAO();
		try {
			lista = arquivoUsuarioDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insere uma novo arquivosUsuario no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PostMapping(path = "api/aluno/arquivosUsuario/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		ArquivoUsuario arquivoUsuario = gson.fromJson(json.toString(), ArquivoUsuario.class);
		ArquivoUsuarioDAO arquivoUsuarioDao = new ArquivoUsuarioDAO();
		try {
			arquivoUsuarioDao.insert(arquivoUsuario);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo para alteração do arquivoUsuario que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "api/arquivoUsuario/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		Gson gson = new Gson();
		ArquivoUsuario arquivoUsuario = gson.fromJson(json.toString(), ArquivoUsuario.class);
		ArquivoUsuarioDAO arquivoUsuarioDao = new ArquivoUsuarioDAO();
		try {
			arquivoUsuarioDao.update(arquivoUsuario);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Método de exclusão do arquivoUsuario que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@DeleteMapping(path = "/api/arquivoUsuario/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		ArquivoUsuarioDAO arquivoUsuarioDao = new ArquivoUsuarioDAO();
		try {
			arquivoUsuarioDao.deleteId(codigo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
