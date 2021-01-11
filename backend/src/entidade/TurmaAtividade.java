package entidade;

/**
 * Classe contendo m�todos e atributos para a liga��o da Turma com as Atividades.
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
     * M�todo construtor que preenche todas as informa��es da classe TurmaAtividade
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
     * M�todo de exibi��o dos atributos da classe 
     */
	@Override
	public String toString() {
		return "TurmaAtividade [idTurmaAtividade=" + idTurmaAtividade + ", turma=" + turma + ", atividade=" + atividade
				+ "]";
	}

	/** M�todo para retorno do ID da TurmaAtividade.
     * @return Int - ID TurmaAtividade
     */
	public int getIdTurmaAtividade() {
		return idTurmaAtividade;
	}
	
	/**
	 * M�todo de inser��o do idTurmaAtividade
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