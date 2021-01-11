//package persistencia.jdbc;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import entidade.Coordenador;
//
//
//public class CoordenadorDAO {
//	private Connection conexao = ConexaoFactory.getConnection();
//
//	/**
//	 * Realiza o registro de um administrador no banco de dados na tabela Usuario
//	 * O usuario cadastrado é definido como administrador a partir do tipoUsuario = 4
//	 * @param usuario
//	 * @return
//	 */
//	public boolean insert(Coordenador coordenador) {
//		String sql = "insert into usuario (nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, "
//				   + "senha, horaFinalExpediente, horaInicioExpediente, fotoUsuario, fk_endereco, "
//				   + "fk_escola) values (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
//		
//		try {
//			PreparedStatement comandoSql = conexao.prepareStatement(sql);
//			comandoSql.setString(1, coordenador.getNome());
//			comandoSql.setString(2, coordenador.getSobrenome());
//			comandoSql.setString(3, coordenador.getCpf());
//			comandoSql.setString(4, coordenador.getTelefone());
//			comandoSql.setString(5, coordenador.getCelular());
//			comandoSql.setInt(6, 2);
//			comandoSql.setString(7, coordenador.getEmail());
//			comandoSql.setString(8, coordenador.getSenha());
//			comandoSql.setTime(9, coordenador.getHorarioFinalExpediente());
//			comandoSql.setTime(10, coordenador.getHorarioInicioExpediente());
//			comandoSql.setString(11, coordenador.getFotoUsuario());
//			comandoSql.setInt(12, coordenador.getEndereco().getIdEndereco());
//			comandoSql.setInt(13, coordenador.getEscola().getIdEscola());
//			
//			comandoSql.execute(); 
//			
//			comandoSql.close(); 
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false; 
//		}
//		return true; 
//	}
//	
//	/**
//	 * Realiza atualização dos dados do administrador no banco de dados
//	 * @param usuario
//	 * @return
//	 */
//	public boolean update(Coordenador coordenador) {
//		
//		String sql = "update usuario set nome = ?, sobrenome = ?, cpf = ?, telefone = ?, celular = ?, "
//				   + "tipoUsuario = ?, email = ?, senha = ?, horaFinalExpediente = ?, horaInicioExpediente = ?, "
//				   + "fotoUsuario = ?, fk_endereco = ?, fk_escola = ? where idUsuario = ? and tipoUsuario = 2";  
//		
//		try {
//			PreparedStatement comandoSql = conexao.prepareStatement(sql);
//			comandoSql.setString(1, coordenador.getNome());
//			comandoSql.setString(2, coordenador.getSobrenome());
//			comandoSql.setString(3, coordenador.getCpf());
//			comandoSql.setString(4, coordenador.getTelefone());
//			comandoSql.setString(5, coordenador.getCelular());
//			comandoSql.setInt(6, 2);
//			comandoSql.setString(7, coordenador.getEmail());
//			comandoSql.setString(8, coordenador.getSenha());
//			comandoSql.setTime(9, coordenador.getHorarioFinalExpediente());
//			comandoSql.setTime(10, coordenador.getHorarioInicioExpediente());
//			comandoSql.setString(11, coordenador.getFotoUsuario());
//			comandoSql.setInt(12, coordenador.getEndereco().getIdEndereco());
//			comandoSql.setInt(13, coordenador.getEscola().getIdEscola());
//			comandoSql.setInt(14, coordenador.getIdUsuario());
//			
//			comandoSql.execute(); 
//			
//			comandoSql.close(); 
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false; 
//		}
//		return true; 
//	}
//	
//	/**
//	 * Realiza a exclusão dos dados de uma linha da tabela Usuario
//	 * @param idUsuario
//	 * @return
//	 */
//	public boolean delete(int idUsuario) {
//		
//		String sql = "delete from usuario where idUsuario = ? and tipoUsuario = 2"; 
//		
//		try {
//			
//			PreparedStatement comandoSql = conexao.prepareStatement(sql);
//			
//			comandoSql.setInt(1, idUsuario);
//			
//			comandoSql.execute(); 
//			
//			comandoSql.close(); 
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false; 
//		}
//		return true; 
//	}
//	
//	/**
//	 * Método de busca de todas as informações de uma linha
//	 * da tabela Usuario do banco de dados
//	 * @param idUsuario
//	 * @return
//	 */
//	public Coordenador buscarPorId(int idUsuario) {
//		Coordenador coordenador = new Coordenador();
//		
//		String sql = "select * from usuario where idUsuario = ? and tipoUsuario = 2"; 
//		
//		try {
//			PreparedStatement comandoSql = conexao.prepareStatement(sql);
//			
//			comandoSql.setInt(1, idUsuario);
//			
//			ResultSet resultSet = comandoSql.executeQuery();
//			
//			if (resultSet.next()) {
//				coordenador.setIdUsuario(resultSet.getInt(1));
//				coordenador.setNome(resultSet.getString(2));
//				coordenador.setSobrenome(resultSet.getString(3));
//				coordenador.setCpf(resultSet.getString(4));
//				coordenador.setTelefone(resultSet.getString(5));
//				coordenador.setCelular(resultSet.getString(6));
//				coordenador.setTipoUsuario(resultSet.getInt(7));
//				coordenador.setEmail(resultSet.getString(8));
//				coordenador.setSenha(resultSet.getString(9));
//				coordenador.setHorarioFinalExpediente(resultSet.getTime(10));
//				coordenador.setHorarioInicioExpediente(resultSet.getTime(11));
//				coordenador.setFotoUsuario(resultSet.getString(12));
//				
//				/**
//				 * Realiza a consulta por id para criar o objeto endereco
//				 * apartir do fk da endereco
//				 */
//	//			EnderecoDAO enderecoDao = new EnderecoDAO();
//	//			Endereco endereco = enderecoDao.buscarPorId(resultSet.getString(13));
//	//			usuario.setEndereco(endereco);
//				
//				/**
//				 * Realiza a consulta por id para criar o objeto escola
//				 * apartir do fk da escola
//				 */
//	//			EscolaDAO escolaDAO = new EscolaDAO();
//	//			Escola escola = escolaDAO.buscarPorId(resultSet.getString(14));
//	//			usuario.setEscola(escola);
//				
//				comandoSql.close(); 
//				return coordenador;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		return null; 
//	}
//	
//	/**
//	 * Retorna todos os dados listados da tabela Usuario do banco de dados 
//	 * @return
//	 */
//	public List<Coordenador> buscarTodos() {
//		
//		List<Coordenador> lista = new ArrayList<Coordenador>(); 
//		
//		String sql = "select * from usuario where tipoUsuario = 2"; 
//		
//		try {
//			PreparedStatement comandoSql = conexao.prepareStatement(sql);
//			
//			ResultSet resultSet = comandoSql.executeQuery();
//			comandoSql.close(); 
//			
//			while (resultSet.next()) {
//				Coordenador coordenador =  new Coordenador();
//				coordenador.setIdUsuario(resultSet.getInt(1));
//				coordenador.setNome(resultSet.getString(2));
//				coordenador.setSobrenome(resultSet.getString(3));
//				coordenador.setCpf(resultSet.getString(4));
//				coordenador.setTelefone(resultSet.getString(5));
//				coordenador.setCelular(resultSet.getString(6));
//				coordenador.setTipoUsuario(resultSet.getInt(7));
//				coordenador.setEmail(resultSet.getString(8));
//				coordenador.setSenha(resultSet.getString(9));
//				coordenador.setHorarioFinalExpediente(resultSet.getTime(10));
//				coordenador.setHorarioInicioExpediente(resultSet.getTime(11));
//				coordenador.setFotoUsuario(resultSet.getString(12));
//				
//				/**
//				 * Realiza a consulta por id para criar o objeto endereco
//				 * apartir do fk da endereco
//				 */
//	//			EnderecoDAO enderecoDao = new EnderecoDAO();
//	//			Endereco endereco = enderecoDao.buscarPorId(resultSet.getString(13));
//	//			usuario.setEndereco(endereco);
//				
//				/**
//				 * Realiza a consulta por id para criar o objeto escola
//				 * apartir do fk da escola
//				 */
//	//			EscolaDAO escolaDAO = new EscolaDAO();
//	//			Escola escola = escolaDAO.buscarPorId(resultSet.getString(14));
//	//			usuario.setEscola(escola);
//				lista.add(coordenador); 
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//	}	
//}
