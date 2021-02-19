package backend.api.controller;

import java.sql.SQLException;
import java.util.List;

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

import com.google.gson.Gson;

import entidade.Endereco;
import persistencia.jdbc.EnderecoDAO;

/**
 * Metodo controller do endereco para consulta no banco de dados através da API Rest
 * @author Andre
 *
 */
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna o endereco que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return Endereco endereco
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@GetMapping("/{codigo}")
	public Endereco consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Endereco codigo {} iniciada", codigo);
		EnderecoDAO enderecoDao = new EnderecoDAO();
		Endereco endereco;
		try {
			endereco = enderecoDao.buscarId(codigo);
			LOGGER.info("Requisição Endereco codigo {} bem sucedida",codigo);
			return endereco;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Endereco Mal Sucedida - Endereco {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista de enderecos registrados no sistema {GET}
	 * @return lista de enderecos registrados no banco
	 * @author Andre
	 */
	@CrossOrigin
	@GetMapping
	public List<Endereco> consultar() {
		LOGGER.info("Requisição List<Endereco>");
		List<Endereco> lista;
		EnderecoDAO enderecoDao = new EnderecoDAO();
		try {
			lista = enderecoDao.buscarTodos();
			LOGGER.info("Requisição List<Endereco> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Endereco Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}

	/**
	 * Insere um novo endereco no banco de dados {POST}
	 * @param Endereco endereco
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody Endereco endereco) {
		Gson gson = new Gson();
		String json = gson.toJson(endereco);
		LOGGER.info("Requisição Inserir Endereco - {}",json);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			enderecoDAO.insert(endereco);
			LOGGER.info("Requisição Inserir Endereco - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Endereco Mal Sucedida - Endereco {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Metodo para alteração do endereco que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param Endereco endereco
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Endereco endereco) {
		Gson gson = new Gson();
		String json = gson.toJson(endereco);
		LOGGER.info("Requisição Atualizar Endereco - {}",json);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			enderecoDAO.update(endereco);
			LOGGER.info("Requisição Atualizar Endereco - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Endereco Mal Sucedida - Endereco {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão do endereco que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@DeleteMapping("/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Endereco id - {}",codigo);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			enderecoDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Endereco id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Endereco Mal Sucedida - Endereco {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Insere um novo endereco no banco de dados {POST}
	 * @param Endereco endereco
	 * @author Breno
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping("/return")
	public int inserirReturn(@RequestBody Endereco endereco) {
		Gson gson = new Gson();
		String json = gson.toJson(endereco);
		LOGGER.info("Requisição Inserir Endereco - {}",json);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			int idEndereco = enderecoDAO.insertReturnID(endereco);
			System.out.println(idEndereco);
			LOGGER.info("Requisição Inserir Endereco - {} - Bem Sucedida",json);
			return idEndereco;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Endereco Mal Sucedida - Endereco {} - erro - {}",json,e.toString());
			return 0;
		}
	}
	
	/**
	 * Verifica se existe alguem endereco identico no
	 * banco e Insere um novo endereco no banco de dados
	 * caso nao tenha um igual ou retorna o id do enderco
	 * ja existente
	 * 
	 * @param Endereco endereco
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping("/inserirAlterar")
	public int inserirAlterar(@RequestBody Endereco endereco) {
		Gson gson = new Gson();
		String json = gson.toJson(endereco);
		LOGGER.info("Requisição InserirAlterar Endereco - {}",json);
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			int idEndereco = enderecoDAO.buscarIgual(endereco);
			if (idEndereco==0) {
				idEndereco = enderecoDAO.insertReturnID(endereco);
			}
			LOGGER.info("Requisição Inserir Endereco - {} - Bem Sucedida",json);
			return idEndereco;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para InserirAlterar Endereco Mal Sucedida - Endereco {} - erro - {}",json,e.toString());
			return 0;
		}
	}
}
