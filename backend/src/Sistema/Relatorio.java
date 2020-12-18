package Sistema;

import java.util.*;

/**
 * Classe contendo métodos e atributos para o envio e criação de relatórios pelo usuário.
 * @see Usuario
 * @author
 */
public class Relatorio {
    private int idRelatorio;
    private String titulo;
    private int destinatario;
    private String texto;
    private int tipoRelatorio;
    private int remetente;

    /**
     * Construtor usado ao instanciar a classe Relatorio.
     * @param
     */
    public Relatorio() {
    }


    /** Método para retorno do ID do relatório.
     * @return Int - ID do relatório
     */
    public int getIdRelatorio() {
    	return idRelatorio;
    }

    /**
     * 
     */
    public void setIdRelatorio() {
        // TODO implement here
    }

    /** Método para retorno do titulo do relatório.
     * @return String - Titulo do relatório
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * 
     */
    public void setTitulo() {
        // TODO implement here
    }

    /** Método para retorno do ID do destinatário.
     * @return Int - ID do destinatário
     */
    public int getDestinatario() {
        return destinatario;
    }

    /**
     * 
     */
    public void setDestinatario() {
        // TODO implement here
    }

    /** Método para retorno do texto do relatório.
     * @return String - Texto do relatório
     */
    public String getTexto() {
        return texto;
    }

    /**
     * 
     */
    public void setTexto() {
        // TODO implement here
    }

    /** Método para retorno do tipo de relatório.
     * @return Int - Tipo do relatório
     */
    public int getTipoRelatorio() {
        return tipoRelatorio;
    }

    /**
     * 
     */
    public void setTipoRelatorio() {
        // TODO implement here
    }

    /** Método para retorno do ID do remetente.
     * @return Int - ID do remetente
     */
    public int getRemetente() {
        return remetente;
    }

    /**
     * 
     */
    public void setRemetente() {
        // TODO implement here
    }

}