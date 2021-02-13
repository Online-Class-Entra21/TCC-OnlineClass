//Pega o id da atividade e o aluno
var idAtividade = sessionStorage.getItem('idAtividadeEscolhida')
var idAluno = sessionStorage.getItem('idAluno');
var idUsuario = sessionStorage.getItem('idUsuario');
carregarTitulo();

//Método para carregar o titulo da atividade e verifica 
async function carregarTitulo() {
    var resposta = await usarApi("GET", "http://localhost:8080/api/atividade/" + idAtividade);
    var atividade = JSON.parse(resposta);
    document.getElementById('inputTitulo').innerHTML = atividade.titulo;
}

var btnEnviar = document.getElementById('botao');
btnEnviar.addEventListener("click", function() {
    enviar();
})

//Método para enviar a resposta
async function enviar() {
    /*
    var arquivo = document.getElementById('selecao-arquivo').files;
    var idArquivo = enviarArquivo(arquivo, "http://localhost:8080/api/upload/file/return/" + idUsuario)
    */
    var dataAtual = new Date();
    var dd = String(dataAtual.getDate()).padStart(2, '0');
    var mm = String(dataAtual.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = dataAtual.getFullYear();

    dataAtual = dd + '/' + mm + '/' + yyyy;
    console.log(dataAtual);
    console.log(document.getElementById('area').value)
    console.log(idAluno)
    console.log(idAtividade)
    var resposta = {
        nota: null,
        dataEntrega: dataAtual,
        comentarioAtividade: null,
        correcaoAtividade: null,
        fk_aluno: idAluno,
        fk_atividade: idAtividade,
        fk_arquivo: 16
    }
    var insertResposta = JSON.stringify(resposta);
    var inserirResposta = await usarApi("POST", "http://localhost:8080/api/resposta/inserir/" + insertResposta);
    console.log(inserirResposta)

}
