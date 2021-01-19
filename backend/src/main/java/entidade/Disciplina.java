package entidade;

/**
 * Classe contendo metodos e atributos para a disciplina.
 * @author André 
 */
public class Disciplina {
	
    private int idDisciplina;
    private String nome;
    private int numeroAulas;
    
    /**
     * Construtor padrao
     */
    public Disciplina() {
    	//Nenhum atributo inicializado
	}

    /**
     * Metodo construtor que preenche os atributos da classe 
     * @param
     */
    public Disciplina(int idDisciplina, String nome, int numeroAulas) {
    	setIdDisciplina(idDisciplina);
    	setNome(nome);
    	setNumeroAulas(numeroAulas);
    }
    
    /** 
     * Metodo para retorno do ID da disciplina
     * @return idDisciplina 
     */
    public int getIdDisciplina() {
        return idDisciplina;
    }
    
    /**
     * Metodo para insercao do ID da disciplina 
     * @param idDisciplina
     */
    public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

    /** 
     * Metodo para retorno do nome da disciplina
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Metodo para insercao do nome da disciplina 
     * @param nome
     */
    public void setNome(String nome) {
		this.nome = nome;
	}

    /** 
     * Metodo para retorno do numero de aulas da disciplina
     * @return numeroAulas
     */
    public int getNumeroAulas() {
        return numeroAulas;
    }

    /**
     * Metodo para insercao do numero de aulas 
     * @param numeroAulas
     */
	public void setNumeroAulas(int numeroAulas) {
		this.numeroAulas = numeroAulas;
	}
}