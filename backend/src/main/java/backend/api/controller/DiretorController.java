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

import entidade.Diretor;
import entidade.Usuario;
import persistencia.jdbc.DiretorDAO;
import persistencia.jdbc.UsuarioDAO;

/**
 * Metodo controller do diretor para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class DiretorController {
	
	/**
	 * Retorna a lista de diretores registrados no sistema {GET}
	 * @return lista de diretores registrados no banco
	 */
	@GetMapping(path = "/api/diretores")
	public List<Diretor> consultar(){
		List<Diretor> lista;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			lista = diretorDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
}
