package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import entidade.Chamada;
import persistencia.jdbc.ChamadaDAO;

/**
 * Metodo controller da chamada para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
@RequestMapping("/chamadas")
public class ChamadaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a chamada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return Chamada chamada
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Chamada codigo {} iniciada", codigo);
		Chamada chamada;
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			chamada = chamadaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(chamada);
			LOGGER.info("Requisição Chamada codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Chamada Mal Sucedida - Chamada {} - erro - {}",codigo,e.toString());
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de chamadas registrados no sistema {GET}
	 * @return lista de chamadas registradas no banco
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping
	public List<Chamada> consultar(){
		LOGGER.info("Requisição List<Chamada>");
		List<Chamada> lista;
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			lista = chamadaDao.buscarTodos();
			LOGGER.info("Requisição List<Chamada> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Chamada Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova chamada no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody Chamada chamada) {
		Gson gson = new Gson();
		String json = gson.toJson(chamada);
		LOGGER.info("Requisição Inserir Chamada - {}",json);
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			chamadaDao.insert(chamada);
			LOGGER.info("Requisição Inserir Chamada - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Chamada Mal Sucedida - Chamada {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da chamada que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Chamada chamada) {
		Gson gson = new Gson();
		String json = gson.toJson(chamada);
		LOGGER.info("Requisição Atualizar Chamada - {}",json);
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			chamadaDao.update(chamada);
			LOGGER.info("Requisição Atualizar Chamada - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Chamada Mal Sucedida - Chamada {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da chamada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@CrossOrigin
	@DeleteMapping("/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Chamada id - {}",codigo);
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			chamadaDao.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Chamada id - {} - Bem Sucedida",codigo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Chamada Mal Sucedida - Chamada {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
