package entidade;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo metodos e atributos para a turma.
 * As turmas possuem alunos, e cada uma tem uma sala como padrao
 * @see Aluno
 * @see SalaPadrao
 * @author Breno
 */
public class Turma {
	
    private int idTurma;
    private String ano;
    private int qtdAluno;
    private Time horarioInicioAula;
    private Time horarioFinalAula;
    private int fk_sala;
    
    /**
     * Construtor padrao
     * @param
     */
    public Turma() {
    	//Nenhum atributo inicializado
    }

    /**
     * Metodo construtor que preenche todos os tributos da classe 
     * @param idTurma
     * @param ano
     * @param qtdAluno
     * @param horarioInicioAula
     * @param horarioFinalAula
     * @param fk_sala
     */
	public Turma(int idTurma, String ano, int qtdAluno, Time horarioInicioAula, Time horarioFinalAula, int fk_sala) {
		
		setIdTurma(idTurma);
		setAno(ano);
		setQtdAluno(qtdAluno);
		setHorarioInicioAula(horarioInicioAula);
		setHorarioFinalAula(horarioFinalAula);
		setFk_sala(fk_sala);
	}

	/** Metodo para retorno do ID da turma
     * @return idTurma
     */
    public int getIdTurma() {
        return idTurma;
    }
    
    /**
     * Metodo de insercao do ID da turma 
     * @param idTurma
     */
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

    /** 
     * Metodo para retorno do ano da turma
     * @return ano
     */
    public String getAno() {
        return ano;
    }
    
    /**
     * Metodo de insercao do ano 
     * @param ano
     */
    public void setAno(String ano) {
		this.ano = ano;
	}


    /** 
     * Metodo para retorno da quantidade de alunos na turma
     * @return qtdAluno
     */
    public int getQtdAluno() {
        return qtdAluno;
    }
    
    /**
     * Metodo de insercao da quantidade de alunos da turma
     * @param qtdAluno
     */
    public void setQtdAluno(int qtdAluno) {
		this.qtdAluno = qtdAluno;
	}

    /** 
     * Metodo para retorno do horario inicial da aula
     * @return horarioInicioAula
     */
    public Time getHorarioInicioAula() {
        return horarioInicioAula;
    }
    
    /**
     * Metodo de insercao do horario inicial da aula 
     * @param horarioInicioAula
     */
    public void setHorarioInicioAula(Time horarioInicioAula) {
		this.horarioInicioAula = horarioInicioAula;
	}

    /** 
     * Metodo para retorno do horario final da aula
     * @return horarioFinalAula
     */
    public Time getHorarioFinalAula() {
        return horarioFinalAula;
    }
    
    /**
     * Metodo de insercao do horario final da aula
     * @param horarioFinalAula
     */
    public void setHorarioFinalAula(Time horarioFinalAula) {
		this.horarioFinalAula = horarioFinalAula;
	}

    /**
     * Metodo para retorno do FK da sala 
     * @return
     */
    public int getFk_sala() {
		return fk_sala;
	}

    /**
     * Metodo para insercao do FK da sala 
     * @param fk_sala
     */
	public void setFk_sala(int fk_sala) {
		this.fk_sala = fk_sala;
	}

	
	//--------------

	
//	/**
//     * M�todo de perquisa de um �nico usu�rio 
//     */
//    public void pesquisarAluno() {
//        // TODO implement here
//    }
}