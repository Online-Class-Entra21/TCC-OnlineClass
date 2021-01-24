package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.ArquivoUsuario;

/**
 * Metodo para consulta do arquivoUsuario no banco de dados
 * @author Andre
 *
 */
public class ArquivoUsuarioDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de um arquivoUsuario no banco de dados
	 * @param ArquivoUsuario arquivoUsuario
	 * @author Andre
	 * @throws SQLException 
	 */
	public void insert(ArquivoUsuario arquivoUsuario) throws SQLException { 
		String sql = "insert into arquivo_Usuario (fk_Arquivo, fk_Usuario, tipoEnvio) values (?,?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
	     
		comandoSql.setInt(1, arquivoUsuario.getFk_arquivo());
		comandoSql.setInt(2, arquivoUsuario.getFk_usuario());
		comandoSql.setInt(3, arquivoUsuario.getTipoEnvio());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza atualizacao dos dados da arquivoUsuario no banco de dados.
	 * O <code>idArquivoUsuario</code> deve ser igual ao do arquivoUsuario que deseja atualizar
	 * @param ArquivoUsuario arquivoUsuario
	 * @author Andre
	 * @throws SQLException 
	 */
	public void update(ArquivoUsuario arquivoUsuario) throws SQLException {
		String sql = "Update arquivo_Usuario set tipoEnvio = ? where id_arquivo_Usuario = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
	    
		comandoSql.setInt(1, arquivoUsuario.getTipoEnvio());
		comandoSql.setInt(2, arquivoUsuario.getIdArquivoUsuario());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza a exclusao dos dados de uma linha da tabela arquivoUsuario.
	 * O <code>idArquivoUsuario</code> deve ser igual ao do arquivoUsuario que deseja deletar
	 * @param idUsuarioArquivo
	 * @author Andre
	 * @throws SQLException 
	 */
	public void deleteId(int idArquivoUsuario) throws SQLException {
		String sql = "delete from arquivo_Usuario where id_Arquivo_Usuario = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idArquivoUsuario);
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Metodo para buscar arquivoUsuario no banco de dados.  
	 * O <code>idArquivoUsuario</code> deve ser igual ao do arquivoUsuario que deseja deletar
	 * @param int idUsuarioArquivo
	 * @return ArquivoUsuario arquivoUsuario
	 * @author Andre
	 * @throws SQLException 
	 */
	public ArquivoUsuario buscarId(int idUsuarioArquivo) throws SQLException {
		ArquivoUsuario usuarioArquivo = new ArquivoUsuario(); 
		String sql = "select * from arquivo_usuario where idUsuarioArquivo = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idUsuarioArquivo);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			usuarioArquivo.setIdArquivoUsuario(resultSet.getInt(1));
			usuarioArquivo.setFk_arquivo(resultSet.getInt(2));
			usuarioArquivo.setFk_usuario(resultSet.getInt(3));
			usuarioArquivo.setTipoEnvio(resultSet.getInt(4));
		}
		comandoSql.close(); 
		return usuarioArquivo;
	}
	
	/**
	 * Retorna todos os dados listados da tabela arquivoUsuario do banco de dados 
	 * @return lista de arquivosUsuarios resgistrados no banco
	 * @author Andre
	 * @throws SQLException 
	 */
	public List<ArquivoUsuario> buscarTodos() throws SQLException {
		ArquivoUsuario arquivoUsuario = new ArquivoUsuario(); 
		List<ArquivoUsuario> lista = new ArrayList<ArquivoUsuario>(); 
		String sql = "select * from arquivo_usuario"; 

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		 
		while (resultSet.next()) {
			arquivoUsuario.setIdArquivoUsuario(resultSet.getInt(1));
			arquivoUsuario.setFk_arquivo(resultSet.getInt(2));
			arquivoUsuario.setFk_usuario(resultSet.getInt(3));
			arquivoUsuario.setTipoEnvio(resultSet.getInt(4));
			
			lista.add(arquivoUsuario); 
		}
		comandoSql.close();
		return lista;
	}
}
