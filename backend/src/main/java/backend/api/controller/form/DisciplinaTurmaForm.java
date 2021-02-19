package backend.api.controller.form;

public class DisciplinaTurmaForm {

	private int idUsuario_disciplina_turma;
	private int idTurma;
	private int idDisciplina;
	
	/**
	 * Construtor padrao 
	 */
	public DisciplinaTurmaForm() {
	}
	
	/**
	 * Metodo construtor que preenche todos os atributos 
	 * @param idUsuario_disciplina_turma
	 * @param idTurma
	 * @param idDisciplina
	 */
	public DisciplinaTurmaForm(int idUsuario_disciplina_turma,int idTurma,int idDisciplina) {
		setIdUsuario_disciplina_turma(idUsuario_disciplina_turma);;
		setIdTurma(idTurma);
		setIdDisciplina(idDisciplina);
	}

	/**
	 * Meto para retorno do idUsuario_disciplina_turma
	 * @return int idUsuario_disciplina_turma
	 */
	public int getIdUsuario_disciplina_turma() {
		return idUsuario_disciplina_turma;
	}

	/**
	 * Metodo para insercao do idUsuario_disciplina_turma
	 * @param int idUsuario_disciplina_turma
	 */
	public void setIdUsuario_disciplina_turma(int idUsuario_disciplina_turma) {
		this.idUsuario_disciplina_turma = idUsuario_disciplina_turma;
	}

	/**
	 * Metodo para retorno do idTurma
	 * @retun int idTurma
	 */
	public int getIdTurma() {
		return idTurma;
	}

	/**
	 * Metodo para insercao do idTurma
	 * @param int idTurma
	 */
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	/**
	 * Metodo para retorno do idDisciplina
	 * @return int idDisciplina
	 */
	public int getIdDisciplina() {
		return idDisciplina;
	}

	/**
	 * Metodo para insercao do idDisciplina 
	 * @param int idDisciplina
	 */
	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
}
