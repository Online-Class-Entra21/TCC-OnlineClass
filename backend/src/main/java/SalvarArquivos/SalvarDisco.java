package SalvarArquivos;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class SalvarDisco {
	
	public static final Logger LOGGER = LoggerFactory.getLogger("SalvarArquivos");
	
	private String raiz;

	/**
	 * Instancia a classe com o diretorio raiz
	 * sendo uma pasta antes da raiz do projeto
	 * 
	 * @author Andre
	 */
	public SalvarDisco() {
		String dir = System.getProperty("user.dir");
		Path diretorio = Paths.get(dir);
		System.out.println(diretorio.getName(diretorio.getNameCount()-1));
		String ultimoDiretorio = diretorio.getName(diretorio.getNameCount()-1).toString();
		if (ultimoDiretorio.equals("backend")) {
			this.raiz = diretorio.getParent().toString();
		}else{
			this.raiz = diretorio.toString();			
		}
		System.out.println(raiz);
	}
	
	
	/**
	 * Gera o nome do arquivo com base no idUsuario
	 * e salva o arquivo dentro da pasta /imagens-usuarios
	 * no diretorio raiz
	 * 
	 * @param arquivo
	 * @param idUsuario
	 * @author Andre
	 * @return
	 */
	public String salvarFoto(MultipartFile arquivo, int idUsuario){
		String id = String. format ("%06d", idUsuario);
		String nome;
		nome = "OnlineClass-imagens-"+id+"."+arquivo.getContentType().substring(arquivo.getContentType().indexOf('/')+1);
		return this.salvarDir("imagens-usuarios", arquivo, nome);
	}
	
	
	/**
	 * Salva um arquivo dentro da pasta raiz
	 * dentro da pasta especificada em diretorio
	 * o nome do arquivo deve conter a extensão
	 * dele e o diretorio não pode conter /
	 * 
	 * @param diretorio - pasta a onde vai ser salvo o arquivo dentro da raiz
	 * @param arquivo - arquivo que vai ser salvo
	 * @param nome - nome do arquivo com a extensão dele
	 * @author Andre
	 * @return diretorio apartir da raiz onde o arquivo foi salvo ex: /imagens-usuarios/user001
	 */
	public String salvarDir(String diretorio, MultipartFile arquivo, String nome){
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(nome);
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		} catch (Exception e) {
			LOGGER.error("Erro ao salvar o arquivo {} - erro : {}",arquivoPath,e);
		}
		return nome;
		
	}

	/**
	 * return o diretorio raiz onde a classe
	 * salva os arquivos
	 * @author Andre
	 * @return diretorioRaiz
	 */
	public String getRaiz() {
		return raiz;
	}

	/**
	 * seta o diretorio raiz onde a classe
	 * salva os arquivos
	 * @author Andre
	 * @param raiz
	 */
	public void setRaiz(String raiz) {
		this.raiz = raiz;
	}
}
