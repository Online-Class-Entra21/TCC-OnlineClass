var escolaEscolhida = sessionStorage.getItem('idEscolaSelecionada');

//Método para chamada da api
function usarApi(method, url) {
    return new Promise(function (resolve, reject) {
        let xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.onload = function () {
            if (this.status >= 200 && this.status < 300) {
                resolve(xhr.response);
            } else {
                //document.getElementById("idLoad").style.display = "none";
                //document.getElementById("idErro").textContent = "Sem Conexão com a Base de Dados - Erro (0001)";
                //document.getElementById("idErro").style.display = "block";
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
//Retorna o id da escola a ser editada
var idEscola = sessionStorage.getItem('idEscolaSelecionada')

//Chama o método editarEscola ao clicar no botão confirmar
$("#btnEditar").click(function() {
    editarEscola(idEscola);
})


carregarCampos(idEscola);
     
//Método para carregar os campos com os atuais dados da escola 
async function carregarCampos(idEscola) {
    var resposta = await usarApi("GET", "http://localhost:8080/api/escola/" + idEscola)
    var escola = JSON.parse(resposta)
    console.log(escola)

    document.getElementById('idID').value = escola.idEscola;
    document.getElementById('idNome').value = escola.nome;
    document.getElementById('idDataInic').value = escola.dataInicioLetivo;
    document.getElementById('idDataFim').value = escola.dataFinalLetivo;

    resposta = await usarApi("GET", "http://localhost:8080/api/diretor/escola/" + idEscola)
    var diretor = JSON.parse(resposta);
 
    if (diretor.fk_escola == null) {
        document.getElementById('idDiretor').value = "Nenhum";
    } else {
        document.getElementById('idDiretor').value = diretor.nome;
    }        
}
    
//Método para edição da escola  
async function editarEscola(idEscola) {

    if (document.getElementById('idNome').value != '') {
        //Edita os Campos da escola
        var alterarEscola = {
            nome: document.getElementById('idNome').value,
            dataInicioLetivo: document.getElementById('idDataInic').value,
            dataFinalLetivo: document.getElementById('idDataFim').value
        }
        var escolaJson = JSON.stringify(alterarEscola);
        console.log(escolaJson);
        var updateEscola = await usarApi("PUT", "http://localhost:8080/api/escola/alterar/"+escolaEscolhida+"/"+escolaJson)
        if (updateEscola == false) {
            alert("Erro, Solicitação de edição mal sucedida");
            
        }
    } else {
        alert("Informe o nome!")
    } 
}   

//Método para deletar a escola
async function excluirEscola(idEscola) {
    var confirmar =  confirm("Tem certeza de que deseja excluir a escola "+ document.getElementById('idNome').value+"?")
    if (confirmar==true) {
        //Retorna o diretor
        resposta = await usarApi("GET", "http://localhost:8080/api/diretor/escola/" + idEscola)

        //Exclui o diretor
        if (resposta != null) {
            var diretor = JSON.parse(resposta);
            var excluirDiretor = await usarApi("DELETE", "http://localhost:8080/api/usuario/deletar/" + diretor.idUsuario);

        }

        //Exclui a escola
        var excluirEscola = await usarApi("DELETE", "http://localhost:8080/api/escola/deletar/" + escolaEscolhida);

        //Verificação
        if (excluirDiretor == false || excluirEscola == false) {
            alert("Ocorreu um erro ao excluir a instituição!")
        }
    }
    

}

