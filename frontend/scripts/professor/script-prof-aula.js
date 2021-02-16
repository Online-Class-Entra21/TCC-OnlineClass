// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var convidados = [];
var userEmail;
$('.alert').hide();
//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
            userEmail = dadosUsuario.email;
            //Adiciona o nome
            document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
            $("#idDestinatario").val(dadosUsuario.nome).prop("disabled", true);
            var dataAgora = new Date();
            var dia  = String(dataAgora.getDate()).padStart(2, '0');
            var mes  = String(dataAgora.getMonth() + 1).padStart(2, '0');
            var ano  = dataAgora.getFullYear();
            var hora = String(dataAgora.getHours()).padStart(2, '0');
            var min  = String(dataAgora.getMinutes()).padStart(2, '0');;
            var dataAgora = ano+'-'+mes+'-'+dia+'T'+hora+':'+min;
            $("#idDateTime").attr("min",dataAgora);
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
    window.location = "/frontend/";
}

async function criarReuniao(){
    var data;
    var nome;
    var valido = true;
    if ($("#idDateTime").val()=="") {
        valido = false;
        $('#erroData').text('Insira uma data').show(300);
        setTimeout(function(){$('#erroData').hide(300)},1500);
    }
    if($("#idNomeReu").val()==""){
        valido = false;
        $('#erroNome').text('Insira um nome').show(300);
        setTimeout(function(){$('#erroNome').hide(300)},1500);
    }
    TurmaSelecionada = $('#lista-turmas :selected').val();
    if (convidados.length==0 && TurmaSelecionada == 'default') {
        valido = false;
        $('#erroConvidado').text('Insira um convidado ou uma turma').show(300);
        setTimeout(function(){$('#erroConvidado').hide(300)},1500);
    }
    if (valido) {
        data = new Date($("#idDateTime").val());
        nome = $('#idNomeReu').val();
        data = timeStampFormat(data);
        
        var sala = {
            nome:"Reuniao: "+nome,
            descricao: "",
            situacaoAcesso: true,
            tipoSala: true,
            link: nome.replace(" ","_")
        }
        sala = JSON.stringify(sala);
        sala = await usarApi('POST','http://localhost:8080/api/sala/inserir/return/'+sala);
        sala = JSON.parse(sala);
        var reuniao = {
            descricao : nome,
            dataInicio : data,
            dono: idUsuario,
            fk_sala: sala.idSala
        };
        reuniao = JSON.stringify(reuniao);
        var idReuniao = await usarApi('POST','http://localhost:8080/api/reuniao/personalizada/inserir/return/'+reuniao);
        $('#reuniaoCriada').text('Aula criada com sucesso').show(300);

        //Adiciona a tuma na lista de convidados 
        if(TurmaSelecionada != 'default'){
            //Chama a api e retorna um arrays com os alunos pertencentes à turma selecionada
            var resposta = await usarApi("GET", "http://localhost:8080/api/alunos/"+TurmaSelecionada);
            var alunos = JSON.parse(resposta);
    
            for(var i = 0; i < alunos.length; i++){
                //Chama a api e retorna um arrays com o usuario pertencente ao aluno do indice
                var resposta2 = await usarApi("GET", "http://localhost:8080/api/usuario/"+alunos[i].fk_usuario);
                var usuario = JSON.parse(resposta2);
                convidados.push(usuario);
            }
        }

        for (var i = 0; i < convidados.length; i++) {
            const element = convidados[i];
            var convite = {
                fk_reuniao: idReuniao,
                fk_usuario: element.idUsuario
            }
            convite = JSON.stringify(convite);
            usarApi('POST','http://localhost:8080/api/reuniaoUsuario/inserir/'+convite);
        }
    }
    
}

$('#btnCriarReuniao').click(criarReuniao);
$('#btnAddConvite').click(convidar);
$('#inConvidado').bind("enterKey",convidar);

async function convidar(){
    var email = $('#inConvidado').val();
    var form = $('form');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        if (email=='') {
            $('#erroEmail').text('Insira um email').show(300);
            setTimeout(function(){$('#erroEmail').hide(300)},1500);
        }else if (email==userEmail) {
            $('#erroEmail').text('Não insira o seu email').show(300);
            setTimeout(function(){$('#erroEmail').hide(300)},1500);
        }else{
            var user = JSON.parse(await usarApi('GET','http://localhost:8080/api/usuario/email/'+email));
            if (user.idUsuario==0) {
                $('#erroEmail').text('usuario nao existe').show(300);
                setTimeout(function(){$('#erroEmail').hide(300)},1500)
            }else{
                var jaExiste = false;
                for (var i = 0; i < convidados.length; i++) {
                    const convidado = convidados[i];
                    if (convidado.email == user.email) {
                        jaExiste = true;
                    }
                }
                if (!jaExiste) {
                    convidados.push(user)
                    $('#tbConvidados').append('<tr><th><img src="/imagens-usuarios/'+user.fotoUsuario+'" alt="" width="32" style="border-radius: 80%;">'+user.email+'</th></tr>')

                    $('#emailCerto').text('Email adicionado com sucesso').show(300);
                    setTimeout(function(){$('#emailCerto').hide(300)},1500);
                }else{
                    $('#erroEmail').text('Email já inserido').show(300);
                    setTimeout(function(){$('#erroEmail').hide(300)},1500);
                }
            }
        }
    }
}

$('#inConvidado').keyup(function(e){
    if(e.keyCode == 13)
    {
        $(this).trigger("enterKey");
    }
});

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

carregarSelect();
//Método para carregar o select com as turmas existentes
async function carregarSelect() {
    //Chama a api e retorna um arrays com as turmas pertencentes à escola e há esse professor
    var resposta = await usarApi("GET", "http://localhost:8080/api/turmas/professor/"+idUsuario);
    var turmas = JSON.parse(resposta);
    var select = document.getElementById('lista-turmas');

    //Cria os options do select
    for (let index = 0; index < turmas.length; index++) {
        
        var option = document.createElement('option');
        option.textContent = turmas[index].ano;
        option.value = turmas[index].idTurma;
        option.classList.add('optionTurmas')

        select.append(option);
    }
}

