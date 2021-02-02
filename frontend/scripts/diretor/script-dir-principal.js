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
            carregarListas();
        })

    xhr.send();

    function carregarListas(){
        //Busca dos reunioes passadas do usuário
        var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/reunioes/"+idUsuario);

        xhr2.addEventListener("load", function(){
            var resposta2 = xhr2.responseText; 
            dadosReuniao = JSON.parse(resposta2);

            reunioes = [];
            for (let i = 0; i < dadosReuniao.length; i++) {
                reunioes.push(dadosReuniao[i]);
            }

            for (let i = 0; i < dadosReuniao.length-1; i++) {
                var str2 = reunioes[i].dataInicio;
                var dataReuniao2 = new Date(str2.split('/').reverse().join('/'));

                var str3 = reunioes[i+1].dataInicio;
                var dataReuniao3 = new Date(str3.split('/').reverse().join('/'));

                console.log(dataReuniao2)
                if(dataReuniao2 > dataReuniao3){
                    var elemento = reunioes[i];
                    reunioes[i] = reunioes[i+1];
                    reunioes[i+1] = elemento;
                }
            }
            console.log(reunioes)
            
            for (let i = 0; i < dadosReuniao.length; i++) {

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
                
                //Cria a imagem dentro da coluna 1
                var img = document.createElement("img");
                img.className = "img-usuario";
                img.src= dadosUsuario.fotoUsuario;
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
                labelNome.textContent = dadosUsuario.nome;
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
        })

    xhr2.send();
    }
    

    // //Busca dos reunioes futuras do usuário
    // var xhr = new XMLHttpRequest(); 

    //     xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

    //     xhr.addEventListener("load", function(){
    //         var resposta = xhr.responseText; 
    //         dadosUsuario = JSON.parse(resposta);
    //         //Adiciona o nome 
    //         document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
    //         //Adiciona a foto de perfil do usuario
    //         var img = document.querySelector("#idFotoPerfil");
    //         img.setAttribute('src', dadosUsuario.fotoUsuario);
    //         img.style.borderRadius = "80%";
    //     })

    // xhr.send();

    // //Busca dos relatorios recebidos do usuário
    // var xhr = new XMLHttpRequest(); 

    //     xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

    //     xhr.addEventListener("load", function(){
    //         var resposta = xhr.responseText; 
    //         dadosUsuario = JSON.parse(resposta);
    //         //Adiciona o nome 
    //         document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
    //         //Adiciona a foto de perfil do usuario
    //         var img = document.querySelector("#idFotoPerfil");
    //         img.setAttribute('src', dadosUsuario.fotoUsuario);
    //         img.style.borderRadius = "80%";
    //     })

    // xhr.send();

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

// //Config. de nicio do programa
// function configurarInicio(){
    
// }

