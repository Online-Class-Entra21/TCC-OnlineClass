package backend.api.controller.form;

import java.sql.Timestamp;

public class TurmaAtividadeForm {
	private int idAtividade;
	private String tituloAtividade;
	private int tipoAtividade;
	private Timestamp finalAtividade;
	private int idDisciplina;
	private String disciplinaNome;
	
	public TurmaAtividadeForm() {
		
	}
	
	/**
	 * @param idAtividade
	 * @param tituloAtividade
	 * @param finalAtividade
	 * @param idDisciplina
	 * @param disciplinaNome
	 */
	public TurmaAtividadeForm(int idAtividade, String tituloAtividade, Timestamp finalAtividade, int idDisciplina,
			String disciplinaNome) {
		this.idAtividade = idAtividade;
		this.tituloAtividade = tituloAtividade;
		this.finalAtividade = finalAtividade;
		this.idDisciplina = idDisciplina;
		this.disciplinaNome = disciplinaNome;
	}

	/**
	 * @return the idAtividade
	 */
	public int getIdAtividade() {
		return idAtividade;
	}

	/**
	 * @param idAtividade the idAtividade to set
	 */
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}

	/**
	 * @return the tituloAtividade
	 */
	public String getTituloAtividade() {
		return tituloAtividade;
	}

	/**
	 * @param tituloAtividade the tituloAtividade to set
	 */
	public void setTituloAtividade(String tituloAtividade) {
		this.tituloAtividade = tituloAtividade;
	}

	/**
	 * @return the finalAtividade
	 */
	public Timestamp getFinalAtividade() {
		return finalAtividade;
	}

	/**
	 * @param finalAtividade the finalAtividade to set
	 */
	public void setFinalAtividade(Timestamp finalAtividade) {
		this.finalAtividade = finalAtividade;
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

	/**
	 * @return the disciplinaNome
	 */
	public String getDisciplinaNome() {
		return disciplinaNome;
	}

	/**
	 * @param disciplinaNome the disciplinaNome to set
	 */
	public void setDisciplinaNome(String disciplinaNome) {
		this.disciplinaNome = disciplinaNome;
	}

	/**
	 * @return the tipoAtividade
	 */
	public int getTipoAtividade() {
		return tipoAtividade;
	}

	/**
	 * @param tipoAtividade the tipoAtividade to set
	 */
	public void setTipoAtividade(int tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}
	
	
	
	
}
