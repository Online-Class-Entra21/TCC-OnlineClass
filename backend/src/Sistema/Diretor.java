package Sistema;

import java.util.*;

/**
 * Classe contendo métodos e atributos para o diretor.
 * Herda métodos e atributos da classe Usuario.
 * @see Usuario
 * @author 
 */
public class Diretor extends Usuario {

	/**
     * Construtor usado ao instanciar a classe Diretor.
     * @param
     */
    public Diretor() {
    }


    /** Método para retorno do ID da escola.
     * @return Int - ID da escola
     */
    public int getEscola() {
        Escola escola = new Escola();
        return escola.getIdEscola();
    }

    /**
     * 
     */
    public void atualizarEscola() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verificaDisponibilidade() {
        // TODO implement here
    }

    /** Método para retorno do ID do PeriodoAvaliacao.
     * @return Int - ID PeriodoAvaliacao
     */
    public int getPeriodoAvaliacao() {
        PeriodoAvaliacao periodoAvaliacao =  new PeriodoAvaliacao();
        return periodoAvaliacao.getIdPeriodoAvaliacao();		
    }

    /**
     * 
     */
    public void adicionarPeriodoAvaliacao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void atualizarPeriodoAvaliacao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerPeriodoAvaliacao() {
        // TODO implement here
    }

    /** Método para retorno do ID do usuário.
     * @return Int - ID do usuário
     */
    public int getUsuario() {
        return getIdUsuario();
    }

    /**
     * 
     */
    public void adicionarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void atualizarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerUsuario() {
        // TODO implement here
    }

}