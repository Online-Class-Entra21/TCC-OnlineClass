// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var userEmail;

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
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
            userEmail = dadosUsuario.email;
        })

    xhr.send();
    
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

var fk_escola = sessionStorage.getItem('escolaUsuario');
var idUsuario = sessionStorage.getItem('idUsuario');
carregarSelect();

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

//Métodos onclick dos botões
var btnCadastrar = document.getElementById('btnCadastrar');
var btnAtualizar = document.getElementById('btnAtualizar');
var btnExcluir = document.getElementById('idBtn');
btnExcluir.addEventListener("click", function() {
    deletarTurma();
})
btnCadastrar.addEventListener("click", function() {
    cadastrar();
})
btnAtualizar.addEventListener("click", function() {
    atualizar();
})

//Método para os botões radio
function eventoRadio(radioB) {
    var opcaoEscolhida = radioB.value;
    if (opcaoEscolhida == 'cadastrar') {
        document.getElementById('SelectTurma').disabled = true;
        document.getElementById('idBtn').hidden = true;
        document.getElementById('inputNome').disabled = false;
        document.getElementById('InputQtdAlunos').disabled = true;
        document.getElementById('inputHoraInicio').disabled = false;
        document.getElementById('inputHoraFinal').disabled = false;
        document.getElementById('btnCadastrar').hidden = false;
        document.getElementById('btnAtualizar').hidden = true;
        $('#divSelect').css('display', 'none');
        $("#tbLista").empty();
        document.getElementById("formulario").reset();

    } else {
        $("#SelectTurma").val("default");
        $("#tbLista").empty();
        document.getElementById('inputNome').value = '';
        document.getElementById('InputQtdAlunos').value = '';
        document.getElementById('inputHoraInicio').value = '';
        document.getElementById('inputHoraFinal').value = '';
        document.getElementById('inputNome').disabled = true;
        document.getElementById('InputQtdAlunos').disabled = true;
        document.getElementById('inputHoraInicio').disabled = true;
        document.getElementById('inputHoraFinal').disabled = true;
        document.getElementById('SelectTurma').disabled = false;
        document.getElementById('idBtn').hidden = true;
        document.getElementById('btnCadastrar').hidden = true;
        document.getElementById('btnAtualizar').hidden = true;
        $('#divSelect').css('display', 'block');
    }
}

//Método para o select
$( "#SelectTurma" ).change(function() { 
    var turmaEscolhida = $('#SelectTurma :selected').val();
    var nomeTurmaEscolhida = $('#SelectTurma :selected').text();
    $("#tbLista").empty();
    if (turmaEscolhida == 'default') {
        document.getElementById('inputNome').value = '';
        document.getElementById('InputQtdAlunos').value = '';
        document.getElementById('inputHoraInicio').value = '';
        document.getElementById('inputHoraFinal').value = '';
        document.getElementById('inputNome').disabled = true;
        document.getElementById('InputQtdAlunos').disabled = true;
        document.getElementById('inputHoraInicio').disabled = true;
        document.getElementById('inputHoraFinal').disabled = true;
        document.getElementById('btnCadastrar').hidden = true;
        document.getElementById('btnAtualizar').hidden = true;
        document.getElementById('idBtn').hidden = true;
    } else {
        document.getElementById('btnCadastrar').hidden = true;
        document.getElementById('btnAtualizar').hidden = false;
        document.getElementById('inputNome').disabled = false;
        document.getElementById('InputQtdAlunos').disabled = true;
        document.getElementById('inputHoraInicio').disabled = false;
        document.getElementById('inputHoraFinal').disabled = false;
        document.getElementById('idBtn').hidden = false;

        carregarListaAlunos(turmaEscolhida, nomeTurmaEscolhida);
        carregarCampos(turmaEscolhida);
    }
});  

