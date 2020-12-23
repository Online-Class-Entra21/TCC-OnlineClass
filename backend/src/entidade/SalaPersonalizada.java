package entidade;

import java.util.Arrays;

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
	 * Método de exibição das inforações
	 */
	@Override
	public String toString() {
		return "SalaPersonalizada [idSalaPersonalizada=" + idSalaPersonalizada + ", dono=" + dono + ", fk_sala="
				+ sala + ", usuariosSalaPersonalizada=" + Arrays.toString(usuariosSalaPersonalizada) + "]";
	}

	/** Método para retorno do ID da sala personalizada
	 * @return Int - ID da sala personalizada
	 */
	public int getIdSalaPersonalizada() {
	    return idSalaPersonalizada;
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
	public Sala getSala() {
		return sala;
	}
	
	/**
	 * Método de inserção no numero da sala que faz referência na sala personalizada 
	 * @param fk_sala
	 */
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	/** Método para retorno do UsuarioSalaPersonalizada
	 * @return UsuarioSalaPersonalizada - UsuarioSalaPersonalizada
	 */
	public UsuarioSalaPersonalizada[] getUsuariosSalaPersonalizada() {
	    return usuariosSalaPersonalizada;
	}
	
	/**
	 * Método para registro de todos os usuários da sala personalizada 
	 * @param usuariosSalaPersonalizada
	 */
	public void setUsuariosSalaPersonalizada(UsuarioSalaPersonalizada[] usuariosSalaPersonalizada) {
		this.usuariosSalaPersonalizada = usuariosSalaPersonalizada;
	}
	
	/** Método para pesquisar um usuário da sala personalizada
	 * @param -
	 * @return UsuarioSalaPersonalizada
	 */
	public UsuarioSalaPersonalizada pesquisarUsuarioSalaPersonalizada() {
		return null;
	}
}