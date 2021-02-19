package entidade;

import java.util.*;

/**
 * Classe contendo metodos e atributos para o envio de uma resposta a uma atividade especifica.
 * Rrespostas sao enviadas pelo Aluno
 * @see Aluno
 * @see Atividade
 * @author Andrey 
 */
public class Resposta {
	
    private int idResposta;
    private double nota;
    private String comentarioAtividade;
    private boolean correcaoAtividade;
    private Date dataEntrega;
    private int fk_aluno;
    private int fk_atividade;
    private int fk_arquivo;

    /**
     * Construtor padrao
     */
    public Resposta() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todos os atributos da classe
     * @param idResposta
     * @param nota
     * @param comentarioAtividade
     * @param correcaoAtividade
     * @param dataEntrega
     * @param fk_aluno
     * @param fk_Atividade
     */
	public Resposta(int idResposta, double nota, String comentarioAtividade, boolean correcaoAtividade,
			Date dataEntrega, int fk_aluno, int fk_Atividade) {
		
		setIdResposta(idResposta);
		setNota(nota);
		setComentarioAtividade(comentarioAtividade);
		setCorrecaoAtividade(correcaoAtividade);
		setDataEntrega(dataEntrega);
		setFk_aluno(fk_aluno);
		setFk_atividade(fk_Atividade);
	}

	/** 
	 * Metodo para retorno do ID da resposta
     * @return int idResposta
     */
    public int getIdResposta() {
        return idResposta;
    }

    /**
     * Metodo para insercao do ID da resposta 
     * @param int idResposta
     */
    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
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
     * Metodo para retorno de um comentario na atividade
     * @return String comantarioAtividade
     */
    public String getComentarioAtividade() {
        return comentarioAtividade;
    }
    
    /**
     * Metodo para insercao de um comentario na atividade 
     * @param String comentarioAtividade
     */
    public void setComentarioAtividade(String comentarioAtividade) {
		this.comentarioAtividade = comentarioAtividade;
	}

	/** 
     * Metodo para retorno se a atividade foi corrigida 
     * @return boolean correcaoAtividade 
     */
    public boolean getCorrecaoAtividade() {
        return correcaoAtividade;
    }
    
    /**
     * Metodo para insercao da situacao da atividade corrigida 
     * @param boolean correcaoAtividade
     */
	public void setCorrecaoAtividade(boolean correcaoAtividade) {
		this.correcaoAtividade = correcaoAtividade;
	}

    /** 
     * Metodo para retorno da data de entrega
     * @return Date dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * Metodo para insercao da data de entrega 
     * @param Date dataEntrega
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * Metodo para retorno do FK do aluno 
     * @return int fk_aluno
     */
	public int getFk_aluno() {
		return fk_aluno;
	}

	/**
	 * Metodo para insercao do FK do aluno 
	 * @param int fk_aluno
	 */
	public void setFk_aluno(int fk_aluno) {
		this.fk_aluno = fk_aluno;
	}

	/**
	 * Metodo para retorno do FK da atividade 
	 * @return int fk_atividade 
	 */
	public int getFk_atividade() {
		return fk_atividade;
	}

	/**
	 * Metodo para insercao do FK da atividade 
	 * @param int fk_Atividade
	 */
	public void setFk_atividade(int fk_atividade) {
		this.fk_atividade = fk_atividade;
	}

	/**
	 * @return the fk_arquivo
	 */
	public int getFk_arquivo() {
		return fk_arquivo;
	}

	/**
	 * @param fk_arquivo the fk_arquivo to set
	 */
	public void setFk_arquivo(int fk_arquivo) {
		this.fk_arquivo = fk_arquivo;
	}
	
	
	
	
}