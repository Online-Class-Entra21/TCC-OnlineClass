package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Sala;
import entidade.Turma;
import entidade.TurmaAtividade;

public class TurmaAtividadeDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma TurmaAtividade no banco de dados
	 * @param turmaAtividade
	 * @return
	 */
	public boolean insert(TurmaAtividade turmaAtividade) {
		
		String sql = "insert into turma_Atividade (id_Turma_Atividade, fk_Turma, fk_Atividade) values (?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setInt(1, turmaAtividade.getIdTurmaAtividade());
			comandoSql.setInt(2, turmaAtividade.getTurma().getIdTurma());
			comandoSql.setInt(3, turmaAtividade.getAtividade().getIdAtividade());
			
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
	 * Realiza a exclusão dos dados de uma linha da tabela TurmaAtividade
	 * @param idTurmaAtividade
	 * @return
	 */
	public boolean delete(int idTurmaAtividade) {
		
		String sql = "delete from turma_Atividade where id_Turma_Atividade = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurmaAtividade);
			
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
	 * da tabela TurmaAtividade do banco de dados
	 * @param idTurmaAtividade
	 * @return
	 */
	public TurmaAtividade buscarPorId(int idTurmaAtividade) {
		TurmaAtividade turmaAtividade = new TurmaAtividade(); 
		
		String sql = "select * from turma_Atividade where id_Turma_Atividade = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurmaAtividade);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				turmaAtividade.setIdTurmaAtividade(resultSet.getInt(1));
				
				/**
				 * Realiza a consulta por id para criar o objeto turma
				 * apartir do fk da turma
				 */
//				TurmaDAO turmaDao = new TurmaDAO();
//				Turma turma = turmaDao.buscarPorId((resultSet.getInt(2)));
//				turmaAtividade.setTurma(turma);
				
				/**
				 * Realiza a consulta por id para criar o objeto atividade
				 * apartir do fk da atividade
				 */
//				AtividadeDAO atividade = new AtividadeDAO();
//				Atividade atividade = atividadeDao.buscarPoId((resultSet.getInt(3)));
//				turmaAtividade.setAtividade(atividade);
				
				comandoSql.close(); 
				return turmaAtividade;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela TurmaAtividade do banco de dados 
	 * @return
	 */
	public List<TurmaAtividade> buscarTodos() {
		
		List<TurmaAtividade> lista = new ArrayList<TurmaAtividade>(); 
		
		String sql = "select * from turma_Atividade"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				TurmaAtividade turmaAtividade = new TurmaAtividade(); 
				turmaAtividade.setIdTurmaAtividade(resultSet.getInt(1));
				
				/**
				 * Realiza a consulta por id para criar o objeto turma
				 * apartir do fk da turma
				 */
//				TurmaDAO turmaDao = new TurmaDAO();
//				Turma turma = turmaDao.buscarPorId((resultSet.getInt(2)));
//				turmaAtividade.setTurma(turma);
				
				/**
				 * Realiza a consulta por id para criar o objeto atividade
				 * apartir do fk da atividade
				 */
//				AtividadeDAO atividade = new AtividadeDAO();
//				Atividade atividade = atividadeDao.buscarPoId((resultSet.getInt(3)));
//				turmaAtividade.setAtividade(atividade);
				
 				lista.add(turmaAtividade); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
