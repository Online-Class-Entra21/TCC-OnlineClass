package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Diretor;
import persistencia.jdbc.DiretorDAO;

/**
 * Metodo controller do diretor para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class DiretorController {
	
	/**
	 * Retorna a lista de diretores registrados no sistema {GET}
	 * @return lista de diretores registrados no banco
	 * @author Andrey
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
}
