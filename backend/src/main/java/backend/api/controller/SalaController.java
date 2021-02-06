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

import entidade.Reuniao;
import entidade.Sala;
import persistencia.jdbc.ReuniaoDAO;
import persistencia.jdbc.SalaDAO;

/**
 * Metodo controller da sala para consulta no banco de dados através da API Rest
 * @author Breno
 * 
 */
@RestController
public class SalaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a sala que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@GetMapping(path = "/api/sala/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Sala codigo {} iniciada", codigo);
		SalaDAO salaDao = new SalaDAO();
		Sala sala;
		try {
			sala = salaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(sala);
			LOGGER.info("Requisição Sala codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Sala Mal Sucedida - Sala {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das salas registrados no sistema {GET}
	 * @return lista de salas registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/salas")
	public List<Sala> consultar(){
		LOGGER.info("Requisição List<Sala>");
		List<Sala> lista;
		SalaDAO salaDao = new SalaDAO();
		try {
			lista = salaDao.buscarTodos();
			LOGGER.info("Requisição List<Sala> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Sala Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova sala no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/sala/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Sala - {}",json);
		Gson gson = new Gson();
		Sala sala = gson.fromJson(json, Sala.class);
		SalaDAO salaDAO = new SalaDAO();
		try {
			salaDAO.insert(sala);
			LOGGER.info("Requisição Inserir Sala - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Sala Mal Sucedida - Sala {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da sala que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/sala/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Sala - {}",json);
		Gson gson = new Gson();
		Sala sala = gson.fromJson(json, Sala.class);
		SalaDAO salaDAO = new SalaDAO();
		try {
			salaDAO.update(sala);
			LOGGER.info("Requisição Atualizar Sala - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Sala Mal Sucedida - Sala {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da sala que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/sala/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Sala id - {}",codigo);
		SalaDAO salaDAO = new SalaDAO();
		try {
			salaDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Sala id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Sala Mal Sucedida - Sala {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
	
	/**
	 * Retorna a sala que corresponde ao idReuniao informado
	 * @param int codigo - idReuniao
	 * @return String json
	 * @author André
	 */
	@GetMapping(path = "/api/salaidreuniao/{codigo}")
	public String consultarIdReuniao(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Sala da Reuniao {} iniciada", codigo);
		SalaDAO salaDao = new SalaDAO();
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		Reuniao reuniao;
		Sala sala;
		try {
			reuniao = reuniaoDAO.buscarId(codigo);
			LOGGER.info("Requisição Reuniao codigo {} bem sucedida",codigo);
			try {
				sala = salaDao.buscarId(reuniao.getFk_sala());
				Gson gson = new Gson();
				String json = gson.toJson(sala);
				LOGGER.info("Requisição Sala codigo {} bem sucedida",codigo);
				return json;
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.error("Requisição para Consultar Sala Mal Sucedida - Sala {} - erro - {}",codigo,e.toString());
				return null;
			}
		} catch (SQLException e) {
			LOGGER.error("Requisição para Consultar Reuniao Mal Sucedida - Reuniao {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
}
