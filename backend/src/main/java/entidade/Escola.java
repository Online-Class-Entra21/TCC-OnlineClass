package entidade;

import java.sql.Date;

/**
 * Classe contendo metodos e atributos para as devidas funcoes da escola.
 * @author Andrey
 */
public class Escola {
	
    private int idEscola;
    private String nome;
    private Date dataInicioLetivo;
    private Date dataFinalLetivo;

    /**
     * Construtor usado ao instanciar a classe Escola
     * @param
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
     * @return idEscola
     */
    public int getIdEscola() {
        return idEscola;
    }

    /**
     * Metodo para insercao do ID da escola 
     * @param idEscola
     */
    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    /** 
     * Metodo para retorno do nome da escola
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo para insercao do nome da escola 
     * @param nome
     */
    public void setNome(String nome) {
    	this.nome = nome;
    }

    /** 
     * Metodo para retorno da data de inicio do ano letivo
     * @return dataInicioLetivo
     */
    public Date getDataInicioLetivo() {
        return dataInicioLetivo;

    }

    /**
     * Metodo para insercao da data de inicio do ano letivo 
     * @param dataInicioLetivo
     */
    public void setDataInicioLeitvo(Date dataInicioLetivo) {
    	this.dataInicioLetivo = dataInicioLetivo;
    }

    /** 
     * Metodo para retorno da data final do ano letivo
     * @return dataFinalLetivo
     */
    public Date getDataFinalLetivo() {
        return dataFinalLetivo;
    }

    /**
     * Metodo para insercao da data final do ano letivo 
     * @param dataFinalLetivo
     */
    public void setDataFinalLetivo(Date dataFinalLetivo) {
        this.dataFinalLetivo = dataFinalLetivo;
    }
    
    
    
    //------------------
    
    

//    /** M�todo para buscar um periodo de avalia��o espec�fico.
//     * @return PeriodoAvaliacao
//     */
//    public PeriodoAvaliacao buscarPeriodo() {
//        return null;
//    }
//
//    /** M�todo para adicionar um per�odo de avalia��o.
//     * @param -
//     */
//    public void adicionarPeriodo() {
//        // TODO implement here
//    }
}