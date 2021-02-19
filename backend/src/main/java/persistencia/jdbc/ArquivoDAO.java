package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidade.Arquivo;

/**
 * Metodo para consulta do arquivo no banco de dados 
 * @author Andre
 *
 */
public class ArquivoDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir um arquivo no banco de dados
	 * @param Arquivo arquivo
	 * @author Andre
	 * @throws SQLException 
	 */
	public void insert(Arquivo arquivo) throws SQLException {
		String sql = "insert into arquivo (extensao, dataenvio, remetente, arquivo) values (?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, arquivo.getExtensao());
		comandoSql.setTimestamp(2, arquivo.getDataEnvio());
		comandoSql.setInt(3, arquivo.getRemetente());
		comandoSql.setString(4, arquivo.getCaminhoArquivo());
		
		comandoSql.execute();
		comandoSql.close();	
	}
	
	/**
	 * Metodo para atualizar os dados de um arquivo no banco de dados
	 * O <code>idArquivo</code> deve ser igual ao do arquivo que deseja atualizar
	 * @param Arquivo arquivo
	 * @author Andre
	 * @throws SQLException 
	 */
	public void update(Arquivo arquivo) throws SQLException {
		String sql = "update arquivo set extensao = ?, dataenvio = ?, remetente = ?, arquivo = ? where idarquivo = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setString(1, arquivo.getExtensao());
		comandoSql.setTimestamp(2, arquivo.getDataEnvio());
		comandoSql.setInt(3, arquivo.getRemetente());
		comandoSql.setString(4, arquivo.getCaminhoArquivo());
		comandoSql.setInt(5, arquivo.getIdArquivo());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para deletar um arquivo do banco de dados
	 * O <code>idArquivo</code> deve ser igual ao do arquivo que deseja deletar
	 * @param int idArquivo
	 * @author Andre
	 * @throws SQLException 
	 */
	public void deleteId(int idArquivo) throws SQLException {
		String sql = "delete from arquivo where idarquivo = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idArquivo);
		
		comandoSql.execute();
		comandoSql.close();
	}
	 
	/**
	 * Metodo para selecionar um arquivo do banco de dados.
	 * O <code>idArquivo</code> deve ser igual ao do arquivo que deseja buscar
	 * @param int idArquivo
	 * @return Arquivo arquivo
	 * @author Andre
	 * @throws SQLException 
	 */
	public Arquivo buscarId(int idArquivo) throws SQLException {
		Arquivo arquivo = new Arquivo();
		String sql = "select * from arquivo where idarquivo = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idArquivo);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			arquivo.setIdArquivo(resultSet.getInt(1));
			arquivo.setExtensao(resultSet.getString(2));
			arquivo.setDataEnvio(resultSet.getTimestamp(3));
			arquivo.setRemetente(resultSet.getInt(4));
			arquivo.setCaminhoArquivo(resultSet.getString(5));
		}
		comandoSql.close();
		return arquivo;
	}
	
	/**
	 * Metodo para selecionar todos os arquivos do banco de dados
	 * @return lista de arquivos que estão no banco 
	 * @author Andre
	 * @throws SQLException 
	 */
	public List<Arquivo> buscarTodos() throws SQLException { 
		List<Arquivo> lista =  new ArrayList<Arquivo>();
		String sql = "select * from arquivo";

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Arquivo arquivo = new Arquivo();
			arquivo.setIdArquivo(resultSet.getInt(1));
			arquivo.setExtensao(resultSet.getString(2));
			arquivo.setDataEnvio(resultSet.getTimestamp(3));
			arquivo.setRemetente(resultSet.getInt(4));
			arquivo.setCaminhoArquivo(resultSet.getString(5));

			lista.add(arquivo);
		}
		comandoSql.close();
		return lista;
	}

	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo para inserir um arquivo no banco de dados
	 * e retorna o idArquivo gerado
	 * 
	 * @param Arquivo arquivo
	 * @return idArquivo
	 * @author Andre
	 * @throws SQLException 
	 */
	public int insertReturnID(Arquivo arquivo) throws SQLException {
		String sql = "insert into arquivo (extensao, dataenvio, remetente, arquivo) values (?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
		comandoSql.setString(1, arquivo.getExtensao());
		comandoSql.setTimestamp(2, arquivo.getDataEnvio());
		comandoSql.setInt(3, arquivo.getRemetente());
		comandoSql.setString(4, arquivo.getCaminhoArquivo());
		
		comandoSql.execute();
        ResultSet rs = comandoSql.getGeneratedKeys();
        rs.next();
        int idEndereco = rs.getInt(1);
		comandoSql.close();
		return idEndereco;
	}
}
