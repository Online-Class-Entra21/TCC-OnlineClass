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
        })

    xhr.send();

    //Pega a data atual do sistema 
    now = new Date();
    document.getElementById("dataAtual").textContent = now.getDate()+"/"+(Number(now.getMonth())+Number(1))+"/"+now.getFullYear();

    //Busca a quantidade de diretores 
    var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/diretores/quantidade");

        xhr2.addEventListener("load", function(){
            var resposta2 = xhr2.responseText; 
            var qtdDiretores = JSON.parse(resposta2);
            document.getElementById("qtdDiretores").textContent = "Quantidade Atual: "+qtdDiretores;
        })

    xhr2.send();

    //Busca a quantidade de coordenadores 
    var xhr3 = new XMLHttpRequest(); 

        xhr3.open("GET", "http://localhost:8080/api/coordenadores/quantidade");

        xhr3.addEventListener("load", function(){
            var resposta3 = xhr3.responseText; 
            var qtdCoordenadores = JSON.parse(resposta3);
            document.getElementById("qtdCoordenadores").textContent = "Quantidade Atual: "+qtdCoordenadores;
        })

    xhr3.send();

    //Busca a quantidade de professores 
    var xhr4 = new XMLHttpRequest(); 

        xhr4.open("GET", "http://localhost:8080/api/professores/quantidade");

        xhr4.addEventListener("load", function(){
            var resposta4 = xhr4.responseText; 
            var qtdProfessores = JSON.parse(resposta4);
            document.getElementById("qtdProfessores").textContent = "Quantidade Atual: "+qtdProfessores;
        })

    xhr4.send();

    //Busca a quantidade de alunos 
    var xhr5 = new XMLHttpRequest(); 

        xhr5.open("GET", "http://localhost:8080/api/alunos/quantidade");

        xhr5.addEventListener("load", function(){
            var resposta5 = xhr5.responseText; 
            var qtdAlunos = JSON.parse(resposta5);
            document.getElementById("qtdAlunos").textContent = "Quantidade Atual: "+qtdAlunos;
        })

    xhr5.send();
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
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


