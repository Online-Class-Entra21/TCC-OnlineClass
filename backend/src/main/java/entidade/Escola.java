package entidade;

import java.sql.Date;

/**
 * Classe contendo metodos e atributos para as devidas funcoes da escola
 * @author Andrey
 */
public class Escola {
	
    private int idEscola;
    private String nome;
    private Date dataInicioLetivo;
    private Date dataFinalLetivo;

    /**
     * Construtor padrao
     */
    public Escola() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche os atributos da classe 
     * @param idEscola
     * @param nome
     * @param dataInicioLetivo
     * @param dataFinalLetivo
     */
    public Escola(int idEscola, String nome, Date dataInicioLetivo, Date dataFinalLetivo) {
		setIdEscola(idEscola);
		setNome(nome);
		setDataInicioLeitvo(dataInicioLetivo);
		setDataFinalLetivo(dataFinalLetivo);
	}

    /** 
     * Metodo para retorno do ID da escola
     * @return int idEscola
     */
    public int getIdEscola() {
        return idEscola;
    }

    /**
     * Metodo para insercao do ID da escola 
     * @param int idEscola
     */
    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    /** 
     * Metodo para retorno do nome da escola
     * @return String nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo para insercao do nome da escola 
     * @param String nome
     */
    public void setNome(String nome) {
    	this.nome = nome;
    }

    /** 
     * Metodo para retorno da data de inicio do ano letivo
     * @return Date dataInicioLetivo
     */
    public Date getDataInicioLetivo() {
        return dataInicioLetivo;

    }

    /**
     * Metodo para insercao da data de inicio do ano letivo 
     * @param Date dataInicioLetivo
     */
    public void setDataInicioLeitvo(Date dataInicioLetivo) {
    	this.dataInicioLetivo = dataInicioLetivo;
    }

    /** 
     * Metodo para retorno da data final do ano letivo
     * @return Date dataFinalLetivo
     */
    public Date getDataFinalLetivo() {
        return dataFinalLetivo;
    }

    /**
     * Metodo para insercao da data final do ano letivo 
     * @param Date dataFinalLetivo
     */
    public void setDataFinalLetivo(Date dataFinalLetivo) {
        this.dataFinalLetivo = dataFinalLetivo;
    }
}