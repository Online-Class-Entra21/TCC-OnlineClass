package entidade;

import java.util.*;

/**
 * Classe contendo metodos e atributos para o envio de uma resposta a uma atividade especifica
 * Respostas sao enviadas pelo Aluno
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
    private int fk_Atividade;

    /**
     * Construtor padrao
     */
    public Resposta() {
    	//Nenhum atributo inicializado
    }
   
	/** 
	 * Metodo para retorno do ID da resposta
     * @return idResposta
     */
    public int getIdResposta() {
        return idResposta;
    }

    /**
     * Metodo para insercao do ID da resposta 
     * @param idResposta
     */
    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }
    
    /** 
     * Metodo para retorno da nota
     * @return nota
     */
    public double getNota() {
        return nota;
    }
    
    /**
     * Metodo para insercao da nota 
     * @param nota
     */
    public void setNota(double nota) {
		this.nota = nota;
	}

    /** 
     * Metodo para retorno de um comentario na atividade
     * @return comantarioAtividade
     */
    public String getComentarioAtividade() {
        return comentarioAtividade;
    }
    
    /**
     * Metodo para insercao de um comentario na atividade 
     * @param comentarioAtividade
     */
    public void setComentarioAtividade(String comentarioAtividade) {
		this.comentarioAtividade = comentarioAtividade;
	}

	/** 
     * Metodo para retorno se a atividade foi corrigida 
     * @return correcaoAtividade 
     */
    public boolean getCorrecaoAtividade() {
        return correcaoAtividade;
    }
    
    /**
     * Metodo para insercao da situacao da atividade corrigida 
     * @param correcaoAtividade
     */
	public void setCorrecaoAtividade(boolean correcaoAtividade) {
		this.correcaoAtividade = correcaoAtividade;
	}

    /** 
     * Metodo para retorno da data de entrega
     * @return dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * Metodo para insercao da data de entrega 
     * @param dataEntrega
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    /**
     * Metodo para retorno do FK do aluno 
     * @return
     */
	public int getFk_aluno() {
		return fk_aluno;
	}

	/**
	 * Metodo para insercao do FK do aluno 
	 * @param fk_aluno
	 */
	public void setFk_aluno(int fk_aluno) {
		this.fk_aluno = fk_aluno;
	}

	/**
	 * Metodo para retorno do FK da atividade 
	 * @return
	 */
	public int getFk_Atividade() {
		return fk_Atividade;
	}

	/**
	 * Metodo para insercao do FK da atividade 
	 * @param fk_Atividade
	 */
	public void setFk_Atividade(int fk_Atividade) {
		this.fk_Atividade = fk_Atividade;
	}
}