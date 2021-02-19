package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("salas")
public class SalaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a sala que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
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
	@CrossOrigin
	@GetMapping
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
	 * @param Sala sala
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody Sala sala) {
		Gson gson = new Gson();
		String json = gson.toJson(sala);
		LOGGER.info("Requisição Inserir Sala - {}",json);
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
	 * @param Sala sala
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Sala sala) {
		Gson gson = new Gson();
		String json = gson.toJson(sala);
		LOGGER.info("Requisição Atualizar Sala - {}",json);
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
	@CrossOrigin
	@DeleteMapping("/{codigo}")
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
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Retorna a sala que corresponde ao idReuniao informado
	 * @param int codigo - idReuniao
	 * @return String json
	 * @author André
	 */
	@CrossOrigin
	@GetMapping("/salaidreuniao/{codigo}")
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
	/**
	 * Insere uma nova sala no banco de dados {POST}
	 * e retorna o json da sala inserida
	 * @param Sala sala
	 * @author André
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping("/return")
	public String inserirReturn(@RequestBody Sala sala) {
		Gson gson = new Gson();
		String json = gson.toJson(sala);
		LOGGER.info("Requisição Inserir Sala - {}",json);
		SalaDAO salaDAO = new SalaDAO();
		try {
			int idSala = salaDAO.insertReturnID(sala);
			LOGGER.info("Requisição Inserir Sala - {} - Bem Sucedida",json);
			String salaJson = gson.toJson(salaDAO.buscarId(idSala));
			return salaJson;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Sala Mal Sucedida - Sala {} - erro - {}",json,e.toString());
			return null;
		}
	}
}
