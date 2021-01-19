package entidade;

/**
 * Classe contendo metodos e atributos para o aluno.
 * Herda metodos e atributos da classe Usuario.
 * @see Usuario
 * @author André 
 */
public class Aluno extends Usuario {
    
	private int idAluno;
    private int ra;
    private int matricula;
    private boolean deficiencia;
    private String nomeMae;
    private String nomePai;
    private String nomeResponsavel;
    private boolean situacaoAnoLetivo;
    private int fk_usuario;
    private int fk_turma;
    
    /**
     * Construtor padrao
     */
    public Aluno() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe aluno 
     * @param idAluno
     * @param ra
     * @param matricula
     * @param deficiencia
     * @param nomeMae
     * @param nomePai
     * @param nomeResponsavel
     * @param situacaoAnoLetivo
     * @param fk_usuario
     * @param fk_turma
     */
    public Aluno(int idAluno, int ra, int matricula, boolean deficiencia, String nomeMae, String nomePai,
			String nomeResponsavel, boolean situacaoAnoLetivo, int fk_usuario, int fk_turma) {

    	setIdAluno(idAluno);
    	setRa(ra);
    	setMatricula(matricula);
    	setDeficiencia(deficiencia);
    	setNomeMae(nomeMae);
    	setNomePai(nomePai);
    	setNomeResponsavel(nomeResponsavel);
    	setSituacaoAnoLetivo(situacaoAnoLetivo);
    	setFk_usuario(fk_usuario);
    	setFk_turma(fk_turma);
	}

	/** 
     * Metodo para retorno do ID do aluno.
     * @return idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * Metodo para inserção do ID do aluno 
     * @param idAluno
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    /** 
     * Metodo para retorno do RA do aluno.
     * @return ra
     */
    public int getRa() {
        return ra;
    }

    /**
     * Metodo para inserção do RA
     * @param ra
     */
    public void setRa(int ra) {
        this.ra = ra;
    }

    /** 
     * Metodo para retorno da matricula do aluno.
     * @return matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Metodo para inserção de matricula 
     * @param matricula
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /** 
     * Metodo para retornar se o aluno possui alguma deficiencia fisica.
     * @return deficiencia
     */
    public boolean getDeficiencia() {
        return deficiencia;
    }

    /**
     * Metodo para insercao da deficiencia 
     * @param deficiencia
     */
    public void setDeficiencia(boolean deficiencia) {
        this.deficiencia = deficiencia;
    }

    /** 
     * Metodo para retorno do nome da mae do aluno.
     * @return nomeMae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * Metodo para insercao do nome da mae 
     * @param nomeMae
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae =  nomeMae;
    }

    /** 
     * Metodo para retorno do nome do pai do aluno.
     * @return nomePai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * Metodo para insercao do nome do pai 
     * @param nomePai
     */
    public void setNomePai(String nomePai) {
    	this.nomePai = nomePai;
    }

    /** 
     * Metodo para retorno do nome do responsavel pelo aluno.
     * @return nomeResponsavel
     */
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    /**
     * Metodo de inserção do nome do responsavel 
     * @param nomeResponsavel
     */
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    /** 
     * Metodo para retorno da situacao do ano letivo do aluno.
     * @return situacaoAnoLetivo
     */
    public boolean getSituacaoAnoLetivo() {
        return situacaoAnoLetivo;
    }

    /**
     * Metodo de insercao da situacao do ano letivo 
     * @param situacaoAnoLetivo
     */
    public void setSituacaoAnoLetivo(boolean situacaoAnoLetivo) {
        this.situacaoAnoLetivo = situacaoAnoLetivo;
    }

    /**
     * Metodo para retorno do FK do usuario
     * @return fk_usuario
     */
    public int getFk_usuario() {
		return fk_usuario;
	}

    /**
     * Metodo para inserção FK do usuario
     * @param fk_usuario
     */
	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	/**
     * Metodo de retorno da turma 
	 * @return fk_turma
	 */
	public int getFk_turma() {
		return fk_turma;
	}

	/**
	 * Metodo de insercao da turma 
	 * @param fk_turma
	 */
	public void setFk_turma(int fk_turma) {
		this.fk_turma = fk_turma;
	}
	
	
	
	//-----
	
	
	
	/** 
	 * Metodo para o envio de uma resposta de uma atividade.
     * @param 
     */
    public void mandarResposta(Resposta resposta) {
        // TODO implement here
    }

    /** 
     * Metodo para visualizar as respostas enviadas, a partir do banco de dados.
     * @param 
     * @retur
     */
    public Resposta verRespostasEnviadas() {
        return null;
    }

    /** 
     * Metodo para visualizar uma resposta enviada espec�fica, a partir do banco de dados.
     * @param 
     * @return
     */
    public Resposta buscarRespostaEnviada(Resposta resposta) {
        return null;
    }

    /** 
     * Metodo para a remocao de uma resposta.
     * @param 
     */
    public void removerResposta(Resposta resposta) {
        // TODO implement here
    }

    /** 
     * Metodo para visualizar as atividades recebidas, a partir do banco de dados.
     * @param 
     * @return
     */
    public Atividade verAtividadesRecebidas() {
        return null;
    }

    /** 
     * Metodo para visualizar uma atividade recebida especafica, a partir do banco de dados.
     * @param 
     * @return
     */
    public Atividade pesquisarAtividadeRecebida() {
        return null;
    }

    /** Metodo para a visualizacao das notas
     * @param 
     * @return
     */
    public Resposta verNotas() {
        return null;
    }

}