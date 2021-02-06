package entidade;

import java.sql.Timestamp;

/**
 * Classe contendo metodos e atributos para as devidas funcoes da escola
 * @author Andrey
 */
public class Escola {
	
    private int idEscola;
    private String nome;
    private Timestamp dataInicioLetivo;
    private Timestamp dataFinalLetivo;

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
    public Escola(int idEscola, String nome, Timestamp dataInicioLetivo, Timestamp dataFinalLetivo) {
		setIdEscola(idEscola);
		setNome(nome);
		setDataInicioLetivo(dataInicioLetivo);
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
     * @return Timestamp dataInicioLetivo
     */
    public Timestamp getDataInicioLetivo() {
        return dataInicioLetivo;

    }

    /**
     * Metodo para insercao da data de inicio do ano letivo 
     * @param Timestamp dataInicioLetivo
     */
    public void setDataInicioLetivo(Timestamp dataInicioLetivo) {
    	this.dataInicioLetivo = dataInicioLetivo;
    }

    /** 
     * Metodo para retorno da data final do ano letivo
     * @return Timestamp dataFinalLetivo
     */
    public Timestamp getDataFinalLetivo() {
        return dataFinalLetivo;
    }

    /**
     * Metodo para insercao da data final do ano letivo 
     * @param Timestamp dataFinalLetivo
     */
    public void setDataFinalLetivo(Timestamp dataFinalLetivo) {
        this.dataFinalLetivo = dataFinalLetivo;
    }
}