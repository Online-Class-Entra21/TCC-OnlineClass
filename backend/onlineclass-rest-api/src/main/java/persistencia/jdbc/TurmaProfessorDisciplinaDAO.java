package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.ProfessorDisciplina;
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
	
	/**
	 * Realiza a exclusão dos dados de uma linha da tabela TurmaProfessorDisciplina
	 * @param idTurmaProfessorDisciplina
	 * @return
	 */
	public boolean delete(int idTurmaProfessorDisciplina) {
		
		String sql = "delete from usuario_Disciplina_Turma where idUsuario_Disciplina_Turma = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurmaProfessorDisciplina);
			
			comandoSql.execute(); 
			
			comandoSql.close(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		return true; 
	}
	
	/**
	 * Método de busca de todas as informações de uma linha
	 * da tabela TurmaProfessorDisciplina do banco de dados
	 * @param idSalaPersonalizada
	 * @return
	 */
	public TurmaProfessorDisciplina buscarPorId(int idTurmaProfessorDisciplina) {
		TurmaProfessorDisciplina turmaProfessorDisciplina = new TurmaProfessorDisciplina(); 
		
		String sql = "select * from sala where idSala = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurmaProfessorDisciplina);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				turmaProfessorDisciplina.setIdTurmaProfessorDisciplina(resultSet.getInt(1));

				/**
				 * Realiza a consulta por id para criar o objeto ProfessorDisciplina
				 * apartir do fk da professorDisciplina
				 */
//				ProfessorDisciplinaDAO professorDisciplinaDao = new ProfessorDisciplinaDAO();
//				ProfessorDisciplina professorDisciplina = professorDisciplinaDao.buscarPorId((resultSet.getString(2)));
//				turmaProfessorDisciplina.setProfessorDisciplina(professorDisciplina);

				/**
				 * Realiza a consulta por id para criar o objeto Turma
				 * apartir do fk da turma
				 */
//				TurmaDAO turmaDAO = new TurmaDAO();
//				Turma turma = turmaDAO.buscarPorId((resultSet.getString(3)));
//				turmaProfessorDisciplina.setTurma(turma);
				
				comandoSql.close(); 
				return turmaProfessorDisciplina;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela Sala do banco de dados 
	 * @return
	 */
	public List<TurmaProfessorDisciplina> buscarTodos() {
		
		List<TurmaProfessorDisciplina> lista = new ArrayList<TurmaProfessorDisciplina>(); 
		
		String sql = "select * from usuario_Disciplina_Turma"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				TurmaProfessorDisciplina turmaProfessorDisciplina = new TurmaProfessorDisciplina(); 
				turmaProfessorDisciplina.setIdTurmaProfessorDisciplina(resultSet.getInt(1));

				/**
				 * Realiza a consulta por id para criar o objeto ProfessorDisciplina
				 * apartir do fk da professorDisciplina
				 */
//				ProfessorDisciplinaDAO professorDisciplinaDao = new ProfessorDisciplinaDAO();
//				ProfessorDisciplina professorDisciplina = professorDisciplinaDao.buscarPorId((resultSet.getString(2)));
//				turmaProfessorDisciplina.setProfessorDisciplina(professorDisciplina);

				/**
				 * Realiza a consulta por id para criar o objeto Turma
				 * apartir do fk da turma
				 */
//				TurmaDAO turmaDAO = new TurmaDAO();
//				Turma turma = turmaDAO.buscarPorId((resultSet.getString(3)));
//				turmaProfessorDisciplina.setTurma(turma);
				lista.add(turmaProfessorDisciplina); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
