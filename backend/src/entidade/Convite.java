package entidade;

import java.util.*;

/**
 * Classe contendo métodos e atributos para a criação de convites de acesso às reuniões.
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


    /** Método para retorno do ID do destinatário.
     * @return Int - ID do destinatário
     */
    public int getDestinatario() {
        return destinatario;
    }

    /**
     * 
     */
    public void setDestinatario() {
        // TODO implement here
    }

    /** Método para retorno do ID do convite da sala.
     * @return Int - ID do convite da sala
     */
    public int getSalaConvite() {
        return salaConvite;
    }

    /**
     * 
     */
    public void setSalaConvite() {
        // TODO implement here
    }

    /** Método para retorno da situação do convite.
     * @return Boolean - Usuário aceitou? True / False
     */
    public boolean getSituacaoConvite() {
        return situacaoConvite;
    }

    /**
     * 
     */
    public void setSituacaoConvite() {
        // TODO implement here
    }

    /** Método para retorno do ID do remetente.
     * @return Int - ID do remetente
     */
    public int getRemetente() {
        return remetente;
    }

    /**
     * 
     */
    public void setRemetente() {
        // TODO implement here
    }

    /** Método para retorno do ID do convite.
     * @return Int - ID do convite
     */
    public int getIdConvite() {
        return idConvite;
    }

    /**
     * 
     */
    public void setIdConvite() {
        // TODO implement here
    }

}