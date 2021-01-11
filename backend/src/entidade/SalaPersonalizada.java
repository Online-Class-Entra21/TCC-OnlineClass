package entidade;

import java.util.Arrays;

/**
 * Herda m�todos e atributos da classe Sala.
 * Salas personalizadas podem ser criadas pelo Usuario.
 * @see Sala
 * @see Usuario
 * @author
 */
public class SalaPersonalizada extends Sala {
	
	private int idSalaPersonalizada;
	private int dono;
	private Sala sala;
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
	public SalaPersonalizada(int dono, Sala sala) {
		setDono(dono);
		setSala(sala);
	}
	
	/**
	 * M�todo de exibi��o das infora��es
	 */
	@Override
	public String toString() {
		return "SalaPersonalizada [idSalaPersonalizada=" + idSalaPersonalizada + ", dono=" + dono + ", fk_sala="
				+ sala + ", usuariosSalaPersonalizada=" + Arrays.toString(usuariosSalaPersonalizada) + "]";
	}

	/** M�todo para retorno do ID da sala personalizada
	 * @return Int - ID da sala personalizada
	 */
	public int getIdSalaPersonalizada() {
	    return idSalaPersonalizada;
	}
	
	/**
	 * M�todo que adiciona o id na sala personalizada 
	 * @param idSalaPersonalizada
	 */
	public void setIdSalaPersonalizada(int idSalaPersonalizada) {
		this.idSalaPersonalizada = idSalaPersonalizada;
	}
	
	/** M�todo para retorno do ID do dono da sala
	 * @return Int - ID do dono da sala
	 */
	public int getDono() {
	    return dono;
	}
	
	/**
	 * M�todo que adiciona o criador da sala 
	 * @param dono
	 */
	public void setDono(int dono) {
		this.dono = dono;
	}
	
	/**
	 * M�todo para retorno do numero da sala
	 * @return
	 */
	public Sala getSala() {
		return sala;
	}
	
	/**
	 * M�todo de inser��o no numero da sala que faz refer�ncia na sala personalizada 
	 * @param fk_sala
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	/** M�todo para retorno do UsuarioSalaPersonalizada
	 * @return UsuarioSalaPersonalizada - UsuarioSalaPersonalizada
	 */
	public UsuarioSalaPersonalizada[] getUsuariosSalaPersonalizada() {
	    return usuariosSalaPersonalizada;
	}
	
	/**
	 * M�todo para registro de todos os usu�rios da sala personalizada 
	 * @param usuariosSalaPersonalizada
	 */
	public void setUsuariosSalaPersonalizada(UsuarioSalaPersonalizada[] usuariosSalaPersonalizada) {
		this.usuariosSalaPersonalizada = usuariosSalaPersonalizada;
	}
	
	/** M�todo para pesquisar um usu�rio da sala personalizada
	 * @param -
	 * @return UsuarioSalaPersonalizada
	 */
	public UsuarioSalaPersonalizada pesquisarUsuarioSalaPersonalizada() {
		return null;
	}
}