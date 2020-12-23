package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidade.Sala;
import entidade.TurmaProfessorDisciplina;

public class TurmaProfessorDisciplinaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma TurmaProfessorDisciplina no banco de dados
	 * @param turmaProfessorDisciplina
	 * @return
	 */
	public boolean insert(TurmaProfessorDisciplina turmaProfessorDisciplina) {
		
		String sql = "insert into usuario_Disciplina_Turma (fk_usuario_Disciplina, fk_Turma) values (?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, turmaProfessorDisciplina.getProfessorDisciplina().getIdProfessorDisciplina());
			comandoSql.setInt(2, turmaProfessorDisciplina.getTurma().getIdTurma());
			
			comandoSql.execute(); 
			
			comandoSql.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		return true; 
	}
	
	
}
