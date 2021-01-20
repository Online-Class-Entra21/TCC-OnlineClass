package entidade;

import java.util.*;

/**
 * Classe contendo metodos e atributos para a criacao de reunioes pelo Usuario
 * @see Usuario
 * @see TurmaProfessor
 * @author Andrey 
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
     * Metodo construtor que preenche todos os atributos da classe 
     * @param idReuniao
     * @param descricao
     * @param dataInicio
     * @param dono
     * @param notaMediaAula
     * @param fk_sala
     * @param fk_usuario_disciplina
     */
    public Reuniao(int idReuniao, String descricao, Date dataInicio, int dono, double notaMediaAula, int fk_sala,
			int fk_usuario_disciplina) {

		setIdReuniao(idReuniao);
		setDescricao(descricao);
		setDataInicio(dataInicio);
		setDono(dono);
		setNotaMediaAula(notaMediaAula);
		setFk_sala(fk_sala);
		setFk_usuario_disciplina(fk_usuario_disciplina);
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
     * Metodo para insercao da descricao da reuniao 
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao; 
    }
    
    /** 
     * Metodo para retorno da data de inicio da reuniao.
     * @return dataInicio 
     */
    public Date getDataInicio() {
		return dataInicio;
	}

    /**
     * Metodo para insercao do inicio da reuniao 
     * @param dataInicio
     */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

    /** 
     * Metodo para retorno do dono da reuniao
     * @return dono
     */
    public int getDono() {
        return dono;
    }

    /**
     * Metodo para insercao do dono da reuniao 
     * @param dono
     */
    public void setDono(int dono) {
        this.dono = dono;
    }

    /** Metodo para retorno da nota media da aula
     * @return nataMediaAula 
     */
    public double getNotaMediaAula() {
        return notaMediaAula;
    }
    
    /**
     * Metodo para insercao da nota media da aula  
     * @param notaMediaAula
     */
    public void setNotaMediaAula(double notaMediaAula) {
		this.notaMediaAula = notaMediaAula;
	}

    /**
     * Metodo para retorno do FK da sala 
     * @return
     */
	public int getFk_sala() {
		return fk_sala;
	}

	/**
	 * Metodo para insercao do FK da sala 
	 * @param fk_sala
	 */
	public void setFk_sala(int fk_sala) {
		this.fk_sala = fk_sala;
	}

	/**
	 * Metodo para retorno do FK do usuario disciplina 
	 * @return
	 */
	public int getFk_usuario_disciplina() {
		return fk_usuario_disciplina;
	}

	/**
	 * Metodo para insercao do FK do usuario disciplina 
	 * @param fk_usuario_disciplina
	 */
	public void setFk_usuario_disciplina(int fk_usuario_disciplina) {
		this.fk_usuario_disciplina = fk_usuario_disciplina;
	}
    
    
    //--------------

    
//    /** 
//     * Metodo para buscar um usuario da reuniao
//     * @param - 
//     * @return ReuniaoUsuario.
//     */
//    public ReuniaoUsuario buscarReuniaoUsuario() {
//        return null;
//    }
//
//    /**
//     * 
//     */
//    public void setReuniaoUsuario() {
//        // TODO implement here
//    }
//
//    /** M�todo para retorno da TurmaProfessorDisciplina.
//     * @return TurmaProfessorDisciplina - TurmaProfessorDisciplina
//     */
//    public TurmaProfessorDisciplina getTurmaProfessorDisciplina() {
//        return turmaProfessorDisciplina;
//    }
//
//    /**
//     * 
//     */
//    public void setTurmaProfessorDisciplina(TurmaProfessorDisciplina turmaProfessorDisciplina) {
//        this.turmaProfessorDisciplina = turmaProfessorDisciplina;
//    }

}