//Método para chamada da API async
function usarApi(method, url) {
    return new Promise(function (resolve, reject) {
        let xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.onload = function () {
            if (this.status >= 200 && this.status < 300) {
                resolve(xhr.response);
            } else {
                reject({
                    status: this.status,
                    statusText: xhr.statusText
                });
            }
        };
        xhr.onerror = function () {
            reject({
                status: this.status,
                statusText: xhr.statusText
            });
        };
        xhr.send();
    });
}



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

    //Verifica se ja foi enviado uma resposta
    resposta = await usarApi("GET", "http://localhost:8080/api/atividade/resposta/" + idAtividade);
    var respostaExistente = JSON.parse(resposta);
    if (respostaExistente != null) {
        document.getElementById('area').value = respostaExistente.comentarioAtividade;
        var confirmar = confirm("Você ja respondeu essa atividade, responder novamente?\nAo clicar em OK, a resposta enviada anteriormente será removida.")
        if (confirmar == false) {
            window.close();
        } else{
            //Exclui a resposta atual
            //await usarApi("DELETE", "http://localhost:8080/api/resposta/deletar/" + respostaExistente.idResposta);
        }
    } 
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
        comentarioAtividade: 'asdsda',
        correcaoAtividade: true,
        fk_aluno: idAluno,
        fk_atividade: idAtividade,
        fk_arquivo: 16
    }
    console.log(resposta);
    var insertResposta = JSON.stringify(resposta);
    console.log(insertResposta)
    var resposta = await usarApi("POST", "http://localhost:8080/api/resposta/inserir/" + insertResposta);
    console.log(inserirResposta)

}
