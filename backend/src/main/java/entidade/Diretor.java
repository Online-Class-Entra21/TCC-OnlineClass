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
	  * @param idUsuario
	  * @param nome
	  * @param sobrenome
	  * @param cpf
	  * @param telefone
	  * @param celular
	  * @param email
	  * @param senha
	  * @param horarioInicioExpediente
	  * @param horarioFinalExpediente
	  * @param fotoUsuario
	  * @param fk_endereco
	  * @param fk_escola
	  */
	 public Diretor(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
					String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
				    String fotoUsuario, int fk_endereco, int fk_escola) {
		 
			super(idUsuario, nome, sobrenome, cpf, telefone, celular, 2, email, senha, horarioInicioExpediente,
					horarioFinalExpediente, fotoUsuario, fk_endereco, fk_escola);
	 }
	 
	 
	 //---------------------
	 

//    /** 
//     * Metodo para retorno do ID da escola.
//     * @return Escola 
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
//    
//    /**
//     * Metodo para retorno do ID do professor
//     * @param int idProfessor
//     * @return Professor professor
//     */
//    public Professor getProfessor(int idProfessor) {
//    	ProfessorDAO professorDao = new ProfessorDAO();
//        Professor professor = professorDao.buscarId(idProfessor);
//        return professor;
//    }
//
//    /**
//     * Metodo para adicionar um professor
//     * @param professor
//     */
//    public void adicionarProfessor(Professor professor) {
//    	ProfessorDAO professorDao = new ProfessorDAO();
//    	professorDao.insert(professor);
//    }
//
//    /** 
//     * Metodo para atualizar um professor
//     * @param Professor professor
//     */
//    public void atualizarProfessor(Professor professor) {
//        ProfessorDAO professorDao = new ProfessorDAO();
//        professorDao.update(professor);
//    }
//
//    /** 
//     * Metodo para a remocao de um professor
//     * @param Professor professor 
//     */
//    public void removerProfessor(Professor professor) {
//        ProfessorDAO professorDao = new ProfessorDAO();
//        professorDao.delete(professor);
//    }

}