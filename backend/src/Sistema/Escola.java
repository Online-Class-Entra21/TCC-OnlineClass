package Sistema;

import java.util.*;

/**
 * Classe contendo métodos e atributos para as devidas funções da escola.
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
     * Construtor usado ao instanciar a classe Escola.
     * @param
     */
    public Escola() {
    }

    
    /** Método para retorno do ID da escola.
     * @return Int - ID da escola
     */
    public int getIdEscola() {
        return idEscola;
    }

    /**
     * 
     */
    public void setIdEscola() {
        // TODO implement here
    }

    /** Método para retorno do nome da escola.
     * @return String - Nome da escola
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     */
    public void setNome() {
        // TODO implement here
    }

    /** Método para retorno da data de início do ano letivo.
     * @return Date - Data de início do ano letivo
     */
    public Date getDataInicioLetivo() {
        return dataInicioLetivo;
    }

    /**
     * 
     */
    public void setDataInicioLeitvo() {
        // TODO implement here
    }

    /** Método para retorno da data final do ano letivo.
     * @return Date - Data final do ano letivo
     */
    public Date getDataFinalLetivo() {
        return dataFinalLetivo;
    }

    /**
     * 
     */
    public void setDataFinalLetivo() {
        // TODO implement here
    }

    /** Método para retorno dos usuários.
     * @return Usuario - Array de usuários
     */
    public Usuario[] getUsuarios() {
        return usuarios;
    }

    /** Método para buscar um usuário específico.
     * @param -
     * @return Usuario - Usuario a ser buscado.
     */
    public Usuario buscarUsuario() {
        return null;
    }

    /** Método para adicionar um usuário ao sistema.
     * @param -
     */
    public void adicionarUsuario() {
        // TODO implement here
    }

    /** Método para buscar um periodo de avaliação específico.
     * @return PeriodoAvaliacao
     */
    public PeriodoAvaliacao buscarPeriodo() {
        return null;
    }

    /** Método para adicionar um período de avaliação.
     * @param -
     */
    public void adicionarPeriodo() {
        // TODO implement here
    }

}