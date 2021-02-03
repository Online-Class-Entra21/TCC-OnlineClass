package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;
import entidade.Turma;

/**
 * Metodo para consulta do aluno no banco de dados 
 * @author Andre
 *
 */
public class AlunoDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir um aluno no banco de dados
	 * @param Aluno aluno
	 * @author Andre
	 * @throws SQLException 
	 */
	public void insert(Aluno aluno) throws SQLException {
		String sql = "insert into aluno (ra, matricula, deficiencia, nomemae, nomepai, nomeresponsavel, "
				   + "situacaoanoletivo, fk_usuario, fk_turma) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
	}
	
	/**
	 * Metodo para Atualizar aluno no banco de dados.
	 * O <code>idAluno</code> deve ser igual ao do aluno que deseja atualizar
	 * @param Aluno aluno
	 * @author Andre
	 * @throws SQLException 
	 */
	
	public void update(Aluno aluno) throws SQLException {
		String sql = "update aluno set ra = ?, matricula = ?, deficiencia = ?, nomemae = ?, nomepai = ?, nomeresponsavel = ?,"
				+ "situacaoanoletivo = ?, fk_usuario = ?, fk_turma = ? where idaluno = ?";
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
		comandoSql.setInt(10, aluno.getIdAluno());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Deleta o aluno do respectivo id do banco de dados.
	 * O <code>idAluno</code> deve ser igual ao do aluno que deseja deletar
	 * @param int idAluno
	 * @author Andre
	 * @throws SQLException 
	 */
	public void deleteId(int idAluno) throws SQLException {
		String sql = "delete from aluno where idaluno = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idAluno);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar o aluno do banco de dados apartir do respectivo id.
	 * O <code>idAluno</code> deve ser igual ao do aluno que deseja buscar
	 * @param int idAluno
	 * @return Aluno aluno
	 * @author Andre
	 * @throws SQLException 
	 */
	public Aluno buscarId(int idAluno) throws SQLException {
		Aluno aluno = new Aluno();
		String sql = "select * from aluno where idaluno = ?";
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
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos os alunos cadastrados
	 * @author Andre
	 * @return lista de alunos registrados no banco 
	 * @throws SQLException
	 */
	public List<Aluno> buscarTodos() throws SQLException {
		List<Aluno> lista =  new ArrayList<Aluno>();
		String sql = "select * from aluno";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Aluno aluno = new Aluno();
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
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo para retorno da quantidade de alunos no banco de dados
	 * @return int qtdAlunos
	 * @author Breno
	 * @throws SQLException
	 */
	public int buscarQuantidadeAlunos() throws SQLException {
		int qtdAlunos = 0;
		String sql = "select count(idUsuario) from usuario where tipoUsuario = 5";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			qtdAlunos = (resultSet.getInt(1));
		}
		comandoSql.close();
		return qtdAlunos;
	}
	/**
	 * Metodo para selecionar o aluno do banco de dados apartir do id do usuario.
	 * O <code>fk_Usuario</code> deve ser igual ao do aluno que deseja buscar
	 * @param int fk_Usuario
	 * @return Aluno aluno
	 * @author Andre
	 * @throws SQLException 
	 */
	public Aluno buscarIdUsuario(int fk_Usuario) throws SQLException {
		Aluno aluno = new Aluno();
		String sql = "select * from aluno where fk_usuario = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, fk_Usuario);
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
	}
	
	/**
	 * Metodo para selecionar do banco de dados todos os alunos cadastrados
	 * @author Andre
	 * @return lista de alunos registrados no banco 
	 * @throws SQLException
	 */
	public List<Aluno> buscarTodosIdSala(int idSala) throws SQLException {
		List<Aluno> lista = new ArrayList<Aluno>();
		TurmaDAO turmaDao = new TurmaDAO();
		Turma turma = turmaDao.buscarIdSala(idSala);
		String sql = "select * from aluno where fk_turma = ?";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, turma.getIdTurma());
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Aluno aluno = new Aluno();
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
	}
	
}
