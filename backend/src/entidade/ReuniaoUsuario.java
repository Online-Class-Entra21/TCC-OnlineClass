package entidade;

import java.sql.Time;
import java.util.*;

/**
 * 
 */
public class ReuniaoUsuario {
    private int idReuniaoUsuario;
    private Time entradaReuniao;
    private double notaReuniao;
    private String comentarioReuniao;
    private Usuario usuario;
    private int codReuniao;
    public Usuario Participa;
    
    /**
     * Construtor usado ao instanciar a classe ReuniaoUsuario.
     * @param
     */
    public ReuniaoUsuario() {
    }


    /** M�todo para retorno do ID da ReuniaoUsuario.
     * @return Int - ID da ReuniaoUsuario
     */
    public int getIdReuniaoUsuario() {
        return idReuniaoUsuario;
    }

    /**
     * 
     */
    public void setReuniaoUsuario() {
        // TODO implement here
    }

    /** M�todo para retorno do hor�rio de entrada da reuni�o.
     * @return Time - Hor�rio de entrada na reuni�o
     */
    public Time getEntradaReuniao() {
        return entradaReuniao;
    }

    /**
     * 
     */
    public void setEntradaReuniao() {
        // TODO implement here
    }

    /** M�todo para retorno da nota da reuni�o.
     * @return Double - Nota da reuni�o
     */
    public double getNotaReuniao() {
        return notaReuniao;
    }

    /**
     * 
     */
    public void setNotaReuniao() {
        // TODO implement here
    }

    /** M�todo para retorno dos coment�rios da reuni�o.
     * @return String - Coment�rios da reuni�o
     */
    public String getComantarioReuniao() {
        return comentarioReuniao;
    }
    /**
     * 
     */
    public void setComentarioReuniao() {
        // TODO implement here
    }

    /** M�todo para retorno do usu�rio.
     * @return Usuario - Usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * 
     */
    public void setUsuario() {
        // TODO implement here
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
    public void setCodReuniao() {
        // TODO implement here
    }

}