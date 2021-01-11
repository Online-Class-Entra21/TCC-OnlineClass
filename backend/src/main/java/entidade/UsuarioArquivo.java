package entidade;

/**
 * Classe cont�ndo m�todos e atributos para a liga��o do Usuario ao Arquivo enviado ou recebido.
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
     * M�todo construtor que preenche todos os atributos da classe 
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
    
    /**
     * M�todo de exibi��o de todos os atributos da classe
     */
	@Override
	public String toString() {
		return "UsuarioArquivo [idUsuarioArquivo=" + idUsuarioArquivo + ", tipoEnvio=" + tipoEnvio + ", arquivo="
				+ arquivo + ", usuario=" + usuario + "]";
	}

	/** M�todo para retorno do ID do UsuarioArquivo.
     * @return Int - ID UsuarioArquivo
     */
    public int getIdUsuarioArquivo() {
        return idUsuarioArquivo;
    }
    
    /**
     * M�todo para inser��o do id do arquivo 
     * @param idUsuarioArquivo
     */
	public void setIdUsuarioArquivo(int idUsuarioArquivo) {
		this.idUsuarioArquivo = idUsuarioArquivo;
	}

    /** M�todo para retorno do tipo de envio.
     * @return Int - Tipo de envio
     */
    public int getTipoEnvio() {
        return tipoEnvio;
    }

    /**
     * M�todo para inser��o do tipo do envio 
     * @param tipoEnvio
     */
	public void setTipoEnvio(int tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

    /** M�todo para retorno do arquivo.
     * @return Arquivo - Arquivo
     */
    public Arquivo getArquivo() {
        return arquivo;
    }

    /**
     * M�todo parai inser��o do arquivo 
     * @param arquivo
     */
	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}
	
    /**
     * M�todo para retorno do usuario
     * @return
     */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * M�todo para inser��o do usaurio
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}  
}