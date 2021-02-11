package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidade.Reuniao;

/**
 * Metodo para consulta da reuniao no banco de dados 
 * @author Andrey
 *
 */
public class ReuniaoDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir reuniao no banco de dados
	 * @param Reuniao reuniao
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void insert(Reuniao reuniao) throws SQLException {
		String sql = "insert into reuniao (descricao, datainicio, dono, notamediaaula, fk_sala, "
				   + "fk_usuario_disciplina_turma) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setString(1, reuniao.getDescricao());
		comandoSql.setTimestamp(2, (Timestamp) reuniao.getDataInicio());
		comandoSql.setInt(3, reuniao.getDono());
		comandoSql.setDouble(4, reuniao.getNotaMediaAula());
		comandoSql.setInt(5, reuniao.getFk_sala());
		comandoSql.setInt(6, reuniao.getFk_usuarioDisciplina());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para atualizar uma reuniao no banco de dados.
	 * O <code>idReuniao</code> deve ser igual ao da reuniao que deseja atualizar
	 * @param Reuniao reuniao
	 * @author Andrey
	 * @throws SQLException 
	 */ 	
	public void update(Reuniao reuniao) throws SQLException {
		String sql = "update reuniao set descricao=?, datainicio=?, dono=?, notamediaaula=?, fk_sala=?, "
				   + "fk_usuario_disciplina_turma=? where idreuniao = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);

		comandoSql.setString(1, reuniao.getDescricao());
		comandoSql.setTimestamp(2, (Timestamp) reuniao.getDataInicio());
		comandoSql.setInt(3, reuniao.getDono());
		comandoSql.setDouble(4, reuniao.getNotaMediaAula());
		comandoSql.setInt(5, reuniao.getFk_sala());
		comandoSql.setInt(6, reuniao.getFk_usuarioDisciplina());
		comandoSql.setInt(7, reuniao.getIdReuniao());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para deletar do banco de dados uma reuniao.
	 * O <code>idReuniao</code> deve ser igual ao da reuniao que deseja deletar
	 * @param int idReuniao
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void deleteId(int idReuniao) throws SQLException {
		String sql = "delete from reuniao where idReuniao = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		
		comandoSql.setInt(1, idReuniao);
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para selecionar reuniao no banco de dados.
	 * O <code>idReuniao</code> deve ser igual ao da reuniao que deseja buscar
	 * @param int idReuniao
	 * @return Reuniao reuniao
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public Reuniao buscarId(int id) throws SQLException {
		Reuniao reuniao = new Reuniao();
		String sql = "select * from reuniao where idreuniao = ?";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setInt(1, id);		
		ResultSet resultSet = comandoSql.executeQuery();
			
		if (resultSet.next()) {
			reuniao.setIdReuniao(resultSet.getInt(1));
			reuniao.setDescricao(resultSet.getString(2));
			reuniao.setDataInicio(resultSet.getTimestamp(3));
			reuniao.setDono(resultSet.getInt(4));
			reuniao.setNotaMediaAula(resultSet.getDouble(5));
			reuniao.setFk_sala(resultSet.getInt(6));
			reuniao.setFk_usuarioDisciplina(resultSet.getInt(7));
		}
		comandoSql.close();
		return reuniao;
	}
	
	/**
	 * Metodo para selecionar todas as reunioes do banco de dados
	 * @return lista de reunioes resgistradas no banco 
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public List<Reuniao> buscarTodos() throws SQLException {
		List<Reuniao> lista = new ArrayList<Reuniao>();
		String sql = "select * from reuniao";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Reuniao reuniao = new Reuniao();
			reuniao.setIdReuniao(resultSet.getInt(1));
			reuniao.setDescricao(resultSet.getString(2));
			reuniao.setDataInicio(resultSet.getTimestamp(3));
			reuniao.setDono(resultSet.getInt(4));
			reuniao.setNotaMediaAula(resultSet.getDouble(5));
			reuniao.setFk_sala(resultSet.getInt(6));
			reuniao.setFk_usuarioDisciplina(resultSet.getInt(7));
			lista.add(reuniao);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo para selecionar todas as reunioes do banco de dados onde o dono e o do codigo informado
	 * @return lista de reunioes resgistradas no banco onde o dono é ele
	 * @param int codigoDono
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public List<Reuniao> buscarTodos(int codigoDono) throws SQLException {
		List<Reuniao> lista = new ArrayList<Reuniao>();
		String sql = "select * from reuniao where dono = ?";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, codigoDono);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Reuniao reuniao = new Reuniao();
			reuniao.setIdReuniao(resultSet.getInt(1));
			reuniao.setDescricao(resultSet.getString(2));
			reuniao.setDataInicio(resultSet.getTimestamp(3));
			reuniao.setDono(resultSet.getInt(4));
			reuniao.setNotaMediaAula(resultSet.getDouble(5));
			reuniao.setFk_sala(resultSet.getInt(6));
			reuniao.setFk_usuarioDisciplina(resultSet.getInt(7));
			lista.add(reuniao);
		}
		comandoSql.close();
		return lista;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Metodo para selecionar todas as reunioes do banco de dados onde o usuario participou 
	 * @return lista de reunioes resgistradas no banco onde o usuario participou
	 * @param int codigo
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public List<Reuniao> buscarTodosParticipantes(int codigo) throws SQLException {
		List<Reuniao> lista = new ArrayList<Reuniao>();
		String sql = "select * from reuniao_usuario where fk_usuario = ?";
		
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
		comandoSql.setInt(1, codigo);
		ResultSet resultSet = comandoSql.executeQuery();
		
		while (resultSet.next()) {
			Reuniao reuniao = new Reuniao();
			int idReuniao = (resultSet.getInt(2));
			ReuniaoDAO reuniaoDao = new ReuniaoDAO();
			reuniao = reuniaoDao.buscarId(idReuniao);
			lista.add(reuniao);
		}
		comandoSql.close();
		return lista;
	}
	
	/**
	 * Metodo para inserir reuniao no banco de dados
	 * @param Reuniao reuniao
	 * @author Andrey
	 * @throws SQLException 
	 */	
	public void insertReuniaoGenerica(Reuniao reuniao) throws SQLException {
		String sql = "insert into reuniao (descricao, datainicio, dono, fk_sala) values (?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql);
			
		comandoSql.setString(1, reuniao.getDescricao());
		comandoSql.setTimestamp(2, (Timestamp) reuniao.getDataInicio());
		comandoSql.setInt(3, reuniao.getDono());
		comandoSql.setInt(4, reuniao.getFk_sala());
		
		comandoSql.execute();
		comandoSql.close();
	}
	
	/**
	 * Metodo para inserir reuniao no banco de dados
	 * e retorna o idReuniao gerado
	 * @param Reuniao reuniao
	 * @author Andre
	 * @return idReuniao
	 * @throws SQLException 
	 */	
	public int insertReuniaoGenericaReturnID(Reuniao reuniao) throws SQLException {
		String sql = "insert into reuniao (descricao, datainicio, dono, fk_sala) values (?, ?, ?, ?)";
		PreparedStatement comandoSql = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			
		comandoSql.setString(1, reuniao.getDescricao());
		comandoSql.setTimestamp(2, (Timestamp) reuniao.getDataInicio());
		comandoSql.setInt(3, reuniao.getDono());
		comandoSql.setInt(4, reuniao.getFk_sala());
		
		comandoSql.execute();
        ResultSet rs = comandoSql.getGeneratedKeys();
        rs.next();
        int idReuniao = rs.getInt(1);
		comandoSql.close();
		return idReuniao;
	}
}
