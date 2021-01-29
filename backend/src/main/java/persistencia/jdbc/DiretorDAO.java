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
			diretor.setHorarioFinalExpediente(resultSet.getTime(10));
			diretor.setHorarioInicioExpediente(resultSet.getTime(11));
			diretor.setFotoUsuario(resultSet.getString(12));
			diretor.setFk_endereco(resultSet.getInt(13));
			diretor.setFk_escola(resultSet.getInt(14));
			
			lista.add(diretor);
		}
		comandoSql.close();
		return lista;
	}
	
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
			diretor.setHorarioFinalExpediente(resultSet.getTime(10));
			diretor.setHorarioInicioExpediente(resultSet.getTime(11));
			diretor.setFotoUsuario(resultSet.getString(12));
			diretor.setFk_endereco(resultSet.getInt(13));
			diretor.setFk_escola(resultSet.getInt(14));
			
			return diretor;
		}
		comandoSql.close();
		return null;
	}
	
	/**
	 * Método para atualizar a escola comandada pelo diretor
	 * @param int fk_escola
	 * @param int idUsuario
	 * @author Andrey
	 */
	public void atualizarEscola(int fk_escola, int idUsuario) throws SQLException {
		String sql = "update usuario set fk_escola = ? where idUsuario = ? and tipoUsuario = 2";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, fk_escola);
		comandoSql.setInt(2, idUsuario);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Método para remover a escola comandada pelo diretor
	 * @param int idUsuario
	 * @throws SQLException
	 * @author Andrey
	 * 
	 */
	public void removerEscola(int idUsuario) throws SQLException {
		String sql = "update usuario set fk_escola = ? where idUsuario = ? and tipoUsuario = 2";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setNull(1, java.sql.Types.INTEGER);
		comandoSql.setInt(2, idUsuario);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Método para retorno dos diretores que não possuem nenhuma escola
	 * @return Diretor
	 * @throws SQLException
	 * @author Andrey
	 */
	public List<Diretor> buscarDiretoresDisponiveis() throws SQLException {
		List<Diretor> lista =  new ArrayList<Diretor>();
		String sql = "select * from usuario where tipoUsuario = 2 and fk_escola = ?";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setNull(1, java.sql.Types.INTEGER);
		
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
			diretor.setHorarioFinalExpediente(resultSet.getTime(10));
			diretor.setHorarioInicioExpediente(resultSet.getTime(11));
			diretor.setFotoUsuario(resultSet.getString(12));
			diretor.setFk_endereco(resultSet.getInt(13));
			diretor.setFk_escola(resultSet.getInt(14));
			lista.add(diretor);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------

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

