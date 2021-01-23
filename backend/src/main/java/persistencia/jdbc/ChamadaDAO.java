package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Chamada;

/**
 * Metodo para consulta da chamada no banco de dados
 * @author Andrey
 *
 */
public class ChamadaDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir chamada no banco de dados
	 * @param Chamada chamada
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void insert(Chamada chamada) throws SQLException {
		String sql = "insert into chamada (situacao, fk_aluno, fk_reuniao) values (?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setBoolean(1, chamada.getSituacao());
		comandoSql.setInt(2, chamada.getFk_aluno());
		comandoSql.setInt(3, chamada.getFk_reuniao());
		
		comandoSql.execute();
		comandoSql.close();	
	}
	
	/**
	 * Metodo para atualizar chamada no banco de dados.
	 * O <code>idChamada</code> deve ser igual ao do chamada que deseja atualizar
	 * @param Chmada chamada
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void update(Chamada chamada) throws SQLException {
		String sql = "update chamada set situacao = ?, fk_aluno = ?, fk_reuniao = ? where idchamada = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setBoolean(1, chamada.getSituacao());
		comandoSql.setInt(2, chamada.getFk_aluno());
		comandoSql.setInt(3, chamada.getFk_reuniao());
		comandoSql.setInt(4, chamada.getIdChamada());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para deletar chamada do banco de dados.
	 * O <code>idAtividade</code> deve ser igual ao do chamada que deseja deletar
	 * @param int idChamada
	 * @author Andrey
	 * @throws SQLException 
	 */
	public void deleteId(int idChamada) throws SQLException {
		String sql = "delete from chamada where idchamada = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idChamada);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar chamada no banco de dados.
	 * O <code>idAtividade</code> deve ser igual ao do chamada que deseja buscar
	 * @param int idChamada
	 * @return Chamada chamada 
	 * @author Andrey
	 * @throws SQLException 
	 */
	public Chamada buscarId(int idChamada) throws SQLException {
		Chamada chamada = new Chamada();
		String sql = "select * from chamada where idchamada = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idChamada);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			chamada.setIdChamada(resultSet.getInt(1));
			chamada.setSituacao(resultSet.getBoolean(2));
			chamada.setFk_aluno(resultSet.getInt(3));
			chamada.setFk_reuniao(resultSet.getInt(3));
		}
		comandoSql.close();
		return chamada;	
	}

	/**
	 * Metodo para selecionar todas as chamadas do banco de dados
	 * @return lista de todas as chamadas registradas no banco
	 * @author Andrey
	 * @throws SQLException 
	 */
	public List<Chamada> buscarTodos() throws SQLException {
		Chamada chamada = new Chamada();
		List<Chamada> lista =  new ArrayList<Chamada>();
		String sql = "select * from chamada";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			chamada.setIdChamada(resultSet.getInt(1));
			chamada.setSituacao(resultSet.getBoolean(2));
			chamada.setFk_aluno(resultSet.getInt(3));
			chamada.setFk_reuniao(resultSet.getInt(3));

			lista.add(chamada);
		}
		comandoSql.close();
		return lista;
	}
}
