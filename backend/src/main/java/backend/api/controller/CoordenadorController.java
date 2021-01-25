package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Coordenador;
import persistencia.jdbc.CoordenadorDAO;

/**
 * Metodo controller do coordenador para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class CoordenadorController {
	
	/**
	 * Retorna a lista de coordenadores registrados no sistema {GET}
	 * @return lista de coordenadores registrados no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/coordenadores")
	public List<Coordenador> consultar(){
		List<Coordenador> lista;
		CoordenadorDAO coordenadorDao = new CoordenadorDAO();
		try {
			lista = coordenadorDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
