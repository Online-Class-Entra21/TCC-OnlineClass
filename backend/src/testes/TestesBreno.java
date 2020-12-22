package testes;

import entidade.SalaPersonalizada;
import persistencia.jdbc.SalaPersonalizadaDAO;

public class TestesBreno {

	public static void main(String[] args) {
		SalaPersonalizada sala = new SalaPersonalizada(2, 1);
		
		SalaPersonalizadaDAO salaDao = new SalaPersonalizadaDAO();
		salaDao.insert(sala);
	}
}
