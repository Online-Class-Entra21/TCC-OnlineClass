package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import entidade.ReuniaoUsuario;
import persistencia.jdbc.ReuniaoUsuarioDAO;

/**
 * Metodo controller da reuniaoUsuario para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
@RequestMapping("reuniaousuarios")
public class ReuniaoUsuarioController {

	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");

	/**
	 * Retorna a reuniaoUsuario que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
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
	@GetMapping
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
	 * @param ReuniaoUsuario reuniaoUsuario
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody ReuniaoUsuario reuniaoUsuario) {
		Gson gson = new Gson();
		String json = gson.toJson(reuniaoUsuario);
		LOGGER.info("Requisição Inserir ReuniaoUsuario - {}",json);
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
	 * @param ReuniaoUsuario reuniaoUsuario
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody ReuniaoUsuario reuniaoUsuario) {
		Gson gson = new Gson();
		String json = gson.toJson(reuniaoUsuario);
		LOGGER.info("Requisição Atualizar ReuniaoUsuario - {}",json);
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
	@CrossOrigin
	@DeleteMapping("/{codigo}")
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
