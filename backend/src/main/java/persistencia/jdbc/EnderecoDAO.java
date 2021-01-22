package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Endereco;

public class EnderecoDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir Endereco no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>Endereco</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */
	public boolean insert(Endereco endereco) {
		
		String sql = "insert into endereco (estado, cidade, bairro, rua, numero, cep) values (?,?,?,?,?,?).";
		
		try {
			
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
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * Metodo para atualizar uma Endereco no banco de dados.
	 * 
	 * O id da <code>Endereco</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param <code>Endereco</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */ 	
	public boolean update(Endereco endereco) {
		
		String sql = "update escola set estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, cep = ? where idendereco = ?";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setString(1, endereco.getEstado());
			comandoSql.setString(2, endereco.getCidade());
			comandoSql.setString(3, endereco.getBairro());
			comandoSql.setString(4, endereco.getRua());
			comandoSql.setInt(5, endereco.getNumero());
			comandoSql.setString(6, endereco.getCep());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma Endereco
	 *  <p>
	 *  O <code>idEndereco</code> deve ser igual ao id do banco de dados
	 * 
	 * @param <code>Endereco</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */
	public boolean deleteId(int id) {
		
		String sql = "delete from endereco where idescola = ?";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, id);
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Metodo para selecionar <code>Endereco</code> no banco de dados
	 * <p>
	 * O <code>idEndereco</code> deve ser igual a Endereco que deseja selecionar
	 * 
	 * @param <code>idEndereco<code>
	 * @return Endereco
	 * @author Andre
	 */
	public Endereco buscarId(int id) {
		Endereco endereco = new Endereco();
		
		String sql = "select * from Endereco where idEndereco = ?";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, id);
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				endereco.setIdEndereco(resultSet.getInt(1));
				endereco.setEstado(resultSet.getString(2));
				endereco.setCidade(resultSet.getString(3));
				endereco.setBairro(resultSet.getString(4));
				endereco.setRua(resultSet.getString(5));
				endereco.setNumero(resultSet.getInt(6));
				endereco.setCep(resultSet.getString(7));
				return endereco;
			}
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo para selecionar todos os <code>Endereco</code> do banco de dados
	 * 
	 * @return <code>List</code>
	 * @author Andre
	 */
	public List<Endereco> buscarTodos() {
		List<Endereco> lista = new ArrayList<Endereco>();
		
		String sql = "select * from Endereco";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
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
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
}
