package entidade;

import java.sql.Time;
import java.util.*;

/**
 * Classe contendo métodos e atributos para o usuário do sistema.
 * Os atributos e métodos dessa classe são herdados pelas classes Administrador, Aluno, Coordenador, Diretor e Professor.
 * @see Administrador
 * @see Aluno
 * @see Coordenador
 * @see Diretor
 * @see Professor
 * @author 
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String celular;
    private byte tipoUsuario;
    private String email;
    private String senha;
    private Time horarioInicioExpediente;
    private Time horarioFinalExpediente;
    private byte fotoUsuario[];
    private Endereco endereco;
    
    /**
     * Construtor usado ao instanciar a classe Usuario.
     * @param
     */
    public Usuario() {
    }


    /** Método para retorno do ID do usuário.
     * @return Int - ID do usuário
     */
    public int getIdUsuario() {
    	 return idUsuario;
    }

    /**
     * 
     */
    public void setIdUsuario() {
        // TODO implement here
    }

    /** Método para retorno do nome do usuário.
     * @return String - Nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     */
    public void setNome() {
        // TODO implement here
    }

    /** Método para retorno do sobrenome do usuário.
     * @return String - Sobrenome do usuário
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * 
     */
    public void setSobrenome() {
        // TODO implement here
    }

    /** Método para retorno do CPF do usuário.
     * @return String - CPF do usuário
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * 
     */
    public void setCpf() {
        // TODO implement here
    }

    /** Método para retorno do telefone do usuário.
     * @return String - Telefone do usuário
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * 
     */
    public void setTelefone() {
        // TODO implement here
    }

    /** Método para retorno do número de celular do usuário.
     * @return String - Número de celular do usuário
     */
    public String getCelular() {
        return celular;
    }

    /**
     * 
     */
    public void setCelular() {
        // TODO implement here
    }

    /** Método para retorno do tipo de conta do usuário.
     * @return Byte - Tipo de conta do usuário.
     * 							0 - Aluno,
	 * 							1 - Professor,
	 * 							2 - Coordenador,
	 * 							3 - Diretor,
	 * 							4 - Administrador
     */
    public Byte getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * 
     */
    public void setTipoUsuario() {
        // TODO implement here
    }

    /** Método para retorno do email do usuário.
     * @return String - Email do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     */
    public void setEmail() {
        // TODO implement here
    }

    /** Método para retorno da senha do usuário.
     * @return String - Senha do usuário
     */
    private String getSenha() {
        return senha;
    }

    /**
     * 
     */
    public void setSenha() {
        // TODO implement here
    }

    /** Método para retorno do horário inicial do expediente do usuário.
     * @return Time - Horário inicial do expediente do usuário
     */
    public Time getHorarioInicioExpediente() {
        return horarioInicioExpediente;
    }

    /**
     * 
     */
    public void setHorarioInicioExpediente() {
        // TODO implement here
    }

    /** Método para retorno do horário final do expediente do usuário.
     * @return Time - Horário final do expediente do usuário
     */
    public Time getHorarioFinalExpediente() {
        return horarioFinalExpediente;
    }

    /**
     * 
     */
    public void setHorarioFinalExpediente() {
        // TODO implement here
    }

    /** Método para retorno da foto do usuário.
     * @return Byte - Array de fotos dos usuários
     */
    public byte[] getFoto() {
        return fotoUsuario;
    }

    /**
     * 
     */
    public void setFoto() {
        // TODO implement here
    }

    /** Método para retorno do endereço do usuário.
     * @return Endereco - Endereço do usuário
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * 
     */
    public void setEndereco() {
        // TODO implement here
    }

    /** Método para a verificação de cpf.
     * Recebe uma String e converte para inteiro, realizando o cálculo para a verificação do dígito veríficador.
     * @param String - CPF a ser verificado. 
     * @return Boolean - True para CPF válido / False para inválido.
     */
    public boolean verificarCpf(String cpf) {
        return false;
    }

    /** Método para verificação do login.
     * 	Recebe o email e senha e verifica no banco de dados se os dados coincidem com os cadastrados pelo usuário.
     * @param String - Email a ser verificado.
     * @param String - Senha a ser verificada.
     * @return Boolean - True para login correto / False para incorreto.
     */
    public boolean verificarLogin(String email, String senha) {
        return false;
    }

    /** Método para pesquisar um usuário específico a partir do ID.
     * @param Int - ID do usuário.
     * @return Usuario - Retorna o usuário.
     */
    public void pesquisarUsuario(int id) {
    }

    /** Método para envio de um relatório. 
     * @param -
     */
    public void mandarRelatorio() {
        // TODO implement here
    }

    /** Método para visualizar os relatórios enviados, a partir do banco de dados.
     * @param -
     * @return Relatorio - Retorna os relatórios enviados.
     */
    public Relatorio verRelatoriosEnviados() {
        return null;
    }

    /** Método para buscar um relatório enviado, a partir do banco de dados.
     * @param -
     * @return Relatorio - Retorna um relatório.
     */
    public void buscarRelatorioEnviado() {
        // TODO implement here
    }

    /** Método para visualizar os relatórios recebidos, a partir do banco de dados.
     * @param -
     * @return Relatorio - Retorna os relatórios recebidos.
     */
    public void verRelatoriosRecebidos() {
        // TODO implement here
    }

    /** Método para buscar um relatório recebido, a partir do banco de dados.
     * @param -
     * @return Relatorio - Retorna um relatório.
     */
    public void buscarRelatorioRecebido() {
        // TODO implement here
    }

    /** Método para a remoção de um relatório.
     * @param Relatorio - Relatório a ser removido.
     */
    public void removerRelatorio(Relatorio relatorio) {
        // TODO implement here
    }

    /** Método para o envio do convite para acessar uma reunião.
     * @param -
     */
    public void mandarConvite() {
        // TODO implement here
    }

    /** Método para visualizar os convites enviados, a partir do banco de dados.
     * @param -
     * @return Convite - Retorna os convites enviados.
     */
    public void verConvitesEnviados() {
        // TODO implement here
    }

    /** Método para buscar um convite enviado, a partir do banco de dados.
     * @param -
     * @return Convite - Retorna um convite.
     */
    public void buscarConviteEnviado() {
        // TODO implement here
    }

    /** Método para buscar os convites recebidos, a partir do banco de dados.
     * @param -
     * @return Convite - Retorna os convites recebidos.
     */
    public void verConvitesRecebidos() {
        // TODO implement here
    }

    /** Método para buscar um convite recebido, a partir do banco de dados.
     * @param -
     * @return Convite - Retorna um convite.
     */
    public void buscarConviteRecebido() {
        // TODO implement here
    }

    /** Método para a remoção de um convite.
     * @param Convite - Convite a ser removido.
     */
    public void removerConvite() {
        // TODO implement here
    }

    /** Método para a aceitação de um convite.
     * @param Boolean - Resposta do convite.
     * @return Boolean - True.
     */
    public boolean aceitarConvite(boolean convite) {
        return true;
    }

    /** Método para recusar um convite.
     * @param Boolean - Resposta do convite.
     * @return Boolean - False.
     */
    public boolean recusarConvite(boolean convite) {
        return false;
    }

    /** Método para o envio de um arquivo.
     * @param -
     */
    public void mandarArquivo() {
        // TODO implement here
    }

    /** Método para visualizar os arquivos enviados, a partir do banco de dados.
     * @param -
     * @return Arquivo - Retorna os arquivos enviados.
     */
    public Arquivo verArquivosEnviados() {
        return null;
    }

    /** Método para visualizar um arquivo específico enviado, a partir do banco de dados.
     * @param -
     * @return Arquivo - Retorna o arquivo.
     */
    public void buscarArquivoEnviado() {
        // TODO implement here
    }

    /** Método para visualizar os arquivos recebidos, a partir do banco de dados.
     * @param -
     * @return Arquivo - Retorna os arquivos recebidos.
     */
    public void verArquivosRecebidos() {
        // TODO implement here
    }

    /** Método para visualizar arquivo específico recebido, a partir do banco de dados.
     * @param -
     * @return Arquivo - Retorna o arquivo.
     */
    public void buscarArquivoRecebido() {
        // TODO implement here
    }

    /** Método para a remoção de um arquivo.
     * @param -
     */
    public void removerArquivo() {
        // TODO implement here
    }

    /** Método para visualizar uma sala personalizada.
     * @param -
     * @return SalaPersonalizada.
     */
    public SalaPersonalizada getSalaPersonalizada() {
        return null;
    }

    /** Método para a criação de uma sala personalizada.
     * @param -
     */
    public void criarSalaPersonalizada() {
        // TODO implement here
    }

    /** Método para atualizar uma sala personalizada.
     * @param SalaPersonalizadaDAO - Sala a ser atualizada.
     */
    public void atualizarSalaPersonalizada(SalaPersonalizada salaP) {
        // TODO implement here
    }

    /** Método para remoção de uma sala personalizada.
     * @param SalaPersonalizadaDAO - Sala a ser removida.
     */
    public void removerSalaPersonalizada(SalaPersonalizada salaP) {
        // TODO implement here
    }

    /** Método para visualizar uma reunião.
     * @return Reuniao.
     */
    public Reuniao getReuniao() {
        return null;
    }

    /** Método para a criação de uma reunião.
     * @param -
     */
    public void criarReuniao() {
        // TODO implement here
    }

    /** Método para a atualização de uma reunião.
     * @param Reuniao - Reunião a ser atualizada.
     */
    public void atualizarReuniao(Reuniao reuniao) {
        // TODO implement here
    }

    /** Método para a remoção de uma reunião.
     * @param Reuniao - Reunião a ser removida.
     */
    public void removerReuniao(Reuniao reuniao) {
        // TODO implement here
    }

    /** Método para entrar em uma reunião.
     * @param - 
     */
    public void entrarReuniao() {
        // TODO implement here
    }

    /** Método para sair de uma reunião.
     * @param -
     */
    public void sairReuniao() {
        // TODO implement here
    }

    /** Método para visualizar uma chamada.
     * @param - 
     * @return Chamada.
     */
    public Chamada getChamada() {
        return null;
    }

    /** Método para a realização da chamada.
     * @param -
     */
    public void fazerChamada() {
        // TODO implement here
    }

    /** Método a remoção de uma chamada.
     *  @param Chamada - Chamada a ser removida.
     */
    public void removerChamada(Chamada chamada) {
        // TODO implement here
    }

}