package entidade;

import java.sql.Timestamp;

/**
 * Classe contendo metodos e atributos para a criacao e uso de arquivos
 * @author Andre
 */
public class Arquivo {
	
    private int idArquivo;
    private String extensao;
    private Timestamp dataEnvio;
    private int remetente;
    private String caminhoArquivo;

    /**
     * Construtor padrao
     */
    public Arquivo() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todas os atributos da classe 
     * @param idArquivo
     * @param extensao
     * @param dataEnvio
     * @param remetente
     * @param caminhoArquivo
     */
    public Arquivo(int idArquivo, String extensao, Timestamp dataEnvio, int remetente, String caminhoArquivo) {
		setIdArquivo(idArquivo);
		setExtensao(extensao);
		setDataEnvio(dataEnvio);
		setRemetente(remetente);
		setCaminhoArquivo(caminhoArquivo);
	}

	/** Metodo para retorno do ID do arquivo
     * @return int idArquivo
     */
    public int getIdArquivo() {
        return idArquivo;
    }

    /**
     * Metodo de insercao de ID do arquivo
     * @param int idArquivo
     */
    public void setIdArquivo(int idArquivo) {
		this.idArquivo = idArquivo;
	}

	/** Metodo para retorno da extensao.
     * @return String extensao
     */
    public String getExtensao() {
        return extensao;
    }

    /**
     * Metodo para insercao da extensao do arquivo 
     * @param String extensao
     */
    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }

    /** Metodo para retorno da data de envio
     * @return Timestamp dataEnvio 
     */
    public Timestamp getDataEnvio() {
        return dataEnvio;
    }

    /**
     * Metodo para insercao da data de envio do arquivo 
     * @param Timestamp dataEnvio
     */
    public void setDataEnvio(Timestamp dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    /** 
     * Metodo para retorno do remetente.
     * @return int remetente 
     */
    public int getRemetente() {
        return remetente;
    }

    /**
     * Metodo para insercao do remetente 
     * @param int remetente
     */
    public void setRemetente(int remetente) {
        this.remetente = remetente;
    }

    /**
     * Metodo para retorno do caminho onde está o arquivo 
     * @return String caminhoArquivo
     */
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	/**
	 * Metodo para insercao do caminho onde está o arquivo 
	 * @param String caminhoArquivo
	 */
	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
}