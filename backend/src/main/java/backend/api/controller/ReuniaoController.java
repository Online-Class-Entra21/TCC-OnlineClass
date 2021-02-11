package backend.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Reuniao;
import entidade.Usuario;
import persistencia.jdbc.ReuniaoDAO;
import persistencia.jdbc.UsuarioDAO;

/**
 * Metodo controller da reuniao para consulta no banco de dados através da API Rest
 * @author Andre
 */
@RestController
public class ReuniaoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a reuniao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping(path = "/api/reuniao/{codigo}")
	public String consultar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição Reuniao codigo {} iniciada", codigo);
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		Reuniao reuniao;
		try {
			reuniao = reuniaoDao.buscarId(codigo);
			Gson gson = new Gson();
			String json = gson.toJson(reuniao);
			LOGGER.info("Requisição Reuniao codigo {} bem sucedida",codigo);
			return json;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar Reuniao Mal Sucedida - Reuniao {} - erro - {}",codigo,e.toString());
			return null;
		}
	}
	
	/**
	 * Retorna a lista das reunioes registrados no sistema {GET}
	 * @return lista de reunioes registradas no banco
	 * @author Andre
	 */
	@GetMapping(path = "/api/reunioes")
	public List<Reuniao> consultar(){
		LOGGER.info("Requisição List<Reuniao>");
		List<Reuniao> lista;
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		try {
			lista = reuniaoDao.buscarTodos();
			LOGGER.info("Requisição List<Reuniao> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Reuniao Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
	
	/**
	 * Insere uma nova reuniao no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/reuniao/inserir/{json}")
	public boolean inserir(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Reuniao - {}",json);
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonBuilder.create();
		Reuniao reuniao = gson.fromJson(json, Reuniao.class);
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			reuniaoDAO.insertReuniaoGenerica(reuniao);
			LOGGER.info("Requisição Inserir Reuniao - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Reuniao Mal Sucedida - Reuniao {} - erro - {}",json,e.toString());
			System.out.println(reuniao.getFk_usuarioDisciplina());
			String teste = null;
			System.out.println(teste);
			return false;
		}
	}

	/**
	 * Metodo para alteração da reuniao que corresponde ao codigo informado {PUT}
	 * @param int codigo
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PutMapping(path = "api/reuniao/alterar/{codigo}/{json}")
	public boolean alterar(@PathVariable("codigo") int codigo, @PathVariable("json") String json) {
		LOGGER.info("Requisição Atualizar Reuniao - {}",json);
		Gson gson = new Gson();
		Reuniao reuniao = gson.fromJson(json, Reuniao.class);
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			reuniaoDAO.update(reuniao);
			LOGGER.info("Requisição Atualizar Reuniao - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Atualizar Reuniao Mal Sucedida - Reuniao {} - erro - {}",json,e.toString());
			return false;
		}
	}
	
	/**
	 * Método de exclusão da reuniao que corresponde ao codigo informado {DELETE}
	 * @param int codigo
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@DeleteMapping(path = "/api/reuniao/deletar/{codigo}")
	public boolean deletar(@PathVariable("codigo") int codigo) {
		LOGGER.info("Requisição para Deletar Reuniao id - {}",codigo);
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			reuniaoDAO.deleteId(codigo);
			LOGGER.info("Requisição para Deletar Reuniao id - {} - Bem Sucedida",codigo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Deletar Reuniao Mal Sucedida - Reuniao {} - erro - {}",codigo,e.toString());
			return false;
		}
	}
	
	//------------------------------------------------------------------
	//Método Extras - Fora dos 5 principais 
	//------------------------------------------------------------------
	
	/**
	 * Retorna a lista das reunioes registrados no sistema onde o dono é o id informado {GET}
	 * @return lista de reunioes registradas no banco
	 * @param int codigo
	 * @author Andre
	 */
	@GetMapping(path = "/api/reunioes/{codigo}")
	public List<Reuniao> consultarId(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição List<Reuniao> codigo dono - {}",codigo);
		List<Reuniao> lista;
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		try {
			lista = reuniaoDao.buscarTodos(codigo);
			LOGGER.info("Requisição List<Reuniao> - codigo dono - {} - bem sucedida",codigo);
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Reuniao Mal Sucedida - erro - {} - codigo dono - {}",e.toString(),codigo);
			return null;
		}
	}
	
	/**
	 * Retorna a lista das reunioes registrados no sistema onde o usuario irá participar {GET}
	 * @return lista de reunioes registradas no banco
	 * @param int codigo
	 * @author Andre
	 */
	@GetMapping(path = "/api/reunioes/participantes/{codigo}")
	public List<Reuniao> consultarPerticipanteId(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição List<Reuniao> codigo participante - {}",codigo);
		List<Reuniao> lista;
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		try {
			lista = reuniaoDao.buscarTodosParticipantes(codigo);
			LOGGER.info("Requisição List<Reuniao> - codigo participante - {} - bem sucedida",codigo);
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Reuniao Mal Sucedida - erro - {} - codigo participante - {}",e.toString(),codigo);
			return null;
		}
	}
	
	/**
	 * Insere uma nova reuniao no banco de dados {POST}
	 * @param String json
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@PostMapping(path = "api/reuniao/personalizada/inserir/{json}")
	public boolean inserirReuniaoPersonalizada(@PathVariable("json") String json) {
		LOGGER.info("Requisição Inserir Reuniao - {}",json);
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		Gson gson = gsonBuilder.create();
		Reuniao reuniao = gson.fromJson(json, Reuniao.class);
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			reuniaoDAO.insertReuniaoGenerica(reuniao);
			LOGGER.info("Requisição Inserir Reuniao - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Reuniao Mal Sucedida - Reuniao {} - erro - {}",json,e.toString());
			System.out.println(reuniao.getFk_usuarioDisciplina());
			String teste = null;
			System.out.println(teste);
			return false;
		}
	}

	/**
	 * Retorna a lista das aulas registrados no sistema {GET}
	 * @return lista de aulas registradas no banco
	 * @author Breno
	 */
	@GetMapping(path = "/api/aulas")
	public List<Reuniao> consultarAulas(){
		LOGGER.info("Requisição List<Reuniao>");
		List<Reuniao> listaReunioes;
		List<Reuniao> lista = new ArrayList<Reuniao>();
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		try {
			listaReunioes = reuniaoDao.buscarTodos();
			for (Reuniao reuniao : listaReunioes) {
				UsuarioDAO usuarioDao = new UsuarioDAO();
				Usuario usuario = usuarioDao.buscarId(reuniao.getDono());
				if(usuario.getTipoUsuario() == 4){
					lista.add(reuniao);
				}
			}
			LOGGER.info("Requisição List<Reuniao> bem sucedida");
			return lista;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Reuniao Mal Sucedida - erro - {}",e.toString());
			return null;
		}
	}
}
