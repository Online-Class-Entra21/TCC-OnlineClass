package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		comandoSql.setDate(1, (Date) periodoAvaliacao.getDataInicial());
		comandoSql.setDate(2, (Date) periodoAvaliacao.getDataFinal());
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
		
		comandoSql.setDate(1, (Date) periodoAvaliacao.getDataInicial());
		comandoSql.setDate(2, (Date) periodoAvaliacao.getDataFinal());
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
		String sql = "delete from periodoavaliacao where idescola = ?";
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
			periodoAvaliacao.setDataInicial(resultSet.getDate(2));
			periodoAvaliacao.setDataFinal(resultSet.getDate(3));
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
		PeriodoAvaliacao periodoAvaliacao = new PeriodoAvaliacao();
		List<PeriodoAvaliacao> lista = new ArrayList<PeriodoAvaliacao>();
		String sql = "select * from Escola";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			periodoAvaliacao.setIdPeriodoAvaliacao(resultSet.getInt(1));
			periodoAvaliacao.setDataInicial(resultSet.getDate(2));
			periodoAvaliacao.setDataFinal(resultSet.getDate(3));
			periodoAvaliacao.setDescricao(resultSet.getString(4));
			periodoAvaliacao.setFk_escola(resultSet.getInt(5));
			lista.add(periodoAvaliacao);
		}	
		comandoSql.close();
		return lista;
	}
}
