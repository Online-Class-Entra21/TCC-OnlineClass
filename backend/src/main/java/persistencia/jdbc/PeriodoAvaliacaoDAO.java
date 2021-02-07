package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidade.PeriodoAvaliacao;

/**
 * Metodo para consulta do periodoAvaliacao no banco de dados 
 * @author Andrey
 *
 */
public class PeriodoAvaliacaoDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir periodoAvaliacao no banco de dados
	 * @param PeriodoAvaliacao periodoAvaliacao
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void insert(PeriodoAvaliacao periodoAvaliacao) throws SQLException {
		String sql = "insert into periodoavaliacao (datainicial, datafinal, descricao, fk_escola) values (?,?,?,?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setTimestamp(1, (Timestamp) periodoAvaliacao.getDataInicial());
		comandoSql.setTimestamp(2, (Timestamp) periodoAvaliacao.getDataFinal());
		comandoSql.setString(3, periodoAvaliacao.getDescricao());
		comandoSql.setInt(4, periodoAvaliacao.getFk_escola());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar um periodoAvaliacao no banco de dados
	 * O <code>idPeriodoAvaliacao</code> deve ser igual ao do periodoAvaliacao que deseja atualizar
	 * @param PeriodoAvaliacao periodoAvaliacao
	 * @author Andrey
	 * @throws SQLException 
	 */ 	
	public void update(PeriodoAvaliacao periodoAvaliacao) throws SQLException {
		String sql = "update periodoavaliacao set datainicial = ?, datafinal = ?, descricao = ?, fk_escola = ?  "
				   + "where idperiodoavaliacao = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setTimestamp(1, (Timestamp) periodoAvaliacao.getDataInicial());
		comandoSql.setTimestamp(2, (Timestamp) periodoAvaliacao.getDataFinal());
		comandoSql.setString(3, periodoAvaliacao.getDescricao());
		comandoSql.setInt(4, periodoAvaliacao.getFk_escola());
		comandoSql.setInt(5, periodoAvaliacao.getIdPeriodoAvaliacao());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados um periodoAvaliacao
	 *  O <code>idPeriodoAvaliacao</code> deve ser igual ao do periodoAvaliacao que deseja delete
	 * @param int periodoAvaliacao
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void deleteId(int idPeriodoAvaliacao) throws SQLException {
		String sql = "delete from periodoavaliacao where idPeriodoAvaliacao = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idPeriodoAvaliacao);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar periodoAvaliacao no banco de dados
	 * O <code>idPeriodoAvaliacao</code> deve ser igual ao do periodoAvaliacao que deseja buscar
	 * @param int idPeriodoAvaliacao
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public PeriodoAvaliacao buscarId(int idPeriodoAvaliacao) throws SQLException {
		PeriodoAvaliacao periodoAvaliacao = new PeriodoAvaliacao();
		String sql = "select * from Escola where idperiodoavaliacao = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idPeriodoAvaliacao);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			periodoAvaliacao.setIdPeriodoAvaliacao(resultSet.getInt(1));
			periodoAvaliacao.setDataInicial(resultSet.getTimestamp(2));
			periodoAvaliacao.setDataFinal(resultSet.getTimestamp(3));
			periodoAvaliacao.setDescricao(resultSet.getString(4));
			periodoAvaliacao.setFk_escola(resultSet.getInt(5));
		}
		comandoSql.close();
		return periodoAvaliacao;
	}
	
	/**
	 * Metodo para selecionar todos os periodosAvaliacaos do banco de dados
	 * @return lista de periodosAvaliacoes registradas no banco 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public List<PeriodoAvaliacao> buscarTodos() throws SQLException {
		List<PeriodoAvaliacao> lista = new ArrayList<PeriodoAvaliacao>();
		String sql = "select * from PeriodoAvaliacao";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			PeriodoAvaliacao periodoAvaliacao = new PeriodoAvaliacao();
			periodoAvaliacao.setIdPeriodoAvaliacao(resultSet.getInt(1));
			periodoAvaliacao.setDataInicial(resultSet.getTimestamp(2));
			periodoAvaliacao.setDataFinal(resultSet.getTimestamp(3));
			periodoAvaliacao.setDescricao(resultSet.getString(4));
			periodoAvaliacao.setFk_escola(resultSet.getInt(5));
			lista.add(periodoAvaliacao);
		}	
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo para selecionar todos os periodosAvaliacaos do banco de dados na escola informada
	 * @return lista de periodosAvaliacoes registradas no banco na escola informada
	 * @author Breno
	 * @param int fk_escola
	 * @throws SQLException 
	 */	
	public List<PeriodoAvaliacao> buscarTodosEscola(int fk_escola) throws SQLException {
		List<PeriodoAvaliacao> lista = new ArrayList<PeriodoAvaliacao>();
		String sql = "select * from PeriodoAvaliacao where fk_escola = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, fk_escola);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			PeriodoAvaliacao periodoAvaliacao = new PeriodoAvaliacao();
			periodoAvaliacao.setIdPeriodoAvaliacao(resultSet.getInt(1));
			periodoAvaliacao.setDataInicial(resultSet.getTimestamp(2));
			periodoAvaliacao.setDataFinal(resultSet.getTimestamp(3));
			periodoAvaliacao.setDescricao(resultSet.getString(4));
			periodoAvaliacao.setFk_escola(resultSet.getInt(5));
			lista.add(periodoAvaliacao);
		}	
		comandoSql.close();
		return lista;
	}
	
	/**
	 *  Metodo para deletar do banco de dados um periodoAvaliacao através do fk
	 *  O <code>fk_escola</code> deve ser igual ao do periodoAvaliacao que deseja delete
	 * @param int fk_escola
	 * @author Breno
	 * @throws SQLException 
	 */	
	public void deleteFk(int fk_escola) throws SQLException {
		String sql = "delete from periodoavaliacao where fk_escola = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, fk_escola);
		
		comandoSql.execute();
		comandoSql.close();
	}
}
