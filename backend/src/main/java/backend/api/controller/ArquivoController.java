package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

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
 * @author Breno
 *
 */
@RestController
public class ArquivoController {
	
	/**
	 * Retorna o arquivo que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/arquivo/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		Arquivo arquivo;
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			arquivo = arquivoDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(arquivo);
			return json;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de arquivos registrados no sistema {GET}
	 * @return lista de arquivos registrados no banco 
	 */
	@GetMapping(path = "/api/arquivos")
	public List<Arquivo> consultar(){
		List<Arquivo> lista;
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			lista = arquivoDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insere uma novo arquivo no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/arquivo/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Arquivo arquivo = gson.fromJson(json.toString(), Arquivo.class);
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			arquivoDao.insert(arquivo);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo para alteração do arquivo que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/arquivo/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Arquivo arquivo = gson.fromJson(json.toString(), Arquivo.class);
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			arquivoDao.update(arquivo);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Método de exclusão do arquivo que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/arquivo/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		ArquivoDAO arquivoDao = new ArquivoDAO();
		try {
			arquivoDao.deleteId(codigo);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
