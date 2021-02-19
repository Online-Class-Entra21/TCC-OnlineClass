
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

import entidade.Escola;
import persistencia.jdbc.EscolaDAO;

/**
 * Metodo controller da escola para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
@RequestMapping("/escolas")
public class EscolaController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a escola que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return Escola escola
	 * @author Andre
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
	public Escola consultar(@PathVariable int codigo) {
		LOGGER.info("Requisição Escola codigo {} iniciada", codigo);
		EscolaDAO escolaDAO = new EscolaDAO();
		Escola escola;
		try {
			escola = escolaDAO.buscarId(codigo);
			LOGGER.info("Requisição Escola codigo {} bem sucedida",codigo);
			return escola;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Escola Mal Sucedida - Escola {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das escolas registrados no sistema {GET}
	 * @return lista de escolas registradas no banco
	 */
	@CrossOrigin
	@GetMapping
	public List<Escola> consultar(){
		LOGGER.info("Requisição List<Escola>");
		List<Escola> lista;
		EscolaDAO escolaDao = new EscolaDAO();
		try {
			lista = escolaDao.buscarTodos();
			LOGGER.info("Requisição List<Escola> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Escola Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova escola no banco de dados {POST}
	 * @param Escola escola
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody Escola escola) {
		LOGGER.info("Requisição Inserir Escola - {}",escola);
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.insert(escola);
			LOGGER.info("Requisição Inserir Escola - {} - Bem Sucedida",escola);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Escola Mal Sucedida - Escola {} - erro - {}",escola,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração da escola que corresponde ao codigo informado {PUT}
	 * @param Escola escola
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Escola escola) {
		LOGGER.info("Requisição Atualizar Escola - {}",escola);
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.update(escola);
			LOGGER.info("Requisição Atualizar Escola - {} - Bem Sucedida",escola);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Escola Mal Sucedida - Escola {} - erro - {}",escola,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Insere uma nova escola no banco de dados só com o nome {POST}
	 * @param String json
	 * @author Andrey
	 * @return int idEscola
	 */
	@CrossOrigin
	@PostMapping("/inserir/nome")
	public int inserirNome(@RequestBody Escola escola) {
		LOGGER.info("Requisição Inserir Nome Escola - {}",escola);
		int idEscola = 0;
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			idEscola = escolaDAO.insertNome(escola);
			LOGGER.info("Requisição Inserir Nome Escola - {} - Bem Sucedida",escola);
			return idEscola;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Nome Escola Mal Sucedida - Escola {} - erro - {}",escola,e.toString());
			return idEscola;
		}
	}
	
	/**
	 * Retorna a escola que corresponde ao nome indicado {GET}
	 * @param String nome
	 * @return Escola escola
	 * @author Andrey
	 */
	@CrossOrigin
	@GetMapping("/buscar/nome/{nome}")
	public Escola consultarNome(@PathVariable("nome") String nome) {
		LOGGER.info("Requisição Escola Nome {} iniciada", nome);
		EscolaDAO escolaDAO = new EscolaDAO();
		Escola escola;
		try {
			escola = escolaDAO.buscarNome(nome);
			LOGGER.info("Requisição Escola nome {} bem sucedida",nome);
			return escola;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Escola Mal Sucedida - Escola {} - erro - {}",nome,e.toString());
			return null;
		}
	}
	
	/**
	 * Metodo para alteração da escola que corresponde ao codigo informado na visao do Adm {PUT}
	 * @param Escola escola
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping("/alterar/administrador")
	public boolean alterarAdm(@RequestBody Escola escola) {
		LOGGER.info("Requisição Atualizar Escola - {}",escola);
		EscolaDAO escolaDAO = new EscolaDAO();
		try {
			escolaDAO.updateAdm(escola);
			LOGGER.info("Requisição Atualizar Escola - {} - Bem Sucedida",escola);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Escola Mal Sucedida - Escola {} - erro - {}",escola,e.toString());
			return false;
		}
	}
}
