package entidade;

/**
 * Classe contendo métodos e atributos para a ligação da Turma com as Atividades.
 * @see Turma
 * @see Atividade
 * @author
 */
public class TurmaAtividade {
    private int idTurmaAtividade;
    private Turma turma;
    private Atividade atividade;
    
    /**
     * Construtor usado ao instanciar a classe TurmaAtividade.
     * @param
     */
    public TurmaAtividade() {
    }
    
    /**
     * Método construtor que preenche todas as informações da classe TurmaAtividade
     * @param idTurmaAtividade
     * @param idTurma
     * @param idAtividade
     */
    public TurmaAtividade(int idTurmaAtividade, Turma turma, Atividade atividade) {
		setIdTurmaAtividade(idTurmaAtividade);
		setTurma(turma);
		setAtividade(atividade);
	}

	/** Método para retorno do ID da TurmaAtividade.
     * @return Int - ID TurmaAtividade
     */
	public int getIdTurmaAtividade() {
		return idTurmaAtividade;
	}
	
	/**
	 * Método de inserção do idTurmaAtividade
	 * @param idTurmaAtividade
	 */
	public void setIdTurmaAtividade(int idTurmaAtividade) {
		this.idTurmaAtividade = idTurmaAtividade;
	}

    /** Método para retorno do ID da turma.
     * @return Int - ID da turma
     */
    public Turma getTurma() {
        return turma;
    }
    
    /**
     * Método de inserção do idTurma
     * @param idTurma
     */
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

    /** Método para retorno da atividade.
     * @return int - idAtividade
     */
    public Atividade getAtividade() {
        return atividade;
    }

    /**
     * Método de iserção da atividade 
     * @param idAtividade
     */
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}