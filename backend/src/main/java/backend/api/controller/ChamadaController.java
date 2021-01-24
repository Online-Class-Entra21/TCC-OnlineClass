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
import persistencia.jdbc.ChamadaDAO;

/**
 * Metodo controller da chamada para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class ChamadaController {
	
	/**
	 * Retorna a chamada que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andrey
	 */
	@GetMapping(path = "/api/chamada/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		Chamada chamada;
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			chamada = chamadaDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(chamada);
			return json;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * Retorna a lista de chamadas registrados no sistema {GET}
	 * @return lista de chamadas registradas no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/chamadas")
	public List<Chamada> consultar(){
		List<Chamada> lista;
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			lista = chamadaDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insere uma nova chamada no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PostMapping(path = "api/chamada/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Chamada chamada = gson.fromJson(json.toString(), Chamada.class);
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			chamadaDao.insert(chamada);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo para alteração da chamada que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "api/chamada/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Chamada chamada = gson.fromJson(json.toString(), Chamada.class);
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			chamadaDao.update(chamada);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Método de exclusão da chamada que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@DeleteMapping(path = "/api/chamada/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		ChamadaDAO chamadaDao = new ChamadaDAO();
		try {
			chamadaDao.deleteId(codigo);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
