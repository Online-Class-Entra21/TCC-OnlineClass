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

import entidade.Disciplina;
import persistencia.jdbc.DisciplinaDAO;

/**
 * Metodo controller da disciplina para consulta no banco de dados através da
 * API Rest
 * @author Andre
 *
 */
@RestController
public class DisciplinaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o disciplina que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/disciplina/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Disciplina codigo {} iniciada", codigo);
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();
		Disciplina disciplina;
		try {
			disciplina = disciplinaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(disciplina);
			LOGGER.info("Requisição Disciplina codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Disciplina Mal Sucedida - Disciplina {} - erro - {}",codigo,e.toString());
			return null;
		}
	}

	/**
	 * Retorna a lista de disciplinas registrados no sistema {GET}
	 * @return lista de disciplinas registrados no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/disciplinas")
	public List<Disciplina> consultar() {
		LOGGER.info("Requisição List<Disciplina>");
		List<Disciplina> lista;
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();
		try {
			lista = disciplinaDao.buscarTodos();
			LOGGER.info("Requisição List<Disciplina> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Disciplina Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}

	/**
	 * Insere uma nova disciplina no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/disciplina/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Disciplina - {}",json);
		Gson gson = new Gson();
		System.err.println(json);
		Disciplina disciplina = gson.fromJson(json, Disciplina.class);
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();
		try {
			disciplinaDao.insert(disciplina);
			LOGGER.info("Requisição Inserir Disciplina - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Disciplina Mal Sucedida - Disciplina {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da disciplina que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/disciplina/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Disciplina Disciplina - {}",json);
		Gson gson = new Gson();
		Disciplina disciplina = gson.fromJson(json, Disciplina.class);
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();
		try {
			disciplinaDao.update(disciplina);
			LOGGER.info("Requisição Disciplina Disciplina - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Disciplina Mal Sucedida - Disciplina {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da disciplina que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/disciplina/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Disciplina id - {}",codigo);
		DisciplinaDAO disciplinaDao = new DisciplinaDAO();
		try {
			disciplinaDao.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Disciplina id - {} - Bem Sucedida",codigo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Disciplina Mal Sucedida - Disciplina {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
