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

import entidade.UsuarioDisciplinaTurma;
import persistencia.jdbc.UsuarioDisciplinaTurmaDAO;

/**
 * Metodo controller do usuarioDisciplinaTurma para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class UsuarioDisciplinaTurmaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o usuarioDisciplinaTurma que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@GetMapping(path = "/api/usuarioDisciplinaTurma/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição UsuarioDisciplinaTurma codigo {} iniciada", codigo);
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDao = new UsuarioDisciplinaTurmaDAO();
		UsuarioDisciplinaTurma usuarioDisciplinaTurma;
		try {
			usuarioDisciplinaTurma = usuarioDisciplinaTurmaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(usuarioDisciplinaTurma);
			LOGGER.info("Requisição UsuarioDisciplinaTurma codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar UsuarioDisciplinaTurma Mal Sucedida - UsuarioDisciplinaTurma {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista dos usuarioDisciplinaTurma registrados no sistema {GET}
	 * @return lista de usuariosDisciplinasTurmas registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/turmasUsuariosDisciplinas")
	public List<UsuarioDisciplinaTurma> consultar(){
		LOGGER.info("Requisição List<UsuarioDisciplinaTurma>");
		List<UsuarioDisciplinaTurma> lista;
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDao = new UsuarioDisciplinaTurmaDAO();
		try {
			lista = usuarioDisciplinaTurmaDao.buscarTodos();
			LOGGER.info("Requisição List<UsuarioDisciplinaTurma> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos UsuarioDisciplinaTurma Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere um novo usuarioDisciplinaTurma no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/usuarioDisciplinaTurma/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir UsuarioDisciplinaTurma - {}",json);
		Gson gson = new Gson();
		UsuarioDisciplinaTurma usuarioDisciplinaTurma = gson.fromJson(json, UsuarioDisciplinaTurma.class);
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDAO = new UsuarioDisciplinaTurmaDAO();
		try {
			usuarioDisciplinaTurmaDAO.insert(usuarioDisciplinaTurma);
			LOGGER.info("Requisição Inserir UsuarioDisciplinaTurma - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir UsuarioDisciplinaTurma Mal Sucedida - UsuarioDisciplinaTurma {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do usuarioDisciplinaTurma que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/usuarioDisciplinaTurma/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar UsuarioDisciplinaTurma - {}",json);
		Gson gson = new Gson();
		UsuarioDisciplinaTurma usuarioDisciplinaTurma = gson.fromJson(json, UsuarioDisciplinaTurma.class);
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDAO = new UsuarioDisciplinaTurmaDAO();
		try {
			usuarioDisciplinaTurmaDAO.update(usuarioDisciplinaTurma);
			LOGGER.info("Requisição Atualizar UsuarioDisciplinaTurma - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar UsuarioDisciplinaTurma Mal Sucedida - UsuarioDisciplinaTurma {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do usuarioDisciplinaTurma que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/usuarioDisciplinaTurma/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar UsuarioDisciplinaTurma id - {}",codigo);
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDAO = new UsuarioDisciplinaTurmaDAO();
		try {
			usuarioDisciplinaTurmaDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar UsuarioDisciplinaTurma id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar UsuarioDisciplinaTurma Mal Sucedida - UsuarioDisciplinaTurma {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
