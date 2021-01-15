package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Escola;

public class EscolaDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(Escola escola) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("insert into escola (nome, datainicioletivo, datafinalletivo) values (?,?,?)");
			
			comandoSql.setString(1, escola.getNome());
			comandoSql.setDate(2, (Date) escola.getDataInicioLetivo());
			comandoSql.setDate(3, (Date) escola.getDataFinalLetivo());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean update(Escola escola) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("update escola set nome = ?, datainicioletivo = ?, datafinalletivo = ? where idescola = ?");
			
			comandoSql.setString(1, escola.getNome());
			comandoSql.setDate(2, (Date) escola.getDataInicioLetivo());
			comandoSql.setDate(3, (Date) escola.getDataFinalLetivo());
			comandoSql.setInt(4, escola.getIdEscola());
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
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("delete from escola where idescola = ?");
			
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
	
	public Escola buscarId(int id) {
		Escola escola = new Escola();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola where idescola = ?");
			
			comandoSql.setInt(1, id);
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				escola.setIdEscola(resultSet.getInt(1));
				escola.setNome(resultSet.getString(2));
				escola.setDataInicioLeitvo(resultSet.getDate(3));
				escola.setDataFinalLetivo(resultSet.getDate(4));
				return escola;
			}
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Escola> buscarTodos() {
		List<Escola> lista = new ArrayList<Escola>();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola");
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				Escola escola = new Escola();
				escola.setIdEscola(resultSet.getInt(1));
				escola.setNome(resultSet.getString(2));
				escola.setDataInicioLeitvo(resultSet.getDate(3));
				escola.setDataFinalLetivo(resultSet.getDate(4));
				lista.add(escola);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	
	
	
}
