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

import entidade.Turma;
import persistencia.jdbc.TurmaDAO;

/**
 * Metodo controller da turma para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class TurmaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a turma que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@GetMapping(path = "/api/turma/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Turma codigo {} iniciada", codigo);
		TurmaDAO turmaDao = new TurmaDAO();
		Turma turma;
		try {
			turma = turmaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(turma);
			LOGGER.info("Requisição Turma codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Turma Mal Sucedida - Turma {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das turmas registrados no sistema {GET}
	 * @return lista de turmas registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/turmas")
	public List<Turma> consultar(){
		LOGGER.info("Requisição List<Turma>");
		List<Turma> lista;
		TurmaDAO turmaDao = new TurmaDAO();
		try {
			lista = turmaDao.buscarTodos();
			LOGGER.info("Requisição List<Turma> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Turma Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova turma no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/turma/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Turma - {}",json);
		Gson gson = new Gson();
		Turma turma = gson.fromJson(json, Turma.class);
		TurmaDAO turmaDAO = new TurmaDAO();
		try {
			turmaDAO.insert(turma);
			LOGGER.info("Requisição Inserir Turma - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Turma Mal Sucedida - Turma {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da turma que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/turma/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Turma - {}",json);
		Gson gson = new Gson();
		Turma turma = gson.fromJson(json, Turma.class);
		TurmaDAO turmaDAO = new TurmaDAO();
		try {
			turmaDAO.update(turma);
			LOGGER.info("Requisição Atualizar Turma - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Turma Mal Sucedida - Turma {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da turma que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/turma/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Turma id - {}",codigo);
		TurmaDAO turmaDAO = new TurmaDAO();
		try {
			turmaDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Turma id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Turma Mal Sucedida - Turma {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
