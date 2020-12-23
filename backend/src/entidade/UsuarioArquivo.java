package entidade;

/**
 * Classe conténdo métodos e atributos para a ligação do Usuario ao Arquivo enviado ou recebido.
 * @see Usuario
 * @see Arquivo
 * @author
 */
public class UsuarioArquivo {
	
    private int idUsuarioArquivo;
    private int tipoEnvio;
    private Arquivo arquivo;
    private Usuario usuario;
    
    /**
     * Construtor usado ao instanciar a classe UsuarioArquivo.
     * @param
     */
    public UsuarioArquivo() {
    }
    
    /**
     * Método construtor que preenche todos os atributos da classe 
     * @param idUsuarioArquivo
     * @param tipoEnvio
     * @param arquivo
     * @param usuario
     */
    public UsuarioArquivo(int tipoEnvio, Arquivo arquivo, Usuario usuario) {
		setTipoEnvio(tipoEnvio);
		setArquivo(arquivo);
		setUsuario(usuario);
	}

	/** Método para retorno do ID do UsuarioArquivo.
     * @return Int - ID UsuarioArquivo
     */
    public int getIdUsuarioArquivo() {
        return idUsuarioArquivo;
    }
    
    /**
     * Método para inserção do id do arquivo 
     * @param idUsuarioArquivo
     */
	public void setIdUsuarioArquivo(int idUsuarioArquivo) {
		this.idUsuarioArquivo = idUsuarioArquivo;
	}

    /** Método para retorno do tipo de envio.
     * @return Int - Tipo de envio
     */
    public int getTipoEnvio() {
        return tipoEnvio;
    }

    /**
     * Método para inserção do tipo do envio 
     * @param tipoEnvio
     */
	public void setTipoEnvio(int tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

    /** Método para retorno do arquivo.
     * @return Arquivo - Arquivo
     */
    public Arquivo getArquivo() {
        return arquivo;
    }

    /**
     * Método parai inserção do arquivo 
     * @param arquivo
     */
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
	
    /**
     * Método para retorno do usuario
     * @return
     */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Método para inserção do usaurio
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}  
}