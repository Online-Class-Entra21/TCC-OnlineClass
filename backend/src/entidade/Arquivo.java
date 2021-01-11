package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para a cria��o e uso de arquivos.
 * @author 
 */
public class Arquivo {
    private int idArquivo;
    private String extensao;
    private Date dataEnvio;
    private int remetente;
    private int tipoEnvio;
    private byte arquivo[];

    /**
     * Construtor usado ao instanciar a classe Arquivo.
     * @param
     */
    public Arquivo() {
    }
    
    /**
     * 
     */
    public Arquivo(int idArquivo, String extensao, Date dataEnvio, int remetente, int tipoEnvio) {
    	setIdArquivo(idArquivo);
    	setExtensao(extensao);
    	setDataEnvio(dataEnvio);
    	setRemetente(remetente);
    	setTipoEnvio(tipoEnvio);
    }

    
    /** M�todo para retorno do ID do arquivo.
     * @return Int - ID do arquivo
     */
    public int getIdArquivo() {
        return idArquivo;
    }

    /**
     * M�todo de inser��o de id do arquivo
     * @param idArquivo
     */
    public void setIdArquivo(int idArquivo) {
		this.idArquivo = idArquivo;
	}

	/** M�todo para retorno da extens�o.
     * @return String - Extens�o do arquivo
     */
    public String getExtensao() {
        return extensao;
    }

    /**
     * 
     */
    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    /** M�todo para retorno da data de envio.
     * @return Date - Data de envio
     */
    public Date getDataEnvio() {
        return dataEnvio;
    }

    /**
     * 
     */
    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    /** M�todo para retorno do remetente.
     * @return Int - ID do remetente
     */
    public int getRemetente() {
        return remetente;
    }

    /**
     * 
     */
    public void setRemetente(int remetente) {
        this.remetente = remetente;
    }

    /** M�todo para retorno do tipo de envio.
     * @return Int - Tipo de envio 
     */
    public int getTipoEnvio() {
    	return tipoEnvio;
    }

    /**
     * 
     */
    public void setTipoEnvio(int tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    /** M�todo para retorno do arquivo.
     * @return Byte - Array de arquivos
     */
    public byte[] getArquivo() {
        return arquivo;
    }

    /**
     * 
     */
    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

}