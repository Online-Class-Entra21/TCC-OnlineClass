package Sistema;

import java.util.*;

/**
 * Classe contendo métodos e atributos para o gerenciamento das atividades e ligação do Professor à Disciplina.
 * @see Professor
 * @see Disciplina
 * @see Atividade
 * @author
 */
public class ProfessorDisciplina {
	public int idProfessorDisciplina;
    private Professor professor;
    private Disciplina disciplina;
    private Atividade atividades[];
    
    /**
     * Construtor usado ao instanciar a classe ProfessorDisciplina.
     * @param
     */
    public ProfessorDisciplina() {
    }


    /** Método para retorno do ID do ProfessorDisciplina.
     * @return Int - ID ProfessorDisciplina
     */
    public int getIdProfessorDisciplina() {
        return idProfessorDisciplina;
    }

    /**
     * 
     */
    public void setIdProfessorDisciplina() {
        // TODO implement here
    }

    /** Método para retorno do professor.
     * @return Professor - Professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * 
     */
    public void setProfessor() {
        // TODO implement here
    }

    /** Método para retorno da disciplina.
     * @return Disciplina - Disciplina
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }

    /**
     * 
     */
    public void setDisciplina() {
        // TODO implement here
    }

    /** Método para retorno das atividades.
     * @return Atividade - Array de atividades
     */
    public Atividade[] getAtividades() {
        return atividades;
    }

    /** Método para visualizar uma atividade.
     * @param -
     * @return Atividade - Atividade a ser visualizada.
     */
    public Atividade pesquisarAtividade() {
    	return null;
    }

    /** Método para adicionar uma atividade.
     * @param -
     */
    public void adicionarAtividade() {
        // TODO implement here
    }

    /** Método para atualizar uma atividade.
     * @param Atividade - Atividade a ser atualizada
     */
    public void atualizarAtividade(Atividade atividade) {
        // TODO implement here
    }

    /** Método para a remoção de uma atividade.
     * @param Atividade - Atividade a ser removida.
     */
    public void removerAtividade(Atividade atividade) {
        // TODO implement here
    }

    /** Método para visualizar uma atividade da turma.
     * @return TurmaAtividade
     */
    public TurmaAtividade pesquisarTurmaAtividade() {
    	return null;
    }

    /** Método para adicionar uma atividade da turma.
     * @param -
     */
    public void adicionarTurmaAtivdade() {
        // TODO implement here
    }



    /** Método para a remoção de uma atividade da turma.
     * @param TurmaAtividade - A ser removida
     */
    public void removerTurmaAtividade(TurmaAtividade turmaAtiv) {
        // TODO implement here
    }

    /** Método para retorno da nota.
     * @return Double - Nota
     */
    public double getNota() {
        Resposta resposta =  new Resposta();
        return resposta.getNota();
    }

    /** Método para criar uma nota.
     * @param -
     */
    public void criarNota() {
        // TODO implement here
    }

    /** Método para atualizar uma nota.
     * @param Nota - Nota a ser atualizada.
     */
    public void atualizarNota(Resposta nota) {
        // TODO implement here
    }

    /** Método para a remoção de uma nota.
     * @param Nota - Nota a ser removida.
     */
    public void removerNota(Resposta nota) {
        // TODO implement here
    }

    /** Método para a visualização das turmas do professor.
     * @param - 
     * @return Turma - Turmas do professor.
     */
    public Turma verTurmas() {
        return null;
    }

    /** Método para pesquisar uma turma específica.
     * @param -
     * @return Turma - Turma a ser pesquisada.
     */
    public Turma pequisarTurma() {
        return null;
    }

    /** Método para visualizar as respostas para uma atividade.
     * @param -
     * @return Resposta - Respostas enviadas para uma atividade.
     */
    public Resposta verRespostasAtividade() {
        return null;
    }

    /** Método para procurar uma resposta específica para uma atividade.
     * @param - 
     * @return Resposta - Resposta de uma atividade.
     */
    public Resposta procurarRespostaAtividade() {
        return null;
    }

}