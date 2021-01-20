package entidade;

import java.sql.Time;

/**
 * Classe contendo metodos e atributos para o diretor.
 * Herda metodos e atributos da classe Usuario.
 * @see Usuario
 * @author André 
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
     * @param
     */
	 public Diretor(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
					String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
				    String fotoUsuario, int fk_endereco, int fk_escola) {
		 
			super(idUsuario, nome, sobrenome, cpf, telefone, celular, 2, email, senha, horarioInicioExpediente,
					horarioFinalExpediente, fotoUsuario, fk_endereco, fk_escola);
		}

	 
	 
	 
	 //---------
	 
	 
	 
//
//    /** M�todo para retorno do ID da escola.
//     * @return Int - ID da escola
//     */
//    public Escola getEscola() {
//        Escola escola = new Escola();
//        return escola;
//    }
//
//	/**
//     * 
//     */
//    public void atualizarEscola() {
//        // TODO implement here
//    }
//
//    /**
//     * 
//     */
//    public void verificaDisponibilidade() {
//        // TODO implement here
//    }
//
//    /** M�todo para retorno do ID do PeriodoAvaliacao.
//     * @return Int - ID PeriodoAvaliacao
//     */
//    public int getPeriodoAvaliacao() {
//        PeriodoAvaliacao periodoAvaliacao =  new PeriodoAvaliacao();
//        return periodoAvaliacao.getIdPeriodoAvaliacao();		
//    }
//
//    /**
//     * 
//     */
//    public void adicionarPeriodoAvaliacao() {
//        // TODO implement here
//    }
//
//    /**
//     * 
//     */
//    public void atualizarPeriodoAvaliacao() {
//        // TODO implement here
//    }
//
//    /**
//     * 
//     */
//    public void removerPeriodoAvaliacao() {
//        // TODO implement here
//    }
//
//    /** M�todo para retorno do ID do usu�rio.
//     * @return Int - ID do usu�rio
//     */
//    public int getUsuario() {
//        return getIdUsuario();
//    }
//
//    /**
//     * 
//     */
//    public void adicionarUsuario() {
//        // TODO implement here
//    }
//
//    /**
//     * 
//     */
//    public void atualizarUsuario() {
//        // TODO implement here
//    }
//
//    /**
//     * 
//     */
//    public void removerUsuario() {
//        // TODO implement here
//    }

}