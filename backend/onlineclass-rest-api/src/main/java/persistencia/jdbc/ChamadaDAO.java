package persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Aluno;
import entidade.Chamada;
import entidade.Convite;
import entidade.Reuniao;
import entidade.Usuario;

public class ChamadaDAO {
	private Connection conexao = ConexaoFactory.getConnection();
		
		public boolean insert(Chamada chamada, Aluno aluno, Reuniao reuniao) {
			String sql = "insert into chamada (situacao, fk_aluno, fk_reuniao) values (?, ?, ?)";
			
			try {
				PreparedStatement comandoSql = conexao.prepareStatement(sql);
				comandoSql.setBoolean(1, chamada.getSituacao());
				comandoSql.setInt(2, aluno.getIdAluno());
				comandoSql.setInt(3, reuniao.getIdReuniao());
				
				comandoSql.execute();
				comandoSql.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return false;
			}
			
			return true;	
		}
		
		public boolean update(Chamada chamada, Aluno aluno, Reuniao reuniao) {
			String sql = "update chamada set situacao = ?, fk_aluno = ?, fk_reuniao = ? where idchamada = ?";
			
			try {
				PreparedStatement comandoSql = conexao.prepareStatement(sql);
				comandoSql.setBoolean(1, chamada.getSituacao());
				comandoSql.setInt(2, aluno.getIdAluno());
				comandoSql.setInt(3, reuniao.getIdReuniao());
				comandoSql.setInt(4, chamada.getIdChamada());
				
				comandoSql.execute();
				comandoSql.close();
		
			} catch (SQLException e) {
				return false;
			}
			return true;
		}
		
		public boolean delete(int idChamada) {
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
					
					/**
					 * Realiza a consulta por id para criar o objeto aluno
					 * apartir do fk do aluno
					 */
					AlunoDAO alunoDAO =  new AlunoDAO();
					Aluno aluno = alunoDAO.buscarId(resultSet.getInt(3));
					chamada.setCodAluno(aluno.getIdAluno());
					
					/**
					 * Realiza a consulta por id para criar o objeto reuniao
					 * apartir do fk da reuniao
					 */
//					ReuniaoDAO reuniaoDAO =  new ReuniaoDAO();
//					Reuniao reuniao = reuniaoDAO.buscarId(resultSet.getInt(4));
//					chamada.setCodReuniao(reuniao.getIdReuniao());
				
				}
				comandoSql.close();
				return chamada;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				return null;
			}
			
		}
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
					
					/**
					 * Realiza a consulta por id para criar o objeto aluno
					 * apartir do fk do aluno
					 */
					AlunoDAO alunoDAO =  new AlunoDAO();
					Aluno aluno = alunoDAO.buscarId(resultSet.getInt(3));
					chamada.setCodAluno(aluno.getIdAluno());
					
					/**
					 * Realiza a consulta por id para criar o objeto reuniao
					 * apartir do fk da reuniao
					 */
//					ReuniaoDAO reuniaoDAO =  new ReuniaoDAO();
//					Reuniao reuniao = reuniaoDAO.buscarId(resultSet.getInt(4));
//					chamada.setCodReuniao(reuniao.getIdReuniao());
	
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
