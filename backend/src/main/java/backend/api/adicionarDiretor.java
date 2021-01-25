package backend.api;

import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

import entidade.Diretor;
import persistencia.jdbc.DiretorDAO;
import persistencia.jdbc.UsuarioDAO;

public class adicionarDiretor {
	
	public static void adicionar() {
		Diretor diretor = new Diretor();
		diretor.setNome("Andresa");
		diretor.setSobrenome("Rosa");
		diretor.setCelular("98599582");
		diretor.setCpf("5588845568");
		diretor.setEmail("andresaemail@email.com");
		diretor.setFk_endereco(1);
		diretor.setFk_escola(4);
		diretor.setFotoUsuario("url:imagemfoda/andresa");
		diretor.setSenha("senhaforte");
		diretor.setTipoUsuario(2);
		diretor.setTelefone("33854512");
		diretor.setHorarioFinalExpediente(new Time(18,0,0));
		diretor.setHorarioInicioExpediente(new Time(14,0,0));
		try {
			new UsuarioDAO().insert(diretor);
			System.out.println("Diretor inseriod");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
