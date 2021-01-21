package entidade;

import java.sql.Time;

import persistencia.jdbc.AlunoDAO;
import persistencia.jdbc.DisciplinaDAO;
import persistencia.jdbc.ProfessorDAO;
import persistencia.jdbc.TurmaDAO;

/**
 * Classe contendo mwtodos e atributos para o coordenador.
 * Herda metodos e atributos da classe Usuario
 * @see Usuario
 * @author André 
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

    /**
     * Metodo para retorno da turma
     * @param int idTurma
     * @return Turma turma 
     */
    public Turma getTurma(int idTurma) {
    	TurmaDAO turmaDao = new TurmaDAO();
        Turma turma = turmaDao.buscarId(idTurma);
        return turma;
    }

    /** 
     * Metodo para adicionar uma turma
     * @param Turma turma 
     */
    public void adicionarTurma(Turma turma) {
        TurmaDAO turmaDao = new TurmaDAO();
        turmaDao.insert(turma);
    }

    /** 
     * Metodo para atualizar uma turma
     * @param Turma turma
     */
    public void atualizarTurma(Turma turma) {
        TurmaDAO turmaDao = new TurmaDAO();
        turmaDao.update(turma);
    }

    /** 
     * Metodo para a remocao de uma turma
     * @param int idTurma
     */
    public void removerTurma(int idTurma) {
        TurmaDAO turmaDao = new TurmaDAO();
        turmaDao.delete(idTurma);
    }

    /**
     * Metodo para retorno da disciplina
     * @param int idDisciplina
     * @return Disciplina disciplina 
     */
    public Disciplina getDisciplina(int idDisciplina) {
    	DisciplinaDAO disciplinaDao = new DisciplinaDAO();
    	Disciplina disciplina = disciplinaDao.buscarId(idDisciplina);
    	return disciplina;
    }

    /** 
     * Metodo para adicionar uma disciplina
     * @param Disciplina disciplina 
     */
    public void adicionarDisciplina(Disciplina disciplina) {
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        disciplinaDao.insert(disciplina);
    }
    
    /** 
     * Metodo para atualizar uma disciplina
     * @param Disciplina disciplina
     */
    public void atualizarDisciplina(Disciplina disciplina) {
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        disciplinaDao.update(disciplina);
    }

    /** 
     * Metodo para a remocao de uma disciplina
     * @param int idDisciplina 
     */
    public void removerDisciplina(int idDisciplina) {
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        disciplinaDao.delete(idDisciplina);
    }

    /**
     * Metodo para retorno do aluno
     * @param int idAluno
     * @return Aluno aluno 
     */
    public Aluno getAluno(int idAluno) {
    	AlunoDAO alunoDao = new AlunoDAO();
        Aluno aluno =  alunoDao.buscarId(idAluno);
        return aluno;	
    }
    
    /**
     * Metodo para insercao do aluno 
     * @param Aluno aluno
     */
    public void adicionarAluno(Aluno aluno) {
    	AlunoDAO alunoDao = new AlunoDAO();
    	alunoDao.insert(aluno);
    }

    /** 
     * Metodo para atualizar um aluno
     * @param Aluno aluno
     */
    public void atualizarAluno(Aluno aluno) {
    	AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.update(aluno);
    }

    /** 
     * Metodo para a remocao de um aluno
     * @param int idAluno
     */
    public void removerAluno(int idAluno) {
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.delete(idAluno);
    }

    /** M�todo para retorno do ID do ProfessorDisciplina.
     * @return Int - ID ProfessorDisciplina
     */
    public int getProfessorDisciplina() {
        ProfessorDisciplina profDisci = new ProfessorDisciplina();
        return profDisci.getIdProfessorDisciplina();
    }

    /** M�todo para a atribui��o de um professor � uma disciplina.
     * @param -
     */
    public void adicionarProfessorDisciplina() {
        // TODO implement here
    }

    /** M�todo para atualizar a liga��o do professor � uma disciplina.
     * @param ProfessorDisciplina
     */
    public void atualizarProfessotDisciplina() {
        // TODO implement here
    }

    /** M�todo para a remo��o de uma liga��o do professor � uma disciplina.
     * @param
     */
    public void removerProfessorDisciplina() {
        // TODO implement here
    }

    /** M�todo para retorno do ID TurmaProfessorDisciplina.
     * @return Int - ID TurmaProfessorDisciplina
     */
    public int getTurmaProfessorDisciplina() {
        TurmaProfessorDisciplina turmaPD = new TurmaProfessorDisciplina();
        return turmaPD.getIdTurmaProfessorDisciplina();
    }

    /** M�todo para adicionar a liga��o entre a turma, professor e disciplina.
     * @param -
     */
    public void adicionarTurmaProfessorDisciplina() {
        // TODO implement here
    }

    /** M�todo para remover a liga��o entre a turma, professor e disciplina.
     * @param TurmaProfessorDisciplinaDAO
     */
    public void removerTurmaProfessorDisciplina(TurmaProfessorDisciplina turmaPD) {
        // TODO implement here
    }

    /** M�todo para retorno do ID da sala padr�o de cada turma.
     * @return Int - ID da sala padr�o
     */
    public int getSalaPadrao() {
        SalaPadrao salaPadrao = new SalaPadrao();
        return salaPadrao.getIdSala();
    }

    /** M�todo para adicionar uma sala padr�o � uma turma.
     * @param Turma - Turma a ser atribuida � sala padr�o.
     */
    public void adicionarSalaPadrao(Turma turma) {
        // TODO implement here
    }

    /** M�todo para atualizar a sala padr�o.
     * @param SalaPadrao - Sala a ser atualizada
     */
    public void atualizarSalaPadrao(SalaPadrao salaP) {
        // TODO implement here
    }

    /** M�todo para a remo��o de uma sala padr�o.
     * @param SalaPadrao - Sala a ser removida.
     * @param Turma - Turma a ter a sala padr�o removida.
     */
    public void removerSalaPadrao(SalaPadrao salaP, Turma turma) {
        // TODO implement here
    }

}