package backend.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	public Usuario consultar(@PathVariable("codigo") int codigo) {
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuario = usuarioDao.buscarPorId(codigo);
		return usuario;
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
}






