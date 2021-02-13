//Pega o id da atividade e o aluno
var idAtividade = sessionStorage.getItem('idAtividadeEscolhida')
var idAluno = sessionStorage.getItem('idAluno');
carregarTitulo();

//Método para carregar o titulo da atividade
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
    var arquivo = $('#selecao-arquivo').files;
    var idArquivo = enviarArquivo(arquivo, "http://localhost:8080/api/upload/file/return")
    console.log(idArquivo)
}
