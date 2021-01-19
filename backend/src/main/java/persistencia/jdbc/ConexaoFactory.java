package persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
	
	private Connection conexao = null;
	
	public Connection getConnection() {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			if (conexao == null) {
				conexao = DriverManager.getConnection("jdbc:postgresql://201.3.251.238:5432/OnlineClassBD", "postgres","adm123");
			}
			return conexao;
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return null;
	}

}
