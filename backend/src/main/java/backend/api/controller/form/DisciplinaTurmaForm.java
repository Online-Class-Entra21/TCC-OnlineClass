package backend.api.controller.form;

public class DisciplinaTurmaForm {
	private int idUsuario_disciplina_turma;
	private int idTurma;
	private int idDisciplina;
	
	public DisciplinaTurmaForm() {
	}
	
	
	
	public DisciplinaTurmaForm(int idUsuario_disciplina_turma,int idTurma,int idDisciplina) {
		this.idUsuario_disciplina_turma = idUsuario_disciplina_turma;
		this.idTurma = idTurma;
		this.idTurma = idDisciplina;
	}

	
	
	public int getIdUsuario_disciplina_turma() {
		return idUsuario_disciplina_turma;
	}



	public void setIdUsuario_disciplina_turma(int idUsuario_disciplina_turma) {
		this.idUsuario_disciplina_turma = idUsuario_disciplina_turma;
	}



	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	
	
	
	
}
