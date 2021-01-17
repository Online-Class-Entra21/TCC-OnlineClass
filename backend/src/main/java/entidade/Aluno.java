package entidade;

/**
 * Classe contendo metodos e atributos para o aluno.
 * Herda metodos e atributos da classe Usuario.
 * @see Usuario
 * @author  
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
    private Usuario usuario;
    private Turma turma;
    
    /**
     * Construtor padrao
     */
    public Aluno() {    	
    }
    
	/**
	 * Método construtor preenchendo todas as informações 
	 * @param idAluno
	 * @param ra
	 * @param matricula
	 * @param deficienciaFisica
	 * @param nomeMae
	 * @param nomePai
	 * @param nomeResponsavel
	 * @param situacaoAnoLetivo
	 * @param usuario
	 * @param turma
	 */
    public Aluno(int idAluno, int ra, int matricula, boolean deficienciaFisica, 
    			 String nomeMae, String nomePai, String nomeResponsavel, boolean situacaoAnoLetivo,
    			 Usuario usuario, Turma turma) {
    	
    	setIdAluno(idAluno);
    	setRa(ra);
    	setMatricula(matricula);
    	setDeficiencia(deficienciaFisica);
    	setNomeMae(nomeMae);
    	setNomePai(nomePai);
    	setNomeResponsavel(nomeResponsavel);
    	setSituacaoAnoLetivo(situacaoAnoLetivo);
    	setUsuario(usuario);
    	setTurma(turma);
    }

    /** 
     * Metodo para retorno do ID do aluno.
     * @return Int - ID do usuUrio
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * Metodo para inserção do id do aluno 
     * @param idAluno
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    /** 
     * Metodo para retorno do RA do aluno.
     * @return Int - RA do usuurio
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
     * Metodo para retorno da matr�cula do aluno.
     * @return String - Matricula do usu�rio
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
     * @return Boolean - Possui deficiencia f�sica? True / False
     */
    public boolean getDeficiencia() {
        return deficiencia;
    }

    /**
     * Metodo para inserção da deficiencia 
     * @param deficienciaFisica
     */
    public void setDeficiencia(boolean deficienciaFisica) {
        this.deficiencia = deficienciaFisica;
    }

    /** 
     * Metodo para retorno do nome da mae do aluno.
     * @return String - Nome do mae do aluno
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * Metodo para inserção do nome da mae 
     * @param nomeMae
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae =  nomeMae;
    }

    /** 
     * Metodo para retorno do nome do pai do aluno.
     * @return String - Nome do pai do aluno
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * Metodo para inserção do nome do pai 
     * @param nomePai
     */
    public void setNomePai(String nomePai) {
    	this.nomePai = nomePai;
    }

    /** 
     * Metodo para retorno do nome do responsavel pelo aluno.
     * @return String - Nome do respons�vel pelo aluno
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
     * @return Boolean - True para aprovado / False para reprovado
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
     * Método para retorno do Usuario
     * @return
     */
    public Usuario getUsuario() {
		return usuario;
	}

    /**
     * Método para inserção do Usuario
     * @param usuario
     */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	/**
     * Metodo de retorno da turma 
	 * @return the turma
	 */
	public Turma getTurma() {
		return turma;
	}
	
	/**
	 * Metodo de insercao da turma 
	 * @param turma the turma to set
	 */
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	/** 
	 * Metodo para o envio de uma resposta de uma atividade.
     * @param Resposta - Resposta a ser enviada.
     */
    public void mandarResposta(Resposta resposta) {
        // TODO implement here
    }

    /** 
     * Metodo para visualizar as respostas enviadas, a partir do banco de dados.
     * @param -
     * @return Resposta - Retorna as respostas enviadas.
     */
    public Resposta verRespostasEnviadas() {
        return null;
    }

    /** 
     * Metodo para visualizar uma resposta enviada espec�fica, a partir do banco de dados.
     * @param -
     * @return Resposta - Retorna uma resposta.
     */
    public Resposta buscarRespostaEnviada(Resposta resposta) {
        return null;
    }

    /** 
     * Metodo para a remocao de uma resposta.
     * @param Resposta - Resposta a ser removida.
     */
    public void removerResposta(Resposta resposta) {
        // TODO implement here
    }

    /** 
     * Metodo para visualizar as atividades recebidas, a partir do banco de dados.
     * @param -
     * @return Atividade - Retorna as atividades recebidas.
     */
    public Atividade verAtividadesRecebidas() {
        return null;
    }

    /** 
     * Metodo para visualizar uma atividade recebida espec�fica, a partir do banco de dados.
     * @param -
     * @return Atividade - retorna uma atividade.
     */
    public Atividade pesquisarAtividadeRecebida() {
        return null;
    }

    /** Metodo para a visualiza��o das notas
     * @param -
     * @return Resposta - Retorna as notas.
     */
    public Resposta verNotas() {
        return null;
    }

}