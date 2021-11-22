package backend.api.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entidade.Conexao;
import persistencia.configuration.PostgresConfi;
import persistencia.jdbc.ConexaoFactory;

/**
 * Testa a conexão com a API
 * @author Breno
 *
 */
@RestController
public class StatusController {
	
	/**
	 * Metodo para verificar se a conexao com a API está tudo certo
	 * @return String status API
	 */
	@GetMapping(path = "/api/status")
	public String check() {
		return "Online";
	}
	
	@Autowired
	PostgresConfi postgresConfi;
	
	/**
	 * Metodo para verificar se a conexao com o banco de dados 
	 * @return String status banco de dados
	 */
	@GetMapping(path = "/api/status/banco")
	public String checkBanco() {
		Conexao conexao = new Conexao();
		if(conexao.getConexao() != null) {
			return "Conectado";
		}
		return "Não Conectado";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void method(HttpServletResponse httpServletResponse) {
		System.out.println(postgresConfi.getIp());
	    httpServletResponse.setHeader("Location", "frontend/index.html");
	    httpServletResponse.setStatus(302);
	    ConexaoFactory.getConnection();
	}
}
