// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

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

console.log(idUsuario)
var listaalunos;
getListaParticipante();
entraChamada();

var usuario;
var sala;
var api;
async function entraChamada() {
    usuario = JSON.parse(await usarApi("GET","http://localhost:8080/api/usuario/"+idUsuario));
    sala = JSON.parse(await usarApi("GET","http://localhost:8080/api/salasPadroes/usuario/"+idUsuario));
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
    });
    api.addListener("emailChange",function(){
        api.executeCommand("email","usuario.email")
    });
}

const interval = setInterval(() => {
    var participantes = api.getParticipantsInfo();
    var partOnline = [];
    var partTodos = [];
    participantes.forEach(element => {
        partOnline.push(element.displayName);
    });
    listaalunos.forEach(element => {
        partTodos.push(element.nomecompleto);
    });
    for (var i = 0; i < partTodos.length; i++){
        const part = partTodos[i];
        var indexPart = partOnline.indexOf(part);
        if (indexPart !== -1){
            document.getElementById(part).className = 'online';
        }else{
            document.getElementById(part).className = 'offline';
        }
    }
}, 1000);
 
async function getListaParticipante() {
    var aluno = JSON.parse(await usarApi("GET","http://localhost:8080/api/aluno/usuario/"+idUsuario))
    var usuarios = JSON.parse(await usarApi("GET","http://localhost:8080/api/salasPadroes/participantes/"+aluno.fk_turma));
    usuarios.sort(function(a,b) {
        return a.nome < b.nome ? -1 : a.nome > b.nome ? 1 : 0;
    });
    console.log(sala)
    console.log(usuarios)
    usuarios.forEach(element => {
        var li = $("<li></li>").text(element.nome).attr('id',element.nomecompleto);
        $("#listaAlunos").append(li);
        
    });
    listaalunos = usuarios;
    
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

function jitsiSize() {
    var altura = $(window).height();
    var largura = $(window).width();
    var sizeTela;
    var x;
    console.log(largura)
    if (largura<1003) {
        altura = altura - (0.20*altura);
        largura = largura - (0.20*largura);
        sizeTela = largura/altura;
        if (sizeTela>1.77) {
            x = altura/9;
            largura = x*16;
        }else{
            x = largura/16;
            altura = x*9;
        }
        $("#divJitsi").height(altura+"px").width(largura+"px");
        $("#divParticipantes").width(largura+"px");
        $("#divParticipantes").height("480px");
    }else{
        altura = altura - (0.20*altura);
        largura = largura - (0.20*largura);
        sizeTela = largura/altura;
        if (sizeTela>1.77) {
            x = altura/9;
            largura = x*16;
        }else{
            x = largura/16;
            altura = x*9;
        }
        $("#divJitsi").height(altura+"px").width(largura+"px");
        $("#divParticipantes").width("170px");
        $("#divParticipantes").height(altura+"px");
    }
}

