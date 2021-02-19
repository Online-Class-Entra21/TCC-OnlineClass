package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import backend.api.controller.form.UsuarioDisciplinaTurmaForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.UsuarioDisciplinaTurma;
import persistencia.jdbc.UsuarioDisciplinaTurmaDAO;

/**
 * Metodo controller do usuarioDisciplinaTurma para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
@RequestMapping("usuariodisciplinaturmas")
public class UsuarioDisciplinaTurmaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o usuarioDisciplinaTurma que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
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
	@CrossOrigin
	@GetMapping()
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
	@CrossOrigin
	@DeleteMapping("/{codigo}")
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

	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Verifica se existe alguem UsuarioDisciplinaTurma identico no
	 * banco e Insere um novo UsuarioDisciplinaTurma no banco de dados
	 * caso nao tenha um igual ou retorna o id do UsuarioDisciplinaTurma
	 * ja existente
	 * 
	 * @param String json
	 * @author Andre
	 * @return id idUsuarioDisciplinaTurma
	 */	
	@PostMapping(path = "/api/usuarioDisciplinaTurma/inserirAlterar/{json}")
	public int inserirAlterarReturnID(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir UsuarioDisciplina - {}",json);
		Gson gson = new Gson();
		UsuarioDisciplinaTurma usuarioDisciplinaTurma = gson.fromJson(json, UsuarioDisciplinaTurma.class);
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDAO = new UsuarioDisciplinaTurmaDAO();
		try {
			int idUserDisc = usuarioDisciplinaTurmaDAO.buscarIgual(usuarioDisciplinaTurma);
			if (idUserDisc==0) {
				idUserDisc = usuarioDisciplinaTurmaDAO.insertReturn(usuarioDisciplinaTurma);
			}
			
			LOGGER.info("Requisição Inserir UsuarioDisciplina - Bem Sucedida - {}",json);
			return idUserDisc;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir UsuarioDisciplina Mal Sucedida - Usuario {} - erro - {}",json,e.toString());
			return 0;
		}
	}
	
	/**
	 * Retorna a lista dos usuarioDisciplinaTurma das disciplinas do
	 * professor idProfessor registrados no sistema {GET} com o idTurma,
	 *  
	 * @return lista de usuariosDisciplinasTurmas registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/turmasUsuariosDisciplinas/{idTurma}/{idProfessor}")
	public List<UsuarioDisciplinaTurma> consultarTurmaProfessor(@PathVariable int idTurma,@PathVariable int idProfessor){
		LOGGER.info("Requisição List<UsuarioDisciplinaTurma> idTurma {}, idProfessor {}",idTurma,idProfessor);
		List<UsuarioDisciplinaTurma> lista;
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDao = new UsuarioDisciplinaTurmaDAO();
		try {
			lista = usuarioDisciplinaTurmaDao.buscarUsuarioDisciplinaTurmaIdTurmaIdProfessor(idTurma, idProfessor);
			LOGGER.info("Requisição List<UsuarioDisciplinaTurma> idTurma {}, idProfessor {} bem sucedida",idTurma,idProfessor);
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos UsuarioDisciplinaTurma idTurma {}, idProfessor {} Mal Sucedida - erro - {}",idTurma,idProfessor,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das turmas do professor pelo id do usuario
	 * @return lista de turmas registradas no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/turmas/usuario/{idUsuario}")
	public List<UsuarioDisciplinaTurmaForm> consultarTurmaUsuario(@PathVariable int idUsuario){
		LOGGER.info("Requisição List<UsuarioDisciplinaTurmaForm> idProfessor {}",idUsuario);
		List<UsuarioDisciplinaTurmaForm> lista;
		UsuarioDisciplinaTurmaDAO usuarioDisciplinaTurmaDao = new UsuarioDisciplinaTurmaDAO();
		try {
			lista = usuarioDisciplinaTurmaDao.buscarTurmasIdUsuario(idUsuario);
			LOGGER.info("Requisição List<UsuarioDisciplinaTurmaForm> idUsuario {} bem sucedida",idUsuario);
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos UsuarioDisciplinaTurmaForm idUsuario {} Mal Sucedida - erro - {}",idUsuario,e.toString());
			return null;
		}
	}
}
