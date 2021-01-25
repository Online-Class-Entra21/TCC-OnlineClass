package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.SalaPadrao;

public class SalaPadraoDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Retorna todos os dados listados da tabela salaPadrao do banco de dados 
	 * @return lista das salasPadroes resgistradas no banco
	 * @author Breno
	 * @throws SQLException 
	 */
	public List<SalaPadrao> buscarTodos() throws SQLException {
		SalaPadrao sala = new SalaPadrao(); 
		List<SalaPadrao> lista = new ArrayList<SalaPadrao>(); 
		String sql = "select * from sala where tipoSala = false"; 

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
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
}
