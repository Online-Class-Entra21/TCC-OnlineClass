package entidade;

/**
 * Classe contendo métodos e atributos para o endereço dos usuários cadastrados no sistema.
 * @see Usuario
 * @author 
 */
public class Endereco {
	private int idEndereco;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String cep;
    
    /**
     * Construtor usado ao instanciar a classe Endereco.
     * @param
     */
    public Endereco() {
    }

    /**
     * Método de retorno do id endereço
     * @return
     */
    public int getIdEndereco() {
		return idEndereco;
	}

    /**
     * Método de inserção do id endereço
     * @param idEndereco
     */
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	/** Método para retorno do estado.
     * @return String - Estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * 
     */
    public void setEstado() {
        // TODO implement here
    }

    /** Método para retorno da cidade.
     * @return String - Cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * 
     */
    public void setCidade() {
        // TODO implement here
    }

    /** Método para retorno do bairro.
     * @return String - Bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * 
     */
    public void setBairro() {
        // TODO implement here
    }

    /** Método para retorno da rua.
     * @return String - Rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * 
     */
    public void setRua() {
        // TODO implement here
    }

    /** Método para retorno do número.
     * @return Int - Número
     */
    public int getNumero() {
        return numero;
    }

    /**
     * 
     */
    public void setNumero() {
        // TODO implement here
    }

    /** Método para retorno do CEP.
     * @return String - CEP
     */
    public String getCep() {
        return cep;
    }

    /**
     * 
     */
    public void setCep() {
        // TODO implement here
    }

}