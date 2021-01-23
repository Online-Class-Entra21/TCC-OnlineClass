package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Reuniao;

public class ReuniaoDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir Reuniao no banco de dados
	 * @param <code>Reuniao</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */	
	public boolean insert(Reuniao reuniao) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("insert into reuniao (descricao, datainicio, dono, notamediaaula, fk_sala, fk_usuario_disciplina_turma) values (?, ?, ?, ?, ?, ?)");
			
			comandoSql.setString(1, reuniao.getDescricao());
			comandoSql.setDate(2, (Date) reuniao.getDataInicio());
			comandoSql.setInt(3, reuniao.getDono());
			comandoSql.setDouble(4, reuniao.getNotaMediaAula());
			comandoSql.setInt(5, reuniao.getFk_sala());
			comandoSql.setInt(6, reuniao.getFk_usuarioDisciplina());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Metodo para atualizar uma Reuniao no banco de dados.
	 * 
	 * O id da <code>Reuniao</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param <code>Reuniao</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */ 	
	public boolean update(Reuniao reuniao) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("update reuniao set SET descricao=?, datainicio=?, dono=?, notamediaaula=?, fk_sala=?, fk_usuario_disciplina_turma=? where idreuniao = ?");

			comandoSql.setString(1, reuniao.getDescricao());
			comandoSql.setDate(2, (Date) reuniao.getDataInicio());
			comandoSql.setInt(3, reuniao.getDono());
			comandoSql.setDouble(4, reuniao.getNotaMediaAula());
			comandoSql.setInt(5, reuniao.getFk_sala());
			comandoSql.setInt(6, reuniao.getFk_usuarioDisciplina());
			comandoSql.setInt(7, reuniao.getIdReuniao());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma Reuniao
	 *  <p>
	 *  O <code>idDisciplina</code> deve ser igual ao id do banco de dados
	 * 
	 * @param <code>Reuniao</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */	
	public boolean deleteId(int id) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("delete from reuniao where idReuniao = ?");
			
			comandoSql.setInt(1, id);
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Metodo para selecionar <code>Reuniao</code> no banco de dados
	 * <p>
	 * O <code>idDisciplina</code> deve ser igual a Reuniao que deseja selecionar
	 * 
	 * @param <code>idDisciplina<code>
	 * @return Reuniao
	 * @author Andre
	 */	
	public Reuniao buscarId(int id) {
		Reuniao reuniao = new Reuniao();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from resposta where idreuniao = ?");
			
			comandoSql.setInt(1, id);
						
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				reuniao.setIdReuniao(resultSet.getInt(1));
				reuniao.setDescricao(resultSet.getString(2));
				reuniao.setDataInicio(resultSet.getDate(3));
				reuniao.setDono(resultSet.getInt(4));
				reuniao.setNotaMediaAula(resultSet.getDouble(5));
				reuniao.setFk_sala(resultSet.getInt(6));
				reuniao.setFk_usuarioDisciplina(resultSet.getInt(7));
				return reuniao;
			}
			
			comandoSql.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo para selecionar todas as <code>Reuniaos</code> do banco de dados
	 * 
	 * @return <code>List</code>
	 * @author Andre
	 */	
	public List<Reuniao> buscarTodos() {
		List<Reuniao> lista = new ArrayList<Reuniao>();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from reuniao");
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				Reuniao reuniao = new Reuniao();
				reuniao.setIdReuniao(resultSet.getInt(1));
				reuniao.setDescricao(resultSet.getString(2));
				reuniao.setDataInicio(resultSet.getDate(3));
				reuniao.setDono(resultSet.getInt(4));
				reuniao.setNotaMediaAula(resultSet.getDouble(5));
				reuniao.setFk_sala(resultSet.getInt(6));
				reuniao.setFk_usuarioDisciplina(resultSet.getInt(7));
				lista.add(reuniao);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
}
