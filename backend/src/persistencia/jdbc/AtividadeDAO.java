package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade.Atividade;
import entidade.TurmaAtividade;

public class AtividadeDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(Atividade atividade, TurmaAtividade turmaAtividade) {
		String sql = "insert into atividade (descricao, inicioatividade, finalatividade, tipoatividade, pesonota, fk_usuario_disciplina) values (?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, atividade.getDescricao());
			comandoSql.setDate(2, (java.sql.Date) atividade.getInicioAtividade());
			comandoSql.setDate(3, (java.sql.Date) atividade.getFinalAtividadel());
			comandoSql.setInt(4, atividade.getTipoAtividade());
			comandoSql.setDouble(5, atividade.getPesoNota());
			comandoSql.setInt(6, turmaAtividade.getIdTurmaAtividade());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;	
	}
	
	public boolean update(Atividade atividade, TurmaAtividade turmaAtividade) {
		String sql = "update atividade set descricao = ?, inicioatividade = ?, finalatividade = ?, tipoatividade = ?, "
				+ "pesonota = ?, fk_usuario_disciplina  where idatividade = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, atividade.getDescricao());
			comandoSql.setDate(2, (java.sql.Date) atividade.getInicioAtividade());
			comandoSql.setDate(3, (java.sql.Date) atividade.getFinalAtividadel());
			comandoSql.setInt(4, atividade.getTipoAtividade());
			comandoSql.setDouble(5, atividade.getPesoNota());
			comandoSql.setInt(6, turmaAtividade.getIdTurmaAtividade());
			comandoSql.setInt(7, atividade.getIdAtividade());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
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
