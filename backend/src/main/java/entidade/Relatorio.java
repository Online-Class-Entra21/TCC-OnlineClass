package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para o envio e cria��o de relat�rios pelo usu�rio.
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


    /** M�todo para retorno do ID do relat�rio.
     * @return Int - ID do relat�rio
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

    /** M�todo para retorno do titulo do relat�rio.
     * @return String - Titulo do relat�rio
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

    /** M�todo para retorno do ID do destinat�rio.
     * @return Int - ID do destinat�rio
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

    /** M�todo para retorno do texto do relat�rio.
     * @return String - Texto do relat�rio
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

    /** M�todo para retorno do tipo de relat�rio.
     * @return Int - Tipo do relat�rio
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

    /** M�todo para retorno do ID do remetente.
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