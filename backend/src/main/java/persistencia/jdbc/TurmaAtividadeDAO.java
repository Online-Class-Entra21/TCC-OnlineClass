package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.TurmaAtividade;

/**
 * Metodo para consulta da turmaAtividade no banco de dados 
 * @author Breno
 *
 */
public class TurmaAtividadeDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma turmaAtividade no banco de dados
	 * @param TurmaAtividade turmaAtividade
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(TurmaAtividade turmaAtividade) throws SQLException {
		String sql = "insert into turma_Atividade (fk_Turma, fk_Atividade) values (?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
	     
		comandoSql.setInt(1, turmaAtividade.getFk_turma());
		comandoSql.setInt(2, turmaAtividade.getFk_atividade());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza atualizacao dos dados da turmaAtividade no banco de dados.
	 * O <code>idTurmaAtividade</code> deve ser igual ao da turmaAtividade que deseja atualizar
	 * @param TurmaAtividade turmaAtividade
	 * @author Breno
	 * @throws SQLException 
	 */
	public void update(TurmaAtividade turmaAtividade) throws SQLException {
		String sql = "Update turmaAtividade set fk_Turma, fk_Atividade ? where idTurmaAtividade = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
	    
		comandoSql.setInt(1, turmaAtividade.getFk_turma());
		comandoSql.setInt(2, turmaAtividade.getFk_atividade());
		comandoSql.setInt(3, turmaAtividade.getIdTurmaAtividade());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza a exclusao dos dados de uma linha da tabela turmaAtividade.
	 * O <code>idSala</code> deve ser igual ao da sala que deseja deletar
	 * @param int idTurmaAtividade
	 * @author Breno
	 * @throws SQLException 
	 */
	public void deleteId(int idTurmaAtividade) throws SQLException {
		String sql = "delete from turma_Atividade where id_Turma_Atividade = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idTurmaAtividade);
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela TurmaAtividade do banco de dados.
	 * O <code>idSala</code> deve ser igual ao da sala que deseja buscar
	 * @param idTurmaAtividade
	 * @return TurmaAtividade turmaAtividade
	 * @author Breno
	 * @throws SQLException 
	 */
	public TurmaAtividade buscarId(int idTurmaAtividade) throws SQLException {
		TurmaAtividade turmaAtividade = new TurmaAtividade(); 
		String sql = "select * from turma_Atividade where id_Turma_Atividade = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idTurmaAtividade);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			turmaAtividade.setIdTurmaAtividade(resultSet.getInt(1));
			turmaAtividade.setFk_turma(resultSet.getInt(2));
			turmaAtividade.setFk_atividade(resultSet.getInt(3));
		}
		comandoSql.close(); 
		return turmaAtividade;
	}
	
	/**
	 * Retorna todos os dados listados da tabela TurmaAtividade do banco de dados
	 * @return lista de TurmasAtividades registradas no banco
	 * @author Breno 
	 * @throws SQLException 
	 */
	public List<TurmaAtividade> buscarTodos() throws SQLException {
		List<TurmaAtividade> lista = new ArrayList<TurmaAtividade>(); 
		String sql = "select * from turma_Atividade"; 
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) { 
			TurmaAtividade turmaAtividade = new TurmaAtividade();
			turmaAtividade.setIdTurmaAtividade(resultSet.getInt(1));
			turmaAtividade.setFk_turma(resultSet.getInt(2));
			turmaAtividade.setFk_atividade(resultSet.getInt(3));
			
			lista.add(turmaAtividade); 
		}
		comandoSql.close();
		return lista;
	}	
}
