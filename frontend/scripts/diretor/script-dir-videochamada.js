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

async function entraChamada() {
    idReuniao = sessionStorage.getItem("idReuniao");
    usuario = JSON.parse(await usarApi("GET","http://localhost:8080/api/usuario/"+idUsuario));
    sala = JSON.parse(await usarApi("GET","http://localhost:8080/api/salaidreuniao/usuario/"+idUsuario));
    console.log(usuario);
    var nome = usuario.nome+" "+usuario.sobrenome
    var domain = "classeonline.tk";
    var options = {
        roomName: sala.link,
        parentNode: divJitsi,
        configOverwrite: {
            startWithAudioMuted: true,
            startWithVideoMuted: true
        },
        userInfo: {
            participantId: usuario.idUsuario,
            email: usuario.email,
            displayName: nome
        }

    };
    api = new JitsiMeetExternalAPI(domain, options);
    api.addListener("displayNameChange",function() {
        api.executeCommand("displayName",nome);
        usuarioOnline();
    });
    api.addListener("emailChange",function(){
        api.executeCommand("email","usuario.email")
    });
    api.addListener("participantJoined",function(){
        usuarioOnline();
    });
}

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