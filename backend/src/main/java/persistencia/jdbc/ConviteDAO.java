package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Convite;

public class ConviteDAO {
private Connection conexao = ConexaoFactory.getConnection();

	/**
	 * Metodo para inserir convite no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>Convite</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean insert(Convite convite) {
		String sql = "insert into convite (destinatario, salaconvite, situacaoconvite, fk_usuario) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, convite.getDestinatario());
			comandoSql.setInt(2, convite.getSalaConvite());
			comandoSql.setBoolean(3, convite.getSituacaoConvite());
			comandoSql.setInt(4, convite.getFk_usuario());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;	
	}
	
	/**
	 * Metodo para atualizar um convite no banco de dados.
	 * <p>
	 * O id da <code>Convite</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param <code>convite</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */ 
	public boolean update(Convite convite) {
		String sql = "update convite set destinatario = ?, salaconvite = ?, situacaoconvite = ?, fk_usuario = ? where idconvite = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, convite.getDestinatario());
			comandoSql.setInt(2, convite.getSalaConvite());
			comandoSql.setBoolean(3, convite.getSituacaoConvite());
			comandoSql.setInt(4, convite.getFk_usuario());
			comandoSql.setInt(5, convite.getIdConvite());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	/**
	 *  Metodo para deletar do banco de dados um convite
	 *  <p>
	 *  O <code>idConvite</code> deve ser igual ao id do banco de dados
	 * 
	 * @param <code>idConvite</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean deleteId(int idConvite) {
		String sql = "delete from convite where idconvite = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idConvite);
			
			comandoSql.execute();
			comandoSql.close();
		
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}

	/**
	 * Metodo para selecionar convite no banco de dados
	 * <p>
	 * O idCovnite deve ser igual a chamada que deseja selecionar
	 * 
	 * @param idChamada
	 * @return Chamada
	 * @author Andrey
	 */
	public Convite buscarId(int idConvite) {
		Convite convite =  new Convite();
		
		String sql = "select * from convite where idconvite = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idConvite);
			
			ResultSet resultSet = comandoSql.executeQuery();
			if (resultSet.next()) {
				convite.setIdConvite(resultSet.getInt(1));
				convite.setDestinatario(resultSet.getInt(2));
				convite.setSalaConvite(resultSet.getInt(3));
				convite.setSituacaoConvite(resultSet.getBoolean(4));
				convite.setFk_usuario(resultSet.getInt(5));
			
			}
			comandoSql.close();
			return convite;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	/**
	 * Metodo para selecionar todos os convites do banco de dados
	 * 
	 * @return List
	 * @author Andrey
	 */
	public List<Convite> buscarTodos() {
		Convite convite = new Convite();
		List<Convite> lista =  new ArrayList<Convite>();
		
		String sql = "select * from convite";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			ResultSet resultSet = comandoSql.executeQuery();
			
			while (resultSet.next()) {
				convite.setIdConvite(resultSet.getInt(1));
				convite.setDestinatario(resultSet.getInt(2));
				convite.setSalaConvite(resultSet.getInt(3));
				convite.setSituacaoConvite(resultSet.getBoolean(4));
				convite.setFk_usuario(resultSet.getInt(5));

			lista.add(convite);
			}
			comandoSql.close();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
