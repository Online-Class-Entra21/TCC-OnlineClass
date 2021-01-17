package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;
import entidade.Convite;
import entidade.Turma;
import entidade.Usuario;

public class ConviteDAO {
private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(Convite convite, Usuario usuario) {
		String sql = "insert into convite (destinatario, salaconvite, situacaoconvite, fk_usuario) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, convite.getDestinatario());
			comandoSql.setInt(2, convite.getSalaConvite());
			comandoSql.setBoolean(3, convite.getSituacaoConvite());
			comandoSql.setInt(4, usuario.getIdUsuario());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;	
	}
	
	public boolean update(Convite convite, Usuario usuario) {
		String sql = "update convite set destinatario = ?, salaconvite = ?, situacaoconvite = ?, fk_usuario = ? where idconvite = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, convite.getDestinatario());
			comandoSql.setInt(2, convite.getSalaConvite());
			comandoSql.setBoolean(3, convite.getSituacaoConvite());
			comandoSql.setInt(4, usuario.getIdUsuario());
			comandoSql.setInt(5, convite.getIdConvite());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	public boolean delete(int idConvite) {
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
				
				/**
				 * Realiza a consulta por id para criar o objeto usuario
				 * apartir do fk do usuario
				 */
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarId(resultSet.getInt(5));
				convite.setRemetente(usuario.getIdUsuario());
			
			}
			comandoSql.close();
			return convite;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
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
				
				/**
				 * Realiza a consulta por id para criar o objeto usuario
				 * apartir do fk do usuario
				 */
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario usuario = usuarioDAO.buscarId(resultSet.getInt(5));
				convite.setRemetente(usuario.getIdUsuario());

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
