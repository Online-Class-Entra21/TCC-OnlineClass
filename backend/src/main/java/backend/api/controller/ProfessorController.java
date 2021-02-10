package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import entidade.Disciplina;
import entidade.Professor;
import entidade.Turma;
import entidade.Usuario;
import persistencia.jdbc.ProfessorDAO;
import persistencia.jdbc.UsuarioDAO;

/**
 * Metodo controller do professor para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class ProfessorController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a lista dos professores registrados no sistema {GET}
	 * @return lista de professores registrados no banco
	 */
	@GetMapping(path = "/api/professores")
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
	@GetMapping(path = "/api/professores/quantidade")
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
	 * Insere uma novo usuário no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/usuario/inserir/{jsonProf}/{jsonMate}/{jsonTurm}")
	public boolean inserir(@PathVariable("jsonProf") String jsonProf,@PathVariable("jsonMate") String jsonMate,@PathVariable("jsonTurm") String jsonTurm) {
		LOGGER.info("Requisição Inserir Professor Materias e Turmas - {} - {} - {}",jsonProf,jsonMate,jsonTurm);
		Gson gson = new Gson();
		Usuario professor = gson.fromJson(jsonProf.toString(), Usuario.class);
		Disciplina[] disciplinas = gson.fromJson(jsonMate, Disciplina[].class);
		Turma[] turmas = gson.fromJson(jsonTurm, Turma[].class); 
		ProfessorDAO professorDAO = new ProfessorDAO();
		try {
			int idprof = professorDAO.insertReturnID(professor);
			
			
			LOGGER.info("Requisição Inserir Professor - {} - Bem Sucedida",jsonProf);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Professor Materias e Turmas Mal Sucedida - {} - {} - {} - erro - {}",jsonProf,jsonMate,jsonTurm,e.toString());
			return false;
		}
	}
}
