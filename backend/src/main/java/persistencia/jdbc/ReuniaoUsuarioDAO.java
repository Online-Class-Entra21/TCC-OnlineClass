package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.ReuniaoUsuario;

/**
 * Metodo para consulta da reuniaoUsuario no banco de dados 
 * @author Andrey
 *
 */
public class ReuniaoUsuarioDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir reuniaoUsuario no banco de dados
	 * @param ReuniaoUsuario reuniaoUsuario
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void insert(ReuniaoUsuario reuniaoUsuario) throws SQLException {
		String sql = "insert into reuniaoUsuario (fk_Reuniao, fk_Usuario, entradaReuniao, notaReuniao, comentarioReuniao)"
				   + " values (?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, reuniaoUsuario.getFk_reuniao());
		comandoSql.setInt(2, reuniaoUsuario.getFk_usuario());
		comandoSql.setTime(3, reuniaoUsuario.getEntradaReuniao());
		comandoSql.setDouble(4, reuniaoUsuario.getNotaReuniao());
		comandoSql.setString(5, reuniaoUsuario.getComentarioReuniao());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma reuniaoUsuario no banco de dados.
	 * O <code>idReuniao</code> deve ser igual ao da reuniao que deseja atualizar
	 * @param ReuniaoUsuario reuniaoUsuario
	 * @author Andrey
	 * @throws SQLException 
	 */ 	
	public void update(ReuniaoUsuario reuniaoUsuario) throws SQLException {
		String sql = "update reuniaoUsuario set descricao=?, datainicio=?, dono=?, notamediaaula=?, fk_sala=?, "
				   + "fk_usuario_disciplina_turma=? where idreuniao = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);

		comandoSql.setInt(1, reuniaoUsuario.getFk_reuniao());
		comandoSql.setInt(2, reuniaoUsuario.getFk_usuario());
		comandoSql.setTime(3, reuniaoUsuario.getEntradaReuniao());
		comandoSql.setDouble(4, reuniaoUsuario.getNotaReuniao());
		comandoSql.setString(5, reuniaoUsuario.getComentarioReuniao());
		comandoSql.setInt(6, reuniaoUsuario.getIdReuniaoUsuario());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para deletar do banco de dados uma reuniaoUsuario.
	 * O <code>idReuniaoUsuario</code> deve ser igual ao da reuniaoUsuario que deseja deletar
	 * @param int idReuniaoUsuario
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void deleteId(int idReuniaoUsuario) throws SQLException {
		String sql = "delete from reuniaoUsuario where idReuniaoUsuario = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idReuniaoUsuario);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar reuniaoUsuario no banco de dados.
	 * O <code>idReuniaoUsuario</code> deve ser igual ao da reuniaoUsuario que deseja buscar
	 * @param int idReuniaoUsuario
	 * @return ReuniaoUsuario reuniaoUsuario
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public ReuniaoUsuario buscarId(int idReuniaoUsuario) throws SQLException {
		ReuniaoUsuario reuniaoUsuario = new ReuniaoUsuario();
		String sql = "select * from resposta where idreuniao = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idReuniaoUsuario);		
		ResultSet resultSet = comandoSql.executeQuery();
			
		if (resultSet.next()) {
			reuniaoUsuario.setIdReuniaoUsuario(resultSet.getInt(1));
			reuniaoUsuario.setFk_reuniao(resultSet.getInt(2));
			reuniaoUsuario.setFk_usuario(resultSet.getInt(3));
			reuniaoUsuario.setEntradaReuniao(resultSet.getTime(4));
			reuniaoUsuario.setNotaReuniao(resultSet.getDouble(5));
			reuniaoUsuario.setComentarioReuniao(resultSet.getString(6));
		}
		comandoSql.close();
		return reuniaoUsuario;
	}
	
	/**
	 * Metodo para selecionar todas as reunioesUsuarios do banco de dados
	 * @return lista de reunioesUsuarios resgistradas no banco 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public List<ReuniaoUsuario> buscarTodos() throws SQLException {
		List<ReuniaoUsuario> lista = new ArrayList<ReuniaoUsuario>();
		String sql = "select * from reuniaoUsuario";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			ReuniaoUsuario reuniaoUsuario = new ReuniaoUsuario();
			reuniaoUsuario.setIdReuniaoUsuario(resultSet.getInt(1));
			reuniaoUsuario.setFk_reuniao(resultSet.getInt(2));
			reuniaoUsuario.setFk_usuario(resultSet.getInt(3));
			reuniaoUsuario.setEntradaReuniao(resultSet.getTime(4));
			reuniaoUsuario.setNotaReuniao(resultSet.getDouble(5));
			reuniaoUsuario.setComentarioReuniao(resultSet.getString(6));
			lista.add(reuniaoUsuario);
		}
		comandoSql.close();
		return lista;
	}
}
