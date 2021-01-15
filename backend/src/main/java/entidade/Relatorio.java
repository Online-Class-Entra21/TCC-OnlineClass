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
    private String tipoRelatorio;
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
     * @param i 
     * 
     */
    public void setIdRelatorio(int idRelatorio) {
        // TODO implement here
    	this.idRelatorio = idRelatorio;
    }

    /** M�todo para retorno do titulo do relat�rio.
     * @return String - Titulo do relat�rio
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param string 
     * 
     */
    public void setTitulo(String titulo) {
        // TODO implement here
    	this.titulo = titulo;
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
    public void setDestinatario(int destinatario) {
        // TODO implement here
    	this.destinatario = destinatario;
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
    public void setTexto(String texto) {
        // TODO implement here
    	this.texto = texto;
    }

    /** M�todo para retorno do tipo de relat�rio.
     * @return Int - Tipo do relat�rio
     */
    public String getTipoRelatorio() {
        return tipoRelatorio;
    }

    /**
     * 
     */
    public void setTipoRelatorio(String tipoRelatorio) {
        // TODO implement here
    	this.tipoRelatorio = tipoRelatorio;
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
    public void setRemetente(int remetente) {
        // TODO implement here
    	this.remetente = remetente;
    }

}