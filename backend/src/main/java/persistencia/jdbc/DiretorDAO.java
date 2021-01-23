package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Diretor;

/**
 * Metodo para consulta do administrador no banco de dados 
 * @author André 
 *
 */
public class DiretorDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para selecionar do banco de dados todos os coordenadores cadastrados
	 * @return lista de coordenadores registrados no banco 
	 * @author André
	 * @throws SQLException
	 */
	public List<Diretor> buscarTodos() throws SQLException {
		Diretor diretor = new Diretor();
		List<Diretor> lista =  new ArrayList<Diretor>();
		String sql = "select * from usuario where tipoUsuario = 2";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			diretor.setIdUsuario(resultSet.getInt(1));
			diretor.setNome(resultSet.getString(2));
			diretor.setSobrenome(resultSet.getString(3));
			diretor.setCpf(resultSet.getString(4));
			diretor.setTelefone(resultSet.getString(5));
			diretor.setCelular(resultSet.getString(6));
			diretor.setTipoUsuario(resultSet.getInt(7));
			diretor.setEmail(resultSet.getString(8));
			diretor.setSenha(resultSet.getString(9));
			diretor.setHorarioFinalExpediente(resultSet.getTime(10));
			diretor.setHorarioInicioExpediente(resultSet.getTime(11));
			diretor.setFotoUsuario(resultSet.getString(12));
			diretor.setFk_endereco(resultSet.getInt(13));
			diretor.setFk_escola(resultSet.getInt(14));
			
			lista.add(diretor);
		}
		comandoSql.close();
		return lista;
	}
}

