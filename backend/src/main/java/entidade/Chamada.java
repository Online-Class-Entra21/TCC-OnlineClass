package entidade;

/**
 * Classe contendo metodos e atributos para realizar 
 * a chamada dos alunos na reuniao.
 * @author André 
 */
public class Chamada {
    private int idChamada;
    private boolean situacao;
    private int fk_aluno;
    private int fk_reuniao;

    /**
     * Construtor padrao
     */
    public Chamada() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo que preenche todos os atributos da classe chamada 
     * @param idChamada
     * @param situacao
     * @param fk_aluno
     * @param fk_reuniao
     */
    public Chamada(int idChamada, boolean situacao, int fk_aluno, int fk_reuniao) {
		this.idChamada = idChamada;
		this.situacao = situacao;
		this.fk_aluno = fk_aluno;
		this.fk_reuniao = fk_reuniao;
	}

	/** 
	 * Metodo para retorno do ID da chamada.
     * @return idChamada 
     */
    public int getIdChamada() {
        return idChamada;
    }

    /**
     * Metodo de insercao do id da chamada 
     * @param idChamada
     */
    public void setIdChamada(int idChamada) {
        this.idChamada = idChamada;
    }

    /** 
     * Metodo para retorno da situacao da chamada.
     * @return situacao
     */
    public boolean getSituacao() {
        return situacao;
    }

    /**
     * Metodo de insercao da situacao da chamada 
     * @param situacao
     */
    public void setSituacao(boolean situacao) {
    	this.situacao = situacao;
    }

    /** 
     * Metodo para retorno do FK do aluno.
     * @return fk_aluno
     */
    public int getFk_aluno() {
		return fk_aluno;
	}

    /**
     * Metodo para insercao do FK do aluno 
     * @param fk_aluno
     */
    public void setFk_aluno(int fk_aluno) {
		this.fk_aluno = fk_aluno;
	}

	/**
	 * Metodo para retorno do FK da reuniao  
	 * @return
	 */
	public int getFk_reuniao() {
		return fk_reuniao;
	}

	/**
	 * Metodo para insercao do FK da reuniao 
	 * @param fk_reuniao
	 */
	public void setFk_reuniao(int fk_reuniao) {
		this.fk_reuniao = fk_reuniao;
	}
}