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
var diretorSelect = null;
//Método para retornar o id do diretor selecionado no select
$(".SDiretor").change(function(){
    diretorSelect = $(this).children("option:selected").val();
}); 

//Chama o método editarEscola ao clicar no botão confirmar
$("#btnEditar").click(function() {
    editarEscola(idEscola);
})


carregarCampos(idEscola);
carregarSelect();
     
//Método para carregar os campos com os atuais dados da escola 
async function carregarCampos(idEscola) {
    var resposta = await usarApi("GET", "http://localhost:8080/api/escola/" + idEscola)
    var escola = JSON.parse(resposta)
    console.log(escola)

    document.getElementById('idID').value = escola.idEscola;
    document.getElementById('idNome').value = escola.nome;
    //document.getElementById('idDataInic').textContent = escola.dataInicioLetivo;
    //document.getElementById('idDataFim').textContent = escola.dataFinalLetivo;

    resposta = await usarApi("GET", "http://localhost:8080/api/diretor/escola/" + idEscola)
    var diretor = JSON.parse(resposta);
    var btnDiretor = document.getElementById('btnDiretor');

    //Se a escola não possuir um diretor, Torna visivel o Select com os diretores disponíveis. Caso houver diretor, Torna visível o botão "Remover diretor"
    if (diretor.fk_escola == null) {
        document.getElementById('idDiretor').value = "Nenhum";
        document.getElementById('SelectDiretor').hidden = false;
    } else {
        btnDiretor.hidden = false;
        document.getElementById('idDiretor').value = diretor.nome;
    }

            
}
    
//Método para carregar o select com os diretores que não tenham uma escola cadastrada
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

//Método para edição da escola  
async function editarEscola(idEscola) {
    //var resposta = await usarApi("GET", "http://localhost:8080/api/diretor/escola/" + idEscola);
    //var diretorAtual = JSON.parse(resposta);
    
    if (document.getElementById('idNome').value != '') {
        //Edita os Campos da escola
        var alterarEscola = {
            idEscola: idEscola,
            nome: document.getElementById('idNome').value,
            dataInicioLetivo: document.getElementById('idDataInic').value,
            dataFinalLetivo: document.getElementById('idDataFim').value
        }
        var escolaJson = JSON.stringify(alterarEscola);
        console.log(escolaJson);
        var updateEscola = await usarApi("PUT", "http://localhost:8080/api/escola/alterar/"+escolaEscolhida.idEscola+"/"+escolaJson)
        if (updateEscola == false) {
            alert("Erro, Solicitação de edição mal sucedida");
            
        }
        /*
        //Edita o Diretor
        if (diretorAtual.fk_escola != diretorSelect) {
            updateDiretor(idEscola, diretorAtual.idUsuario, diretorSelect)
        }
       */
    } else {
        alert("Informe o nome!")
    }
    
}   


//Método para alterar o diretor
async function updateDiretor(idEscola, idDiretorAtual, idDiretorNovo) {
    //Altera o atual diretor no banco de dados
    var removerDiretor = await usarApi("PUT", "http://localhost:8080/api/diretor/escola/remover/" + idDiretorAtual);
    //Atualiza para o novo diretor da escola
    var alterarDiretor = await usarApi("PUT", "http://localhost:8080/api/diretor/escola/alterar/"+idEscola+"/"+idDiretorNovo)
    if (removerDiretor == false || alterarDiretor == false) {
        alert("Erro, Solicitação de edição de diretor mal sucedida");
    }
}

