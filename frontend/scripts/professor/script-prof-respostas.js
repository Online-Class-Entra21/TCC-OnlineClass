// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var fk_escola;

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

            fk_escola = dadosUsuario.fk_escola;
            carregarTurmas();
        })
    xhr.send();

}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

document.getElementById("idDisci").disabled = true;

//Carrega as turmas do professor
async function carregarTurmas(){
    var resposta = await usarApi('GET','http://localhost:8080/api/turmas/professor/'+idUsuario);
    turmaArray = JSON.parse(resposta);

    //comparacao de turmas iguais
    turmas = [];
    turmasId = [];
    for(var i = 0; i <turmaArray.length;i++){
        const turma = turmaArray[i];
        var index = turmasId.indexOf(turma.idTurma);
        if (index==-1) {
            turmasId.push(turma.idTurma);
            turmas.push(turma);
        }
    }
    var select = document.getElementById('idTipo');

    //Cria os options do select
    for (let index = 0; index < turmas.length; index++) {
        
        var option = document.createElement('option')
        option.textContent = turmas[index].ano;
        option.value = turmas[index].idTurma;
        option.classList.add('optionTurmas')

        select.append(option);
    }
}

//Método para o select
$( "#idTipo" ).change(function() { 
    var turmaEscolhida = $('#idTipo :selected').val();
    if (turmaEscolhida == 'default') {
        document.getElementById("idDisci").disabled = true;
    } else {
        document.getElementById("idDisci").disabled = false;
        carregarDisciplinas(turmaEscolhida);
    }
});  

//Carrega as disciplinas escolhidas
async function carregarDisciplinas(turmaEscolhida){
    var resposta = await usarApi('GET','http://localhost:8080/api/disciplinas/turmas/aluno/'+idUsuario+'/'+turmaEscolhida);
    disciplinas = JSON.parse(resposta);
    
    var select = document.getElementById('idDisci');

    //Cria os options do select
    for (let index = 0; index < disciplinas.length; index++) {
        
        var option = document.createElement('option')
        option.textContent = disciplinas[index].nome;
        option.value = disciplinas[index].idDisciplina;
        option.classList.add('optionDisciplinas')

        select.append(option);
    }
}

//Evento de click do botao pesquisar 
document.getElementById("botao-pesquisar").addEventListener("click", function(){
    var turmaEscolhida = $('#idTipo :selected').val();
    var disciplinaEscolhida = $('#idDisci :selected').val();

    if(turmaEscolhida != "default" && disciplinaEscolhida != "default"){
        buscarRespostas(turmaEscolhida, disciplinaEscolhida);
    }else{
        alert("Escolha primeiro a turma e a disciplina!");
    }
})