//Método para o cadastro de uma turma
async function cadastrar() {
    //Coleta os dados do input
    var turma = document.getElementById('inputNome').value;
    var horaInicioAula = new Date(document.getElementById('inputHoraInicio').valueAsDate);
    var horaFinalAula = new Date(document.getElementById('inputHoraFinal').valueAsDate);

    //Verifica os campos
    if(turma == '' || horaInicioAula == "Wed Dec 31 1969 21:00:00 GMT-0300 (Horário Padrão de Brasília)" || horaFinalAula == "Wed Dec 31 1969 21:00:00 GMT-0300 (Horário Padrão de Brasília)") {
       alert("Preencha os campos")
    }else {

        //Cria o Objeto turma
        var inserirTurma = {
            ano: turma,
            qtdaluno: null,
            horarioInicioAula: horaInicioAula,
            horarioFinalAula: horaFinalAula,
            fk_sala: 1,
            fk_escola: fk_escola
        }

        //Converte para JSON
        var turmaJson = JSON.stringify(inserirTurma);

        //Chama a api para cadastrar a turma
        var insertTurma = await usarApi("POST", "http://localhost:8080/api/turma/inserir/" + turmaJson);

        if (insertTurma == false) {
            alert("Ocorreu um erro ao cadastrar a turma.")
        } else {
            alert("Turma cadastrada com sucesso.")
            document.getElementById('inputNome').value = '';
            document.getElementById('InputQtdAlunos').value = '';
            document.getElementById('inputHoraInicio').value = '';
            document.getElementById('inputHoraFinal').value = '';
            $("#SelectTurma").empty();
            var opt = document.createElement("option");
            opt.value = "default";
            opt.textContent = "Selecione uma turma"
            document.getElementById("SelectTurma").append(opt)
            carregarSelect();
        }
    }
}

//Método para atualizar a turma
async function atualizar() {
    //Coleta os dados do input
    var turma = document.getElementById('inputNome').value;
    //Converte a data de inicio para pegar só o horário
    var horaInicioAula = new Date(document.getElementById('inputHoraInicio').valueAsDate);
    var horaFinalAula = new Date(document.getElementById('inputHoraFinal').valueAsDate);
    
    var qtdAluno = document.getElementById('InputQtdAlunos').value;
    
    //Verifica o campo nome
    if(turma == '') {
       alert("Preencha os campos")
    }else{
        //Cria o objeto turma
        var alterarTurma = {
            ano: turma,
            qtdAluno: qtdAluno,
            horarioInicioAula: horaInicioAula,
            horarioFinalAula: horaFinalAula,
            fk_sala: 1,
            fk_escola: fk_escola,
            idTurma: $('#SelectTurma :selected').val()
            
        }

        //Converte para Json
        var turmaJson = JSON.stringify(alterarTurma);
        var updateEscola = await usarApi("PUT", "http://localhost:8080/api/turma/alterar/"+turmaJson);
        var resposta = JSON.parse(updateEscola)
                    
        if (!resposta) {
            alert("Erro ao salvar edição!");
        }else{
            alert("Atualizado com sucesso.")
            document.getElementById('inputNome').value = '';
            document.getElementById('InputQtdAlunos').value = '';
            document.getElementById('inputHoraInicio').value = '';
            document.getElementById('inputHoraFinal').value = '';
            $("#SelectTurma").empty();
            var opt = document.createElement("option");
            opt.value = "default";
            opt.textContent = "Selecione uma turma"
            document.getElementById("SelectTurma").append(opt)
            $("#tbLista").empty();
            carregarSelect();
            document.getElementById('inputNome').disabled = true;
            document.getElementById('InputQtdAlunos').disabled = true;
            document.getElementById('inputHoraInicio').disabled = true;
            document.getElementById('inputHoraFinal').disabled = true;
            document.getElementById('btnAtualizar').hidden = true;
            document.getElementById('idBtn').hidden = true;
        }
    }        
}

//Método para carregar o select com as turmas existentes
async function carregarSelect() {
    //Chama a api e retorna um arrays com as turmas pertencentes à escola
    var resposta = await usarApi("GET", "http://localhost:8080/api/turmas/escola/"+fk_escola);
    var turmas = JSON.parse(resposta);
    var select = document.getElementById('SelectTurma');

    //Cria os options do select
    for (let index = 0; index < turmas.length; index++) {
        
        var option = document.createElement('option')
        option.textContent = turmas[index].ano;
        option.value = turmas[index].idTurma;
        option.classList.add('optionTurmas')

        select.append(option);
    }
}

