package entidade;

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

    /**
     * Método de construção que preenche todas as informações relevantes 
     * ao inicio da criação da turma 
     * @param idTurma
     * @param ano
     * @param qtdAluno
     * @param horarioInicioAula
     * @param horarioFinalAula
     * @param alunos
     * @param salaPadrao
     */
    public Turma(int idTurma, String ano, int qtdAluno, Time horarioInicioAula, Time horarioFinalAula, 
    			 Aluno[] alunos, SalaPadrao salaPadrao) {
		setIdTurma(idTurma);
		setAno(ano);
		setQtdAluno(qtdAluno);
		setHorarioInicioAula(horarioInicioAula);
		setHorarioFinalAula(horarioFinalAula);
		setSalaPadrao(salaPadrao);
	}



	/** Método para retorno do ID da turma.
     * @return Int - ID da turma
     */
    public int getIdTurma() {
        return idTurma;
    }
    
    /**
     * Método de inserção do id da turma 
     * @param idTurma
     */
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

    /** Método para retorno do ano da turma.
     * @return String - Ano da turma
     */
    public String getAno() {
        return ano;
    }
    
    /**
     * Método de inserção do ano 
     * @param ano
     */
    public void setAno(String ano) {
		this.ano = ano;
	}


    /** Método para retorno da quantidade de alunos na turma.
     * @return Int - Quantidade de alunos na turma
     */
    public int getQtdAluno() {
        return qtdAluno;
    }
    
    /**
     * Método de inserção da quantidade de alunos da turma
     * @param qtdAluno
     */
    public void setQtdAluno(int qtdAluno) {
		this.qtdAluno = qtdAluno;
	}

    /** Método para retorno do horário inicial da aula.
     * @return Time - Horário inicial da aula
     */
    public Time getHorarioInicioAula() {
        return horarioInicioAula;
    }
    
    /**
     * Método de inserção do horário inicial da aula 
     * @param horarioInicioAula
     */
    public void setHorarioInicioAula(Time horarioInicioAula) {
		this.horarioInicioAula = horarioInicioAula;
	}


    /** Método para retorno do horário final da aula.
     * @return Time - Horário final da aula
     */
    public Time getHorarioFinalAula() {
        return horarioFinalAula;
    }
    
    /**
     * Método de inserção do horário final da aula
     * @param horarioFinalAula
     */
    public void setHorarioFinalAula(Time horarioFinalAula) {
		this.horarioFinalAula = horarioFinalAula;
	}

    /** Método para retorno dos alunos na turma.
     * @return Aluno - Array de alunos
     */
    public Aluno[] getAlunos() {
        return alunos;
    }
    
    /**
     * Método de inserção dos alunos na turma
     * @param alunos
     */
	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

    /**
     * Método de perquisa de um único usuário 
     */
    public void pesquisarAluno() {
        // TODO implement here
    }

    /** Método para retorno da sala padrão da turma.
     * @return SalaPadrao - SalaPadrao da turma
     */
    public SalaPadrao getSalaPadrao() {
        return salaPadrao;
    }

    /**
     * Método de inserção da sala padrão 
     * @param salaPadrao
     */
	public void setSalaPadrao(SalaPadrao salaPadrao) {
		this.salaPadrao = salaPadrao;
	}
    
    
}