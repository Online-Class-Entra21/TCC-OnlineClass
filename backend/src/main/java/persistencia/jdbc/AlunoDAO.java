package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;

/**
 * Metodo para consulta do aluno no banco de dados 
 * @author Andrey
 *
 */
public class AlunoDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir um aluno no banco de dados
	 * 	 
	 * @param Aluno aluno
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey 
	 */
	public boolean insert(Aluno aluno) {
		
		String sql = "insert into aluno (ra, matricula, deficiencia, nomemae, nomepai, nomeresponsavel, "
				   + "situacaoanoletivo, fk_usuario, fk_turma) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, aluno.getRa());
			comandoSql.setInt(2, aluno.getMatricula());
			comandoSql.setBoolean(3, aluno.getDeficiencia());
			comandoSql.setString(4, aluno.getNomeMae());
			comandoSql.setString(5, aluno.getNomePai());
			comandoSql.setString(6, aluno.getNomeResponsavel());
			comandoSql.setBoolean(7, aluno.getSituacaoAnoLetivo());
			comandoSql.setInt(8, aluno.getFk_usuario());
			comandoSql.setInt(9, aluno.getFk_turma());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;	
	}
	
	/**
	 * Metodo para Atualizar aluno no banco de dados
	 * 
	 * Nota: o idAluno do Aluno deve ser o id que deseja atualizar no banco 
	 * 
	 * @param Aluno aluno
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	
	public boolean update(Aluno aluno) {
		String sql = "update aluno set ra = ?, matricula = ?, deficiencia = ?, nomemae = ?, nomepai = ?, nomeresponsavel = ?,"
				+ "situacaoanoletivo = ?, fk_usuario = ?, fk_turma = ? where idaluno = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, aluno.getRa());
			comandoSql.setInt(2, aluno.getMatricula());
			comandoSql.setBoolean(3, aluno.getDeficiencia());
			comandoSql.setString(4, aluno.getNomeMae());
			comandoSql.setString(5, aluno.getNomePai());
			comandoSql.setString(6, aluno.getNomeResponsavel());
			comandoSql.setBoolean(7, aluno.getSituacaoAnoLetivo());
			comandoSql.setInt(8, aluno.getFk_usuario());
			comandoSql.setInt(9, aluno.getFk_turma());
			comandoSql.setInt(10, aluno.getFk_usuario());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Deleta o aluno do respectivo id do banco de dados
	 * 
	 * @param int idAluno
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean deleteId(int idAluno) {
		String sql = "delete from aluno where idaluno = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idAluno);
			
			comandoSql.execute();
			comandoSql.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo para selecionar o aluno do banco de dados apartir do respectivo id
	 * 
	 * @param <code>idAluno</code> id do aluno que deseja selecionar
	 * @return Aluno referente ao id de entrada
	 * @author Andrey
	 */
	public Aluno buscarId(int idAluno) {
		Aluno aluno = new Aluno();
		
		String sql = "select * from aluno where idaluno = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idAluno);
			
			ResultSet resultSet = comandoSql.executeQuery();
			if (resultSet.next()) {
				aluno.setIdAluno(resultSet.getInt(1));
				aluno.setRa(resultSet.getInt(2));
				aluno.setMatricula(resultSet.getInt(3));
				aluno.setDeficiencia(resultSet.getBoolean(4));
				aluno.setNomeMae(resultSet.getString(5));
				aluno.setNomePai(resultSet.getString(6));
				aluno.setNomeResponsavel(resultSet.getString(7));
				aluno.setSituacaoAnoLetivo(resultSet.getBoolean(8));
				aluno.setFk_usuario(resultSet.getInt(9));						
				aluno.setFk_turma(resultSet.getInt(10));
			}
			comandoSql.close();
			return aluno;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos os alunos cadastrados
	 *  
	 * @return lista de objetos Aluno com todos os alunos do banco de dados
	 * @author Andrey
	 */
	public List<Aluno> buscarTodos() {
		Aluno aluno = new Aluno();
		List<Aluno> lista =  new ArrayList<Aluno>();
		
		String sql = "select * from aluno";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			while (resultSet.next()) {
				aluno.setIdAluno(resultSet.getInt(1));
				aluno.setRa(resultSet.getInt(2));
				aluno.setMatricula(resultSet.getInt(3));
				aluno.setDeficiencia(resultSet.getBoolean(4));
				aluno.setNomeMae(resultSet.getString(5));
				aluno.setNomePai(resultSet.getString(6));
				aluno.setNomeResponsavel(resultSet.getString(7));
				aluno.setSituacaoAnoLetivo(resultSet.getBoolean(8));
				aluno.setFk_usuario(resultSet.getInt(9));
				aluno.setFk_turma(resultSet.getInt(10));
				
			lista.add(aluno);
			}
			comandoSql.close();
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
