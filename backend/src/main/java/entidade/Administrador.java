package entidade;

import java.sql.Time;

/**
 * Classe contendo metodos e atributos para o administrador.
 * Herda metodos e atributos da classe Usuario
 * @see Usuario
 * @author Andre
 */
public class Administrador extends Usuario {
	
	/**
	 * Construtor padrão
	 */
	public Administrador() {
		//Nenhum atributo inicializado
	}

    /**
     * Construtor usado ao instanciar a classe Administrador, herdando 
     * atributos da classe superior
     * @param idUsuario
     * @param nome
     * @param sobrenome
     * @param cpf
     * @param telefone
     * @param celular
     * @param email
     * @param senha
     * @param horarioInicioExpediente
     * @param horarioFinalExpediente
     * @param fotoUsuario
     * @param fk_endereco
     */
	public Administrador(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
						 String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
						 String fotoUsuario, int fk_endereco) {
		
		super(idUsuario, nome, sobrenome, cpf, telefone, celular, 1, email, senha, horarioInicioExpediente,
				horarioFinalExpediente, fotoUsuario, fk_endereco);
	} 
}