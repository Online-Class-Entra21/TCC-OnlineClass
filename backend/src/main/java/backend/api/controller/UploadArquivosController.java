package backend.api.controller;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import entidade.Arquivo;
import persistencia.jdbc.ArquivoDAO;
import persistencia.jdbc.UsuarioDAO;
import SalvarArquivos.SalvarDisco;


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
	
	/**
	 * Guarda a foto no servidor e armazena
	 * o caminho dela no banco de dados
	 * 
	 * @param foto
	 * @return int idArquivo 
	 * @author Andre
	 */
	@PostMapping(path = "/api/upload/file/return")
	public int upGenericFile(MultipartFile file){
		int idArquivo = 0;
		LOGGER.info("Enviando Arquivo {} ",file.getOriginalFilename());
		Arquivo arquivo = new Arquivo();
		ArquivoDAO arquivoDAO = new ArquivoDAO();
		String caminho = save.salvarFile(file);
		arquivo.setCaminhoArquivo(caminho);
		try {
			Timestamp data = new Timestamp(System.currentTimeMillis());
			arquivo.setDataEnvio(data);
			String extensao = FilenameUtils.getExtension(file.getOriginalFilename());
			arquivo.setExtensao(extensao);
			idArquivo = arquivoDAO.insertReturnID(arquivo);
			LOGGER.info("Arquivo {} sendo enviado atualizada com sucesso",file.getOriginalFilename());
			return idArquivo;
		} catch (SQLException e) {
			LOGGER.error("Arquivo {} não enviado erro {}",file.getOriginalFilename(),e);
		}
		return idArquivo;
	}
}
