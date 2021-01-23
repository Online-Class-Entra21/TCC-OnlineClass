package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.TurmaUsuarioDisciplina;
import entidade.UsuarioDisciplina;

public class UsuarioDisciplinaTurmaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma turmaUsuarioDisciplina no banco de dados
	 * @param TurmaUsuarioDisciplina turmaUsuarioDisciplina
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(TurmaUsuarioDisciplina turmaUsuarioDisciplina) throws SQLException {
		String sql = "insert into usuario_Disciplina_Turma (fk_usuario_Disciplina, fk_Turma) values (?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
		comandoSql.setInt(1, turmaUsuarioDisciplina.getFk_usuariorDisciplina());
		comandoSql.setInt(2, turmaUsuarioDisciplina.getFk_turma());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Metodo para atualizar uma turmaUsuarioDisciplina no banco de dados.
	 * O <code>idTurmaUsuarioDisciplina</code> deve ser igual ao da turmaUsuarioDisciplina que deseja atualizar
	 * @param TurmaUsuarioDisciplina turmaUsuarioDisciplina 
	 * @author Breno
	 * @throws SQLException 
	 */ 
	public void update(TurmaUsuarioDisciplina turmaUsuarioDisciplina) throws SQLException {
		String sql = "update usuario_Disciplina_Turma set fk_usuario = ?, fk_disciplina = ? where id_usuario_Disciplina_Turma = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, turmaUsuarioDisciplina.getFk_usuariorDisciplina());
		comandoSql.setInt(2, turmaUsuarioDisciplina.getFk_turma());
		comandoSql.setInt(3, turmaUsuarioDisciplina.getIdTurmaUsuarioDisciplina());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Realiza a exclusao dos dados de uma linha da tabela turmaUsuarioDisciplina.
	 *  O <code>idTurmaUsuarioDisciplina</code> deve ser igual ao da turmaUsuarioDisciplina que deseja deletar
	 * @param int idTurmaUsuarioDisciplina
	 * @author Breno
	 * @throws SQLException 
	 */
	public void deleteId(int idTurmaUsuarioDisciplina) throws SQLException {
		String sql = "delete from usuario_Disciplina_Turma where idUsuario_Disciplina_Turma = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idTurmaUsuarioDisciplina);
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela TurmaUsuarioDisciplina do banco de dados.
	 *  O <code>idTurmaUsuarioDisciplina</code> deve ser igual ao da turmaUsuarioDisciplina que deseja buscar
	 * @param int idSalaPersonalizada
	 * @author Breno
	 * @throws SQLException 
	 */
	public TurmaUsuarioDisciplina buscarId(int idTurmaUsuarioDisciplina) throws SQLException {
		TurmaUsuarioDisciplina turmaUsuarioDisciplina = new TurmaUsuarioDisciplina(); 
		String sql = "select * from sala where idSala = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idTurmaUsuarioDisciplina);
		ResultSet resultSet = comandoSql.executeQuery();
			
		if (resultSet.next()) {
			turmaUsuarioDisciplina.setIdTurmaUsuarioDisciplina(resultSet.getInt(1));
			turmaUsuarioDisciplina.setFk_usuariorDisciplina(resultSet.getInt(2));
			turmaUsuarioDisciplina.setFk_turma(resultSet.getInt(3));
		}
		comandoSql.close(); 
		return turmaUsuarioDisciplina;
	}
	
	/**
	 * Retorna todos os dados listados da tabela Sala do banco de dados 
	 * @return lista de turmasUsuariosDisciplinas registradas no banco
	 * @author Breno
	 * @throws SQLException 
	 */
	public List<TurmaUsuarioDisciplina> buscarTodos() throws SQLException {
		List<TurmaUsuarioDisciplina> lista = new ArrayList<TurmaUsuarioDisciplina>(); 
		String sql = "select * from usuario_Disciplina_Turma"; 
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			TurmaUsuarioDisciplina turmaUsuarioDisciplina = new TurmaUsuarioDisciplina(); 
			turmaUsuarioDisciplina.setIdTurmaUsuarioDisciplina(resultSet.getInt(1));
			turmaUsuarioDisciplina.setFk_usuariorDisciplina(resultSet.getInt(2));
			turmaUsuarioDisciplina.setFk_turma(resultSet.getInt(3));
			
			lista.add(turmaUsuarioDisciplina); 
		}
		comandoSql.close(); 
		return lista;
	}	
}
