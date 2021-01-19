package entidade;

import java.util.*;

/**
 * Classe contendo metodos e atributos para a criacao de atividades.
 * As atividades sao em formato de arquivo e podem ser criadas pelo Professor.
 * @author André  
 */
public class Atividade {
	
    private int idAtividade;
    private String descricao;
    private Date inicioAtividade;
    private Date finalAtividade;
    private int tipoAtividade;
    private double pesoNota;
    private int fk_usuario_disciplina;

    /**
     * Construtor usado ao instanciar a classe Atividade.
     * @param
     */
    public Atividade() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idAtividade
     * @param descricao
     * @param inicioAtividade
     * @param finalAtividade
     * @param tipoAtividade
     * @param pesoNota
     * @param fk_usuario_disciplina
     */
    public Atividade(int idAtividade, String descricao, Date inicioAtividade, Date finalAtividade, int tipoAtividade,
					 double pesoNota, int fk_usuario_disciplina) {
    	
		setIdAtividade(idAtividade);
		setDescricao(descricao);
		setInicioAtividade(inicioAtividade);
		setFinalAtividade(finalAtividade);
		setTipoAtividade(tipoAtividade);
		setPesoNota(pesoNota);
		setFk_usuario_disciplina(fk_usuario_disciplina);
	}

	/** 
     * Metodo para retorno do ID da atividade.
     * @return idAtividade 
     */
    public int getIdAtividade() {
        return idAtividade;
    }

    /**
     * Metodo para insercao do id da atividade 
     * @param idAtividade
     */
    public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}


	/** 
	 * Metodo para retorno da descricao da atividade.
     * @return descricao 
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo para insercao da descricao da atividade 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /** 
     * Metodo para retorno da data de inicio da atividade.
     * @return inicioAtividade 
     */
    public Date getInicioAtividade() {
        return inicioAtividade;
    }

    /**
     * Metodo para insercao da data de incio da atividade 
     * @param inicioAtividade
     */
    public void setInicioAtividade(Date inicioAtividade) {
        this.inicioAtividade = inicioAtividade;
    }

    /** 
     * Metodo para retorno da data final da atividade.
     * @return finalAtividade 
     */
    public Date getFinalAtividade() {
        return finalAtividade;
    }

    /**
     * Metodo para insercao da data final da atividade 
     * @param finalAtividade
     */
    public void setFinalAtividade(Date finalAtividade) {
        this.finalAtividade = finalAtividade;
    }

    /**
     * Metodo para retorno do tipo de atividade.
     * @return tipoAtividade 
     */
    public int getTipoAtividade() {
        return tipoAtividade;
    }

    /**
     * Metodo para insercao do tipo de atividade 
     * @param tipoAtividade
     */
    public void setTipoAtividade(int tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    /** 
     * Metodo para retorno do peso da nota.
     * @return pesoNota
     */
    public double getPesoNota() {
        return pesoNota;
    }

    /**
     * Metodo para insercao do peso da nota 
     * @param pesoNota
     */
    public void setPesoNota(double pesoNota) {
        this.pesoNota = pesoNota;
    }

    /**
     * Metodo para retorno do fk do usuario disciplina
     * @return
     */
	public int getFk_usuario_disciplina() {
		return fk_usuario_disciplina;
	}

	/**
	 * Metodo para insercao do fk do usuario disciplina 
	 * @param fk_usuario_disciplina
	 */
	public void setFk_usuario_disciplina(int fk_usuario_disciplina) {
		this.fk_usuario_disciplina = fk_usuario_disciplina;
	}
}