package entidade;

import java.util.*;

/**
 * Classe com m�todos e atributos para o per�odo de avalia��o.
 * @author 
 */
public class PeriodoAvaliacao {
    private int idPeriodoAvaliacao;
    private Date dataInicial;
    private Date dataFinal;
    private String descricao;
    private int idEscola;
    
    /**
     * Construtor usado ao instanciar a classe PeriodoAvaliacao.
     * @param
     */
    public PeriodoAvaliacao() {
    }

    
    public int getIdEscola() {
		return idEscola;
	}


	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
	}


	/** M�todo para retorno do ID do PeriodoAvaliacao.
     * @return Int - ID PeriodoAvaliacao
     */
    public int getIdPeriodoAvaliacao() {
        return idPeriodoAvaliacao;
    }

    /**
     * 
     */
    public void setIdPeriodoAvaliacao(int idPeriodoAvaliacao) {
        this.idPeriodoAvaliacao = idPeriodoAvaliacao;
    }

    /** M�todo para retorno da data inicial do PeriodoAvaliacao.
     * @return Date - Data inicial do PeriodoAvaliacao
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * 
     */
    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    /** M�todo para retorno da data final do PeriodoAvaliacao.
     * @return Date - Data final do PeriodoAvaliacao
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * 
     */
    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    /** M�todo para retorno da descri��o do PeriodoAvaliacao.
     * @return String -  Descri��o PeriodoAvaliacao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}