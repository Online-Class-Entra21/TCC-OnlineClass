package backend.api.controller.form;

import java.sql.Timestamp;

public class RespostaForm {

	private int idResposta;
	private String comentarioAtividade;
	private Timestamp dataEntrega;
	private int fk_aluno;
	private int fk_atividade;
	private int fk_arquivo;
	
	/**
	 * Metodo construto padrao
	 */
	public RespostaForm() {
	}

	/**
	 * Metodo construtor que preenche todos os atributos da classe 
	 * @param idResposta
	 * @param comentarioAtividade
	 * @param dataEntrega
	 * @param fk_aluno
	 * @param fk_atividade
	 * @param fk_arquivo
	 */
	public RespostaForm(int idResposta, String comentarioAtividade, Timestamp dataEntrega, int fk_aluno,
			int fk_atividade, int fk_arquivo) {
		setIdResposta(idResposta);
		setComentarioAtividade(comentarioAtividade);
		setDataEntrega(dataEntrega);
		setFk_aluno(fk_aluno);
		setFk_atividade(fk_atividade);
		setFk_arquivo(fk_arquivo);
	}
	

	/**
	 * Metodo para retorno do idResposta 
	 * @return int idResposta
	 */
	public int getIdResposta() {
		return idResposta;
	}

	/**
	 * Metodo para insercao do idResposta 
	 * @param int idResposta
	 */
	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}

	/**
	 * Metodo para retorno do comentario da atividade 
	 * @return String comentarioAtividade
	 */
	public String getComentarioAtividade() {
		return comentarioAtividade;
	}

	/**
	 * Metodo para insercao do comentario da atividade 
	 * @param String comentarioAtividade
	 */
	public void setComentarioAtividade(String comentarioAtividade) {
		this.comentarioAtividade = comentarioAtividade;
	}

	/**
	 * Metodo para retorno da data de entrega 
	 * @return Timestamp dataEntrega
	 */
	public Timestamp getDataEntrega() {
		return dataEntrega;
	}

	/**
	 * Metodo para insercao da data de entrega 
	 * @param Timestamp dataEntrega 
	 */
	public void setDataEntrega(Timestamp dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	/**
	 * Metodo para retorno do fk_aluno
	 * @return int fk_aluno
	 */
	public int getFk_aluno() {
		return fk_aluno;
	}

	/**
	 * Metodo para insercao do fk_aluno
	 * @param int fk_aluno
	 */
	public void setFk_aluno(int fk_aluno) {
		this.fk_aluno = fk_aluno;
	}

	/**
	 * Metodo para retorno do fk_atividade 
	 * @return int fk_atividade
	 */
	public int getFk_atividade() {
		return fk_atividade;
	}

	/**
	 * Metodo para insercao do fk_atividade 
	 * @param int fk_atividade
	 */
	public void setFk_atividade(int fk_atividade) {
		this.fk_atividade = fk_atividade;
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
