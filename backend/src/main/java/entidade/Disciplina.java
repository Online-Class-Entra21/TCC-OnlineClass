package entidade;

/**
 * Classe contendo metodos e atributos para a disciplina
 * @author Andrey 
 */
public class Disciplina {
	
    private int idDisciplina;
    private String nome;
    
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
    public Disciplina(int idDisciplina, String nome, int numeroAulas) {
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
}