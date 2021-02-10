// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

var idEscola;

$('#inputCep').val('89023760');
$('#inputCpf').val('89054823760');
$('#inputNome').val('Cacau');
$('#inputSobrenome').val('Show');
$('#inputCelular').val('47988885466');
$('#inputTelefone').val('4733885466');
$('#inputEmail').val('cacau@gmail.com');


$(".alert").hide();
$(".radioMenu").hide();
//Verifica se o idUsuario é válido 
if (idUsuario != 0 && idUsuario != null) {
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest();

    console.log("teste03")
    dadosUsuario();
    async function dadosUsuario() {
        console.log("teste02")
        var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/" + idUsuario);
        console.log("teste01")
        dadosUsuario = JSON.parse(resposta);
        //Adiciona o nome 
        document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
        idEscola = dadosUsuario.fk_escola;
        //Adiciona a foto de perfil do usuario
        var img = document.querySelector("#idFotoPerfil");
        img.setAttribute('src', '/imagens-usuarios/'+dadosUsuario.fotoUsuario);
        img.style.borderRadius = "80%";
    }
    
    



} else {
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}
$("#inputCelular").mask("(00) 00000-0000");
$("#inputTelefone").mask("(00) 0000-0000");
$("#inputCpf").mask("000.000.000-00");
$("#inputCep").mask("00000-000");

$("#inputCep").change(async function () {
    var cep = $(this).val()
    console.log(cep.length)
    if (cep.length == 9) {
        cep = cep.replace("-", "");
        var ende = await usarApi('GET', 'https://viacep.com.br/ws/' + cep + '/json/');
        ende = JSON.parse(ende);
        if (ende.erro) {
            console.log("testDone")
        } else {
            console.log(ende)
            $("#inputEstado").val(ende.uf)
            $("#inputCidade").val(ende.localidade)
            $("#inputBairro").val(ende.bairro)
            $("#inputLogradouro").val(ende.logradouro)
        }

    }
});

$('#inputHorarioFinal').change(function () {
    var menorHora = $('#inputHorarioInicial').val();
    var maiorHora = $('#inputHorarioFinal').val();
    if (menorHora > maiorHora) {
        $('#inputHorarioFinal').val('');
    }
});

$("#inputConfirmSenha").change(function () {
    var senha1 = $("#inputSenha").val();
    var senha2 = $("#inputConfirmSenha").val();
    console.log(senha1)
    console.log(senha2)
    if (senha1 != senha2) {
        $("#erroSenha").show();
    } else {
        $("#erroSenha").hide();
    }
});


$("#btnCadastrar").click(async function(){
    if ($("#inputSenha").val().length>7) {
        console.log("click");
        if(!form[0].checkValidity()) {
            console.log("form errado");
            $('<input type="submit">').hide().appendTo(form).click().remove();
        }else{
            console.log("form certo");
            var endereco = {
                estado: $("#inputEstado").val(),
                cidade: $("#inputCidade").val(),
                bairro: $("#inputBairro").val(),
                rua: $("#inputLogradouro").val(),
                numero: $("#inputNumero").val(),
                cep: $("#inputCep").val(),
                complemento: $("#inputTipoLogradouro").val()
            };
            var jsonendereco = JSON.stringify(endereco);
            var idEndereco = await usarApi('POST', 'http://localhost:8080/api/endereco/inseriralterar/'+jsonendereco);
            console.log(idEndereco);
            var horarioFinal = document.getElementById('inputHorarioFinal').valueAsDate;
            var horaInicial = document.getElementById('inputHorarioInicial').valueAsDate;
            horarioFinal.setHours(horarioFinal.getHours()+3);
            horaInicial.setHours(horaInicial.getHours()+3);
            var inserirProf = {
                nome: $("#inputNome").val(),
                sobrenome: $("#inputSobrenome").val(),
                celular: $("#inputCelular").val(),
                telefone: $("#inputTelefone").val(),
                cpf: $("#inputCpf").val(),
                horarioInicioExpediente: horaInicial,
                horarioFinalExpediente: horarioFinal,
                fk_endereco: idEndereco,
                email: $("#inputEmail").val(),
                senha: $("#inputSenha").val(),
                tipoUsuario: 4,
                fk_escola: idEscola
            };
            usarApi('POST','http://localhost:8080/api/usuario/inserir/'+JSON.stringify(inserirProf))
            alert('Inserido com sucesso '+JSON.stringify(inserirProf))
        }
    }
});

