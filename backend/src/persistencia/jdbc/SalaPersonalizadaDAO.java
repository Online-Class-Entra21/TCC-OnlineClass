package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidade.SalaPersonalizada;

public class SalaPersonalizadaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma Sala Personalizada no banco de dados
	 * @param sala
	 * @return
	 */
	public boolean insert(SalaPersonalizada salaPersonalizada) {
		
		String sql = "insert into salaPersonalizada (dono, fk_sala) values (?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, salaPersonalizada.getDono());
			comandoSql.setInt(2, salaPersonalizada.getFk_sala());
			
			comandoSql.execute(); 
			
			comandoSql.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		return true; 
	}
}
