package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Disciplina;
import entidade.Professor;
import entidade.UsuarioDisciplina;


public class ProfessorDisciplinaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(UsuarioDisciplina professorDisciplina) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("insert into usuario_disciplina (fk_usuario, fk_disciplina) values (?,?)");
			
			comandoSql.setInt(1, professorDisciplina.getProfessor().getIdProfessor());
			comandoSql.setInt(2, professorDisciplina.getDisciplina().getIdDisciplina());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean update(UsuarioDisciplina professorDisciplina) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("update professordisciplina set fk_usuario = ?, fk_disciplina = ? where id_usuario_disciplina = ?");
			
			comandoSql.setInt(1, professorDisciplina.getProfessor().getIdProfessor());
			comandoSql.setInt(2, professorDisciplina.getDisciplina().getIdDisciplina());
			comandoSql.setInt(3, professorDisciplina.getIdProfessorDisciplina());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteID(int id) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("delete from usuario_disciplina where id_usuario_disciplina = ?");
			
			comandoSql.setInt(1, id);
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public UsuarioDisciplina buscarId(int id) {
		UsuarioDisciplina professorDisciplina = new UsuarioDisciplina();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from ProfessorDisciplina where id_usuario_disciplina = ?");
			
			comandoSql.setInt(1, id);
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				professorDisciplina.setIdProfessorDisciplina(resultSet.getInt(1));
				Professor prof = new ProfessorDAO().buscarPorId(resultSet.getInt(2));
				professorDisciplina.setProfessor(prof);
				Disciplina disciplina = new DisciplinaDAO().buscarId(resultSet.getInt(3));
				professorDisciplina.setDisciplina(disciplina);
				return professorDisciplina;
			}
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<UsuarioDisciplina> buscarTodos() {
		List<UsuarioDisciplina> lista = new ArrayList<UsuarioDisciplina>();
		
		String sql = "select * from Endereco";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				UsuarioDisciplina professorDisciplina = new UsuarioDisciplina();
				professorDisciplina.setIdProfessorDisciplina(resultSet.getInt(1));
				Professor prof = new ProfessorDAO().buscarPorId(resultSet.getInt(2));
				professorDisciplina.setProfessor(prof);
				Disciplina disciplina = new DisciplinaDAO().buscarId(resultSet.getInt(3));
				professorDisciplina.setDisciplina(disciplina);
				lista.add(professorDisciplina);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	

}
