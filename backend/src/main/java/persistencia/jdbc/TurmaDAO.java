package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Turma;

public class TurmaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma Turma no banco de dados
	 * @param turma
	 * @return
	 * @author Breno
	 */
	public boolean insert(Turma turma) {
		
		String sql = "insert into turma (ano, qtdAluno, horaInicioAula, horaFinalAula, fk_sala) values (?,?,?,?,?)"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
			comandoSql.setString(1, turma.getAno());
			comandoSql.setInt(2, turma.getQtdAluno());
			comandoSql.setTime(3, turma.getHorarioInicioAula());
			comandoSql.setTime(4, turma.getHorarioFinalAula());
			comandoSql.setInt(5, turma.getFk_sala());
			
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
	 * Realiza atualizacao dos dados da Turma no banco de dados
	 * @param turma
	 * @return
	 * @author Breno
	 */
	public boolean update(Turma turma) {
		
		String sql = "Update turma set ano = ?, qtdAluno = ?, horaInicioAula = ?, "
				   + "horaFinalAula = ?, fk_sala = ? where idTurma = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
		    
			comandoSql.setString(1, turma.getAno());
			comandoSql.setInt(2, turma.getQtdAluno());
			comandoSql.setTime(3, turma.getHorarioInicioAula());
			comandoSql.setTime(4, turma.getHorarioFinalAula());
			comandoSql.setInt(5, turma.getFk_sala());
			comandoSql.setInt(6, turma.getIdTurma());

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
	 * Realiza a exclusao dos dados de uma linha da tabela Turma
	 * @param idTurma
	 * @return
	 * @author Breno
	 */
	public boolean deleteId(int idTurma) {
		
		String sql = "delete from turma where idTurma = ?"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurma);
			
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
	 * da tabela Turma do banco de dados
	 * @param idTurma
	 * @return
	 * @author Breno
	 */
	public Turma buscarId(int idTurma) {
		Turma turma = new Turma(); 
		
		String sql = "select * from turma where idTurma = ?"; 
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			comandoSql.setInt(1, idTurma);
			
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				turma.setIdTurma(resultSet.getInt(1));
				turma.setAno(resultSet.getString(2));
				turma.setQtdAluno(resultSet.getInt(3));
				turma.setHorarioInicioAula(resultSet.getTime(4));
				turma.setHorarioFinalAula(resultSet.getTime(5));
				turma.setFk_sala(resultSet.getInt(6));
				comandoSql.close(); 
				return turma;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null; 
	}
	
	/**
	 * Retorna todos os dados listados da tabela Turma do banco de dados 
	 * @return
	 * @author Breno
	 */
	public List<Turma> buscarTodos() {
		
		List<Turma> lista = new ArrayList<Turma>(); 
		
		String sql = "select * from turma"; 
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close(); 
			
			while (resultSet.next()) {
				Turma turma = new Turma(); 
				turma.setIdTurma(resultSet.getInt(1));
				turma.setAno(resultSet.getString(2));
				turma.setQtdAluno(resultSet.getInt(3));
				turma.setHorarioInicioAula(resultSet.getTime(4));
				turma.setHorarioFinalAula(resultSet.getTime(5));
				turma.setFk_sala(resultSet.getInt(6));
				lista.add(turma); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}	
}
