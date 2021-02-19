package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.PeriodoAvaliacao;
import persistencia.jdbc.PeriodoAvaliacaoDAO;

/**
 * Metodo controller do periodoAvaliacao para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
@RequestMapping("/periodoAvaliacoes")
public class PeriodoAvaliacaoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o periodoAvaliacao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
	public PeriodoAvaliacao consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição PeriodoAvaliacao codigo {} iniciada", codigo);
		PeriodoAvaliacaoDAO periodoAvaliacaoDao = new PeriodoAvaliacaoDAO();
		PeriodoAvaliacao periodoAvaliacao;
		try {
			periodoAvaliacao = periodoAvaliacaoDao.buscarId(codigo);
			LOGGER.info("Requisição PeriodoAvaliacao codigo {} bem sucedida",codigo);
			return periodoAvaliacao;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar PeriodoAvaliacao Mal Sucedida - PeriodoAvaliacao {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista dos periodosAvaliacoes registrados no sistema {GET}
	 * @return lista de periodosAvaliacoes registrados no banco
	 * @author Andre
	 */
	@CrossOrigin
	@GetMapping
	public List<PeriodoAvaliacao> consultar(){
		LOGGER.info("Requisição List<PeriodoAvaliacao>");
		List<PeriodoAvaliacao> lista;
		PeriodoAvaliacaoDAO periodoAvaliacaoDao = new PeriodoAvaliacaoDAO();
		try {
			lista = periodoAvaliacaoDao.buscarTodos();
			LOGGER.info("Requisição List<PeriodoAvaliacao> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos PeriodoAvaliacao Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere um novo periodoAvaliacao no banco de dados {POST}
	 * @param PeriodoAvaliacao periodoAvaliacao
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody PeriodoAvaliacao periodoAvaliacao) {
		Gson gson = new Gson();
		String json = gson.toJson(periodoAvaliacao);
		LOGGER.info("Requisição Inserir PeriodoAvaliacao - {}",json);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.insert(periodoAvaliacao);
			LOGGER.info("Requisição Inserir PeriodoAvaliacao - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir PeriodoAvaliacao Mal Sucedida - PeriodoAvaliacao {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do periodoAvaliacao que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @author Andre
	 * @param PeriodoAvaliacao periodoAvaliacao
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping
	public boolean  alterar(@RequestBody PeriodoAvaliacao periodoAvaliacao) {
		Gson gson = new Gson();
		String json = gson.toJson(periodoAvaliacao);
		LOGGER.info("Requisição Atualizar PeriodoAvaliacao - {}",json);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.update(periodoAvaliacao);
			LOGGER.info("Requisição Atualizar PeriodoAvaliacao - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar PeriodoAvaliacao Mal Sucedida - PeriodoAvaliacao {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do periodoAvaliacao que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@DeleteMapping("/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar PeriodoAvaliacao id - {}",codigo);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar PeriodoAvaliacao id - {} - Bem Sucedida",codigo);
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar PeriodoAvaliacao Mal Sucedida - PeriodoAvaliacao {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Retorna a lista dos periodosAvaliacoes registrados no sistema na escola informada {GET}
	 * @return lista de periodosAvaliacoes registrados no banco na escola informada
	 * @param int fk_escola
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/escola/{fk_escola}")
	public List<PeriodoAvaliacao> consultarEscola(@PathVariable("fk_escola") int fk_escola){
		LOGGER.info("Requisição List<PeriodoAvaliacao>");
		List<PeriodoAvaliacao> lista;
		PeriodoAvaliacaoDAO periodoAvaliacaoDao = new PeriodoAvaliacaoDAO();
		try {
			lista = periodoAvaliacaoDao.buscarTodosEscola(fk_escola);
			LOGGER.info("Requisição List<PeriodoAvaliacao> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos PeriodoAvaliacao Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Método de exclusão do periodoAvaliacao que corresponde ao fk_escola informado {DELETE}
	 * @param int fk_escola
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@DeleteMapping("/escola/{fk_escola}")
	public boolean deletarFk(@PathVariable("fk_escola") int fk_escola) {
		LOGGER.info("Requisição para Deletar PeriodoAvaliacao fk_escola - {}",fk_escola);
		PeriodoAvaliacaoDAO periodoAvaliacaoDAO = new PeriodoAvaliacaoDAO();
		try {
			periodoAvaliacaoDAO.deleteFk(fk_escola);
			LOGGER.info("Requisição para Deletar PeriodoAvaliacao fk_escola - {} - Bem Sucedida",fk_escola);
			return true;	
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar PeriodoAvaliacao Mal Sucedida - fk_escola {} - erro - {}",fk_escola,e.toString());
			return false;
		}
	}
}
