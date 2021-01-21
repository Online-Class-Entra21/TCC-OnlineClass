package entidade;

/**
 * Classe contando metodos e atributos para a ligacao do Professor e sua Disciplina e Turma.
 * @see UsuarioDisciplina
 * @see Turma
 * @author Breno 
 */
public class TurmaUsuarioDisciplina {
	
    private int idTurmaUsuarioDisciplina;
    private int fk_turma;
    private int fk_usuariorDisciplina;
    
    /**
     * Construtor padrao
     * @param
     */
    public TurmaUsuarioDisciplina() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idTurmaUsuarioDisciplina
     * @param fk_turma
     * @param fk_usuariorDisciplina
     */
	public TurmaUsuarioDisciplina(int idTurmaUsuarioDisciplina, int fk_turma, int fk_usuariorDisciplina) {
	
		setIdTurmaUsuarioDisciplina(idTurmaUsuarioDisciplina);
		setFk_turma(fk_turma);
		setFk_usuariorDisciplina(fk_usuariorDisciplina);
	}

	/** 
	 * Metodo para retorno do ID TurmaUsuarioDisciplina
     * @return idTurmaUsuarioDisciplina 
     */
    public int getIdTurmaUsuarioDisciplina() {
        return idTurmaUsuarioDisciplina;
    }

    /**
     * Metodo de insercao do id da turmaUsuarioDisciplina
     * @param idTurmaUsuarioDisciplina
     */
    public void setIdTurmaUsuarioDisciplina(int idTurmaUsuarioDisciplina) {
		this.idTurmaUsuarioDisciplina = idTurmaUsuarioDisciplina;
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
	 * Metodo para retorno do FK do usuarioDisciplina 
	 * @return
	 */
	public int getFk_usuariorDisciplina() {
		return fk_usuariorDisciplina;
	}

	/**
	 * Metodo para insercao do FK do usuarioDisciplina 
	 * @param fk_usuariorDisciplina
	 */
	public void setFk_usuariorDisciplina(int fk_usuariorDisciplina) {
		this.fk_usuariorDisciplina = fk_usuariorDisciplina;
	}
}