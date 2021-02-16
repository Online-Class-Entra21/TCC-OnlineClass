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

import entidade.TurmaAtividade;
import persistencia.jdbc.TurmaAtividadeDAO;

/**
 * Metodo controller da turmaAtividade para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class TurmaAtividadeController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a turmaAtividade que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@GetMapping(path = "/api/turmaAtividade/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição TurmaAtividade codigo {} iniciada", codigo);
		TurmaAtividadeDAO turmaAtividadeDao = new TurmaAtividadeDAO();
		TurmaAtividade turmaAtividade;
		try {
			turmaAtividade = turmaAtividadeDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(turmaAtividade);
			LOGGER.info("Requisição TurmaAtividade codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar TurmaAtividade Mal Sucedida - TurmaAtividade {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das turmasAtividades registrados no sistema {GET}
	 * @return lista de turmasAtividades registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/turmasAtividades")
	public List<TurmaAtividade> consultar(){
		LOGGER.info("Requisição List<TurmaAtividade>");
		List<TurmaAtividade> lista;
		TurmaAtividadeDAO turmaAtividadeDao = new TurmaAtividadeDAO();
		try {
			lista = turmaAtividadeDao.buscarTodos();
			LOGGER.info("Requisição List<TurmaAtividade> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos TurmaAtividade Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova turmaAtividade no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/turmaAtividade/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir TurmaAtividade - {}",json);
		Gson gson = new Gson();
		TurmaAtividade turmaAtividade = gson.fromJson(json, TurmaAtividade.class);
		TurmaAtividadeDAO turmaAtividadeDAO = new TurmaAtividadeDAO();
		try {
			turmaAtividadeDAO.insert(turmaAtividade);
			LOGGER.info("Requisição Inserir TurmaAtividade - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir TurmaAtividade Mal Sucedida - TurmaAtividade {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da turmaAtividade que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/turmaAtividade/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar TurmaAtividade - {}",json);
		Gson gson = new Gson();
		TurmaAtividade turmaAtividade = gson.fromJson(json, TurmaAtividade.class);
		TurmaAtividadeDAO turmaAtividadeDAO = new TurmaAtividadeDAO();
		try {
			turmaAtividadeDAO.update(turmaAtividade);
			LOGGER.info("Requisição Atualizar TurmaAtividade - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar TurmaAtividade Mal Sucedida - TurmaAtividade {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da turmaAtividade que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/turmaAtividade/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar TurmaAtividade id - {}",codigo);
		TurmaAtividadeDAO turmaAtividadeDAO = new TurmaAtividadeDAO();
		try {
			turmaAtividadeDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar TurmaAtividade id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar TurmaAtividade Mal Sucedida - TurmaAtividade {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Retorna a lista das turmasAtividades registrados no sistema {GET}
	 * @return lista de turmasAtividades registradas no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/turmas/atividades/turma/{idTurma}")
	public List<TurmaAtividade> consultarTodosIdTurma(@PathVariable("idTurma") int idTurma){
		LOGGER.info("Requisição List<TurmaAtividade>");
		List<TurmaAtividade> lista;
		TurmaAtividadeDAO turmaAtividadeDao = new TurmaAtividadeDAO();
		try {
			lista = turmaAtividadeDao.buscarTodosIdTurma(idTurma);
			LOGGER.info("Requisição List<TurmaAtividade> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos TurmaAtividade Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
}
