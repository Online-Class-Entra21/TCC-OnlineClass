package backend.api.controller.DTO;

import java.util.stream.Collectors;
import java.util.List;

import entidade.Usuario;

/**
 * Metodo para filtragem do usuario
 * @author Andre 
 */
public class UsuarioDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String nomecompleto;

	/**
	 * Metodo construtor que passa um usuario para filtragem de atributos 
	 * @param usuario
	 */
    public UsuarioDTO(Usuario usuario){
        setNomecompleto(usuario.getNome()+" "+usuario.getSobrenome());
        setNome(usuario.getNome());
        setSobrenome(usuario.getSobrenome());
        setEmail(usuario.getEmail());
    }

	/**
	 * Metodo para retorno do nome
	 * @return String nome 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Metodo para insercao do nome 
	 * @param String nome 
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo para retorno do sobrenome
	 * @return String sobrenome 
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Metodo para insercao do sobrenome 
	 * @param String sobrenome 
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * Metodo para retorno do email
	 * @return String email 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo para insercao do email 
	 * @param String email 
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo para retorno do nomeCompleto 
	 * @return String nomeCompleto 
	 */
	public String getNomecompleto() {
		return nomecompleto;
	}

	/**
	 * Metodo para insercao do nomeCompleto 
	 * @param String nomeCompleto 
	 */
	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	/**
	 * Metodo para convercao da lista de usuarios para usuariosDTO
	 * @param List<Usuario> usuarios 
	 * @return List<UsuarioDTO>
	 */
    public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	} 
}
