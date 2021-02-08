package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entidade.Sala;

/**
 * Metodo para consulta da sala no banco de dados 
 * @author Breno
 *
 */
public class SalaDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Realiza o registro de uma sala no banco de dados
	 * @param Sala sala
	 * @author Breno
	 * @throws SQLException 
	 */
	public void insert(Sala sala) throws SQLException {
		String sql = "insert into sala (nome, descricao, situacaoAcesso, tipoSala, link) values (?,?,?,?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		     
		comandoSql.setString(1, sala.getNome());
		comandoSql.setString(2, sala.getDescricao());
		comandoSql.setBoolean(3, sala.getSituacaoAcesso());
		comandoSql.setBoolean(4, sala.getTipoSala());
		comandoSql.setString(5, sala.getLink());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza atualizacao dos dados da sala no banco de dados.
	 * O <code>idSala</code> deve ser igual ao da sala que deseja atualizar
	 * @param Sala sala
	 * @author Breno
	 * @throws SQLException 
	 */
	public void update(Sala sala) throws SQLException {
		String sql = "Update sala set nome = ?, descricao = ?,"
				   + "situacaoAcesso = ?, tipoSala = ?, link = ? where idSala = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
	    
		comandoSql.setString(1, sala.getNome());
		comandoSql.setString(2, sala.getDescricao());
		comandoSql.setBoolean(3, sala.getSituacaoAcesso());
		comandoSql.setBoolean(4, sala.getTipoSala());
		comandoSql.setString(5, sala.getLink());
		comandoSql.setInt(6, sala.getIdSala());
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Realiza a exclusao dos dados de uma linha da tabela sala.
	 * O <code>idSala</code> deve ser igual ao da sala que deseja deletar
	 * @param int idSala
	 * @author Breno
	 * @throws SQLException 
	 */
	public void deleteId(int idSala) throws SQLException {
		String sql = "delete from sala where idSala = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idSala);
		
		comandoSql.execute(); 
		comandoSql.close(); 
	}
	
	/**
	 * Metodo de busca de todas as informacoes de uma linha
	 * da tabela sala do banco de dados.
	 * O <code>idSala</code> deve ser igual ao da sala que deseja buscar
	 * @param int idSalaPersonalizada
	 * @return
	 * @author Breno
	 * @throws SQLException 
	 */
	public Sala buscarId(int idSala) throws SQLException {
		Sala sala = new Sala(); 
		String sql = "select * from sala where idSala = ?"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, idSala);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			sala.setIdSala(resultSet.getInt(1));
			sala.setNome(resultSet.getString(2));
			sala.setDescricao(resultSet.getString(3));
			sala.setSituacaoAcesso(resultSet.getBoolean(4));
			sala.setTipoSala(resultSet.getBoolean(5));
			sala.setLink(resultSet.getString(6));
		}
		comandoSql.close(); 
		return sala;
	}
	
	/**
	 * Retorna todos os dados listados da tabela sala do banco de dados 
	 * @return lista das salas resgistradas no banco
	 * @author Breno
	 * @throws SQLException 
	 */
	public List<Sala> buscarTodos() throws SQLException {
		List<Sala> lista = new ArrayList<Sala>(); 
		String sql = "select * from sala"; 

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Sala sala = new Sala(); 
			sala.setIdSala(resultSet.getInt(1));
			sala.setNome(resultSet.getString(2));
			sala.setDescricao(resultSet.getString(3));
			sala.setSituacaoAcesso(resultSet.getBoolean(4));
			sala.setTipoSala(resultSet.getBoolean(5));
			sala.setLink(resultSet.getString(6));
			
			lista.add(sala); 
		}
		comandoSql.close(); 
		return lista;
	}
	/**
	 * Realiza o registro de uma sala no banco de dados
	 * e retorna o id registrado no banco de dados
	 * @param Sala sala
	 * @return int idSala
	 * @author Breno
	 * @throws SQLException 
	 */
	public int insertReturnID(Sala sala) throws SQLException {
		String sql = "insert into sala (nome, descricao, situacaoAcesso, tipoSala, link) values (?,?,?,?,?)"; 
		PreparedStatement comandoSql = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		     
		comandoSql.setString(1, sala.getNome());
		comandoSql.setString(2, sala.getDescricao());
		comandoSql.setBoolean(3, sala.getSituacaoAcesso());
		comandoSql.setBoolean(4, sala.getTipoSala());
		comandoSql.setString(5, sala.getLink());
		
		comandoSql.execute();
        ResultSet rs = comandoSql.getGeneratedKeys();
        rs.next();
        int idSala = rs.getInt(1);
		comandoSql.close(); 
		return idSala;
	}
}
