package persistencia.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidade.Reuniao;

public class ReuniaoDAO {

	private Connection conexao = ConexaoFactory.getConnection();
	
	public boolean insert(Reuniao reuniao) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("insert into resposta (idresposta, nota, comentarioatividade, correcaoatividade, dataentrega, fk_aluno, fk_atividade) values (?, ?, ?, ?, ?, ?, ?)");
			
			comandoSql.setString(1, reuniao.getDescricao());
			comandoSql.setDate(2, (Date) reuniao.getDataInicioReuniao());
			comandoSql.setInt(3, reuniao.getDono());
			comandoSql.setDouble(4, reuniao.getNotaMediaAula());
			comandoSql.setInt(5, reuniao.getSala().getIdSala());
			comandoSql.setInt(6, reuniao.getTurmaProfessorDisciplina().getIdTurmaProfessorDisciplina());
			comandoSql.execute();
			
			comandoSql.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean update(Reuniao reuniao) {
		
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("update resposta set SET idresposta=?, nota=?, comentarioatividade=?, correcaoatividade=?, dataentrega=?, fk_aluno=?, fk_atividade=? where idresposta = ?");

			comandoSql.setString(1, reuniao.getDescricao());
			comandoSql.setDate(2, (Date) reuniao.getDataInicioReuniao());
			comandoSql.setInt(3, reuniao.getDono());
			comandoSql.setDouble(4, reuniao.getNotaMediaAula());
			comandoSql.setInt(5, reuniao.getSala().getIdSala());
			comandoSql.setInt(6, reuniao.getTurmaProfessorDisciplina().getIdTurmaProfessorDisciplina());
			
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
			
			PreparedStatement comandoSql = conexao.prepareStatement("delete from reuniao where idReuniao = ?");
			
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
	
	public Reuniao buscarId(int id) {
		Reuniao reuniao = new Reuniao();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from resposta where idreuniao = ?");
			
			comandoSql.setInt(1, id);
						
			ResultSet resultSet = comandoSql.executeQuery();
			
			if (resultSet.next()) {
				reuniao.setIdReuniao(resultSet.getInt(1));
				reuniao.setDescricao(resultSet.getString(2));
				reuniao.setDataInicioReuniao(resultSet.getDate(3));
				reuniao.setDono(resultSet.getInt(4));
				reuniao.setNotaMediaAula(resultSet.getDouble(5));
				reuniao.setSala(new SalaDAO().buscarPorId(resultSet.getInt(6)));
				reuniao.setTurmaProfessorDisciplina(new TurmaProfessorDisciplinaDAO().buscarPorId(resultSet.getInt(7)));
				return reuniao;
			}
			
			comandoSql.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Reuniao> buscarTodos() {
		List<Reuniao> lista = new ArrayList<Reuniao>();
		try {
			
			PreparedStatement comandoSql = conexao.prepareStatement("select * from Escola");
			
			ResultSet resultSet = comandoSql.executeQuery();
			comandoSql.close();
			
			while (resultSet.next()) {
				Reuniao reuniao = new Reuniao();
				reuniao.setIdReuniao(resultSet.getInt(1));
				reuniao.setDescricao(resultSet.getString(2));
				reuniao.setDataInicioReuniao(resultSet.getDate(3));
				reuniao.setDono(resultSet.getInt(4));
				reuniao.setNotaMediaAula(resultSet.getDouble(5));
				reuniao.setSala(new SalaDAO().buscarPorId(resultSet.getInt(6)));
				reuniao.setTurmaProfessorDisciplina(new TurmaProfessorDisciplinaDAO().buscarPorId(resultSet.getInt(7)));
				lista.add(reuniao);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
}
