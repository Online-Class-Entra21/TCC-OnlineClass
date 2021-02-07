package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Coordenador;
import entidade.Diretor;

/**
 * Metodo para consulta do administrador no banco de dados 
 * @author Andre 
 *
 */
public class CoordenadorDAO {
	
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para selecionar do banco de dados todos os coordenadores cadastrados
	 * @return lista de coordenadores registrados no banco 
	 * @author Andre
	 * @throws SQLException
	 */
	public List<Coordenador> buscarTodos() throws SQLException {
		List<Coordenador> lista =  new ArrayList<Coordenador>();
		String sql = "select * from usuario where tipoUsuario = 3";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Coordenador coordenador = new Coordenador();
			coordenador.setIdUsuario(resultSet.getInt(1));
			coordenador.setNome(resultSet.getString(2));
			coordenador.setSobrenome(resultSet.getString(3));
			coordenador.setCpf(resultSet.getString(4));
			coordenador.setTelefone(resultSet.getString(5));
			coordenador.setCelular(resultSet.getString(6));
			coordenador.setTipoUsuario(resultSet.getInt(7));
			coordenador.setEmail(resultSet.getString(8));
			coordenador.setSenha(resultSet.getString(9));
			coordenador.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			coordenador.setHorarioInicioExpediente(resultSet.getTimestamp(11));
			coordenador.setFotoUsuario(resultSet.getString(12));
			coordenador.setFk_endereco(resultSet.getInt(13));
			coordenador.setFk_escola(resultSet.getInt(14));
			
			lista.add(coordenador);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo para retorno da quantidade de coordenadores no banco de dados
	 * @return int qtdCoordenadores
	 * @author Breno
	 * @throws SQLException
	 */
	public int buscarQuantidadeCoordenadores() throws SQLException {
		int qtdCoordenadores = 0;
		String sql = "select count(idUsuario) from usuario where tipoUsuario = 3";

		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			qtdCoordenadores = (resultSet.getInt(1));
		}
		comandoSql.close();
		return qtdCoordenadores;
	}
	
	/**
	 * Método para retorno do coordenador correspondente ao id da escola
	 * @param int fk_escola
	 * @return Andrey
	 * @throws SQLException
	 */
	public List<Coordenador> buscarEscola(int fk_escola) throws SQLException {
		List<Coordenador> lista =  new ArrayList<Coordenador>();
		String sql = "select * from usuario where tipoUsuario = 3 and fk_escola = ?";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, fk_escola);
		ResultSet resultSet = comandoSql.executeQuery();
		
		if (resultSet.next()) {
			Coordenador coordenador = new Coordenador();
			coordenador.setIdUsuario(resultSet.getInt(1));
			coordenador.setNome(resultSet.getString(2));
			coordenador.setSobrenome(resultSet.getString(3));
			coordenador.setCpf(resultSet.getString(4));
			coordenador.setTelefone(resultSet.getString(5));
			coordenador.setCelular(resultSet.getString(6));
			coordenador.setTipoUsuario(resultSet.getInt(7));
			coordenador.setEmail(resultSet.getString(8));
			coordenador.setSenha(resultSet.getString(9));
			coordenador.setHorarioFinalExpediente(resultSet.getTimestamp(10));
			coordenador.setHorarioInicioExpediente(resultSet.getTimestamp(11));
			coordenador.setFotoUsuario(resultSet.getString(12));
			coordenador.setFk_endereco(resultSet.getInt(13));
			coordenador.setFk_escola(resultSet.getInt(14));
			
			lista.add(coordenador);
		}
		comandoSql.close();
		return lista;
	}
	
}
