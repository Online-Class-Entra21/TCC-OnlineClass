package entidade;

/**
 * Classe contendo metodos e atributos para a sala de aula.
 * Local onde ocorre as reunioes
 * @see Reuniao
 * @author Breno 
 */
public class Sala {
	
    private int idSala;
    private String nome;
    private String descricao;
    private boolean situacaoAcesso;
    private boolean tipoSala;
    private String link;

    /**
     * Construtor padrao
     */
    public Sala() {
        //Nenhum atributo inicializado
    }

    /**
     * Metodo construtor que preenche todas os dados da tabela sala
     * @param idSala
     * @param nome
     * @param descricao
     * @param situacaoAcesso
     * @param tipoSala
     * @param link
     */
	public Sala(int idSala, String nome, String descricao, boolean situacaoAcesso, boolean tipoSala, String link) {
		setIdSala(idSala);
		setNome(nome);
		setDescricao(descricao);
		setSituacaoAcesso(situacaoAcesso);
		setTipoSala(tipoSala);
		setLink(link);
	}

	/** 
	 * Metodo para retorno do ID da sala
     * @return int idSala
     */
    public int getIdSala() {
        return idSala;
    }
    
    /**
     * M�todo de insercao do id da sala
     * @param int idSala
     */
    public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

    /** 
     * Metodo para retorno do nome da sala
     * @return String nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo de insercao do nome da sala
     * @param Stirng nome
     */
    public void setNome(String nome) {
		this.nome = nome;
	}
    
    /** 
     * Metodo para retorno da descricao da sala
     * @return String descricao
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Metodo de insercao da descricao da sala
     * @param String descricao
     */
    public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

    /** Metodo para retorno da situacao de acesso
     * @return boolean situacaoAcesso
     */
    public boolean getSituacaoAcesso() {
        return situacaoAcesso;
    }
    
    /**
     * Metodo de insercao da situacao de acesso da sala 
     * @param boolean situacaoAcesso
     */
    public void setSituacaoAcesso(boolean situacaoAcesso) {
		this.situacaoAcesso = situacaoAcesso;
	}

    /** Metodo para retorno do tipo da sala.
     * @return boolean tipoSala
     */
    public boolean getTipoSala() {
        return tipoSala;
    }
    
    /**
     * Metodo de insercao do tipo da sala 
     * @param boolean tipoSala
     */
    public void setTipoSala(boolean tipoSala) {
		this.tipoSala = tipoSala;
	}

    /** 
     * Metodo para retorno do link da reuniao
     * @return String link
     */
    public String getLink() {
        return link;
    }

    /**
     * Metodo de insercao do link da reuniao da sala 
     * @param String link
     */
    public void setLink(String link) {
		this.link = link;
	}
}