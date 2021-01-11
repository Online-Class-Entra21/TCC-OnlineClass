package entidade;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo m�todos e atributos para a turma.
 * As turmas possuem alunos, e cada uma tem uma sala como padr�o.
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
     * M�todo de constru��o que preenche todas as informa��es relevantes 
     * ao inicio da cria��o da turma 
     * @param idTurma
     * @param ano
     * @param qtdAluno
     * @param horarioInicioAula
     * @param horarioFinalAula
     * @param alunos
     * @param salaPadrao
     */
    public Turma(int idTurma, String ano, int qtdAluno, Time horarioInicioAula, Time horarioFinalAula, SalaPadrao salaPadrao) {
		setIdTurma(idTurma);
		setAno(ano);
		setQtdAluno(qtdAluno);
		setHorarioInicioAula(horarioInicioAula);
		setHorarioFinalAula(horarioFinalAula);
		setSalaPadrao(salaPadrao);
	}

    /**
     * M�todo de exibi��o dos atributos da classe
     */
	@Override
	public String toString() {
		return "Turma [idTurma=" + idTurma + ", ano=" + ano + ", qtdAluno=" + qtdAluno + ", horarioInicioAula="
				+ horarioInicioAula + ", horarioFinalAula=" + horarioFinalAula + ", alunos=" + Arrays.toString(alunos)
				+ ", salaPadrao=" + salaPadrao + "]";
	}

	/** M�todo para retorno do ID da turma.
     * @return Int - ID da turma
     */
    public int getIdTurma() {
        return idTurma;
    }
    
    /**
     * M�todo de inser��o do id da turma 
     * @param idTurma
     */
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

    /** M�todo para retorno do ano da turma.
     * @return String - Ano da turma
     */
    public String getAno() {
        return ano;
    }
    
    /**
     * M�todo de inser��o do ano 
     * @param ano
     */
    public void setAno(String ano) {
		this.ano = ano;
	}


    /** M�todo para retorno da quantidade de alunos na turma.
     * @return Int - Quantidade de alunos na turma
     */
    public int getQtdAluno() {
        return qtdAluno;
    }
    
    /**
     * M�todo de inser��o da quantidade de alunos da turma
     * @param qtdAluno
     */
    public void setQtdAluno(int qtdAluno) {
		this.qtdAluno = qtdAluno;
	}

    /** M�todo para retorno do hor�rio inicial da aula.
     * @return Time - Hor�rio inicial da aula
     */
    public Time getHorarioInicioAula() {
        return horarioInicioAula;
    }
    
    /**
     * M�todo de inser��o do hor�rio inicial da aula 
     * @param horarioInicioAula
     */
    public void setHorarioInicioAula(Time horarioInicioAula) {
		this.horarioInicioAula = horarioInicioAula;
	}


    /** M�todo para retorno do hor�rio final da aula.
     * @return Time - Hor�rio final da aula
     */
    public Time getHorarioFinalAula() {
        return horarioFinalAula;
    }
    
    /**
     * M�todo de inser��o do hor�rio final da aula
     * @param horarioFinalAula
     */
    public void setHorarioFinalAula(Time horarioFinalAula) {
		this.horarioFinalAula = horarioFinalAula;
	}

    /** M�todo para retorno dos alunos na turma.
     * @return Aluno - Array de alunos
     */
    public Aluno[] getAlunos() {
        return alunos;
    }
    
    /**
     * M�todo de inser��o dos alunos na turma
     * @param alunos
     */
	public void setAlunos(Aluno[] alunos) {
		this.alunos = alunos;
	}

    /**
     * M�todo de perquisa de um �nico usu�rio 
     */
    public void pesquisarAluno() {
        // TODO implement here
    }

    /** M�todo para retorno da sala padr�o da turma.
     * @return SalaPadrao - SalaPadrao da turma
     */
    public SalaPadrao getSalaPadrao() {
        return salaPadrao;
    }

    /**
     * M�todo de inser��o da sala padr�o 
     * @param salaPadrao
     */
	public void setSalaPadrao(SalaPadrao salaPadrao) {
		this.salaPadrao = salaPadrao;
	}
    
    
}