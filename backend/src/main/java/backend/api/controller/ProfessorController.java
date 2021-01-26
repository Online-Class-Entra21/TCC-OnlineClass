package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Professor;
import persistencia.jdbc.ProfessorDAO;

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
		List<Professor> lista;
		ProfessorDAO professorDao = new ProfessorDAO();
		try {
			lista = professorDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Professor Mal Sucedida - erro - {}",e.toString());
		}
		return lista;
	}
}
