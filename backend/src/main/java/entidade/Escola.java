package entidade;


import java.sql.Date;
import java.util.Arrays;

/**
 * Classe contendo m�todos e atributos para as devidas fun��es da escola.
 * @author 
 */
public class Escola {
    private int idEscola;
    private String nome;
    private Date dataInicioLetivo;
    private Date dataFinalLetivo;
    private Usuario usuarios[];
    private PeriodoAvaliacao periodos[];

    /**
     * Construtor usado para criar uma instancia com os dados do Banco de Dados
     * @param idEscola
     * @param nome
     * @param dataInicioLetivo
     * @param dataFinalLetivo
     */
    public Escola(int idEscola, String nome, Date dataInicioLetivo, Date dataFinalLetivo) {
		setIdEscola(idEscola);
		setNome(nome);
		setDataInicioLeitvo(dataInicioLetivo);
		setDataFinalLetivo(dataFinalLetivo);
	}

	/**
     * Construtor usado ao instanciar a classe Escola.
     * @param
     */
    public Escola() {
    }

    
    /** M�todo para retorno do ID da escola.
     * @return Int - ID da escola
     */
    public int getIdEscola() {
        return idEscola;
    }

    /**
     * 
     */
    public void setIdEscola(int idEscola) {
        this.idEscola = idEscola;
    }

    /** M�todo para retorno do nome da escola.
     * @return String - Nome da escola
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome 
     * 
     */
    public void setNome(String nome) {
    	this.nome = nome;
    }

    /** M�todo para retorno da data de in�cio do ano letivo.
     * @return Date - Data de in�cio do ano letivo
     */
    public Date getDataInicioLetivo() {
        return dataInicioLetivo;

    }

    /**
     * @param dataInicioLetivo2 
     * 
     */
    public void setDataInicioLeitvo(Date dataInicioLetivo) {
    	this.dataInicioLetivo = dataInicioLetivo;
    }

    /** M�todo para retorno da data final do ano letivo.
     * @return Date - Data final do ano letivo
     */
    public Date getDataFinalLetivo() {
        return dataFinalLetivo;
    }

    /**
     * @param dataFinalLetivo2 
     * 
     */
    public void setDataFinalLetivo(Date dataFinalLetivo) {
        this.dataFinalLetivo = dataFinalLetivo;
    }

    /** M�todo para retorno dos usu�rios.
     * @return Usuario - Array de usu�rios
     */
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    /** M�todo para buscar um usu�rio espec�fico.
     * @param -
     * @return Usuario - Usuario a ser buscado.
     */
    public Usuario buscarUsuario() {
        return null;
    }

    /** M�todo para adicionar um usu�rio ao sistema.
     * @param -
     */
    public void adicionarUsuario() {
        // TODO implement here
    }

    /** M�todo para buscar um periodo de avalia��o espec�fico.
     * @return PeriodoAvaliacao
     */
    public PeriodoAvaliacao buscarPeriodo() {
        return null;
    }

    /** M�todo para adicionar um per�odo de avalia��o.
     * @param -
     */
    public void adicionarPeriodo() {
        // TODO implement here
    }
}