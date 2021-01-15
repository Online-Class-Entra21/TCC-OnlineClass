package testes;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import entidade.Endereco;
import entidade.Escola;
import entidade.Professor;
import persistencia.jdbc.EscolaDAO;
import persistencia.jdbc.ProfessorDAO;

/*
 * Esse main � destinado para os testes do Andr�
 * n�o edite !!
 */
public class TestesAndre {
	
	public static void main(String[] args) {
		
		ProfessorDAO profDao = new ProfessorDAO();
		Professor prof = new Professor();
		prof.setNome("Anderson");
		prof.setCelular("3412124124");
		prof.setCpf("231241241");
		prof.setEmail("anderson@gmail.com");
		prof.setEndereco(new Endereco(1, "SC", "bLUMENAU", "nao rua", "nao bairro", 19, "12312412"));
		Escola escola = new EscolaDAO().buscarId(1);
		prof.setEscola(escola);
		prof.setFotoUsuario("nao muito feio");
		prof.setHorarioFinalExpediente(new Time(7, 30, 00));
		prof.setHorarioInicioExpediente(new Time(12, 15, 00));
		prof.setSenha("123");
		prof.setSobrenome("Augusto");
		prof.setTelefone("123123123");
		
		profDao.insert(prof);
	}
	
}
//	
//	
//	
//	private static void testeInsertEscola() {
//		// TODO Auto-generated method stub
//		String nome = "Escola dois";
//		Date dataInicioLetivo = Date.valueOf("2020-02-10");
//		Date dataFinalLetivo = Date.valueOf("2020-12-10");
//		Escola escola = new Escola();
//		escola.setNome(nome);
//		escola.setDataInicioLeitvo(dataInicioLetivo);
//		escola.setDataFinalLetivo(dataFinalLetivo);
//		
//		EscolaDAO escolaDAO = new EscolaDAO();
//		
//		escolaDAO.insert(escola);
//		
//	}
//	
//	private static void testeUpdateEscola() {
//		int idEscola = 4;
//		String nome = "Escola Treis";
//		Date dataInicioLetivo = Date.valueOf("2020-02-10");
//		Date dataFinalLetivo = Date.valueOf("2020-12-10");
//		Escola escola = new Escola();
//		escola.setIdEscola(idEscola);
//		escola.setNome(nome);
//		escola.setDataInicioLeitvo(dataInicioLetivo);
//		escola.setDataFinalLetivo(dataFinalLetivo);
//		
//		EscolaDAO escolaDAO = new EscolaDAO();
//		
//		escolaDAO.update(escola);
//	}
//	
//	private static void testeDeleteEscola() {
//		EscolaDAO escolaDAO = new EscolaDAO();
//		escolaDAO.deleteID(2);
//
//	}
//	private static void testeSelecionarIdEscola() {
//		EscolaDAO escolaDAO = new EscolaDAO();
//		Escola escola = escolaDAO.buscarId(1);
//		System.out.println(escola.toString());
//	}
//	private static void testeSelecionarTodosEscola() {
//		EscolaDAO escolaDAO = new EscolaDAO();
//		List<Escola> escolas = escolaDAO.buscarTodos();
//		
//		for (Escola escola : escolas) {
//			System.out.println(escola.toString());
//		}
//		
//	}
//	
//	private static void testeInsertEndereco() {
//		// TODO Auto-generated method stub
//		String nome = "Escola dois";
//		Date dataInicioLetivo = Date.valueOf("2020-02-10");
//		Date dataFinalLetivo = Date.valueOf("2020-12-10");
//		Escola escola = new Escola();
//		escola.setNome(nome);
//		escola.setDataInicioLeitvo(dataInicioLetivo);
//		escola.setDataFinalLetivo(dataFinalLetivo);
//		
//		EscolaDAO escolaDAO = new EscolaDAO();
//		
//		escolaDAO.insert(escola);
//		
//	}
//	
//	private static void testeUpdateEscola() {
//		int idEscola = 4;
//		String nome = "Escola Treis";
//		Date dataInicioLetivo = Date.valueOf("2020-02-10");
//		Date dataFinalLetivo = Date.valueOf("2020-12-10");
//		Escola escola = new Escola();
//		escola.setIdEscola(idEscola);
//		escola.setNome(nome);
//		escola.setDataInicioLeitvo(dataInicioLetivo);
//		escola.setDataFinalLetivo(dataFinalLetivo);
//		
//		EscolaDAO escolaDAO = new EscolaDAO();
//		
//		escolaDAO.update(escola);
//	}
//	
//	private static void testeDeleteEscola() {
//		EscolaDAO escolaDAO = new EscolaDAO();
//		escolaDAO.deleteID(2);
//		
//	}
//	private static void testeSelecionarIdEscola() {
//		EscolaDAO escolaDAO = new EscolaDAO();
//		Escola escola = escolaDAO.buscarId(1);
//		System.out.println(escola.toString());
//	}
//	private static void testeSelecionarTodosEscola() {
//		EscolaDAO escolaDAO = new EscolaDAO();
//		List<Escola> escolas = escolaDAO.buscarTodos();
//		
//		for (Escola escola : escolas) {
//			System.out.println(escola.toString());
//		}
//		
//	}
//	
//	
//}
