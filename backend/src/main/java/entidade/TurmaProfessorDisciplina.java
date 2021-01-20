package entidade;

/**
 * Classe cont�ndo m�todos e atributos para a liga��o do Professor e sua Disciplina � Turma.
 * @see UsuarioDisciplina
 * @see Turma
 * @author
 */
public class TurmaProfessorDisciplina {
	
    private int idTurmaProfessorDisciplina;
    private Turma turma;
    private UsuarioDisciplina professorDisciplina;
    
    /**
     * Construtor usado ao instanciar a classe TurmaProfessorDisciplina.
     * @param
     */
    public TurmaProfessorDisciplina() {
    }
    
    /**
     * M�todo construtor que preenche todos os atributos da classe 
     * @param idTurmaProfessorDisciplina
     * @param turma
     * @param professorDisciplina
     */
    public TurmaProfessorDisciplina(UsuarioDisciplina professorDisciplina, Turma turma) {
		setProfessorDisciplina(professorDisciplina);
		setTurma(turma);
	}
    
	/** M�todo para retorno do ID TurmaProfessorDisciplina
     * @return Int - TurmaProfessorDisciplina
     */
    public int getIdTurmaProfessorDisciplina() {
        return idTurmaProfessorDisciplina;
    }

    /**
     * M�todo de inser��o do id da turmaProfessorDisciplina
     * @param idTurmaProfessorDisciplina
     */
    public void setIdTurmaProfessorDisciplina(int idTurmaProfessorDisciplina) {
		this.idTurmaProfessorDisciplina = idTurmaProfessorDisciplina;
	}

    /** M�todo para retorno da turma.
     * @return Turma - Turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * M�todo de inser��o da turma 
     * @param turma
     */
    public void setTurma(Turma turma) {
		this.turma = turma;
	}

    /** M�todo para retorno do professor da disciplina.
     * @return ProfessorDisciplina - ProfessorDisciplina
     */
    public UsuarioDisciplina getProfessorDisciplina() {
        return professorDisciplina;
    }

    /**
     * M�todo de inser��o do PorfessorDisciplina
     * @param professorDisciplina
     */
    public void setProfessorDisciplina(UsuarioDisciplina professorDisciplina) {
		this.professorDisciplina = professorDisciplina;
	}
}