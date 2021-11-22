package persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Estabelece a conexão com o banco de dados 
 * @author Breno
 *
 */
@Component
public class ConexaoFactory {
	
	private static Connection conexao = null;
	private static String ip;
	private static String porta;
	private static String database;
	private static String login;
	private static String senha;
	
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			
			if (conexao == null) {
				conexao = DriverManager.getConnection("jdbc:postgresql://"+ip+":"+porta+"/"+database+"", login,senha);
			}
			return conexao;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	
	public static void setConfiguracaoDB(String ipDB, String portaDB, String databaseDB, String loginDB, String senhaDB) {
		ip = ipDB;
		porta = portaDB;
		database = databaseDB;
		login = loginDB;
		senha = senhaDB;
	}
}
