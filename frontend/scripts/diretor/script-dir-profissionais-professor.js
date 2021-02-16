// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var idEscola;

$(".alert").hide();
$(".radioMenu").hide();
//Verifica se o idUsuario é válido 
if (idUsuario != 0 && idUsuario != null) {
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest();

    dadosUsuario();
    async function dadosUsuario() {
    
        var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/" + idUsuario);
    
        dadosUsuario = JSON.parse(resposta);
        //Adiciona o nome 
        document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome+" "+dadosUsuario.sobrenome;
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

    if (cep.length == 9) {
        cep = cep.replace("-", "");
        var ende = await usarApi('GET', 'https://viacep.com.br/ws/' + cep + '/json/');
        ende = JSON.parse(ende);
        if (ende.erro) {
        
        } else {
        
            $("#inputEstado").val(ende.uf)
            $("#inputCidade").val(ende.localidade)
            $("#inputBairro").val(ende.bairro)
            $("#inputLogradouro").val(ende.logradouro)
        }

    }
});

function verificarHora() {
    var menorHora = $('#inputHorarioInicial').val();
    var maiorHora = $('#inputHorarioFinal').val();
    if (menorHora > maiorHora) {
        $('#inputHorarioFinal').css("border-color","red");
        return false;
    }else{
        $('#inputHorarioFinal').css("border-color","green");
        return true;
    }
}

$('#inputHorarioFinal').change(verificarHora);

function confirmSenha() {
    var senha1 = $("#inputSenha").val();
    var senha2 = $("#inputConfirmSenha").val();

    if (senha1.length<8) {
        $("#inputSenha").css("border-color","red");
    }else{
        $("#inputSenha").css("border-color","green");
        if (senha1 != senha2) {
            $("#inputConfirmSenha").css("border-color","red");
            $("#erroSenha").show();
        } else {
            $("#inputConfirmSenha").css("border-color","green");
            $("#erroSenha").hide();
        }
    }
};

$('#inputSenha').change(confirmSenha);
$("#inputConfirmSenha").change(confirmSenha);

getTurmas();
getMaterias($('#turma1').attr('id'));
getMaterias($('#turma2').attr('id'));

async function getTurmas() {
    turmas = await usarApi('GET','http://localhost:8080/api/turmas');
    turmas = JSON.parse(turmas);
    for (var i = 0; i < turmas.length; i++){
        const turm = turmas[i];
        $("#turma").append('<label for="turma'+turm.idTurma+'"><input type="checkbox" name="'+turm.ano+'" id="turma'+turm.idTurma+'"> '+turm.ano+'</label>')
    }
}

function getSelTurmas() {
    var turmas = $('input[id^="turma"]:checked');

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
$('#btnAvancar').click(async function(){
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        if ($("#inputSenha").val().length>7 && $("#inputSenha").val()==$("#inputConfirmSenha").val()) {
            var email = $("#inputEmail").val();
            var resp = await usarApi("GET", "http://localhost:8080/api/verificar/"+ email);
            var isExisteEmail = JSON.parse(resp);

            if(!isExisteEmail){
                var cpf = $('#inputCpf').val();
                console.log(cpf);
                //Verifica se o cpf é válido
                var cpfValida = cpf.replace(".", "");
                cpfValida = cpfValida.replace(".", "");
                cpfValida = cpfValida.replace("-", "");

                var isValido = TestaCPF(cpfValida);
                if (isValido){
                    var isHoraValida = verificarHora();
                    if (isHoraValida){

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
                            +'</tr>');
                            
                            getMaterias($('#'+turma.id).attr('id'));
                        }
                    }else{
                        alert('informe um horario final maior que o horario inicial');
                    }
                }else{
                    alert('cpf invalido')
                }
            }else{
                alert('Email já existe.');
            }
        }else{
            alert('Senha Invalida.');
        }
    }
});

async function getMaterias(idTurma) {
    var disciplinas = await usarApi('GET','http://localhost:8080/api/disciplinas');
    disciplinas = JSON.parse(disciplinas);

    $('td#'+idTurma).append('<div name="materias'+idTurma+'" class="selectBox">'
                    +'<select class="form-control">'
                        +'<option>Informe as Matérias</option>'
                    +'</select>'
                    +'<div  id="'+idTurma+'-sel" class="overSelect"></div>'
                +'</div>'
                +'<div id="materias'+idTurma+'" class="radioMenu">'
               +'</div>');
    for (var i = 0; i < disciplinas.length; i++){
        const materia = disciplinas[i];
    
        $("#materias"+idTurma).append('<label for="Materia-'+materia.nome+'-'+idTurma+'"><input name="'+materia.idDisciplina+'" type="checkbox" id="Materia-'+materia.nome+'-'+idTurma+'">'+materia.nome+'</label>');
    }
    $("#materias"+idTurma).hide();
    $('#'+idTurma+'-sel').click(function() {
    
        var materias = document.getElementById("materias");
        var idTSel = $(this).parent().attr("name");
    
        
        $("#"+idTSel).toggle();
    });
}

$('#btnCadastrar').click(async function() {
    //posta o endereco no banco de dados
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
    var horarioFinal = document.getElementById('inputHorarioFinal').valueAsDate;
    var horaInicial = document.getElementById('inputHorarioInicial').valueAsDate;
    horarioFinal.setHours(horarioFinal.getHours()+3);
    horaInicial.setHours(horaInicial.getHours()+3);

    // cria o json do professor no banco de dados
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
    var idProfessor = await usarApi('POST','http://localhost:8080/api/usuario/inserir/return/'+JSON.stringify(inserirProf));
    alert('Professor cadastrado com sucesso');

    //pega o professor e junta nas tabeelas
    var materiasCheck = $('input[id^="Materia"]:checked');
    var idMaterias = [];

    for (var i = 0; i <materiasCheck.length;i++){
        const disciplina = materiasCheck[i];
    
        var idDisciplina = parseInt(disciplina.name);
        var idTurma = disciplina.id;
        idTurma = idTurma.substr(idTurma.indexOf("turma"));
        idTurma = parseInt(idTurma.replace('turma', ''));
        var idUsuarioDisciplinaTurma = await usarApi('POST','http://localhost:8080/api/usuarioDisciplina/inserirAlterar/'+JSON.stringify({fk_usuario:idProfessor,fk_disciplina:idDisciplina}));
        var insertTurmaDisciplina = {
            fk_turma:idTurma,
            fk_usuariorDisciplina:idUsuarioDisciplinaTurma
        }
    
        await usarApi('POST','http://localhost:8080/api/usuarioDisciplinaTurma/inserir/'+JSON.stringify(insertTurmaDisciplina))
    }
});