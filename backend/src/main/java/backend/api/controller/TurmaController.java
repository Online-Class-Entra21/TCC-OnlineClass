package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import entidade.Turma;
import persistencia.jdbc.TurmaDAO;

/**
 * Metodo controller da turma para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
@RequestMapping("/turmas")
public class TurmaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a turma que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Turma codigo {} iniciada", codigo);
		TurmaDAO turmaDao = new TurmaDAO();
		Turma turma;
		try {
			turma = turmaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(turma);
			System.out.println(json);
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
	@CrossOrigin
	@GetMapping
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
	 * @param Turma turma
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody Turma turma) {
		Gson gson = new Gson();
		String json = gson.toJson(turma);
		LOGGER.info("Requisição Inserir Turma - {}",json);
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
	 * @param Turma turma
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Turma turma) {
		Gson gson = new Gson();
		String json = gson.toJson(turma);
		LOGGER.info("Requisição Atualizar Turma - {}",json);
		System.out.println(turma.getHorarioFinalAula());
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
	@CrossOrigin
	@DeleteMapping("/{codigo}")
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
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais
	//------------------------------------------------------------------
		
	/**
	 * Retorna a lista das turmas registrados no sistema pelo id da escola {GET}
	 * @return lista de turmas registradas no banco pelo id da escola
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping("/idescola/{codigo}")
	public List<Turma> consultarIdEscola(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição List<Turma> pelo fk_escola");
		List<Turma> lista;
		TurmaDAO turmaDao = new TurmaDAO();
		try {
			lista = turmaDao.buscarIdEscola(codigo);
			LOGGER.info("Requisição List<Turma> pelo fk_escola bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Turma pelo fk_escola Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}

	/**
	 * Retorna a lista das turmas registrados no sistema onde ocorre aquela disciplina {GET}
	 * @return lista de turmas registradas no banco onde ocorre aquela disciplina
	 * @author Breno
	 * @param int codigo 
	 */
	@CrossOrigin
	@GetMapping("/disciplina/{codigo}")
	public List<Turma> consultarDisciplina(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição List<Turma> pela disciplina");
		List<Turma> lista;
		TurmaDAO turmaDao = new TurmaDAO();
		try {
			lista = turmaDao.buscarDisciplina(codigo);
			LOGGER.info("Requisição List<Turma> pela disciplina bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Turma pela disciplina Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}

	/**
	 * Retorna a lista das turmas registrados no sistema onde ocorre aquela onde o professor da aula {GET}
	 * @return lista de turmas registradas no banco onde ocorre onde o professor da aula 
	 * @author Breno
	 * @param int codigo 
	 */
	@GetMapping("/turmas/professor/{codigo}")
	public List<Turma> consultarTurmasProfessor(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição List<Turma> pela disciplina");
		List<Turma> lista;
		TurmaDAO turmaDao = new TurmaDAO();
		try {
			lista = turmaDao.buscarTurmaIdUsuario(codigo);
			LOGGER.info("Requisição List<Turma> onde o professor da aula o  bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todas as Turma nde o professor da aula Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
}
