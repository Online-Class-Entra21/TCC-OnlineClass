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

import entidade.Relatorio;
import persistencia.jdbc.RelatorioDAO;

/**
 * Metodo controller do relatorio para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
public class RelatorioController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o relatorio que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @author Andre
	 * @return String json
	 */
	@GetMapping(path = "/api/relatorio/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Relatorio codigo {} iniciada", codigo);
		RelatorioDAO relatorioDao = new RelatorioDAO();
		Relatorio relatorio;
		try {
			relatorio = relatorioDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(relatorio);
			LOGGER.info("Requisição Relatorio codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Relatorio Mal Sucedida - Relatorio {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista dos relatorios registrados no sistema {GET}
	 * @author Andre
	 * @return lista de relatorios registrados no banco
	 */
	@GetMapping(path = "/api/relatorios")
	public List<Relatorio> consultar(){
		LOGGER.info("Requisição List<Relatorio>");
		List<Relatorio> lista;
		RelatorioDAO relatorioDao = new RelatorioDAO();
		try {
			lista = relatorioDao.buscarTodos();
			LOGGER.info("Requisição List<Relatorio> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Relatorio Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere um novo relatorio no banco de dados {POST}
	 * @author Andre
	 * @return boolean situacao da operacao
	 * @param String json
	 */
	@PostMapping(path = "api/relatorio/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Relatorio - {}",json);
		Gson gson = new Gson();
		Relatorio relatorio = gson.fromJson(json, Relatorio.class);
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		try {
			relatorioDAO.insert(relatorio);
			LOGGER.info("Requisição Inserir Relatorio - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Relatorio Mal Sucedida - Relatorio {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do relatorio que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/relatorio/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Relatorio - {}",json);
		Gson gson = new Gson();
		Relatorio relatorio = gson.fromJson(json, Relatorio.class);
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		try {
			relatorioDAO.update(relatorio);
			LOGGER.info("Requisição Atualizar Relatorio - {} - Bem Sucedida",json);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Relatorio Mal Sucedida - Relatorio {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do relatorio que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/relatorio/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Relatorio id - {}",codigo);
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		try {
			relatorioDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Relatorio id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Relatorio Mal Sucedida - Relatorio {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Retorna a lista dos relatorios registrados no sistema onde 
	 * o fk_usuario é igual ao codigo informado {GET}
	 * @param int fk_usuario
	 * @author Breno
	 * @return lista de relatorios registrados no banco onde fk_usuario é igual ao codigo
	 */
	@GetMapping(path = "/api/relatorios/{fk_usuario}")
	public List<Relatorio> consultarFk(@PathVariable("fk_usuario") int fk_usuario){
		LOGGER.info("Requisição List<Relatorio>");
		List<Relatorio> lista;
		RelatorioDAO relatorioDao = new RelatorioDAO();
		try {
			lista = relatorioDao.buscarTodosFk(fk_usuario);
			LOGGER.info("Requisição List<Relatorio> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Relatorio Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
}
