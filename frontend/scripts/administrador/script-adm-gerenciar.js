//Evento de abertura do menu 
document.getElementById("mostrar").addEventListener("mouseover", function(){
    abrirMenu();
})
document.getElementById("idImgMenu").addEventListener("mouseover", function(){
    abrirMenu();
})

//Abertura do menu
function abrirMenu(){
    document.getElementById("menu").style.display = "block";
}

//Evento de fechamento do menu 
document.getElementById("menu").addEventListener("mouseleave", function(){
    document.getElementById("menu").style.display = "none";
})


//Método para chamada da api
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


//Método para retornar um array de escolas cadastradas no banco de dados e populá-las em uma tabela
listaEscolas();
console.log("carregando");
async function listaEscolas(){
    var resposta = await usarApi("GET", "http://localhost:8080/api/escolas");
    console.log(resposta)
    var escolas = JSON.parse(resposta);
    
    setTimeout(async function() {
        for (let i = 0; i < escolas.length; i++) {
            var linha = document.createElement("tr");
            var coluna = document.createElement("td");
            var coluna2 = document.createElement("td");
            var input = escolas[i].nome;
                    
            coluna.append(input);
            linha.append(coluna);
                    
  
            var diretor = await usarApi("GET","http://localhost:8080/api/diretor/escola/"+escolas[i].idEscola);
            diretor = JSON.parse(diretor);
            coluna2.append(diretor.nome);
            linha.append(coluna2);
            document.getElementById('tbLista').append(linha)
        }
        document.getElementById("idLoad").style.display = "none";
    }, 3000)
}

//Método para edição da escola  
async function editarEscola(idEscola) {
    //var escolaEscolhida = document.getElementById("Subtituir pelo id da escola recebido ao selecionar qual escola será editada")
    //var diretorAtual = document.getElementById("Subtituir pelo id do diretor recebido ao selecionar qual escola será editada")

    //Edita a escola
    var alterarEscola = {
        //"idEscola": escolaEscolhida.idEscola,
        //"nome": input nome,
        //"dataInicioLetivo": input dataInicio,
        //"dataFinalLetivo": input dataFinal
    }
    var escolaJson = JSON.stringify(alterarEscola);
    console.log(escolaJson);
    var updateEscola = await usarApi("PUT", "http://localhost:8080/api/escola/alterar/"+escolaEscolhida.idEscola+"/"+escolaJson)

    //Traz todos os diretores que podem ser adicionados à escola e popula eles em uma Drop Down list(Select)
    //Atualizar os id's conforme necessitado pela página
    var resposta = await usarApi("GET", "http://localhost:8080/api/diretores");
    console.log(resposta);
    var diretores = JSON.parse(resposta);

    var selectDiretoresDisponiveis = document.getElementById("idSelectDiretores");
    for (let index = 0; index < diretores.length; index++) {
        var option = document.createElement("option");;
        option.textContent = diretores[index].nome;
        //A opção selecionada retornará o ID do diretor
        option.value = diretores[index].idUsuario;
        
        selectDiretoresDisponiveis.appendChild(option);
    }

    
    //Remove o atual diretor deletando-o do banco de dados e atualiza o novo diretor da escola
    var idDiretorNovo = selectDiretoresDisponiveis.value;
    if (diretorAtual.idUsuario != idDiretorNovo) {
        updateDiretor(idEscola, diretorAtual.idUsuario, idDiretorNovo);
    }
    
}

/*
Método para remover o atual diretor de uma escola, deletando-o da tabela usuario no banco de dados e atribuindo um novo diretor à escola em seguida
*/
function updateDiretor(idEscola, idDiretorAtual, idDiretorNovo) {
    //Deleta o atual diretor no banco de dados
    var deletarUsuario = await usarApi("DELETE", "http://localhost:8080/api/usuario/deletar/"+idDiretorAtual);

    //Atualiza para o novo diretor da escola
    var updateDiretor = await usarApi("PUT", "http://localhost:8080/api/diretor/escola/alterar/"+idEscola+"/"+idDiretorNovo)
}