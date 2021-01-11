package entidade;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo m�todos e atributos para o aluno.
 * Herda m�todos e atributos da classe Usuario.
 * @see Usuario
 * @author  
 */
public class Aluno extends Usuario {
    private int idAluno;
    private int ra;
    private int matricula;
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
    public Aluno(int idAluno, int ra, int matricula, boolean deficienciaFisica, 
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
    
    
    /** M�todo para retorno do ID do aluno.
     * @return Int - ID do usu�rio
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * 
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    /** M�todo para retorno do RA do aluno.
     * @return Int - RA do usu�rio
     */
    public int getRa() {
        return ra;
    }

    /**
     * 
     */
    public void setRa(int ra) {
        this.ra = ra;
    }

    /** M�todo para retorno da matr�cula do aluno.
     * @return String - Matr�cula do usu�rio
     */
    public int getMatricula() {
        return 0;
    }

    /**
     * 
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /** M�todo para retornar se o aluno possui alguma defici�ncia f�sica.
     * @return Boolean - Possui defici�ncia f�sica? True / False
     */
    public boolean getDeficienciaFisica() {
        return deficienciaFisica;
    }

    /**
     * 
     */
    public void setDeficienciaFisica(boolean deficienciaFisica) {
        this.deficienciaFisica = deficienciaFisica;
    }

    /** M�todo para retorno do nome da m�e do aluno.
     * @return String - Nome do m�e do aluno
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * 
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae =  nomeMae;
    }

    /** M�todo para retorno do nome do pai do aluno.
     * @return String - Nome do pai do aluno
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * 
     */
    public void setNomePai(String nomePai) {
    	this.nomePai = nomePai;
    }

    /** M�todo para retorno do nome do respons�vel pelo aluno.
     * @return String - Nome do respons�vel pelo aluno
     */
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    /**
     * 
     */
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    /** M�todo para retorno da situa��o do ano letivo do aluno.
     * @return Boolean - True para aprovado / False para reprovado
     */
    public boolean getSituacaoAnoLetivo() {
        return situacaoAnoLetivo;
    }

    /**
     * 
     */
    public void setSituacaoAnoLetivo(boolean situacaoAnoLetivo) {
        this.situacaoAnoLetivo = situacaoAnoLetivo;
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
	/** M�todo para o envio de uma resposta � uma atividade.
     * @param Resposta - Resposta a ser enviada.
     */
    public void mandarResposta(Resposta resposta) {
        // TODO implement here
    }

    /** M�todo para visualizar as respostas enviadas, a partir do banco de dados.
     * @param -
     * @return Resposta - Retorna as respostas enviadas.
     */
    public Resposta verRespostasEnviadas() {
        return null;
    }

    /** M�todo para visualizar uma resposta enviada espec�fica, a partir do banco de dados.
     * @param -
     * @return Resposta - Retorna uma resposta.
     */
    public Resposta buscarRespostaEnviada(Resposta resposta) {
        return null;
    }

    /** M�todo para a remo��o de uma resposta.
     * @param Resposta - Resposta a ser removida.
     */
    public void removerResposta(Resposta resposta) {
        // TODO implement here
    }

    /** M�todo para visualizar as atividades recebidas, a partir do banco de dados.
     * @param -
     * @return Atividade - Retorna as atividades recebidas.
     */
    public Atividade verAtividadesRecebidas() {
        return null;
    }

    /** M�todo para visualizar uma atividade recebida espec�fica, a partir do banco de dados.
     * @param -
     * @return Atividade - retorna uma atividade.
     */
    public Atividade pesquisarAtividadeRecebida() {
        return null;
    }

    /** M�todo para a visualiza��o das notas
     * @param -
     * @return Resposta - Retorna as notas.
     */
    public Resposta verNotas() {
        return null;
    }

}