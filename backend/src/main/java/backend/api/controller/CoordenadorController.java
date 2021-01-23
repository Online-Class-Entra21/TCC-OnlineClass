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

import entidade.Aluno;
import entidade.Convite;
import entidade.Coordenador;
import entidade.Usuario;
import persistencia.jdbc.AlunoDAO;
import persistencia.jdbc.ConviteDAO;
import persistencia.jdbc.CoordenadorDAO;
import persistencia.jdbc.UsuarioDAO;

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
