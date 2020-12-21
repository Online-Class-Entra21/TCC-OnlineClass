package entidade;

import java.util.*;

/**
 * Classe contendo métodos e atributos para a criação e uso de arquivos.
 * @author 
 */
public class Arquivo {
    private int idArquivo;
    private String extensao;
    private Date dataEnvio;
    private int remetente;
    private byte arquivo[];

    /**
     * Construtor usado ao instanciar a classe Arquivo.
     * @param
     */
    public Arquivo() {
    }

    
    /** Método para retorno do ID do arquivo.
     * @return Int - ID do arquivo
     */
    public int getIdArquivo() {
        return idArquivo;
    }

    /**
     * 
     */
    public void setIdArquivo() {
        // TODO implement here
    }

    /** Método para retorno da extensão.
     * @return String - Extensão do arquivo
     */
    public String getExtensao() {
        return extensao;
    }

    /**
     * 
     */
    public void setExtensao() {
        // TODO implement here
    }

    /** Método para retorno da data de envio.
     * @return Date - Data de envio
     */
    public Date getDataEnvio() {
        return dataEnvio;
    }

    /**
     * 
     */
    public void setDataEnvio() {
        // TODO implement here
    }

    /** Método para retorno do remetente.
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

    /** Método para retorno do tipo de envio.
     * @return Int - Tipo de envio 
     */
    public int getTipoEnvio() {
    	UsuarioArquivo usuarioArquivo = new UsuarioArquivo();
        return usuarioArquivo.getTipoEnvio();
    }

    /**
     * 
     */
    public void setTipoEnvio() {
        // TODO implement here
    }

    /** Método para retorno do arquivo.
     * @return Byte - Array de arquivos
     */
    public byte[] getArquivo() {
        return arquivo;
    }

    /**
     * 
     */
    public void setArquivo() {
        // TODO implement here
    }

}