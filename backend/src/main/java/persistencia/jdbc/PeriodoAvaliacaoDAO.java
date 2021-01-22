package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.PeriodoAvaliacao;

public class PeriodoAvaliacaoDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir PeriodoAvaliacao no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>PeriodoAvaliacao</code>
	 * @author Andre
	 * @throws SQLException 
	 */
	public void insert(PeriodoAvaliacao periodoAvaliacao) throws SQLException {
			
		PreparedStatement comandoSql = conexao.prepareStatement("insert into periodoavaliacao (datainicial, datafinal, descricao, fk_escola) values (?,?,?,?)");
		
		comandoSql.setDate(1, (Date) periodoAvaliacao.getDataInicial());
		comandoSql.setDate(2, (Date) periodoAvaliacao.getDataFinal());
		comandoSql.setString(3, periodoAvaliacao.getDescricao());
		comandoSql.setInt(4, periodoAvaliacao.getFk_escola());
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma PeriodoAvaliacao no banco de dados.
	 * 
	 * O id do <code>PeriodoAvaliacao</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param <code>PeriodoAvaliacao</code>
	 * @author Andre
	 * @throws SQLException 
	 */ 	
	public void update(PeriodoAvaliacao periodoAvaliacao) throws SQLException {
		
		PreparedStatement comandoSql = conexao.prepareStatement("update periodoavaliacao set datainicial = ?, datafinal = ?, descricao = ?, fk_escola = ?  where idperiodoavaliacao = ?");
		
		comandoSql.setDate(1, (Date) periodoAvaliacao.getDataInicial());
		comandoSql.setDate(2, (Date) periodoAvaliacao.getDataFinal());
		comandoSql.setString(3, periodoAvaliacao.getDescricao());
		comandoSql.setInt(4, periodoAvaliacao.getFk_escola());
		comandoSql.setInt(5, periodoAvaliacao.getIdPeriodoAvaliacao());
		comandoSql.execute();
		
		comandoSql.close();

	}
	
	/**
	 *  Metodo para deletar do banco de dados uma PeriodoAvaliacao
	 *  <p>
	 *  O <code>idPeriodoAvaliacao</code> deve ser igual ao id do banco de dados
	 * 
	 * @param <code>PeriodoAvaliacao</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 * @throws SQLException 
	 */	
	public void deleteId(int id) throws SQLException {
		
			PreparedStatement comandoSql = conexao.prepareStatement("delete from periodoavaliacao where idescola = ?");
			
			comandoSql.setInt(1, id);
			comandoSql.execute();
			
			comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar <code>PeriodoAvaliacao</code> no banco de dados
	 * <p>
	 * O <code>idPeriodoAvaliacao</code> deve ser igual ao PeriodoAvaliacao que deseja selecionar
	 * 
	 * @param <code>idPeriodoAvaliacao<code>
	 * @author Andre
	 * @throws SQLException 
	 */	
	public PeriodoAvaliacao buscarId(int id) throws SQLException {
		PeriodoAvaliacao periodoAvaliacao = new PeriodoAvaliacao();

		PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola where idperiodoavaliacao = ?");
		
		comandoSql.setInt(1, id);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			periodoAvaliacao.setIdPeriodoAvaliacao(resultSet.getInt(1));
			periodoAvaliacao.setDataInicial(resultSet.getDate(2));
			periodoAvaliacao.setDataFinal(resultSet.getDate(3));
			periodoAvaliacao.setDescricao(resultSet.getString(4));
			periodoAvaliacao.setFk_escola(resultSet.getInt(5));
			return periodoAvaliacao;
		}
		
		comandoSql.close();
		
		return null;
	}
	
	/**
	 * Metodo para selecionar todos os <code>PeriodoAvaliacaos</code> do banco de dados
	 * 
	 * @return <code>List</code>
	 * @author Andre
	 * @throws SQLException 
	 */	
	public List<PeriodoAvaliacao> buscarTodos() throws SQLException {
		List<PeriodoAvaliacao> lista = new ArrayList<PeriodoAvaliacao>();
		
		PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola");
		
		ResultSet resultSet = comandoSql.executeQuery();
		comandoSql.close();
		
		while (resultSet.next()) {
			PeriodoAvaliacao periodoAvaliacao = new PeriodoAvaliacao();
			periodoAvaliacao.setIdPeriodoAvaliacao(resultSet.getInt(1));
			periodoAvaliacao.setDataInicial(resultSet.getDate(2));
			periodoAvaliacao.setDataFinal(resultSet.getDate(3));
			periodoAvaliacao.setDescricao(resultSet.getString(4));
			periodoAvaliacao.setFk_escola(resultSet.getInt(5));
			lista.add(periodoAvaliacao);
		}
			
		return lista;
	}
	
}
