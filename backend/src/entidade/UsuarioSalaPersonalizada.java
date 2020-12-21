package entidade;

import java.util.*;

/**
 * Classe contendo métodos e atributos para a ligação do Usuario à Sala Personalizada.
 * @see Usuario
 * @see SalaPersonalizada
 * @author
 */
public class UsuarioSalaPersonalizada {
    private int idUsuarioSalaPersonalizada;
    private int codSalaPersonalizada;
    private Usuario usuario;
    
    /**
     * Construtor usado ao instanciar a classe UsuarioSalaPersonalizada.
     * @param
     */
    public UsuarioSalaPersonalizada() {
    }


    /** Método para retorno do ID do UsuarioSalaPersonalizada.
     * @return Int - ID UsuarioSalaPersonalizada
     */
    public int getIdUsuarioSalaPersonalizada() {
        return idUsuarioSalaPersonalizada;
    }

    /**
     * 
     */
    public void setIdUsuarioSalaPersonalizada() {
        // TODO implement here
    }

    /** Método para retorno do código da sala personalizada.
     * @return Int - Código da sala personalizada
     */
    public int getCodSalaPersonalizada() {
        return codSalaPersonalizada;
    }

    /**
     * 
     */
    public void setCodSalaPersonalizada() {
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

}