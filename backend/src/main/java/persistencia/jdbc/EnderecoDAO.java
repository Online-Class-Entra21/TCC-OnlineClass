package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Endereco;

public class EnderecoDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
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
	
	public boolean deleteID(int id) {
		
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
	
	public Endereco buscarId(int id) {
		Endereco endereco = new Endereco();
		
		String sql = "select * from Endereco where idendereco = ?";
		
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
