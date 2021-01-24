package entidade;

/**
 * Classe contendo metodos e atributos para o gerenciamento das atividades e ligacoo do Professor e Disciplina
 * @see Professor
 * @see Disciplina
 * @see Atividade
 * @author Breno
 */
public class UsuarioDisciplina {
	
	private int idUsuarioDisciplina;
    private int fk_usuario;
    private int fk_disciplina;
    
    /**
     * Construtor padrao
     */
    public UsuarioDisciplina() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idUsuarioDisciplina
     * @param fk_usuario
     * @param fk_disciplina
     */
    public UsuarioDisciplina(int idUsuarioDisciplina, int fk_usuario, int fk_disciplina) {
		setIdUsuarioDisciplina(idUsuarioDisciplina);
		setFk_usuario(fk_usuario);
		setFk_disciplina(fk_disciplina);
	}

	/**
     * Metodo para retorno do ID do usuario disciplina 
     * @return int idUsuarioDisciplina 
     */
	public int getIdUsuarioDisciplina() {
		return idUsuarioDisciplina;
	}

	/**
	 * Metodo para insercao do ID do usuario disciplina 
	 * @param int idUsuarioDisciplina
	 */
	public void setIdUsuarioDisciplina(int idUsuarioDisciplina) {
		this.idUsuarioDisciplina = idUsuarioDisciplina;
	}
	
	/**
	 * Metodo de retorno do FK do usuario 
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

	/**
	 * Metodo de retorno do FK da disciplina 
	 * @return int fk_disciplina 
	 */
	public int getFk_disciplina() {
		return fk_disciplina;
	}

	/**
	 * Metodo para insercao do FK da disciplina 
	 * @param int fk_disciplina
	 */
	public void setFk_disciplina(int fk_disciplina) {
		this.fk_disciplina = fk_disciplina;
	}
}