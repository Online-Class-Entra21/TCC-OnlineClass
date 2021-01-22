package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.UsuarioSalaPersonalizada;

public class UsuarioSalaPersonalizadaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma UsuarioSalaPersonalizadaDAO no banco de dados
	 * @param usuarioSalaPersonalizada
	 * @return
	 * @author Breno
	 */
	public boolean insert(UsuarioSalaPersonalizada usuarioSalaPersonalizada) {
		
		String sql = "insert into usuario_SalaPersonalizada (fk_Usuario, fk_SalaPersonalizada) values (?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, usuarioSalaPersonalizada.getFk_usuario());
			comandoSql.setInt(2, usuarioSalaPersonalizada.getFk_salaPersonalizada());
			
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
	 * Realiza a exclusao dos dados de uma linha da tabela UsuarioSalaPersonalizada
	 * @param idUsuarioSalaPersonalizada
	 * @return
	 * @author Breno
	 */
	public boolean deleteId(int idUsuarioSalaPersonalizada) {
		
		String sql = "delete from usuario_SalaPersonalizada where id_Usuario_SalaPersonalizada = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuarioSalaPersonalizada);
			
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
	 * da tabela UsuarioSalaPersonalizada do banco de dados
	 * @param idUsuarioSalaPersonalizada
	 * @return
	 * @author Breno
	 */
	public UsuarioSalaPersonalizada buscarId(int idUsuarioSalaPersonalizada) {
		UsuarioSalaPersonalizada usuarioSalaPersonalizada = new UsuarioSalaPersonalizada(); 
		
		String sql = "select * from usuario_SalaPersonalizada where id_Usuario_SalaPersonalizada = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuarioSalaPersonalizada);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				
				usuarioSalaPersonalizada.setIdUsuarioSalaPersonalizada(resultSet.getInt(1));
				usuarioSalaPersonalizada.setFk_usuario(resultSet.getInt(2));
				usuarioSalaPersonalizada.setFk_salaPersonalizada(resultSet.getInt(3));
				
				comandoSql.close(); 
				return usuarioSalaPersonalizada;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela UsuarioSalaPersonalizada do banco de dados 
	 * @return
	 * @author Breno
	 */
	public List<UsuarioSalaPersonalizada> buscarTodos() {
		
		List<UsuarioSalaPersonalizada> lista = new ArrayList<UsuarioSalaPersonalizada>(); 
		
		String sql = "select * from sala"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				UsuarioSalaPersonalizada usuarioSalaPersonalizada = new UsuarioSalaPersonalizada();
				
				usuarioSalaPersonalizada.setIdUsuarioSalaPersonalizada(resultSet.getInt(1));
				usuarioSalaPersonalizada.setFk_usuario(resultSet.getInt(2));
				usuarioSalaPersonalizada.setFk_salaPersonalizada(resultSet.getInt(3));
				lista.add(usuarioSalaPersonalizada); 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
