package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para o envio e criacao de relatorios pelo usuario
 * @see Usuario
 * @author Andrey
 */
public class Relatorio {
	
    private int idRelatorio;
    private String titulo;
    private int destinatario;
    private String texto;
    private Date dataRelatorio;
    private int fk_usuario;

    /**
     * Construtor padrao
     * @param
     */
    public Relatorio() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idRelatorio
     * @param titulo
     * @param destinatario
     * @param texto
     * @param tipoRelatorio
     * @param fk_usuario
     */
    public Relatorio(int idRelatorio, String titulo, int destinatario, String texto, Date dataRelatorio,
					 int fk_usuario) {
    	
		setIdRelatorio(idRelatorio);
		setTitulo(titulo);
		setDestinatario(destinatario);
		setTexto(texto);
		setDataRelatorio(dataRelatorio);
		setFk_usuario(fk_usuario);
	}

	/** 
     * Metodo para retorno do ID do relatorio
     * @return int idRelatorio
     */
    public int getIdRelatorio() {
    	return idRelatorio;
    }

    /**
     * Metodo para insercao do ID do relatorio 
     * @param int idRelatorio
     */
    public void setIdRelatorio(int idRelatorio) {
    	this.idRelatorio = idRelatorio;
    }

    /**
     * Metodo para retorno do titulo do relatorio.
     * @return String titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo para insercao do titulo do relatorio 
     * @param String titulo
     */
    public void setTitulo(String titulo) {
    	this.titulo = titulo;
    }

    /** 
     * Metodo para retorno do destinatorio
     * @return int destinatario
     */
    public int getDestinatario() {
        return destinatario;
    }

    /**
     * Metodo para insercao do destinatario 
     * @param int destinatario
     */
    public void setDestinatario(int destinatario) {
        // TODO implement here
    	this.destinatario = destinatario;
    }

    /** 
     * Metodo para retorno do texto do relatorio
     * @return String texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Metodo para insercao do texto 
     * @param String texto
     */
    public void setTexto(String texto) {
    	this.texto = texto;
    }

    /** 
     * Metodo para retorno da data do relatorio
     * @return Date dataRelatorio
     */
    public Date getDataRelatorio() {
        return dataRelatorio;
    }

    /**
     * Metodo para insercao da data do relatorio
     * @param Date tipoRelatorio
     */
    public void setDataRelatorio(Date dataRelatorio) {
    	this.dataRelatorio = dataRelatorio;
    }

    /**
     * Metodo para retorno do FK do usuario 
     * @return int fk_usuario 
     */
	public int getFk_usuario() {
		return fk_usuario;
	}

	/**
	 * Metodo para insercao do FK do usuario
	 * @param int fk_usuario
	 */
	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
}