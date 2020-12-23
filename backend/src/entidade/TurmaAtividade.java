package entidade;

/**
 * Classe contendo métodos e atributos para a ligação da Turma com as Atividades.
 * @see Turma
 * @see Atividade
 * @author
 */
public class TurmaAtividade {
    private int idTurmaAtividade;
    private int idTurma;
    private int idAtividade;
    
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
    public TurmaAtividade(int idTurmaAtividade, int idTurma, int idAtividade) {
		setIdTurmaAtividade(idTurmaAtividade);
		setFk_Turma(idTurma);
		setFk_Atividade(idAtividade);
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
    public int getFk_Turma() {
        return idTurma;
    }
    
    /**
     * Método de inserção do idTurma
     * @param idTurma
     */
	public void setFk_Turma(int idTurma) {
		this.idTurma = idTurma;
	}

    /** Método para retorno da atividade.
     * @return int - idAtividade
     */
    public int getFk_Atividade() {
        return idAtividade;
    }

    /**
     * Método de iserção da atividade 
     * @param idAtividade
     */
	public void setFk_Atividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}

}