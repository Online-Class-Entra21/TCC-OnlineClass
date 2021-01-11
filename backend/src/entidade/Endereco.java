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
    public void setEstado(String estado) {
        // TODO implement here
    	this.estado = estado;
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
    public void setCidade(String cidade) {
        // TODO implement here
    	this.cidade = cidade;
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
    public void setBairro(String bairro) {
        // TODO implement here
    	this.bairro = bairro;    	
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
    public void setRua(String rua) {
        // TODO implement here
    	this.rua = rua;
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
    public void setNumero(int num) {
        // TODO implement here
    	this.numero = num;
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
    public void setCep(String cep) {
        // TODO implement here
    	this.cep = cep;
    }

}