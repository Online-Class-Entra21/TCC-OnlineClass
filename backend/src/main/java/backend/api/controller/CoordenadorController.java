package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Coordenador;
import persistencia.jdbc.CoordenadorDAO;

/**
 * Metodo controller do coordenador para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class CoordenadorController {
	
	/**
	 * Retorna a lista de coordenadores registrados no sistema {GET}
	 * @return lista de coordenadores registrados no banco
	 */
	@GetMapping(path = "/api/coordenadores")
	public List<Coordenador> consultar(){
		List<Coordenador> lista;
		CoordenadorDAO coordenadorDao = new CoordenadorDAO();
		try {
			lista = coordenadorDao.buscarTodos();
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
