package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Administrador;
import persistencia.jdbc.AdministradorDAO;

/**
 * Metodo controller do administrador para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class AdministradorController {
	public static final Logger LOGGER = LoggerFactory.getLogger(AdministradorController.class);
	/**
	 * Retorna a lista de administradores registrados no sistema {GET}
	 * @return lista de administradores registrados no banco
	 * @author Andrey 
	 */
	@GetMapping(path = "/api/administradores")
	public List<Administrador> consultar(){
		LOGGER.info("Requisição List<Administrador>");
		List<Administrador> lista;
		AdministradorDAO administradorDao = new AdministradorDAO();
		try {
			lista = administradorDao.buscarTodos();
			LOGGER.info("Requisição List<Administrador> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição List<Administrador> mal sucedida", e);
			return null;
		}
	}
}
