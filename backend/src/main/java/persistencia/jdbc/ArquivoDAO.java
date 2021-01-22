package persistencia.jdbc;

/*
 * nota para o pessoal do back, 
 * insert  = 100%
 * update  = 100%
 * delete  = 100%
 * javadoc = 80% < precisa de revisão
 */

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Arquivo;

public class ArquivoDAO {
	private Connection conexao = ConexaoFactory.getConnection();
	
	/**
	 * Metodo para inserir um <code>arquivo</code> no banco de dados
	 * 
	 * @param arquivo
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean insert(Arquivo arquivo) {
		String sql = "insert into arquivo (extensao, dataenvio, remetente, arquivo) values (?, ?, ?, ?)";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, arquivo.getExtensao());
			comandoSql.setDate(2, (Date) arquivo.getDataEnvio());
			comandoSql.setInt(3, arquivo.getRemetente());
			comandoSql.setString(4, arquivo.getCaminhoArquivo());
			
			comandoSql.execute();
			comandoSql.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		return true;	
	}
	
	/**
	 * Metodo para atualizar os dados de um arquivo no banco de dados.
	 * 
	 * O id do <code>Arquivos</code> deve ser igual ao arquivo que se deseja atualizar
	 * 
	 * @param arquivo
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean update(Arquivo arquivo) {
		String sql = "update arquivo set extensao = ?, dataenvio = ?, remetente = ?, arquivo = ? where idarquivo = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setString(1, arquivo.getExtensao());
			comandoSql.setDate(2, (Date) arquivo.getDataEnvio());
			comandoSql.setInt(3, arquivo.getRemetente());
			comandoSql.setString(4, arquivo.getCaminhoArquivo());
			comandoSql.setInt(5, arquivo.getIdArquivo());
			
			comandoSql.execute();
			comandoSql.close();
	
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo para deletar um arquivo do banco de dados
	 * 
	 * O <code>idArquivo</code> deve ser igual ao do arquivo que deseja deletar
	 * 
	 * @param idArquivo
	 * @return <code>true</code> caso seja bem sucedido o delete; <code>false</code> e um erro caso ocorra falha
	 * @author Andrey
	 */
	public boolean deleteId(int idArquivo) {
		String sql = "delete from arquivo where idarquivo = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idArquivo);
			
			comandoSql.execute();
			comandoSql.close();
		
		} catch (SQLException e) {
			return false;
		}
		
		return true;
	}
	 
	/**
	 * Metodo para selecionar um arquivo do banco de dados.
	 * 
	 * O <code>idArquivo</code> deve ser igual ao do arquivo que você quer selecionar.
	 * 
	 * @param idArquivo
	 * @return <code>Arquivo</code>
	 * @author Andrey
	 */
	public Arquivo buscarId(int idArquivo) {
		Arquivo arquivo = new Arquivo();
		
		String sql = "select * from arquivo where idarquivo = ?";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			comandoSql.setInt(1, idArquivo);
			
			ResultSet resultSet = comandoSql.executeQuery();
			if (resultSet.next()) {
				arquivo.setIdArquivo(resultSet.getInt(1));
				arquivo.setExtensao(resultSet.getString(2));
				arquivo.setDataEnvio(resultSet.getDate(3));
				arquivo.setRemetente(resultSet.getInt(4));
				arquivo.setCaminhoArquivo(resultSet.getString(5));
			
			}
			comandoSql.close();
			return arquivo;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	/**
	 * Metodo para selecionar todos os arquivos do banco de dados
	 * 
	 * @return <code>List<Arquivo></code> com todos os arquivos do banco de dados
	 * @author Andrey
	 */
	public List<Arquivo> buscarTodos() {
		Arquivo arquivo = new Arquivo(); 
		List<Arquivo> lista =  new ArrayList<Arquivo>();
		
		String sql = "select * from arquivo";
		
		try {
			PreparedStatement comandoSql = conexao.prepareStatement(sql);
			ResultSet resultSet = comandoSql.executeQuery();
			
			while (resultSet.next()) {
				arquivo.setIdArquivo(resultSet.getInt(1));
				arquivo.setExtensao(resultSet.getString(2));
				arquivo.setDataEnvio(resultSet.getDate(3));
				arquivo.setRemetente(resultSet.getInt(4));
				arquivo.setCaminhoArquivo(resultSet.getString(5));

			lista.add(arquivo);
			}
			comandoSql.close();
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
