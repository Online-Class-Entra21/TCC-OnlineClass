package Sistema;

import java.util.*;

/**
 * Classe contendo métodos e atributos para a sala de aula.
 * Local onde ocorre as reuniões
 * @see Reuniao
 * @author 
 */
public class Sala {
    private int idSala;
    private String nome;
    private String descricao;
    private boolean situacaoAcesso;
    private boolean tipoSala;
    private String link;

    /**
     * Construtor usado ao instanciar a classe Sala.
     * @param
     */
    public Sala() {
    }


    /** Método para retorno do ID da sala.
     * @return Int - ID da sala
     */
    public int getIdSala() {
        return idSala;
    }

    /**
     * 
     */
    public void setIdSala() {
        // TODO implement here
    }

    /** Método para retorno do nome da sala.
     * @return String - Nome da sala
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

    /** Método para retorno da descrição da sala.
     * @return String - Descrição da sala
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * 
     */
    public void setDescricao() {
        // TODO implement here
    }

    /** Método para retorno da situação de acesso.
     * @return Boolean - Permitida a entrada? True / False
     */
    public boolean getSituacaoAcesso() {
        return situacaoAcesso;
    }

    /**
     * 
     */
    public void setSituacaoAcesso() {
        // TODO implement here
    }

    /** Método para retorno do tipo da sala.
     * @return Boolean - True para sala padrão / False para sala personalizada
     */
    public boolean getTipoSala() {
        return tipoSala;
    }

    /**
     * 
     */
    public void setTipoSala() {
        // TODO implement here
    }

    /** Método para retorno do link da reunião.
     * @return String - Link da reunião
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     */
    public void setLink() {
        // TODO implement here
    }

}