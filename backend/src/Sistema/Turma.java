package Sistema;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo métodos e atributos para a turma.
 * As turmas possuem alunos, e cada uma tem uma sala como padrão.
 * @see Aluno
 * @see SalaPadrao
 * @author 
 */
public class Turma {
    private int idTurma;
    private String ano;
    private int qtdAluno;
    private Time horarioInicioAula;
    private Time horarioFinalAula;
    private Aluno alunos[];
    private SalaPadrao salaPadrao;
    
    /**
     * Construtor usado ao instanciar a classe Turma.
     * @param
     */
    public Turma() {
    }


    /** Método para retorno do ID da turma.
     * @return Int - ID da turma
     */
    public int getIdTurma() {
        return idTurma;
    }

    /**
     * 
     */
    public void setIdTurma() {
        // TODO implement here
    }

    /** Método para retorno do ano da turma.
     * @return String - Ano da turma
     */
    public String getAno() {
        return ano;
    }

    /**
     * 
     */
    public void setAno() {
        // TODO implement here
    }

    /** Método para retorno da quantidade de alunos na turma.
     * @return Int - Quantidade de alunos na turma
     */
    public int getQtdAluno() {
        return qtdAluno;
    }

    /**
     * 
     */
    public void setQtdAluno() {
        // TODO implement here
    }

    /** Método para retorno do horário inicial da aula.
     * @return Time - Horário inicial da aula
     */
    public Time getHorarioInicioAula() {
        return horarioInicioAula;
    }

    /**
     * 
     */
    public void setHorarioInicioAula() {
        // TODO implement here
    }

    /** Método para retorno do horário final da aula.
     * @return Time - Horário final da aula
     */
    public Time getHorarioFinalAula() {
        return horarioFinalAula;
    }

    /**
     * 
     */
    public void setHorarioFinalAula() {
        // TODO implement here
    }

    /** Método para retorno dos alunos na turma.
     * @return Aluno - Array de alunos
     */
    public Aluno[] getAlunos() {
        return alunos;
    }

    /**
     * 
     */
    public void pesquisarAluno() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setAluno() {
        // TODO implement here
    }

    /** Método para retorno da sala padrão da turma.
     * @return SalaPadrao - SalaPadrao da turma
     */
    public SalaPadrao getSalaPadrao() {
        return salaPadrao;
    }

    /**
     * 
     */
    public void setSalaPadrao() {
        // TODO implement here
    }

}