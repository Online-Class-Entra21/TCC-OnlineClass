package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.SalaPersonalizada;

/**
 * Metodo para consulta da salaPersonalizada no banco de dados 
 * @author Breno
 *
 */
public class SalaPersonalizadaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma salaPersonalizada no banco de dados
	 * @param SalaPersonalizada salaPersonalizada
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(SalaPersonalizada salaPersonalizada) throws SQLException {
		String sql = "insert into salaPersonalizada (dono, fk_sala) values (?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
	     
		comandoSql.setInt(1, salaPersonalizada.getDono());
		comandoSql.setInt(2, salaPersonalizada.getFk_sala());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza atualizacao dos dados da salaPersonalizada no banco de dados.
	 * O <code>idSalaPersonalizada</code> deve ser igual ao da salaPersonalizada que deseja atualizar
	 * @param SalaPersonlizada salaPersonalizada
	 * @author Breno
	 * @throws SQLException 
	 */
	public void update(SalaPersonalizada salaPersonalizada) throws SQLException {
		String sql = "Update salaPersonalizada set dono = ?, fk_sala = ? where idSalaPersonalizada = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		    
		comandoSql.setInt(1, salaPersonalizada.getDono());
		comandoSql.setInt(2, salaPersonalizada.getFk_sala());
		comandoSql.setInt(3, salaPersonalizada.getIdSalaPersonalizada());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza a exclusao dos dados de uma linha da tabela salaPersonalizada.
	 * O <code>idSalaPersonalizada</code> deve ser igual ao da salaPersonalizada que deseja deletar
	 * @param idSalaPersonalizada
	 * @throws SQLException 
	 */
	public void deleteId(int idSalaPersonalizada) throws SQLException {
		String sql = "delete from salaPersonalizada where idSalaPersonalizada = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idSalaPersonalizada);

		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela Sala Personalizada do banco de dados.
	 * O <code>idSalaPersonalizada</code> deve ser igual ao da salaPersonalizada que deseja buscar
	 * @param int idSalaPersonalizada
	 * @return SalaPersonalizada salaPersonalizada 
	 * @throws SQLException 
	 */
	public SalaPersonalizada buscarId(int idSalaPersonalizada) throws SQLException {
		SalaPersonalizada salaPersonalizada = new SalaPersonalizada(); 
		String sql = "select * from salaPersonalizada where idSalaPersonalizada = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idSalaPersonalizada);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			salaPersonalizada.setIdSalaPersonalizada(resultSet.getInt(1));
			salaPersonalizada.setDono(resultSet.getInt(2));
			salaPersonalizada.setFk_sala(resultSet.getInt(3));
		}
		comandoSql.close();
		return salaPersonalizada;
	}

	/**
	 * Retorna todos os dados listados da tabela salaPersonalizada do banco de dados
	 * @return lista de salasPersonalizadas registradas no banco 
	 * @throws SQLException 
	 */
	public List<SalaPersonalizada> buscarTodos() throws SQLException {
		SalaPersonalizada salaPersonalizada = new SalaPersonalizada();
		List<SalaPersonalizada> lista = new ArrayList<SalaPersonalizada>();
		String sql = "select * from salaPersonalizada";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();

		while (resultSet.next()) {
			salaPersonalizada.setIdSalaPersonalizada(resultSet.getInt(1));
			salaPersonalizada.setDono(resultSet.getInt(2));
			salaPersonalizada.setFk_sala(resultSet.getInt(3));
			
			lista.add(salaPersonalizada); 
		}
		comandoSql.close();
		return lista;
	}	
}
