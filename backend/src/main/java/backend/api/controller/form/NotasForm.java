package backend.api.controller.form;

import java.sql.Timestamp;

public class NotasForm {
	
	private String periodo;
	private String materia;
	private Timestamp dataNota;
	private String tipoAvaliacao;
	private double nota;
	
	/**
	 * Metodo para retorno do periodo
	 * @return String periodo
	 */
	public String getPeriodo() {
		return periodo;
	}
	
	/**
	 * Metodo para insercao do periodo 
	 * @param String periodo
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	/**
	 * Metodo para retorno da materia 
	 * @return String materia 
	 */
	public String getMateria() {
		return materia;
	}
	
	/**
	 * Metodo para insercao da materia 
	 * @param String materia
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}
	
	/**
	 * Metodo para retorno da data da nota 
	 * @return Timestamp dataNota 
	 */
	public Timestamp getDataNota() {
		return dataNota;
	}
	
	/**
	 * Metodo para insercao da data da nota
	 * @param Timestamp dataNota
	 */
	public void setDataNota(Timestamp dataNota) {
		this.dataNota = dataNota;
	}
	
	/**
	 * Metodo para retorno do tipo da avaliacao
	 * @return String tipoAvaliacao
	 */
	public String getTipoAvaliacao() {
		return tipoAvaliacao;
	}
	
	/**
	 * Metodo para insercao do tipo da avaliacao 
	 * @param String tipoAvaliacao
	 */
	public void setTipoAvaliacao(String tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
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
}
