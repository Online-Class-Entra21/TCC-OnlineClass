package backend.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
public class UsuarioController {
	
	/**
	 * Retorna o usuário que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 */
	@GetMapping(path = "/api/usuario/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarId(codigo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			usuario = null;
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		return json;
	}
	
	/**
	 * Retorna a lista de usuarios registrados no sistema {GET}
	 * @return lista de usuarios registrados no banco
	 */
	@GetMapping(path = "/api/usuarios")
	public List<Usuario> consultar(){
		List<Usuario> lista;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			lista = usuarioDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Insere uma novo usuário no banco de dados {POST}
	 * @param String json
	 */
	@PostMapping(path = "api/usuario/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json.toString(), Usuario.class);
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuarioDao.insert(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo para alteração do usuario que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 */
	@PutMapping(path = "api/usuario/alterar/{json}")
	public boolean alterar(@PathVariable("json") String json) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json.toString(), Usuario.class);
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuarioDao.update(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * Método de exclusão do usuario que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 */
	@DeleteMapping(path = "/api/usuario/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuarioDao.deleteId(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Retorna o usuário que corresponde ao email indicado {GET}
	 * @param String email
	 * @return String json 
	 */
	@GetMapping(path = "/api/usuario/email/{email}")
	public String consultarEmail(@PathVariable("email") String email) {
		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
			usuario = null;
		}
		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		return json;
	}
	
	/**
	 * Verifica se o usuario existe no banco de dados  {GET}
	 * @param String email
	 * @return boolean situacao de existencia do usuario
	 */
	@GetMapping(path = "api/verificar/{email}")
	public boolean verificarEmail(@PathVariable("email") String email) {
		Usuario usuario;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
			usuario = null;
		}
		if(usuario != null) {
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
	@GetMapping(path = "/api/codigo/{email}")
	public String codigo(@PathVariable("email") String email){
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return codigo;
	}
	
	/**
	 * Metodo para mudar a senha do usuario informado {PUT}
	 * @param String email
	 * @param String senha
	 */
	@PutMapping(path = "/api/mudar/senha/{email}/{senha-digitada}")
	public boolean mudarSenha(@PathVariable("email") String email, @PathVariable("senha-digitada") String senha) {
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		try {
			usuario = usuarioDao.buscarEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		usuario.setSenha(senha);
		try {
			usuarioDao.update(usuario);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

