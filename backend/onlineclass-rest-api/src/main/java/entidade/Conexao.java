package entidade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import persistencia.jdbc.ConexaoFactory;

/**
 * Classe com métodos e atributos para realizar a conexão com o Banco de Dados.
 * @author
 */
public class Conexao {
    private String status;
    private String driveNome;
    private String serveNome;
    private String nomeDatabase;
    private String url;
    private String userNome;
    private String password;
    private ConexaoFactory conexaoFactory = new ConexaoFactory();
    /**
     * Default constructor
     */
    public Conexao() {
    }

    
    /** Método para retorno da conexão.
     * @return String - Conexão
     */
    public Connection getConexao() {
    	Connection conexao;
        conexao = conexaoFactory.getConnection();
        return conexao;
    }

    /**
     * 
     */
    public void statusConexao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void fecharConexao(Connection conexao) {
        conexao = conexaoFactory.getConnection();
        try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}