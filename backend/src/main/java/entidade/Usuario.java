package entidade;

import java.sql.Timestamp;

/**
 * Classe contendo metodos e atributos para o usuario do sistema.
 * Os atributos e metodos dessa classe sao herdados pelas classes Administrador, Aluno, Coordenador, Diretor e Professor
 * @see Administrador
 * @see Aluno
 * @see Coordenador
 * @see Diretor
 * @see Professor
 * @author Breno
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
    private Timestamp horarioInicioExpediente;
    private Timestamp horarioFinalExpediente;
    private String fotoUsuario;
    private int fk_endereco;
    private int fk_escola;
    
    /**
     * Construtor padrao
     */
    public Usuario() {
    	//Nenhum atributo inicializado
    }

    /**
     * Metodo construtor que preenche todos os atributos da classe 
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
    public Usuario(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
				   int tipoUsuario, String email, String senha, Timestamp horarioInicioExpediente, Timestamp horarioFinalExpediente,
				   String fotoUsuario, int fk_endereco, int fk_escola) {
    	
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
		setFk_endereco(fk_endereco);
		setFk_escola(fk_escola);
	}
    
    /**
     * Metodo construtor que preenche todos os atributos da classe menos a escola 
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
     */
    public Usuario(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
			   	   int tipoUsuario, String email, String senha, Timestamp horarioInicioExpediente, Timestamp horarioFinalExpediente,
			       String fotoUsuario, int fk_endereco) {
	
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
		setFk_endereco(fk_endereco);
}

	/**
	 * Metodo para retorno do ID do usuario
     * @return int idUsuario
     */
    public int getIdUsuario() {
    	 return idUsuario;
    }

    /**
     * Metodo de insercao do id usuario 
     * @param int idUsuario
     */
    public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/** 
	 * Metodo para retorno do nome do usuario
     * @return String nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Metodo de insercao do nome
     * @param String nome
     */
    public void setNome(String nome) {
		this.nome = nome;
	}

    /** 
     * Metodo para retorno do sobrenome do usuario.
     * @return String sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Metodo de insercao do sobrenome do usuario
     * @param String sobrenome
     */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

    /** 
     * Metodo para retorno do cpf do usuario.
     * @return String cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Metodo de insercao do cpf do usuario 
     * @param String cpf
     */
    public void setCpf(String cpf) {
		this.cpf = cpf;
	}
    
    /** 
     * Metodo para retorno do telefone do usuario.
     * @return String telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Metodo para insercaoo do telefone do usuario 
     * @param String telefone
     */
    public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

    /** 
     * Metodo para retorno do numero de celular do usuario.
     * @return String celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Metodo para insercao do celular do usuario 
     * @param String celular
     */
    public void setCelular(String celular) {
		this.celular = celular;
	}

    /** 
     * 1 - Administrador,
	 * 2 - Diretor,
	 * 3 - Coordenador,
	 * 4 - Professor,
	 * 5 - Aluno.
     * 
     * Metodo para retorno do tipo de conta do usuario.
     * @return int tipoUsuario
	 * 							
     */
    public int getTipoUsuario() {
        return tipoUsuario;
    }

    /** 
     * Metodo para insercao do tipo do usuario
     * @param int tipoUsuario
     */
    public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

    /** 
     * Metodo para retorno do email do usuario
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo de insercao do email do usuario
     * @param String email
     */
    public void setEmail(String email) {
		this.email = email;
	}

    /**
     * Metodo de insercao de senha 
     * @param String senha
     */
    public void setSenha(String senha) {
		this.senha = senha;
	}
    
    /**
     * Metodo de retorno da senha do usuario
     * @return String senha 
     */
	public String getSenha() {
		return senha;
	}

	/** 
	 * Metodo para retorno do horario inicial do expediente do usuario.
     * @return Time horarioInicioExpediente
     */
    public Timestamp getHorarioInicioExpediente() {
        return horarioInicioExpediente;
    }

    /**
     * Metodo para insercao do horarioInicioExpediente do usuario
     * @param Time horarioInicioExpediente
     */
    public void setHorarioInicioExpediente(Timestamp horarioInicioExpediente) {
		this.horarioInicioExpediente = horarioInicioExpediente;
	}

    /** 
     * Metodo para retorno do horario final do expediente do usuario.
     * @return Time horarioFinalExpediente
     */
    public Timestamp getHorarioFinalExpediente() {
        return horarioFinalExpediente;
    }

    /**
     * Metodo para insercao do horarioFinalExpediente do usuario 
     * @param Time horarioFinalExpediente
     */
    public void setHorarioFinalExpediente(Timestamp horarioFinalExpediente) {
		this.horarioFinalExpediente = horarioFinalExpediente;
	}
    
    /**
     * Metodo para pegar o caminho da foto do usuario
     * @return String fotoUsuario
     */
    public String getFotoUsuario() {
		return fotoUsuario;
	}

    /**
     * Metodo de insercao do caminho da foto do usuario
     * @param String fotoUsuario
     */
	public void setFotoUsuario(String fotoUsuario) {
		this.fotoUsuario = fotoUsuario;
	}

	/**
	 * Metodo para retorno do FK do endereco
	 * @return int fk_endereco
	 */
	public int getFk_endereco() {
		return fk_endereco;
	}

	/**
	 * Metodo para insercao do FK do endereco
	 * @param int fk_endereco
	 */
	public void setFk_endereco(int fk_endereco) {
		this.fk_endereco = fk_endereco;
	}

	/**
	 * Metodo para retorno do FK da escola 
	 * @return int fk_escola 
	 */
	public int getFk_escola() {
		return fk_escola;
	}

	/**
	 * Metodo de insercao do FK da escola 
	 * @param int fk_escola
	 */
	public void setFk_escola(int fk_escola) {
		this.fk_escola = fk_escola;
	}
}