package entidade;

import java.sql.Timestamp;

/**
 * Classe com metodos e atributos para o periodo de avaliacao
 * @author Andrey 
 */
public class PeriodoAvaliacao {
	
    private int idPeriodoAvaliacao;
    private Timestamp dataInicial;
    private Timestamp dataFinal;
    private String descricao;
    private int fk_escola;
    
    /**
     * Construtor padrao
     */
    public PeriodoAvaliacao() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos 
     * @param idPeriodoAvaliacao
     * @param dataInicial
     * @param dataFinal
     * @param descricao
     * @param fk_escola
     */
	public PeriodoAvaliacao(int idPeriodoAvaliacao, Timestamp dataInicial, Timestamp dataFinal, String descricao, int fk_escola) {
		setIdPeriodoAvaliacao(idPeriodoAvaliacao);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
		setDescricao(descricao);
		setFk_escola(fk_escola);
	}

	/** 
	 * Metodo para retorno do ID do PeriodoAvaliacao
     * @return int idPeriodoAvaliacao
     */
    public int getIdPeriodoAvaliacao() {
        return idPeriodoAvaliacao;
    }

    /**
     * Metodo para insercao do periodo de avaliacao 
     * @param int idPeriodoAvaliacao
     */
    public void setIdPeriodoAvaliacao(int idPeriodoAvaliacao) {
        this.idPeriodoAvaliacao = idPeriodoAvaliacao;
    }

    /** 
     * Metodo para retorno da data inicial do PeriodoAvaliacao
     * @return Timestamp dataInicial
     */
    public Timestamp getDataInicial() {
        return dataInicial;
    }

    /**
     * Metodo para insercao da data inicial do PeriodoAvaliacao 
     * @param Timestamp dataInicial
     */
    public void setDataInicial(Timestamp dataInicial) {
        this.dataInicial = dataInicial;
    }

    /** 
     * Metodo para retorno da data final do PeriodoAvaliacao
     * @return Timestamp dataFinal
     */
    public Timestamp getDataFinal() {
        return dataFinal;
    }

    /**
     * Metodo para insercao da data final do PeriodoAvaliacao 
     * @param Timestamp dataFinal
     */
    public void setDataFinal(Timestamp dataFinal) {
        this.dataFinal = dataFinal;
    }

    /** 
     * Metodo para retorno da descricao do PeriodoAvaliacao
     * @return String descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo para insercao da descricao do 
     * @param String descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo para retorno do FK da escola
     * @return int fk_escola
     */
	public int getFk_escola() {
		return fk_escola;
	}

	/**
	 * Metodo para insercao do FK da escola 
	 * @param int fk_escola
	 */
	public void setFk_escola(int fk_escola) {
		this.fk_escola = fk_escola;
	}
}