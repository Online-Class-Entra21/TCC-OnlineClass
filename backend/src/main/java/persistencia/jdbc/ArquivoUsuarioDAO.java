package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.ArquivoUsuario;

public class ArquivoUsuarioDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma UsuarioArquivo no banco de dados
	 * @param usuarioArquivo
	 * @return
	 * @author Breno
	 */
	public boolean insert(ArquivoUsuario usuarioArquivo) {
		
		String sql = "insert into arquivo_Usuario (fk_Arquivo, fk_Usuario, tipoEnvio) values (?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, usuarioArquivo.getFk_arquivo());
			comandoSql.setInt(2, usuarioArquivo.getFk_usuario());
			comandoSql.setInt(3, usuarioArquivo.getTipoEnvio());
			
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
	 * Realiza atualizacao dos dados da UsuarioArquivo no banco de dados
	 * @param usuarioArquivo
	 * @return
	 * @author Breno
	 */
	public boolean update(ArquivoUsuario usuarioArquivo) {
		
		String sql = "Update arquivo_Usuario set tipoEnvio = ? where id_arquivo_Usuario = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		    
			comandoSql.setInt(1, usuarioArquivo.getTipoEnvio());
			comandoSql.setInt(2, usuarioArquivo.getIdArquivoUsuario());
			
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
	 * Realiza a exclusao dos dados de uma linha da tabela UsuarioArquivo
	 * @param idUsuarioArquivo
	 * @return
	 * @author Breno
	 */
	public boolean deleteId(int idUsuarioArquivo) {
		
		String sql = "delete from arquivo_Usuario where id_Arquivo_Usuario = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuarioArquivo);
			
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
	 * da tabela UsuarioArquivo do banco de dados
	 * @param idUsuarioArquivo
	 * @return
	 * @author Breno
	 */
	public ArquivoUsuario buscarId(int idUsuarioArquivo) {
		ArquivoUsuario usuarioArquivo = new ArquivoUsuario(); 
		
		String sql = "select * from arquivo_usuario where idUsuarioArquivo = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuarioArquivo);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				usuarioArquivo.setIdArquivoUsuario(resultSet.getInt(1));
				usuarioArquivo.setFk_arquivo(resultSet.getInt(2));
				usuarioArquivo.setFk_usuario(resultSet.getInt(3));
				
				usuarioArquivo.setTipoEnvio(resultSet.getInt(4));
				
				comandoSql.close(); 
				return usuarioArquivo;
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
	public List<ArquivoUsuario> buscarTodos() {
		
		List<ArquivoUsuario> lista = new ArrayList<ArquivoUsuario>(); 
		
		String sql = "select * from arquivo_usuario"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				ArquivoUsuario usuarioArquivo = new ArquivoUsuario(); 
				
				usuarioArquivo.setIdArquivoUsuario(resultSet.getInt(1));
				usuarioArquivo.setFk_arquivo(resultSet.getInt(2));
				usuarioArquivo.setFk_usuario(resultSet.getInt(3));
				
				usuarioArquivo.setTipoEnvio(resultSet.getInt(4));
				
				lista.add(usuarioArquivo); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
