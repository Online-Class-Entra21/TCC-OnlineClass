package entidade;

/**
 * Classe conténdo métodos e atributos para a ligação do Professor e sua Disciplina à Turma.
 * @see ProfessorDisciplina
 * @see Turma
 * @author
 */
public class TurmaProfessorDisciplina {
	
    private int idTurmaProfessorDisciplina;
    private Turma turma;
    private ProfessorDisciplina professorDisciplina;
    
    /**
     * Construtor usado ao instanciar a classe TurmaProfessorDisciplina.
     * @param
     */
    public TurmaProfessorDisciplina() {
    }
    
    /**
     * Método construtor que preenche todos os atributos da classe 
     * @param idTurmaProfessorDisciplina
     * @param turma
     * @param professorDisciplina
     */
    public TurmaProfessorDisciplina(ProfessorDisciplina professorDisciplina, Turma turma) {
		setProfessorDisciplina(professorDisciplina);
		setTurma(turma);
	}
    
	/** Método para retorno do ID TurmaProfessorDisciplina
     * @return Int - TurmaProfessorDisciplina
     */
    public int getIdTurmaProfessorDisciplina() {
        return idTurmaProfessorDisciplina;
    }

    /**
     * Método de inserção do id da turmaProfessorDisciplina
     * @param idTurmaProfessorDisciplina
     */
    public void setIdTurmaProfessorDisciplina(int idTurmaProfessorDisciplina) {
		this.idTurmaProfessorDisciplina = idTurmaProfessorDisciplina;
	}

    /** Método para retorno da turma.
     * @return Turma - Turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * Método de inserção da turma 
     * @param turma
     */
    public void setTurma(Turma turma) {
		this.turma = turma;
	}

    /** Método para retorno do professor da disciplina.
     * @return ProfessorDisciplina - ProfessorDisciplina
     */
    public ProfessorDisciplina getProfessorDisciplina() {
        return professorDisciplina;
    }

    /**
     * Método de inserção do PorfessorDisciplina
     * @param professorDisciplina
     */
    public void setProfessorDisciplina(ProfessorDisciplina professorDisciplina) {
		this.professorDisciplina = professorDisciplina;
	}
}