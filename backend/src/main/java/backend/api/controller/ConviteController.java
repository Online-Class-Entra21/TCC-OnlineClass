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

import entidade.Convite;
import persistencia.jdbc.ConviteDAO;

/**
 * Metodo controller do convite para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class ConviteController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o convite que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andrey
	 */
	@GetMapping(path = "/api/convite/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Convite codigo {} iniciada", codigo);
		Convite convite;
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			convite = conviteDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(convite);
			LOGGER.info("Requisição Convite codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Convite Mal Sucedida - Convite {} - erro - {}",codigo,e.toString());
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de convites registrados no sistema {GET}
	 * @return lista de convites registrados no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/convites")
	public List<Convite> consultar(){
		LOGGER.info("Requisição List<Convite>");
		List<Convite> lista;
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			lista = conviteDao.buscarTodos();
			LOGGER.info("Requisição List<Convite> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Convite Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere um novo convite no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PostMapping(path = "api/convite/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Convite - {}",json);
		Gson gson = new Gson();
		Convite convite = gson.fromJson(json.toString(), Convite.class);
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			conviteDao.insert(convite);
			LOGGER.info("Requisição Inserir Convite - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Convite Mal Sucedida - Convite {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do convite que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "api/convite/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Convite - {}",json);
		Gson gson = new Gson();
		Convite convite = gson.fromJson(json.toString(), Convite.class);
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			conviteDao.update(convite);
			LOGGER.info("Requisição Atualizar Convite - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Convite Mal Sucedida - Convite {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do convite que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@DeleteMapping(path = "/api/convite/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Convite id - {}",codigo);
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			conviteDao.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Convite id - {} - Bem Sucedida",codigo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Convite Mal Sucedida - Convite {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
