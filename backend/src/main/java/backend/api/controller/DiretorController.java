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

import entidade.Diretor;
import persistencia.jdbc.DiretorDAO;

/**
 * Metodo controller do diretor para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class DiretorController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a lista de diretores registrados no sistema {GET}
	 * @return lista de diretores registrados no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/diretores")
	public List<Diretor> consultar(){
		LOGGER.info("Requisição List<Diretor>");
		List<Diretor> lista;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			lista = diretorDao.buscarTodos();
			LOGGER.info("Requisição List<Diretor> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Diretor Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora do principal
	//------------------------------------------------------------------
	
	/**
	 * Retorna o diretor que comanda o a escola com o fk informado atrvés dos parametros {GET}
	 * @param codigo
	 * @return String json 
	 * @author Andrey
	 */
	@GetMapping(path = "/api/diretor/escola/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição Diretor codigo {} iniciada", codigo);
		Diretor diretor;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretor = diretorDao.buscarDiretorEscola(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(diretor);
			LOGGER.info("Requisição Diretor codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Diretor Mal Sucedida - Diretor {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Metodo para alteração da escola comandada pelo diretor {PUT}
	 * @param int codigo escola
	 * @param int codigo diretor
	 * @author Andrey
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/diretor/escola/alterar/{codigoEscola}/{codigoDiretor}")
	public boolean alterar(@PathVariable("codigoEscola") int codigoEscola, @PathVariable("codigoDiretor") int codigoDiretor) {
		LOGGER.info("Requisição Atualizar Usuario.fk_escola - Novo fk.escola:{}",codigoEscola);
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretorDao.atualizarEscola(codigoEscola, codigoDiretor);
			LOGGER.info("Requisição Atualizar Usuario.fk_escola - Novo fk.escola:{} - Bem Sucedida",codigoEscola);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Usuario.fk_escola Mal Sucedida - fk.escola{} - erro - {}",codigoEscola,e.toString());
			return false;
		}
	}
	
	/**
	 * Método para remover a escola sob comando do diretor {PUT}
	 * @param int id codigo escola
	 * @param int id codigo diretor
	 * @author Andrey
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/diretor/escola/remover/{codigoDiretor}")
	public boolean removerEscola(@PathVariable("codigoDiretor") int codigoDiretor) {
		LOGGER.info("Requisição Remover Usuario.fk_escola - Remover fk.escola:{}",codigoDiretor);
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretorDao.removerEscola(codigoDiretor);
			LOGGER.info("Requisição Remover Usuario.fk_escola - Remover fk.escola:{} - Bem Sucedida",codigoDiretor);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.error("Requisição para Remover Usuario.fk_escola Mal Sucedida - fk.escola{} - erro - {}",codigoDiretor,e.toString());
			return false;
		}
	}
	
	/**
	 * Retorna a lista de diretores registrados no sistema que não possuem uma escola registrada {GET}
	 * @return lista de diretores sem escola registrados no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/diretores/disponiveis")
	public List<Diretor> consultarDiretoresDisponiveis(){
		LOGGER.info("Requisição List<Diretor> sem Escolas");
		List<Diretor> lista;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			lista = diretorDao.buscarDiretoresDisponiveis();
			LOGGER.info("Requisição List<Diretor> sem Escolas bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Diretores sem Escolas Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Metodo para consulta da quantidade de diretores no sistema 
	 * @return int qtdDiretores
	 * @author Breno
	 */
	@GetMapping(path = "/api/diretores/quantidade")
	public int buscarQuantidade() {
		LOGGER.info("Requisição quantidade de diretores");
		int qtdDiretores;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			qtdDiretores = diretorDao.buscarQuantidadeDiretores();
			LOGGER.info("Requisição quantidade de diretores bem sucedida");
			return qtdDiretores;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar da quantidade de diretores Mal Sucedida - erro - {}",e.toString());
			return 0;
		}
	}
	
	/**
	 * Insere uma novo usuário diretor no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "/api/diretor/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Usuario - {}",json);
		Gson gson = new Gson();
		Diretor diretor = gson.fromJson(json.toString(), Diretor.class);
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretorDao.insert(diretor);
			LOGGER.info("Requisição Inserir Usuario - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Usuario Mal Sucedida - Usuario {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Metodo para alteração do diretor que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Breno
	 */
	@PutMapping(path = "/api/diretor/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Diretor - {}",json);
		Gson gson = new Gson();
		Diretor diretor = gson.fromJson(json.toString(), Diretor.class);
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretorDao.update(diretor);
			LOGGER.info("Requisição Atualizar Diretor - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Diretor Mal Sucedida - Diretor {} - erro - {}",json,e.toString());
			return false;
		}
	}
}
