package Sistema;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo métodos e atributos para o usuário do sistema.
 * Os atributos e métodos dessa classe são herdados pelas classes Administrador, Aluno, Coordenador, Diretor e Professor.
 * @see Administrador
 * @see Aluno
 * @see Coordenador
 * @see Diretor
 * @see Professor
 * @author 
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String celular;
    private byte tipoUsuario;
    private String email;
    private String senha;
    private Time horarioInicioExpediente;
    private Time horarioFinalExpediente;
    private byte fotoUsuario[];
    private Endereco endereco;
    
    /**
     * Construtor utilizado para instanciar a classe Usuario.
	 * @param nome				Nome completo do usuário do sistema.
	 * @param tipoUsuario		Tipo de conta do Usuário:
	 * 							0 - Aluno
	 * 							1 - Professor
	 * 							2 - Coordenador
	 * 							3 - Diretor
	 * 							4 - Administrador
	 * @param email				Email cadastrado pelo usuário.
     */
    public Usuario() {
    }


    /** Método para retorno do ID do usuário.
     * @return Int - ID do usuário
     */
    public int getIdUsuario() {
    	 return idUsuario;
    }

    /**
     * 
     */
    public void setIdUsuario() {
        // TODO implement here
    }

    /** Método para retorno do nome do usuário.
     * @return String - Nome do usuário
     */
    public void getNome() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setNome() {
        // TODO implement here
    }

    /** Método para retorno do sobrenome do usuário.
     * @return String - Sobrenome do usuário
     */
    public void getSobrenome() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setSobrenome() {
        // TODO implement here
    }

    /** Método para retorno do CPF do usuário.
     * @return String - CPF do usuário
     */
    public void getCpf() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setCpf() {
        // TODO implement here
    }

    /** Método para retorno do telefone do usuário.
     * @return String - Telefone do usuário
     */
    public void getTelefone() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setTelefone() {
        // TODO implement here
    }

    /** Método para retorno do número de celular do usuário.
     * @return String - Número de celular do usuário
     */
    public void getCelular() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setCelular() {
        // TODO implement here
    }

    /** Método para retorno do tipo de conta do usuário.
     * @return Byte - Tipo de conta do usuário.
     * 							0 - Aluno
	 * 							1 - Professor
	 * 							2 - Coordenador
	 * 							3 - Diretor
	 * 							4 - Administrador
     */
    public void getTipoUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setTipoUsuario() {
        // TODO implement here
    }

    /** Método para retorno do email do usuário.
     * @return String - Email do usuário
     */
    public void getEmail() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setEmail() {
        // TODO implement here
    }

    /** Método para retorno da senha do usuário.
     * @return String - Senha do usuário
     */
    private void getSenha() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setSenha() {
        // TODO implement here
    }

    /** Método para retorno do horário inicial do expediente do usuário.
     * @return Time - Horário inicial do expediente do usuário
     */
    public void getHorarioInicioExpediente() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setHorarioInicioExpediente() {
        // TODO implement here
    }

    /** Método para retorno do horário final do expediente do usuário.
     * @return Time - Horário final do expediente do usuário
     */
    public void getHorarioFinalExpediente() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setHorarioFinalExpediente() {
        // TODO implement here
    }

    /** Método para retorno da foto do usuário.
     * @return Byte - Foto do usuário
     */
    public void getFoto() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setFoto() {
        // TODO implement here
    }

    /** Método para retorno do endereço do usuário.
     * @return Endereco - Endereço do usuário
     */
    public void getEndereco() {
        // TODO implement here
    }

    /**
     * 
     */
    public void setEndereco() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verificarCpf() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verificarLogin() {
        // TODO implement here
    }

    /**
     * 
     */
    public void pesquisarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mandarRelatorio() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verRelatoriosEnviados() {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarRelatorioEnviado() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verRelatoriosRecebidos() {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarRelatorioRecebido() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerRelatorio() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mandarConvite() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verConvitesEnviados() {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarConviteEnviado() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verConvitesRecebidos() {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarConviteRecebido() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerConvite() {
        // TODO implement here
    }

    /**
     * 
     */
    public void aceitarConvite() {
        // TODO implement here
    }

    /**
     * 
     */
    public void recusarConvite() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mandarArquivo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verArquivosEnviados() {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarArquivoEnviado() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verArquivosRecebidos() {
        // TODO implement here
    }

    /**
     * 
     */
    public void buscarArquivoRecebido() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerArquivo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getSalaPersonalizada() {
        // TODO implement here
    }

    /**
     * 
     */
    public void criarSalaPersonalizada() {
        // TODO implement here
    }

    /**
     * 
     */
    public void atualizarSalaPersonalizada() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerSalaPersonalizada() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getReuniao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void criarReuniao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void atualizarReuniao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerReuniao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void entrarReuniao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void sairReuniao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void getChamada() {
        // TODO implement here
    }

    /**
     * 
     */
    public void fazerChamada() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerChamada() {
        // TODO implement here
    }

}