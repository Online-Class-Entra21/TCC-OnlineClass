package entidade;


import java.sql.Date;
import java.sql.Time;

import persistencia.jdbc.DiretorDAO;
import persistencia.jdbc.EscolaDAO;

/**
 * Classe contendo metodos e atributos para o administrador.
 * Herda metodos e atributos da classe Usuario.
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
     * atributos da classe pai.
     * @param
     */
	public Administrador(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular,
						 int tipoUsuario, String email, String senha, Time horarioInicioExpediente, Time horarioFinalExpediente,
						 String fotoUsuario, int fk_endereco) {
		
		super(idUsuario, nome, sobrenome, cpf, telefone, celular, tipoUsuario, email, senha, horarioInicioExpediente,
				horarioFinalExpediente, fotoUsuario, fk_endereco);
	}
    
    
    //----------

    
    
    /** 
     * Metodo para adicionar uma escola ao sistema.
     * @param - 
     */
    public void adicionarEscola(int idEscola, String nome, Date dataInicioLetivo, Date dataFinalLetivo) {
    	Escola escola = new Escola(idEscola, nome, dataInicioLetivo, dataFinalLetivo);
        EscolaDAO escolaDAO = new EscolaDAO();
        escolaDAO.insert(escola);
    }
    
	/** 
     * Metodo para a atualizacao da escola.
     * @param Escola - Escola a ser atualizada.
     */
    public void atualizarEscola(Escola escola) {
        EscolaDAO escolaDAO = new EscolaDAO();
        escolaDAO.update(escola);
    }

    /**
     * Metodo para a remocao de uma escola.
     * @param Escola - Escola a ser removida do sistema.
     */
    public void removerEscola(Escola escola) {
    	EscolaDAO escolaDAO = new EscolaDAO();
        escolaDAO.deleteID(escola.getIdEscola());
    }

    /** 
     * Metodo para retorno do ID do diretor.
     * @return Int - ID do diretor
     */
    public Diretor getDiretor(Diretor diretor) {
    	return diretor;
    }

    /** 
     * Metodo para adicionar um diretor.
     * @param -
     */
    public void adicionarDiretor(int idUsuario, String nome, String sobrenome, String cpf, String telefone, String celular, String email,
    							 String senha, Time horarioInicioExpediente, Time horarioFinalExpediente, String fotoUsuario,
    							 Endereco endereco, Escola escola) {
    	
    	Diretor diretor = new Diretor(idUsuario, nome, sobrenome, cpf, telefone, celular, 3, email, senha, horarioInicioExpediente,
    			                      horarioFinalExpediente, fotoUsuario, endereco, escola);
    	DiretorDAO diretorDAO = new DiretorDAO();
    	diretorDAO.insert(diretor);
    }

    /** 
     * Metodo para a atualizacao do diretor.
     * @param Diretor - Diretor a ser atualizado.
     */
    public void atualizarDiretor(Diretor diretor) {
    	DiretorDAO diretorDAO = new DiretorDAO();
    	diretorDAO.update(diretor);
    }

    /** 
     * Metodo para a remocao do diretor
     * @param Diretor - Diretor a ser removido.
     */
    public void removerDiretor(Diretor diretor) {
    	DiretorDAO diretorDAO = new DiretorDAO();
    	diretorDAO.delete(diretor.getIdUsuario());
    }
}