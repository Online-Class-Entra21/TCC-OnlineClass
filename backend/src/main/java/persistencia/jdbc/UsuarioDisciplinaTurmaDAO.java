package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.TurmaUsuarioDisciplina;

public class UsuarioDisciplinaTurmaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma TurmaUsuarioDisciplina no banco de dados
	 * @param turmaUsuarioDisciplina
	 * @return
	 * @author Breno
	 */
	public boolean insert(TurmaUsuarioDisciplina turmaUsuarioDisciplina) {
		
		String sql = "insert into usuario_Disciplina_Turma (fk_usuario_Disciplina, fk_Turma) values (?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, turmaUsuarioDisciplina.getFk_usuariorDisciplina());
			comandoSql.setInt(2, turmaUsuarioDisciplina.getFk_turma());
			
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
	 * Realiza a exclusao dos dados de uma linha da tabela TurmaUsuarioDisciplina
	 * @param idTurmaUsuarioDisciplina
	 * @return
	 * @author Breno
	 */
	public boolean deleteId(int idTurmaUsuarioDisciplina) {
		
		String sql = "delete from usuario_Disciplina_Turma where idUsuario_Disciplina_Turma = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurmaUsuarioDisciplina);
			
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
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela TurmaUsuarioDisciplina do banco de dados
	 * @param idSalaPersonalizada
	 * @return
	 * @author Breno
	 */
	public TurmaUsuarioDisciplina buscarId(int idTurmaUsuarioDisciplina) {
		TurmaUsuarioDisciplina turmaUsuarioDisciplina = new TurmaUsuarioDisciplina(); 
		
		String sql = "select * from sala where idSala = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurmaUsuarioDisciplina);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				turmaUsuarioDisciplina.setIdTurmaUsuarioDisciplina(resultSet.getInt(1));
				turmaUsuarioDisciplina.setFk_usuariorDisciplina(resultSet.getInt(2));
				turmaUsuarioDisciplina.setFk_turma(resultSet.getInt(3));
				
				comandoSql.close(); 
				return turmaUsuarioDisciplina;
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
	 * @author Breno
	 */
	public List<TurmaUsuarioDisciplina> buscarTodos() {
		
		List<TurmaUsuarioDisciplina> lista = new ArrayList<TurmaUsuarioDisciplina>(); 
		
		String sql = "select * from usuario_Disciplina_Turma"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				TurmaUsuarioDisciplina turmaUsuarioDisciplina = new TurmaUsuarioDisciplina(); 
				turmaUsuarioDisciplina.setIdTurmaUsuarioDisciplina(resultSet.getInt(1));
				turmaUsuarioDisciplina.setFk_usuariorDisciplina(resultSet.getInt(2));
				turmaUsuarioDisciplina.setFk_turma(resultSet.getInt(3));
				lista.add(turmaUsuarioDisciplina); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
