package entidade;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GerarRelatorio {
	
	public void relatorioErro(Exception erro){

		// data/hora atual
	    LocalDateTime agora = LocalDateTime.now();
	    System.out.println(agora);

	    // formatar a data
	    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	    String dataFormatada = formatterData.format(agora);

	    // formatar a hora
	    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
	    String horaFormatada = formatterHora.format(agora);
		
		try {
			
			//data formatada para colocar no nome do arquivo 
			String dataNome = dataFormatada.replace("/", "");
			
			//Cria o arquivo ou abre se já existir 
			FileWriter arq = new FileWriter("listaDeErros"+dataNome+".txt");
		    PrintWriter gravarArq = new PrintWriter(arq);

		    gravarArq.printf("+------Erro Ocorrido no sistema------+%n");
		    gravarArq.printf("Data: "+dataFormatada+"%n");
		    gravarArq.printf("Hora: "+horaFormatada+"%n");
		    gravarArq.printf("Erro: "+erro+"%n");
		    gravarArq.printf("+------------------------------------+%n");
		    
			arq.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
