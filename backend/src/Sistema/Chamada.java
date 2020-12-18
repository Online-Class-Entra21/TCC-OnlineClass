package Sistema;

import java.util.*;

/**
 * Classe contendo métodos e atributos para realizar a chamada dos alunos na reunião.
 * @author
 */
public class Chamada {
    private int idChamada;
    private boolean situacao;
    private int codAluno;
    private int codReuniao;

    /**
     * Construtor usado ao instanciar a classe Chamada.
     * @param
     */
    public Chamada() {
    }


    /** Método para retorno do ID da chamada.
     * @return Int - ID da chamada
     */
    public int getIdChamada() {
        return idChamada;
    }

    /**
     * 
     */
    public void setIdChamada() {
        // TODO implement here
    }

    /** Método para retorno da situação da chamada.
     * @return Boolean - Aluno faltante? True / False
     */
    public boolean getSituacao() {
        return situacao;
    }

    /**
     * 
     */
    public void setSituacao() {
        // TODO implement here
    }

    /** Método para retorno do código do aluno.
     * @return Int - Código do aluno
     */
    public int getCodAluno() {
        return codAluno;
    }

    /**
     * 
     */
    public void setCodAluno() {
        // TODO implement here
    }

    /** Método para retorno do código da reunião.
     * @return Int - Código da reunião
     */
    public int getCodReuniao() {
    	return codReuniao;
    }

    /**
     * 
     */
    public void setCodReuniao() {
        // TODO implement here
    }

}