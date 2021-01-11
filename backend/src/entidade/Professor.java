package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para o professor.
 * Herda m�todos e atributos da classe Usuario.
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
    
    
    /** M�todo para retorno do ID do professor.
     *  @return Int - ID do professor
     */
    public int getIdProfessor() {
    	return idProfessor;
    }

    /** M�todo para visualizar as disciplinas do professor.
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