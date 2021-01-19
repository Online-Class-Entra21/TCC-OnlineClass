package entidade;

import java.sql.Connection;
import java.sql.SQLException;

import persistencia.jdbc.ConexaoFactory;

/**
 * Classe com metodos e atributos para realizar a conexao com o Banco de Dados.
 * @author Breno
 */
public class Conexao {
	
	//Instancia a classe conexaoFactory 
    private ConexaoFactory conexaoFactory = new ConexaoFactory();

    
    /** Metodo para abrir a conexao.
     * @return conexao
     */
    public Connection getConexao() {
    	Connection conexao;
        conexao = conexaoFactory.getConnection();
        return conexao;
    }

    /**
     * Metodo para fechar a conexao
     * @param conexao
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