getTurmas();
getMaterias($('#turma1').attr('id'));
getMaterias($('#turma2').attr('id'));


var turmas;
async function getTurmas() {
    turmas = await usarApi('GET','http://localhost:8080/api/turmas');
    turmas = JSON.parse(turmas);
    for (var i = 0; i < turmas.length; i++){
        const turm = turmas[i];
        $("#turma").append('<label for="turma'+turm.idTurma+'"><input type="checkbox" name="'+turm.ano+'" id="turma'+turm.idTurma+'">turma '+turm.ano+'</label>')
    }
}





function getSelTurmas() {
    var turmas = $('input[id^="turma"]:checked');
    console.log(turmas)
    for (var i = 0; i <turmas.length;i++){
        const turma = turmas[i];
        
    }
}

$('#testebtn').click(function(){
    getSelTurmas();
})






//Evento de abertura do menu 
document.getElementById("mostrar").addEventListener("mouseover", function () {
    abrirMenu();
})
document.getElementById("idImgMenu").addEventListener("mouseover", function () {
    abrirMenu();
})

//Abertura do menu
function abrirMenu() {
    document.getElementById("menu").style.display = "block";
}

//Evento de fechamento do menu 
document.getElementById("menu").addEventListener("mouseleave", function () {
    document.getElementById("menu").style.display = "none";
})


//---> Referencia checkbox inside select
//---> https://stackoverflow.com/questions/17714705/how-to-use-checkbox-inside-select-option
//-> Checkbox Inside Select code:


function optionTurmas() {
    $('#turma').toggle();
}
    
// segunda parte do cadastro adicionar turmas e materias
$('#turmaMataria').hide();
$('#testebtn').click(async function(){
    await $('#dados').slideToggle('slow');
    await $('#turmaMataria').slideToggle('slow');
    var turmas = $('input[id^="turma"]:checked');
    for (var i = 0; i < turmas.length; i++){
        const turma = turmas[i];
        $("#tab-turma").append('<tr>'
        +'<td>'
            +'<label for="turma">'+turma.name+'</label>'
        +'</td>'
        +'<td class="input" id="'+turma.id+'">'
            
        +'</td>'
        +'</tr>')
        console.log($('#'+turma.id).attr('id'))
        getMaterias($('#'+turma.id).attr('id'));
    }

});


async function getMaterias(idTurma) {
    var disciplinas = await usarApi('GET','http://localhost:8080/api/disciplinas');
    disciplinas = JSON.parse(disciplinas);
    console.log($('td#'+idTurma)[0]);
    $('td#'+idTurma).append('<div name="materias'+idTurma+'" class="selectBox">'
                    +'<select>'
                        +'<option>Informe as Matérias</option>'
                    +'</select>'
                    +'<div  id="'+idTurma+'-sel" class="overSelect"></div>'
                +'</div>'
                +'<div id="materias'+idTurma+'" class="radioMenu">'
               +'</div>');
    for (var i = 0; i < disciplinas.length; i++){
        const materia = disciplinas[i];
        // console.log(materia)
        $("#materias"+idTurma).append('<label for="'+materia.nome+'-'+idTurma+'"><input type="checkbox" id="'+materia.nome+'-'+idTurma+'">'+materia.nome+'</label>')
    }
    $("#materias"+idTurma).hide();
    $('#'+idTurma+'-sel').click(function() {
        // console.log('teste');
        var materias = document.getElementById("materias");
        var idTSel = $(this).parent().attr("name");
        // console.log($("#"+idTeste))
        
        $("#"+idTSel).toggle();
    });
}
