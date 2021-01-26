package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.UsuarioSalaPersonalizada;

/**
 * Metodo para consulta do usuarioSalaPersonalizadaDAO no banco de dados 
 * @author Breno
 *
 */
public class UsuarioSalaPersonalizadaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de um usuarioSalaPersonalizadaDAO no banco de dados
	 * @param UsuarioSalaPersonalizada usuarioSalaPersonalizada
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(UsuarioSalaPersonalizada usuarioSalaPersonalizada) throws SQLException {
		String sql = "insert into usuario_SalaPersonalizada (fk_Usuario, fk_SalaPersonalizada) values (?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
	     
		comandoSql.setInt(1, usuarioSalaPersonalizada.getFk_usuario());
		comandoSql.setInt(2, usuarioSalaPersonalizada.getFk_salaPersonalizada());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Metodo para atualizar um usuarioSalaPersonalizada no banco de dados.
	 * O <code>idUsuarioSalaPersonalizada</code> deve ser igual ao do usuarioSalaPersonalizada que deseja atualizar
	 * @param UsuarioSalaPersonalizada usuarioSalaPersonalizada 
	 * @author Breno
	 * @throws SQLException 
	 */ 
	public void update(UsuarioSalaPersonalizada usuarioSalaPersonalizada) throws SQLException {
		String sql = "update usuario_Sala_Personalizada set fk_usuario = ?, fk_salaPersonalizada = ? where id_usuario_Sala_Personalizada = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, usuarioSalaPersonalizada.getFk_usuario());
		comandoSql.setInt(2, usuarioSalaPersonalizada.getFk_salaPersonalizada());
		comandoSql.setInt(2, usuarioSalaPersonalizada.getIdUsuarioSalaPersonalizada());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Realiza a exclusao dos dados de uma linha da tabela usuarioSalaPersonalizada.
	 * O <code>idUsuarioSalaPersonalizada</code> deve ser igual ao do usuarioSalaPersonalizada que deseja deletar
	 * @param int idUsuarioSalaPersonalizada
	 * @author Breno
	 * @throws SQLException 
	 */
	public void deleteId(int idUsuarioSalaPersonalizada) throws SQLException {
		String sql = "delete from usuario_SalaPersonalizada where id_Usuario_SalaPersonalizada = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idUsuarioSalaPersonalizada);
		
		comandoSql.execute(); 
		comandoSql.close();
	}
	
	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela UsuarioSalaPersonalizada do banco de dados.
	 * O <code>idUsuarioSalaPersonalizada</code> deve ser igual ao do usuarioSalaPersonalizada que deseja buscar
	 * @param int idUsuarioSalaPersonalizada
	 * @return UsuarioSalaPersonalizada usuarioSalaPersonalizada
	 * @author Breno
	 * @throws SQLException 
	 */
	public UsuarioSalaPersonalizada buscarId(int idUsuarioSalaPersonalizada) throws SQLException {
		UsuarioSalaPersonalizada usuarioSalaPersonalizada = new UsuarioSalaPersonalizada(); 
		String sql = "select * from usuario_SalaPersonalizada where id_Usuario_SalaPersonalizada = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idUsuarioSalaPersonalizada);
		ResultSet resultSet = comandoSql.executeQuery();
			
		if (resultSet.next()) {
			usuarioSalaPersonalizada.setIdUsuarioSalaPersonalizada(resultSet.getInt(1));
			usuarioSalaPersonalizada.setFk_usuario(resultSet.getInt(2));
			usuarioSalaPersonalizada.setFk_salaPersonalizada(resultSet.getInt(3));
		}
		comandoSql.close(); 
		return usuarioSalaPersonalizada;
	}
	
	/**
	 * Retorna todos os dados listados da tabela UsuarioSalaPersonalizada do banco de dado
	 * @return lista de usuariosSalasPersonalizadas registrados no banco
	 * @author Breno
	 * @throws SQLException 
	 */
	public List<UsuarioSalaPersonalizada> buscarTodos() throws SQLException {
		List<UsuarioSalaPersonalizada> lista = new ArrayList<UsuarioSalaPersonalizada>(); 
		String sql = "select * from sala"; 
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
			
		while (resultSet.next()) {
			UsuarioSalaPersonalizada usuarioSalaPersonalizada = new UsuarioSalaPersonalizada();
			usuarioSalaPersonalizada.setIdUsuarioSalaPersonalizada(resultSet.getInt(1));
			usuarioSalaPersonalizada.setFk_usuario(resultSet.getInt(2));
			usuarioSalaPersonalizada.setFk_salaPersonalizada(resultSet.getInt(3));
			lista.add(usuarioSalaPersonalizada); 
		}
		comandoSql.close(); 
		return lista;
	}	
}
