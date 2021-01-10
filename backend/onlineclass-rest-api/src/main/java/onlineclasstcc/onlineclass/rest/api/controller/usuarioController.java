package onlineclasstcc.onlineclass.rest.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import entidade.Usuario;
import persistencia.jdbc.UsuarioDAO;

@RestController
public class usuarioController {
	
	@GetMapping(path = "/api/usuario/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuario = usuarioDao.buscarPorId(codigo);
		return usuario.getNome();
	}
}
