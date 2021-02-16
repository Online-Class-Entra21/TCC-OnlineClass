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
import com.google.gson.GsonBuilder;

import backend.api.controller.form.TurmaAtividadeForm;
import entidade.Atividade;
import persistencia.jdbc.AtividadeDAO;

/**
 * Metodo controller da atividade para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class AtividadeController {	
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a atividade que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andrey
	 */
	@GetMapping(path = "/api/atividade/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Atividade codigo {} iniciada", codigo);
		Atividade atividade;
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			atividade = atividadeDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(atividade);
			LOGGER.info("Requisição Atividade codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Atividade Mal Sucedida - Atividade {} - erro - {}",codigo,e.toString());
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de atividades registrados no sistema {GET}
	 * @return lista de atividades registradas no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/atividades")
	public List<Atividade> consultar(){
		LOGGER.info("Requisição List<Atividade>");
		List<Atividade> lista;
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			lista = atividadeDao.buscarTodos();
			LOGGER.info("Requisição List<Atividade> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todas Atividade Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova atividade no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PostMapping(path = "api/atividade/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Atividade - {}",json);
		Gson gson = new Gson();
		Atividade atividade = gson.fromJson(json.toString(), Atividade.class);
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			atividadeDao.insert(atividade);
			LOGGER.info("Requisição Inserir Atividade - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Atividade Mal Sucedida - Atividade {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Metodo para alteração da atividade que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "api/atividade/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Atividade - {}",json);
		Gson gson = new Gson();
		Atividade atividade = gson.fromJson(json.toString(), Atividade.class);
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			atividadeDao.update(atividade);
			LOGGER.info("Requisição Atualizar Atividade - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Atividade Mal Sucedida - Atividade {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da atividade que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@DeleteMapping(path = "/api/atividade/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Atividade id - {}",codigo);
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			atividadeDao.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Atividade id - {} - Bem Sucedida",codigo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Atividade Mal Sucedida - Atividade {} - erro - {}",codigo,e.toString());
			return false;
		}
	}

	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Retorna a lista de atividades correspondentes ao id da turma informado (GET)
	 * @return lista de atividade registrados no banco na turma específica
	 * @param int idTurma
	 * @author Andrey
	 */
	@GetMapping(path = "/api/atividades/turma/{idTurma}")
	public List<TurmaAtividadeForm> consultarTurmaAtividade(@PathVariable int idTurma) {
		LOGGER.info("Requisição List<TurmaAtividadeForm>");
		List<TurmaAtividadeForm> lista;
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			lista = atividadeDao.buscarTurmaAtividade(idTurma);
			LOGGER.info("Requisição List<TurmaAtividadeForm> bem sucedida idTurma - {}",idTurma);
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos TurmaAtividade idTurma - {} Mal Sucedida - erro - {}",idTurma,e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova atividade no banco de dados {POST}
	 * e retorna o idAtividade gerado
	 * @param String json
	 * @return int idAtividade
	 * @author Andrey
	 */
	@PostMapping(path = "api/atividade/inserir/return/{json}")
	public int inserirReturnID(@PathVariable("json") String json) {
		System.out.println(json.toString());
		LOGGER.info("Requisição Inserir Atividade - {}",json);
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonBuilder.create();
		Atividade atividade = gson.fromJson(json.toString(), Atividade.class);
		AtividadeDAO atividadeDao = new AtividadeDAO();
		try {
			int idAtividade = atividadeDao.insertReturnID(atividade);
			LOGGER.info("Requisição Inserir Atividade - {} - Bem Sucedida",json);
			return idAtividade;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Atividade Mal Sucedida - Atividade {} - erro - {}",json,e.toString());
			return 0;
		}
	}
	
}
