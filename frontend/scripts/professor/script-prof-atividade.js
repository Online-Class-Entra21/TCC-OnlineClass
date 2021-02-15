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
    // alert('Sessão expirada - Erro (0002)')
    // window.location = "/frontend/index.html";
}

var idProfessor = sessionStorage.getItem('idUsuario');
$('#idDisci').prop('disabled',true);
pegarTurmas();
var arquivo;

var dataAgora = new Date();
var dia  = String(dataAgora.getDate()).padStart(2, '0');
var mes  = String(dataAgora.getMonth() + 1).padStart(2, '0');
var ano  = dataAgora.getFullYear();
var hora = String(dataAgora.getHours()).padStart(2, '0');
var min  = String(dataAgora.getMinutes()).padStart(2, '0');;
var dataAgora = ano+'-'+mes+'-'+dia+'T'+hora+':'+min;
$("#idDateTime").attr("min",dataAgora);

$('#customFile').change(function(){
    var nomeArquivo = $(this).val().substring(12);
    arquivo = this.files;
    console.log(nomeArquivo);
    $('.custom-file-label').text(nomeArquivo);
});

async function pegarTurmas(){
    var turmas = await usarApi("GET", "http://localhost:8080/api/disciplinas/turmas/"+idProfessor);
    turmas = JSON.parse(turmas);
    var turmasID = [];
    for (let index = 0; index < turmas.length; index++) {
        const turma = turmas[index].idTurma;
        var teste = turmasID.indexOf(turma);
        if (teste==-1) {
            turmasID.push(turma);
        }
    }
    for (let index = 0; index < turmasID.length; index++) {
        const idTurma = turmasID[index];
        var turma = await usarApi("GET", "http://localhost:8080/api/turma/"+idTurma);
        turma = JSON.parse(turma);
        $('#idTurma').append('<option value="'+idTurma+'">'+turma.ano+'</option>');
    }
}
var turma_usuario_disciplina;
async function pegarMaterias(idTurma){
    var turma_disciplina = await usarApi("GET", "http://localhost:8080/api/turmasUsuariosDisciplinas/"+idTurma+"/"+idProfessor);
    turma_disciplina = JSON.parse(turma_disciplina);
    turma_usuario_disciplina = turma_disciplina;
    $('#idDisci').prop('disabled',false);
    $('#idDisci').empty();
    $('#idDisci').append('<option value="0">-Seleciona a Disciplina</option>'); 
    for (var i = 0; i <turma_disciplina.length; i++){
        var turmadisci = turma_disciplina[i].fk_usuariorDisciplina
        var idDisciplina = JSON.parse(await usarApi("GET", "http://localhost:8080/api/usuarioDisciplina/"+turmadisci)).fk_disciplina;
        var disciplina = JSON.parse(await usarApi("GET", "http://localhost:8080/api/disciplina/"+idDisciplina));
        $('#idDisci').append('<option value="'+idDisciplina+'">'+disciplina.nome+'</option>');
    }
}
$('#idTurma').change(function(){
    var idTurma = $(this).val();
    if (idTurma >0){
        pegarMaterias($(this).val());
    }else{
        $('#idDisci').empty();
        $('#idDisci').append('<option value="0">-Seleciona Uma Turma Antes</option>');
        $('#idDisci').prop('disabled',true);
    }
});

$('#btnEnviar').click(async function (){
    form = $('#form1');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        if ($('#idTipo')!=0) {
            if(arquivo!=undefined){
                if ($('#idDisci').val()!='0') {
                    
                
                    var descricao = $('textarea').val();
                    var incioatividae = new Date().toISOString().replace('T',' ').replace('Z',' ');
                    var tipoatividade = $('#idTipo').val();
                    var finalatividae = new Date($('#idDateTime').val()).toISOString().replace('T',' ').replace('Z',' ');
                    var titulo = $('#idTitle').val();
                    
                    var json = JSON.stringify({fk_usuario:idProfessor,fk_disciplina:$('#idDisci').val()});
                    var fk_usuario_disciplina = await usarApi('POST','http://localhost:8080/api/usuarioDisciplina/inserirAlterar/'+json);
                    var fk_arquivo
                    
                    fk_arquivo = await enviarArquivo(arquivo,'http://localhost:8080/api/upload/file/return/'+idProfessor);
                    
                    
                    console.log("descricao : "+descricao);
                    console.log("inicioatividade : "+incioatividae);
                    console.log("finalatividae : "+finalatividae);
                    console.log("tipoatividade : "+tipoatividade);
                    console.log("fk_usuario_disciplina : "+fk_usuario_disciplina);
                    console.log("titulo : "+titulo);
                    console.log("fk_arquivo : "+fk_arquivo);
                    var json = JSON.stringify({
                        descricao       : descricao,
                        inicioAtividade : '2021-02-14 22:04:03',
                        finalAtividade  : finalatividae,
                        tipoAtividade   : tipoatividade,
                        fk_usuarioDisciplina : fk_usuario_disciplina,
                        titulo          : titulo,
                        fk_arquivo      : fk_arquivo
                    });
                    console.log(json)
                    var idAtividade = await usarApi('POST','http://localhost:8080/api/atividade/inserir/return/'+json);
                    var jsonTurmaAtividade = JSON.stringify({
                        fk_turma:$('#idTurma').val(),
                        fk_atividade:idAtividade
                    });
                    console.log(jsonTurmaAtividade)
                    
                    await usarApi('POST','http://localhost:8080/api/turmaAtividade/inserir/'+jsonTurmaAtividade);
                    alert('secesso enviado')
                }else{
                    alert('Insira 1 Materia')
                }
            }else{
                alert('Insira 1 arquivo')
            }
        }else{
            alert('Insira 1 tipo')
        }
        
    }
});


async function enviarArquivo(file,url){
    return new Promise(function (resolve, reject) {
        var size = file[0].size;
        console.log(size)
        if(size < 1048576) { //1MB
        
        } else {           
          alert('Arquivo muito grande envie outro com menos de 1 mega')
          return;
        }
        
        var files = file[0];
        var xhr = new XMLHttpRequest();
        var fd = new FormData();
    
        fd.append( "file", files, files.name);
        xhr.open("POST", url, true);
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
        xhr.send(fd);
    });
}