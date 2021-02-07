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
