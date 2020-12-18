package Sistema;

import java.util.*;

/**
 * Classe contendo métodos e atributos para o professor.
 * Herda métodos e atributos da classe Usuario.
 * @see Usuario
 * @author  
 */
public class Professor extends Usuario {
	private int idProfessor;

	/**
     * Construtor usado ao instanciar a classe Professor.
     * @param
     */
    public Professor() {
    }
    
    
    /** Método para retorno do ID do professor.
     *  @return Int - ID do professor
     */
    public int getIdProfessor() {
    	return idProfessor;
    }

    /** Método para visualizar as disciplinas do professor.
     * @param - 
     * @return ProfessorDisciplina - Disciplinas do professor.
     */
    public ProfessorDisciplina verDisciplinas() {
        return null;
    }

    /**
     * 
     */
    public void escolherDisciplinaGerenciar() {
        // TODO implement here
    }

}