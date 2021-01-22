package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entidade.Sala;

public class SalaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma Sala no banco de dados
	 * @param sala
	 * @return
	 * @author Breno
	 */
	public boolean insert(Sala sala) {
		
		String sql = "insert into sala (nome, descricao, situacaoAcesso, tipoSala, link) values (?,?,?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setString(1, sala.getNome());
			comandoSql.setString(2, sala.getDescricao());
			comandoSql.setBoolean(3, sala.getSituacaoAcesso());
			comandoSql.setBoolean(4, sala.getTipoSala());
			comandoSql.setString(5, sala.getLink());
			
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
	 * Realiza atualizacao dos dados da Sala no banco de dados
	 * @param sala
	 * @return
	 * @author Breno
	 */
	public boolean update(Sala sala) {
		
		String sql = "Update sala set nome = ?, descricao = ?,"
				+ "situacaoAcesso = ?, tipoSala = ?, link = ? where idSala = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		    
			comandoSql.setString(1, sala.getNome());
			comandoSql.setString(2, sala.getDescricao());
			comandoSql.setBoolean(3, sala.getSituacaoAcesso());
			comandoSql.setBoolean(4, sala.getTipoSala());
			comandoSql.setString(5, sala.getLink());
			comandoSql.setInt(6, sala.getIdSala());
			
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
	 * Realiza a exclusao dos dados de uma linha da tabela Sala
	 * @param idSala
	 * @return
	 * @author Breno
	 */
	public boolean deleteId(int idSala) {
		
		String sql = "delete from sala where idSala = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idSala);
			
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
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela Sala do banco de dados
	 * @param idSalaPersonalizada
	 * @return
	 * @author Breno
	 */
	public Sala buscarId(int idSala) {
		Sala sala = new Sala(); 
		
		String sql = "select * from sala where idSala = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idSala);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				sala.setIdSala(resultSet.getInt(1));
				sala.setNome(resultSet.getString(2));
				sala.setDescricao(resultSet.getString(3));
				sala.setSituacaoAcesso(resultSet.getBoolean(4));
				sala.setTipoSala(resultSet.getBoolean(5));
				sala.setLink(resultSet.getString(6));
				comandoSql.close(); 
				return sala;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela Sala do banco de dados 
	 * @return
	 * @author Breno
	 */
	public List<Sala> buscarTodos() {
		
		List<Sala> lista = new ArrayList<Sala>(); 
		
		String sql = "select * from sala"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				Sala sala = new Sala(); 
				sala.setIdSala(resultSet.getInt(1));
				sala.setNome(resultSet.getString(2));
				sala.setDescricao(resultSet.getString(3));
				sala.setSituacaoAcesso(resultSet.getBoolean(4));
				sala.setTipoSala(resultSet.getBoolean(5));
				sala.setLink(resultSet.getString(6));
				lista.add(sala); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
