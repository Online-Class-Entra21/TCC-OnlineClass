// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/usuarios/"+idUsuario);

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
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

carregarSelectTurmas();

var selectDisciplina = document.getElementById('SelectDisciplina');
var selectTurma = document.getElementById('SelectTurma');
var selectAluno = document.getElementById('SelectAlunos');

$( "#SelectTurma" ).change(function() {
    $("#tabelaAlunos").empty();
    var turmaEscolhida = $('#SelectTurma :selected').val();
    if (turmaEscolhida == 'defaultTurma') {
        $("#SelectDisciplina").val("defaultDisciplina");
        $("#SelectAlunos").val("defaultAluno");
        selectDisciplina.disabled = true;
        selectAluno.disabled = true;
        $("#tabelaAlunos").empty();
    } else {
        $("#SelectAlunos").empty();
        var opt = document.createElement("option");
        opt.value = "defaultAluno";
        opt.textContent = "Selecione um aluno"
        document.getElementById("SelectAlunos").append(opt)
        carregarSelectAlunos(turmaEscolhida)
        selectAluno.disabled = false;

        $("#SelectDisciplina").empty();
        var opt = document.createElement("option");
        opt.value = "defaultDisciplina";
        opt.textContent = "Selecione uma disciplina"
        document.getElementById("SelectDisciplina").append(opt)
        carregarSelectDisciplinas(turmaEscolhida)
    }
});

$("#SelectAlunos").change(function() {
    var alunoEscolhido = $('#SelectAlunos :selected').val();
    var turmaEscolhida = $('#SelectTurma :selected').val();
    if (alunoEscolhido == 'defaultAluno') {
        $("#SelectDisciplina").val("defaultDisciplina");
        selectDisciplina.disabled = true;
    } else {
        selectDisciplina.disabled = false;

        //Chama a resposta
        $("#tabelaAlunos").empty();
        carregarTabela(turmaEscolhida, alunoEscolhido);

    }
})

$("#SelectDisciplina").change(function() {
    var alunoEscolhido = $('#SelectAlunos :selected').val();
    var turmaEscolhida = $('#SelectTurma :selected').val();
    var disciplinaEscolhida = $('#SelectDisciplina :selected').val();
    if (disciplinaEscolhida == 'defaultDisciplina') {
        $("#SelectDisciplina").val("defaultDisciplina");
        $("#tabelaAlunos").empty();
        carregarTabela(turmaEscolhida, alunoEscolhido);
        selectDisciplina.disabled = true;
    } else {
        selectDisciplina.disabled = false;

        //Chama a resposta
        $("#tabelaAlunos").empty();
        carregarTabelaDisciplina(turmaEscolhida, alunoEscolhido, disciplinaEscolhida);

    }
})


//Método para carregar os selects
async function carregarSelectTurmas() {
    //Carrega o Select das Turmas
    var resposta = await usarApi("GET", "http://localhost:8080/usuariodisciplinaturmas/usuario/" + idUsuario);
    var turmas = JSON.parse(resposta);
    for (let index = 0; index < turmas.length; index++) {
       var option = document.createElement('option');
       option.textContent = turmas[index].ano;
       option.value = turmas[index].idTurma;

       selectTurma.appendChild(option);    
    }
}

async function carregarSelectDisciplinas(idTurma) {
    
    //Carrega o Select das Disciplinas
    var resposta = await usarApi("GET", "http://localhost:8080/disciplinas/turma/" + idTurma);
    var disciplinas = JSON.parse(resposta);
    for (let index = 0; index < disciplinas.length; index++) {
       var option = document.createElement('option');
       option.textContent = disciplinas[index].nome;
       option.value = disciplinas[index].idDisciplina;

       selectDisciplina.appendChild(option);    
    }
}

async function carregarSelectAlunos(idTurma) {
   //Carrega o Select dos alunos da turmas
   resposta = await usarApi("GET", "http://localhost:8080/alunos/turma/" + idTurma);
   var alunos = JSON.parse(resposta);
   for (let index = 0; index < alunos.length; index++) {
        resposta = await usarApi("GET", "http://localhost:8080/usuarios/" + alunos[index].fk_usuario);
        var usuario = JSON.parse(resposta);
        var option = document.createElement('option');
        option.textContent = usuario.nome;
        option.value = alunos[index].idAluno;

        selectAluno.appendChild(option);    
   }
}

//Método para carregar a tabela pelo aluno informado
async function carregarTabela(idTurma ,idAluno) {
    var resposta = await usarApi("GET", "http://localhost:8080/professores/notas/" + idTurma + "/" + idAluno);
    var notasAluno = JSON.parse(resposta);

    for (let index = 0; index < notasAluno.length; index++) {

        var dataEntrega = new Date(notasAluno[index].dataEntrega);
        dataEntrega = dataFormatada2(dataEntrega);


        var linha = document.createElement('tr');
        var colunaAno = document.createElement('td');
        colunaAno.append(notasAluno[index].ano);
        colunaAno.classList.add('tdTabela');
        linha.append(colunaAno);

        var colunaData = document.createElement('td');
        colunaData.append(dataEntrega.slice(0,10));
        colunaData.classList.add('tdTabela');
        linha.append(colunaData)

        var colunaTitulo = document.createElement('td');
        colunaTitulo.append(notasAluno[index].titulo);
        colunaTitulo.classList.add('tdTabela');
        linha.append(colunaTitulo);

        var colunaNota = document.createElement('td');
        colunaNota.append(notasAluno[index].nota);
        colunaNota.classList.add('tdTabela');
        linha.append(colunaNota);

        var colunaDisciplina = document.createElement('td');
        colunaDisciplina.append(notasAluno[index].nome);
        colunaDisciplina.classList.add('tdTabela');
        linha.append(colunaDisciplina);

        document.getElementById('tabelaAlunos').appendChild(linha);
        
    }
}

//Método para carregar a tabela pela disciplina informado
async function carregarTabelaDisciplina(idTurma ,idAluno, idDisciplina) {
    var resposta = await usarApi("GET", "http://localhost:8080/professores/notas/disciplina/" + idTurma + "/" + idAluno + "/" + idDisciplina);
    var notasAluno = JSON.parse(resposta);

    for (let index = 0; index < notasAluno.length; index++) {

        var dataEntrega = new Date(notasAluno[index].dataEntrega);
        dataEntrega = dataFormatada2(dataEntrega);


        var linha = document.createElement('tr');
        var colunaAno = document.createElement('td');
        colunaAno.append(notasAluno[index].ano);
        colunaAno.classList.add('tdTabela');
        linha.append(colunaAno);

        var colunaData = document.createElement('td');
        colunaData.append(dataEntrega.slice(0,10));
        colunaData.classList.add('tdTabela');
        linha.append(colunaData)

        var colunaTitulo = document.createElement('td');
        colunaTitulo.append(notasAluno[index].titulo);
        colunaTitulo.classList.add('tdTabela');
        linha.append(colunaTitulo);

        var colunaNota = document.createElement('td');
        colunaNota.append(notasAluno[index].nota);
        colunaNota.classList.add('tdTabela');
        linha.append(colunaNota);

        var colunaDisciplina = document.createElement('td');
        colunaDisciplina.append(notasAluno[index].nome);
        colunaDisciplina.classList.add('tdTabela');
        linha.append(colunaDisciplina);

        document.getElementById('tabelaAlunos').appendChild(linha);
        
    }
}