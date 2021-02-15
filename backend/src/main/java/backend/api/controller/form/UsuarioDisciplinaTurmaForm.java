package backend.api.controller.form;

public class UsuarioDisciplinaTurmaForm {
	private int idTurma;
	private String ano;
	
	public UsuarioDisciplinaTurmaForm() {
		
	}
	
	

	/**
	 * @param idTurma
	 * @param ano
	 */
	public UsuarioDisciplinaTurmaForm(int idTurma, String ano) {
		super();
		this.idTurma = idTurma;
		this.ano = ano;
	}



	/**
	 * @return the idTurma
	 */
	public int getIdTurma() {
		return idTurma;
	}

	/**
	 * @param idTurma the idTurma to set
	 */
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	/**
	 * @return the ano
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * @param ano the ano to set
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	
}
