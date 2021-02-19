package backend.api.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import backend.api.controller.DTO.UsuarioDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import entidade.Reuniao;
import entidade.Usuario;
import persistencia.jdbc.ReuniaoDAO;
import persistencia.jdbc.UsuarioDAO;

/**
 * Metodo controller da reuniao para consulta no banco de dados através da API Rest
 * @author Andre
 */
@RestController
@RequestMapping("reunioes")
public class ReuniaoController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	
	/**
	 * Retorna a reuniao que corresponde ao id indicado {GET}
	 * @param int codigo
	 * @return String json
	 * @author Andre
	 */
	@GetMapping("/{codigo}")
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
	@GetMapping
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
	 * @param Reuniao reuniao
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping
	public boolean inserir(@RequestBody Reuniao reuniao) {
		Gson gson = new Gson();
		String json = gson.toJson(reuniao);
		LOGGER.info("Requisição Inserir Reuniao - {}",json);
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
	 * @param Reuniao reuniao
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PutMapping
	public boolean alterar(@RequestBody Reuniao reuniao) {
		Gson gson = new Gson();
		String json = gson.toJson(reuniao);
		LOGGER.info("Requisição Atualizar Reuniao - {}",json);
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
	@CrossOrigin
	@DeleteMapping("/{codigo}")
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
	@CrossOrigin
	@GetMapping("/dono/{codigo}")
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
	@CrossOrigin
	@GetMapping("/participantes/{codigo}")
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
	 * @param Reuniao reuniao
	 * @author Andre
	 * @return boolean situacao da operacao
	 */
	@CrossOrigin
	@PostMapping("/personalizada")
	public boolean inserirReuniaoPersonalizada(@RequestBody Reuniao reuniao) {
		Gson gson = new Gson();
		String json = gson.toJson(reuniao);
		LOGGER.info("Requisição Inserir Reuniao - {}",json);
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			reuniaoDAO.insertReuniaoGenerica(reuniao);
			LOGGER.info("Requisição Inserir Reuniao - {} - Bem Sucedida",json);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Reuniao Mal Sucedida - Reuniao {} - erro - {}",json,e.toString());
			return false;
		}
	}

	/**
	 * Retorna a lista das aulas registrados no sistema {GET}
	 * @return lista de aulas registradas no banco
	 * @param int codigo 
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/aulas/{codigo}")
	public List<Reuniao> consultarAulas(@PathVariable("codigo") int codigo){
		LOGGER.info("Requisição List<Reuniao>");
		List<Reuniao> listaReunioes;
		List<Reuniao> lista = new ArrayList<Reuniao>();
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		try {
			listaReunioes = reuniaoDao.buscarTodosParticipantes(codigo);
			for (Reuniao reuniao : listaReunioes) {
				System.out.println(reuniao.getDono());
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
	
	/**	 
	 * Insere uma nova reuniao no banco de dados {POST}
	 * @param Reuniao reuniao
	 * @author Andre
	 * @return int idReuniao
	 */
	@CrossOrigin
	@PostMapping("/personalizada/return")
	public int inserirReturnID(@RequestBody Reuniao reuniao) {
		Gson gson = new Gson();
		String json = gson.toJson(reuniao);
		LOGGER.info("Requisição Inserir Reuniao - {}",json);
		ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
		try {
			int idReuniao = reuniaoDAO.insertReuniaoGenericaReturnID(reuniao);
			LOGGER.info("Requisição Inserir Reuniao - {} - Bem Sucedida",json);
			return idReuniao;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Inserir Reuniao Mal Sucedida - Reuniao {} - erro - {}",json,e.toString());
			return 0;
		}
	}
	
	/**
	 * Retorna a lista de usuarios registrados no sistema que participam da reuniao  {GET}
	 * @return lista de usuarios registrados no banco que participam da reuniao
	 * @param int idReuniao
	 * @author Breno
	 */
	@CrossOrigin
	@GetMapping("/usuarios/participantes/{idReuniao}")
	public List<UsuarioDTO> consultarParticipantes(@PathVariable("idReuniao") int idReuniao){
		LOGGER.info("Requisição List<Usuario> idReuniao - {}",idReuniao);
		List<Usuario> lista;
		ReuniaoDAO reuniaoDao = new ReuniaoDAO();
		try {
			lista = reuniaoDao.buscarTodosParticipantesReuniao(idReuniao);
			LOGGER.info("Requisição List<Usuario> bem sucedida idReuniao - {}",idReuniao);
			List<UsuarioDTO> listaDTO = UsuarioDTO.converter(lista);
			return listaDTO;
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.error("Requisição para Consultar todos Usuario idReuniao - {} Mal Sucedida - erro - {}",idReuniao,e.toString());
			return null;
		}
	}
}
