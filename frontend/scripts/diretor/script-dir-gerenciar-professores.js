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
            carregarListasTipo1();
        })
    xhr.send();

}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}


buscarProfessores();
var curentProfessore = 0;
async function buscarProfessores(){
    var professores = await usarApi('GET','http://localhost:8080/api/professores');
    professores = JSON.parse(professores);
    var tb = $('#tbProfessores');
    for(var i = 0; i <professores.length; i++){
        const prof = professores[i];
        tb.append('<tr id="prof-'+prof.idUsuario+'">'
                    +'<th scope="row">'+prof.idUsuario+'</td>'
                    +'<td>'+prof.nome+' '+prof.sobrenome+'</td>'
                 +'</tr>');
        $('#prof-'+prof.idUsuario).click(async function(){
            var disciplinas = await usarApi("GET", "http://localhost:8080/api/disciplinas/turmas/"+prof.idUsuario);
            // console.log(disciplinas);
            criarPopUp(prof.idUsuario);
        });
    }
}

async function criarPopUp(idProfessor){
    $('#tabelaDisciplinas').empty();
    curentProfessore = idProfessor;
    var disciplinas = await usarApi("GET", "http://localhost:8080/api/disciplinas/turmas/"+idProfessor);
    disciplinas = JSON.parse(disciplinas);
    for (var i = 0; i < disciplinas.length; i++){
        const disc = disciplinas[i];
        var turma = await usarApi('GET', "http://localhost:8080/api/turma/"+disc.idTurma);
        turma = JSON.parse(turma);
        var disciplina = await usarApi('GET', "http://localhost:8080/api/disciplina/"+disc.idDisciplina);
        disciplina = JSON.parse(disciplina);
        $('#tabelaDisciplinas').append('<tr id="'+disc.idUsuario_disciplina_turma+'">'
                                            +'<th scope="row">'+turma.idTurma+'</td>'
                                            +'<td>'+turma.ano+'</td>'
                                            +'<td>'+disciplina.nome+'<input type="button" id="btnDeletar-'+disc.idUsuario_disciplina_turma+'" value="deletar" class="float-right btn-danger"></td>'
                                        +'</tr>');
        $('#btnDeletar-'+disc.idUsuario_disciplina_turma).click(async function(){
            await usarApi('DELETE', 'http://localhost:8080/api/usuarioDisciplinaTurma/deletar/'+disc.idUsuario_disciplina_turma);
            criarPopUp(idProfessor);
        });
    }
    $('#popUp').show();
    $('#divDesativar').show();
    $('#materiaSelect').val('');
    $('#turmaSelect').val('');
}



$('#btnAdicionar').click(async function(){
    var idDisciplina = $('#materiaSelect').val();
    console.log(idDisciplina)
    var idTurma = $('#turmaSelect').val();
    console.log(idTurma)
    var insertDisciplina = {
        fk_usuario: curentProfessore,
        fk_disciplina: idDisciplina
    }
    insertDisciplina = JSON.stringify(insertDisciplina);
     var idDisciplinaUsuario = await usarApi("POST","http://localhost:8080/api/usuarioDisciplina/inserirAlterar/"+insertDisciplina);
     var insertDisciplinaTurma = JSON.stringify({
        fk_turma:idTurma,
        fk_usuariorDisciplina:idDisciplinaUsuario
     });
     var insertTurmaDisciplina = await usarApi("POST","http://localhost:8080/api/usuarioDisciplinaTurma/inserirAlterar/"+insertDisciplinaTurma);
     criarPopUp(curentProfessore);
});
buscarMaterias();
buscarTurmas();
async function buscarTurmas(){
    var turmas = await usarApi("GET", "http://localhost:8080/api/turmas");
    turmas = JSON.parse(turmas);
    var select = $('#turmaSelect');
    for (var i = 0; i <turmas.length; i++){
        const turma = turmas[i];
        select.append('<option value="'+turma.idTurma+'">'+turma.ano+'</option>');
    }
}
async function buscarMaterias(){
    var materias = await usarApi("GET","http://localhost:8080/api/disciplinas");
    materias = JSON.parse(materias);
    var select = $('#materiaSelect');
    for (var i = 0; i <materias.length; i++){
        const materia = materias[i];
        select.append('<option value="'+materia.idDisciplina+'" selected>'+materia.nome+'</option>');
    }
}
$('#divDesativar').hide().click(function(){
    $('#divDesativar').hide();
    $('#popUp').hide();
});
$('#popUp').hide();
$('#btnConcluido').click(function(){
    $('#divDesativar').hide();
    $('#popUp').hide();
});
resizePopUp();
function resizePopUp() {
    var width = $(window).width()/1.2;
    var height = $(window).height()/1.2;
    var mheight = (height/2);
    var mwidth = (width/2);
    $('#popUp')
        .css('height',height)
        .css('width',width)
        .css('margin-left', '-'+mwidth+'px')
        .css('margin-top', '-'+mheight+'px');

}

$(window).resize(resizePopUp);