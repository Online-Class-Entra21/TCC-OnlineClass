package entidade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import persistencia.jdbc.ConexaoFactory;

/**
 * Classe com m�todos e atributos para realizar a conex�o com o Banco de Dados.
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

    
    /** M�todo para retorno da conex�o.
     * @return String - Conex�o
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