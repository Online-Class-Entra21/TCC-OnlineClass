package entidade;

/**
 * Classe contendo metodos e atributos para o endere�o dos usuarios cadastrados no sistema
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
     * Metodo de retorno do ID endereco
     * @return int idEndereco
     */
    public int getIdEndereco() {
		return idEndereco;
	}

    /**
     * Metodo de insercao do ID endereco
     * @param int idEndereco
     */
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	/** 
	 * Metodo para retorno do estado
     * @return String estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo para insercao do estado 
     * @param String estado
     */
    public void setEstado(String estado) {
    	this.estado = estado;
    }

    /** 
     * Metodo para retorno da cidade
     * @return String cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Metodo para insercao da cidade 
     * @param String cidade
     */
    public void setCidade(String cidade) {
    	this.cidade = cidade;
    }

    /** 
     * Metodo para retorno do bairro
     * @return String bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Metodo para insercao do bairro
     * @param String bairro
     */
    public void setBairro(String bairro) {
    	this.bairro = bairro;    	
    }

    /** 
     * Metodo para retorno da rua
     * @return String rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * Metodo para insercao da rua 
     * @param String rua
     */
    public void setRua(String rua) {
    	this.rua = rua;
    }

    /** 
     * Metodo para retorno do numero
     * @return String numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Metodo para insercao do numero 
     * @param String numero
     */
    public void setNumero(int numero) {
    	this.numero = numero;
    }

    /** 
     * Metodo para retorno do cep
     * @return String cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Metodo para insercao do cep
     * @param String cep
     */
    public void setCep(String cep) {
    	this.cep = cep;
    }
}