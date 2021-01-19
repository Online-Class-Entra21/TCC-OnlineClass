package entidade;

/**
 * Classe contendo metodos e atributos para o endere�o dos usu�rios cadastrados no sistema.
 * @see Usuario
 * @author Andrey 
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
     * Construtor padrao
     * @param
     */
    public Endereco() {
    	//Nenhum atributo inicializado
    }

    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idEndereco
     * @param estado
     * @param cidade
     * @param bairro
     * @param rua
     * @param numero
     * @param cep
     */
	public Endereco(int idEndereco, String estado, String cidade, String bairro, String rua, int numero, String cep) {
		setIdEndereco(idEndereco);
		setEstado(estado);
		setCidade(cidade);
		setBairro(bairro);
		setRua(rua);
		setNumero(numero);
		setCep(cep);
	}

	/**
     * Metodo de retorno do id endereco
     * @return idEndereco
     */
    public int getIdEndereco() {
		return idEndereco;
	}

    /**
     * Metodo de insercao do id endereco
     * @param idEndereco
     */
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	/** 
	 * Metodo para retorno do estado.
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo para insercao do estado 
     * @param estado
     */
    public void setEstado(String estado) {
        // TODO implement here
    	this.estado = estado;
    }

    /** 
     * Metodo para retorno da cidade.
     * @return cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Metodo para insercao da cidade 
     * @param cidade
     */
    public void setCidade(String cidade) {
        // TODO implement here
    	this.cidade = cidade;
    }

    /** 
     * Metodo para retorno do bairro
     * @return bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Metodo para insercao do bairro
     * @param bairro
     */
    public void setBairro(String bairro) {
        // TODO implement here
    	this.bairro = bairro;    	
    }

    /** 
     * Metodo para retorno da rua.
     * @return rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * Metodo para insercao da rua 
     * @param rua
     */
    public void setRua(String rua) {
        // TODO implement here
    	this.rua = rua;
    }

    /** 
     * Metodo para retorno do numero.
     * @return numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo para insercao do numero 
     * @param num
     */
    public void setNumero(int num) {
        // TODO implement here
    	this.numero = num;
    }

    /** 
     * Metodo para retorno do CEP.
     * @return cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Metodo para insercao do CEP
     * @param cep
     */
    public void setCep(String cep) {
    	this.cep = cep;
    }
}