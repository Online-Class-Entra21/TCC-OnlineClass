package backend.api.controller.form;

import java.sql.Timestamp;

public class ProfessorNotasForm {
	private String ano;
	private Timestamp dataEntrega;
	private String titulo;
	private double nota;
	
	public ProfessorNotasForm() {
		
	}
	
	/**
	 * @param ano
	 * @param dataEntrega
	 * @param titulo
	 * @param nota
	 */
	public ProfessorNotasForm(String ano, Timestamp dataEntrega, String titulo, double nota) {
		this.ano = ano;
		this.dataEntrega = dataEntrega;
		this.titulo = titulo;
		this.nota = nota;
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
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the nota
	 */
	public double getNota() {
		return nota;
	}
	/**
	 * @param nota the nota to set
	 */
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
}
