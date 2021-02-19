package backend.api.controller.form;

import java.sql.Timestamp;

public class RespostaVisualizacaoForm {
	
	private int idResposta;
	private String titulo;
	private int tipoAvaliacao;
	private int fk_aluno; 
	private Timestamp dataEntrega;
	private int fk_arquivo;
	private double nota;
	private String comentario;
	
	/**
	 * Metodo construtor padrao
	 */
	public RespostaVisualizacaoForm(){
	}
	
	/**
	 * Metodo construtor da classe resposta 
	 * @param idResposta
	 * @param titulo
	 * @param tipoAvaliacao
	 * @param fk_aluno
	 * @param dataEntrega
	 * @param fk_arquivo
	 * @param nota
	 * @param comentario
	 */
	public RespostaVisualizacaoForm(int idResposta, String titulo, int tipoAvaliacao, int fk_aluno, Timestamp dataEntrega,
			int fk_arquivo, double nota, String comentario) {
		
		setIdResposta(idResposta);
		setTitulo(titulo);
		setTipoAvaliacao(tipoAvaliacao);
		setFk_aluno(fk_aluno);
		setDataEntrega(dataEntrega);
		setFk_arquivo(fk_arquivo);
		setNota(nota);
		setComentario(comentario);
	}
	
	/**
	 * Metodo para retorno do idResposta 
	 * @return int idResposta 
	 */
	public int getIdResposta() {
		return idResposta;
	}

	/**
	 * Metodo para retorno do idResposta 
	 * @param int idResposta
	 */
	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}

	/**
	 * Meotodo para retorno da titulo 
	 * @return String titulo 
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Metodo para insercao da titulo 
	 * @param String titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Metodo para retorno do tipoAvaliacao 
	 * @return int tipoAvaliacao 
	 */
	public int getTipoAvaliacao() {
		return tipoAvaliacao;
	}
	
	/**
	 * Metodo para insercao do tipoAvaliacao 
	 * @param int tipoAvaliacao
	 */
	public void setTipoAvaliacao(int tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
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
	 * Metodo para retorno da dataEntrega 
	 * @return Timestamp dataEntrega 
	 */
	public Timestamp getDataEntrega() {
		return dataEntrega;
	}
	
	/**
	 * Metodo para insercao da dataEntrega 
	 * @param Timestamp dataEntrega
	 */
	public void setDataEntrega(Timestamp dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	/**
	 * Metodo para retorno do fk_arquivo
	 * @return int fk_arquivo
	 */
	public int getFk_arquivo() {
		return fk_arquivo;
	}
	
	/**
	 * Metodo para insercao do fk_ arquivo 
	 * @param int fk_arquivo
	 */
	public void setFk_arquivo(int fk_arquivo) {
		this.fk_arquivo = fk_arquivo;
	}
	
	/**
	 * Metodo para retorno da nota 
	 * @return double nota 
	 */
	public double getNota() {
		return nota;
	}
	
	/**
	 * Metodo para insercao da nota 
	 * @param double nota
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}

	/**
	 * Metodo para retorno do comentario 
	 * @return String comentario 
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Metodo para insercao do comentario 
	 * @param String comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
