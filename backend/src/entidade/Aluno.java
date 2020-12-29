package entidade;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo métodos e atributos para o aluno.
 * Herda métodos e atributos da classe Usuario.
 * @see Usuario
 * @author  
 */
public class Aluno extends Usuario {
    private int idAluno;
    private int ra;
    private String matricula;
    private boolean deficienciaFisica;
    private String nomeMae;
    private String nomePai;
    private String nomeResponsavel;
    private boolean situacaoAnoLetivo;
    private Resposta respostas[];
    private Turma turma;
    
    public Aluno() {
    	
    }
/**
 * 
 * @param idAluno
 * @param ra
 * @param matricula
 * @param deficienciaFisica
 * @param nomeMae
 * @param nomePai
 * @param nomeResponsavel
 * @param situacaoAnoLetivo
 * @param turma
 */
    public Aluno(int idAluno, int ra, String matricula, boolean deficienciaFisica, 
    			 String nomeMae, String nomePai, String nomeResponsavel, boolean situacaoAnoLetivo, Turma turma) {
    	setIdAluno(idAluno);
    	setRa(ra);
    	setMatricula(matricula);
    	setDeficienciaFisica(deficienciaFisica);
    	setNomeMae(nomeMae);
    	setNomePai(nomePai);
    	setNomeResponsavel(nomeResponsavel);
    	setSituacaoAnoLetivo(situacaoAnoLetivo);
    	setTurma(turma);
    }
    /**
     * Construtor usado ao instanciar a classe Aluno.
     * @param
     */
    public Aluno(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
			   int tipoUsuario, String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
			   String fotoUsuario, Endereco endereco, Escola escola) {
    	super(idUsuario, nome, sobrenome, cpf, telefone, celular,
				   tipoUsuario, email, senha, horarioInicioExpediente, horarioFinalExpediente,
				   fotoUsuario, endereco, escola);
	setTipoUsuario(0);
    }
    
    
    /** Método para retorno do ID do aluno.
     * @return Int - ID do usuário
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * 
     */
    public void setIdAluno() {
        // TODO implement here
    }

    /** Método para retorno do RA do aluno.
     * @return Int - RA do usuário
     */
    public int getRa() {
        return ra;
    }

    /**
     * 
     */
    public void setRa() {
        // TODO implement here
    }

    /** Método para retorno da matrícula do aluno.
     * @return String - Matrícula do usuário
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * 
     */
    public void setMatricula() {
        // TODO implement here
    }

    /** Método para retornar se o aluno possui alguma deficiência física.
     * @return Boolean - Possui deficiência física? True / False
     */
    public boolean getDeficienciaFisica() {
        return deficienciaFisica;
    }

    /**
     * 
     */
    public void setDeficienciaFisica() {
        // TODO implement here
    }

    /** Método para retorno do nome da mãe do aluno.
     * @return String - Nome do mãe do aluno
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * 
     */
    public void setNomeMae() {
        // TODO implement here
    }

    /** Método para retorno do nome do pai do aluno.
     * @return String - Nome do pai do aluno
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * 
     */
    public void setNomePai() {
        // TODO implement here
    }

    /** Método para retorno do nome do responsável pelo aluno.
     * @return String - Nome do responsável pelo aluno
     */
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    /**
     * 
     */
    public void setNomeResponsavel() {
        // TODO implement here
    }

    /** Método para retorno da situação do ano letivo do aluno.
     * @return Boolean - True para aprovado / False para reprovado
     */
    public boolean getSituacaoAnoLetivo() {
        return situacaoAnoLetivo;
    }

    /**
     * 
     */
    public void setSituacaoAnoLetivo() {
        // TODO implement here
    }

    /**
	 * @return the turma
	 */
	public Turma getTurma() {
		return turma;
	}
	/**
	 * @param turma the turma to set
	 */
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	/** Método para o envio de uma resposta à uma atividade.
     * @param Resposta - Resposta a ser enviada.
     */
    public void mandarResposta(Resposta resposta) {
        // TODO implement here
    }

    /** Método para visualizar as respostas enviadas, a partir do banco de dados.
     * @param -
     * @return Resposta - Retorna as respostas enviadas.
     */
    public Resposta verRespostasEnviadas() {
        return null;
    }

    /** Método para visualizar uma resposta enviada específica, a partir do banco de dados.
     * @param -
     * @return Resposta - Retorna uma resposta.
     */
    public Resposta buscarRespostaEnviada(Resposta resposta) {
        return null;
    }

    /** Método para a remoção de uma resposta.
     * @param Resposta - Resposta a ser removida.
     */
    public void removerResposta(Resposta resposta) {
        // TODO implement here
    }

    /** Método para visualizar as atividades recebidas, a partir do banco de dados.
     * @param -
     * @return Atividade - Retorna as atividades recebidas.
     */
    public Atividade verAtividadesRecebidas() {
        return null;
    }

    /** Método para visualizar uma atividade recebida específica, a partir do banco de dados.
     * @param -
     * @return Atividade - retorna uma atividade.
     */
    public Atividade pesquisarAtividadeRecebida() {
        return null;
    }

    /** Método para a visualização das notas
     * @param -
     * @return Resposta - Retorna as notas.
     */
    public Resposta verNotas() {
        return null;
    }

}