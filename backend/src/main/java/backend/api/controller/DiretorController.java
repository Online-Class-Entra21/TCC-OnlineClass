package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import entidade.Diretor;
import persistencia.jdbc.DiretorDAO;

/**
 * Metodo controller do diretor para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
public class DiretorController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a lista de diretores registrados no sistema {GET}
	 * @return lista de diretores registrados no banco
	 * @author Andrey
	 */
	@GetMapping(path = "/api/diretores")
	public List<Diretor> consultar(){
		LOGGER.info("Requisição List<Diretor>");
		List<Diretor> lista;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			lista = diretorDao.buscarTodos();
			LOGGER.info("Requisição List<Diretor> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Diretor Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora do principal
	//------------------------------------------------------------------
	
	/**
	 * Retorna o diretor que comanda o a escola com o fk informado atrvés dos parametros {GET}
	 * @param codigo
	 * @return String json 
	 */
	@GetMapping(path = "/api/diretor/escola/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição Diretor codigo {} iniciada", codigo);
		Diretor diretor;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretor = diretorDao.buscarDiretorEscola(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(diretor);
			LOGGER.info("Requisição Diretor codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Diretor Mal Sucedida - Diretor {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
}
