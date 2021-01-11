package entidade;

import java.util.*;

/**
 * Classe com métodos e atributos para o período de avaliação.
 * @author 
 */
public class PeriodoAvaliacao {
    private int idPeriodoAvaliacao;
    private Date dataInicial;
    private Date dataFinal;
    private String descricao;
    
    /**
     * Construtor usado ao instanciar a classe PeriodoAvaliacao.
     * @param
     */
    public PeriodoAvaliacao() {
    }


    /** Método para retorno do ID do PeriodoAvaliacao.
     * @return Int - ID PeriodoAvaliacao
     */
    public int getIdPeriodoAvaliacao() {
        return idPeriodoAvaliacao;
    }

    /**
     * 
     */
    public void setIdPeriodoAvaliacao() {
        // TODO implement here
    }

    /** Método para retorno da data inicial do PeriodoAvaliacao.
     * @return Date - Data inicial do PeriodoAvaliacao
     */
    public Date getDataInicial() {
        return dataInicial;
    }

    /**
     * 
     */
    public void setDataInicial() {
        // TODO implement here
    }

    /** Método para retorno da data final do PeriodoAvaliacao.
     * @return Date - Data final do PeriodoAvaliacao
     */
    public Date getDataFinal() {
        return dataFinal;
    }

    /**
     * 
     */
    public void setDataFinal() {
        // TODO implement here
    }

    /** Método para retorno da descrição do PeriodoAvaliacao.
     * @return String -  Descrição PeriodoAvaliacao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * 
     */
    public void setDescricao() {
        // TODO implement here
    }

}