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

import entidade.Reuniao;
import persistencia.jdbc.ReuniaoDAO;

/**
 * Metodo controller da reuniao para consulta no banco de dados através da API Rest
 * @author Andre
 */
@RestController
public class ReuniaoController {
	
	/**
	 * Retorna a reuniao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/reuniao/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		Reuniao reuniao;
		try {
			reuniao = reuniaoDao.buscarId(codigo);
		} catch (SQLException e) {
			reuniao = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(reuniao);
		return json;
	}
	
	/**
	 * Retorna a lista das reunioes registrados no sistema {GET}
	 * @return lista de reunioes registradas no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/reunioes")
	public List<Reuniao> consultar(){
		List<Reuniao> lista;
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		try {
			lista = reuniaoDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere uma nova reuniao no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/reuniao/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Reuniao reuniao = gson.fromJson(json, Reuniao.class);
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			reuniaoDAO.insert(reuniao);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Metodo para alteração da reuniao que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/reuniao/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		Gson gson = new Gson();
		Reuniao reuniao = gson.fromJson(json, Reuniao.class);
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			reuniaoDAO.update(reuniao);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão da reuniao que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/reuniao/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			reuniaoDAO.deleteId(codigo);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
