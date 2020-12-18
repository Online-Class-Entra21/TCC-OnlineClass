package Sistema;

import java.sql.Connection;
import java.util.*;

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
    
    /**
     * Default constructor
     */
    public Conexao() {
    }

    
    /** Método para retorno da conexão.
     * @return String - Conexão
     */
    public Connection getConexao() {
        return null;
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
    public void fecharConexao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void reniciarConexao() {
        // TODO implement here
    }

}