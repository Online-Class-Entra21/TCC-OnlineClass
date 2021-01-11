package entidade;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo m�todos e atributos para o diretor.
 * Herda m�todos e atributos da classe Usuario.
 * @see Usuario
 * @author 
 */
public class Diretor extends Usuario {
	public Diretor() {
		
	}
	
	/**
     * Construtor usado ao instanciar a classe Diretor.
     * @param
     */
    public Diretor(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
			   int tipoUsuario, String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
			   String fotoUsuario, Endereco endereco, Escola escola) {
    	super(idUsuario, nome, sobrenome, cpf, telefone, celular,
				   tipoUsuario, email, senha, horarioInicioExpediente, horarioFinalExpediente,
				   fotoUsuario, endereco, escola);
 	setTipoUsuario(3);
    }


    /** M�todo para retorno do ID da escola.
     * @return Int - ID da escola
     */
    public Escola getEscola() {
        Escola escola = new Escola();
        return escola;
    }

    /**
     * 
     */
    public void atualizarEscola() {
        // TODO implement here
    }

    /**
     * 
     */
    public void verificaDisponibilidade() {
        // TODO implement here
    }

    /** M�todo para retorno do ID do PeriodoAvaliacao.
     * @return Int - ID PeriodoAvaliacao
     */
    public int getPeriodoAvaliacao() {
        PeriodoAvaliacao periodoAvaliacao =  new PeriodoAvaliacao();
        return periodoAvaliacao.getIdPeriodoAvaliacao();		
    }

    /**
     * 
     */
    public void adicionarPeriodoAvaliacao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void atualizarPeriodoAvaliacao() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerPeriodoAvaliacao() {
        // TODO implement here
    }

    /** M�todo para retorno do ID do usu�rio.
     * @return Int - ID do usu�rio
     */
    public int getUsuario() {
        return getIdUsuario();
    }

    /**
     * 
     */
    public void adicionarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void atualizarUsuario() {
        // TODO implement here
    }

    /**
     * 
     */
    public void removerUsuario() {
        // TODO implement here
    }

}