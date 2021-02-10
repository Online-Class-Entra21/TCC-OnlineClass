package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidade.Professor;
import entidade.Usuario;

/**
 * Metodo para consulta do professor no banco de dados 
 * @author Andrey
 *
 */
public class ProfessorDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para selecionar do banco de dados todos os professores cadastrados
	 * @return lista de professores registrados no banco 
	 * @author Andrey
	 * @throws SQLException
	 */
	public List<Professor> buscarTodos() throws SQLException {
		List<Professor> lista =  new ArrayList<Professor>();
		String sql = "select * from usuario where tipoUsuario = 4";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Professor professor = new Professor();
			professor.setIdUsuario(resultSet.getInt(1));
			professor.setNome(resultSet.getString(2));
			professor.setSobrenome(resultSet.getString(3));
			professor.setCpf(resultSet.getString(4));
			professor.setTelefone(resultSet.getString(5));
			professor.setCelular(resultSet.getString(6));
			professor.setTipoUsuario(resultSet.getInt(7));
			professor.setEmail(resultSet.getString(8));
			professor.setSenha(resultSet.getString(9));
			professor.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			professor.setHorarioInicioExpediente(resultSet.getTimestamp(11));
			professor.setFotoUsuario(resultSet.getString(12));
			professor.setFk_endereco(resultSet.getInt(13));
			professor.setFk_escola(resultSet.getInt(14));
			
			lista.add(professor);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
		
	/**
	 * Metodo para retorno da quantidade de professores no banco de dados
	 * @return int qtdProfessores
	 * @author Breno
	 * @throws SQLException
	 */
	public int buscarQuantidadeProfessores() throws SQLException {
		int qtdProfessores = 0;
		String sql = "select count(idUsuario) from usuario where tipoUsuario = 4";

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			qtdProfessores = (resultSet.getInt(1));
		}
		comandoSql.close();
		return qtdProfessores;
	}
	
	/**
	 * Realiza o registro de um professor no banco de dados
	 * e retorna o id do registro
	 * @param Usuario usuario
	 * @author Andre
	 * @throws SQLException 
	 */
	public int insertReturnID(Usuario usuario) throws SQLException {
		String sql = "insert into usuario (nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, "
				   + "senha, horaFinalExpediente, horaInicioExpediente, fk_endereco, "
				   + "fk_escola) values (?,?,?,?,?,?,?,?,?,?,?,?)"; 
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
		comandoSql.setInt(11, usuario.getFk_endereco());
		comandoSql.setInt(12, usuario.getFk_escola());

		comandoSql.execute();
		
        ResultSet rs = comandoSql.getGeneratedKeys();
        rs.next();
        int idEndereco = rs.getInt(1);
		comandoSql.close();
		return idEndereco;
	}
}
