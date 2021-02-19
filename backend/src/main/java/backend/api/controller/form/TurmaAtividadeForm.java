package backend.api.controller.form;

import java.sql.Timestamp;

public class TurmaAtividadeForm {

	private int idAtividade;
	private String tituloAtividade;
	private int tipoAtividade;
	private Timestamp finalAtividade;
	private int fk_arquivo;
	private int idDisciplina;
	private String disciplinaNome;
	
	/**
	 * Metodo contrutor padrao
	 */
	public TurmaAtividadeForm() {
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos 
	 * @param idAtividade
	 * @param tituloAtividade
	 * @param finalAtividade
	 * @param idDisciplina
	 * @param disciplinaNome
	 */
	public TurmaAtividadeForm(int idAtividade, String tituloAtividade, Timestamp finalAtividade, int idDisciplina,
			String disciplinaNome) {

		setIdDisciplina(idDisciplina);
		setTituloAtividade(tituloAtividade);
		setFinalAtividade(finalAtividade);
		setIdDisciplina(idDisciplina);
		setDisciplinaNome(disciplinaNome);
	}

	/**
	 * Metodo para retorno do idAtividade 
	 * @return int idAtividade
	 */
	public int getIdAtividade() {
		return idAtividade;
	}

	/**
	 * Metodo para insercao do idAtividade 
	 * @param int idAtividade
	 */
	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}

	/**
	 * Metodo para retorno do tituloAtividade 
	 * @return String tituloAtividade
	 */
	public String getTituloAtividade() {
		return tituloAtividade;
	}

	/**
	 * Metodo para insercao do tituloAtividade 
	 * @param String tituloAtividade
	 */
	public void setTituloAtividade(String tituloAtividade) {
		this.tituloAtividade = tituloAtividade;
	}

	/**
	 * Metodo para retorno do finalAtividade
	 * @return Timestamp finalAtividade
	 */
	public Timestamp getFinalAtividade() {
		return finalAtividade;
	}

	/**
	 * Metodo para insercao do finalAtividade 
	 * @param Timestamp finalAtividade
	 */
	public void setFinalAtividade(Timestamp finalAtividade) {
		this.finalAtividade = finalAtividade;
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

	/**
	 * Metodo para retorno da disciplinaNome
	 * @return String disciplinaNome
	 */
	public String getDisciplinaNome() {
		return disciplinaNome;
	}

	/**
	 * Metodo para insercao da disciplinaNome 
	 * @param String disciplinaNome
	 */
	public void setDisciplinaNome(String disciplinaNome) {
		this.disciplinaNome = disciplinaNome;
	}

	/**
	 * Metodo para retorno do tipoAtividade
	 * @return int tipoAtividade
	 */
	public int getTipoAtividade() {
		return tipoAtividade;
	}

	/**
	 * Metodo para insercao do tipoAtividade
	 * @param int tipoAtividade
	 */
	public void setTipoAtividade(int tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	/**
	 * Metodo para retorno do fk_arquivo 
	 * @return int fk_arquivo
	 */
	public int getFk_arquivo() {
		return fk_arquivo;
	}

	/**
	 * Metodo para insercao do fk_arquivo 
	 * @param int fk_arquivo
	 */
	public void setFk_arquivo(int fk_arquivo) {
		this.fk_arquivo = fk_arquivo;
	}
}
