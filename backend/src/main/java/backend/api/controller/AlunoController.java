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
import persistencia.jdbc.AlunoDAO;

/**
 * Metodo controller do aluno para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class AlunoController {
	
	/**
	 * Retorna o aluno que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andrey
	 * @throws SQLException 
	 */
	@GetMapping(path = "/api/aluno/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		Aluno aluno;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			aluno = alunoDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(aluno);
			return json;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	/**
	 * Retorna a lista de alunos registrados no sistema {GET}
	 * @return lista de aluno registrados no banco 
	 * @author Andrey
	 */
	@GetMapping(path = "/api/alunos")
	public List<Aluno> consultar(){
		List<Aluno> lista;
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			lista = alunoDao.buscarTodos();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Insere uma novo aluno no banco de dados {POST}
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PostMapping(path = "api/aluno/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Aluno aluno = gson.fromJson(json.toString(), Aluno.class);
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			alunoDao.insert(aluno);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Metodo para alteração do aluno que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@PutMapping(path = "api/aluno/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Aluno aluno = gson.fromJson(json.toString(), Aluno.class);
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			alunoDao.update(aluno);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Método de exclusão do aluno que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @return boolean situacao da operacao
	 * @author Andrey
	 */
	@DeleteMapping(path = "/api/aluno/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		AlunoDAO alunoDao = new AlunoDAO();
		try {
			alunoDao.deleteId(codigo);
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
