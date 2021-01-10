package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Diretor;
import entidade.Usuario;

public class DiretorDAO {
private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de um administrador no banco de dados na tabela Usuario
	 * O usuario cadastrado é definido como administrador a partir do tipoUsuario = 4
	 * @param usuario
	 * @return
	 */
	public boolean insert(Diretor diretor) {
		String sql = "insert into usuario (nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, "
				   + "senha, horaFinalExpediente, horaInicioExpediente, fotoUsuario, fk_endereco, "
				   + "fk_escola) values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, diretor.getNome());
			comandoSql.setString(2, diretor.getSobrenome());
			comandoSql.setString(3, diretor.getCpf());
			comandoSql.setString(4, diretor.getTelefone());
			comandoSql.setString(5, diretor.getCelular());
			comandoSql.setInt(6, 3);
			comandoSql.setString(7, diretor.getEmail());
			comandoSql.setString(8, diretor.getSenha());
			comandoSql.setTime(9, diretor.getHorarioFinalExpediente());
			comandoSql.setTime(10, diretor.getHorarioInicioExpediente());
			comandoSql.setString(11, diretor.getFotoUsuario());
			comandoSql.setInt(12, diretor.getEndereco().getIdEndereco());
			comandoSql.setInt(13, diretor.getEscola().getIdEscola());
			
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
	public boolean update(Diretor diretor) {
		
		String sql = "update usuario set nome = ?, sobrenome = ?, cpf = ?, telefone = ?, celular = ?, "
				   + "tipoUsuario = ?, email = ?, senha = ?, horaFinalExpediente = ?, horaInicioExpediente = ?, "
				   + "fotoUsuario = ?, fk_endereco = ?, fk_escola = ? where idUsuario = ? and tipoUsuario = 3";  
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, diretor.getNome());
			comandoSql.setString(2, diretor.getSobrenome());
			comandoSql.setString(3, diretor.getCpf());
			comandoSql.setString(4, diretor.getTelefone());
			comandoSql.setString(5, diretor.getCelular());
			comandoSql.setInt(6, 3);
			comandoSql.setString(7, diretor.getEmail());
			comandoSql.setString(8, diretor.getSenha());
			comandoSql.setTime(9, diretor.getHorarioFinalExpediente());
			comandoSql.setTime(10, diretor.getHorarioInicioExpediente());
			comandoSql.setString(11, diretor.getFotoUsuario());
			comandoSql.setInt(12, diretor.getEndereco().getIdEndereco());
			comandoSql.setInt(13, diretor.getEscola().getIdEscola());
			comandoSql.setInt(14, diretor.getIdUsuario());
			
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
		
		String sql = "delete from usuario where idUsuario = ? and tipoUsuario = 3"; 
		
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
	public Diretor buscarPorId(int idUsuario) {
		Diretor diretor = new Diretor();
		
		String sql = "select * from usuario where idUsuario = ? and tipoUsuario = 3"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idUsuario);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				diretor.setIdUsuario(resultSet.getInt(1));
				diretor.setNome(resultSet.getString(2));
				diretor.setSobrenome(resultSet.getString(3));
				diretor.setCpf(resultSet.getString(4));
				diretor.setTelefone(resultSet.getString(5));
				diretor.setCelular(resultSet.getString(6));
				diretor.setTipoUsuario(resultSet.getInt(7));
				diretor.setEmail(resultSet.getString(8));
				diretor.setSenha(resultSet.getString(9));
				diretor.setHorarioFinalExpediente(resultSet.getTime(10));
				diretor.setHorarioInicioExpediente(resultSet.getTime(11));
				diretor.setFotoUsuario(resultSet.getString(12));
				
				/**
				 * Realiza a consulta por id para criar o objeto endereco
				 * apartir do fk da endereco
				 */
	//			EnderecoDAO enderecoDao = new EnderecoDAO();
	//			Endereco endereco = enderecoDao.buscarPorId(resultSet.getString(13));
	//			usuario.setEndereco(endereco);
				
				/**
				 * Realiza a consulta por id para criar o objeto escola
				 * apartir do fk da escola
				 */
	//			EscolaDAO escolaDAO = new EscolaDAO();
	//			Escola escola = escolaDAO.buscarPorId(resultSet.getString(14));
	//			usuario.setEscola(escola);
				
				comandoSql.close(); 
				return diretor;
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
	public List<Diretor> buscarTodos() {
		
		List<Diretor> lista = new ArrayList<Diretor>(); 
		
		String sql = "select * from usuario where tipoUsuario = 3"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				Diretor diretor = new Diretor();
				diretor.setIdUsuario(resultSet.getInt(1));
				diretor.setNome(resultSet.getString(2));
				diretor.setSobrenome(resultSet.getString(3));
				diretor.setCpf(resultSet.getString(4));
				diretor.setTelefone(resultSet.getString(5));
				diretor.setCelular(resultSet.getString(6));
				diretor.setTipoUsuario(resultSet.getInt(7));
				diretor.setEmail(resultSet.getString(8));
				diretor.setSenha(resultSet.getString(9));
				diretor.setHorarioFinalExpediente(resultSet.getTime(10));
				diretor.setHorarioInicioExpediente(resultSet.getTime(11));
				diretor.setFotoUsuario(resultSet.getString(12));
				
				/**
				 * Realiza a consulta por id para criar o objeto endereco
				 * apartir do fk da endereco
				 */
	//			EnderecoDAO enderecoDao = new EnderecoDAO();
	//			Endereco endereco = enderecoDao.buscarPorId(resultSet.getString(13));
	//			usuario.setEndereco(endereco);
				
				/**
				 * Realiza a consulta por id para criar o objeto escola
				 * apartir do fk da escola
				 */
	//			EscolaDAO escolaDAO = new EscolaDAO();
	//			Escola escola = escolaDAO.buscarPorId(resultSet.getString(14));
	//			usuario.setEscola(escola);
				lista.add(diretor); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
