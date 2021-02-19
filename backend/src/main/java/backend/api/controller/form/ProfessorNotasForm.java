package backend.api.controller.form;

import java.sql.Timestamp;

public class ProfessorNotasForm {

	private String ano;
	private Timestamp dataEntrega;
	private String titulo;
	private double nota;
	private String nome;
	
	/**
	 * Metodo construtor padrao 
	 */
	public ProfessorNotasForm() {	
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos da classe
	 * @param ano
	 * @param dataEntrega
	 * @param titulo
	 * @param nota
	 */
	public ProfessorNotasForm(String ano, Timestamp dataEntrega, String titulo, double nota, String nome) {
		setAno(ano);
		setDataEntrega(dataEntrega);
		setTitulo(titulo);
		setNota(nota);
		setNome(nome);
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
	 * Metodo para retorno do titulo
	 * @return String titulo 
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo para insercao do titulo
	 * @param String titulo 
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	 * Metodo para retorno do nome 
	 * @return String nome 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo para insercao do nome 
	 * @param String nome 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}
