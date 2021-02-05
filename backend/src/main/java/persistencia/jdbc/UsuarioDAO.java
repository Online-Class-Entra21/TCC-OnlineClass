package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Usuario;

/**
 * Metodo para consulta do usuario no banco de dados 
 * @author Breno
 *
 */
public class UsuarioDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de um usuario no banco de dados
	 * @param Usuario usuario
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(Usuario usuario) throws SQLException {
		String sql = "insert into usuario (nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, "
				   + "senha, horaFinalExpediente, horaInicioExpediente, fotoUsuario, fk_endereco, "
				   + "fk_escola) values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
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
	}

	/**
	 * Realiza atualizacao dos dados da usuario no banco de dados.
	 * O <code>idUsuario</code> deve ser igual ao da usuario que deseja atualizar
	 * @param Usuario usuario
	 * @author Breno
	 * @throws SQLException 
	 */
	public void update(Usuario usuario) throws SQLException {
		String sql = "update usuario set nome = ?, sobrenome = ?, cpf = ?, telefone = ?, celular = ?, "
				+ "tipoUsuario = ?, email = ?, senha = ?, horaFinalExpediente = ?, horaInicioExpediente = ?, "
				+ "fotoUsuario = ?, fk_endereco = ?, fk_escola = ? where idUsuario = ?";
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
	}
	
	/**
	 * Realiza a exclusao dos dados de uma linha da tabela usuario.
	 * O <code>idUsuario</code> deve ser igual ao da usuario que deseja deletar
	 * @param int idUsuario
	 * @author Breno
	 * @throws SQLException 
	 */
	public void deleteId(int idUsuario) throws SQLException {
		String sql = "delete from usuario where idUsuario = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idUsuario);
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela Usuario do banco de dados.
	 * O <code>idUsuario</code> deve ser igual ao da usuario que deseja buscar
	 * @param idUsuario
	 * @return Usuario usuario 
	 * @author Breno
	 * @throws SQLException 
	 */
	public Usuario buscarId(int idUsuario) throws SQLException {
		Usuario usuario = new Usuario(); 
		String sql = "select * from usuario where idUsuario = ?"; 
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
		}
		comandoSql.close(); 
		return usuario;
	}
	
	/**
	 * Retorna todos os dados listados da tabela Usuario do banco de dados 
	 * @return lista de usuarios registrados no banco 
	 * @author Breno
	 * @throws SQLException 
	 */
	public List<Usuario> buscarTodos() throws SQLException {
		List<Usuario> lista = new ArrayList<Usuario>(); 
		String sql = "select * from usuario"; 
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
			
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
		comandoSql.close(); 
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela Usuario do banco de dados através do email
	 * @param String email
	 * @return Usuario usuario
	 * @author Breno
	 * @throws SQLException 
	 */
	public Usuario buscarEmail(String email) throws SQLException {
		Usuario usuario = new Usuario(); 
		String sql = "select * from usuario where email = ?"; 
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
		}
		comandoSql.close(); 
		return usuario;
	}
	
	/**
	 * Realiza o registro de um usuario no banco de dados com campos limitados
	 * @param Usuario usuario
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void insertDiretor(Usuario usuario) throws SQLException {
		String sql = "insert into usuario (nome, sobrenome, telefone, celular, tipoUsuario, email, "
				   + "senha, fk_escola) values (?,?,?,?,?,?,?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
		comandoSql.setString(1, usuario.getNome());
		comandoSql.setString(2, usuario.getSobrenome());
		//comandoSql.setString(3, usuario.getCpf());
		comandoSql.setString(3, usuario.getTelefone());
		comandoSql.setString(4, usuario.getCelular());
		comandoSql.setInt(5, usuario.getTipoUsuario());
		comandoSql.setString(6, usuario.getEmail());
		comandoSql.setString(7, usuario.getSenha());
		//comandoSql.setTime(9, usuario.getHorarioFinalExpediente());
		//comandoSql.setTime(10, usuario.getHorarioInicioExpediente());
		//comandoSql.setString(11, usuario.getFotoUsuario());
		//comandoSql.setInt(9, usuario.getFk_endereco());
		comandoSql.setInt(8, usuario.getFk_escola());

		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Realiza atualizacao da foto do usuario no banco de dados.
	 * O <code>idUsuario</code> deve ser igual ao da usuario que deseja atualizar
	 * @param caminhoArquivo
	 * @param idUsuario
	 * @author André
	 * @throws SQLException 
	 */
	public void updateFoto(String caminho, int idUsuario) throws SQLException {
		String sql = "update usuario set fotoUsuario = ? where idUsuario = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);

		comandoSql.setString(1, caminho);
		comandoSql.setInt(2, idUsuario);
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
}
