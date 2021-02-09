// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
$(".alert").hide();
$(".radioMenu").hide();
//Verifica se o idUsuario é válido 
if (idUsuario != 0 && idUsuario != null) {
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest();

    xhr.open("GET", "http://localhost:8080/api/usuario/" + idUsuario);

    xhr.addEventListener("load", function () {
        var resposta = xhr.responseText;
        dadosUsuario = JSON.parse(resposta);
        //Adiciona o nome 
        document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
        //Adiciona a foto de perfil do usuario
        var img = document.querySelector("#idFotoPerfil");
        img.setAttribute('src', dadosUsuario.fotoUsuario);
        img.style.borderRadius = "80%";
    })



} else {
    // alert('Sessão expirada - Erro (0002)')
    // window.location = "/frontend/index.html";
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


$("#btnCadastrar").click(function(){
    
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        var inserirProf = {
            nome: $("#inputNome").val(),
            sobrenome: $("#inputSobrenome").val(),
            celular: $("#inputCelular").val(),
            telefone: $("#inputTelefone").val(),
            cpf: $("#inputCpf").val(),
            horarioInicioExpediente: $("#inputHorarioInicial").val(),
            horarioFinalExpediente: $("#inputHorarioFinal").val(),
            
        };
    }
});

getMaterias();
getTurmas();

async function getTurmas() {
    var turmas = await usarApi('GET','http://localhost:8080/api/turmas');
    turmas = JSON.parse(turmas);
    for (var i = 0; i < turmas.length; i++){
        const turma = turmas[i];
        $("#turma").append('<label for="turma'+turma.idTurma+'"><input type="checkbox" id="turma'+turma.idTurma+'">turma '+turma.ano+'</label>')
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
    
