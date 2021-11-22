// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
console.log(idUsuario);
//Pega o id da reuniao 
var idReuniao = sessionStorage.getItem("idReuniao");
console.log(idReuniao);
//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
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

entraChamada();
var usuario;
var sala;
async function entraChamada() {
    usuario = JSON.parse(await usarApi("GET","http://localhost:8080/usuarios/"+idUsuario));
    sala = JSON.parse(await usarApi("GET","http://localhost:8080/salas/salaidreuniao/"+idReuniao));

    var nome = usuario.nome+" "+usuario.sobrenome
    var domain = "meet.jit.si";
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
    api.addListener("participantLeft",function(){
        usuarioOnline();
    });
    getListaParticipante();
}


async function getListaParticipante() {
    var reuniao = JSON.parse(await usarApi('GET','http://localhost:8080/reunioes/'+idReuniao));
    var dono = JSON.parse(await usarApi("GET","http://localhost:8080/usuarios/dto/"+reuniao.dono));
    var usuarios = JSON.parse(await usarApi("GET","http://localhost:8080/reunioes/usuarios/participantes/"+idReuniao));
    console.log(usuarios);
    usuarios.push(dono);
    usuarios.sort(function(a,b) {
        return a.nome < b.nome ? -1 : a.nome > b.nome ? 1 : 0;
    });
    console.log(sala)
    
    usuarios.forEach(element => {
        console.log(element);
        var li = $("<li></li>").text(element.nome).attr('id',element.nomecompleto);
        console.log(li)
        $("#listaParticipantes").append(li);
        
    });
    listaParticipantes = usuarios;
    console.log(listaParticipantes);
}

const interval = setInterval(() => {
    var participantes = api.getParticipantsInfo();
    var partOnline = [];
    var partTodos = [];
    participantes.forEach(element => {
        partOnline.push(element.displayName);
    });
    listaParticipantes.forEach(element => {
        partTodos.push(element.nomecompleto);
    });
    
    for (var i = 0; i < partTodos.length; i++){
        const part = partTodos[i];
        var indexPart = partOnline.indexOf(part);
        if (indexPart !== -1){
            document.getElementById(part).className = 'online';
        }else{
            console.log(part)
            document.getElementById(part).className = 'offline';
        }
    }
}, 1000);

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