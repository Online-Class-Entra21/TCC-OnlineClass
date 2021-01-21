package entidade;

import java.sql.Connection;
import java.sql.SQLException;

import persistencia.jdbc.ConexaoFactory;

/**
 * Classe com metodos e atributos para realizar a conexao com o Banco de Dados.
 * @author
 */
public class Conexao {
	
    private ConexaoFactory conexaoFactory = new ConexaoFactory();
    
    /**
     * Construtor padrao
     */
    public Conexao() {
    	//Nenhum atributo inicializado
    }
    
    /** 
     * Metodo para retorno da conexao.
     * @return conexao
     */
    @SuppressWarnings("static-access")
	public Connection getConexao() {
    	Connection conexao;
        conexao = conexaoFactory.getConnection();
        return conexao;
    }

    /**
     * Metodo para fechar a conexao com o Banco de Dados 
     * @param conexao
     */
    @SuppressWarnings("static-access")
	public void fecharConexao(Connection conexao) {
        conexao = conexaoFactory.getConnection();
        try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}