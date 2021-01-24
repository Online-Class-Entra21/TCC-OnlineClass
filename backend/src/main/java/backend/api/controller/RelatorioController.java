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

import entidade.Relatorio;
import persistencia.jdbc.RelatorioDAO;

/**
 * Metodo controller do relatorio para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class RelatorioController {
	
	/**
	 * Retorna o relatorio que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/relatorio/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		RelatorioDAO relatorioDao = new RelatorioDAO();
		Relatorio relatorio;
		try {
			relatorio = relatorioDao.buscarId(codigo);
		} catch (SQLException e) {
			relatorio = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(relatorio);
		return json;
	}
	
	/**
	 * Retorna a lista dos relatorios registrados no sistema {GET}
	 * @return lista de relatorios registrados no banco
	 */
	@GetMapping(path = "/api/relatorios")
	public List<Relatorio> consultar(){
		List<Relatorio> lista;
		RelatorioDAO relatorioDao = new RelatorioDAO();
		try {
			lista = relatorioDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere um novo relatorio no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/relatorio/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Relatorio relatorio = gson.fromJson(json, Relatorio.class);
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		try {
			relatorioDAO.insert(relatorio);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração do relatorio que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/relatorio/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Relatorio relatorio = gson.fromJson(json, Relatorio.class);
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		try {
			relatorioDAO.update(relatorio);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	/**
	 * Método de exclusão do relatorio que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/relatorio/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		try {
			relatorioDAO.deleteId(codigo);
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
