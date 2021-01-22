package entidade;

/**
 * Classe contendo metodos e atributos para a ligacao da Turma com as Atividades
 * @see Turma
 * @see Atividade
 * @author Breno 
 */
public class TurmaAtividade {
	
    private int idTurmaAtividade;
    private int fk_turma;
    private int fk_atividade;
    
    /**
     * Construtor padrao
     */
    public TurmaAtividade() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idTurmaAtividade
     * @param fk_turma
     * @param fk_atividade
     */
	public TurmaAtividade(int idTurmaAtividade, int fk_turma, int fk_atividade) {
		setIdTurmaAtividade(idTurmaAtividade);
		setFk_turma(fk_turma);
		setFk_atividade(fk_atividade);
	}

	/** 
	 * Metodo para retorno do ID da TurmaAtividade
     * @return int idTurmaAtividade 
     */
	public int getIdTurmaAtividade() {
		return idTurmaAtividade;
	}
	
	/**
	 * Metodo de insercao do idTurmaAtividade
	 * @param int idTurmaAtividade
	 */
	public void setIdTurmaAtividade(int idTurmaAtividade) {
		this.idTurmaAtividade = idTurmaAtividade;
	}

	/**
	 * Metodo para retorno do FK da turma 
	 * @return int fk_turma 
	 */
	public int getFk_turma() {
		return fk_turma;
	}

	/**
	 * Metodo para insercao do FK da turma 
	 * @param int fk_turma
	 */
	public void setFk_turma(int fk_turma) {
		this.fk_turma = fk_turma;
	}

	/**
	 * Metodo para retorno do FK da atividade 
	 * @return int fk_atividade 
	 */
	public int getFk_atividade() {
		return fk_atividade;
	}

	/**
	 * Metodo para insercao do FK da atividade 
	 * @param int fk_atividade
	 */
	public void setFk_atividade(int fk_atividade) {
		this.fk_atividade = fk_atividade;
	} 
}