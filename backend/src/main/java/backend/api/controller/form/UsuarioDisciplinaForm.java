package backend.api.controller.form;

public class UsuarioDisciplinaForm {
	private String nome;
	private int idDisciplina;
	
	public UsuarioDisciplinaForm() {
		
	}

	/**
	 * @param nome
	 */
	public UsuarioDisciplinaForm(String nome, int idDisciplina) {
		this.nome = nome;
		this.idDisciplina = idDisciplina;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the idDisciplina
	 */
	public int getIdDisciplina() {
		return idDisciplina;
	}

	/**
	 * @param idDisciplina the idDisciplina to set
	 */
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	
	
}
