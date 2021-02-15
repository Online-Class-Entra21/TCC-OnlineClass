// Pegando id do arquivo que abriu - id resposta
var idArquivo = sessionStorage.getItem("idArquivo");
var idResposta = sessionStorage.getItem("idResposta");

// Pegando id do usuário que logou 
var idAluno = sessionStorage.getItem("idAluno");

carregarTela();
//Carrega a resposta do aluno clicado 
function carregarTela(){
    var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/arquivo/"+idArquivo);

        xhr2.addEventListener("load", function(){
            var resposta = xhr2.responseText; 
            var arquivo = JSON.parse(resposta);
            var caminhoArquivo = arquivo.caminhoArquivo;

            //Evento de click no botao de baixar arquivo
            document.getElementById("download").addEventListener("click",function(){
                //Faz o download
                downloadFile(caminhoArquivo);
            })

            //Visualizar descricao 
            carregarRespostaTitulo(idResposta)
        })
        xhr2.send(); 
}

//Carrega o titulo da resposta 
function carregarRespostaTitulo(idResposta){

    var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/resposta/"+idResposta);

        xhr2.addEventListener("load", function(){
            var resposta = xhr2.responseText; 
            var respostaAluno = JSON.parse(resposta);

            //Adiciona o texto da resposta
            document.getElementById("idTexto").textContent = respostaAluno.comentarioAtividade;

            //Carrega o nome do aluno
            carregarNome(idAluno);
        })
        xhr2.send(); 
}

//Carrega o nome do aluno na tela 
function carregarNome(idAluno){
    var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/usuario/"+idAluno);

        xhr2.addEventListener("load", function(){
            var resposta = xhr2.responseText; 
            var aluno = JSON.parse(resposta);

            document.getElementById("idTitulo").textContent = aluno.nome+" "+aluno.sobrenome;
        })
        xhr2.send();
}

//Faz o download do arquivo 
function downloadFile(url){
    var link=document.createElement('a');
    link.href = url;
    link.download = url.substr(url.lastIndexOf('/') + 1);
    link.click();
}