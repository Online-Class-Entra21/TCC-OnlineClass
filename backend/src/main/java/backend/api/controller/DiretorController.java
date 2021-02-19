package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/diretores")
public class DiretorController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a lista de diretores registrados no sistema {GET}
	 * @return lista de diretores registrados no banco
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping
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
	
	/**
	 * Insere uma novo usuário diretor no banco de dados {POST}
	 * @param Diretor diretor
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody Diretor diretor) {
		Gson gson = new Gson();
		String json = gson.toJson(diretor);
		LOGGER.info("Requisição Inserir Usuario - {}",json);
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretorDao.insert(diretor);
			LOGGER.info("Requisição Inserir Usuario - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Usuario Mal Sucedida - Usuario {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Metodo para alteração do diretor que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param Diretor diretor
	 * @return boolean situacao da operacao
	 * @author Breno
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Diretor diretor) {
		Gson gson = new Gson();
		String json = gson.toJson(diretor);
		LOGGER.info("Requisição Atualizar Diretor - {}",json);
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretorDao.update(diretor);
			LOGGER.info("Requisição Atualizar Diretor - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Diretor Mal Sucedida - Diretor {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 3 principal
	//------------------------------------------------------------------
	
	/**
	 * Retorna o diretor que comanda o a escola com o fk informado atrvés dos parametros {GET}
	 * @param codigo
	 * @return lista de diretores na escola indicada 
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping("/escola/{codigo}")
	public Diretor consultar(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição Diretor codigo {} iniciada", codigo);
		Diretor diretor;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			diretor = diretorDao.buscarDiretorEscola(codigo);
			LOGGER.info("Requisição Diretor codigo {} bem sucedida",codigo);
			return diretor;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Diretor Mal Sucedida - Diretor {} - erro - {}",codigo,e.toString());
			return null;
		}
	}

	/**
	 * Metodo para consulta da quantidade de diretores no sistema 
	 * @return int qtdDiretores
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/quantidade")
	public int buscarQuantidade() {
		LOGGER.info("Requisição quantidade de diretores");
		int qtdDiretores;
		DiretorDAO diretorDao = new DiretorDAO();
		try {
			qtdDiretores = diretorDao.buscarQuantidadeDiretores();
			LOGGER.info("Requisição quantidade de diretores bem sucedida");
			return qtdDiretores;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar da quantidade de diretores Mal Sucedida - erro - {}",e.toString());
			return 0;
		}
	}
}
