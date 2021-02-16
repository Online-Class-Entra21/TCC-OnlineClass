package backend.api.controller.form;

public class UsuarioDisciplinaForm {

	private String nome;
	private int idDisciplina;
	
	/**
	 * Metodo construtor padrao 
	 */
	public UsuarioDisciplinaForm() {
	}

	/**
	 * Metodo construtor que preenche todos os atributos da classe 
	 * @param nome
	 * @param idDisciplina 
	 */
	public UsuarioDisciplinaForm(String nome, int idDisciplina) {
		setNome(nome);
		setIdDisciplina(idDisciplina);
	}

	/**
	 * Metodo para retorno do nome 
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo para insercao do nome 
	 * @param String nome 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo para retorno do idDisciplina 
	 * @return int idDisciplina
	 */
	public int getIdDisciplina() {
		return idDisciplina;
	}

	/**
	 * Metodo para insercao do idDisciplina 
	 * @param int idDisciplina
	 */
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
}
