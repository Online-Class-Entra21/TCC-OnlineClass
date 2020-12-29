package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Administrador;
/**
 * O administrador faz parte da tabela usuário, sendo diferenciado pelo tipoUsuario = 4
 * @see Usuario
 * @author
 */
public class AdministradorDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Realiza o registro de um administrador no banco de dados na tabela Usuario
	 * O usuario cadastrado é definido como administrador a partir do tipoUsuario = 4
	 * @param usuario
	 * @return
	 */
	public boolean insert(Administrador administrador) {
		String sql = "insert into usuario (nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, "
				   + "senha, horaFinalExpediente, horaInicioExpediente, fotoUsuario, fk_endereco, "
				   + "fk_escola) values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, administrador.getNome());
			comandoSql.setString(2, administrador.getSobrenome());
			comandoSql.setString(3, administrador.getCpf());
			comandoSql.setString(4, administrador.getTelefone());
			comandoSql.setString(5, administrador.getCelular());
			comandoSql.setInt(6, 4);
			comandoSql.setString(7, administrador.getEmail());
			comandoSql.setString(8, administrador.getSenha());
			comandoSql.setTime(9, administrador.getHorarioFinalExpediente());
			comandoSql.setTime(10, administrador.getHorarioInicioExpediente());
			comandoSql.setString(11, administrador.getFotoUsuario());
			comandoSql.setInt(12, administrador.getEndereco().getIdEndereco());
			comandoSql.setInt(13, administrador.getEscola().getIdEscola());
			
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
	 * Realiza atualização dos dados do administrador no banco de dados
	 * @param usuario
	 * @return
	 */
	public boolean update(Administrador administrador) {
		
		String sql = "update usuario set nome = ?, sobrenome = ?, cpf = ?, telefone = ?, celular = ?, "
				   + "tipoUsuario = ?, email = ?, senha = ?, horaFinalExpediente = ?, horaInicioExpediente = ?, "
				   + "fotoUsuario = ?, fk_endereco = ?, fk_escola = ? where idUsuario = ? and tipoUsuario = 4";  
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, administrador.getNome());
			comandoSql.setString(2, administrador.getSobrenome());
			comandoSql.setString(3, administrador.getCpf());
			comandoSql.setString(4, administrador.getTelefone());
			comandoSql.setString(5, administrador.getCelular());
			comandoSql.setInt(6, 4);
			comandoSql.setString(7, administrador.getEmail());
			comandoSql.setString(8, administrador.getSenha());
			comandoSql.setTime(9, administrador.getHorarioFinalExpediente());
			comandoSql.setTime(10, administrador.getHorarioInicioExpediente());
			comandoSql.setString(11, administrador.getFotoUsuario());
			comandoSql.setInt(12, administrador.getEndereco().getIdEndereco());
			comandoSql.setInt(13, administrador.getEscola().getIdEscola());
			comandoSql.setInt(14, administrador.getIdUsuario());
			
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
	 * Realiza a exclusão dos dados de uma linha da tabela Usuario
	 * @param idUsuario
	 * @return
	 */
	public boolean delete(int idUsuario) {
		
		String sql = "delete from usuario where idUsuario = ? and tipoUsuario = 4"; 
		
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
	 * Método de busca de todas as informações de uma linha
	 * da tabela Usuario do banco de dados
	 * @param idUsuario
	 * @return
	 */
	public Administrador buscarPorId(int idUsuario) {
		Administrador administrador = new Administrador();
		
		String sql = "select * from usuario where idUsuario = ? and tipoUsuario = 4"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuario);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				administrador.setIdUsuario(resultSet.getInt(1));
				administrador.setNome(resultSet.getString(2));
				administrador.setSobrenome(resultSet.getString(3));
				administrador.setCpf(resultSet.getString(4));
				administrador.setTelefone(resultSet.getString(5));
				administrador.setCelular(resultSet.getString(6));
				administrador.setTipoUsuario(resultSet.getInt(7));
				administrador.setEmail(resultSet.getString(8));
				administrador.setSenha(resultSet.getString(9));
				administrador.setHorarioFinalExpediente(resultSet.getTime(10));
				administrador.setHorarioInicioExpediente(resultSet.getTime(11));
				administrador.setFotoUsuario(resultSet.getString(12));
				
				/**
				 * Realiza a consulta por id para criar o objeto endereco
				 * apartir do fk da endereco
				 */
//				EnderecoDAO enderecoDao = new EnderecoDAO();
//				Endereco endereco = enderecoDao.buscarPorId(resultSet.getString(13));
//				usuario.setEndereco(endereco);
				
				/**
				 * Realiza a consulta por id para criar o objeto escola
				 * apartir do fk da escola
				 */
//				EscolaDAO escolaDAO = new EscolaDAO();
//				Escola escola = escolaDAO.buscarPorId(resultSet.getString(14));
//				usuario.setEscola(escola);
				
				comandoSql.close(); 
				return administrador;
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
	 */
	public List<Administrador> buscarTodos() {
		
		List<Administrador> lista = new ArrayList<Administrador>(); 
		
		String sql = "select * from usuario where tipoUsuario = 4"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				Administrador administrador = new Administrador();
				administrador.setIdUsuario(resultSet.getInt(1));
				administrador.setNome(resultSet.getString(2));
				administrador.setSobrenome(resultSet.getString(3));
				administrador.setCpf(resultSet.getString(4));
				administrador.setTelefone(resultSet.getString(5));
				administrador.setCelular(resultSet.getString(6));
				administrador.setTipoUsuario(resultSet.getInt(7));
				administrador.setEmail(resultSet.getString(8));
				administrador.setSenha(resultSet.getString(9));
				administrador.setHorarioFinalExpediente(resultSet.getTime(10));
				administrador.setHorarioInicioExpediente(resultSet.getTime(11));
				administrador.setFotoUsuario(resultSet.getString(12));
				
				/**
				 * Realiza a consulta por id para criar o objeto endereco
				 * apartir do fk da endereco
				 */
//				EnderecoDAO enderecoDao = new EnderecoDAO();
//				Endereco endereco = enderecoDao.buscarPorId(resultSet.getString(13));
//				usuario.setEndereco(endereco);
				
				/**
				 * Realiza a consulta por id para criar o objeto escola
				 * apartir do fk da escola
				 */
//				EscolaDAO escolaDAO = new EscolaDAO();
//				Escola escola = escolaDAO.buscarPorId(resultSet.getString(14));
//				usuario.setEscola(escola);
				lista.add(administrador); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
