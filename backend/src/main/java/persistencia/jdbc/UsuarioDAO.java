package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Usuario;

public class UsuarioDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma Usuario no banco de dados
	 * @param usuario
	 * @return
	 * @author Breno
	 */
	public boolean insert(Usuario usuario) {
		
		String sql = "insert into usuario (nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, "
				   + "senha, horaFinalExpediente, horaInicioExpediente, fotoUsuario, fk_endereco, "
				   + "fk_escola) values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setString(1, usuario.getNome());
			comandoSql.setString(2, usuario.getSobrenome());
			comandoSql.setString(3, usuario.getCpf());
			comandoSql.setString(4, usuario.getTelefone());
			comandoSql.setString(5, usuario.getCelular());
			comandoSql.setInt(6, usuario.getTipoUsuario());
			comandoSql.setString(7, usuario.getEmail());
			comandoSql.setString(8, usuario.getSenha());
			comandoSql.setTime(9, usuario.getHorarioFinalExpediente());
			comandoSql.setTime(10, usuario.getHorarioInicioExpediente());
			comandoSql.setString(11, usuario.getFotoUsuario());
			comandoSql.setInt(12, usuario.getFk_endereco());
			comandoSql.setInt(13, usuario.getFk_escola());

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
	 * Realiza atualizacao dos dados da Usuario no banco de dados
	 * 
	 * @param usuario
	 * @return
	 * @author Breno
	 */
	public boolean update(Usuario usuario) {

		String sql = "update usuario set nome = ?, sobrenome = ?, cpf = ?, telefone = ?, celular = ?, "
				+ "tipoUsuario = ?, email = ?, senha = ?, horaFinalExpediente = ?, horaInicioExpediente = ?, "
				+ "fotoUsuario = ?, fk_endereco = ?, fk_escola = ? where idUsuario = ?";

		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);

			comandoSql.setString(1, usuario.getNome());
			comandoSql.setString(2, usuario.getSobrenome());
			comandoSql.setString(3, usuario.getCpf());
			comandoSql.setString(4, usuario.getTelefone());
			comandoSql.setString(5, usuario.getCelular());
			comandoSql.setInt(6, usuario.getTipoUsuario());
			comandoSql.setString(7, usuario.getEmail());
			comandoSql.setString(8, usuario.getSenha());
			comandoSql.setTime(9, usuario.getHorarioFinalExpediente());
			comandoSql.setTime(10, usuario.getHorarioInicioExpediente());
			comandoSql.setString(11, usuario.getFotoUsuario());
			comandoSql.setInt(12, usuario.getFk_endereco());
			comandoSql.setInt(13, usuario.getFk_escola());
			comandoSql.setInt(14, usuario.getIdUsuario());
			
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
	 * Realiza a exclus�o dos dados de uma linha da tabela Usuario
	 * @param idUsuario
	 * @return
	 */
	public boolean deleteId(int idUsuario) {
		
		String sql = "delete from usuario where idUsuario = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuario);
			
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
	 * da tabela Usuario do banco de dados
	 * @param idUsuario
	 * @return
	 * @author Breno
	 */
	public Usuario buscarId(int idUsuario) {
		Usuario usuario = new Usuario(); 
		
		String sql = "select * from usuario where idUsuario = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuario);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				usuario.setIdUsuario(resultSet.getInt(1));
				usuario.setNome(resultSet.getString(2));
				usuario.setSobrenome(resultSet.getString(3));
				usuario.setCpf(resultSet.getString(4));
				usuario.setTelefone(resultSet.getString(5));
				usuario.setCelular(resultSet.getString(6));
				usuario.setTipoUsuario(resultSet.getInt(7));
				usuario.setEmail(resultSet.getString(8));
				usuario.setSenha(resultSet.getString(9));
				usuario.setHorarioFinalExpediente(resultSet.getTime(10));
				usuario.setHorarioInicioExpediente(resultSet.getTime(11));
				usuario.setFotoUsuario(resultSet.getString(12));
				usuario.setFk_endereco(resultSet.getInt(13));
				usuario.setFk_escola(resultSet.getInt(14));
				
				comandoSql.close(); 
				return usuario;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela Usuario do banco de dados 
	 * @return
	 * @author Breno
	 */
	public List<Usuario> buscarTodos() {
		
		List<Usuario> lista = new ArrayList<Usuario>(); 
		
		String sql = "select * from usuario"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				Usuario usuario = new Usuario(); 
				usuario.setIdUsuario(resultSet.getInt(1));
				usuario.setNome(resultSet.getString(2));
				usuario.setSobrenome(resultSet.getString(3));
				usuario.setCpf(resultSet.getString(4));
				usuario.setTelefone(resultSet.getString(5));
				usuario.setCelular(resultSet.getString(6));
				usuario.setTipoUsuario(resultSet.getInt(7));
				usuario.setEmail(resultSet.getString(8));
				usuario.setSenha(resultSet.getString(9));
				usuario.setHorarioFinalExpediente(resultSet.getTime(10));
				usuario.setHorarioInicioExpediente(resultSet.getTime(11));
				usuario.setFotoUsuario(resultSet.getString(12));
				usuario.setFk_endereco(resultSet.getInt(13));
				usuario.setFk_escola(resultSet.getInt(14));
				
				lista.add(usuario); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
	
	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela Usuario do banco de dados através do email
	 * @param email
	 * @return
	 * @author Breno
	 */
	public Usuario buscarEmail(String email) {
		Usuario usuario = new Usuario(); 
		
		String sql = "select * from usuario where email = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setString(1, email);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				usuario.setIdUsuario(resultSet.getInt(1));
				usuario.setNome(resultSet.getString(2));
				usuario.setSobrenome(resultSet.getString(3));
				usuario.setCpf(resultSet.getString(4));
				usuario.setTelefone(resultSet.getString(5));
				usuario.setCelular(resultSet.getString(6));
				usuario.setTipoUsuario(resultSet.getInt(7));
				usuario.setEmail(resultSet.getString(8));
				usuario.setSenha(resultSet.getString(9));
				usuario.setHorarioFinalExpediente(resultSet.getTime(10));
				usuario.setHorarioInicioExpediente(resultSet.getTime(11));
				usuario.setFotoUsuario(resultSet.getString(12));
				usuario.setFk_endereco(resultSet.getInt(13));
				usuario.setFk_escola(resultSet.getInt(14));
				
				comandoSql.close(); 
				return usuario;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
}
