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

import entidade.Arquivo;
import persistencia.jdbc.ArquivoDAO;

/**
 * Metodo controller do arquivo para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class ArquivoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o arquivo que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andrey
	 */
	@GetMapping(path = "/api/arquivo/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Arquivo codigo {} iniciada", codigo);
		Arquivo arquivo;
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			arquivo = arquivoDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(arquivo);
			LOGGER.info("Requisição Arquivo codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Arquivo Mal Sucedida - Arquivo {} - erro - {}",codigo,e.toString());
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de arquivos registrados no sistema {GET}
	 * @return lista de arquivos registrados no banco 
	 * @author Andrey
	 */
	@GetMapping(path = "/api/arquivos")
	public List<Arquivo> consultar(){
		LOGGER.info("Requisição List<Arquivo>");
		List<Arquivo> lista;
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			lista = arquivoDao.buscarTodos();
			LOGGER.info("Requisição List<Arquivo> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Listar todos Arquivos Mal Sucedida erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma novo arquivo no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PostMapping(path = "api/arquivo/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Arquivo - {}",json);
		Gson gson = new Gson();
		Arquivo arquivo = gson.fromJson(json.toString(), Arquivo.class);
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			arquivoDao.insert(arquivo);
			LOGGER.info("Requisição Inserir Arquivo - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Arquivo Mal Sucedida - Arquivo {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do arquivo que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "api/arquivo/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Arquivo - {}",json);
		Gson gson = new Gson();
		Arquivo arquivo = gson.fromJson(json.toString(), Arquivo.class);
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			arquivoDao.update(arquivo);
			LOGGER.info("Requisição Atualizar Arquivo - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Arquivo Mal Sucedida - Arquivo {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do arquivo que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@DeleteMapping(path = "/api/arquivo/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Arquivo id - {}",codigo);
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			arquivoDao.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Arquivo id - {} - Bem Sucedida",codigo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Arquivo Mal Sucedida - Arquivo {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
}
