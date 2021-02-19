package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import entidade.TurmaAtividade;
import persistencia.jdbc.TurmaAtividadeDAO;

/**
 * Metodo controller da turmaAtividade para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
@RequestMapping("turmaatividades")
public class TurmaAtividadeController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a turmaAtividade que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
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
	@CrossOrigin
	@GetMapping
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
	 * @param TurmaAtividade turmaAtividade
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody TurmaAtividade turmaAtividade) {
		Gson gson = new Gson();
		String json = gson.toJson(turmaAtividade);
		LOGGER.info("Requisição Inserir TurmaAtividade - {}",json);
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
	 * @param TurmaAtividade turmaAtividade
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody TurmaAtividade turmaAtividade) {
		Gson gson = new Gson();
		String json = gson.toJson(turmaAtividade);
		LOGGER.info("Requisição Atualizar TurmaAtividade - {}",json);
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
	@CrossOrigin
	@DeleteMapping("/{codigo}")
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
	@GetMapping("/turma/{idTurma}")
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
