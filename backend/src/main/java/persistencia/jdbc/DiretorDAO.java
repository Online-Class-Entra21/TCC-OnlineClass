package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Diretor;

/**
 * Metodo para consulta do diretor no banco de dados 
 * @author Andre
 *
 */
public class DiretorDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Realiza o registro de um usuario diretor no banco de dados
	 * @param Diretor diretor
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(Diretor diretor) throws SQLException {
		String sql = "insert into usuario (nome, sobrenome, telefone, celular, email, "
				   + "senha, tipoUsuario, fk_escola) values (?,?,?,?,?,?,?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
		comandoSql.setString(1, diretor.getNome());
		comandoSql.setString(2, diretor.getSobrenome());
		comandoSql.setString(3, diretor.getTelefone());
		comandoSql.setString(4, diretor.getCelular());
		comandoSql.setString(5, diretor.getEmail());
		comandoSql.setString(6, diretor.getSenha());
		comandoSql.setInt(7, 2);
		comandoSql.setInt(8, diretor.getFk_escola());

		comandoSql.execute();
		comandoSql.close();
	}

	/**
	 * Metodo para atualizar os dados de um perfil do diretor no banco de dados.
	 * O <code>idDiretor</code> deve ser igual ao do diretor que deseja atualizar
	 * @param Diretor diretor
	 * @throws SQLException
	 */
	public void update(Diretor diretor) throws SQLException {
		String sql = "update usuario set nome = ?, sobrenome = ?, telefone = ?, celular = ?, email = ?, "
				   + "senha = ? where idUsuario = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, diretor.getNome());
		comandoSql.setString(2, diretor.getSobrenome());
		comandoSql.setString(3, diretor.getTelefone());
		comandoSql.setString(4, diretor.getCelular());
		comandoSql.setString(5, diretor.getEmail());
		comandoSql.setString(6, diretor.getSenha());
		comandoSql.setInt(7, diretor.getIdUsuario());

		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos os diretores cadastrados
	 * @return lista de diretores registrados no banco 
	 * @author Andre
	 * @throws SQLException
	 */
	public List<Diretor> buscarTodos() throws SQLException {
		List<Diretor> lista =  new ArrayList<Diretor>();
		String sql = "select * from usuario where tipoUsuario = 2";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
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
			diretor.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			diretor.setHorarioInicioExpediente(resultSet.getTimestamp(11));
			diretor.setFotoUsuario(resultSet.getString(12));
			diretor.setFk_endereco(resultSet.getInt(13));
			diretor.setFk_escola(resultSet.getInt(14));
			
			lista.add(diretor);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 3 principais 
	//------------------------------------------------------------------

	/**
	 * Método para retorno do diretor que comenda a escola ao qual o fk foi informado 
	 * @param int fk_escola
	 * @return Andre
	 * @throws SQLException
	 */
	public Diretor buscarDiretorEscola(int fk_escola) throws SQLException {
		String sql = "select * from usuario where tipoUsuario = 2 and fk_escola = ?";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, fk_escola);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
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
			diretor.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			diretor.setHorarioInicioExpediente(resultSet.getTimestamp(11));
			diretor.setFotoUsuario(resultSet.getString(12));
			diretor.setFk_endereco(resultSet.getInt(13));
			diretor.setFk_escola(resultSet.getInt(14));
			
			return diretor;
		}
		comandoSql.close();
		return null;
	}
	
	/**
	 * Metodo para retorno da quantidade de diretores no banco de dados
	 * @return int qtdDiretores
	 * @author Breno
	 * @throws SQLException
	 */
	public int buscarQuantidadeDiretores() throws SQLException {
		int qtdDiretores = 0;
		String sql = "select count(idUsuario) from usuario where tipoUsuario = 2";

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			qtdDiretores = (resultSet.getInt(1));
		}
		comandoSql.close();
		return qtdDiretores;
	}
}

