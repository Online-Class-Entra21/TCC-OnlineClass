package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import entidade.Coordenador;
import persistencia.jdbc.CoordenadorDAO;
/**
 * Metodo controller do coordenador para consulta no banco de dados através da API Rest
 * @author Andrey
 *
 */
@RestController
@RequestMapping("/coordenadores")
public class CoordenadorController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a lista de coordenadores registrados no sistema {GET}
	 * @return lista de coordenadores registrados no banco
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping
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
	
	//------------------------------------------------------------------
	//Método Extras - Fora do principal
	//------------------------------------------------------------------
		
	/**
	 * Metodo para consulta da quantidade de coordenadores no sistema 
	 * @return int qtdCoordenadores
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/quantidade")
	public int buscarQuantidade() {
		LOGGER.info("Requisição quantidade de coordenadores");
		int qtdCoordenadores;
		CoordenadorDAO coordenadorDao = new CoordenadorDAO();
		try {
			qtdCoordenadores = coordenadorDao.buscarQuantidadeCoordenadores();
			LOGGER.info("Requisição quantidade de coordenadores bem sucedida");
			return qtdCoordenadores;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar da quantidade de coordenadores Mal Sucedida - erro - {}",e.toString());
			return 0;
		}
	}
	
	/**
	 * Retorna o coordenador que corresponde ao id da escola indicado {GET}
	 * @param int codigo escola
	 * @return lista de coordenadores do sistema naquela escola 
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping("/escola/{codigo}")
	public List<Coordenador> consultarEscola(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição List<Coordenador> pelo id escola");
		List<Coordenador> lista;
		CoordenadorDAO coordenadorDao = new CoordenadorDAO();
		try {
			lista = coordenadorDao.buscarEscola(codigo);
			LOGGER.info("Requisição List<Coordenador> pelo id escola bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Coordenador pelo id escola Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Metodo para alteração do coordenador que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param Coordenador coordenador
	 * @return boolean situacao da operacao
	 * @author Breno
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Coordenador coordenador) {
		Gson gson = new Gson();
		String json = gson.toJson(coordenador);
		LOGGER.info("Requisição Atualizar Coordenador - {}",json);
		CoordenadorDAO coordenadorDao = new CoordenadorDAO();
		try {
			coordenadorDao.update(coordenador);
			LOGGER.info("Requisição Atualizar Coordenador - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Coordenador Mal Sucedida - Coordenador {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
}
