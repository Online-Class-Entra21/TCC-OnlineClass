package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Convite;

/**
 * Metodo para consulta do convite no banco de dados
 * @author André
 *
 */
public class ConviteDAO {
	
private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Metodo para inserir convite no banco de dados
	 * @param Convite convite
	 * @author André
	 * @throws SQLException 
	 */
	public void insert(Convite convite) throws SQLException {
		String sql = "insert into convite (destinatario, salaconvite, situacaoconvite, fk_usuario) values (?, ?, ?, ?)";

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, convite.getDestinatario());
		comandoSql.setInt(2, convite.getSalaConvite());
		comandoSql.setBoolean(3, convite.getSituacaoConvite());
		comandoSql.setInt(4, convite.getFk_usuario());
		
		comandoSql.execute();
		comandoSql.close();	
	}
	
	/**
	 * Metodo para atualizar um convite no banco de dados.
	 * O <code>idConvite</code> deve ser igual ao do convite que deseja atualizar
	 * @param Convite convite
	 * @author André
	 * @throws SQLException 
	 */ 
	public void update(Convite convite) throws SQLException {
		String sql = "update convite set destinatario = ?, salaconvite = ?, situacaoconvite = ?, fk_usuario = ? "
				   + "where idconvite = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, convite.getDestinatario());
		comandoSql.setInt(2, convite.getSalaConvite());
		comandoSql.setBoolean(3, convite.getSituacaoConvite());
		comandoSql.setInt(4, convite.getFk_usuario());
		comandoSql.setInt(5, convite.getIdConvite());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 *  Metodo para deletar do banco de dados um convite.
	 *  O <code>idConvite</code> deve ser igual ao do convite que deseja deletar 
	 * @param int idConvite
	 * @author André
	 * @throws SQLException 
	 */
	public void deleteId(int idConvite) throws SQLException {
		String sql = "delete from convite where idconvite = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idConvite);
		
		comandoSql.execute();
		comandoSql.close();
	}

	/**
	 * Metodo para selecionar convite no banco de dados
	 * O <code>idConvite</code> deve ser igual ao do convite que deseja buscar
	 * @param int idChamada
	 * @return Chamada chamada 
	 * @author André
	 * @throws SQLException 
	 */
	public Convite buscarId(int idConvite) throws SQLException {
		Convite convite =  new Convite();
		String sql = "select * from convite where idconvite = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idConvite);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			convite.setIdConvite(resultSet.getInt(1));
			convite.setDestinatario(resultSet.getInt(2));
			convite.setSalaConvite(resultSet.getInt(3));
			convite.setSituacaoConvite(resultSet.getBoolean(4));
			convite.setFk_usuario(resultSet.getInt(5));
		}
		comandoSql.close();
		return convite;
	}
	/**
	 * Metodo para selecionar todos os convites do banco de dados
	 * @return lista de convites registrados no banco 
	 * @author André
	 * @throws SQLException 
	 */
	public List<Convite> buscarTodos() throws SQLException {
		Convite convite = new Convite();
		List<Convite> lista =  new ArrayList<Convite>();
		String sql = "select * from convite";

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			convite.setIdConvite(resultSet.getInt(1));
			convite.setDestinatario(resultSet.getInt(2));
			convite.setSalaConvite(resultSet.getInt(3));
			convite.setSituacaoConvite(resultSet.getBoolean(4));
			convite.setFk_usuario(resultSet.getInt(5));

			lista.add(convite);
		}
		comandoSql.close();
		return lista;
	}
}
