package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidade.UsuarioDisciplina;

/**
 * Metodo para consulta do usuarioDisciplina no banco de dados 
 * @author Breno
 *
 */
public class UsuarioDisciplinaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir usuarioDisciplina no banco de dados
	 * @param UsuarioDisciplina usuarioDisciplina
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(UsuarioDisciplina usuarioDisciplina) throws SQLException {
		String sql = "insert into usuario_disciplina (fk_usuario, fk_disciplina) values (?,?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, usuarioDisciplina.getFk_usuario());
		comandoSql.setInt(2, usuarioDisciplina.getFk_disciplina());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma UsuarioDisciplina no banco de dados.
	 * O <code>idUsuarioDisciplina</code> deve ser igual ao da usuarioDisciplina que deseja atualizar
	 * @param UsuarioDisciplina usuarioDisciplina 
	 * @author Breno
	 * @throws SQLException 
	 */ 
	public void update(UsuarioDisciplina usuarioDisciplina) throws SQLException {
		String sql = "update usuario_Disciplina set fk_usuario = ?, fk_disciplina = ? where id_usuario_disciplina = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, usuarioDisciplina.getFk_usuario());
		comandoSql.setInt(2, usuarioDisciplina.getFk_disciplina());
		comandoSql.setInt(3, usuarioDisciplina.getIdUsuarioDisciplina());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados um usuarioDisciplina.
	 *  O <code>idUsuarioDisciplina</code> deve ser igual ao da usuarioDisciplina que deseja deletar
	 * @param int idUsuarioDisciplina
	 * @author Breno
	 * @throws SQLException 
	 */	
	public void deleteId(int idUsuarioDisciplina) throws SQLException {
		String sql = "delete from usuario_Disciplina where id_usuario_disciplina = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idUsuarioDisciplina);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar usuarioDisciplina no banco de dados.
	 * O <code>idUsuarioDisciplina</code> deve ser igual ao da usuarioDisciplina que deseja buscar
	 * @param int idUsuarioDisciplina 
	 * @return UsuarioDisciplina
	 * @author Breno
	 * @throws SQLException 
	 */	
	public UsuarioDisciplina buscarId(int id) throws SQLException {
		UsuarioDisciplina usuarioDisciplina = new UsuarioDisciplina();
		String sql = "select * from usuario_Disciplina where id_usuario_disciplina = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, id);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			usuarioDisciplina.setIdUsuarioDisciplina(resultSet.getInt(1));
			usuarioDisciplina.setFk_usuario(resultSet.getInt(2));
			usuarioDisciplina.setFk_disciplina(resultSet.getInt(3));
		}
		comandoSql.close();
		return usuarioDisciplina;
	}
	
	/**
	 * Metodo para selecionar todos os usuariosDisciplinas do banco de dados
	 * @return lista de usuariosDisciplinas
	 * @author Breno
	 * @throws SQLException 
	 */	
	public List<UsuarioDisciplina> buscarTodos() throws SQLException {
		List<UsuarioDisciplina> lista = new ArrayList<UsuarioDisciplina>();
		String sql = "select * from usuario_Disciplina";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			UsuarioDisciplina usuarioDisciplina = new UsuarioDisciplina();
			usuarioDisciplina.setIdUsuarioDisciplina(resultSet.getInt(1));
			usuarioDisciplina.setFk_usuario(resultSet.getInt(2));
			usuarioDisciplina.setFk_disciplina(resultSet.getInt(3));
			lista.add(usuarioDisciplina);
		}
		comandoSql.close();
		return lista;
	}
	
	/**
	 * Metodo para selecionar o idUsuarioDisciplina no banco de dados.
	 * O objeto usuarioDisciplina ter os atributos iguais aos do banco de dados
	 * caso nao tenha nenhum usuarioDisciplina igual sera retornado 0
	 * 
	 * @param UsuarioDisciplina usuarioDisciplina
	 * @return int idUsuarioDisciplina
	 * @author Andre
	 * @throws SQLException
	 */
	public int buscarIgual(UsuarioDisciplina usuarioDisciplina) throws SQLException {
		int idUsuarioDisciplina = 0;
		String sql = "select id_usuario_Disciplina from usuario_disciplina where fk_usuario=? and fk_disciplina=?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, usuarioDisciplina.getFk_usuario());
		comandoSql.setInt(2, usuarioDisciplina.getFk_disciplina());
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			idUsuarioDisciplina = resultSet.getInt(1);
		}
		comandoSql.close();
		return idUsuarioDisciplina;
	}
	
	/**
	 * Metodo para inserir usuarioDisciplina no banco de dados
	 * e retornar o idusuarioDisciplina criado
	 * @param UsuarioDisciplina usuarioDisciplina
	 * @author Andre
	 * @throws SQLException 
	 */
	public int insertReturn(UsuarioDisciplina usuarioDisciplina) throws SQLException {
		String sql = "insert into usuario_disciplina (fk_usuario, fk_disciplina) values (?,?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		comandoSql.setInt(1, usuarioDisciplina.getFk_usuario());
		comandoSql.setInt(2, usuarioDisciplina.getFk_disciplina());
		
		comandoSql.execute();
        ResultSet rs = comandoSql.getGeneratedKeys();
        rs.next();
        int idusuarioDisciplina = rs.getInt(1);
		comandoSql.close();
		return idusuarioDisciplina; 
	}
}
