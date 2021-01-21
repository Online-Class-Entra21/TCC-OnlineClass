package entidade;

/**
 * Classe contendo m�todos e atributos para a liga��o do Usuario � Sala Personalizada
 * @see Usuario
 * @see SalaPersonalizada
 * @author Breno
 */
public class UsuarioSalaPersonalizada {
	
    private int idUsuarioSalaPersonalizada;
    private int fk_salaPersonalizada;
    private int fk_usuario;
    
    /**
     * Construtor padrao 
     */
    public UsuarioSalaPersonalizada() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe
     * @param idUsuarioSalaPersonalizada
     * @param fk_salaPersonalizada
     * @param fk_usuario
     */
	public UsuarioSalaPersonalizada(int idUsuarioSalaPersonalizada, int fk_salaPersonalizada, int fk_usuario) {
		setIdUsuarioSalaPersonalizada(idUsuarioSalaPersonalizada);
		setFk_salaPersonalizada(fk_salaPersonalizada);
		setFk_usuario(fk_usuario);
	}

	/** 
	 * Metodo para retorno do ID do UsuarioSalaPersonalizada
     * @return int idUsuarioSalaPersonalizada
     */
    public int getIdUsuarioSalaPersonalizada() {
        return idUsuarioSalaPersonalizada;
    }

    /**
     * Mwtodo de insercao do idUsuarioSalaPersonalizada
     * @param int idUsuarioSalaPersonalizada
     */
	public void setIdUsuarioSalaPersonalizada(int idUsuarioSalaPersonalizada) {
		this.idUsuarioSalaPersonalizada = idUsuarioSalaPersonalizada;
	}

	/**
	 * Metodo para retorno do FK da salaPersonalizada
	 * @return int fk_salaPersonalizada
	 */
	public int getFk_salaPersonalizada() {
		return fk_salaPersonalizada;
	}

	/**
	 * Metodo para insercao da sala personalzada 
	 * @param int fk_salaPersonalizada
	 */
	public void setFk_salaPersonalizada(int fk_salaPersonalizada) {
		this.fk_salaPersonalizada = fk_salaPersonalizada;
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