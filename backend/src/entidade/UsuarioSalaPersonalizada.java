package entidade;

/**
 * Classe contendo métodos e atributos para a ligação do Usuario à Sala Personalizada.
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
     * Método construtor que preenche todos os atributos da classe
     * @param idUsuarioSalaPersonalizada
     * @param codSalaPersonalizada
     * @param usuario
     */
    public UsuarioSalaPersonalizada(int idUsuarioSalaPersonalizada, SalaPersonalizada salaPersonalizada, Usuario usuario) {
		setSalaPersonalizada(salaPersonalizada);
		setUsuario(usuario);
	}
    
    /**
     * Método de exibição de todos os atributos da classe
     */
	@Override
	public String toString() {
		return "UsuarioSalaPersonalizada [idUsuarioSalaPersonalizada=" + idUsuarioSalaPersonalizada
				+ ", salaPersonalizada=" + salaPersonalizada + ", usuario=" + usuario + "]";
	}

	/** Método para retorno do ID do UsuarioSalaPersonalizada.
     * @return Int - ID UsuarioSalaPersonalizada
     */
    public int getIdUsuarioSalaPersonalizada() {
        return idUsuarioSalaPersonalizada;
    }

    /**
     * Método de inserção do idUsuarioSalaPersonalizada
     * @param idUsuarioSalaPersonalizada
     */
	public void setIdUsuarioSalaPersonalizada(int idUsuarioSalaPersonalizada) {
		this.idUsuarioSalaPersonalizada = idUsuarioSalaPersonalizada;
	}

    /** Método para retorno do código da sala personalizada.
     * @return Salapersonalizada
     */
    public SalaPersonalizada getSalaPersonalizada() {
        return salaPersonalizada;
    }
    
    /**
     * Método de inserção da sala personalizada
     * @param SalaPersonalizada
     */
    public void setSalaPersonalizada(SalaPersonalizada salaPersonalizada) {
		this.salaPersonalizada = salaPersonalizada;
	}

    /** Método para retorno do usuário.
     * @return Usuario - Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }
    
    /**
     * Método de inserção do usuario 
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}