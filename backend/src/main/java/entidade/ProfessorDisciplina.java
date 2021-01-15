package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para o gerenciamento das atividades e liga��o do Professor � Disciplina.
 * @see Professor
 * @see Disciplina
 * @see Atividade
 * @author
 */
public class ProfessorDisciplina {
	private int idProfessorDisciplina;
    private Professor professor;
    private Disciplina disciplina;
    private Atividade atividades[];
    
    /**
     * Construtor usado ao instanciar a classe ProfessorDisciplina.
     * @param
     */
    public ProfessorDisciplina() {
    }


    /** M�todo para retorno do ID do ProfessorDisciplina.
     * @return Int - ID ProfessorDisciplina
     */
    public int getIdProfessorDisciplina() {
        return idProfessorDisciplina;
    }

    /**
     * M�todo de inser��o do id do ProfessorDiciplina
     * @param idProfessorDisciplina
     */
    public void setIdProfessorDisciplina(int idProfessorDisciplina) {
		this.idProfessorDisciplina = idProfessorDisciplina;
	}

	/** M�todo para retorno do professor.
     * @return Professor - Professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * 
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /** M�todo para retorno da disciplina.
     * @return Disciplina - Disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina 
     * 
     */
    public void setDisciplina(Disciplina disciplina) {
        // TODO implement here
    	this.disciplina = disciplina;
    }

    /** M�todo para retorno das atividades.
     * @return Atividade - Array de atividades
     */
//    public Atividade[] getAtividades() {
//        return atividades;
//    }

    /** M�todo para visualizar uma atividade.
     * @param -
     * @return Atividade - Atividade a ser visualizada.
     */
    public Atividade pesquisarAtividade() {
    	return null;
    }

    /** M�todo para adicionar uma atividade.
     * @param -
     */
    public void adicionarAtividade() {
        // TODO implement here
    }

    /** M�todo para atualizar uma atividade.
     * @param Atividade - Atividade a ser atualizada
     */
    public void atualizarAtividade(Atividade atividade) {
        // TODO implement here
    }

    /** M�todo para a remo��o de uma atividade.
     * @param Atividade - Atividade a ser removida.
     */
    public void removerAtividade(Atividade atividade) {
        // TODO implement here
    }

    /** M�todo para visualizar uma atividade da turma.
     * @return TurmaAtividade
     */
    public TurmaAtividade pesquisarTurmaAtividade() {
    	return null;
    }

    /** M�todo para adicionar uma atividade da turma.
     * @param -
     */
    public void adicionarTurmaAtivdade() {
        // TODO implement here
    }



    /** M�todo para a remo��o de uma atividade da turma.
     * @param TurmaAtividadeDAO - A ser removida
     */
    public void removerTurmaAtividade(TurmaAtividade turmaAtiv) {
        // TODO implement here
    }

    /** M�todo para retorno da nota.
     * @return Double - Nota
     */
    public double getNota() {
        Resposta resposta =  new Resposta();
        return resposta.getNota();
    }

    /** M�todo para criar uma nota.
     * @param -
     */
    public void criarNota() {
        // TODO implement here
    }

    /** M�todo para atualizar uma nota.
     * @param Nota - Nota a ser atualizada.
     */
    public void atualizarNota(Resposta nota) {
        // TODO implement here
    }

    /** M�todo para a remo��o de uma nota.
     * @param Nota - Nota a ser removida.
     */
    public void removerNota(Resposta nota) {
        // TODO implement here
    }

    /** M�todo para a visualiza��o das turmas do professor.
     * @param - 
     * @return Turma - Turmas do professor.
     */
    public Turma verTurmas() {
        return null;
    }

    /** M�todo para pesquisar uma turma espec�fica.
     * @param -
     * @return Turma - Turma a ser pesquisada.
     */
    public Turma pequisarTurma() {
        return null;
    }

    /** M�todo para visualizar as respostas para uma atividade.
     * @param -
     * @return Resposta - Respostas enviadas para uma atividade.
     */
    public Resposta verRespostasAtividade() {
        return null;
    }

    /** M�todo para procurar uma resposta espec�fica para uma atividade.
     * @param - 
     * @return Resposta - Resposta de uma atividade.
     */
    public Resposta procurarRespostaAtividade() {
        return null;
    }

}