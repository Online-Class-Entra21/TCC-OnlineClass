package backend.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Administrador;
import entidade.Usuario;
import persistencia.jdbc.AdministradorDAO;
import persistencia.jdbc.UsuarioDAO;

/**
 * Metodo controller do administrador para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class AdministradorController {
	
	/**
	 * Retorna a lista de administradores registrados no sistema {GET}
	 * @return lista de administradores registrados no banco 
	 */
	@GetMapping(path = "/api/administradores")
	public List<Administrador> consultar(){
		List<Administrador> lista;
		AdministradorDAO administradorDao = new AdministradorDAO();
		try {
			lista = administradorDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 3 principais 
	//------------------------------------------------------------------
}
