package entidade;

import java.util.*;

/**
 * Classe contendo metodos e atributos para a criacao de reunioes pelo Usuario
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
    private int fk_sala;
    private int fk_usuario_disciplina;
    
    /**
     * Construtor padrao
     * @param
     */
    public Reuniao() {
    	//Nenhum atributo inicializado
    }

    /** 
     * Metodo para retorno do ID da reuniao
     * @return idReuniao
     */
    public int getIdReuniao() {
        return idReuniao;
    }

    /**
     * Metodo de insercao do ID da reuniao
     * @param idReuniao
     */
    public void setIdReuniao(int idReuniao) {
        this.idReuniao = idReuniao;
    }

    /** 
     * Metodo para retorno da descricao da reuniao
     * @return descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Metodo para insercao 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao; 
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
    public void setDataInicioReuniao(Date dataInicio) {
        this.dataInicio = dataInicio;
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
    public void setDono(int dono) {
        this.dono = dono;
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
    public void setNotaMediaAula(Double notaMediaAula) {
    	this.notaMediaAula = notaMediaAula;
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
    public void setSala(Sala sala) {
        this.sala = sala;
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
    public void setTurmaProfessorDisciplina(TurmaProfessorDisciplina turmaProfessorDisciplina) {
        this.turmaProfessorDisciplina = turmaProfessorDisciplina;
    }

}