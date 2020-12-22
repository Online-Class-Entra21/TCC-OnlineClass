package entidade;

/**
 * Herda métodos e atributos da classe Sala.
 * Salas personalizadas podem ser criadas pelo Usuario.
 * @see Sala
 * @see Usuario
 * @author
 */
public class SalaPersonalizada extends Sala {
	
	private int idSalaPersonalizada;
	private int dono;
	private int fk_sala;
	private UsuarioSalaPersonalizada usuariosSalaPersonalizada[];

	/**
	 * Construtor usado ao instanciar a classe sala personalizada
	 * @param
	 */
	public SalaPersonalizada() {
		// TODO Auto-generated
	}
	
	/**
	 * Construtor que preenche o dono da sala personalizada
	 * @param dono
	 */
	public SalaPersonalizada(int dono, int fk_sala) {
		setDono(dono);
		setFk_sala(fk_sala);
	}
	
	
	/** Método para retorno do ID da sala personalizada
	 * @return Int - ID da sala personalizada
	 */
	public int getIdSalaPersonalizada() {
	    return idSalaPersonalizada;
	}
	
	public void setUsuariosSalaPersonalizada(UsuarioSalaPersonalizada[] usuariosSalaPersonalizada) {
		this.usuariosSalaPersonalizada = usuariosSalaPersonalizada;
	}
	
	/**
	 * Método que adiciona o id na sala personalizada 
	 * @param idSalaPersonalizada
	 */
	public void setIdSalaPersonalizada(int idSalaPersonalizada) {
		this.idSalaPersonalizada = idSalaPersonalizada;
	}
	
	/** Método para retorno do ID do dono da sala
	 * @return Int - ID do dono da sala
	 */
	public int getDono() {
	    return dono;
	}
	
	/**
	 * Método que adiciona o criador da sala 
	 * @param dono
	 */
	public void setDono(int dono) {
		this.dono = dono;
	}
	
	/**
	 * Método para retorno do numero da sala
	 * @return
	 */
	public int getFk_sala() {
		return fk_sala;
	}
	
	/**
	 * Método de inserção no numero da sala que faz referência na sala personalizada 
	 * @param fk_sala
	 */
	public void setFk_sala(int fk_sala) {
		this.fk_sala = fk_sala;
	}
	
	/** Método para retorno do UsuarioSalaPersonalizada
	 * @return UsuarioSalaPersonalizada - UsuarioSalaPersonalizada
	 */
	public UsuarioSalaPersonalizada[] getUsuariosSalaPersonalizada() {
	    return usuariosSalaPersonalizada;
	}
	
	/** Método para pesquisar o usuário da sala personalizada
	 * @param -
	 * @return UsuarioSalaPersonalizada
	 */
	public UsuarioSalaPersonalizada pesquisarUsuarioSalaPersonalizada() {
		return null;
	}
}