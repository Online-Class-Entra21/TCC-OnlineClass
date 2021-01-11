package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para a disciplina.
 * @author 
 */
public class Disciplina {
    private int idDisciplina;
    private String nome;
    private int numeroAulas;

    /**
     * Construtor usado ao instanciar a classe Disciplina.
     * @param
     */
    public Disciplina(int idDisciplina, String nome, int numeroAulas) {
    	setIdDisciplina(idDisciplina);
    	setNome(nome);
    	setNumeroAulas(numeroAulas);
    }

    
    /** M�todo para retorno do ID da disciplina.
     * @return Int - ID da disciplina
     */
    public int getIdDisciplina() {
        return idDisciplina;
    }

    /**
     * 
     */
    public void setIdDisciplina() {
        // TODO implement here
    }

    /** M�todo para retorno do nome da disciplina.
     * @return String - Nome da disciplina
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     */
    public void setNome() {
        // TODO implement here
    }

    /** M�todo para retorno do n�mero de aulas da disciplina.
     * @return Int - N�mero de aulas
     */
    public int getNumeroAulas() {
        return numeroAulas;
    }

    /**
     * 
     */
    public void setNumeroAulas() {
        // TODO implement here
    }

}