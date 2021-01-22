package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Relatorio;

public class RelatorioDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir Relatorio no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>Relatorio</code>
	 * @author Andre
	 * @throws SQLException 
	 */	
	public void insert(Relatorio relatorio) throws SQLException {
		
		PreparedStatement comandoSql = conexao.prepareStatement("insert into relatorio (titulo, destinatario, texto, tiporelatorio, fk_usuario) values (?, ?, ?, ?, ?, ?)");
		
		comandoSql.setString(1, relatorio.getTitulo());
		comandoSql.setInt(2, relatorio.getDestinatario());
		comandoSql.setString(3, relatorio.getTexto());
		comandoSql.setString(4, relatorio.getTipoRelatorio());
		comandoSql.setInt(5, relatorio.getFk_usuario());
		comandoSql.execute();
		
		comandoSql.close();

		
	}
	
	/**
	 * Metodo para atualizar um Relatorio no banco de dados.
	 * 
	 * O id do <code>Relatorio</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param <code>Relatorio</code>
	 * @author Andre
	 * @throws SQLException 
	 */ 	
	public void update(Relatorio relatorio) throws SQLException {
		
		PreparedStatement comandoSql = conexao.prepareStatement("update relatorio set idrelatorio=?, titulo=?, destinatario=?, texto=?, tiporelatorio=?, fk_usuario=? where idrelatorio = ?");
		
		comandoSql.setString(1, relatorio.getTitulo());
		comandoSql.setInt(2, relatorio.getDestinatario());
		comandoSql.setString(3, relatorio.getTexto());
		comandoSql.setString(4, relatorio.getTipoRelatorio());
		comandoSql.setInt(5, relatorio.getFk_usuario());
		comandoSql.execute();
		
		comandoSql.close();

	}
	
	/**
	 *  Metodo para deletar do banco de dados uma Relatorio
	 *  <p>
	 *  O <code>idRelatorio</code> deve ser igual ao id do banco de dados
	 * 
	 * @param <code>Relatorio</code>
	 * @author Andre
	 * @throws SQLException 
	 */	
	public void deleteId(int id) throws SQLException {
		
		PreparedStatement comandoSql = conexao.prepareStatement("delete from relatorio where idrelatorio = ?");
		
		comandoSql.setInt(1, id);
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar <code>Relatorio</code> no banco de dados
	 * <p>
	 * O <code>idRelatorio</code> deve ser igual ao Relatorio que deseja selecionar
	 * 
	 * @param <code>idRelatorio<code>
	 * @return Relatorio
	 * @author Andre
	 * @throws SQLException 
	 */	
	public Relatorio buscarId(int id) throws SQLException {
		Relatorio relatorio = new Relatorio();
		
		PreparedStatement comandoSql = conexao.prepareStatement("select * from relatorio where idescola = ?");
		
		comandoSql.setInt(1, id);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			relatorio.setIdRelatorio (resultSet.getInt(1));
			relatorio.setTitulo(resultSet.getString(2));
			relatorio.setDestinatario(resultSet.getInt(3));
			relatorio.setTexto(resultSet.getString(4));
			relatorio.setTipoRelatorio(resultSet.getString(5));
			relatorio.setFk_usuario(resultSet.getInt(6));
			return relatorio;
		}
		
		comandoSql.close();
			
		return null;
	}
	
	/**
	 * Metodo para selecionar todos os <code>Relatorios</code> do banco de dados
	 * 
	 * @return <code>List</code>
	 * @author Andre
	 * @throws SQLException 
	 */	
	public List<Relatorio> buscarTodos() throws SQLException {
		List<Relatorio> lista = new ArrayList<Relatorio>();
	
		PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola");
		
		ResultSet resultSet = comandoSql.executeQuery();
		comandoSql.close();
		
		while (resultSet.next()) {
			Relatorio relatorio = new Relatorio();
			relatorio.setIdRelatorio (resultSet.getInt(1));
			relatorio.setTitulo(resultSet.getString(2));
			relatorio.setDestinatario(resultSet.getInt(3));
			relatorio.setTexto(resultSet.getString(4));
			relatorio.setTipoRelatorio(resultSet.getString(5));
			relatorio.setFk_usuario(resultSet.getInt(6));
			lista.add(relatorio);
		}

		return lista;
	}
	
}
