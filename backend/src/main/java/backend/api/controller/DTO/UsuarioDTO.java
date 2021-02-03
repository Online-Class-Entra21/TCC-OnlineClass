package backend.api.controller.DTO;

import java.util.stream.Collectors;
import java.util.List;

import entidade.Usuario;

public class UsuarioDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String nomecompleto;

    public UsuarioDTO(Usuario usuario){
        this.nomecompleto = usuario.getNome()+" "+usuario.getSobrenome();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

    public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	} 

}
