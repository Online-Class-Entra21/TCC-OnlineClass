package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import backend.api.controller.form.ProfessorNotasForm;
import entidade.Professor;
import persistencia.jdbc.ProfessorDAO;
import persistencia.jdbc.UsuarioDAO;

/**
 * Metodo controller do professor para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
@RequestMapping("/professores")
public class ProfessorController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a lista dos professores registrados no sistema {GET}
	 * @return lista de professores registrados no banco
	 */
	@CrossOrigin
	@GetMapping
	public List<Professor> consultar(){
		LOGGER.info("Requisição List<Professor>");
		List<Professor> lista;
		ProfessorDAO professorDao = new ProfessorDAO();
		try {
			lista = professorDao.buscarTodos();
			LOGGER.info("Requisição List<Professor> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Professor Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora do principal
	//------------------------------------------------------------------
	
	/**
	 * Metodo para consulta da quantidade de professores no sistema 
	 * @return int qtdProfessores
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/quantidade")
	public int buscarQuantidade() {
		LOGGER.info("Requisição quantidade de professores");
		int qtdProfessores;
		ProfessorDAO professorDao = new ProfessorDAO();
		try {
			qtdProfessores = professorDao.buscarQuantidadeProfessores();
			LOGGER.info("Requisição quantidade de professores bem sucedida");
			return qtdProfessores;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar da quantidade de professores Mal Sucedida - erro - {}",e.toString());
			return 0;
		}
	}
	
	/**
	 * Insere um novo professor no banco de dados {POST}
	 * e retorna um 
	 * @param Professor professor
	 * @author Andre
	 * @return int idProfessor
	 */
	@CrossOrigin
	@PostMapping("/return")
	public int inserirReturn(@RequestBody Professor professor) {
		Gson gson = new Gson();
		String json = gson.toJson(professor);
		LOGGER.info("Requisição Inserir Usuario - {}",json);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try {
			int idUsuario = usuarioDAO.insertReturnID(professor);
			LOGGER.info("Requisição Inserir Usuario - {} - Bem Sucedida",json);
			return idUsuario;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Usuario Mal Sucedida - Usuario {} - erro - {}",json,e.toString());
			return 0;
		}
	}
	
	/**
	 * Metodo para alteração do professor que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param Professor professor
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Professor professor) {
		Gson gson = new Gson();
		String json = gson.toJson(professor);
		LOGGER.info("Requisição Atualizar Professor - {}",json);
		ProfessorDAO professorDao = new ProfessorDAO();
		try {
			professorDao.update(professor);
			LOGGER.info("Requisição Atualizar Professor - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Professor Mal Sucedida - Diretor {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Verifica se as notas do aluno (GET)
	 * @return notas
	 * @param int idAluno
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping("/notas/{idTurma}/{idAluno}")
	public List<ProfessorNotasForm> consultarProfessorNotas(@PathVariable("idTurma") int idTurma,@PathVariable("idAluno") int idAluno) {
		LOGGER.info("Requisição Notas aluno Existentes");
		List<ProfessorNotasForm> professorNotasForm;
		ProfessorDAO professorDao = new ProfessorDAO();
		try {
			professorNotasForm = professorDao.buscarNotasAluno(idTurma, idAluno);
			LOGGER.info("Requisição Notas Aluno Existentes bem sucedida idTurma - {} - idAluno - {}",idTurma,idAluno);
			return professorNotasForm;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para verificar Notas Aluno Existentes idTurma - {} - idAluno - {} Mal Sucedida - erro - {}",idTurma,idAluno,e.toString());
			return null;
		}
	}


	/**
	 * Verifica as notas do aluno por disciplina (GET)
	 * @return notas pelo idDisciplina
	 * @param int idTurma
	 * @param int idAluno
	 * @param int idDisciplina
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping("/notas/disciplina/{idTurma}/{idAluno}/{idDisciplina}")
	public List<ProfessorNotasForm> consultarProfessorNotasDisciplina(@PathVariable("idTurma") int idTurma,@PathVariable("idAluno") 
		   int idAluno, @PathVariable("idDisciplina") int idDisciplina) {
		
		LOGGER.info("Requisição Notas aluno Existentes");
		List<ProfessorNotasForm> professorNotasForm;
		ProfessorDAO professorDao = new ProfessorDAO();
		try {
			professorNotasForm = professorDao.buscarNotasAlunoDisciplina(idTurma, idAluno, idDisciplina);
			LOGGER.info("Requisição Notas Aluno Existentes bem sucedida idTurma - {} - idAluno - {} idDisciplina - {}",idTurma,idAluno, idDisciplina);
			return professorNotasForm;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para verificar Notas Aluno Existentes idTurma - {} - idAluno - {} idDisciplina - {} Mal Sucedida - erro - {}",idTurma,idAluno,idDisciplina,e.toString());
			return null;
		}
	}

}
