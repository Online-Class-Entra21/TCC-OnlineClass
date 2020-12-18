package Sistema;

import java.util.*;

/**
 * Classe conténdo métodos e atributos para a ligação do Usuario ao Arquivo enviado ou recebido.
 * @see Usuario
 * @see Arquivo
 * @author
 */
public class UsuarioArquivo {
    private int idUsuarioArquivo;
    private int tipoEnvio;
    private Arquivo arquivo;
    private int destinatario;
    
    /**
     * Construtor usado ao instanciar a classe UsuarioArquivo.
     * @param
     */
    public UsuarioArquivo() {
    }


    /** Método para retorno do ID do UsuarioArquivo.
     * @return Int - ID UsuarioArquivo
     */
    public int getIdUsuarioArquivo() {
        return idUsuarioArquivo;
    }

    /**
     * 
     */
    public void setIdUsuarioArquivo() {
        // TODO implement here
    }

    /** Método para retorno do tipo de envio.
     * @return Int - Tipo de envio
     */
    public int getTipoEnvio() {
        return tipoEnvio;
    }

    /**
     * 
     */
    public void setTipoEnvio() {
        // TODO implement here
    }

    /** Método para retorno do arquivo.
     * @return Arquivo - Arquivo
     */
    public Arquivo getArquivo() {
        return arquivo;
    }

    /**
     * 
     */
    public void setArquivo() {
        // TODO implement here
    }

    /** Método para retorno do ID do destinatário.
     * @return Int - ID destinatário
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

}