package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para o envio de uma resposta � uma atividade espec�fica.
 * Respostas s�o enviadas pelo Aluno.
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


    /** M�todo para retorno do ID da resposta.
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

    /** M�todo para retorno da nota.
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

    /** M�todo para retorno de um coment�rio na atividade.
     * @return String - Coment�rio da atividade
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

    /** M�todo para retorno se a atividade foi corrigida.
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

    /** M�todo para retorno da data de entrega.
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

    /** M�todo para retorno do c�digo da atividade.
     * @return Int - C�digo da atividade
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