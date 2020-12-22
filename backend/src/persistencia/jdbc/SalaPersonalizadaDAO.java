package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Sala;
import entidade.SalaPersonalizada;

public class SalaPersonalizadaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma Sala Personalizada no banco de dados
	 * @param sala
	 * @return
	 */
	public boolean insert(SalaPersonalizada salaPersonalizada) {
		
		String sql = "insert into salaPersonalizada (dono, fk_sala) values (?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, salaPersonalizada.getDono());
			comandoSql.setInt(2, salaPersonalizada.getFk_Sala());
			
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
	 * Realiza atualização dos dados da Sala personalizada no banco de dados
	 * @param sala
	 * @return
	 */
	public boolean update(SalaPersonalizada salaPersonalizada) {
		
		String sql = "Update salaPersonalizada set dono = ?, fk_sala = ? where idSalaPersonalizada = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		    
			comandoSql.setInt(1, salaPersonalizada.getDono());
			comandoSql.setInt(2, salaPersonalizada.getFk_Sala());
			comandoSql.setInt(3, salaPersonalizada.getIdSalaPersonalizada());
			
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
	 * Realiza a exclusão dos dados de uma linha da tabela Sala Personalizada
	 * @param idSala
	 * @return
	 */
	public boolean delete(int idSalaPersonalizada) {
		
		String sql = "delete from salaPersonalizada where idSalaPersonalizada = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idSalaPersonalizada);
			
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
	 * da tabela Sala Personalizada do banco de dados
	 * @param idSalaPersonalizada
	 * @return
	 */
	public SalaPersonalizada buscarPorId(int idSalaPersonalizada) {
		SalaPersonalizada salaPersonalizada = new SalaPersonalizada(); 
		
		String sql = "select * from salaPersonalizada where idSalaPersonalizada = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idSalaPersonalizada);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				salaPersonalizada.setIdSalaPersonalizada(resultSet.getInt(1));
				salaPersonalizada.setDono(resultSet.getInt(2));
				salaPersonalizada.setFk_Sala(resultSet.getInt(3));
				comandoSql.close(); 
				return salaPersonalizada;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela Sala Personalizada do banco de dados 
	 * @return
	 */
	public List<SalaPersonalizada> buscarTodos() {
		
		List<SalaPersonalizada> lista = new ArrayList<SalaPersonalizada>(); 
		
		String sql = "select * from salaPersonalizada"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				SalaPersonalizada salaPersonalizada = new SalaPersonalizada(); 
				salaPersonalizada.setIdSalaPersonalizada(resultSet.getInt(1));
				salaPersonalizada.setDono(resultSet.getInt(2));
				salaPersonalizada.setFk_Sala(resultSet.getInt(3));
				lista.add(salaPersonalizada); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
