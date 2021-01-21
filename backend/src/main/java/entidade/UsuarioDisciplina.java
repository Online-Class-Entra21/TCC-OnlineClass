package entidade;

/**
 * Classe contendo metodos e atributos para o gerenciamento das atividades e ligacoo do Professor e Disciplina.
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
     * @param
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
     * @return
     */
	public int getIdUsuarioDisciplina() {
		return idUsuarioDisciplina;
	}

	/**
	 * Metodo para insercao do ID do usuario disciplina 
	 * @param idUsuarioDisciplina
	 */
	public void setIdUsuarioDisciplina(int idUsuarioDisciplina) {
		this.idUsuarioDisciplina = idUsuarioDisciplina;
	}
	
	/**
	 * Metodo de retorno do FK do usuario 
	 * @return fk_usuario 
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
	 * Metodo de retorno do FK da disciplina 
	 * @return
	 */
	public int getFk_disciplina() {
		return fk_disciplina;
	}

	/**
	 * Metodo para insercao do FK da disciplina 
	 * @param fk_disciplina
	 */
	public void setFk_disciplina(int fk_disciplina) {
		this.fk_disciplina = fk_disciplina;
	}
    
    
	//--------------

	
    
//    /** M�todo para visualizar uma atividade.
//     * @param -
//     * @return Atividade - Atividade a ser visualizada.
//     */
//    public Atividade pesquisarAtividade() {
//    	return null;
//    }
//
//    /** M�todo para adicionar uma atividade.
//     * @param -
//     */
//    public void adicionarAtividade() {
//        // TODO implement here
//    }
//
//    /** M�todo para atualizar uma atividade.
//     * @param Atividade - Atividade a ser atualizada
//     */
//    public void atualizarAtividade(Atividade atividade) {
//        // TODO implement here
//    }
//
//    /** M�todo para a remo��o de uma atividade.
//     * @param Atividade - Atividade a ser removida.
//     */
//    public void removerAtividade(Atividade atividade) {
//        // TODO implement here
//    }
//
//    /** M�todo para visualizar uma atividade da turma.
//     * @return TurmaAtividade
//     */
//    public TurmaAtividade pesquisarTurmaAtividade() {
//    	return null;
//    }
//
//    /** M�todo para adicionar uma atividade da turma.
//     * @param -
//     */
//    public void adicionarTurmaAtivdade() {
//        // TODO implement here
//    }
//
//    /** M�todo para a remo��o de uma atividade da turma.
//     * @param TurmaAtividadeDAO - A ser removida
//     */
//    public void removerTurmaAtividade(TurmaAtividade turmaAtiv) {
//        // TODO implement here
//    }
//
//    /** M�todo para retorno da nota.
//     * @return Double - Nota
//     */
//    public double getNota() {
//        Resposta resposta =  new Resposta();
//        return resposta.getNota();
//    }
//
//    /** M�todo para criar uma nota.
//     * @param -
//     */
//    public void criarNota() {
//        // TODO implement here
//    }
//
//    /** M�todo para atualizar uma nota.
//     * @param Nota - Nota a ser atualizada.
//     */
//    public void atualizarNota(Resposta nota) {
//        // TODO implement here
//    }
//
//    /** M�todo para a remo��o de uma nota.
//     * @param Nota - Nota a ser removida.
//     */
//    public void removerNota(Resposta nota) {
//        // TODO implement here
//    }
//
//    /** M�todo para a visualiza��o das turmas do professor.
//     * @param - 
//     * @return Turma - Turmas do professor.
//     */
//    public Turma verTurmas() {
//        return null;
//    }
//
//    /** M�todo para pesquisar uma turma espec�fica.
//     * @param -
//     * @return Turma - Turma a ser pesquisada.
//     */
//    public Turma pequisarTurma() {
//        return null;
//    }
//
//    /** M�todo para visualizar as respostas para uma atividade.
//     * @param -
//     * @return Resposta - Respostas enviadas para uma atividade.
//     */
//    public Resposta verRespostasAtividade() {
//        return null;
//    }
//
//    /** M�todo para procurar uma resposta espec�fica para uma atividade.
//     * @param - 
//     * @return Resposta - Resposta de uma atividade.
//     */
//    public Resposta procurarRespostaAtividade() {
//        return null;
//    }
}