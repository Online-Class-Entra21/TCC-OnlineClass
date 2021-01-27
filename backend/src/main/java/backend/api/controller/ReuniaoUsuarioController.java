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

import entidade.ReuniaoUsuario;
import persistencia.jdbc.ReuniaoUsuarioDAO;

/**
 * Metodo controller da reuniaoUsuario para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class ReuniaoUsuarioController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a reuniaoUsuario que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/reuniaoUsuario/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição ReuniaoUsuario codigo {} iniciada", codigo);
		ReuniaoUsuarioDAO reuniaoUsuarioDao = new ReuniaoUsuarioDAO();
		ReuniaoUsuario reuniaoUsuario;
		try {
			reuniaoUsuario = reuniaoUsuarioDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(reuniaoUsuario);
			LOGGER.info("Requisição ReuniaoUsuario codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar ReuniaoUsuario Mal Sucedida - ReuniaoUsuario {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das reunioesUsuarios registrados no sistema {GET}
	 * @return lista de reunioesUsuarios registradas no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/reunioesUsuarios")
	public List<ReuniaoUsuario> consultar(){
		LOGGER.info("Requisição List<ReuniaoUsuario>");
		List<ReuniaoUsuario> lista;
		ReuniaoUsuarioDAO reuniaoUsuarioDao = new ReuniaoUsuarioDAO();
		try {
			lista = reuniaoUsuarioDao.buscarTodos();
			LOGGER.info("Requisição List<ReuniaoUsuario> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos ReuniaoUsuario Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova reuniaoUsuario no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/reuniaoUsuario/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir ReuniaoUsuario - {}",json);
		Gson gson = new Gson();
		ReuniaoUsuario reuniaoUsuario = gson.fromJson(json, ReuniaoUsuario.class);
		ReuniaoUsuarioDAO reuniaoUsuarioDAO = new ReuniaoUsuarioDAO();
		try {
			reuniaoUsuarioDAO.insert(reuniaoUsuario);
			LOGGER.info("Requisição Inserir ReuniaoUsuario - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir ReuniaoUsuario Mal Sucedida - ReuniaoUsuario {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da reuniaoUsuario que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/reuniaoUsuario/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar ReuniaoUsuario - {}",json);
		Gson gson = new Gson();
		ReuniaoUsuario reuniaoUsuario = gson.fromJson(json, ReuniaoUsuario.class);
		ReuniaoUsuarioDAO reuniaoUsuarioDAO = new ReuniaoUsuarioDAO();
		try {
			reuniaoUsuarioDAO.update(reuniaoUsuario);
			LOGGER.info("Requisição Atualizar ReuniaoUsuario - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar ReuniaoUsuario Mal Sucedida - ReuniaoUsuario {} - erro - {}",json,e.toString());
			return false;
		}	
	}
	
	/**
	 * Método de exclusão da reuniaoUsuario que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/reuniaoUsuario/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar ReuniaoUsuario id - {}",codigo);
		ReuniaoUsuarioDAO reuniaoUsuarioDAO = new ReuniaoUsuarioDAO();
		try {
			reuniaoUsuarioDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar ReuniaoUsuario id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar ReuniaoUsuario Mal Sucedida - ReuniaoUsuario {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
