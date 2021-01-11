package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para a cria��o de convites de acesso �s reuni�es.
 * @author
 */
public class Convite {
    private int idConvite;
    private int destinatario;
    private int salaConvite;
    private boolean situacaoConvite;
    private int remetente;

    /**
     * Construtor usado ao instanciar a classe Convite.
     * @param
     */
    public Convite() {
    }
    
    /**
     * 
     */
    public Convite(int idConvite, int destinatario, int salaConvite, boolean situacaoConvite, int remetente) {
    	setIdConvite(idConvite);
    	setDestinatario(destinatario);
    	setSalaConvite(salaConvite);
    	setSituacaoConvite(situacaoConvite);
    	setRemetente(remetente);
    }


    /** M�todo para retorno do ID do destinat�rio.
     * @return Int - ID do destinat�rio
     */
    public int getDestinatario() {
        return destinatario;
    }

    /**
     * 
     */
    public void setDestinatario(int idDestinatario) {
        this.destinatario = idDestinatario;
    }

    /** M�todo para retorno do ID do convite da sala.
     * @return Int - ID do convite da sala
     */
    public int getSalaConvite() {
        return salaConvite;
    }

    /**
     * 
     */
    public void setSalaConvite(int idSalaConvite) {
        this.salaConvite = idSalaConvite;
    }

    /** M�todo para retorno da situa��o do convite.
     * @return Boolean - Usu�rio aceitou? True / False
     */
    public boolean getSituacaoConvite() {
        return situacaoConvite;
    }

    /**
     * 
     */
    public void setSituacaoConvite(boolean situacaoConvite) {
        this.situacaoConvite = situacaoConvite;
    }

    /** M�todo para retorno do ID do remetente.
     * @return Int - ID do remetente
     */
    public int getRemetente() {
        return remetente;
    }

    /**
     * 
     */
    public void setRemetente(int idRemetente) {
        this.remetente = idRemetente;
    }

    /** M�todo para retorno do ID do convite.
     * @return Int - ID do convite
     */
    public int getIdConvite() {
        return idConvite;
    }

    /**
     * 
     */
    public void setIdConvite(int idConvite) {
        this.idConvite = idConvite;
    }

}