package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Escola;

public class EscolaDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir Disciplina no banco de dados.
	 * 
	 * O id sera gerado pelo banco de dados ou seja sera diferente do objeto.
	 * 
	 * @param <code>Disciplina</code>
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */	
	public boolean insert(Escola escola) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("insert into escola (nome, datainicioletivo, datafinalletivo) values (?,?,?)");
			
			comandoSql.setString(1, escola.getNome());
			comandoSql.setDate(2, (Date) escola.getDataInicioLetivo());
			comandoSql.setDate(3, (Date) escola.getDataFinalLetivo());
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
	 * Metodo para atualizar uma Disciplina no banco de dados.
	 * 
	 * O id da <code>Disciplina</code> deve ser o mesmo id que esta no banco de dados.
	 * 
	 * @param Disciplina
	 * @param turmaDisciplina
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */ 	
	public boolean update(Escola escola) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("update escola set nome = ?, datainicioletivo = ?, datafinalletivo = ? where idescola = ?");
			
			comandoSql.setString(1, escola.getNome());
			comandoSql.setDate(2, (Date) escola.getDataInicioLetivo());
			comandoSql.setDate(3, (Date) escola.getDataFinalLetivo());
			comandoSql.setInt(4, escola.getIdEscola());
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
	 *  Metodo para deletar do banco de dados uma Disciplina
	 *  <p>
	 *  O <code>idDisciplina</code> deve ser igual ao id do banco de dados
	 * 
	 * @param idDisciplina
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andre
	 */	
	public boolean deleteId(int id) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("delete from escola where idescola = ?");
			
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
	 * Metodo para selecionar chamada no banco de dados
	 * <p>
	 * O idChamada deve ser igual a chamada que seseja selecionar
	 * 
	 * @param idChamada
	 * @return Chamada
	 * @author Andre
	 */	
	public Escola buscarId(int id) {
		Escola escola = new Escola();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola where idescola = ?");
			
			comandoSql.setInt(1, id);
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				escola.setIdEscola(resultSet.getInt(1));
				escola.setNome(resultSet.getString(2));
				escola.setDataInicioLeitvo(resultSet.getDate(3));
				escola.setDataFinalLetivo(resultSet.getDate(4));
				return escola;
			}
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Metodo para selecionar todas as chamadas do banco de dados
	 * 
	 * @return List
	 * @author Andre
	 */	
	public List<Escola> buscarTodos() {
		List<Escola> lista = new ArrayList<Escola>();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola");
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				Escola escola = new Escola();
				escola.setIdEscola(resultSet.getInt(1));
				escola.setNome(resultSet.getString(2));
				escola.setDataInicioLeitvo(resultSet.getDate(3));
				escola.setDataFinalLetivo(resultSet.getDate(4));
				lista.add(escola);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	
	
	
}
