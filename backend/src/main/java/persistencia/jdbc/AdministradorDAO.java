package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Administrador;

/**
 * Metodo para consulta do administrador no banco de dados 
 * @author Andre
 *
 */
public class AdministradorDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para selecionar do banco de dados todos os administradores cadastrados
	 * @return lista de administradores registrados no banco 
	 * @author Andre
	 * @throws SQLException
	 */
	public List<Administrador> buscarTodos() throws SQLException {
		List<Administrador> lista =  new ArrayList<Administrador>();
		String sql = "select * from usuario where tipoUsuario = 1";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Administrador administrador = new Administrador();
			administrador.setIdUsuario(resultSet.getInt(1));
			administrador.setNome(resultSet.getString(2));
			administrador.setSobrenome(resultSet.getString(3));
			administrador.setCpf(resultSet.getString(4));
			administrador.setTelefone(resultSet.getString(5));
			administrador.setCelular(resultSet.getString(6));
			administrador.setTipoUsuario(resultSet.getInt(7));
			administrador.setEmail(resultSet.getString(8));
			administrador.setSenha(resultSet.getString(9));
			administrador.setHorarioFinalExpediente(resultSet.getTime(10));
			administrador.setHorarioInicioExpediente(resultSet.getTime(11));
			administrador.setFotoUsuario(resultSet.getString(12));
			administrador.setFk_endereco(resultSet.getInt(13));
			administrador.setFk_escola(resultSet.getInt(14));
			
			lista.add(administrador);
		}
		comandoSql.close();
		return lista;
	}
}
