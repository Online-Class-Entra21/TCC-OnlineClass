package entidade;

import java.util.*;

/**
 * Classe com metodos e atributos para o periodo de avaliacao.
 * @author Andrey 
 */
public class PeriodoAvaliacao {
	
    private int idPeriodoAvaliacao;
    private Date dataInicial;
    private Date dataFinal;
    private String descricao;
    private int fk_escola;
    
    /**
     * Construtor padrao
     * @param
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
	public PeriodoAvaliacao(int idPeriodoAvaliacao, Date dataInicial, Date dataFinal, String descricao, int fk_escola) {
		setIdPeriodoAvaliacao(idPeriodoAvaliacao);
		setDataInicial(dataInicial);
		setDataFinal(dataFinal);
		setDescricao(descricao);
		setFk_escola(fk_escola);
	}

	/** 
	 * Metodo para retorno do ID do PeriodoAvaliacao
     * @return idPeriodoAvaliacao
     */
    public int getIdPeriodoAvaliacao() {
        return idPeriodoAvaliacao;
    }

    /**
     * Metodo para insercao do periodo de avaliacao 
     * @param idPeriodoAvaliacao
     */
    public void setIdPeriodoAvaliacao(int idPeriodoAvaliacao) {
        this.idPeriodoAvaliacao = idPeriodoAvaliacao;
    }

    /** 
     * Metodo para retorno da data inicial do PeriodoAvaliacao
     * @return dataInicial
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * Metodo para insercao da data inicial do PeriodoAvaliacao 
     * @param dataInicial
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /** 
     * Metodo para retorno da data final do PeriodoAvaliacao
     * @return dataFinal
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * Metodo para insercao da data final do PeriodoAvaliacao 
     * @param dataFinal
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    /** 
     * Metodo para retorno da descricao do PeriodoAvaliacao
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo para insercao da descricao do 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Metodo para retorno do FK da escola
     * @return fk_escola
     */
	public int getFk_escola() {
		return fk_escola;
	}

	/**
	 * Metodo para insercao do FK da escola 
	 * @param fk_escola
	 */
	public void setFk_escola(int fk_escola) {
		this.fk_escola = fk_escola;
	}
}