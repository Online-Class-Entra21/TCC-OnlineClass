package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Relatorio;

/**
 * Metodo para consulta do relatorio no banco de dados 
 * @author Andrey
 *
 */
public class RelatorioDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir relatorio no banco de dados
	 * @param Relatorio relatorio 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void insert(Relatorio relatorio) throws SQLException {
		String sql = "insert into relatorio (titulo, destinatario, texto, dataRelatorio, fk_usuario) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, relatorio.getTitulo());
		comandoSql.setInt(2, relatorio.getDestinatario());
		comandoSql.setString(3, relatorio.getTexto());
		comandoSql.setDate(4, (Date) relatorio.getDataRelatorio());
		comandoSql.setInt(5, relatorio.getFk_usuario());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar um relatorio no banco de dados.
	 * O <code>idRelatorio</code> deve ser igual ao do relatorio que deseja atualizar
	 * @param Relatorio relatorio 
	 * @author Andrey
	 * @throws SQLException 
	 */ 	
	public void update(Relatorio relatorio) throws SQLException {
		String sql = "update relatorio set idrelatorio=?, titulo=?, destinatario=?, texto=?, "
				   + "datarelatorio=?, fk_usuario=? where idrelatorio =?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, relatorio.getTitulo());
		comandoSql.setInt(2, relatorio.getDestinatario());
		comandoSql.setString(3, relatorio.getTexto());
		comandoSql.setDate(4, (Date) relatorio.getDataRelatorio());
		comandoSql.setInt(5, relatorio.getFk_usuario());
		comandoSql.setInt(6, relatorio.getIdRelatorio());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma relatorio.
	 *  O <code>idRelatorio</code> deve ser igual ao do relatorio que deseja deletar
	 * @param int idRelatorio 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void deleteId(int idRelatorio) throws SQLException {
		String sql = "delete from relatorio where idrelatorio = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idRelatorio);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar relatorio no banco de dados.
	 * O <code>idRelatorio</code> deve ser igual ao do relatorio que deseja buscar
	 * @param int idRelatorio
	 * @return Relatorio relatorio 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public Relatorio buscarId(int idRelatorio) throws SQLException {
		Relatorio relatorio = new Relatorio();
		String sql = "select * from relatorio where idRelatorio = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idRelatorio);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			relatorio.setIdRelatorio (resultSet.getInt(1));
			relatorio.setTitulo(resultSet.getString(2));
			relatorio.setDestinatario(resultSet.getInt(3));
			relatorio.setTexto(resultSet.getString(4));
			relatorio.setFk_usuario(resultSet.getInt(5));
			relatorio.setDataRelatorio(resultSet.getDate(6));
		}
		comandoSql.close();
		return relatorio;
	}
	
	/**
	 * Metodo para selecionar todos os relatorios do banco de dados
	 * @return lista de relatorios registrados no banco
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public List<Relatorio> buscarTodos() throws SQLException {
		List<Relatorio> lista = new ArrayList<Relatorio>();
	    String sql = "select * from relatorio";
	    
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Relatorio relatorio = new Relatorio();
			relatorio.setIdRelatorio (resultSet.getInt(1));
			relatorio.setTitulo(resultSet.getString(2));
			relatorio.setDestinatario(resultSet.getInt(3));
			relatorio.setTexto(resultSet.getString(4));
			relatorio.setFk_usuario(resultSet.getInt(5));
			relatorio.setDataRelatorio(resultSet.getDate(6));
			lista.add(relatorio);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo para selecionar todos os relatorios do banco de dados onde fk_usuario é igual ao codigo
	 * @return lista de relatorios registrados no banco onde fk_usuario é igual ao codigo
	 * @param int fk_usuario
	 * @author Breno
	 * @throws SQLException 
	 */	
	public List<Relatorio> buscarTodosFk(int fk_usuario) throws SQLException {
		List<Relatorio> lista = new ArrayList<Relatorio>();
	    String sql = "select * from relatorio where fk_usuario = ?";
	    
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, fk_usuario);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Relatorio relatorio = new Relatorio();
			relatorio.setIdRelatorio (resultSet.getInt(1));
			relatorio.setTitulo(resultSet.getString(2));
			relatorio.setDestinatario(resultSet.getInt(3));
			relatorio.setTexto(resultSet.getString(4));
			relatorio.setFk_usuario(resultSet.getInt(5));
			relatorio.setDataRelatorio(resultSet.getDate(6));
			lista.add(relatorio);
		}
		comandoSql.close();
		return lista;
	}
	
	/**
	 * Metodo para selecionar todos os relatorios do banco de dados onde fk_usuario é igual ao codigo
	 * @return lista de relatorios registrados no banco onde destina é igual ao codigo
	 * @param int destinatario
	 * @author Breno
	 * @throws SQLException 
	 */	
	public List<Relatorio> buscarTodosDestinatario(int destinatario) throws SQLException {
		List<Relatorio> lista = new ArrayList<Relatorio>();
	    String sql = "select * from relatorio where destinatario = ?";
	    
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, destinatario);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Relatorio relatorio = new Relatorio();
			relatorio.setIdRelatorio (resultSet.getInt(1));
			relatorio.setTitulo(resultSet.getString(2));
			relatorio.setDestinatario(resultSet.getInt(3));
			relatorio.setTexto(resultSet.getString(4));
			relatorio.setFk_usuario(resultSet.getInt(5));
			relatorio.setDataRelatorio(resultSet.getDate(6));
			lista.add(relatorio);
		}
		comandoSql.close();
		return lista;
	}
}
