jitsiSize();
// entraChamada();
$(window).resize(function(){
    jitsiSize();
});
var usuario;
var sala;
var api;
async function entraChamada() {
    usuario = JSON.parse(await usarApi("GET","http://localhost:8080/api/usuario/"+2));
    sala = JSON.parse(await usarApi("GET","http://localhost:8080/api/salasPadroes/turma/"+2));
    console.log(usuario);
    var domain = "jitsi.0nlineclass.tk";
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
            displayName: usuario.nome
        }
    };
    api = new JitsiMeetExternalAPI(domain, options);
    api.addListener("displayNameChange",function() {
        api.executeCommand("displayName",usuario.nome)
        api.executeCommand("formattedDisplayName",usuario.nome)
        
        usuarioOnline();
    });
    api.addListener("emailChange",function(){
        api.executeCommand("email",usuario.email)
    });
}

function usuarioOnline() {
    var participantes = api.getParticipantsInfo();
    console.log(participantes);
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