package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;
import entidade.Turma;
import entidade.Usuario;

public class AlunoDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insertTabelaAluno(Aluno aluno, Turma turma) {
		
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
			comandoSql.setInt(8, aluno.getIdUsuario());
			comandoSql.setInt(9, turma.getIdTurma());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;	
	}
	public boolean insertTabelaUsuario(Aluno aluno) {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			aluno.setTipoUsuario(0);
			usuarioDAO.insert(aluno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	public boolean update(Aluno aluno, Turma turma) {
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
			comandoSql.setInt(8, aluno.getIdUsuario());
			comandoSql.setInt(9, turma.getIdTurma());
			comandoSql.setInt(10, aluno.getIdAluno());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	public boolean delete(int idAluno) {
		String sql = "delete from aluno where idaluno = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idAluno);
			
			comandoSql.execute();
			comandoSql.close();
		
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	public boolean deleteTabelaUsuario(int idUsuario) {
		String sql = "delete from usuario where idUsuario = ? and tipoUsuario = 0";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idUsuario);
			
			comandoSql.execute();
			comandoSql.close();
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
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
				
				/**
				 * Realiza a consulta por id para criar o objeto usuario
				 * apartir do fk do usuario
				 */
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarId(resultSet.getInt(9));
				aluno.setIdUsuario(usuario.getIdUsuario());
			
				/**
				 * Realiza a consulta por id para criar o objeto turma
				 * apartir do fk da turma
				 */
				TurmaDAO turmaDAO = new TurmaDAO();
				Turma turma = turmaDAO.buscarPorId(resultSet.getInt(10));
				aluno.setTurma(turma);
			}
			comandoSql.close();
			return aluno;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
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
				
				/**
				 * Realiza a consulta por id para criar o objeto usuario
				 * apartir do fk do usuario
				 */
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarId(resultSet.getInt(9));
				aluno.setIdUsuario(usuario.getIdUsuario());
			
				/**
				 * Realiza a consulta por id para criar o objeto turma
				 * apartir do fk da turma
				 */
				TurmaDAO turmaDAO = new TurmaDAO();
				Turma turma = turmaDAO.buscarPorId(resultSet.getInt(10));
				aluno.setTurma(turma);
				
			lista.add(aluno);
			}
			comandoSql.close();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
}
