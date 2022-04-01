package persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import backend.api.persistencia.configuration.PostgresConfi;

/**
 * Estabelece a conexão com o banco de dados 
 * @author Breno
 *
 */
@Configuration
public class ConexaoFactory {
	
	private Connection conexao = null;
	private static ConexaoFactory conexaoFactory; 	
	
	private PostgresConfi postgresConfi;
	
	public static ConexaoFactory getInstance() {
		if(conexaoFactory == null) {
			conexaoFactory = new ConexaoFactory();
		}
		return conexaoFactory;
	}
	
	public Connection getConexao() {
		try {
			Class.forName("org.postgresql.Driver");
			
			if (conexao == null) {
				conexao = DriverManager.getConnection("jdbc:postgresql://"+postgresConfi.getIp()+":"+postgresConfi.getPorta()+"/"+postgresConfi.getDatabase(), postgresConfi.getLogin(),postgresConfi.getSenha());
			}
			return conexao;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}
	
	public static Connection getConnection() {
		return getInstance().getConexao();		
	}

	public void setPostgresConfi(PostgresConfi postgresConfi) {
		this.postgresConfi = postgresConfi;
	}
	
}
