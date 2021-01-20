package entidade;

/**
 * Herda metodos e atributos da classe Sala.
 * Salas personalizadas podem ser criadas pelo Usuario
 * @see Sala
 * @see Usuario
 * @author Breno 
 */
public class SalaPersonalizada extends Sala {
	
	private int idSalaPersonalizada;
	private int dono;
	private int fk_sala;

	/**
	 * Construtor padrao
	 * @param
	 */
	public SalaPersonalizada() {
		//Nenhum atributo inicializado 
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos da classe 
	 * @param idSalaPersonalizada
	 * @param dono
	 * @param fk_sala
	 */
	public SalaPersonalizada(int idSalaPersonalizada, int dono, int fk_sala) {
		
		setIdSalaPersonalizada(idSalaPersonalizada);
		setDono(dono);
		setFk_sala(fk_sala);
	}

	/** Metodo para retorno do ID da sala personalizada
	 * @return idSalaPersonalizada 
	 */
	public int getIdSalaPersonalizada() {
	    return idSalaPersonalizada;
	}
	
	/**
	 * Metodo que adiciona o id na sala personalizada 
	 * @param idSalaPersonalizada
	 */
	public void setIdSalaPersonalizada(int idSalaPersonalizada) {
		this.idSalaPersonalizada = idSalaPersonalizada;
	}
	
	/** 
	 * Metodo para retorno do ID do dono da sala
	 * @return dono
	 */
	public int getDono() {
	    return dono;
	}
	
	/**
	 * Metodo que adiciona o criador da sala 
	 * @param dono
	 */
	public void setDono(int dono) {
		this.dono = dono;
	}

	/**
	 * Metodo para retorno do FK sala 
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
	
	
	//---------------
	
	
//	/** M�todo para pesquisar um usu�rio da sala personalizada
//	 * @param -
//	 * @return UsuarioSalaPersonalizada
//	 */
//	public UsuarioSalaPersonalizada pesquisarUsuarioSalaPersonalizada() {
//		return null;
//	}
}