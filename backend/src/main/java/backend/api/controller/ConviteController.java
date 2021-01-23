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

import entidade.Chamada;
import entidade.Convite;
import persistencia.jdbc.ChamadaDAO;
import persistencia.jdbc.ConviteDAO;

/**
 * Metodo controller do convite para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class ConviteController {

	/**
	 * Retorna o convite que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/convite/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		Convite convite;
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			convite = conviteDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(convite);
			return json;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de convites registrados no sistema {GET}
	 * @return lista de convites registrados no banco
	 */
	@GetMapping(path = "/api/convites")
	public List<Convite> consultar(){
		List<Convite> lista;
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			lista = conviteDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insere um novo convite no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/convite/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Convite convite = gson.fromJson(json.toString(), Convite.class);
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			conviteDao.insert(convite);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo para alteração do convite que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/convite/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Convite convite = gson.fromJson(json.toString(), Convite.class);
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			conviteDao.update(convite);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Método de exclusão do convite que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/convite/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		ConviteDAO conviteDao = new ConviteDAO();
		try {
			conviteDao.deleteId(codigo);
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
