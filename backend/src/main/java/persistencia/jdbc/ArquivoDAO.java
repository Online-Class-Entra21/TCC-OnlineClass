package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Arquivo;

public class ArquivoDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(Arquivo arquivo) {
		String sql = "insert into arquivo (extensao, dataenvio, remetente, arquivo) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, arquivo.getExtensao());
			comandoSql.setDate(2, (Date) arquivo.getDataEnvio());
			comandoSql.setInt(3, arquivo.getRemetente());
			comandoSql.setBytes(4, arquivo.getArquivo());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;	
	}
	
	public boolean update(Arquivo arquivo) {
		String sql = "update arquivo set extensao = ?, dataenvio = ?, remetente = ?, arquivo = ? where idarquivo = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, arquivo.getExtensao());
			comandoSql.setDate(2, (Date) arquivo.getDataEnvio());
			comandoSql.setInt(3, arquivo.getRemetente());
			comandoSql.setBytes(4, arquivo.getArquivo());
			comandoSql.setInt(5, arquivo.getIdArquivo());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	public boolean delete(int idArquivo) {
		String sql = "delete from arquivo where idarquivo = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idArquivo);
			
			comandoSql.execute();
			comandoSql.close();
		
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	 
	public Arquivo buscarId(int idArquivo) {
		Arquivo arquivo = new Arquivo();
		
		String sql = "select * from arquivo where idarquivo = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idArquivo);
			
			ResultSet resultSet = comandoSql.executeQuery();
			if (resultSet.next()) {
				arquivo.setIdArquivo(resultSet.getInt(1));
				arquivo.setExtensao(resultSet.getString(2));
				arquivo.setDataEnvio(resultSet.getDate(3));
				arquivo.setRemetente(resultSet.getInt(4));
				arquivo.setArquivo(resultSet.getBytes(5));
			
			}
			comandoSql.close();
			return arquivo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	public List<Arquivo> buscarTodos() {
		Arquivo arquivo = new Arquivo(); 
		List<Arquivo> lista =  new ArrayList<Arquivo>();
		
		String sql = "select * from arquivo";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			ResultSet resultSet = comandoSql.executeQuery();
			
			while (resultSet.next()) {
				arquivo.setIdArquivo(resultSet.getInt(1));
				arquivo.setExtensao(resultSet.getString(2));
				arquivo.setDataEnvio(resultSet.getDate(3));
				arquivo.setRemetente(resultSet.getInt(4));
				arquivo.setArquivo(resultSet.getBytes(5));

			lista.add(arquivo);
			}
			comandoSql.close();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
