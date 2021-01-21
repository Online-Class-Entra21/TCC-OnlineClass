package entidade;

import java.sql.Date;
import java.sql.Time;

import persistencia.jdbc.DiretorDAO;
import persistencia.jdbc.EscolaDAO;

/**
 * Classe contendo metodos e atributos para o administrador.
 * Herda metodos e atributos da classe Usuario
 * @see Usuario
 * @author André
 */
public class Administrador extends Usuario {
	
	/**
	 * Construtor padrão
	 */
	public Administrador() {
		//Nenhum atributo inicializado
	}

    /**
     * Construtor usado ao instanciar a classe Administrador, herdando 
     * atributos da classe superior
     * @param idUsuario
     * @param nome
     * @param sobrenome
     * @param cpf
     * @param telefone
     * @param celular
     * @param email
     * @param senha
     * @param horarioInicioExpediente
     * @param horarioFinalExpediente
     * @param fotoUsuario
     * @param fk_endereco
     */
	public Administrador(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
						 String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
						 String fotoUsuario, int fk_endereco) {
		
		super(idUsuario, nome, sobrenome, cpf, telefone, celular, 1, email, senha, horarioInicioExpediente,
				horarioFinalExpediente, fotoUsuario, fk_endereco);
	} 
	
	/**
	 * Metodo que retorno uma consulta na escola desejada 
	 * @param int idEscola
	 * @return Escola escola 
	 */
	public Escola getEscola(int idEscola) {
		EscolaDAO escolaDao = new EscolaDAO();
		Escola escola = escolaDao.buscarId(idEscola);
		return escola;
	}

    /** 
     * Metodo para adicionar uma escola ao sistema
     * @param Escola escola
     */
    public void adicionarEscola(Escola escola) {
        EscolaDAO escolaDao = new EscolaDAO();
        escolaDao.insert(escola);
    }
    
	/** 
     * Metodo para a atualizacao da escola
     * @param Escola escola
     */
    public void atualizarEscola(Escola escola) {
        EscolaDAO escolaDao = new EscolaDAO();
        escolaDao.update(escola);
    }

    /**
     * Metodo para a remocao de uma escola
     * @param Escola escola
     */
    public void removerEscola(Escola escola) {
    	EscolaDAO escolaDao = new EscolaDAO();
        escolaDao.delete(escola.getIdEscola());
    }

    /** 
     * Metodo para retorno do diretor
     * @return Diretor diretor
     */
    public Diretor getDiretor(int idDiretor) {
    	DiretorDAO diretorDao = new DiretorDAO();
    	Diretor diretor = diretorDao.buscarId(idDiretor);
    	return diretor;
    }

    /**
     * Metodo para adicionar um diretor
     * @param Diretor diretor
     */
    public void adicionarDiretor(Diretor diretor) {
    	DiretorDAO diretorDAO = new DiretorDAO();
    	diretorDAO.insert(diretor);
    }

    /** 
     * Metodo para a atualizacao do diretor
     * @param Diretor diretor
     */
    public void atualizarDiretor(Diretor diretor) {
    	DiretorDAO diretorDAO = new DiretorDAO();
    	diretorDAO.update(diretor);
    }

    /** 
     * Metodo para a remocao do diretor
     * @param int idDiretor
     */
    public void removerDiretor(int idDiretor) {
    	DiretorDAO diretorDAO = new DiretorDAO();
    	diretorDAO.delete(idDiretor);
    }
}