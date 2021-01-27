package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Coordenador;
import persistencia.jdbc.CoordenadorDAO;

/**
 * Metodo controller do coordenador para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class CoordenadorController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a lista de coordenadores registrados no sistema {GET}
	 * @return lista de coordenadores registrados no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/coordenadores")
	public List<Coordenador> consultar(){
		LOGGER.info("Requisição List<Coordenador>");
		List<Coordenador> lista;
		CoordenadorDAO coordenadorDao = new CoordenadorDAO();
		try {
			lista = coordenadorDao.buscarTodos();
			LOGGER.info("Requisição List<Coordenador> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Coordenador Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
}
