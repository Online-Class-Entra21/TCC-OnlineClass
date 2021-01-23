package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Disciplina;

/**
 * Metodo para consulta da disciplina no banco de dados
 * @author Andrey
 *
 */
public class DisciplinaDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir Disciplina no banco de dados
	 * @param Disciplina disciplina 
	 * @author André
	 * @throws SQLException 
	 */
	public void insert(Disciplina disciplina) throws SQLException {
		String sql = "insert into disciplina (nome, numeroaulas) values (?,?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, disciplina.getNome());
		comandoSql.setInt(2, disciplina.getNumeroAulas());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma Disciplina no banco de dados.
	 * O <code>idDisciplina</code> deve ser igual ao do disciplina que deseja atualizar
	 * @param Disciplina disciplina 
	 * @author André
	 * @throws SQLException 
	 */ 
	public void update(Disciplina disciplina) throws SQLException {
		String sql = "update disciplina set nome = ?, numeroaulas = ? where iddisciplina = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, disciplina.getNome());
		comandoSql.setInt(2, disciplina.getNumeroAulas());
		comandoSql.setInt(3, disciplina.getIdDisciplina());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma Disciplina
	 *  O <code>idDisciplina</code> deve ser igual ao do disciplina que deseja deletar
	 * @param int idDisciplina
	 * @author Andre
	 */
	public void deleteId(int idDsciplina) {
		
		String sql = "delete from disciplina where iddisciplina = ?";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idDsciplina);
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
