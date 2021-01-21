package entidade;

/**
 * Herda metodos e atributos da classe Sala.
 * Cada turma tem uma sala como padrao
 * @see Sala
 * @see Turma
 * @author Breno
 */
public class SalaPadrao extends Sala {

	/**
     * construtor padrao
     */
    public SalaPadrao() {
    	//Nenhum atributo inicializado 
    }

    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idSala
     * @param nome
     * @param descricao
     * @param situacaoAcesso
     * @param link
     */
	public SalaPadrao(int idSala, String nome, String descricao, boolean situacaoAcesso, String link) {
		super(idSala, nome, descricao, situacaoAcesso, false, link);
	}
}