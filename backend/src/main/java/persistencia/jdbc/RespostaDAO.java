package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Resposta;

/**
 * Metodo para consulta da resposta no banco de dados 
 * @author Andrey
 *
 */
public class RespostaDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir resposta no banco de dados
	 * @param Resposta resposta 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void insert(Resposta resposta) throws SQLException {
		String sql = "insert into resposta (nota, comentarioatividade, correcaoatividade, dataentrega,"
				   + " fk_aluno, fk_atividade) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setDouble(1, resposta.getNota());
		comandoSql.setString(2, resposta.getComentarioAtividade());
		comandoSql.setBoolean(3, resposta.getCorrecaoAtividade());
		comandoSql.setDate(4, (Date) resposta.getDataEntrega());
		comandoSql.setInt(5, resposta.getFk_aluno());
		comandoSql.setInt(6, resposta.getFk_atividade());
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma resposta no banco de dados.
	 * O <code>idResposta</code> deve ser igual ao do resposta que deseja atualizar
	 * @param Resposta resposta
	 * @author Andrey
	 * @throws SQLException 
	 */ 	
	public void update(Resposta resposta) throws SQLException {
		String sql = "update resposta set SET nota=?, comentarioatividade=?, correcaoatividade=?, dataentrega=?,"
				   + " fk_aluno=?, fk_atividade=? where idresposta = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);

		comandoSql.setDouble(1, resposta.getNota());
		comandoSql.setString(2, resposta.getComentarioAtividade());
		comandoSql.setBoolean(3, resposta.getCorrecaoAtividade());
		comandoSql.setDate(4, (Date) resposta.getDataEntrega());
		comandoSql.setInt(5, resposta.getFk_aluno());
		comandoSql.setInt(6, resposta.getFk_atividade());
		comandoSql.setInt(7, resposta.getIdResposta());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma resposta.
	 *  O <code>idResposta</code> deve ser igual ao do resposta que deseja deletar
	 * @param int idResposta
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void deleteId(int idResposta) throws SQLException {
		String sql = "delete from resposta where idresposta = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idResposta);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar a resposta no banco de dados.
	 * O <code>idResposta</code> deve ser igual ao do resposta que deseja buscar
	 * @param int idResposta
	 * @return Resposta resposta
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public Resposta buscarId(int id) throws SQLException {
		Resposta resposta = new Resposta();
		String sql = "select * from resposta where idresposta = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, id);	
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			resposta.setIdResposta(resultSet.getInt(1));
			resposta.setNota(resultSet.getDouble(2));
			resposta.setComentarioAtividade(resultSet.getString(3));
			resposta.setCorrecaoAtividade(resultSet.getBoolean(4));
			resposta.setDataEntrega(resultSet.getDate(5));
			resposta.setFk_aluno(resultSet.getInt(6));
			resposta.setFk_atividade(resultSet.getInt(7));
		}
		comandoSql.close();
		return resposta;
	}
	
	/**
	 * Metodo para selecionar todas as respostas do banco de dados
	 * @return lista de respostas registradas no banco
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public List<Resposta> buscarTodos() throws SQLException {
		Resposta resposta = new Resposta();
		List<Resposta> lista = new ArrayList<Resposta>();
		PreparedStatement comandoSql = conexao.prepareStatement("select * from Resposta");
		
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			resposta.setIdResposta(resultSet.getInt(1));
			resposta.setNota(resultSet.getDouble(2));
			resposta.setComentarioAtividade(resultSet.getString(3));
			resposta.setCorrecaoAtividade(resultSet.getBoolean(4));
			resposta.setDataEntrega(resultSet.getDate(5));
			resposta.setFk_aluno(resultSet.getInt(6));
			resposta.setFk_atividade(resultSet.getInt(7));
			
			lista.add(resposta);
		}
		comandoSql.close();
		return lista;
	}
}
