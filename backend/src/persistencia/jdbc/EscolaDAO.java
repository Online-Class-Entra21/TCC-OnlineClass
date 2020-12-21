package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

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
	
	
	
	
	
	
}
