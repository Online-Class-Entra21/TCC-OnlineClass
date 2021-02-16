package entidade;

import java.sql.Timestamp;

/**
 * Classe contendo mwtodos e atributos para o coordenador.
 * Herda metodos e atributos da classe Usuario
 * @see Usuario
 * @author Andre
 */
public class Coordenador extends Usuario {
	
    /**
     * Construtor padrao
     */
    public Coordenador() {
    	//Nenhum atributo inicializado
    }

    /**
     * Metodo construtor que preenche os atributos da classe superior 
     * @param idUsuario
     * @param nome
     * @param sobrenome
     * @param cpf
     * @param telefone
     * @param celular
     * @param tipoUsuario
     * @param email
     * @param senha
     * @param horarioInicioExpediente
     * @param horarioFinalExpediente
     * @param fotoUsuario
     * @param fk_endereco
     * @param fk_escola
     */
	public Coordenador(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
			int tipoUsuario, String email, String senha, Timestamp horarioInicioExpediente, Timestamp horarioFinalExpediente,
			String fotoUsuario, int fk_endereco, int fk_escola) {
		
		super(idUsuario, nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, senha, horarioInicioExpediente,
				horarioFinalExpediente, fotoUsuario, fk_endereco, fk_escola);
	}
}