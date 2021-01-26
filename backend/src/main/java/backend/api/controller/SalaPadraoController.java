package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.SalaPadrao;
import persistencia.jdbc.SalaPadraoDAO;

/**
 * Metodo controller da salaPadrao para consulta no banco de dados através da API Rest
 * @author Breno
 *
 */
@RestController
public class SalaPadraoController {
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	/**
	 * Retorna a lista das salasPadroes registrados no sistema {GET}
	 * @return lista de salasPadroes registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/salasPadroes")
	public List<SalaPadrao> consultar(){
		List<SalaPadrao> lista;
		SalaPadraoDAO salaPadraoDao = new SalaPadraoDAO();
		try {
			lista = salaPadraoDao.buscarTodos();
		} catch (SQLException e) {
			lista = null;
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos SalaPadrao Mal Sucedida - erro - {}",e.toString());
		}
		return lista;
	}
}
