package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Atividade;

public class AtividadeDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir atividade no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>Atividade</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 */
	public boolean insert(Atividade atividade) {
		String sql = "insert into atividade (descricao, inicioatividade, finalatividade, tipoatividade, pesonota, fk_usuario_disciplina) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, atividade.getDescricao());
			comandoSql.setDate(2, (java.sql.Date) atividade.getInicioAtividade());
			comandoSql.setDate(3, (java.sql.Date) atividade.getFinalAtividade());
			comandoSql.setInt(4, atividade.getTipoAtividade());
			comandoSql.setDouble(5, atividade.getPesoNota());
			comandoSql.setInt(6, atividade.getFk_usuarioDisciplina());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;	
	}
	
	/**
	 * Metodo para atualizar uma atividade no banco de dados.
	 * 
	 * O id da <code>Atividade</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param atividade
	 * @param turmaAtividade
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 */ 
	public boolean update(Atividade atividade) {
		String sql = "update atividade set descricao = ?, inicioatividade = ?, finalatividade = ?, tipoatividade = ?, "
				+ "pesonota = ?, fk_usuario_disciplina  where idatividade = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, atividade.getDescricao());
			comandoSql.setDate(2, (java.sql.Date) atividade.getInicioAtividade());
			comandoSql.setDate(3, (java.sql.Date) atividade.getFinalAtividade());
			comandoSql.setInt(4, atividade.getTipoAtividade());
			comandoSql.setDouble(5, atividade.getPesoNota());
			comandoSql.setInt(6, atividade.getFk_usuarioDisciplina());
			comandoSql.setInt(7, atividade.getIdAtividade());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	/**
	 *  Metodo para deletar do banco de dados uma atividade
	 *  
	 *  O <code>idAtividade</code> deve ser igual ao id do banco de dados
	 * 
	 * @param idAtividade
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 */
	public boolean delete(int idAtividade) {
		String sql = "delete from atividade where idatividade = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idAtividade);
			
			comandoSql.execute();
			comandoSql.close();
		
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Metodo para selecionar uma atividade do banco de dados
	 * 
	 * O <code>idAtividade</code> deve ser igual ao id do banco de dados
	 * 
	 * @param idAtividade
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 */
	public Atividade buscarId(int idAtividade) {
		Atividade atividade = new Atividade();
		
		String sql = "select * from atividade where idatividade = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idAtividade);
			
			ResultSet resultSet = comandoSql.executeQuery();
			if (resultSet.next()) {
				atividade.setIdAtividade(resultSet.getInt(1));
				atividade.setDescricao(resultSet.getString(2));
				atividade.setInicioAtividade(resultSet.getDate(3));
				atividade.setFinalAtividade(resultSet.getDate(4));
				atividade.setTipoAtividade(resultSet.getInt(5));
				atividade.setPesoNota(resultSet.getDouble(6));
			
			}
			comandoSql.close();
			return atividade;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	/**
	 * Metodo para selecionar todas as atividades do banco de dados
	 * 
	 * @return <code>List</code>
	 * @author Andrey 
	 */
	public List<Atividade> buscarTodos() {
		Atividade atividade = new Atividade();
		List<Atividade> lista =  new ArrayList<Atividade>();
		
		String sql = "select * from atividade";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			ResultSet resultSet = comandoSql.executeQuery();
			
			while (resultSet.next()) {
				atividade.setIdAtividade(resultSet.getInt(1));
				atividade.setDescricao(resultSet.getString(2));
				atividade.setInicioAtividade(resultSet.getDate(3));
				atividade.setFinalAtividade(resultSet.getDate(4));
				atividade.setTipoAtividade(resultSet.getInt(5));
				atividade.setPesoNota(resultSet.getDouble(6));

			lista.add(atividade);
			}
			comandoSql.close();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
