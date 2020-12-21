package entidade;

import java.util.*;

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


    /** Método para retorno do ID TurmaProfessorDisciplina
     * @return Int - TurmaProfessorDisciplina
     */
    public int getIdTurmaProfessorDisciplina() {
        return idTurmaProfessorDisciplina;
    }

    /**
     * 
     */
    public void setIdTurmaProfessorDisciplina() {
        // TODO implement here
    }

    /** Método para retorno da turma.
     * @return Turma - Turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * 
     */
    public void setTurma() {
        // TODO implement here
    }

    /** Método para retorno do professor da disciplina.
     * @return ProfessorDisciplina - ProfessorDisciplina
     */
    public ProfessorDisciplina getTurmaProfessorDisciplina() {
        return professorDisciplina;
    }

    /**
     * 
     */
    public void setTurmaProfessorDisciplina() {
        // TODO implement here
    }

}