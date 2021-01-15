package backend.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import entidade.Usuario;
import persistencia.jdbc.UsuarioDAO;

@RestController
public class usuarioController {
	
	/**
	 * Retorna o usuário que corresponde ao id indicado
	 * @param codigo
	 * @return
	 */
	@GetMapping(path = "/api/usuario/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuario = usuarioDao.buscarPorId(codigo);
		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		return json;
	}
	
	@GetMapping(path = "/api/usuario/email/{email}")
	public String consultarPorEmail(@PathVariable("email") String email) {
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuario = usuarioDao.buscarPorEmail(email);
		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		return json;
	}
	
	/**
	 * Retorna a lista de usuarios registrados no sistema
	 * @return
	 */
	@GetMapping(path = "/api/usuarios")
	public List<Usuario> consultar(){
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		lista = usuarioDao.buscarTodos();
		return lista;
	}
	
	/**
	 * Método de exclusão do usuario que corresponde ao codigo informado 
	 * @param codigo
	 * @return
	 */
	@DeleteMapping(path = "/api/usuario/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		return usuarioDao.delete(codigo);
	}
	
	@GetMapping(path = "/api/codigo")
	public String codigo(){
		String codigo = "";
		
		int digitos[] = new int[6];
		Random sortear = new Random();
		for (int i = 0; i < digitos.length; i++) {
			digitos[i] = sortear.nextInt(10);
			codigo = codigo+digitos[i];
		}
		return codigo;
	}
	
	
	
	
}






