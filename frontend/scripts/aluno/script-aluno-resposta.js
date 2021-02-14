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

//Adiciona imagem no arquivo raiz 
async function enviarArquivo(file,url){
    var size = file[0].size;
    console.log(size)
    if(size < 1048576) { //1MB
      
    } else {           
      alert('Arquivo não enviado maior que 1 MB'); //Acima do limite
      return;
    }
    
    var files = file[0];
    var xhr = new XMLHttpRequest();
    var fd = new FormData();

    fd.append( "file", files, files.name);
    xhr.open("POST", url, true);
    var idArquivo;
    xhr.addEventListener("load", function(){
        var resposta = xhr.responseText;
        idArquivo = JSON.parse(resposta); 
        return idArquivo;
    });
    xhr.send(fd);
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
    resposta = await usarApi("GET", "http://localhost:8080/api/atividade/resposta/" + idAtividade + "/" + idAluno);
    var respostaExistente = JSON.parse(resposta);
    if (respostaExistente.dataEntrega != null) {
        var confirmar = confirm("Você ja respondeu essa atividade, responder novamente?\nAo clicar em OK, a resposta enviada anteriormente será removida.")
        if (confirmar == false) {
            window.close();
        } else{
            //Exclui a resposta atual
            await usarApi("DELETE", "http://localhost:8080/api/resposta/deletar/" + respostaExistente.idResposta);
        }
    } 
}

var btnEnviar = document.getElementById('botao');
btnEnviar.addEventListener("click", function() {
    enviar();
})

//Método para enviar a resposta
async function enviar() {
    var arquivo = document.getElementById('selecao-arquivo').files;
    if (arquivo.length == 0) {
        alert("Anexe um arquivo!")
    } else {
        var size = arquivo[0].size;
        if(size < 1048576) { //1MB
    
        } else {           
        alert('Arquivo não enviado maior que 1 MB'); //Acima do limite
        return;
        }
    
        var files = arquivo[0];
        var xhr = new XMLHttpRequest();
        var fd = new FormData();
    
        fd.append( "file", files, files.name);
        xhr.open("POST", "http://localhost:8080/api/upload/file/return/" + idUsuario, true);
        xhr.addEventListener("load", async function(){
            var resposta = xhr.responseText;
            idArquivo = JSON.parse(resposta); 
            var dataAtual = new Date();
            dataAtual = dataAtual.toISOString();
            
            var resposta = {
                comentarioAtividade: document.getElementById('area').value,
                fk_aluno: idAluno,
                fk_atividade: idAtividade,
                fk_arquivo: idArquivo
            }
            var insertResposta = JSON.stringify(resposta);
            var resposta = await usarApi("POST", "http://localhost:8080/api/resposta/inserir/" + insertResposta);
            
            if (resposta == false) {
                alert("Ocorreu um erro ao enviar a resposta");
            } else {
                alert("Resposta enviada com sucesso!")
                window.close();
            }
        });
        xhr.send(fd);
    }

    

    
   
    
}
