package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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
		comandoSql.setTimestamp(9, (Timestamp) usuario.getHorarioFinalExpediente());
		comandoSql.setTimestamp(10, (Timestamp) usuario.getHorarioInicioExpediente());
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
		comandoSql.setTimestamp(9, usuario.getHorarioFinalExpediente());
		comandoSql.setTimestamp(10, usuario.getHorarioInicioExpediente());
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
			usuario.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			usuario.setHorarioInicioExpediente(resultSet.getTimestamp(11));
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
			usuario.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			usuario.setHorarioInicioExpediente(resultSet.getTimestamp(11));
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
			usuario.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			usuario.setHorarioInicioExpediente(resultSet.getTimestamp(11));
			usuario.setFotoUsuario(resultSet.getString(12));
			usuario.setFk_endereco(resultSet.getInt(13));
			usuario.setFk_escola(resultSet.getInt(14));
		}
		comandoSql.close(); 
		return usuario;
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

	/**
	 * Retorna todos os dados listados da tabela Usuario do banco de dados onde a escola é igual a informada 
	 * @return lista de usuarios registrados no banco onde a escola é igual a informada 
	 * @param innt idEscola 
	 * @author Breno
	 * @throws SQLException 
	 */
	public List<Usuario> buscarTodosEscola(int idEscola) throws SQLException {
		List<Usuario> lista = new ArrayList<Usuario>(); 
		String sql = "select * from usuario where fk_escola = ?"; 
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, idEscola);
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
			usuario.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			usuario.setHorarioInicioExpediente(resultSet.getTimestamp(11));
			usuario.setFotoUsuario(resultSet.getString(12));
			usuario.setFk_endereco(resultSet.getInt(13));
			usuario.setFk_escola(resultSet.getInt(14));
			
			lista.add(usuario); 
		}
		comandoSql.close(); 
		return lista;
	}

	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela Usuario do banco de dados através do cpf
	 * @param String cpf
	 * @return Usuario usuario
	 * @author Breno
	 * @throws SQLException 
	 */
	public Usuario buscarCpf(String cpf) throws SQLException {
		Usuario usuario = new Usuario(); 
		String sql = "select * from usuario where cpf = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setString(1, cpf);
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
			usuario.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			usuario.setHorarioInicioExpediente(resultSet.getTimestamp(11));
			usuario.setFotoUsuario(resultSet.getString(12));
			usuario.setFk_endereco(resultSet.getInt(13));
			usuario.setFk_escola(resultSet.getInt(14));
		}
		comandoSql.close(); 
		return usuario;
	}
	
	/**
	 * Realiza o registro de um usuario no banco de dados
	 * e retorna o id registrado no banco de dados
	 * @param Usuario usuario
	 * @return int idUsuario
	 * @author Andrey
	 * @throws SQLException 
	 */
	public int insertReturnID(Usuario usuario) throws SQLException {
		String sql = "insert into usuario (nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, "
				   + "senha, horaFinalExpediente, horaInicioExpediente, fotoUsuario, fk_endereco, "
				   + "fk_escola) values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		     
		comandoSql.setString(1, usuario.getNome());
		comandoSql.setString(2, usuario.getSobrenome());
		comandoSql.setString(3, usuario.getCpf());
		comandoSql.setString(4, usuario.getTelefone());
		comandoSql.setString(5, usuario.getCelular());
		comandoSql.setInt(6, usuario.getTipoUsuario());
		comandoSql.setString(7, usuario.getEmail());
		comandoSql.setString(8, usuario.getSenha());
		comandoSql.setTimestamp(9, (Timestamp) usuario.getHorarioFinalExpediente());
		comandoSql.setTimestamp(10, (Timestamp) usuario.getHorarioInicioExpediente());
		comandoSql.setString(11, usuario.getFotoUsuario());
		comandoSql.setInt(12, usuario.getFk_endereco());
		comandoSql.setInt(13, usuario.getFk_escola());

		comandoSql.execute();
		ResultSet rs = comandoSql.getGeneratedKeys();
        rs.next();
        int idUsuario = rs.getInt(1);
		comandoSql.close(); 

		return idUsuario;
	}
	
	/**
	 * Realiza atualizacao dos dados da usuario no banco de dados.
	 * O <code>idUsuario</code> deve ser igual ao da usuario que deseja atualizar
	 * @param Usuario usuario
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void updateUsuarioAluno(Usuario usuario) throws SQLException {
		String sql = "update usuario set nome = ?, sobrenome = ?, cpf = ?, telefone = ?, celular = ?, email = ?, senha = ? where idUsuario = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);

		comandoSql.setString(1, usuario.getNome());
		comandoSql.setString(2, usuario.getSobrenome());
		comandoSql.setString(3, usuario.getCpf());
		comandoSql.setString(4, usuario.getTelefone());
		comandoSql.setString(5, usuario.getCelular());
		comandoSql.setString(6, usuario.getEmail());
		comandoSql.setString(7, usuario.getSenha());
		comandoSql.setInt(8, usuario.getIdUsuario());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza atualizacao da senha do usuario no banco de dados.
	 * O <code>idUsuario</code> deve ser igual ao da usuario que deseja atualizar
	 * @param Usuario usuario
	 * @author André
	 * @throws SQLException 
	 */
	public void updateSenha(Usuario usuario) throws SQLException {
		String sql = "update usuario set senha = ? where idUsuario = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);

		comandoSql.setString(1, usuario.getSenha());
		comandoSql.setInt(2, usuario.getIdUsuario());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
}
