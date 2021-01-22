package backend.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import entidade.Conexao;

/**
 * Testa a conexão com a API
 * @author Breno
 *
 */
@RestController
public class statusController {
	
	/**
	 * Metodo para verificar se a conexao com a API está tudo certo
	 * @return String status API
	 */
	@GetMapping(path = "/api/status")
	public String check() {
		return "Online";
	}
	
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
}
