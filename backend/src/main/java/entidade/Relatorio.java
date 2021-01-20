package entidade;

/**
 * Classe contendo m�todos e atributos para o envio e criacao de relatorios pelo usuario.
 * @see Usuario
 * @author Andrey
 */
public class Relatorio {
	
    private int idRelatorio;
    private String titulo;
    private int destinatario;
    private String texto;
    private String tipoRelatorio;
    private int fk_usuario;

    /**
     *Construtor padrao
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
    public Relatorio(int idRelatorio, String titulo, int destinatario, String texto, String tipoRelatorio,
					 int fk_usuario) {
    	
		setIdRelatorio(idRelatorio);
		setTitulo(titulo);
		setDestinatario(destinatario);
		setTexto(texto);
		setTipoRelatorio(tipoRelatorio);
		setFk_usuario(fk_usuario);
	}

	/** 
     * Metodo para retorno do ID do relatorio
     * @return idRelatorio
     */
    public int getIdRelatorio() {
    	return idRelatorio;
    }

    /**
     * Metodo para insercao do ID do relatorio 
     * @param idRelatorio
     */
    public void setIdRelatorio(int idRelatorio) {
    	this.idRelatorio = idRelatorio;
    }

    /**
     * Metodo para retorno do titulo do relatorio.
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo para insercao do titulo do relatorio 
     * @param titulo
     */
    public void setTitulo(String titulo) {
    	this.titulo = titulo;
    }

    /** 
     * Metodo para retorno do destinatorio
     * @return destinatario
     */
    public int getDestinatario() {
        return destinatario;
    }

    /**
     * Metodo para insercao do destinatario 
     * @param destinatario
     */
    public void setDestinatario(int destinatario) {
        // TODO implement here
    	this.destinatario = destinatario;
    }

    /** 
     * Metodo para retorno do texto do relatorio
     * @return texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Metodo para insercao do texto 
     * @param texto
     */
    public void setTexto(String texto) {
        // TODO implement here
    	this.texto = texto;
    }

    /** 
     * Metodo para retorno do tipo de relatorio
     * @return tipoRelatorio
     */
    public String getTipoRelatorio() {
        return tipoRelatorio;
    }

    /**
     * Metodo para insercao do tipo relatorio 
     * @param tipoRelatorio
     */
    public void setTipoRelatorio(String tipoRelatorio) {
    	this.tipoRelatorio = tipoRelatorio;
    }

    /**
     * Metodo para retorno do FK do usuario 
     * @return
     */
	public int getFk_usuario() {
		return fk_usuario;
	}

	/**
	 * Metodo para insercao do FK do usuario
	 * @param fk_usuario
	 */
	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}
}