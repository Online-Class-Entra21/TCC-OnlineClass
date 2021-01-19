package entidade;

import java.sql.Time;

/**
 * Classe contendo mwtodos e atributos para o coordenador.
 * Herda metodos e atributos da classe Usuario.
 * @see Usuario
 * @author 
 */
public class Coordenador extends Usuario {
	
	/**
     * Construtor padrao
     */
    public Coordenador() {
    	//Nenhum atributo inicializado
    }

    /**
     * Metodo construtor que preenche os atributos da classe superior 
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
	public Coordenador(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
			int tipoUsuario, String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
			String fotoUsuario, int fk_endereco, int fk_escola) {
		
		super(idUsuario, nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, senha, horarioInicioExpediente,
				horarioFinalExpediente, fotoUsuario, fk_endereco, fk_escola);
	}
    
    
    //------------------
    
    

//    /** M�todo para retorno do ID da turma.
//     * @return Int - ID da turma
//     */
//    public Turma getTurma(TurmaDAO turmaDAO, int idTurma) {
//        Turma turma = turmaDAO.buscarPorId(idTurma);
//        return turma;
//    }
//
//    /** M�todo para adicionar uma turma.
//     * @param -
//     */
//    public void adicionarTurma(int idTurma, String ano, int qtdAluno, Time horarioInicioAula, Time horarioFinalAula, SalaPadrao salaPadrao) {
//        Turma turma = new Turma(idTurma, ano, qtdAluno, horarioInicioAula, horarioFinalAula, salaPadrao);
//        TurmaDAO turmaDAO = new TurmaDAO();
//        turmaDAO.insert(turma);
//    }
//
//    /** M�todo para atualizar uma turma.
//     * @param Turma - Turma a ser atualizada.
//     */
//    public void atualizarTurma(Turma turma) {
//        TurmaDAO turmaDAO = new TurmaDAO();
//        turmaDAO.update(turma);
//    }
//
//    /** M�todo para a remo��o de uma turma.
//     * @param Turma - Turma a ser removida.
//     */
//    public void removerTurma(Turma turma) {
//        TurmaDAO turmaDAO = new TurmaDAO();
//        turmaDAO.delete(turma.getIdTurma());
//    }
///**
// * Consertar a classe DisciplinaDAO antes de descomentar
// */
////    /** M�todo para retorno do ID da disciplina.
////     * @return Int - ID da disciplina
////     */
////    public Disciplina getDisciplina(DisciplinaDAO disciplinaDAO, int idDisciplina) {
////    	Disciplina disciplina = disciplinaDAO.buscarId(idDisciplina);
////    	return disciplina;
////    }
////
////    /** M�todo para adicionar uma disciplina.
////     * @param -
////     */
////    public void adicionarDisciplina(int idDisciplina, String nome, int numeroAulas) {
////        Disciplina disciplina = new Disciplina(idDisciplina, nome, numeroAulas);
////        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
////        disciplinaDAO.insert(disciplina);
////    }
////
////    /** M�todo para atualizar uma disciplina.
////     * @param DisciplinaDAO - Disciplina a ser atualizada.
////     */
////    public void atualizarDisciplina(Disciplina disciplina) {
////        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
////        disciplinaDAO.update(disciplina);
////    }
////
////    /** M�todo para a remo��o de uma disciplina.
////     * @param DisciplinaDAO - Disciplina a ser removida.
////     */
////    public void removerDisciplina(Disciplina disciplina) {
////        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
////        disciplinaDAO.deleteID(disciplina.getIdDisciplina());
////    }
//
//    /** M�todo para retorno do ID do aluno.
//     * @return Int - ID do aluno
//     */
//    public Aluno getAluno(AlunoDAO alundoDAO, int idAluno) {
//        Aluno aluno =  AlunoDAO.buscarId(idAluno);
//        return aluno;	
//    }
//
//    /** M�todo para atualizar um aluno.
//     * @param Aluno - Aluno a ser atualizado
//     */
//    public void atualizarAluno(Aluno aluno) {
//    	AlunoDAO alunoDAO = new AlunoDAO();
//        alunoDAO.update(aluno);
//    }
//
//    /** M�todo para a remo��o de um aluno.
//     * @param Aluno - Aluno a ser removido.
//     */
//    public void removerAluno(Aluno aluno) {
//        AlunoDAO alunoDAO = new AlunoDAO();
//        alunoDAO.delete(aluno);
//    }
//    /**
//     * 
//     */
//    public void removerAlunoTabelaUsuario(Usuario usuario) {
//    	UsuarioDAO usuarioDAO = new UsuarioDAO();
//    	usuarioDAO.delete(usuario.getIdUsuario());
//    }
//
//    /** M�todo para adicionar um aluno.
//     * @param -
//     */
//    public void adicionarAluno(int idAluno, int ra, String matricula, boolean deficienciaFisica, 
//			 				   String nomeMae, String nomePai, String nomeResponsavel, boolean situacaoAnoLetivo, Turma turma) {
//    	Aluno aluno = new Aluno(idAluno, ra, matricula, deficienciaFisica, nomeMae, nomePai, nomeResponsavel, situacaoAnoLetivo, turma);
//    	AlunoDAO alunoDAO = new AlunoDAO();
//    	alunoDAO.insert(aluno);
//    }
//    /**
//     * 
//     */
//    public void adicionarAlunoTabelaUsuario(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular, String email,
//			 String senha, Time horarioInicioExpediente, Time horarioFinalExpediente, String fotoUsuario,
//			 Endereco endereco, Escola escola) {
//    	Usuario aluno = new Usuario(idUsuario, nome, sobrenome, cpf, telefone, celular, 0, email, senha, horarioInicioExpediente,
//    								horarioFinalExpediente, fotoUsuario, endereco, escola);
//    	UsuarioDAO usuarioDAO = new UsuarioDAO();
//    	usuarioDAO.insert(aluno);
//    }
//    /** M�todo para retorno do ID do professor.
//     * @return Int - ID do professor
//     */
//    public Professor getProfessor(ProfessorDAO professorDAO, int idProfessor) {
//        Professor professor = ProfessorDAO.buscarId(idProfessor);
//        return professor;
//    }
//
//    /** M�todo para adicionar um professor.
//     * @param -
//     */
//    public void adicionarProfessor(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular, String email,
//			 String senha, Time horarioInicioExpediente, Time horarioFinalExpediente, String fotoUsuario,
//			 Endereco endereco, Escola escola) {
//    	Usuario professor = new Usuario(idUsuario, nome, sobrenome, cpf, telefone, celular, 1, email,
//				  senha, horarioInicioExpediente, horarioFinalExpediente, fotoUsuario, endereco, escola);
//    	ProfessorDAO professorDAO = new professorDAO();
//    	professorDAO.insert(professor);
//    }
//
//    /** M�todo para atualizar um professor.
//     * @param Professor - Professor a ser atualizado.
//     */
//    public void atualizarProfessor(Professor professor) {
//        ProfessorDAO professorDAO = new ProfessorDAO();
//        professorDAO.update(professor);
//    }
//
//    /** M�todo para a remo��o de um professor.
//     * @param Professor - Professor a ser removido.
//     */
//    public void removerProfessor(Professor professor) {
//        ProfessorDAO professorDAO = new ProfessorDAO();
//        professorDAO.delete(professor);
//    }
//
//    /** M�todo para retorno do ID do ProfessorDisciplina.
//     * @return Int - ID ProfessorDisciplina
//     */
//    public int getProfessorDisciplina() {
//        ProfessorDisciplina profDisci = new ProfessorDisciplina();
//        return profDisci.getIdProfessorDisciplina();
//    }
//
//    /** M�todo para a atribui��o de um professor � uma disciplina.
//     * @param -
//     */
//    public void adicionarProfessorDisciplina() {
//        // TODO implement here
//    }
//
//    /** M�todo para atualizar a liga��o do professor � uma disciplina.
//     * @param ProfessorDisciplina
//     */
//    public void atualizarProfessotDisciplina() {
//        // TODO implement here
//    }
//
//    /** M�todo para a remo��o de uma liga��o do professor � uma disciplina.
//     * @param
//     */
//    public void removerProfessorDisciplina() {
//        // TODO implement here
//    }
//
//    /** M�todo para retorno do ID TurmaProfessorDisciplina.
//     * @return Int - ID TurmaProfessorDisciplina
//     */
//    public int getTurmaProfessorDisciplina() {
//        TurmaProfessorDisciplina turmaPD = new TurmaProfessorDisciplina();
//        return turmaPD.getIdTurmaProfessorDisciplina();
//    }
//
//    /** M�todo para adicionar a liga��o entre a turma, professor e disciplina.
//     * @param -
//     */
//    public void adicionarTurmaProfessorDisciplina() {
//        // TODO implement here
//    }
//
//    /** M�todo para remover a liga��o entre a turma, professor e disciplina.
//     * @param TurmaProfessorDisciplinaDAO
//     */
//    public void removerTurmaProfessorDisciplina(TurmaProfessorDisciplina turmaPD) {
//        // TODO implement here
//    }
//
//    /** M�todo para retorno do ID da sala padr�o de cada turma.
//     * @return Int - ID da sala padr�o
//     */
//    public int getSalaPadrao() {
//        SalaPadrao salaPadrao = new SalaPadrao();
//        return salaPadrao.getIdSala();
//    }
//
//    /** M�todo para adicionar uma sala padr�o � uma turma.
//     * @param Turma - Turma a ser atribuida � sala padr�o.
//     */
//    public void adicionarSalaPadrao(Turma turma) {
//        // TODO implement here
//    }
//
//    /** M�todo para atualizar a sala padr�o.
//     * @param SalaPadrao - Sala a ser atualizada
//     */
//    public void atualizarSalaPadrao(SalaPadrao salaP) {
//        // TODO implement here
//    }
//
//    /** M�todo para a remo��o de uma sala padr�o.
//     * @param SalaPadrao - Sala a ser removida.
//     * @param Turma - Turma a ter a sala padr�o removida.
//     */
//    public void removerSalaPadrao(SalaPadrao salaP, Turma turma) {
//        // TODO implement here
//    }

}