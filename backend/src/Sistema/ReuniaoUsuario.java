package Sistema;

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


    /** Método para retorno do ID da ReuniaoUsuario.
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

    /** Método para retorno do horário de entrada da reunião.
     * @return Time - Horário de entrada na reunião
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

    /** Método para retorno da nota da reunião.
     * @return Double - Nota da reunião
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

    /** Método para retorno dos comentários da reunião.
     * @return String - Comentários da reunião
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

    /** Método para retorno do usuário.
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

    /** Método para retorno do código da reunião.
     * @return Int - Código da reunião
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