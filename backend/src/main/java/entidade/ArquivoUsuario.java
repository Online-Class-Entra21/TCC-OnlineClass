package entidade;

/**
 * Classe contendo metodos e atributos para a ligacao do Usuario ao Arquivo enviado ou recebido
 * @see Usuario
 * @see Arquivo
 * @author Andrey 
 */
public class ArquivoUsuario {
	
    private int idArquivoUsuario;
    private int fk_arquivo;
    private int fk_usuario;
    private int tipoEnvio;
    
    /**
     * Construtor padrao
     * @param
     */
    public ArquivoUsuario() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idArquivoUsuario
     * @param fk_arquivo
     * @param fk_usuario
     * @param tipoEnvio
     */
    public ArquivoUsuario(int idArquivoUsuario, int fk_arquivo, int fk_usuario, int tipoEnvio) {
		setIdArquivoUsuario(idArquivoUsuario);
		setFk_arquivo(fk_arquivo);
		setFk_usuario(fk_usuario);
		setTipoEnvio(tipoEnvio);
	}

	/**
     * Metodo para retorno do ID arquivo usuario 
     * @return idArquivoUsuario
     */
	public int getIdArquivoUsuario() {
		return idArquivoUsuario;
	}

	/**
	 * Metodo para insercao do ID do arquivo usuario
	 * @param idArquivoUsuario
	 */
	public void setIdArquivoUsuario(int idArquivoUsuario) {
		this.idArquivoUsuario = idArquivoUsuario;
	}

	/**
	 * Metodo para retorno do FK do arquivo 
	 * @return fk_arquivo
	 */
	public int getFk_arquivo() {
		return fk_arquivo;
	}

	/**
	 * Metodo para insercao do FK do arquivo 
	 * @param fk_arquivo
	 */
	public void setFk_arquivo(int fk_arquivo) {
		this.fk_arquivo = fk_arquivo;
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

	/**
	 * Metodo para retorno do tipo de envio 
	 * @return tipoEnvio 
	 */
	public int getTipoEnvio() {
		return tipoEnvio;
	}

	/**
	 * Metodo para insercao do tipo de envio 
	 * @param tipoEnvio
	 */
	public void setTipoEnvio(int tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}
}