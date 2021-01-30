function usarApi(method, url) {
    return new Promise(function (resolve, reject) {
        let xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.onload = function () {
            if (this.status >= 200 && this.status < 300) {
                resolve(xhr.response);
            } else {
                document.getElementById("idLoad").style.display = "none";
                document.getElementById("idErro").textContent = "Sem Conexão com a Base de Dados - Erro (0001)";
                document.getElementById("idErro").style.display = "block";
                reject({
                    status: this.status,
                    statusText: xhr.statusText
                });
            }
        };
        xhr.onerror = function () {
            document.getElementById("idLoad").style.display = "none";
            document.getElementById("idErro").textContent = "Sem Conexão com a Base de Dados - Erro (0001)";
            document.getElementById("idErro").style.display = "block";
            reject({
                status: this.status,
                statusText: xhr.statusText
            });
        };
        xhr.send();
    });
}

var idEscola = sessionStorage.getItem('idEscolaSelecionada')
carregarCampos(idEscola);
carregarSelect();
        
async function carregarCampos(idEscola) {
    var resposta = await usarApi("GET", "http://localhost:8080/api/escola/" + idEscola)
    var escola = JSON.parse(resposta)
    console.log(escola)

    document.getElementById('idID').value = escola.idEscola;
    document.getElementById('idNome').value = escola.nome;
    //document.getElementById('idDataInic').textContent = escola.dataInicioLetivo;

    resposta = await usarApi("GET", "http://localhost:8080/api/diretor/escola/" + idEscola)
    var diretor = JSON.parse(resposta);
    var btnDiretor = document.getElementById('btnDiretor');
    if (diretor.fk_escola == null) {
        document.getElementById('SelectDiretor').hidden = false;
    } else {
        btnDiretor.hidden = false;
        document.getElementById('idDiretor').value = diretor.nome;
    }

            
}
        
async function carregarSelect() {
    var resposta = await usarApi("GET", "http://localhost:8080/api/diretores/disponiveis");
    var diretores = JSON.parse(resposta);

    var selectDiretoresDisponiveis = document.getElementById("SelectDiretor");
    for (let index = 0; index < diretores.length; index++) {
        var option = document.createElement("option");;
        option.textContent = diretores[index].nome;
        //A opção selecionada retornará o ID do diretor
        option.value = diretores[index].idUsuario;
        
        selectDiretoresDisponiveis.appendChild(option);
        }
}




/*
//-----------Alterar------------

 //Método para edição da escola  
 async function editarEscola(idEscola) {
     var escolaEscolhida = document.getElementById("Subtituir pelo id da escola recebido ao selecionar qual escola será editada")
     var diretorAtual = document.getElementById("Subtituir pelo id do diretor recebido ao selecionar qual escola será editada")

     //Edita a escola
     var alterarEscola = {
         "idEscola": escolaEscolhida.idEscola,
         "nome": input nome,
         "dataInicioLetivo": input dataInicio,
         "dataFinalLetivo": input dataFinal
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
//         //A opção selecionada retornará o ID do diretor
         option.value = diretores[index].idUsuario;
        
         selectDiretoresDisponiveis.appendChild(option);
     }

    
     //Remove o atual diretor deletando-o do banco de dados e atualiza o novo diretor da escola
     var idDiretorNovo = selectDiretoresDisponiveis.value;
     if (diretorAtual.idUsuario != idDiretorNovo) {
         updateDiretor(idEscola, diretorAtual.idUsuario, idDiretorNovo);
     }
    
 }

//---------Alterar----------
 /*
 Método para remover o atual diretor de uma escola, deletando-o da tabela usuario no banco de dados e atribuindo um novo diretor à escola em seguida
 */
/*
 function updateDiretor(idEscola, idDiretorAtual, idDiretorNovo) {
     //Deleta o atual diretor no banco de dados
     var deletarUsuario = await usarApi("DELETE", "http://localhost:8080/api/usuario/deletar/"+idDiretorAtual);

     //Atualiza para o novo diretor da escola
     var updateDiretor = await usarApi("PUT", "http://localhost:8080/api/diretor/escola/alterar/"+idEscola+"/"+idDiretorNovo)
 }
 */
