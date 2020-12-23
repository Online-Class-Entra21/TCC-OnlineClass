package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Sala;
import entidade.TurmaAtividade;

public class TurmaAtividadeDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma TurmaAtividade no banco de dados
	 * @param turmaAtividade
	 * @return
	 */
	public boolean insert(TurmaAtividade turmaAtividade) {
		
		String sql = "insert into turmaAtividade (id_Turma_Atividade, fk_Turma, fk_Atividade) values (?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, turmaAtividade.getIdTurmaAtividade());
			comandoSql.setInt(2, turmaAtividade.getFk_Turma());
			comandoSql.setInt(3, turmaAtividade.getFk_Atividade());
			
			comandoSql.execute(); 
			
			comandoSql.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		return true; 
	}
	
	/**
	 * Realiza atualização dos dados da TurmaAtividade no banco de dados
	 * @param turmaAtividade
	 * @return
	 */
	public boolean update(TurmaAtividade turmaAtividade) {
		
		String sql = "Update turmaAtividade set fk_Turma = ?,"
				+ "fk_Atividade = ? where idTurmaAtividade = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		    
			comandoSql.setInt(1, turmaAtividade.getFk_Turma());
			comandoSql.setInt(2, turmaAtividade.getFk_Atividade());
			comandoSql.setInt(3, turmaAtividade.getIdTurmaAtividade());
			
			comandoSql.execute(); 
			
			comandoSql.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		return true; 
	}
	
	/**
	 * Realiza a exclusão dos dados de uma linha da tabela TurmaAtividade
	 * @param idTurmaAtividade
	 * @return
	 */
	public boolean delete(int idTurmaAtividade) {
		
		String sql = "delete from turmaAtividade where idSala = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurmaAtividade);
			
			comandoSql.execute(); 
			
			comandoSql.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		return true; 
	}
	
	/**
	 * Método de busca de todas as informações de uma linha
	 * da tabela TurmaAtividade do banco de dados
	 * @param idTurmaAtividade
	 * @return
	 */
	public TurmaAtividade buscarPorId(int idTurmaAtividade) {
		TurmaAtividade turmaAtividade = new TurmaAtividade(); 
		
		String sql = "select * from turmaAtividade where idTurmaAtividade = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurmaAtividade);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				turmaAtividade.setIdTurmaAtividade(resultSet.getInt(1));
				turmaAtividade.setFk_Turma(resultSet.getInt(2));
				turmaAtividade.setFk_Atividade(resultSet.getInt(3));
				comandoSql.close(); 
				return turmaAtividade;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela TurmaAtividade do banco de dados 
	 * @return
	 */
	public List<TurmaAtividade> buscarTodos() {
		
		List<TurmaAtividade> lista = new ArrayList<TurmaAtividade>(); 
		
		String sql = "select * from turmaAtividade"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				TurmaAtividade turmaAtividade = new TurmaAtividade(); 
				turmaAtividade.setIdTurmaAtividade(resultSet.getInt(1));
				turmaAtividade.setFk_Turma(resultSet.getInt(2));
				turmaAtividade.setFk_Atividade(resultSet.getInt(3));
				lista.add(turmaAtividade); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
