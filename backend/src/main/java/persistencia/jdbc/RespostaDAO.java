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
	
	/**
	 * Metodo para inserir Resposta no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>Resposta</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */	
	public boolean insert(Resposta resposta) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("insert into resposta (nota, comentarioatividade, correcaoatividade, dataentrega, fk_aluno, fk_atividade) values (?, ?, ?, ?, ?, ?)");
			
			comandoSql.setDouble(1, resposta.getNota());
			comandoSql.setString(2, resposta.getComentarioAtividade());
			comandoSql.setBoolean(3, resposta.getCorrecaoAtividade());
			comandoSql.setDate(4, (Date) resposta.getDataEntrega());
			comandoSql.setInt(5, resposta.getFk_aluno());
			comandoSql.setInt(6, resposta.getFk_atividade());
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
	 * Metodo para atualizar uma Resposta no banco de dados.
	 * 
	 * O id da <code>Resposta</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param <code>Resposta</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */ 	
	public boolean update(Resposta resposta) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("update resposta set SET nota=?, comentarioatividade=?, correcaoatividade=?, dataentrega=?, fk_aluno=?, fk_atividade=? where idresposta = ?");

			comandoSql.setDouble(1, resposta.getNota());
			comandoSql.setString(2, resposta.getComentarioAtividade());
			comandoSql.setBoolean(3, resposta.getCorrecaoAtividade());
			comandoSql.setDate(4, (Date) resposta.getDataEntrega());
			comandoSql.setInt(5, resposta.getFk_aluno());
			comandoSql.setInt(6, resposta.getFk_atividade());
			comandoSql.setInt(7, resposta.getIdResposta());
			
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
	 *  Metodo para deletar do banco de dados uma Resposta
	 *  <p>
	 *  O <code>idResposta</code> deve ser igual ao id do banco de dados
	 * 
	 * @param <code>Resposta</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */	
	public boolean deleteId(int id) {
		
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
	
	/**
	 * Metodo para selecionar <code>Resposta</code> no banco de dados
	 * <p>
	 * O <code>idResposta</code> deve ser igual a Resposta que deseja selecionar
	 * 
	 * @param <code>idResposta<code>
	 * @return Resposta
	 * @author Andre
	 */	
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
				resposta.setFk_aluno(resultSet.getInt(6));
				resposta.setFk_atividade(resultSet.getInt(7));
				return resposta;
			}
			
			comandoSql.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo para selecionar todas as <code>Respostas</code> do banco de dados
	 * 
	 * @return <code>List</code>
	 * @author Andre
	 */	
	public List<Resposta> buscarTodos() {
		List<Resposta> lista = new ArrayList<Resposta>();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from Resposta");
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				Resposta resposta = new Resposta();
				resposta.setIdResposta(resultSet.getInt(1));
				resposta.setNota(resultSet.getDouble(2));
				resposta.setComentarioAtividade(resultSet.getString(3));
				resposta.setCorrecaoAtividade(resultSet.getBoolean(4));
				resposta.setDataEntrega(resultSet.getDate(5));
				resposta.setFk_aluno(resultSet.getInt(6));
				resposta.setFk_atividade(resultSet.getInt(7));
				lista.add(resposta);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
