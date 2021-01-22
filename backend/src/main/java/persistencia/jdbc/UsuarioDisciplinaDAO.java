package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.UsuarioDisciplina;


public class UsuarioDisciplinaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir ProfessorDisciplina no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>UsuarioDisciplina</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */
	public boolean insert(UsuarioDisciplina professorDisciplina) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("insert into usuario_disciplina (fk_usuario, fk_disciplina) values (?,?)");
			
			comandoSql.setInt(1, professorDisciplina.getFk_usuario());
			comandoSql.setInt(2, professorDisciplina.getFk_disciplina());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Metodo para atualizar uma UsuarioDisciplina no banco de dados.
	 * 
	 * O id da <code>UsuarioDisciplina</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param <code>UsuarioDisciplina</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */ 
	public boolean update(UsuarioDisciplina professorDisciplina) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("update professordisciplina set fk_usuario = ?, fk_disciplina = ? where id_usuario_disciplina = ?");
			
			comandoSql.setInt(1, professorDisciplina.getFk_usuario());
			comandoSql.setInt(2, professorDisciplina.getFk_disciplina());
			comandoSql.setInt(3, professorDisciplina.getIdUsuarioDisciplina());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma UsuarioDisciplina
	 *  <p>
	 *  O <code>idDisciplina</code> deve ser igual ao id do banco de dados
	 * 
	 * @param <code>UsuarioDisciplina</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */	
	public boolean deleteId(int id) {
		
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
	
	/**
	 * Metodo para selecionar <code>UsuarioDisciplina</code> no banco de dados
	 * <p>
	 * O <code>idDisciplina</code> deve ser igual a UsuarioDisciplina que deseja selecionar
	 * 
	 * @param <code>idDisciplina<code>
	 * @return UsuarioDisciplina
	 * @author Andre
	 */	
	public UsuarioDisciplina buscarId(int id) {
		UsuarioDisciplina professorDisciplina = new UsuarioDisciplina();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from ProfessorDisciplina where id_usuario_disciplina = ?");
			
			comandoSql.setInt(1, id);
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				professorDisciplina.setIdUsuarioDisciplina(resultSet.getInt(1));
				professorDisciplina.setFk_usuario(resultSet.getInt(2));
				professorDisciplina.setFk_disciplina(resultSet.getInt(3));
				return professorDisciplina;
			}
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo para selecionar todas as <code>UsuarioDisciplinas</code> do banco de dados
	 * 
	 * @return <code>List</code>
	 * @author Andre
	 */	
	public List<UsuarioDisciplina> buscarTodos() {
		List<UsuarioDisciplina> lista = new ArrayList<UsuarioDisciplina>();
		
		String sql = "select * from Endereco";
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				UsuarioDisciplina professorDisciplina = new UsuarioDisciplina();
				professorDisciplina.setIdUsuarioDisciplina(resultSet.getInt(1));
				professorDisciplina.setFk_usuario(resultSet.getInt(2));
				professorDisciplina.setFk_disciplina(resultSet.getInt(3));
				lista.add(professorDisciplina);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	

}
