// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
            //Adiciona o nome 
            document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
            //Adiciona a foto de perfil do usuario
            var img = document.querySelector("#idFotoPerfil");
            img.setAttribute('src', dadosUsuario.fotoUsuario);
            img.style.borderRadius = "80%";
            carregarListasTipo1();
        })
    xhr.send();

    //Reunioes com o dono sendo o usuario 
    function carregarListasTipo1(){
        //Busca dos reunioes passadas do usuário
        var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/reunioes/"+idUsuario);

        xhr2.addEventListener("load", function(){
            var resposta2 = xhr2.responseText; 
            dadosReuniao = JSON.parse(resposta2);

            var reunioes = [];
            for (let i = 0; i < dadosReuniao.length; i++) {
                reunioes.push(dadosReuniao[i]);
            }
            carregarListasTipo2(reunioes)
        })
        xhr2.send();
    }

    //Reunioes onde o usuario participou 
    function carregarListasTipo2(reunioes){
        //Busca dos reunioes passadas do usuário
        var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/reunioes/participantes/"+idUsuario);

        xhr2.addEventListener("load", function(){
            var resposta2 = xhr2.responseText; 
            dadosReuniao = JSON.parse(resposta2);
           
            for (var i = 0; i < dadosReuniao.length; i++) {
                var passou = false;
                for (let j = 0; j < reunioes.length; j++) {
                    if(dadosReuniao[i].idReuniao == reunioes[j].idReuniao){
                        passou = true;
                    }
                }
                if(!passou){
                    reunioes.push(dadosReuniao[i]);
                }
            }

            //Ordena a tabela pela data 
            for (var i = 0; i < reunioes.length; i++) {

                var str2 = reunioes[i].dataInicio;
                var dataReuniao2 = new Date(str2.split('/').reverse().join('/'));
    
                for(let j = 0; j < reunioes.length; j++){
                    var str3 = reunioes[j].dataInicio;
                    var dataReuniao3 = new Date(str3.split('/').reverse().join('/'));
    
                    if(dataReuniao2 > dataReuniao3){
                        var elemento = reunioes[i];
                        reunioes[i] = reunioes[j];
                        reunioes[j] = elemento;
                    }
                }    
            }
            mostrar(reunioes)
        })
        xhr2.send();
    }

    //Método para chamada da API 
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

    //Mostra os resultados na tela 
    async function mostrar(reunioes){
        for (let i = 0; i < reunioes.length; i++) {

            //Pega a data da reuniao para comparacao
            var str = reunioes[i].dataInicio;
            var dataReuniao = new Date(str.split('/').reverse().join('/'));
            var dataAtual = new Date();

            //Verifica em qual lista vai 
            if(dataReuniao > dataAtual){
                //Pega a lista - tabela 
                var lista = document.getElementById("lista-programacao");
            }else{
                //Pega a lista - tabela 
                var lista = document.getElementById("lista-historico");
            }

            //Cria uma nova linha 
            var linha = document.createElement("tr");
            linha.className = "linha";

            //Cria uma nova coluna da linha - part 1 
            var coluna = document.createElement("td");
            coluna.className = "td-lista foto-usuario";

            var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/"+reunioes[i].dono);
            var usuario = JSON.parse(resposta);
            
            //Cria a imagem dentro da coluna 1
            var img = document.createElement("img");
            img.className = "img-usuario";
            img.src = usuario.fotoUsuario;
            img.alt="Foto Usuario";
            img.title="Foto do Usuário";

            //Cria uma nova coluna da linha - part 2
            var coluna2 = document.createElement("td");
            coluna2.className = "td-lista dados";

            //Cria uma nova div dentro da coluna 2 
            var div1 = document.createElement("div");
            div1.className = "div-nome";

            //Cria uma nova label dentro da div 1
            var labelNome = document.createElement("label");
            labelNome.className = "nome";
            labelNome.name = "nome";
            labelNome.title = "Nome";
            labelNome.textContent = usuario.nome;
            div1.append(labelNome);

            //Cria uma nova div dentro da coluna 2 
            var div2 = document.createElement("div");
            div2.className = "div-data";

            //Cria uma nova label dentro da div 1
            var labelData = document.createElement("label");
            labelData.className = "data";
            labelData.name = "data";
            labelData.title = "Data";
            labelData.textContent = reunioes[i].dataInicio;
            div2.append(labelData);

            //Adiciona os conteudos nas colunas 
            coluna.append(img)
            coluna2.append(div1);
            coluna2.append(div2);

            //Adiciona as colunas na linha 
            linha.append(coluna);
            linha.append(coluna2);

            //Adiciona a linha na lista - tabela 
            lista.append(linha);
        }
    }

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

//Eventos de click nos botoes 
document.getElementById("criarRelatorios").addEventListener("click", function(){
    location = "/frontend/paginas/diretor/dir-relatorios.html";
})
document.getElementById("criarReunioes").addEventListener("click", function(){
    location = "/frontend/paginas/diretor/dir-reunioes.html";
})


