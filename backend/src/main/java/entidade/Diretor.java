package entidade;

import java.sql.Time;

/**
 * Classe contendo metodos e atributos para o diretor.
 * Herda metodos e atributos da classe Usuario.
 * @see Usuario
 * @author Andre
 */
public class Diretor extends Usuario {
	
	/**
     * Construtor padrao
     */
	public Diretor() {
		//Nenhum atributo inicializado
	}
	
	 /**
	  * Metodo construtor que preenche todos os atributos da classe superior
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
	  * @param fk_escola
	  */
	 public Diretor(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
					String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
				    String fotoUsuario, int fk_endereco, int fk_escola) {
		 
			super(idUsuario, nome, sobrenome, cpf, telefone, celular, 2, email, senha, horarioInicioExpediente,
					horarioFinalExpediente, fotoUsuario, fk_endereco, fk_escola);
	 }
}