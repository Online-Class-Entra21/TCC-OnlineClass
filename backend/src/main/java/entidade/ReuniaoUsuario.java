package entidade;

import java.sql.Time;

/**
 * Classe contendo metodos e atributos sobre o usuario que participa de uma reuniao em especifico.
 * Respostas sao enviadas pelo Aluno
 * @author Andrey 
 *
 */
public class ReuniaoUsuario {
	
    private int idReuniaoUsuario;
    private int fk_reuniao;
    private int fk_usuario;
    private Time entradaReuniao;
    private double notaReuniao;
    private String comentarioReuniao;
    
    /**
     * Construtor padrao
     * @param
     */
    public ReuniaoUsuario() {
    	//Nenhum atributo inicializado
    }
    
    /**
     * Metodo construtor que preenche todas os atributos da classe 
     * @param idReuniaoUsuario
     * @param fk_reuniao
     * @param fk_usuario
     * @param entradaReuniao
     * @param notaReuniao
     * @param comentarioReuniao
     */
    public ReuniaoUsuario(int idReuniaoUsuario, int fk_reuniao, int fk_usuario, Time entradaReuniao, double notaReuniao,
			String comentarioReuniao) {

		setIdReuniaoUsuario(idReuniaoUsuario);
		setFk_reuniao(fk_reuniao);
		setFk_usuario(fk_usuario);
		setEntradaReuniao(entradaReuniao);
		setNotaReuniao(notaReuniao);
		setComentarioReuniao(comentarioReuniao);
	}

	/** 
     * Metodo para retorno do ID da ReuniaoUsuario
     * @return int idReuniaoUsuario 
     */
    public int getIdReuniaoUsuario() {
        return idReuniaoUsuario;
    }

    /**
     * Metodo para insercao do ID da reuniaoUsuario
     * @param int idReuniaoUsuario
     */
    public void setIdReuniaoUsuario(int idReuniaoUsuario) {
		this.idReuniaoUsuario = idReuniaoUsuario;
	}

    /**
     * Metodo para retorno do FK da reuniao 
     * @return int fk_reuniao
     */
	public int getFk_reuniao() {
		return fk_reuniao;
	}

	/**
	 * Metodo para insercao do FK da reuniao 
	 * @param int fk_reuniao
	 */
	public void setFk_reuniao(int fk_reuniao) {
		this.fk_reuniao = fk_reuniao;
	}

	/**
	 * Metodo para retorno do FK do usuario 
	 * @return int fk_usuario 
	 */
	public int getFk_usuario() {
		return fk_usuario;
	}

	/**
	 * Metodo para insercao do FK do usuario 
	 * @param int fk_usuario
	 */
	public void setFk_usuario(int fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	/**
	 * Metodo para retorno da hora de entrada da reuniao 
	 * @return Time entradaReuniao 
	 */
	public Time getEntradaReuniao() {
		return entradaReuniao;
	}

	/**
	 * Metodo para insercao da hora de entrada da reuniao 
	 * @param Time entradaReuniao
	 */
	public void setEntradaReuniao(Time entradaReuniao) {
		this.entradaReuniao = entradaReuniao;
	}

	/**
	 * Metodo para retorno da nota da reuniao 
	 * @return double notaReuniao
	 */
	public double getNotaReuniao() {
		return notaReuniao;
	}

	/**
	 * Metodo para insercao da nota da reuniao 
	 * @param double notaReuniao
	 */
	public void setNotaReuniao(double notaReuniao) {
		this.notaReuniao = notaReuniao;
	}

	/**
	 * Metodo para retorno do comentario 
	 * @return String comentarioReuniao
	 */
	public String getComentarioReuniao() {
		return comentarioReuniao;
	}

	/**
	 * Metodo para insercao do comentario 
	 * @param String comentarioReuniao
	 */
	public void setComentarioReuniao(String comentarioReuniao) {
		this.comentarioReuniao = comentarioReuniao;
	}
}