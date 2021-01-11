package testes;

import java.sql.Date;
import java.util.List;

import entidade.Escola;
import persistencia.jdbc.EscolaDAO;

/*
 * Esse main é destinado para os testes do André
 * não edite !!
 */
public class TestesAndre {
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	
	private static void testeInsertEscola() {
		// TODO Auto-generated method stub
		String nome = "Escola dois";
		Date dataInicioLetivo = Date.valueOf("2020-02-10");
		Date dataFinalLetivo = Date.valueOf("2020-12-10");
		Escola escola = new Escola();
		escola.setNome(nome);
		escola.setDataInicioLeitvo(dataInicioLetivo);
		escola.setDataFinalLetivo(dataFinalLetivo);
		
		EscolaDAO escolaDAO = new EscolaDAO();
		
		escolaDAO.insert(escola);
		
	}
	
	private static void testeUpdateEscola() {
		int idEscola = 4;
		String nome = "Escola Treis";
		Date dataInicioLetivo = Date.valueOf("2020-02-10");
		Date dataFinalLetivo = Date.valueOf("2020-12-10");
		Escola escola = new Escola();
		escola.setIdEscola(idEscola);
		escola.setNome(nome);
		escola.setDataInicioLeitvo(dataInicioLetivo);
		escola.setDataFinalLetivo(dataFinalLetivo);
		
		EscolaDAO escolaDAO = new EscolaDAO();
		
		escolaDAO.update(escola);
	}
	
	private static void testeDeleteEscola() {
		EscolaDAO escolaDAO = new EscolaDAO();
		escolaDAO.deleteID(2);

	}
	private static void testeSelecionarIdEscola() {
		EscolaDAO escolaDAO = new EscolaDAO();
		Escola escola = escolaDAO.buscarId(1);
		System.out.println(escola.toString());
	}
	private static void testeSelecionarTodosEscola() {
		EscolaDAO escolaDAO = new EscolaDAO();
		List<Escola> escolas = escolaDAO.buscarTodos();
		
		for (Escola escola : escolas) {
			System.out.println(escola.toString());
		}
		
	}
	
	private static void testeInsertEndereco() {
		// TODO Auto-generated method stub
		String nome = "Escola dois";
		Date dataInicioLetivo = Date.valueOf("2020-02-10");
		Date dataFinalLetivo = Date.valueOf("2020-12-10");
		Escola escola = new Escola();
		escola.setNome(nome);
		escola.setDataInicioLeitvo(dataInicioLetivo);
		escola.setDataFinalLetivo(dataFinalLetivo);
		
		EscolaDAO escolaDAO = new EscolaDAO();
		
		escolaDAO.insert(escola);
		
	}

	
	
}