//Buscar resultados 
async function buscarRespostas(turmaEscolhida, disciplinaEscolhida){
    $("#tbLista").empty();
    var resposta = await usarApi('GET','http://localhost:8080/api/atividade/resposta/turma/'+turmaEscolhida+'/'+disciplinaEscolhida);
    respostas = JSON.parse(resposta);
    
    //Adiciona as respostas na tabela 
    for (let i = 0; i < respostas.length; i++) {
        const element = respostas[i];
        
        var lista = document.getElementById("tbLista");
        
        var linha = document.createElement("tr");
        linha.classList.add("linhaResposta")

        var colunaAtividade = document.createElement("td");
        colunaAtividade.scope = "col";
        colunaAtividade.textContent = element.titulo;

        var colunaTipo = document.createElement("td");
        colunaTipo.scope = "col";

        //Verifica qual é o tipo de avaliacao
        if(element.tipoAvaliacao == 1){
            colunaTipo.textContent = "Avaliação";
        }else if(element.tipoAvaliacao == 2){
            colunaTipo.textContent = "Atividade";
        }else if(element.tipoAvaliacao == 3){
            colunaTipo.textContent = "Recuperação Paralela";
        }else if(element.tipoAvaliacao == 4){
            colunaTipo.textContent = "Auto-Avaliação";
        }else{
            colunaTipo.textContent = "Nenhum";
        }

        //Busca o aluno da resposta - nome 
        var resposta2 = await usarApi('GET','http://localhost:8080/api/aluno/'+element.fk_aluno);
        aluno = JSON.parse(resposta2);
        var resposta4 = await usarApi('GET','http://localhost:8080/api/usuario/'+aluno.fk_usuario);
        usuario = JSON.parse(resposta4);

        var colunaAluno = document.createElement("td");
        colunaAluno.scope = "col";
        colunaAluno.textContent = usuario.nome+" "+usuario.sobrenome;
        
        var colunaData = document.createElement("td");
        colunaData.scope = "col";
        colunaData.textContent = dataFormatada2(new Date(element.dataEntrega));

        //Adiciona o botao na coluna 
        var colunaBotao = document.createElement("td");
        colunaBotao.scope = "col";
        var buttonDownload = document.createElement("button");
        buttonDownload.classList.add("btn");
        buttonDownload.className += "  btn-primary anexo";
        buttonDownload.value = i;
        buttonDownload.textContent = "Visualizar";

        colunaBotao.append(buttonDownload);

        //Cria a coluna de nota - input 
        var colunaNota = document.createElement("td") 
        colunaNota.classList.add("ult");
        colunaNota.scope = "col";
        var inputNota = document.createElement("input");
        inputNota.classList.add("nota");
        inputNota.className = " form-control";
        inputNota.type = "number";
        inputNota.min = 0;
        inputNota.max = 10.0;
        inputNota.step = ".01";
        inputNota.maxLength = 2;
        inputNota.name = "nmNota";
        inputNota.id = 'input-'+element.idResposta;
        if(element.nota != null){
            inputNota.value = element.nota;
        }
        inputNota.classList.add("notasInput");
        colunaNota.append(inputNota);

        //Adiciona o botao na coluna - salvar 
        var colunaSalvar = document.createElement("td");
        colunaSalvar.scope = "col";
        var buttonSalvar = document.createElement("button");
        buttonSalvar.classList.add("btn");
        buttonSalvar.className += "  btn-primary salvar";
        buttonSalvar.value = element.idResposta;
        buttonSalvar.textContent = "Salvar";

        colunaSalvar.append(buttonSalvar);

        //Cria a linha dentro da lista - tabela 
        linha.append(colunaAtividade);
        linha.append(colunaTipo);
        linha.append(colunaAluno);
        linha.append(colunaData);
        linha.append(colunaBotao);
        linha.append(colunaNota);
        linha.append(colunaSalvar);

        lista.append(linha);

    }
    //Abre a visualizacao do arquivo e observao da resposta 
    $( ".anexo" ).click(function() {
        var index = this.value;
        sessionStorage.setItem("idArquivo",respostas[index].fk_arquivo);
        sessionStorage.setItem("idResposta",respostas[index].idResposta);
        sessionStorage.setItem("idAluno",usuario.idUsuario);
        novaJanela = window.open ("/frontend/paginas/professor/prof-resposta-aberta.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2);   
    });  

    //Salva a alteração da nota 
    $( ".salvar" ).click(async function() {
        var idResposta = this.value;
        var nota = $('#input-'+idResposta).val();

        if(nota <= 10 && nota >= 0){
        
            var xhr2 = new XMLHttpRequest(); 
            xhr2.open("PUT", "http://localhost:8080/api/resposta/alterar/nota/"+idResposta+'/'+nota);

            xhr2.addEventListener("load", function(){
                var resposta6 = xhr2.responseText;
                var status = JSON.parse(resposta6);

                if(status){
                    alert("Nota salva com sucesso");
                }else{
                    alert("Erro ao salvar nota!");
                }
            })
            xhr2.send();  
        }else{
            alert("Nota inválida!")
        }
    });   
}