//Método para carregar os campos da turma selecionada
async function carregarCampos(turma) {
    //Busca os dados da turma selecionado no checkbox 
    var resposta = await usarApi("GET", "http://localhost:8080/api/turma/" + turma)
    var turma = JSON.parse(resposta)

    //Converte as datas para só pegar o horário
    var horaInicioAula = new Date(turma.horarioInicioAula);
    var horas = horaInicioAula.getHours()+3;
    var minutos = horaInicioAula.getMinutes();
    if (horas < 10 && minutos < 10) {
        horas = "0"+horas;
        minutos = "0"+minutos;
    } else if (horas < 10 && minutos >= 10) {
        horas = "0"+horas;
    } else if (horas >= 10 && minutos < 10) {
        minutos = "0"+minutos;
    }
    horaInicioAula = horas+":"+minutos+":00";
    
    var horaFinalAula = new Date(turma.horarioFinalAula);
    horas = horaFinalAula.getHours()+3;
    minutos = horaFinalAula.getMinutes();
    if (horas < 10 && minutos < 10) {
        horas = "0"+horas;
        minutos = "0"+minutos;
    } else if (horas < 10 && minutos >= 10) {
        horas = "0"+horas;
    } else if (horas >= 10 && minutos < 10) {
        minutos = "0"+minutos;
    }
    horaFinalAula = horas+":"+minutos+":00";

    //Dados Turma
    document.getElementById('inputHoraInicio').value = horaInicioAula;
    document.getElementById('inputHoraFinal').value = horaFinalAula;
    document.getElementById('inputNome').value = turma.ano;

    //Faz a contagem dos alunos da turma
     //Busca a quantidade de alunos 
     var resposta2 = await usarApi("GET", "http://localhost:8080/api/alunos/quantidade/"+turma.idTurma);
     var qtd = JSON.parse(resposta2);
    var qtdaluno = qtd
    document.getElementById('InputQtdAlunos').value = qtdaluno; 
}

//Método para carregar a lista de alunos da turma selecionada
async function carregarListaAlunos(idTurma, nomeTurma) {

    //Faz a buscar na API
    var resposta = await usarApi("GET", "http://localhost:8080/api/alunos/" + idTurma);
    var alunos = JSON.parse(resposta);
    
    //Verifica se tem algum aluno no banco de dados
    if(alunos[0] == null){
        var tr = document.createElement("tr");
        var coluna = document.createElement("td");
        coluna.append("Nenhum aluno ligado à essa turma.")
        tr.append(coluna)
        document.getElementById('tbLista').append(tr)
    }else{
        var alunosIndex = []
        for (let i = 0; i < alunos.length; i++) {

            resposta = await usarApi("GET", "http://localhost:8080/api/usuario/" + alunos[i].fk_usuario);
            var usuarioNome = JSON.parse(resposta);

            alunosIndex.push(alunos[i]);

            var linha = document.createElement("tr");
            linha.classList.add("LinhaAlunos")
            var colunaNome = document.createElement("td");
            colunaNome.classList.add("colunaNome")
            var nomeAluno = usuarioNome.nome+" "+usuarioNome.sobrenome;
            colunaNome.append(nomeAluno)
            linha.append(colunaNome);
            var colunaMatricula = document.createElement("td");
            colunaMatricula.classList.add("colunaMatricula")
            colunaMatricula.append(alunos[i].matricula)
            linha.append(colunaMatricula);
            var colunaTurma = document.createElement("td");
            colunaTurma.classList.add("colunaTurma")
            colunaTurma.append(nomeTurma)
            linha.append(colunaTurma);

            document.getElementById('tbLista').append(linha)
        }  
    }
}

//Método para deletar a turma
async function deletarTurma() {
    var idTurmaDelete = $('#SelectTurma :selected').val();
    
    var resposta = await usarApi("DELETE", "http://localhost:8080/api/turma/deletar/" + idTurmaDelete);
    var deletarTurma = JSON.parse(resposta);
     if (deletarTurma == true) {
        alert("Turma deletada com sucesso.")
        document.getElementById('inputNome').value = '';
        document.getElementById('InputQtdAlunos').value = '';
        document.getElementById('inputHoraInicio').value = '';
        document.getElementById('inputHoraFinal').value = '';
        $("#SelectTurma").empty();
        var opt = document.createElement("option");
        opt.value = "default";
        opt.textContent = "Selecione uma turma"
        document.getElementById("SelectTurma").append(opt)
        carregarSelect();
        document.getElementById('inputNome').disabled = true;
        document.getElementById('InputQtdAlunos').disabled = true;
        document.getElementById('inputHoraInicio').disabled = true;
        document.getElementById('inputHoraFinal').disabled = true;
        document.getElementById('btnAtualizar').hidden = true;
        document.getElementById('idBtn').hidden = true;
        $("#tbLista").empty();
     } else {
        alert("Ocorreu um erro ao deletar a turma")
     }
}


