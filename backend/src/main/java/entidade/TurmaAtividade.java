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

	/**
	 * Metodo para retorno do FK da turma 
	 * @return fk_turma 
	 */
	public int getFk_turma() {
		return fk_turma;
	}

	/**
	 * Metodo para insercao do FK da turma 
	 * @param fk_turma
	 */
	public void setFk_turma(int fk_turma) {
		this.fk_turma = fk_turma;
	}

	/**
	 * Metodo para retorno do FK da atividade 
	 * @return
	 */
	public int getFk_atividade() {
		return fk_atividade;
	}

	/**
	 * Metodo para insercao do FK da atividade 
	 * @param fk_atividade
	 */
	public void setFk_atividade(int fk_atividade) {
		this.fk_atividade = fk_atividade;
	} 
}