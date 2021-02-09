package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidade.Endereco;

/**
 * Metodo para consulta do endereco no banco de dados 
 * @author Andrey
 *
 */
public class EnderecoDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir endereco no banco de dados
	 * @param Endereco endereco
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void insert(Endereco endereco) throws SQLException {
		String sql = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?,?,?,?,?,?,?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, endereco.getEstado());
		comandoSql.setString(2, endereco.getCidade());
		comandoSql.setString(3, endereco.getBairro());
		comandoSql.setString(4, endereco.getRua());
		comandoSql.setInt(5, endereco.getNumero());
		comandoSql.setString(6, endereco.getCep());
		comandoSql.setString(7, endereco.getComplemento());
		
		comandoSql.execute();
		comandoSql.close();
	}

	/**
	 * Metodo para atualizar um endereco no banco de dados.
	 * O <code>idEndereco</code> deve ser igual ao do endereco que deseja atualizar
	 * @author Andrey
	 * @throws SQLException 
	 */ 	
	public void update(Endereco endereco) throws SQLException {
		String sql = "update endereco set estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, cep = ?, complemento = ? where idendereco = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, endereco.getEstado());
		comandoSql.setString(2, endereco.getCidade());
		comandoSql.setString(3, endereco.getBairro());
		comandoSql.setString(4, endereco.getRua());
		comandoSql.setInt(5, endereco.getNumero());
		comandoSql.setString(6, endereco.getCep());
		comandoSql.setString(7, endereco.getComplemento());
		comandoSql.setInt(8, endereco.getIdEndereco());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma endereco.
	 *  O <code>idEndereco</code> deve ser igual ao do endereco que deseja deletar
	 * @param int idEndereco
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void deleteId(int idEndereco) throws SQLException {
		String sql = "delete from endereco where idescola = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idEndereco);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar o endereco no banco de dados.
	 * O <code>idEndereco</code> deve ser igual ao do endereco que deseja buscar
	 * @param int idEndereco
	 * @return Endereco endereco
	 * @author Andrey
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
			endereco.setComplemento(resultSet.getString(8));
		}
		comandoSql.close();
		return endereco;
	}
	
	/**
	 * Metodo para selecionar todos os enderecos do banco de dados
	 * @return lista de enderecos registrados no banco 
	 * @author Andrey
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
			endereco.setComplemento(resultSet.getString(8));
			
			lista.add(endereco);
		}
		comandoSql.close();
		return lista;
	}
	
	/**
	 * Realiza o registro de um endereco no banco de dados
	 * e retorna o id registrado no banco de dados
	 * @param Endereco endereco
	 * @return int idEndereco
	 * @author Breno
	 * @throws SQLException 
	 */
	public int insertReturnID(Endereco endereco) throws SQLException {
		String sql = "insert into endereco (estado, cidade, bairro, rua, numero, cep, complemento) values (?,?,?,?,?,?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		     
		comandoSql.setString(1, endereco.getEstado());
		comandoSql.setString(2, endereco.getCidade());
		comandoSql.setString(3, endereco.getBairro());
		comandoSql.setString(4, endereco.getRua());
		comandoSql.setInt(5, endereco.getNumero());
		comandoSql.setString(6, endereco.getCep());
		comandoSql.setString(7, endereco.getComplemento());
		
		comandoSql.execute();
		
        ResultSet rs = comandoSql.getGeneratedKeys();
        rs.next();
        int idEndereco = rs.getInt(1);
		comandoSql.close(); 
		return idEndereco;
	}
	
	/**
	 * Metodo para selecionar o idEndereco no banco de dados.
	 * O objeto endereco ter os tributos iguais aos do banco de dados
	 * caso nao tenha nenhum enedereco igual sera retornado 0
	 * 
	 * @param Endereco endereco
	 * @return int idEndereco
	 * @author Andre
	 * @throws SQLException 
	 */
	public int buscarIgual(Endereco endereco) throws SQLException {
		int idEndereco = 0;
		String sql = "select idenereco from endereco where"
				+ "LOWER(estado)=LOWER(?) and LOWER(cidade)=LOWER(?)"
				+ "and LOWER(bairro)=LOWER(?) and LOWER(rua)=LOWER(?)"
				+ "and numero=? and LOWER(cep)=LOWER(?) and LOWER(complemento)=LOWER(?);";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setString(1, endereco.getEstado());
		comandoSql.setString(2, endereco.getCidade());
		comandoSql.setString(3, endereco.getBairro());
		comandoSql.setString(4, endereco.getRua());
		comandoSql.setInt(5, endereco.getNumero());
		comandoSql.setString(6, endereco.getCep());
		comandoSql.setString(7, endereco.getComplemento());
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			idEndereco = resultSet.getInt(1);
		}
		comandoSql.close();
		return idEndereco;
	}
	
}
