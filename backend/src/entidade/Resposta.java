package entidade;

import java.util.*;

/**
 * Classe contendo métodos e atributos para o envio de uma resposta à uma atividade específica.
 * Respostas são enviadas pelo Aluno.
 * @see Aluno
 * @see Atividade
 * @author 
 */
public class Resposta {
    private int idResposta;
    private double nota;
    private String comentarioAtividade;
    private boolean correcaoAtividade;
    private Date dataEntrega;
    private int codAtividade;

    /**
     * Construtor usado ao instanciar a classe Resposta.
     * @param
     */
    public Resposta() {
    }


    /** Método para retorno do ID da resposta.
     * @return Int - ID da resposta
     */
    public int getIdResposta() {
        return idResposta;
    }

    /**
     * 
     */
    public void setIdResposta() {
        // TODO implement here
    }

    /** Método para retorno da nota.
     * @return Double - Nota
     */
    public double getNota() {
        return nota;
    }

    /**
     * 
     */
    public void setNota() {
        // TODO implement here
    }

    /** Método para retorno de um comentário na atividade.
     * @return String - Comentário da atividade
     */
    public String getComentarioAtividade() {
        return comentarioAtividade;
    }

    /**
     * 
     */
    public void setComentarioAtividade() {
        // TODO implement here
    }

    /** Método para retorno se a atividade foi corrigida.
     * @return Boolean - Foi corrigida? True / False
     */
    public boolean getCorrecaoAtividade() {
        return correcaoAtividade;
    }

    /**
     * 
     */
    public void setCorrecaoAtividade() {
        // TODO implement here
    }

    /** Método para retorno da data de entrega.
     * @return Date - Data de entrega 
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * 
     */
    public void setDataEntrega() {
        // TODO implement here
    }

    /** Método para retorno do código da atividade.
     * @return Int - Código da atividade
     */
    public int getCodAtividade() {
        return codAtividade;
    }

    /**
     * 
     */
    public void setCodAtividade() {
        // TODO implement here
    }

}