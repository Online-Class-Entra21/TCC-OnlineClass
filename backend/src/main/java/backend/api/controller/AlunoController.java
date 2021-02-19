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

import entidade.Aluno;
import persistencia.jdbc.AlunoDAO;

/**
 * Metodo controller do aluno para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o aluno que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return Aluno aluno
	 * @author Andrey
	 * @throws SQLException 
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
	public Aluno consultar(@PathVariable int codigo) {
		LOGGER.info("Requisição Aluno codigo {} iniciada", codigo);
		Aluno aluno;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			aluno = alunoDao.buscarId(codigo);
			LOGGER.info("Requisição Aluno codigo {} bem sucedida",codigo);
			return aluno;
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
	@CrossOrigin
	@GetMapping
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
	 * @param Aluno aluno
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody Aluno aluno) {
		Gson gson = new Gson();
		String json = gson.toJson(aluno);
		LOGGER.info("Requisição Inserir Aluno - {}",aluno);
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
	 * @param Aluno aluno
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Aluno aluno) {
		Gson gson = new Gson();
		String json = gson.toJson(aluno);
		LOGGER.info("Requisição Atualizar Aluno - {}",aluno);
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
	@CrossOrigin
	@DeleteMapping("/{codigo}")
	public boolean deletar(@PathVariable int codigo) {
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
	@CrossOrigin
	@GetMapping("/quantidade")
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
	@CrossOrigin
	@GetMapping("/turma/{idTurma}")
	public List<Aluno> consultarTurma(@PathVariable int idTurma){
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
	
	/**
	 * Retorna o aluno que corresponde ao id do usuario {GET}
	 * @param int codigo 
	 * @return Aluno aluno
	 * @author Andrey
	 * @throws SQLException 
	 */
	@CrossOrigin
	@GetMapping("/usuario/{codigo}")
	public Aluno consultarIdUsuario(@PathVariable int codigo) {
		LOGGER.info("Requisição Aluno pelo idUsuario {} iniciada", codigo);
		Aluno aluno;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			aluno = alunoDao.buscarIdUsuario(codigo);
			LOGGER.info("Requisição Aluno pelo idUsuario {} bem sucedida",codigo);
			return aluno;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição Aluno pelo idUsuario {} mal sucedida erro : {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Metodo para alteração do aluno que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param Aluno aluno
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@CrossOrigin
	@PutMapping("/alterar/perfil")
	public boolean alterarAluno(@RequestBody Aluno aluno) {
		Gson gson = new Gson();
		String json = gson.toJson(aluno);
		LOGGER.info("Requisição Atualizar Aluno - {}",json);
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			alunoDao.updateAluno(aluno);
			LOGGER.info("Requisição Atualizar Aluno - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição Atualizar Aluno - {} - Mal Sucedida {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Metodo para consulta da quantidade de alunos de uma turma no sistema 
	 * @return int qtdAlunos
	 * @param int idTurma
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/quantidade/{idTurma}")
	public int buscarQuantidade(@PathVariable int idTurma) {
		LOGGER.info("Requisição quantidade de alunos");
		int qtdAlunos;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			qtdAlunos = alunoDao.buscarQuantidadeAlunos(idTurma);
			LOGGER.info("Requisição quantidade de alunos bem sucedida");
			return qtdAlunos;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar da quantidade de alunos Mal Sucedida - erro - {}",e.toString());
			return 0;
		}
	}
}
