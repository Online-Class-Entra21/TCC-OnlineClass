package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Professor;

public class ProfessorDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma Professor no banco de dados
	 * @param Professor
	 * @return
	 */
	public boolean insert(Professor Professor) {
		
		String sql = "insert into usuario (nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, "
				   + "senha, horaFinalExpediente, horaInicioExpediente, fotoUsuario, fk_endereco, "
				   + "fk_escola) values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setString(1, Professor.getNome());
			comandoSql.setString(2, Professor.getSobrenome());
			comandoSql.setString(3, Professor.getCpf());
			comandoSql.setString(4, Professor.getTelefone());
			comandoSql.setString(5, Professor.getCelular());
			comandoSql.setInt(6, Professor.getTipoUsuario());
			comandoSql.setString(7, Professor.getEmail());
			comandoSql.setString(8, Professor.getSenha());
			comandoSql.setTime(9, Professor.getHorarioFinalExpediente());
			comandoSql.setTime(10, Professor.getHorarioInicioExpediente());
			comandoSql.setString(11, Professor.getFotoUsuario());
			comandoSql.setInt(12, Professor.getEndereco().getIdEndereco());
			comandoSql.setInt(13, Professor.getEscola().getIdEscola());
			
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
	 * Realiza atualiza��o dos dados da Professor no banco de dados
	 * @param Professor
	 * @return
	 */
	public boolean update(Professor Professor) {
		
		String sql = "update Professor set nome = ?, sobrenome = ?, cpf = ?, telefone = ?, celular = ?, "
				   + "tipoProfessor = ?, email = ?, senha = ?, horaFinalExpediente = ?, horaInicioExpediente = ?, "
				   + "fotoProfessor = ?, fk_endereco = ?, fk_escola = ? where idProfessor = ?";  
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		    
			comandoSql.setString(1, Professor.getNome());
			comandoSql.setString(2, Professor.getSobrenome());
			comandoSql.setString(3, Professor.getCpf());
			comandoSql.setString(4, Professor.getTelefone());
			comandoSql.setString(5, Professor.getCelular());
			comandoSql.setInt(6, Professor.getTipoUsuario());
			comandoSql.setString(7, Professor.getEmail());
			comandoSql.setString(8, Professor.getSenha());
			comandoSql.setTime(9, Professor.getHorarioFinalExpediente());
			comandoSql.setTime(10, Professor.getHorarioInicioExpediente());
			comandoSql.setString(11, Professor.getFotoUsuario());
			comandoSql.setInt(12, Professor.getEndereco().getIdEndereco());
			comandoSql.setInt(13, Professor.getEscola().getIdEscola());
			comandoSql.setInt(14, Professor.getIdProfessor());
			
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
	 * Realiza a exclus�o dos dados de uma linha da tabela Professor
	 * @param idProfessor
	 * @return
	 */
	public boolean delete(int idProfessor) {
		
		String sql = "delete from Professor where idProfessor = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idProfessor);
			
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
	 * M�todo de busca de todas as informa��es de uma linha
	 * da tabela Professor do banco de dados
	 * @param idProfessor
	 * @return
	 */
	public Professor buscarPorId(int idProfessor) {
		Professor Professor = new Professor(); 
		
		String sql = "select * from Professor where idProfessor = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idProfessor);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				Professor.setIdUsuario(resultSet.getInt(1));
				Professor.setNome(resultSet.getString(2));
				Professor.setSobrenome(resultSet.getString(3));
				Professor.setCpf(resultSet.getString(4));
				Professor.setTelefone(resultSet.getString(5));
				Professor.setCelular(resultSet.getString(6));
				Professor.setTipoUsuario(resultSet.getInt(7));
				Professor.setEmail(resultSet.getString(8));
				Professor.setSenha(resultSet.getString(9));
				Professor.setHorarioFinalExpediente(resultSet.getTime(10));
				Professor.setHorarioInicioExpediente(resultSet.getTime(11));
				Professor.setFotoUsuario(resultSet.getString(12));
				
				/**
				 * Realiza a consulta por id para criar o objeto endereco
				 * apartir do fk da endereco
				 */
//				EnderecoDAO enderecoDao = new EnderecoDAO();
//				Endereco endereco = enderecoDao.buscarPorId(resultSet.getString(13));
//				Professor.setEndereco(endereco);
				
				/**
				 * Realiza a consulta por id para criar o objeto escola
				 * apartir do fk da escola
				 */
//				EscolaDAO escolaDAO = new EscolaDAO();
//				Escola escola = escolaDAO.buscarPorId(resultSet.getString(14));
//				Professor.setEscola(escola);
				
				comandoSql.close(); 
				return Professor;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela Professor do banco de dados 
	 * @return
	 */
	public List<Professor> buscarTodos() {
		
		List<Professor> lista = new ArrayList<Professor>(); 
		
		String sql = "select * from Professor"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				Professor Professor = new Professor(); 
				Professor.setIdUsuario(resultSet.getInt(1));
				Professor.setNome(resultSet.getString(2));
				Professor.setSobrenome(resultSet.getString(3));
				Professor.setCpf(resultSet.getString(4));
				Professor.setTelefone(resultSet.getString(5));
				Professor.setCelular(resultSet.getString(6));
				Professor.setTipoUsuario(resultSet.getInt(7));
				Professor.setEmail(resultSet.getString(8));
				Professor.setSenha(resultSet.getString(9));
				Professor.setHorarioFinalExpediente(resultSet.getTime(10));
				Professor.setHorarioInicioExpediente(resultSet.getTime(11));
				Professor.setFotoUsuario(resultSet.getString(12));
				
				/**
				 * Realiza a consulta por id para criar o objeto endereco
				 * apartir do fk da endereco
				 */
//				EnderecoDAO enderecoDao = new EnderecoDAO();
//				Endereco endereco = enderecoDao.buscarPorId(resultSet.getString(13));
//				Professor.setEndereco(endereco);
				
				/**
				 * Realiza a consulta por id para criar o objeto escola
				 * apartir do fk da escola
				 */
//				EscolaDAO escolaDAO = new EscolaDAO();
//				Escola escola = escolaDAO.buscarPorId(resultSet.getString(14));
//				Professor.setEscola(escola);
				lista.add(Professor); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	

}
