package entidade;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo m�todos e atributos para o usu�rio do sistema.
 * Os atributos e m�todos dessa classe s�o herdados pelas classes Administrador, Aluno, Coordenador, Diretor e Professor.
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
    private int tipoUsuario;
    private String email;
    private String senha;
    private Time horarioInicioExpediente;
    private Time horarioFinalExpediente;
    private String fotoUsuario;
    private Endereco endereco;
    private Escola escola;
    
    /**
     * Construtor usado ao instanciar a classe Usuario.
     * @param
     */
    public Usuario() {
    }

    /**
     * M�todo construtor que preenche todos os atributos da classe 
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
     * @param endereco
     * @param escola
     */
    public Usuario(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
				   int tipoUsuario, String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
				   String fotoUsuario, Endereco endereco, Escola escola) {
    	setIdUsuario(idUsuario);
		setNome(nome);
		setSobrenome(sobrenome);
		setCpf(cpf);
		setTelefone(telefone);
		setCelular(celular);
		setTipoUsuario(tipoUsuario);
		setEmail(email);
		setSenha(senha);
		setHorarioInicioExpediente(horarioInicioExpediente);
		setHorarioFinalExpediente(horarioFinalExpediente);
		setFotoUsuario(fotoUsuario);
		setEndereco(endereco);
		setEscola(escola);
	}

	/** M�todo para retorno do ID do usu�rio.
     * @return Int - ID do usu�rio
     */
    public int getIdUsuario() {
    	 return idUsuario;
    }

    /**
     * M�todo de inser��o do id usuario 
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/** M�todo para retorno do nome do usu�rio.
     * @return String - Nome do usu�rio
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * M�todo de inser��o do nome
     * @param nome
     */
    public void setNome(String nome) {
		this.nome = nome;
	}

    /**
     * M�todo para pegar o caminho da foto do usuario
     * @return
     */
    public String getFotoUsuario() {
		return fotoUsuario;
	}

    /**
     * M�todo de inser��o do caminho da foto do usuario
     * @param fotoUsuario
     */
	public void setFotoUsuario(String fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}

	
    /** M�todo para retorno do sobrenome do usu�rio.
     * @return String - Sobrenome do usu�rio
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * M�todo de inser��o do sobrenome do usuario
     * @param sobrenome
     */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

    /** M�todo para retorno do CPF do usu�rio.
     * @return String - CPF do usu�rio
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * M�todo de inser��o do cpf do usuario 
     * @param cpf
     */
    public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    /** M�todo para retorno do telefone do usu�rio.
     * @return String - Telefone do usu�rio
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * M�todo para inser��o do telefone do usuario 
     * @param telefone
     */
    public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

    /** M�todo para retorno do n�mero de celular do usu�rio.
     * @return String - N�mero de celular do usu�rio
     */
    public String getCelular() {
        return celular;
    }

    /**
     * M�todo para inser��o do celular do usuario 
     * @param celular
     */
    public void setCelular(String celular) {
		this.celular = celular;
	}

    /** M�todo para retorno do tipo de conta do usu�rio.
     * @return Byte - Tipo de conta do usu�rio.
     * 							0 - Aluno,
	 * 							1 - Professor,
	 * 							2 - Coordenador,
	 * 							3 - Diretor,
	 * 							4 - Administrador
     */
    public int getTipoUsuario() {
        return tipoUsuario;
    }

    /** M�todo para inser��o do tipo do usuario
     * @param tipoUsuario
     */
    public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

    /** M�todo para retorno do email do usu�rio.
     * @return String - Email do usu�rio
     */
    public String getEmail() {
        return email;
    }

    /**
     * M�todo de inser��o do email do usuario
     * @param email
     */
    public void setEmail(String email) {
		this.email = email;
	}

    /**
     * M�todo de inser��o de senha 
     * @param senha
     */
    public void setSenha(String senha) {
		this.senha = senha;
	}
    
    /**
     * M�todo de retorno da senha do usuario
     * @return
     */
	public String getSenha() {
		return senha;
	}

	/** M�todo para retorno do hor�rio inicial do expediente do usu�rio.
     * @return Time - Hor�rio inicial do expediente do usu�rio
     */
    public Time getHorarioInicioExpediente() {
        return horarioInicioExpediente;
    }

    /**
     * M�todo para inser��o do horarioInicioExpediente do usuario
     * @param horarioInicioExpediente
     */
    public void setHorarioInicioExpediente(Time horarioInicioExpediente) {
		this.horarioInicioExpediente = horarioInicioExpediente;
	}

    /** M�todo para retorno do hor�rio final do expediente do usu�rio.
     * @return Time - Hor�rio final do expediente do usu�rio
     */
    public Time getHorarioFinalExpediente() {
        return horarioFinalExpediente;
    }

    /**
     * M�todo para inser��o do horarioFinalExpediente do usuario 
     * @param horarioFinalExpediente
     */
    public void setHorarioFinalExpediente(Time horarioFinalExpediente) {
		this.horarioFinalExpediente = horarioFinalExpediente;
	}

    /** M�todo para retorno do endere�o do usu�rio.
     * @return Endereco - Endere�o do usu�rio
     */
    public Endereco getEndereco() {
        return endereco;
    }
    
    /**
     * M�todo para inser��o do endereco do usuario
     * @param endereco
     */
    public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

    /**
     * M�todo de retorno da escola 
     * @return
     */
    public Escola getEscola() {
		return escola;
	}

    /**
     * M�todo de inser��o da escola 
     * @param escola
     */
	public void setEscola(Escola escola) {
		this.escola = escola;
	}


	/** M�todo para a verifica��o de cpf.
     * Recebe uma String e converte para inteiro, realizando o c�lculo para a verifica��o do d�gito ver�ficador.
     * @param String - CPF a ser verificado. 
     * @return Boolean - True para CPF v�lido / False para inv�lido.
     */
    public boolean verificarCpf(String cpf) {
        return false;
    }

    /** M�todo para verifica��o do login.
     * 	Recebe o email e senha e verifica no banco de dados se os dados coincidem com os cadastrados pelo usu�rio.
     * @param String - Email a ser verificado.
     * @param String - Senha a ser verificada.
     * @return Boolean - True para login correto / False para incorreto.
     */
    public boolean verificarLogin(String email, String senha) {
        return false;
    }

    /** M�todo para pesquisar um usu�rio espec�fico a partir do ID.
     * @param Int - ID do usu�rio.
     * @return Usuario - Retorna o usu�rio.
     */
    public void pesquisarUsuario(int id) {
    }

    /** M�todo para envio de um relat�rio. 
     * @param -
     */
    public void mandarRelatorio() {
        // TODO implement here
    }

    /** M�todo para visualizar os relat�rios enviados, a partir do banco de dados.
     * @param -
     * @return Relatorio - Retorna os relat�rios enviados.
     */
    public Relatorio verRelatoriosEnviados() {
        return null;
    }

    /** M�todo para buscar um relat�rio enviado, a partir do banco de dados.
     * @param -
     * @return Relatorio - Retorna um relat�rio.
     */
    public void buscarRelatorioEnviado() {
        // TODO implement here
    }

    /** M�todo para visualizar os relat�rios recebidos, a partir do banco de dados.
     * @param -
     * @return Relatorio - Retorna os relat�rios recebidos.
     */
    public void verRelatoriosRecebidos() {
        // TODO implement here
    }

    /** M�todo para buscar um relat�rio recebido, a partir do banco de dados.
     * @param -
     * @return Relatorio - Retorna um relat�rio.
     */
    public void buscarRelatorioRecebido() {
        // TODO implement here
    }

    /** M�todo para a remo��o de um relat�rio.
     * @param Relatorio - Relat�rio a ser removido.
     */
    public void removerRelatorio(Relatorio relatorio) {
        // TODO implement here
    }

    /** M�todo para o envio do convite para acessar uma reuni�o.
     * @param -
     */
    public void mandarConvite() {
        // TODO implement here
    }

    /** M�todo para visualizar os convites enviados, a partir do banco de dados.
     * @param -
     * @return Convite - Retorna os convites enviados.
     */
    public void verConvitesEnviados() {
        // TODO implement here
    }

    /** M�todo para buscar um convite enviado, a partir do banco de dados.
     * @param -
     * @return Convite - Retorna um convite.
     */
    public void buscarConviteEnviado() {
        // TODO implement here
    }

    /** M�todo para buscar os convites recebidos, a partir do banco de dados.
     * @param -
     * @return Convite - Retorna os convites recebidos.
     */
    public void verConvitesRecebidos() {
        // TODO implement here
    }

    /** M�todo para buscar um convite recebido, a partir do banco de dados.
     * @param -
     * @return Convite - Retorna um convite.
     */
    public void buscarConviteRecebido() {
        // TODO implement here
    }

    /** M�todo para a remo��o de um convite.
     * @param Convite - Convite a ser removido.
     */
    public void removerConvite() {
        // TODO implement here
    }

    /** M�todo para a aceita��o de um convite.
     * @param Boolean - Resposta do convite.
     * @return Boolean - True.
     */
    public boolean aceitarConvite(boolean convite) {
        return true;
    }

    /** M�todo para recusar um convite.
     * @param Boolean - Resposta do convite.
     * @return Boolean - False.
     */
    public boolean recusarConvite(boolean convite) {
        return false;
    }

    /** M�todo para o envio de um arquivo.
     * @param -
     */
    public void mandarArquivo() {
        // TODO implement here
    }

    /** M�todo para visualizar os arquivos enviados, a partir do banco de dados.
     * @param -
     * @return Arquivo - Retorna os arquivos enviados.
     */
    public Arquivo verArquivosEnviados() {
        return null;
    }

    /** M�todo para visualizar um arquivo espec�fico enviado, a partir do banco de dados.
     * @param -
     * @return Arquivo - Retorna o arquivo.
     */
    public void buscarArquivoEnviado() {
        // TODO implement here
    }

    /** M�todo para visualizar os arquivos recebidos, a partir do banco de dados.
     * @param -
     * @return Arquivo - Retorna os arquivos recebidos.
     */
    public void verArquivosRecebidos() {
        // TODO implement here
    }

    /** M�todo para visualizar arquivo espec�fico recebido, a partir do banco de dados.
     * @param -
     * @return Arquivo - Retorna o arquivo.
     */
    public void buscarArquivoRecebido() {
        // TODO implement here
    }

    /** M�todo para a remo��o de um arquivo.
     * @param -
     */
    public void removerArquivo() {
        // TODO implement here
    }

    /** M�todo para visualizar uma sala personalizada.
     * @param -
     * @return SalaPersonalizada.
     */
    public SalaPersonalizada getSalaPersonalizada() {
        return null;
    }

    /** M�todo para a cria��o de uma sala personalizada.
     * @param -
     */
    public void criarSalaPersonalizada() {
        // TODO implement here
    }

    /** M�todo para atualizar uma sala personalizada.
     * @param SalaPersonalizadaDAO - Sala a ser atualizada.
     */
    public void atualizarSalaPersonalizada(SalaPersonalizada salaP) {
        // TODO implement here
    }

    /** M�todo para remo��o de uma sala personalizada.
     * @param SalaPersonalizadaDAO - Sala a ser removida.
     */
    public void removerSalaPersonalizada(SalaPersonalizada salaP) {
        // TODO implement here
    }

    /** M�todo para visualizar uma reuni�o.
     * @return Reuniao.
     */
    public Reuniao getReuniao() {
        return null;
    }

    /** M�todo para a cria��o de uma reuni�o.
     * @param -
     */
    public void criarReuniao() {
        // TODO implement here
    }

    /** M�todo para a atualiza��o de uma reuni�o.
     * @param Reuniao - Reuni�o a ser atualizada.
     */
    public void atualizarReuniao(Reuniao reuniao) {
        // TODO implement here
    }

    /** M�todo para a remo��o de uma reuni�o.
     * @param Reuniao - Reuni�o a ser removida.
     */
    public void removerReuniao(Reuniao reuniao) {
        // TODO implement here
    }

    /** M�todo para entrar em uma reuni�o.
     * @param - 
     */
    public void entrarReuniao() {
        // TODO implement here
    }

    /** M�todo para sair de uma reuni�o.
     * @param -
     */
    public void sairReuniao() {
        // TODO implement here
    }

    /** M�todo para visualizar uma chamada.
     * @param - 
     * @return Chamada.
     */
    public Chamada getChamada() {
        return null;
    }

    /** M�todo para a realiza��o da chamada.
     * @param -
     */
    public void fazerChamada() {
        // TODO implement here
    }

    /** M�todo a remo��o de uma chamada.
     *  @param Chamada - Chamada a ser removida.
     */
    public void removerChamada(Chamada chamada) {
        // TODO implement here
    }

}