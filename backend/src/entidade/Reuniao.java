package entidade;

import java.util.*;

/**
 * Classe contendo m�todos e atributos para a cria��o de reuni�es pelo Usuario.
 * @see Usuario
 * @see TurmaProfessor
 * @author 
 */
public class Reuniao {
    private int idReuniao;
    private String descricao;
    private Date dataInicio;
    private int dono;
    private double notaMediaAula;
    private Sala sala;
    private ReuniaoUsuario reuniaoUsuarios[];
    private TurmaProfessorDisciplina turmaProfessorDisciplina;
    
    /**
     * Construtor usado ao instanciar a classe Reuniao.
     * @param
     */
    public Reuniao() {
    }


    /** M�todo para retorno do ID da reuni�o.
     * @return Int - ID da reuni�o
     */
    public int getIdReuniao() {
        return idReuniao;
    }

    /**
     * 
     */
    public void setIdReuniao() {
        // TODO implement here
    }

    /** M�todo para retorno da descri��o da reuni�o.
     * @return String - Descri��o da reuni�o
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

    /** M�todo para retorno da data de in�cio da reuni�o.
     * @return Date - Data de in�cio da reuni�o 
     */
    public Date getDataInicioReuniao() {
        return dataInicio;
    }

    /**
     * 
     */
    public void setDataInicioReuniao() {
        // TODO implement here
    }

    /** M�todo para retorno do ID do dono da reuni�o.
     * @return Int - ID do dono da reuni�o
     */
    public int getDono() {
        return dono;
    }

    /**
     * 
     */
    public void setDono() {
        // TODO implement here
    }

    /** M�todo para retorno da nota m�dia da aula.
     * @return Double - Nota m�dia da aula
     */
    public double getNotaMediaAula() {
        return notaMediaAula;
    }

    /**
     * 
     */
    public void setNotaMediaAula() {
        // TODO implement here
    }

    /** M�todo para retorno da sala.
     * @return Sala - Sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * 
     */
    public void setSala() {
        // TODO implement here
    }

    /** M�todo para retorno dos usu�rios conectados � reuni�o.
     * @return ReuniaoUsuario - Array de usu�rios conectados
     */
    public ReuniaoUsuario[] getReuniaoUsuarios() {
        return reuniaoUsuarios;
    }

    /** M�todo para buscar um usu�rio da reuni�o.
     * @param - 
     * @return ReuniaoUsuario.
     */
    public ReuniaoUsuario buscarReuniaoUsuario() {
        return null;
    }

    /**
     * 
     */
    public void setReuniaoUsuario() {
        // TODO implement here
    }

    /** M�todo para retorno da TurmaProfessorDisciplina.
     * @return TurmaProfessorDisciplina - TurmaProfessorDisciplina
     */
    public TurmaProfessorDisciplina getTurmaProfessorDisciplina() {
        return turmaProfessorDisciplina;
    }

    /**
     * 
     */
    public void setTurmaProfessorDisciplina() {
        // TODO implement here
    }

}