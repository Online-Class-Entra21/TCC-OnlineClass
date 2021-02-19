package backend.api.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import entidade.Usuario;
import persistencia.jdbc.UsuarioDAO;

/**
 * Metodo controller do usuario para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
@RequestMapping("usuarios")
public class UsuarioController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o usuário que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Usuario codigo {} iniciada", codigo);
		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(usuario);
			LOGGER.info("Requisição Usuario codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Usuario Mal Sucedida - Usuario {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista de usuarios registrados no sistema {GET}
	 * @return lista de usuarios registrados no banco
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping()
	public List<Usuario> consultar(){
		LOGGER.info("Requisição List<Usuario>");
		List<Usuario> lista;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			lista = usuarioDao.buscarTodos();
			LOGGER.info("Requisição List<Usuario> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Usuario Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma novo usuário no banco de dados {POST}
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/usuario/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Usuario - {}",json);
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json.toString(), Usuario.class);
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuarioDao.insert(usuario);
			LOGGER.info("Requisição Inserir Usuario - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Usuario Mal Sucedida - Usuario {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Metodo para alteração do usuario que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/usuario/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Usuario - {}",json);
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json.toString(), Usuario.class);
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			System.out.println("");
			System.out.println("");
			System.out.println("");
			System.out.println(usuario.getHorarioFinalExpediente());
			System.out.println(usuario.getHorarioInicioExpediente());
			System.out.println("");
			System.out.println("");
			System.out.println("");
			usuarioDao.update(usuario);
			LOGGER.info("Requisição Atualizar Usuario - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Usuario Mal Sucedida - Usuario {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do usuario que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@DeleteMapping("/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Usuario id - {}",codigo);
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuarioDao.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Usuario id - {} - Bem Sucedida",codigo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Usuario Mal Sucedida - Usuario {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Retorna o usuário que corresponde ao email indicado {GET}
	 * @param String email
	 * @return String json 
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{email}")
	public String consultarEmail(@PathVariable("email") String email) {
		LOGGER.info("Requisição Usuario email - {}",email);
		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarEmail(email);
			Gson gson = new Gson();
			String json = gson.toJson(usuario);
			LOGGER.info("Requisição Usuario email - {} - Bem Sucedida",email);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Usuario por Email Mal Sucedida - Email do Usuario {} - erro - {}",email,e.toString());
			return null;
		}
	}
	
	/**
	 * Verifica se o usuario existe no banco de dados  {GET}
	 * @param String email
	 * @return boolean situacao de existencia do usuario
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{email}")
	public boolean verificarEmail(@PathVariable("email") String email) {
		LOGGER.info("Requisição de verificação Usuario por email - {}",email);
		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
			usuario = null;
			LOGGER.error("Requisição de verificação Usuario por Email Mal Sucedida - Email do Usuario {} - erro - {}",email,e.toString());
		}
		if(usuario.getIdUsuario() != 0) {
			LOGGER.info("Requisição de verificação Usuario por email - {} - Bem Sucedida",email);
			return true;
		}
		return false;
	}
	
	/**
	 * Envia um código de verificação via e-mail ao usuário {GET}
	 * @param String email
	 * @return Strinf codigo
	 * @author Andre
	 */
	@CrossOrigin
	@GetMapping("/{email}")
	public String codigo(@PathVariable("email") String email){
		LOGGER.info("Requisição de código de recuperação de senha por email - {}",email);
		String codigo = "";
		
		int digitos[] = new int[6];
		Random sortear = new Random();
		for (int i = 0; i < digitos.length; i++) {
			digitos[i] = sortear.nextInt(10);
			codigo = codigo+digitos[i];
		}
		
		String nossoEmail = "suporteonlineclass@gmail.com";
		String nossaSenha = "aabir1029384756";
		
		SimpleEmail emailCon = new SimpleEmail();
		emailCon.setHostName("smtp.gmail.com");
		emailCon.setSmtpPort(465);
		emailCon.setAuthenticator(new DefaultAuthenticator(nossoEmail, nossaSenha));
		emailCon.setSSLOnConnect(true);
		
		try {
			emailCon.setFrom(nossoEmail);
			emailCon.setSubject("Codigo Verificação");
			emailCon.setMsg("Seu codigo de Verificação é '"+codigo+"' use esse codigo para alterar sua senha no site");
			emailCon.addTo(email);
			emailCon.send();
			LOGGER.info("Requisição de código de recuperação de senha por email - {} - Bem Sucedida",email);
			return codigo;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição de código de recuperação de senha por email Mal Sucedida - Email do Usuario {} - erro - {}",email,e.toString());
			return null;
		}
	}
	
	/**
	 * Metodo para mudar a senha do usuario informado {PUT}
	 * @param String email
	 * @param String senha
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "/api/mudar/senha/{email}/{senha-digitada}")
	public boolean mudarSenha(@PathVariable("email") String email, @PathVariable("senha-digitada") String senha) {
		LOGGER.info("Requisição de mudança de senha email - {} - senha - {}",email,senha);
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.info("Requisição de mudança de senha email Mal Sucedida - Email do Usuario {} - senha {} - erro - {}",email,senha,e.toString());
			return false;
		}
		usuario.setSenha(senha);
		try {
			usuarioDao.update(usuario);
			LOGGER.info("Requisição de mudança de senha email - Bem Sucedida - Email do Usuario {} - senha {}",email,senha);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.info("Requisição de mudança de senha email Mal Sucedida - Email do Usuario {} - senha {} - erro - {}",email,senha,e.toString());
			return false;
		}
	}

	/**
	 * Verifica se o usuario existe no banco de dados  {GET}
	 * @param String cpf
	 * @return boolean situacao de existencia do usuario
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/{cpf}")
	public boolean verificarCpf(@PathVariable("cpf") String cpf) {
		LOGGER.info("Requisição de verificação Usuario por cpf - {}",cpf);
		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarCpf(cpf);
		} catch (SQLException e) {
			e.printStackTrace();
			usuario = null;
			LOGGER.error("Requisição de verificação Usuario por Cpf Mal Sucedida - Cpf do Usuario {} - erro - {}",cpf,e.toString());
		}
		if(usuario.getIdUsuario() != 0) {
			LOGGER.info("Requisição de verificação Usuario por cpf - {} - Bem Sucedida",cpf);
			return true;
		}
		return false;
	}
	
	/**
	 * Insere um novo usuario no banco de dados {POST}
	 * e retorna o idUsuario gerado
	 * @param String json
	 * @author Andrey
	 * @return int idUsuario
	 */
	@PostMapping(path = "api/usuario/inserir/return/{json}")
	public int inserirReturn(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Usuario - {}",json);
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		try {
			int idUsuario = usuarioDAO.insertReturnID(usuario);
			LOGGER.info("Requisição Inserir Usuario - {} - Bem Sucedida",json);
			return idUsuario;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Usuario Mal Sucedida - Usuario {} - erro - {}",json,e.toString());
			return 0;
		}
	}
	
	/**
	 * Metodo para alteração do usuario que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Andrey
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/usuario/alterar/aluno/{json}")
	public boolean alterarUsuarioAluno(@PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Usuario - {}",json);
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json.toString(), Usuario.class);
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuarioDao.updateUsuarioAluno(usuario);
			LOGGER.info("Requisição Atualizar Usuario - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Usuario Mal Sucedida - Usuario {} - erro - {}",json,e.toString());
			return false;
		}
	}
}

