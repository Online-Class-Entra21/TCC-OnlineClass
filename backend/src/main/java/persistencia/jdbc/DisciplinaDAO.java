package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Disciplina;

public class DisciplinaDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir Disciplina no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>Disciplina</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */
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
	
	/**
	 * Metodo para atualizar uma Disciplina no banco de dados.
	 * 
	 * O id da <code>Disciplina</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param <code>Disciplina</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */ 
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
	
	/**
	 *  Metodo para deletar do banco de dados uma Disciplina
	 *  <p>
	 *  O <code>idDisciplina</code> deve ser igual ao id do banco de dados
	 * 
	 * @param <code>Disciplina</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */
	public boolean deleteId(int id) {
		
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
	
	/**
	 * Metodo para selecionar <code>Disciplina</code> no banco de dados
	 * <p>
	 * O <code>idDisciplina</code> deve ser igual a Disciplina que deseja selecionar
	 * 
	 * @param <code>idDisciplina<code>
	 * @return Disciplina
	 * @author Andre
	 */
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
	
	/**
	 * Metodo para selecionar todas as <code>Disciplinas</code> do banco de dados
	 * 
	 * @return <code>List</code>
	 * @author Andre
	 */
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
