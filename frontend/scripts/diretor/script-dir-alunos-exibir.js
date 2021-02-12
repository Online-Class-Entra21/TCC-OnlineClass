//Busca dos dados dos alunos
var idTurma = sessionStorage.getItem("idTurma");
carregarAlunos();

function carregarAlunos(){
    var xhr = new XMLHttpRequest(); 

    xhr.open("GET", "http://localhost:8080/api/alunos/"+idTurma);

    xhr.addEventListener("load", function(){
        var resposta = xhr.responseText; 
        alunos = JSON.parse(resposta);
        colocarTabela(alunos)
    });
    xhr.send();
}

//Coloca os elementos na tabela 
async function colocarTabela(alunos){
    
    for (let i = 0; i < alunos.length; i++) {

        var element = alunos[i];

        //Cria uma linha e suas colunas 
        var linha = document.createElement("tr");
        linha.classList.add("linhas");

        //Coluna do RA
        var colunaRa = document.createElement("td");
        colunaRa.textContent = element.matricula;

        //Busca os dados do usuario no banco 
        var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/"+element.fk_usuario);
        var usuario = JSON.parse(resposta);

        //Coluna do nome
        var colunaNome = document.createElement("td");
        colunaNome.textContent = usuario.nome;

        //Adiciona a linha na tabela 
        var tabela = document.getElementById("tab");
        linha.appendChild(colunaRa);
        linha.appendChild(colunaNome);

        tabela.appendChild(linha);
    }
    
    $(".linhas").dblclick(function() { 
        var isConfirm = confirm("Deseja expulsar o aluno?");

        if(isConfirm){
            var idAluno = alunos[$(this).index()-1].idAluno;
            apagar(idAluno);
        }
    });
}

//Exclui a conta do aluno 
async function apagar(idAluno){

    var alunoResposta = await usarApi("GET", "http://localhost:8080/api/aluno/"+idAluno)
    var aluno = JSON.parse(alunoResposta);

    var resposta = await usarApi("DELETE", "http://localhost:8080/api/usuario/deletar/"+aluno.fk_usuario);
    var isApagou = JSON.parse(resposta);

    if(isApagou){
        alert("Aluno foi expulso com sucesso!");
        location = "/frontend/paginas/diretor/dir-alunos-exibir.html";
    }else{
        alert("Erro ao expulsar aluno!");
    }
}

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
