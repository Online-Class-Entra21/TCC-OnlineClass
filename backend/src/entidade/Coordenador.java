package entidade;

import java.util.*;

/**
 * Classe contendo métodos e atributos para o coordenador.
 * Herda métodos e atributos da classe Usuario.
 * @see Usuario
 * @author 
 */
public class Coordenador extends Usuario {

	/**
     * Construtor usado ao instanciar a classe Coordenador.
     * @param
     */
    public Coordenador() {
    }

    /** Método para retorno do ID da turma.
     * @return Int - ID da turma
     */
    public int getTurma() {
    	Turma turma = new Turma();
        return turma.getIdTurma();
    }

    /** Método para adicionar uma turma.
     * @param -
     */
    public void adicionarTurma() {
        // TODO implement here
    }

    /** Método para atualizar uma turma.
     * @param Turma - Turma a ser atualizada.
     */
    public void atualizarTurma(Turma turma) {
        // TODO implement here
    }

    /** Método para a remoção de uma turma.
     * @param Turma - Turma a ser removida.
     */
    public void removerTurma(Turma turma) {
        // TODO implement here
    }

    /** Método para retorno do ID da disciplina.
     * @return Int - ID da disciplina
     */
    public int getDisciplina() {
    	Disciplina disciplina = new Disciplina();
    	return disciplina.getIdDisciplina();
    }

    /** Método para adicionar uma disciplina.
     * @param -
     */
    public void adicionarDisciplina() {
        // TODO implement here
    }

    /** Método para atualizar uma disciplina.
     * @param Disciplina - Disciplina a ser atualizada.
     */
    public void atualizarDisciplina(Disciplina disciplina) {
        // TODO implement here
    }

    /** Método para a remoção de uma disciplina.
     * @param Disciplina - Disciplina a ser removida.
     */
    public void removerDisciplina(Disciplina disciplina) {
        // TODO implement here
    }

    /** Método para retorno do ID do aluno.
     * @return Int - ID do aluno
     */
    public int getAluno() {
        Aluno aluno =  new Aluno();
        return aluno.getIdAluno();		
    }

    /** Método para atualizar um aluno.
     * @param Aluno - Aluno a ser atualizado
     */
    public void atualizarAluno(Aluno aluno) {
        // TODO implement here
    }

    /** Método para a remoção de um aluno.
     * @param Aluno - Aluno a ser removido.
     */
    public void removerAluno(Aluno aluno) {
        // TODO implement here
    }

    /** Método para adicionar um aluno.
     * @param -
     */
    public void adicionarAluno() {
        // TODO implement here
    }

    /** Método para retorno do ID do professor.
     * @return Int - ID do professor
     */
    public int getProfessor() {
        Professor professor = new Professor();
        return professor.getIdProfessor();
    }

    /** Método para adicionar um professor.
     * @param -
     */
    public void adicionarProfessor() {
        // TODO implement here
    }

    /** Método para atualizar um professor.
     * @param Professor - Professor a ser atualizado.
     */
    public void atualizarProfessor(Professor professor) {
        // TODO implement here
    }

    /** Método para a remoção de um professor.
     * @param Professor - Professor a ser removido.
     */
    public void removerProfessor() {
        // TODO implement here
    }

    /** Método para retorno do ID do ProfessorDisciplina.
     * @return Int - ID ProfessorDisciplina
     */
    public int getProfessorDisciplina() {
        ProfessorDisciplina profDisci = new ProfessorDisciplina();
        return profDisci.getIdProfessorDisciplina();
    }

    /** Método para a atribuição de um professor à uma disciplina.
     * @param -
     */
    public void adicionarProfessorDisciplina() {
        // TODO implement here
    }

    /** Método para atualizar a ligação do professor à uma disciplina.
     * @param ProfessorDisciplina
     */
    public void atualizarProfessotDisciplina() {
        // TODO implement here
    }

    /** Método para a remoção de uma ligação do professor à uma disciplina.
     * @param
     */
    public void removerProfessorDisciplina() {
        // TODO implement here
    }

    /** Método para retorno do ID TurmaProfessorDisciplina.
     * @return Int - ID TurmaProfessorDisciplina
     */
    public int getTurmaProfessorDisciplina() {
        TurmaProfessorDisciplina turmaPD = new TurmaProfessorDisciplina();
        return turmaPD.getIdTurmaProfessorDisciplina();
    }

    /** Método para adicionar a ligação entre a turma, professor e disciplina.
     * @param -
     */
    public void adicionarTurmaProfessorDisciplina() {
        // TODO implement here
    }

    /** Método para remover a ligação entre a turma, professor e disciplina.
     * @param TurmaProfessorDisciplinaDAO
     */
    public void removerTurmaProfessorDisciplina(TurmaProfessorDisciplina turmaPD) {
        // TODO implement here
    }

    /** Método para retorno do ID da sala padrão de cada turma.
     * @return Int - ID da sala padrão
     */
    public int getSalaPadrao() {
        SalaPadrao salaPadrao = new SalaPadrao();
        return salaPadrao.getIdSala();
    }

    /** Método para adicionar uma sala padrão à uma turma.
     * @param Turma - Turma a ser atribuida à sala padrão.
     */
    public void adicionarSalaPadrao(Turma turma) {
        // TODO implement here
    }

    /** Método para atualizar a sala padrão.
     * @param SalaPadrao - Sala a ser atualizada
     */
    public void atualizarSalaPadrao(SalaPadrao salaP) {
        // TODO implement here
    }

    /** Método para a remoção de uma sala padrão.
     * @param SalaPadrao - Sala a ser removida.
     * @param Turma - Turma a ter a sala padrão removida.
     */
    public void removerSalaPadrao(SalaPadrao salaP, Turma turma) {
        // TODO implement here
    }

}