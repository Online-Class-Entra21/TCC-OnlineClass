package entidade;

/**
 * Classe contendo metodos e atributos para a ligacao da Turma com as Atividades.
 * @see Turma
 * @see Atividade
 * @author Breno 
 */
public class TurmaAtividade {
    private int idTurmaAtividade;
    private Turma turma;
    private Atividade atividade;
    
    /**
     * Construtor padrao
     * @param
     */
    public TurmaAtividade() {
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe
     * @param idTurmaAtividade
     * @param idTurma
     * @param idAtividade
     */
    public TurmaAtividade(int idTurmaAtividade, Turma turma, Atividade atividade) {
		setIdTurmaAtividade(idTurmaAtividade);
		setTurma(turma);
		setAtividade(atividade);
	}

	/** 
	 * Metodo para retorno do ID da TurmaAtividade
     * @return idTurmaAtividade 
     */
	public int getIdTurmaAtividade() {
		return idTurmaAtividade;
	}
	
	/**
	 * Metodo de insercao do idTurmaAtividade
	 * @param idTurmaAtividade
	 */
	public void setIdTurmaAtividade(int idTurmaAtividade) {
		this.idTurmaAtividade = idTurmaAtividade;
	}

    /** M�todo para retorno do ID da turma.
     * @return Int - ID da turma
     */
    public Turma getTurma() {
        return turma;
    }
    
    /**
     * M�todo de inser��o do idTurma
     * @param idTurma
     */
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

    /** M�todo para retorno da atividade.
     * @return int - idAtividade
     */
    public Atividade getAtividade() {
        return atividade;
    }

    /**
     * M�todo de iser��o da atividade 
     * @param idAtividade
     */
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}