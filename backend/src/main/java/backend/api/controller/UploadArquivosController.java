package backend.api.controller;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import entidade.Arquivo;
import entidade.ArquivoUsuario;
import persistencia.jdbc.ArquivoDAO;
import persistencia.jdbc.ArquivoUsuarioDAO;
import persistencia.jdbc.UsuarioDAO;
import SalvarArquivos.SalvarDisco;


@RestController
@RequestMapping("uploadarquivos")
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
	@CrossOrigin
	@PostMapping("/fotoperfil/{codigo}")
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
	@PostMapping("/file/return/{idUsuario}")
	public int upGenericFile(MultipartFile file, @PathVariable("idUsuario") int idUsuario){
		int idArquivo = 0;
		LOGGER.info("Enviando Arquivo {} ",file.getOriginalFilename());
		Arquivo arquivo = new Arquivo();
		ArquivoDAO arquivoDAO = new ArquivoDAO();
		ArquivoUsuario arquivoUsuario =  new ArquivoUsuario();
		ArquivoUsuarioDAO arquivoUsuarioDao = new ArquivoUsuarioDAO();
		String caminho = save.salvarFile(file);
		arquivo.setCaminhoArquivo(caminho);
		try {
			Timestamp data = new Timestamp(System.currentTimeMillis());
			arquivo.setDataEnvio(data);
			String extensao = FilenameUtils.getExtension(file.getOriginalFilename());
			arquivo.setExtensao(extensao);
			idArquivo = arquivoDAO.insertReturnID(arquivo);
			arquivoUsuario.setFk_arquivo(idArquivo);
			arquivoUsuario.setFk_usuario(idUsuario);
			arquivoUsuarioDao.insert2(arquivoUsuario);
			LOGGER.info("Arquivo {} sendo enviado atualizada com sucesso",file.getOriginalFilename());
			System.out.println(idArquivo);
			return idArquivo;
		} catch (SQLException e) {
			LOGGER.error("Arquivo {} não enviado erro {}",file.getOriginalFilename(),e);
		}
		return idArquivo;
	}
}
