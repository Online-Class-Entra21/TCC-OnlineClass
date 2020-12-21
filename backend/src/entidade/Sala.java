package entidade;

/**
 * Classe contendo métodos e atributos para a sala de aula.
 * Local onde ocorre as reuniões
 * @see Reuniao
 * @author 
 */
public class Sala {
    private int idSala;
    private String nome;
    private String descricao;
    private boolean situacaoAcesso;
    private boolean tipoSala;
    private String link;

    /**
     * Construtor usado ao instanciar a classe Sala.
     * @param
     */
    public Sala() {
    }

    /**
     * Método construtor que preenche todas os dados da tabela sala
     * @param nome
     * @param descricao
     * @param situacaoAcesso
     * @param tipoSala
     * @param link
     */
	public Sala(String nome, String descricao, boolean situacaoAcesso, boolean tipoSala, String link) {
		setNome(nome);
		setDescricao(descricao);
		setSituacaoAcesso(situacaoAcesso);
		setTipoSala(tipoSala);
		setLink(link);
	}
	
	/**
	 * Método de exbição de dados da classe
	 */
	@Override
	public String toString() {
		return "Sala [idSala=" + idSala + ", nome=" + nome + ", descricao=" + descricao + ", situacaoAcesso="
				+ situacaoAcesso + ", tipoSala=" + tipoSala + ", link=" + link + "]";
	}

	/** Método para retorno do ID da sala.
     * @return Int - ID da sala
     */
    public int getIdSala() {
        return idSala;
    }

    /** Método para retorno do nome da sala.
     * @return String - Nome da sala
     */
    public String getNome() {
        return nome;
    }

    /** Método para retorno da descrição da sala.
     * @return String - Descrição da sala
     */
    public String getDescricao() {
        return descricao;
    }

    /** Método para retorno da situação de acesso.
     * @return Boolean - Permitida a entrada? True / False
     */
    public boolean getSituacaoAcesso() {
        return situacaoAcesso;
    }

    /** Método para retorno do tipo da sala.
     * @return Boolean - True para sala padrão / False para sala personalizada
     */
    public boolean getTipoSala() {
        return tipoSala;
    }

    /** Método para retorno do link da reunião.
     * @return String - Link da reunião
     */
    public String getLink() {
        return link;
    }

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setSituacaoAcesso(boolean situacaoAcesso) {
		this.situacaoAcesso = situacaoAcesso;
	}

	public void setTipoSala(boolean tipoSala) {
		this.tipoSala = tipoSala;
	}

	public void setLink(String link) {
		this.link = link;
	}
}