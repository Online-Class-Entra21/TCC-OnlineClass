package backend.api.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import SalvarArquivos.SalvarDisco;
import persistencia.jdbc.UsuarioDAO;


@RestController
public class UploadArquivosController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("backend.api");
	private SalvarDisco save = new SalvarDisco();
	
	/**
	 * Guarda a foto no servidor e armazena
	 * o caminho dela no banco de dados
	 * 
	 * @param foto
	 * @param idUsuario
	 */
	@PostMapping(path = "/api/upload/{codigo}")
	public void upAvatar(MultipartFile foto,@PathVariable("codigo") int idUsuario){
		LOGGER.info("Enviando foto do usuario {}",idUsuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		String caminho = save.salvarFoto(foto, idUsuario);
		try {
			usuarioDAO.updateFoto(caminho, idUsuario);
			LOGGER.info("Foto do usuario {} atualizada com sucesso",idUsuario);
		} catch (SQLException e) {
			LOGGER.error("Foto do usuario {} não atualizada erro {}",idUsuario,e);
		}
	}
	
}
