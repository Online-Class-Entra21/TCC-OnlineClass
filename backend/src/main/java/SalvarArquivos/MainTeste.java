package SalvarArquivos;

import java.io.File;

public class MainTeste {
	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");
		dir = dir.replaceFirst("backend", "frontend");
		dir += "\\imagens-usuarios";
		File diretorio = new File(dir);
		System.out.println(diretorio.exists());
	}
}
