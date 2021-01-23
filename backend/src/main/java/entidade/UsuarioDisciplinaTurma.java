package entidade;

/**
 * Classe contando metodos e atributos para a ligacao do Professor e sua Disciplina e Turma
 * @see UsuarioDisciplina
 * @see Turma
 * @author Breno 
 */
public class UsuarioDisciplinaTurma {
	
    private int idUsuarioDisciplinaTurma;
    private int fk_turma;
    private int fk_usuariorDisciplina;
    
    /**
     * Construtor padrao
     */
    public UsuarioDisciplinaTurma() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idUsuarioDisciplinaTurma
     * @param fk_turma
     * @param fk_usuariorDisciplina
     */
	public UsuarioDisciplinaTurma(int idUsuarioDisciplinaTurma, int fk_turma, int fk_usuariorDisciplina) {
		setIdUsuarioDisciplinaTurma(idUsuarioDisciplinaTurma);
		setFk_turma(fk_turma);
		setFk_usuariorDisciplina(fk_usuariorDisciplina);
	}

	/** 
	 * Metodo para retorno do ID usuarioDisciplinaTurma
     * @return int idUsuarioDisciplinaTurma
     */
    public int getIdUsuarioDisciplinaTurma() {
        return idUsuarioDisciplinaTurma;
    }

    /**
     * Metodo de insercao do id da usuarioDisciplinaTurma
     * @param int idUsuarioDisciplinaTurma
     */
    public void setIdUsuarioDisciplinaTurma(int idUsuarioDisciplinaTurma) {
		this.idUsuarioDisciplinaTurma = idUsuarioDisciplinaTurma;
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
	 * Metodo para retorno do FK do usuarioDisciplina 
	 * @return int fk_usuarioDisciplina 
	 */
	public int getFk_usuariorDisciplina() {
		return fk_usuariorDisciplina;
	}

	/**
	 * Metodo para insercao do FK do usuarioDisciplina 
	 * @param int fk_usuariorDisciplina
	 */
	public void setFk_usuariorDisciplina(int fk_usuariorDisciplina) {
		this.fk_usuariorDisciplina = fk_usuariorDisciplina;
	}
}