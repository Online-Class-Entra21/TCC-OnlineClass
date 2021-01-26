package entidade;

/**
 * Classe contendo metodos e atributos para a criacao de convites de acesso as reunioes
 * @author Andre
 */
public class Convite {
	
    private int idConvite;
    private int destinatario;
    private int salaConvite;
    private boolean situacaoConvite;
    private int fk_usuario;

    /**
     * Construtor padrao
     */
    public Convite() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idConvite
     * @param destinatario
     * @param salaConvite
     * @param situacaoConvite
     * @param fk_usuario
     */
    public Convite(int idConvite, int destinatario, int salaConvite, boolean situacaoConvite, int fk_usuario) {
		setIdConvite(idConvite);
		setDestinatario(destinatario);
		setSalaConvite(salaConvite);
		setSituacaoConvite(situacaoConvite);
		setFk_usuario(fk_usuario);
	}

	/**
     * Metodo para retorno do ID do convite 
     * @return int idConvite 
     */
    public int getIdConvite() {
		return idConvite;
	}

    /**
     * Metodo para insercao do ID do convite 
     * @param int idConvite
     */
	public void setIdConvite(int idConvite) {
		this.idConvite = idConvite;
	}

    /** 
     * Metodo para retorno do ID do destinatario.
     * @return int destinatario 
     */
    public int getDestinatario() {
        return destinatario;
    }

    /**
     * Metodo para insercao do ID do destinatario 
     * @param int idDestinatario
     */
    public void setDestinatario(int idDestinatario) {
        this.destinatario = idDestinatario;
    }

    /** 
     * Metodo para retorno do ID do convite da sala
     * @return int salaConvite 
     */
    public int getSalaConvite() {
        return salaConvite;
    }

    /**
     * Metodo para insercao do ID do convite da sala 
     * @param int idSalaConvite
     */
    public void setSalaConvite(int idSalaConvite) {
        this.salaConvite = idSalaConvite;
    }

    /** 
     * Metodo para retorno da situacao do convite.
     * @return boolean situacaoConvite
     */
    public boolean getSituacaoConvite() {
        return situacaoConvite;
    }

    /**
     * Metodo para insercao da situacao do convite 
     * @param boolean situacaoConvite
     */
    public void setSituacaoConvite(boolean situacaoConvite) {
        this.situacaoConvite = situacaoConvite;
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