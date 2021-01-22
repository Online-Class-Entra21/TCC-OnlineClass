package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Chamada;

public class ChamadaDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir chamamada no banco de dados.
	 * <p>
	 * O idChamada sera gerado pelo banco de dados.
	 * 
	 * @param chamada
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean insert(Chamada chamada) {
		String sql = "insert into chamada (situacao, fk_aluno, fk_reuniao) values (?, ?, ?)";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setBoolean(1, chamada.getSituacao());
			comandoSql.setInt(2, chamada.getFk_aluno());
			comandoSql.setInt(3, chamada.getFk_reuniao());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;	
	}
	/**
	 * Metodo para atualizar chamado no banco de dados
	 * <p>
	 * O idChamada deve ser igual ao id da chamada que se deseja atualizar
	 * 
	 * @param chamada
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean update(Chamada chamada) {
		String sql = "update chamada set situacao = ?, fk_aluno = ?, fk_reuniao = ? where idchamada = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setBoolean(1, chamada.getSituacao());
			comandoSql.setInt(2, chamada.getFk_aluno());
			comandoSql.setInt(3, chamada.getFk_reuniao());
			comandoSql.setInt(4, chamada.getIdChamada());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo para deletar chamada do banco de dados
	 * 
	 * o id deve ser igual ao id do banco de dados
	 * 
	 * @param idChamada
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean deleteId(int idChamada) {
		String sql = "delete from chamada where idchamada = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idChamada);
			
			comandoSql.execute();
			comandoSql.close();
		
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Metodo para selecionar chamada no banco de dados
	 * <p>
	 * O idChamada deve ser igual a chamada que deseja selecionar
	 * 
	 * @param idChamada
	 * @return Chamada
	 * @author Andrey
	 */
	public Chamada buscarId(int idChamada) {
		Chamada chamada = new Chamada();
		
		String sql = "select * from chamada where idchamada = ?";
		
		try {
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}

	/**
	 * Metodo para selecionar todas as chamadas do banco de dados
	 * 
	 * @return List
	 * @author Andrey
	 */
	public List<Chamada> buscarTodos() {
		Chamada chamada = new Chamada();
		List<Chamada> lista =  new ArrayList<Chamada>();
		
		String sql = "select * from chamada";
		
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
