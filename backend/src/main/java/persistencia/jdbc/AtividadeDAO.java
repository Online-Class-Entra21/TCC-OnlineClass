package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Atividade;

/**
 * Metodo para consulta da atividade no banco de dados
 * @author Andre
 *
 */
public class AtividadeDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir atividade no banco de dados
	 * @param Atividade atividade
	 * @author Andre
	 * @throws SQLException 
	 */
	public void insert(Atividade atividade) throws SQLException {
		String sql = "insert into atividade (descricao, inicioatividade, finalatividade, tipoatividade, pesonota, fk_usuario_disciplina) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, atividade.getDescricao());
		comandoSql.setDate(2, (java.sql.Date) atividade.getInicioAtividade());
		comandoSql.setDate(3, (java.sql.Date) atividade.getFinalAtividade());
		comandoSql.setInt(4, atividade.getTipoAtividade());
		comandoSql.setDouble(5, atividade.getPesoNota());
		comandoSql.setInt(6, atividade.getFk_usuarioDisciplina());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma atividade no banco de dados.
	 * O <code>idAtividade</code> deve ser igual ao da atividade que deseja atualizar
	 * @param Atividade atividade
	 * @author Andre
	 * @throws SQLException 
	 */ 
	public void update(Atividade atividade) throws SQLException {
		String sql = "update atividade set descricao = ?, inicioatividade = ?, finalatividade = ?, tipoatividade = ?, "
				+ "pesonota = ?, fk_usuario_disciplina  where idatividade = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, atividade.getDescricao());
		comandoSql.setDate(2, (java.sql.Date) atividade.getInicioAtividade());
		comandoSql.setDate(3, (java.sql.Date) atividade.getFinalAtividade());
		comandoSql.setInt(4, atividade.getTipoAtividade());
		comandoSql.setDouble(5, atividade.getPesoNota());
		comandoSql.setInt(6, atividade.getFk_usuarioDisciplina());
		comandoSql.setInt(7, atividade.getIdAtividade());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma atividade.
	 *  O <code>idAtividade</code> deve ser igual ao da atividade que deseja deletar
	 * @param int idAtividade
	 * @author Andre
	 * @throws SQLException 
	 */
	public void deleteId(int idAtividade) throws SQLException {
		String sql = "delete from atividade where idatividade = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idAtividade);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar uma atividade do banco de dados.
	 * O <code>idAtividade</code> deve ser igual ao da atividade que deseja buscar
	 * @param int idAtividade
	 * @author Andre
	 * @throws SQLException 
	 */
	public Atividade buscarId(int idAtividade) throws SQLException {
		Atividade atividade = new Atividade();
		String sql = "select * from atividade where idatividade = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idAtividade);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			atividade.setIdAtividade(resultSet.getInt(1));
			atividade.setDescricao(resultSet.getString(2));
			atividade.setInicioAtividade(resultSet.getDate(3));
			atividade.setFinalAtividade(resultSet.getDate(4));
			atividade.setTipoAtividade(resultSet.getInt(5));
			atividade.setPesoNota(resultSet.getDouble(6));
		
		}
		comandoSql.close();
		return atividade;
	}
	
	/**
	 * Metodo para selecionar todas as atividades do banco de dados
	 * @author Andre
	 * @return lista de atividades resgistradas no banco 
	 * @throws SQLException 
	 */
	public List<Atividade> buscarTodos() throws SQLException {
		List<Atividade> lista =  new ArrayList<Atividade>();
		String sql = "select * from atividade";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Atividade atividade = new Atividade();
			atividade.setIdAtividade(resultSet.getInt(1));
			atividade.setDescricao(resultSet.getString(2));
			atividade.setInicioAtividade(resultSet.getDate(3));
			atividade.setFinalAtividade(resultSet.getDate(4));
			atividade.setTipoAtividade(resultSet.getInt(5));
			atividade.setPesoNota(resultSet.getDouble(6));

			lista.add(atividade);
		}
		comandoSql.close();
		return lista;
	}
}
