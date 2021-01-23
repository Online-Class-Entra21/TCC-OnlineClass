package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Relatorio;

/**
 * Metodo para consulta do relatorio no banco de dados 
 * @author André
 *
 */
public class RelatorioDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir relatorio no banco de dados
	 * @param Relatorio relatorio 
	 * @author André
	 * @throws SQLException 
	 */	
	public void insert(Relatorio relatorio) throws SQLException {
		String sql = "insert into relatorio (titulo, destinatario, texto, tiporelatorio, fk_usuario) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, relatorio.getTitulo());
		comandoSql.setInt(2, relatorio.getDestinatario());
		comandoSql.setString(3, relatorio.getTexto());
		comandoSql.setString(4, relatorio.getTipoRelatorio());
		comandoSql.setInt(5, relatorio.getFk_usuario());
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar um relatorio no banco de dados.
	 * O <code>idRelatorio</code> deve ser igual ao do relatorio que deseja atualizar
	 * @param Relatorio relatorio 
	 * @author André
	 * @throws SQLException 
	 */ 	
	public void update(Relatorio relatorio) throws SQLException {
		String sql = "update relatorio set idrelatorio=?, titulo=?, destinatario=?, texto=?, "
				   + "tiporelatorio=?, fk_usuario=? where idrelatorio = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, relatorio.getTitulo());
		comandoSql.setInt(2, relatorio.getDestinatario());
		comandoSql.setString(3, relatorio.getTexto());
		comandoSql.setString(4, relatorio.getTipoRelatorio());
		comandoSql.setInt(5, relatorio.getFk_usuario());
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma relatorio.
	 *  O <code>idRelatorio</code> deve ser igual ao do relatorio que deseja deletar
	 * @param Relatorio relatorio 
	 * @author André
	 * @throws SQLException 
	 */	
	public void deleteId(int id) throws SQLException {
		String sql = "delete from relatorio where idrelatorio = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, id);
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar <code>Relatorio</code> no banco de dados.
	 * O <code>idRelatorio</code> deve ser igual ao do relatorio que deseja buscar
	 * @param int idRelatorio
	 * @return Relatorio relatorio 
	 * @author André
	 * @throws SQLException 
	 */	
	public Relatorio buscarId(int id) throws SQLException {
		Relatorio relatorio = new Relatorio();
		String sql = "select * from relatorio where idescola = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, id);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			relatorio.setIdRelatorio (resultSet.getInt(1));
			relatorio.setTitulo(resultSet.getString(2));
			relatorio.setDestinatario(resultSet.getInt(3));
			relatorio.setTexto(resultSet.getString(4));
			relatorio.setTipoRelatorio(resultSet.getString(5));
			relatorio.setFk_usuario(resultSet.getInt(6));
		}
		comandoSql.close();
		return relatorio;
	}
	
	/**
	 * Metodo para selecionar todos os relatorios do banco de dados
	 * @return lista de relatorios registrados no banco
	 * @author Andre
	 * @throws SQLException 
	 */	
	public List<Relatorio> buscarTodos() throws SQLException {
		List<Relatorio> lista = new ArrayList<Relatorio>();
	    String sql = "select * from Escola";
	    
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
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
		comandoSql.close();
		return lista;
	}
}
