/*
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
        document.getElementById('btnCadastrar').textContent = 'Cadastrar'
        document.getElementById('btnCadastrar').hidden = false;
        $('#divSelect').css('display', 'none');
        $("#tbLista").empty();
        document.getElementById("formulario").reset();
    } else {
        document.getElementById('inputNome').disabled = true;
        document.getElementById('InputQtdAlunos').disabled = true;
        document.getElementById('inputHoraInicio').disabled = true;
        document.getElementById('inputHoraFinal').disabled = true;
        document.getElementById('SelectTurma').disabled = false;
        document.getElementById('idBtn').hidden = false;
        document.getElementById('btnCadastrar').textContent = 'Atualizar'
        document.getElementById('btnCadastrar').hidden = true;
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
    } else {
        document.getElementById('btnCadastrar').hidden = false;
        document.getElementById('inputNome').disabled = false;
        document.getElementById('InputQtdAlunos').disabled = true;
        document.getElementById('inputHoraInicio').disabled = false;
        document.getElementById('inputHoraFinal').disabled = false;
        carregarListaAlunos(turmaEscolhida, nomeTurmaEscolhida);
        carregarCampos(turmaEscolhida);
    }
});  

//Método para o cadastro de uma turma
async function cadastrar() {
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        //Coleta os dados do input
        var turma = document.getElementById('inputNome').value;
        var horaInicioAula = new Date(document.getElementById('inputHoraInicio').valueAsDate);
        var horaFinalAula = new Date(document.getElementById('inputHoraFinal').valueAsDate);
        horaInicioAula.setHours(horaInicioAula.getHours()+3);
        horaFinalAula.setHours(horaFinalAula.getHours()+3);
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
    
    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        //Edita os Campos da escola
        var alterarTurma = {
            ano: document.getElementById('inputNome').value,
            horainicioaula: document.getElementById('inputHorarioInicial').valueAsDate,
            horafinalaula: document.getElementById('inputHorarioFinal').valueAsDate,
            qtdaluno: null,
            fk_sala: null,
            fk_escola: document.getElementById('inputFk_Escola').value
        }
        var turmaJson = JSON.stringify(alterarTurma);
        var updateEscola = await usarApi("PUT", "http://localhost:8080/api/turma/alterar/"+codigoEscola+"/"+turmaJson);
        var resposta = JSON.parse(updateEscola)
                    
        if (!resposta) {
            alert("Erro ao salvar edição!");
        }else{
            editarDiretor();
        }
    }

            
}

//Método para carregar o select com as turmas existentes
async function carregarSelect() {
    var resposta = await usarApi("GET", "http://localhost:8080/api/turmas/escola/"+fk_escola);
    var turmas = JSON.parse(resposta);
    var select = document.getElementById('SelectTurma');

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

    //Dados Turma
    document.getElementById('inputNome').value = turma.ano;
    document.getElementById('InputQtdAlunos').value = turma.qtdAluno
    /*
    var horaInicioAulaFormatado = turma.horarioInicioAula.slice(13, 20);
    var horaFinalAulaFormatado = turma.horarioFinalAula.slice(13, 20);
    console.log(horaInicioAulaFormatado.toISOString())
    console.log(horaFinalAulaFormatado)
    document.getElementById('inputHoraInicio').value = horaInicioAulaFormatado;
    document.getElementById('inputHoraFinal').value = turma.horarioFinalAula;
    */
   /*
}
//Método para carregar a lista de alunos da turma selecionada
async function carregarListaAlunos(idTurma, nomeTurma) {
    //Faz a buscar na API
    var resposta = await usarApi("GET", "http://localhost:8080/api/alunos/" + idTurma);
    var alunos = JSON.parse(resposta);

    
    //Verifica se tem alguma escola no banco de dados
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

async function deletarTurma() {

}
*/
