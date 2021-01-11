package entidade;

/**
 * Classe contendo m�todos e atributos para a liga��o do Usuario � Sala Personalizada.
 * @see Usuario
 * @see SalaPersonalizada
 * @author
 */
public class UsuarioSalaPersonalizada {
	
    private int idUsuarioSalaPersonalizada;
    private SalaPersonalizada salaPersonalizada;
    private Usuario usuario;
    
    /**
     * Construtor usado ao instanciar a classe UsuarioSalaPersonalizada.
     * @param
     */
    public UsuarioSalaPersonalizada() {
    	
    }

    /**
     * M�todo construtor que preenche todos os atributos da classe
     * @param idUsuarioSalaPersonalizada
     * @param codSalaPersonalizada
     * @param usuario
     */
    public UsuarioSalaPersonalizada(int idUsuarioSalaPersonalizada, SalaPersonalizada salaPersonalizada, Usuario usuario) {
		setSalaPersonalizada(salaPersonalizada);
		setUsuario(usuario);
	}
    
    /**
     * M�todo de exibi��o de todos os atributos da classe
     */
	@Override
	public String toString() {
		return "UsuarioSalaPersonalizada [idUsuarioSalaPersonalizada=" + idUsuarioSalaPersonalizada
				+ ", salaPersonalizada=" + salaPersonalizada + ", usuario=" + usuario + "]";
	}

	/** M�todo para retorno do ID do UsuarioSalaPersonalizada.
     * @return Int - ID UsuarioSalaPersonalizada
     */
    public int getIdUsuarioSalaPersonalizada() {
        return idUsuarioSalaPersonalizada;
    }

    /**
     * M�todo de inser��o do idUsuarioSalaPersonalizada
     * @param idUsuarioSalaPersonalizada
     */
	public void setIdUsuarioSalaPersonalizada(int idUsuarioSalaPersonalizada) {
		this.idUsuarioSalaPersonalizada = idUsuarioSalaPersonalizada;
	}

    /** M�todo para retorno do c�digo da sala personalizada.
     * @return Salapersonalizada
     */
    public SalaPersonalizada getSalaPersonalizada() {
        return salaPersonalizada;
    }
    
    /**
     * M�todo de inser��o da sala personalizada
     * @param SalaPersonalizada
     */
    public void setSalaPersonalizada(SalaPersonalizada salaPersonalizada) {
		this.salaPersonalizada = salaPersonalizada;
	}

    /** M�todo para retorno do usu�rio.
     * @return Usuario - Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    
    /**
     * M�todo de inser��o do usuario 
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}