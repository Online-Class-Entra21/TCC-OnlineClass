package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Disciplina;

public class DisciplinaDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(Disciplina disciplina) {
		
		String sql = "insert into disciplina (nome, numeroaulas) values (?,?)";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setString(1, disciplina.getNome());
			comandoSql.setInt(2, disciplina.getNumeroAulas());
			
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean update(Disciplina disciplina) {
		
		String sql = "update disciplina set nome = ?, numeroaulas = ? where iddisciplina = ?";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setString(1, disciplina.getNome());
			comandoSql.setInt(2, disciplina.getNumeroAulas());
			comandoSql.setInt(3, disciplina.getIdDisciplina());
			
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	public boolean deleteID(int id) {
		
		String sql = "delete from disciplina where iddisciplina = ?";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, id);
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public Disciplina buscarId(int id) {
		Disciplina disciplina = new Disciplina();
		
		String sql = "select * from Endereco where idendereco = ?";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, id);
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				disciplina.setIdDisciplina(resultSet.getInt(1));
				disciplina.setNome(resultSet.getString(2));
				disciplina.setNumeroAulas(resultSet.getInt(3));
				return disciplina;
			}
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Disciplina> buscarTodos() {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		
		String sql = "select * from Endereco";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setIdDisciplina(resultSet.getInt(1));
				disciplina.setNome(resultSet.getString(2));
				disciplina.setNumeroAulas(resultSet.getInt(3));
				lista.add(disciplina);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
}
