// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
$(".alert").hide();
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
    if (menorHora>maiorHora) {
        $('#inputHorarioFinal').val('');
    }
});

$("#inputConfirmSenha").change(function(){
    var senha1 = $("#inputSenha").val();
    var senha2 = $("#inputConfirmSenha").val();
    console.log(senha1)
    console.log(senha2)
    if (senha1!=senha2) {
        $("#erroSenha").show();
    }else{
        $("#erroSenha").hide();
    }
});

















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

var expanded = false;


function optionPeriodos() {
    var periodos = document.getElementById("periodos");
    if (!expanded) {
        periodos.style.display = "block";
        expanded = true;
    } else {
        periodos.style.display = "none";
        expanded = false;
    }
}

function optionMaterias() {
    var materias = document.getElementById("materias");
    if (!expanded) {
        materias.style.display = "block";
        expanded = true;
    } else {
        materias.style.display = "none";
        expanded = false;
    }
}

function optionTurmas() {
  var turmas = document.getElementById("turmas");
  if (!expanded) {
    turmas.style.display = "block";
    expanded = true;
    console.log("teste")
  } else {
        turmas.style.display = "none";
        expanded = false;
    }
}

