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
	 * Metodo para inserir disciplina no banco de dados
	 * @param Disciplina disciplina 
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void insert(Disciplina disciplina) throws SQLException {
		String sql = "insert into disciplina (nome, fk_escola) values (?,?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, disciplina.getNome());
		comandoSql.setInt(2, disciplina.getFk_escola());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma disciplina no banco de dados.
	 * O <code>idDisciplina</code> deve ser igual ao do disciplina que deseja atualizar
	 * @param Disciplina disciplina 
	 * @author Andrey
	 * @throws SQLException 
	 */ 
	public void update(Disciplina disciplina) throws SQLException {
		String sql = "update disciplina set nome = ?, numeroaulas = ? where iddisciplina = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, disciplina.getNome());
		comandoSql.setInt(2, disciplina.getIdDisciplina());
		comandoSql.setInt(3, disciplina.getFk_escola());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma disciplina.
	 *  O <code>idDisciplina</code> deve ser igual ao do disciplina que deseja deletar
	 * @param int idDisciplina
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void deleteId(int idDisciplina) throws SQLException {
		String sql = "delete from disciplina where iddisciplina = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idDisciplina);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar disciplina no banco de dados.
	 * O <code>idDisciplina</code> deve ser igual ao do disciplina que deseja buscar
	 * @param int idDisciplina
	 * @return Disciplina disciplina 
	 * @author Andrey
	 * @throws SQLException 
	 */
	public Disciplina buscarId(int idDisciplina) throws SQLException {
		Disciplina disciplina = new Disciplina();
		String sql = "select * from Disciplina where idDisciplina = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idDisciplina);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			disciplina.setIdDisciplina(resultSet.getInt(1));
			disciplina.setNome(resultSet.getString(2));
			disciplina.setFk_escola(resultSet.getInt(3));
		}
		comandoSql.close();
		return disciplina;
	}
	
	/**
	 * Metodo para selecionar todas as discilina do banco de dados
	 * @return lista de disciplinas resgistradas no banco 
	 * @author Andrey
	 * @throws SQLException 
	 */
	public List<Disciplina> buscarTodos() throws SQLException {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		String sql = "select * from Disciplina";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Disciplina disciplina = new Disciplina();
			disciplina.setIdDisciplina(resultSet.getInt(1));
			disciplina.setNome(resultSet.getString(2));
			disciplina.setFk_escola(resultSet.getInt(3));
			
			lista.add(disciplina);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais
	//------------------------------------------------------------------
	
	/**
	 * Metodo para selecionar todas as disciplinas do banco de dados
	 * @return lista de disciplinas resgistradas no banco 
	 * @param int fk_escola
	 * @author Breno
	 * @throws SQLException 
	 */
	public List<Disciplina> buscarTodosFk(int fk_escola) throws SQLException {
		List<Disciplina> lista = new ArrayList<Disciplina>();
		String sql = "select * from Disciplina where fk_escola = ?";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, fk_escola);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Disciplina disciplina = new Disciplina();
			disciplina.setIdDisciplina(resultSet.getInt(1));
			disciplina.setNome(resultSet.getString(2));
			disciplina.setFk_escola(resultSet.getInt(3));
			
			lista.add(disciplina);
		}
		comandoSql.close();
		return lista;
	}
}
