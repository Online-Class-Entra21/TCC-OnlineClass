package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import entidade.Aluno;
import entidade.Sala;
import entidade.SalaPadrao;
import entidade.Turma;
import persistencia.jdbc.AlunoDAO;
import persistencia.jdbc.SalaDAO;
import persistencia.jdbc.SalaPadraoDAO;
import persistencia.jdbc.TurmaDAO;

/**
 * Metodo controller da salaPadrao para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class SalaPadraoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a lista das salasPadroes registrados no sistema {GET}
	 * @return lista de salasPadroes registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/salasPadroes")
	public List<SalaPadrao> consultar(){
		LOGGER.info("Requisição List<SalaPadrao>");
		List<SalaPadrao> lista;
		SalaPadraoDAO salaPadraoDao = new SalaPadraoDAO();
		try {
			lista = salaPadraoDao.buscarTodos();
			LOGGER.info("Requisição List<SalaPadrao> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos SalaPadrao Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	@GetMapping(path = "/api/salasPadroes/usuario/{codigo}")
	public String consultarIdUsuario(@PathVariable("codigo") int codigo) {
		AlunoDAO alunoDAO = new AlunoDAO();
		TurmaDAO turmaDAO = new TurmaDAO();
		SalaDAO salaDAO = new SalaDAO();
		Gson gson = new Gson();
		try {
			Aluno aluno = alunoDAO.buscarIdUsuario(codigo);
			Turma turma = turmaDAO.buscarId(aluno.getFk_turma());
			Sala sala = salaDAO.buscarId(turma.getFk_sala());
			return gson.toJson(sala);
		} catch (SQLException e) {
			LOGGER.error("Requisição para Consultar Turma Mal Sucedida - Turma {} - erro - {}",codigo,e.toString());
			e.printStackTrace();
		}
		return null;
	}
}
