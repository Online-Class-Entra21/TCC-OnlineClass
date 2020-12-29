package persistencia.jdbc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;

public class AlunoDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(Aluno aluno) {
		return false;	
	}
	public boolean update(Aluno aluno) {
		return false;
	}
	public boolean delete(int idAluno) {
		return false;
	}
	public Aluno buscarId(int idAluno) {
		return null;
	}
	public List<Aluno> buscarTodos() {
		List<Aluno> lista =  new ArrayList<Aluno>();
		return lista;
	}
	
}
