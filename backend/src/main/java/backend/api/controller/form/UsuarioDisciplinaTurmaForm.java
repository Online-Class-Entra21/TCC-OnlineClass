package backend.api.controller.form;

public class UsuarioDisciplinaTurmaForm {

	private int idTurma;
	private String ano;
	
	/**
	 * Metodo construtor padrao
	 */
	public UsuarioDisciplinaTurmaForm() {
	}
	
	/**
	 * Metodo contrutor que preenche todos os atributos 
	 * @param idTurma
	 * @param ano
	 */
	public UsuarioDisciplinaTurmaForm(int idTurma, String ano) {
		setIdTurma(idTurma);
		setAno(ano);
	}

	/**
	 * Metodo para retorno do idTurma
	 * @return int idTurma
	 */
	public int getIdTurma() {
		return idTurma;
	}

	/**
	 * Metodo para insercao do idTurma 
	 * @param int idTurma 
	 */
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	/**
	 * Metodo para retorno do ano 
	 * @return String ano 
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * Metodo para insercao do ano 
	 * @param String ano 
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
}
