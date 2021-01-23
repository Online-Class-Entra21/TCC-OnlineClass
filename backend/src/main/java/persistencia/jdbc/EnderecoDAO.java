package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Endereco;

/**
 * Metodo para consulta do endereco no banco de dados 
 * @author André
 *
 */
public class EnderecoDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir Endereco no banco de dados
	 * @param Endereco endereco
	 * @author André
	 * @throws SQLException 
	 */
	public void insert(Endereco endereco) throws SQLException {
		String sql = "insert into endereco (estado, cidade, bairro, rua, numero, cep) values (?,?,?,?,?,?).";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, endereco.getEstado());
		comandoSql.setString(2, endereco.getCidade());
		comandoSql.setString(3, endereco.getBairro());
		comandoSql.setString(4, endereco.getRua());
		comandoSql.setInt(5, endereco.getNumero());
		comandoSql.setString(6, endereco.getCep());
		comandoSql.setInt(7, endereco.getIdEndereco());
		comandoSql.execute();
		
		comandoSql.close();
	}

	/**
	 * Metodo para atualizar uma Endereco no banco de dados.
	 * O <code>idEndereco</code> deve ser igual ao do endereco que deseja atualizar
	 * @author André
	 * @throws SQLException 
	 */ 	
	public void update(Endereco endereco) throws SQLException {
		String sql = "update escola set estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, cep = ? where idendereco = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, endereco.getEstado());
		comandoSql.setString(2, endereco.getCidade());
		comandoSql.setString(3, endereco.getBairro());
		comandoSql.setString(4, endereco.getRua());
		comandoSql.setInt(5, endereco.getNumero());
		comandoSql.setString(6, endereco.getCep());
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma Endereco.
	 *  O <code>idEndereco</code> deve ser igual ao do endereco que deseja deletar
	 * @param Endereco endereco
	 * @author André
	 * @throws SQLException 
	 */
	public void deleteId(int id) throws SQLException {
		String sql = "delete from endereco where idescola = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, id);
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar o endereco no banco de dados.
	 * O <code>idEndereco</code> deve ser igual ao do endereco que deseja buscar
	 * @param int idEndereco
	 * @return Endereco endereco
	 * @author André
	 * @throws SQLException 
	 */
	public Endereco buscarId(int idEndereco) throws SQLException {
		Endereco endereco = new Endereco();
		String sql = "select * from Endereco where idEndereco = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idEndereco);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			endereco.setIdEndereco(resultSet.getInt(1));
			endereco.setEstado(resultSet.getString(2));
			endereco.setCidade(resultSet.getString(3));
			endereco.setBairro(resultSet.getString(4));
			endereco.setRua(resultSet.getString(5));
			endereco.setNumero(resultSet.getInt(6));
			endereco.setCep(resultSet.getString(7));
		}
		comandoSql.close();
		return endereco;
	}
	
	/**
	 * Metodo para selecionar todos os enderecos do banco de dados
	 * @return lista de enderecos registrados no banco 
	 * @author André
	 * @throws SQLException 
	 */
	public List<Endereco> buscarTodos() throws SQLException {
		List<Endereco> lista = new ArrayList<Endereco>();
		String sql = "select * from Endereco";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();

		while (resultSet.next()) {
			Endereco endereco = new Endereco();
			endereco.setIdEndereco(resultSet.getInt(1));
			endereco.setEstado(resultSet.getString(2));
			endereco.setCidade(resultSet.getString(3));
			endereco.setBairro(resultSet.getString(4));
			endereco.setRua(resultSet.getString(5));
			endereco.setNumero(resultSet.getInt(6));
			endereco.setCep(resultSet.getString(7));
			
			lista.add(endereco);
		}
		comandoSql.close();
		return lista;
	}
}
