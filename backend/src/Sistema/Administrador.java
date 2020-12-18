package Sistema;

import java.util.*;

/**
 * Classe contendo métodos e atributos para o administrador.
 * Herda métodos e atributos da classe Usuario.
 * @see Usuario
 * @author 
 */
public class Administrador extends Usuario {

    /**
     * Construtor usado ao instanciar a classe Administrador.
     * @param
     */
    public Administrador() {
    	
    }

    /** Método para retorno da escola.
     * @return String - Nome do usuário
     */
    public String getEscola() {
    	Escola escola = new Escola();
        return escola.getNome();
    }

    /** Método para adicionar uma escola ao sistema.
     * @param - 
     */
    public void adicionarEscola() {
        // TODO implement here
    }

    /** Método para a atualização da escola.
     * @param Escola - Escola a ser atualizada.
     */
    public void atualizarEscola(Escola escola) {
        // TODO implement here
    }

    /** Método para a remoção de uma escola.
     * @param Escola - Escola a ser removida do sistema.
     */
    public void removerEscola(Escola escola) {
        // TODO implement here
    }

    /** Método para retorno do ID do diretor.
     * @return Int - ID do diretor
     */
    public int getDiretor() {
    	Diretor diretor =  new Diretor();
        return diretor.getIdUsuario();
    }

    /** Método para adicionar um diretor.
     * @param -
     */
    public void adicionarDiretor() {
        // TODO implement here
    }

    /** Método para a atualização do diretor.
     * @param Diretor - Diretor a ser atualizado.
     */
    public void atualizarDiretor(Diretor diretor) {
        // TODO implement here
    }

    /** Método para a remoção do diretor
     * @param Diretor - Diretor a ser removido.
     */
    public void removerDiretor(Diretor diretor) {
        // TODO implement here
    }

}