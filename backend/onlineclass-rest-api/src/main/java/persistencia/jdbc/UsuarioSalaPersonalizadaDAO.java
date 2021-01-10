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
	 */
	public boolean insert(UsuarioSalaPersonalizada usuarioSalaPersonalizada) {
		
		String sql = "insert into usuario_SalaPersonalizada (fk_Usuario, fk_SalaPersonalizada) values (?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, usuarioSalaPersonalizada.getUsuario().getIdUsuario());
			comandoSql.setInt(2, usuarioSalaPersonalizada.getSalaPersonalizada().getIdSalaPersonalizada());
			
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
	 * Realiza a exclusão dos dados de uma linha da tabela UsuarioSalaPersonalizada
	 * @param idUsuarioSalaPersonalizada
	 * @return
	 */
	public boolean delete(int idUsuarioSalaPersonalizada) {
		
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
	 * Método de busca de todas as informações de uma linha
	 * da tabela UsuarioSalaPersonalizada do banco de dados
	 * @param idUsuarioSalaPersonalizada
	 * @return
	 */
	public UsuarioSalaPersonalizada buscarPorId(int idUsuarioSalaPersonalizada) {
		UsuarioSalaPersonalizada usuarioSalaPersonalizada = new UsuarioSalaPersonalizada(); 
		
		String sql = "select * from usuario_SalaPersonalizada where id_Usuario_SalaPersonalizada = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuarioSalaPersonalizada);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				
				usuarioSalaPersonalizada.setIdUsuarioSalaPersonalizada(resultSet.getInt(1));
				
				/**
				 * Realiza a consulta por id para criar o objeto usuario
				 * apartir do fk da usuario
				 */
//				UsuarioDAO usuarioDao = new UsuarioDAO();
//				Usuario usuario = usuarioDao.buscarPorId((resultSet.getInt(2)));
//				usuarioSalaPersonalizada.setUsuario(usuario);
				
				/**
				 * Realiza a consulta por id para criar o objeto salaPersonalizada
				 * apartir do fk da salaPersonalizada
				 */
//				SalaPersonalizadaDAO salaPersonalizadaDao = new SalaPersonalizadaDAO();
//				SalaPersonalizada salaPersonalizada = salaPersonalizadaDao.buscarPorId((resultSet.getInt(3)));
//				usuarioSalaPersonalizada.setSalaPersonalizada(salaPersonalizada);
				
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
				
				/**
				 * Realiza a consulta por id para criar o objeto usuario
				 * apartir do fk da usuario
				 */
//				UsuarioDAO usuarioDao = new UsuarioDAO();
//				Usuario usuario = usuarioDao.buscarPorId((resultSet.getInt(2)));
//				usuarioSalaPersonalizada.setUsuario(usuario);
				
				/**
				 * Realiza a consulta por id para criar o objeto salaPersonalizada
				 * apartir do fk da salaPersonalizada
				 */
//				SalaPersonalizadaDAO salaPersonalizadaDao = new SalaPersonalizadaDAO();
//				SalaPersonalizada salaPersonalizada = salaPersonalizadaDao.buscarPorId((resultSet.getInt(3)));
//				usuarioSalaPersonalizada.setSalaPersonalizada(salaPersonalizada);
				lista.add(usuarioSalaPersonalizada); 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
