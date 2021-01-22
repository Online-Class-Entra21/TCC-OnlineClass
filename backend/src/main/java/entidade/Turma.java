package entidade;

import java.sql.Time;

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
     * @return int idTurma
     */
    public int getIdTurma() {
        return idTurma;
    }
    
    /**
     * Metodo de insercao do ID da turma 
     * @param int idTurma
     */
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

    /** 
     * Metodo para retorno do ano da turma
     * @return String ano
     */
    public String getAno() {
        return ano;
    }
    
    /**
     * Metodo de insercao do ano 
     * @param String ano
     */
    public void setAno(String ano) {
		this.ano = ano;
	}

    /** 
     * Metodo para retorno da quantidade de alunos na turma
     * @return int qtdAluno
     */
    public int getQtdAluno() {
        return qtdAluno;
    }
    
    /**
     * Metodo de insercao da quantidade de alunos da turma
     * @param int qtdAluno
     */
    public void setQtdAluno(int qtdAluno) {
		this.qtdAluno = qtdAluno;
	}

    /** 
     * Metodo para retorno do horario inicial da aula
     * @return Time horarioInicioAula
     */
    public Time getHorarioInicioAula() {
        return horarioInicioAula;
    }
    
    /**
     * Metodo de insercao do horario inicial da aula 
     * @param Time horarioInicioAula
     */
    public void setHorarioInicioAula(Time horarioInicioAula) {
		this.horarioInicioAula = horarioInicioAula;
	}

    /** 
     * Metodo para retorno do horario final da aula
     * @return Time horarioFinalAula
     */
    public Time getHorarioFinalAula() {
        return horarioFinalAula;
    }
    
    /**
     * Metodo de insercao do horario final da aula
     * @param Time horarioFinalAula
     */
    public void setHorarioFinalAula(Time horarioFinalAula) {
		this.horarioFinalAula = horarioFinalAula;
	}

    /**
     * Metodo para retorno do FK da sala 
     * @return int fk_sala 
     */
    public int getFk_sala() {
		return fk_sala;
	}

    /**
     * Metodo para insercao do FK da sala 
     * @param int fk_sala
     */
	public void setFk_sala(int fk_sala) {
		this.fk_sala = fk_sala;
	}
}