package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para realizar a chamada dos alunos na reuni�o.
 * @author
 */
public class Chamada {
    private int idChamada;
    private boolean situacao;
    private int codAluno;
    private int codReuniao;

    /**
     * Construtor usado ao instanciar a classe Chamada.
     * @param
     */
    public Chamada() {
    }
    /**
     * 
     */
    public Chamada(int idChamada, boolean situacao, int codAluno, int codReuniao) {
    	setIdChamada(idChamada);
    	setSituacao(situacao);
    	setCodAluno(codAluno);
    	setCodReuniao(codReuniao);
    }


    /** M�todo para retorno do ID da chamada.
     * @return Int - ID da chamada
     */
    public int getIdChamada() {
        return idChamada;
    }

    /**
     * 
     */
    public void setIdChamada(int idChamada) {
        this.idChamada = idChamada;
    }

    /** M�todo para retorno da situa��o da chamada.
     * @return Boolean - Aluno faltante? True / False
     */
    public boolean getSituacao() {
        return situacao;
    }

    /**
     * 
     */
    public void setSituacao(boolean situacao) {
    	this.situacao = situacao;
    }

    /** M�todo para retorno do c�digo do aluno.
     * @return Int - C�digo do aluno
     */
    public int getCodAluno() {
        return codAluno;
    }

    /**
     * 
     */
    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    /** M�todo para retorno do c�digo da reuni�o.
     * @return Int - C�digo da reuni�o
     */
    public int getCodReuniao() {
    	return codReuniao;
    }

    /**
     * 
     */
    public void setCodReuniao(int codReuniao) {
        this.codReuniao = codReuniao;
    }

}