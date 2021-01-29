// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o cep é válido 
if(idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
            document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
        })
        xhr.onerror = function () {
            alert('Sem Conexão com a Base de Dados - Erro (0001)')
            window.location = "/frontend/index.html";
        }

    xhr.send();
}else{
    // alert('Sessão expirada - Erro (0002)')
    // window.location = "/frontend/index.html";
}

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

//Método para chamada da API - requisição de lista de escolas 
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

//Método para retornar um array de escolas cadastradas no banco de dados e populá-las em uma tabela
listaEscolas();
async function listaEscolas(){
    //Inicia o loading 
    document.getElementById("idLoad").style.display = "block";
    //Faz a buscar na API
    var resposta = await usarApi("GET", "http://localhost:8080/api/escolas");
    var escolas = JSON.parse(resposta);

    //Verifica se tem alguma escola no banco de dados
    if(escolas == null){
        document.getElementById("idLoad").style.display = "none";
        document.getElementById("idErro").textContent = "Nenhuma Escola Cadastrada no Sistema";
        document.getElementById("idErro").style.display = "block";
    }else{
        var escolasIndex = []
        for (let i = 0; i < escolas.length; i++) {

            escolasIndex.push(escolas[i]);

            var linha = document.createElement("tr");
            linha.classList.add("LinhaEscolas")
            var coluna = document.createElement("td");
            coluna.classList.add("colunaEscola");
            var coluna2 = document.createElement("td");
            var input = escolas[i].nome;
                    
            coluna.append(input);
            linha.append(coluna);
            
            var diretor = await usarApi("GET","http://localhost:8080/api/diretor/escola/"+escolas[i].idEscola);
            diretor = JSON.parse(diretor);

            //Verifica se a escola tem um diretor 
            if(diretor == null){
                coluna2.append("Nenhum");
            }else{
                coluna2.append(diretor.nome);
            }

            linha.append(coluna2);
            document.getElementById('tbLista').append(linha)
        }
        //Termina o loading de carregamento 
        document.getElementById("idLoad").style.display = "none";
    }
    //Retorna o valor da linha da escola clicada
    $( ".LinhaEscolas" ).click(function() { 
        console.log(escolasIndex)
        var escolaEscolhida = escolasIndex[$(this).index()].idEscola
        sessionStorage.setItem('idEscolaSelecionada', escolaEscolhida)
        location.href = "/frontend/paginas/administrador/teste-adm-editar.html"
    });
}

/* Métodos para teste

alterarBotão();
carregarSelect();
function alterarBotão() {
    var btn = document.getElementById("btnConverter")
    if()
    btn.textContent="Remover Diretor"
}
var diretorDisp = document.getElementById("idDiretor")
async function carregarDiretor(idEscola) {
    var diretorTeste = await usarApi("GET","http://localhost:8080/api/diretor/escola/"+idEscola);
    var diretorTeste2 = JSON.parse(diretorTeste)
    diretorDisp.value = diretorTeste2.nome;
}
async function carregarSelect() {
    var resposta = await usarApi("GET", "http://localhost:8080/api/diretores");
    console.log(resposta);
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
*/


//-----------Alterar------------

// //Método para edição da escola  
// async function editarEscola(idEscola) {
//     //var escolaEscolhida = document.getElementById("Subtituir pelo id da escola recebido ao selecionar qual escola será editada")
//     //var diretorAtual = document.getElementById("Subtituir pelo id do diretor recebido ao selecionar qual escola será editada")

//     //Edita a escola
//     var alterarEscola = {
//         //"idEscola": escolaEscolhida.idEscola,
//         //"nome": input nome,
//         //"dataInicioLetivo": input dataInicio,
//         //"dataFinalLetivo": input dataFinal
//     }
//     var escolaJson = JSON.stringify(alterarEscola);
//     console.log(escolaJson);
//     var updateEscola = await usarApi("PUT", "http://localhost:8080/api/escola/alterar/"+escolaEscolhida.idEscola+"/"+escolaJson)

//     //Traz todos os diretores que podem ser adicionados à escola e popula eles em uma Drop Down list(Select)
//     //Atualizar os id's conforme necessitado pela página
//     var resposta = await usarApi("GET", "http://localhost:8080/api/diretores");
//     console.log(resposta);
//     var diretores = JSON.parse(resposta);

//     var selectDiretoresDisponiveis = document.getElementById("idSelectDiretores");
//     for (let index = 0; index < diretores.length; index++) {
//         var option = document.createElement("option");;
//         option.textContent = diretores[index].nome;
//         //A opção selecionada retornará o ID do diretor
//         option.value = diretores[index].idUsuario;
        
//         selectDiretoresDisponiveis.appendChild(option);
//     }

    
//     //Remove o atual diretor deletando-o do banco de dados e atualiza o novo diretor da escola
//     var idDiretorNovo = selectDiretoresDisponiveis.value;
//     if (diretorAtual.idUsuario != idDiretorNovo) {
//         updateDiretor(idEscola, diretorAtual.idUsuario, idDiretorNovo);
//     }
    
// }

//---------Alterar----------
// /*
// Método para remover o atual diretor de uma escola, deletando-o da tabela usuario no banco de dados e atribuindo um novo diretor à escola em seguida
// */
// function updateDiretor(idEscola, idDiretorAtual, idDiretorNovo) {
//     //Deleta o atual diretor no banco de dados
//     var deletarUsuario = await usarApi("DELETE", "http://localhost:8080/api/usuario/deletar/"+idDiretorAtual);

//     //Atualiza para o novo diretor da escola
//     var updateDiretor = await usarApi("PUT", "http://localhost:8080/api/diretor/escola/alterar/"+idEscola+"/"+idDiretorNovo)
// }