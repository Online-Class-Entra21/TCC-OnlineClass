
package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Escola;
import persistencia.jdbc.EscolaDAO;

/**
 * Metodo controller da escola para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class EscolaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a escola que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/escola/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Escola codigo {} iniciada", codigo);
		EscolaDAO escolaDAO = new EscolaDAO();
		Escola escola;
		try {
			escola = escolaDAO.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(escola);
			LOGGER.info("Requisição Escola codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Escola Mal Sucedida - Escola {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das escolas registrados no sistema {GET}
	 * @return lista de escolas registradas no banco
	 */
	@GetMapping(path = "/api/escolas")
	public List<Escola> consultar(){
		LOGGER.info("Requisição List<Escola>");
		List<Escola> lista;
		EscolaDAO escolaDao = new EscolaDAO();
		try {
			lista = escolaDao.buscarTodos();
			LOGGER.info("Requisição List<Escola> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Escola Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova escola no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "/api/escola/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Escola - {}",json);
		Gson gson = new Gson();
		Escola escola = gson.fromJson(json, Escola.class);
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.insert(escola);
			LOGGER.info("Requisição Inserir Escola - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Escola Mal Sucedida - Escola {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da escola que corresponde ao codigo informado {PUT}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "/api/escola/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Escola - {}",json);
		Gson gson = new Gson();
		Escola escola = gson.fromJson(json, Escola.class);
		System.out.println(escola.getIdEscola());
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.update(escola);
			LOGGER.info("Requisição Atualizar Escola - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Escola Mal Sucedida - Escola {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Insere uma nova escola no banco de dados só com o nome {POST}
	 * @param String json
	 * @author Andrey
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "/api/escola/inserir/nome/{json}")
	public boolean inserirNome(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Nome Escola - {}",json);
		Gson gson = new Gson();
		Escola escola = gson.fromJson(json, Escola.class);
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.insertNome(escola);
			LOGGER.info("Requisição Inserir Nome Escola - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Nome Escola Mal Sucedida - Escola {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Retorna a escola que corresponde ao nome indicado {GET}
	 * @param int nome
	 * @return String json
	 * @author Andrey
	 */
	@GetMapping(path = "/api/escola/buscar/nome/{nome}")
	public String consultarNome(@PathVariable("nome") String nome) {
		LOGGER.info("Requisição Escola Nome {} iniciada", nome);
		EscolaDAO escolaDAO = new EscolaDAO();
		Escola escola;
		try {
			escola = escolaDAO.buscarNome(nome);
			Gson gson = new Gson();
			String json = gson.toJson(escola);
			LOGGER.info("Requisição Escola nome {} bem sucedida",nome);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Escola Mal Sucedida - Escola {} - erro - {}",nome,e.toString());
			return null;
		}
	}
	
	/**
	 * Metodo para alteração da escola que corresponde ao codigo informado na visao do Adm {PUT}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "/api/escola/alterar/administrador/{json}")
	public boolean alterarAdm(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Escola - {}",json);
		Gson gson = new Gson();
		Escola escola = gson.fromJson(json, Escola.class);
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.updateAdm(escola);
			LOGGER.info("Requisição Atualizar Escola - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Escola Mal Sucedida - Escola {} - erro - {}",json,e.toString());
			return false;
		}
	}
}
