package backend.api.controller.form;

import java.sql.Timestamp;

public class RespostaForm {
	private int idResposta;
	private String comentarioAtividade;
	private Timestamp dataEntrega;
	private int fk_aluno;
	private int fk_atividade;
	private int fk_arquivo;
	
	public RespostaForm() {
		
	}

	/**
	 * @param idResposta
	 * @param comentarioAtividade
	 * @param dataEntrega
	 * @param fk_aluno
	 * @param fk_atividade
	 * @param fk_arquivo
	 */
	public RespostaForm(int idResposta, String comentarioAtividade, Timestamp dataEntrega, int fk_aluno,
			int fk_atividade, int fk_arquivo) {
		super();
		this.idResposta = idResposta;
		this.comentarioAtividade = comentarioAtividade;
		this.dataEntrega = dataEntrega;
		this.fk_aluno = fk_aluno;
		this.fk_atividade = fk_atividade;
		this.fk_arquivo = fk_arquivo;
	}
	

	/**
	 * @return the idResposta
	 */
	public int getIdResposta() {
		return idResposta;
	}

	/**
	 * @param idResposta the idResposta to set
	 */
	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}

	/**
	 * @return the comentarioAtividade
	 */
	public String getComentarioAtividade() {
		return comentarioAtividade;
	}

	/**
	 * @param comentarioAtividade the comentarioAtividade to set
	 */
	public void setComentarioAtividade(String comentarioAtividade) {
		this.comentarioAtividade = comentarioAtividade;
	}

	/**
	 * @return the dataEntrega
	 */
	public Timestamp getDataEntrega() {
		return dataEntrega;
	}

	/**
	 * @param dataEntrega the dataEntrega to set
	 */
	public void setDataEntrega(Timestamp dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	/**
	 * @return the fk_aluno
	 */
	public int getFk_aluno() {
		return fk_aluno;
	}

	/**
	 * @param fk_aluno the fk_aluno to set
	 */
	public void setFk_aluno(int fk_aluno) {
		this.fk_aluno = fk_aluno;
	}

	/**
	 * @return the fk_atividade
	 */
	public int getFk_atividade() {
		return fk_atividade;
	}

	/**
	 * @param fk_atividade the fk_atividade to set
	 */
	public void setFk_atividade(int fk_atividade) {
		this.fk_atividade = fk_atividade;
	}

	/**
	 * @return the fk_arquivo
	 */
	public int getFk_arquivo() {
		return fk_arquivo;
	}

	/**
	 * @param fk_arquivo the fk_arquivo to set
	 */
	public void setFk_arquivo(int fk_arquivo) {
		this.fk_arquivo = fk_arquivo;
	}
	
	
	
}
