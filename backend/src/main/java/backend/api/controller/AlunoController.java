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

import entidade.Aluno;
import persistencia.jdbc.AlunoDAO;

/**
 * Metodo controller do aluno para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class AlunoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o aluno que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andrey
	 * @throws SQLException 
	 */
	@GetMapping(path = "/api/aluno/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Aluno codigo {} iniciada", codigo);
		Aluno aluno;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			aluno = alunoDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(aluno);
			LOGGER.info("Requisição Aluno codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição Aluno codigo {} mal sucedida erro : {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista de alunos registrados no sistema {GET}
	 * @return lista de aluno registrados no banco 
	 * @author Andrey
	 */
	@GetMapping(path = "/api/alunos")
	public List<Aluno> consultar(){
		LOGGER.info("Requisição List<Aluno>");
		List<Aluno> lista;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
		LOGGER.info("Requisição List<Aluno> Bem Sucedida");
		lista = alunoDao.buscarTodos();
		return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição Lista de todos os Alunos Mal Sucedida erro : {}", e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma novo aluno no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PostMapping(path = "api/aluno/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Aluno - {}",json);
		Gson gson = new Gson();
		Aluno aluno = gson.fromJson(json.toString(), Aluno.class);
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			alunoDao.insert(aluno);
			LOGGER.info("Requisição Inserir Aluno - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição Inserir Aluno - {} - Mal Sucedida erro : {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do aluno que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "api/aluno/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Aluno - {}",json);
		Gson gson = new Gson();
		Aluno aluno = gson.fromJson(json.toString(), Aluno.class);
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			alunoDao.update(aluno);
			LOGGER.info("Requisição Atualizar Aluno - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição Atualizar Aluno - {} - Mal Sucedida {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do aluno que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@DeleteMapping(path = "/api/aluno/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Aluno id - {}",codigo);
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			alunoDao.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Aluno id - {} - Bem Sucedida",codigo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Aluno id - {} - Mal Sucedida",codigo);
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora do principal
	//------------------------------------------------------------------
			
	/**
	 * Metodo para consulta da quantidade de alunos no sistema 
	 * @return int qtdAlunos
	 * @author Breno
	 */
	@GetMapping(path = "/api/alunos/quantidade")
	public int buscarQuantidade() {
		LOGGER.info("Requisição quantidade de alunos");
		int qtdAlunos;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			qtdAlunos = alunoDao.buscarQuantidadeAlunos();
			LOGGER.info("Requisição quantidade de alunos bem sucedida");
			return qtdAlunos;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar da quantidade de alunos Mal Sucedida - erro - {}",e.toString());
			return 0;
		}
	}
	
	/**
	 * Retorna a lista de alunos registrados no sistema em determinada turma {GET}
	 * @return lista de aluno registrados no banco em determinada turma
	 * @param int idTurma
	 * @author Andrey
	 */
	@GetMapping(path = "/api/alunos/{idTurma}")
	public List<Aluno> consultarTurma(@PathVariable("idTurma") int idTurma){
		LOGGER.info("Requisição List<Aluno>");
		List<Aluno> lista;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
		LOGGER.info("Requisição List<Aluno> Bem Sucedida");
		lista = alunoDao.buscarTodosTurma(idTurma);
		return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição Lista de todos os Alunos Mal Sucedida erro : {}", e.toString());
			return null;
		}
	}
}
