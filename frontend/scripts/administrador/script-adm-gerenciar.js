// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o cep é válido 
if(idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/usuarios/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            var dadosUsuario = JSON.parse(resposta);
            //Adiciona o nome 
            document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome +" "+dadosUsuario.sobrenome;
            //Adiciona a foto de perfil do usuario
            var img = document.querySelector("#idFotoPerfil");
            if(dadosUsuario.fotoUsuario != null){
                img.setAttribute('src', "/imagens-usuarios/"+dadosUsuario.fotoUsuario);
                img.style.borderRadius = "80%";
            }
        })

    xhr.send();
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

//Método para chamada da API - requisição de lista de escolas 
function usarApiLocal(method, url) {
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

listaEscolas();

//Método para retornar um array de escolas cadastradas no banco de dados e populá-las em uma tabela
async function listaEscolas(){

    //Inicia o loading 
    document.getElementById("idLoad").style.display = "block";

    //Faz a buscar na API
    var resposta = await usarApiLocal("GET", "http://localhost:8080/escolas");
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

            var diretor = await usarApiLocal("GET","http://localhost:8080/diretores/escola/"+escolas[i].idEscola);
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
        var escolaEscolhida = escolasIndex[$(this).index()].idEscola;
        sessionStorage.setItem('idEscolaSelecionada', escolaEscolhida)
        location.href = "/frontend/paginas/administrador/adm-editar.html";
    });  
}

