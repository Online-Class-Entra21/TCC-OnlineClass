
package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	/**
	 * Retorna a escola que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author André
	 */
	@GetMapping(path = "/api/escola/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		EscolaDAO escolaDAO = new EscolaDAO();
		Escola escola;
		try {
			escola = escolaDAO.buscarId(codigo);
		} catch (SQLException e) {
			escola = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(escola);
		return json;
	}
	
	/**
	 * Retorna a lista das escolas registrados no sistema {GET}
	 * @return lista de escolas registradas no banco
	 */
	@GetMapping(path = "/api/escolas")
	public List<Escola> consultar(){
		List<Escola> lista;
		EscolaDAO escolaDao = new EscolaDAO();
		try {
			lista = escolaDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere uma nova escola no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/escola/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Escola escola = gson.fromJson(json, Escola.class);
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.insert(escola);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da escola que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/escola/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Escola escola = gson.fromJson(json, Escola.class);
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.update(escola);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão da escola que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/escola/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
