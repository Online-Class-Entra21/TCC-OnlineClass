package entidade;

/**
 * Classe contendo metodos e atributos para a disciplina
 * @author Andrey 
 */
public class Disciplina {
	
    private int idDisciplina;
    private String nome;
    private int fk_escola;
    
    /**
     * Construtor padrao
     */
    public Disciplina() {
    	//Nenhum atributo inicializado
	}

    /**
     * Metodo construtor que preenche os atributos da classe 
     * @param idDisciplina
     * @param nome
     */
    public Disciplina(int idDisciplina, String nome, int fk_escola) {
    	setIdDisciplina(idDisciplina);
    	setNome(nome);
    	
    }
    
    /** 
     * Metodo para retorno do ID da disciplina
     * @return int idDisciplina 
     */
    public int getIdDisciplina() {
        return idDisciplina;
    }
    
    /**
     * Metodo para insercao do ID da disciplina 
     * @param int idDisciplina
     */
    public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

    /** 
     * Metodo para retorno do nome da disciplina
     * @return String nome 
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Metodo para insercao do nome da disciplina 
     * @param String nome
     */
    public void setNome(String nome) {
		this.nome = nome;
	}

    /**
     * Metodo para insercao do fk da escola 
     * @param int fk_escola
     */
	public int getFk_escola() {
		return fk_escola;
	}

	/**
     * Metodo para insercao do fk da escola 
     * @param int fk_escola
     */
	public void setFk_escola(int fk_escola) {
		this.fk_escola = fk_escola;
	}
}