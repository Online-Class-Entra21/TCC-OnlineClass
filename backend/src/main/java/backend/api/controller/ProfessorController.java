package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import backend.api.controller.form.ProfessorNotasForm;
import entidade.Professor;
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
	 * Insere um novo professor no banco de dados {POST}
	 * e retorna um 
	 * @param String json
	 * @author Andre
	 * @return int idProfessor
	 */
	@PostMapping(path = "/api/professor/inserir/return/{json}")
	public int inserirReturn(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Usuario - {}",json);
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try {
			int idUsuario = usuarioDAO.insertReturnID(usuario);
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
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "/api/professor/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Professor - {}",json);
		Gson gson = new Gson();
		Professor professor = gson.fromJson(json.toString(), Professor.class);
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
	@GetMapping(path = "/api/aluno/notas/{idAluno}")
	public List<ProfessorNotasForm> consultarProfessorNotas(@PathVariable("idAluno") int idAluno) {
		LOGGER.info("Requisição Notas aluno Existentes");
		List<ProfessorNotasForm> professorNotasForm;
		ProfessorDAO professorDao = new ProfessorDAO();
		try {
			professorNotasForm = professorDao.buscarNotasAluno(idAluno);
			LOGGER.info("Requisição Notas Aluno Existentes bem sucedida idAluno - {}",idAluno);
			return professorNotasForm;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para verificar Notas Aluno Existentes idAluno - {} Mal Sucedida - erro - {}",idAluno,e.toString());
			return null;
		}
	}
}

