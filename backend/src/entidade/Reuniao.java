package entidade;

import java.util.*;

/**
 * Classe contendo métodos e atributos para a criação de reuniões pelo Usuario.
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


    /** Método para retorno do ID da reunião.
     * @return Int - ID da reunião
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

    /** Método para retorno da descrição da reunião.
     * @return String - Descrição da reunião
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

    /** Método para retorno da data de início da reunião.
     * @return Date - Data de início da reunião 
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

    /** Método para retorno do ID do dono da reunião.
     * @return Int - ID do dono da reunião
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

    /** Método para retorno da nota média da aula.
     * @return Double - Nota média da aula
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

    /** Método para retorno da sala.
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

    /** Método para retorno dos usuários conectados à reunião.
     * @return ReuniaoUsuario - Array de usuários conectados
     */
    public ReuniaoUsuario[] getReuniaoUsuarios() {
        return reuniaoUsuarios;
    }

    /** Método para buscar um usuário da reunião.
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

    /** Método para retorno da TurmaProfessorDisciplina.
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