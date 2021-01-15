package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Resposta;

public class RespostaDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(Resposta resposta) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("insert into resposta (idresposta, nota, comentarioatividade, correcaoatividade, dataentrega, fk_aluno, fk_atividade) values (?, ?, ?, ?, ?, ?, ?)");
			
			comandoSql.setDouble(1, resposta.getNota());
			comandoSql.setString(2, resposta.getComentarioAtividade());
			comandoSql.setBoolean(3, resposta.getCorrecaoAtividade());
			comandoSql.setDate(4, (Date) resposta.getDataEntrega());
			comandoSql.setInt(5, resposta.getAluno().getIdAluno());
			comandoSql.setInt(6, resposta.getCodAtividade());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean update(Resposta resposta) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("update resposta set SET idresposta=?, nota=?, comentarioatividade=?, correcaoatividade=?, dataentrega=?, fk_aluno=?, fk_atividade=? where idresposta = ?");

			comandoSql.setDouble(1, resposta.getNota());
			comandoSql.setString(2, resposta.getComentarioAtividade());
			comandoSql.setBoolean(3, resposta.getCorrecaoAtividade());
			comandoSql.setDate(4, (Date) resposta.getDataEntrega());
			comandoSql.setInt(5, resposta.getAluno().getIdAluno());
			comandoSql.setInt(6, resposta.getCodAtividade());
			
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean deleteID(int id) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("delete from resposta where idresposta = ?");
			
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
	
	public Resposta buscarId(int id) {
		Resposta resposta = new Resposta();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from resposta where idresposta = ?");
			
			comandoSql.setInt(1, id);
						
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				resposta.setIdResposta(resultSet.getInt(1));
				resposta.setNota(resultSet.getDouble(2));
				resposta.setComentarioAtividade(resultSet.getString(3));
				resposta.setCorrecaoAtividade(resultSet.getBoolean(4));
				resposta.setDataEntrega(resultSet.getDate(5));
				resposta.setAluno(new AlunoDAO().buscarId(resultSet.getInt(6)));
				resposta.setCodAtividade(resultSet.getInt(7));
				return resposta;
			}
			
			comandoSql.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Resposta> buscarTodos() {
		List<Resposta> lista = new ArrayList<Resposta>();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola");
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				Resposta resposta = new Resposta();
				resposta.setIdResposta(resultSet.getInt(1));
				resposta.setNota(resultSet.getDouble(2));
				resposta.setComentarioAtividade(resultSet.getString(3));
				resposta.setCorrecaoAtividade(resultSet.getBoolean(4));
				resposta.setDataEntrega(resultSet.getDate(5));
				resposta.setAluno(new AlunoDAO().buscarId(resultSet.getInt(6)));
				resposta.setCodAtividade(resultSet.getInt(7));
				lista.add(resposta);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
