package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidade.Escola;

/**
 * Metodo para consulta da escola no banco de dados 
 * @author Andrey
 *
 */
public class EscolaDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir a escola no banco de dados
	 * @param Escola escola 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void insert(Escola escola) throws SQLException {
		String sql = "insert into escola (nome, datainicioletivo, datafinalletivo) values (?,?,?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, escola.getNome());
		comandoSql.setTimestamp(2, (Timestamp) escola.getDataInicioLetivo());
		comandoSql.setTimestamp(3, (Timestamp) escola.getDataFinalLetivo());
		comandoSql.execute();
		
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma escola no banco de dados.
	 * O <code>idEscola</code> deve ser igual ao do escola que deseja atualizar
	 * @param Escola escola
	 * @author Andrey
	 * @throws SQLException 
	 */ 	
	public void update(Escola escola) throws SQLException {
		String sql = "update escola set nome = ?, datainicioletivo = ?, datafinalletivo = ? where idescola = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, escola.getNome());
		comandoSql.setTimestamp(2, (Timestamp) escola.getDataInicioLetivo());
		comandoSql.setTimestamp(3, (Timestamp) escola.getDataFinalLetivo());
		comandoSql.setInt(4, escola.getIdEscola());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar chamada no banco de dados
	 * O <code>idEscola</code> deve ser igual ao do escola que deseja buscar
	 * @param int idChamada
	 * @return Chamada chamada 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public Escola buscarId(int idChamada) throws SQLException {
		Escola escola = new Escola();
		String sql = "select * from Escola where idescola = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idChamada);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			escola.setIdEscola(resultSet.getInt(1));
			escola.setNome(resultSet.getString(2));
			escola.setDataInicioLetivo(resultSet.getTimestamp(3));
			escola.setDataFinalLetivo(resultSet.getTimestamp(4));
			
		}
		comandoSql.close();
		return escola;
	}
	
	/**
	 * Metodo para selecionar todas as chamadas do banco de dados
	 * @return lista de escolas resgistradas no banco
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public List<Escola> buscarTodos() throws SQLException {
		List<Escola> lista = new ArrayList<Escola>();
		String sql = "select * from Escola";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Escola escola = new Escola();
			escola.setIdEscola(resultSet.getInt(1));
			escola.setNome(resultSet.getString(2));
			escola.setDataInicioLetivo(resultSet.getTimestamp(3));
			escola.setDataFinalLetivo(resultSet.getTimestamp(4));
			
			lista.add(escola);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo para inserir a escola no banco de dados só com o nome
	 * @param Escola escola 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void insertNome(Escola escola) throws SQLException {
		String sql = "insert into escola (nome) values (?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, escola.getNome());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar chamada no banco de dados
	 * O <code>nome</code> deve ser igual ao do escola que deseja buscar
	 * @param String nome
	 * @return Chamada chamada 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public Escola buscarNome(String nome) throws SQLException {
		Escola escola = new Escola();
		String sql = "select * from Escola where nome = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, nome);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			escola.setIdEscola(resultSet.getInt(1));
			escola.setNome(resultSet.getString(2));
			escola.setDataInicioLetivo(resultSet.getTimestamp(3));
			escola.setDataFinalLetivo(resultSet.getTimestamp(4));
		}
		comandoSql.close();
		return escola;
	}
	
	/**
	 * Metodo para atualizar uma escola no banco de dados na visao do ADM
	 * O <code>idEscola</code> deve ser igual ao do escola que deseja atualizar
	 * @param Escola escola
	 * @author Andrey
	 * @throws SQLException 
	 */ 	
	public void updateAdm(Escola escola) throws SQLException {
		String sql = "update escola set nome = ? where idEscola = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, escola.getNome());
		comandoSql.setInt(2, escola.getIdEscola());
		
		comandoSql.execute();
		comandoSql.close();
	}
}
