// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

var idEscola;
// $('#dados').animate({
//     height: '20px'
// }, 1500);
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

getMaterias();
getTurmas();


var turmas;
async function getTurmas() {
    turmas = await usarApi('GET','http://localhost:8080/api/turmas');
    turmas = JSON.parse(turmas);
    for (var i = 0; i < turmas.length; i++){
        const turm = turmas[i];
        $("#turma").append('<label for="turma'+turm.idTurma+'"><input type="checkbox" id="turma'+turm.idTurma+'">turma '+turm.ano+'</label>')
    }
}

async function getMaterias() {
    var disciplinas = await usarApi('GET','http://localhost:8080/api/disciplinas');
    disciplinas = JSON.parse(disciplinas);
    for (var i = 0; i < disciplinas.length; i++){
        const materia = disciplinas[i];
        console.log(materia)
        $("#materias").append('<label for="'+materia.nome+'"><input type="checkbox" id="'+materia.nome+'">'+materia.nome+'</label>')
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

var isMaterias = false;
var isPeriodos = false;
var isTurma = false;


function optionPeriodos() {
    var periodos = document.getElementById("periodos");
    if (!isPeriodos) {
        $("#periodos").show();
        isPeriodos = true;
        $("#turma").hide();
        isTurma = false;
        $("#materias").hide();
        isMaterias = false;
    } else {
        $("#periodos").hide();
        isPeriodos = false;
    }
}

function optionMaterias() {
    var materias = document.getElementById("materias");
    if (!isMaterias) {
        $("#materias").show();
        isMaterias = true;
        $("#turma").hide();
        isTurma = false;
        $("#periodos").hide();
        isPeriodos = false;
    } else {
        $("#materias").hide();
        isMaterias = false;
    }
}

function optionTurmas() {
    if (!isTurma) {
        $("#turma").show();
        isTurma = true;
        $("#materias").hide();
        isMaterias = false;
        $("#periodos").hide();
        isPeriodos = false;
    } else {
        $("#turma").hide();
        isTurma = false;
    }
}
    
// segunda parte do cadastro adicionar turmas e materias

