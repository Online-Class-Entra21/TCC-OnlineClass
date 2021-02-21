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


carregarLinhas();

async function carregarLinhas() {
    var resposta = await usarApi("GET", "http://localhost:8080/alunos/usuario/" + idUsuario);
    var aluno = JSON.parse(resposta);
    var idTurma = aluno.fk_turma;

    //Retorna as atividades da turma
    resposta = await usarApi("GET", "http://localhost:8080/atividades/turma/" + idTurma);
    var turmasAtividades = JSON.parse(resposta);

    //Retorna os dados para popular a tabela
    resposta = await usarApi("GET", "http://localhost:8080/turmaatividades/turma/" + idTurma);
    var dados = JSON.parse(resposta);
    if (dados[0] == null) {
        var linha = document.createElement('tr');
        var td = document.createElement('td');
        td.append('Nenhuma Atividade Marcada.')
        linha.append(td);
        document.getElementById('tbAtividades').appendChild(linha);
    }
    for (let index = 0; index < dados.length; index++) {
        if (turmasAtividades[index].tipoAtividade == 1) {
            turmasAtividades[index].tipoAtividade = 'Avaliação';
        } else if (turmasAtividades[index].tipoAtividade == 2) {
            turmasAtividades[index].tipoAtividade = 'Atividade';
        } else if (turmasAtividades[index].tipoAtividade == 3) {
            turmasAtividades[index].tipoAtividade = 'Recuperação Paralela';
        } else if (turmasAtividades[index].tipoAtividade == 4) {
            turmasAtividades[index].tipoAtividade = 'Auto-Avaliação';
        }
        //Converte a data
        var dataFinal = new Date(turmasAtividades[index].finalAtividade);
        dataFinal = dataFormatada2(dataFinal);

        var linha = document.createElement('tr');
        var colunaDisciplina = document.createElement('td');
        colunaDisciplina.append(turmasAtividades[index].disciplinaNome);
        colunaDisciplina.classList.add('alternado');
        linha.append(colunaDisciplina);

        var colunaTipo = document.createElement('td');
        var br = document.createElement('br')
        colunaTipo.append(turmasAtividades[index].tipoAtividade);
        colunaTipo.append(br)
        colunaTipo.append("Data Final - "+dataFinal.slice(0,10))
        colunaTipo.classList.add('alternado');
        linha.append(colunaTipo)

        var colunaTitulo = document.createElement('td');
        colunaTitulo.append(turmasAtividades[index].tituloAtividade);
        colunaTitulo.classList.add('alternado');
        linha.append(colunaTitulo);

        var colunaDownload = document.createElement('td');
        var btnDownload = document.createElement('button');
        btnDownload.innerHTML = "Baixar Atividade";
        //btnDowload.setAttribute('type', 'button')
        btnDownload.setAttribute('value', turmasAtividades[index].fk_arquivo);
        btnDownload.setAttribute('id', 'btnDownload');
        btnDownload.setAttribute('class', 'btn btn-primary download');
        colunaDownload.append(btnDownload);
        linha.append(colunaDownload);

        var colunaSituacao = document.createElement('td');
        resposta = await usarApi("GET", "http://localhost:8080/respostas/atividade/" + turmasAtividades[index].idAtividade + "/" + aluno.idAluno);
        var respostaExistente = JSON.parse(resposta);
        if (respostaExistente.dataEntrega == null) {
            colunaSituacao.append('Não Respondida')
            colunaSituacao.classList.add('naorespondida');
        } else {
            colunaSituacao.append('Respondida')
            colunaSituacao.classList.add('respondida');
        }
        linha.append(colunaSituacao);

        document.getElementById('tbAtividades').appendChild(linha);
    }
    var isPassou;
    $( ".download" ).click(function() {
        isPassou = true;
        var fk_arquivo = this.value;
    
        //Faz o download da atividade
        var xhr = new XMLHttpRequest(); 
        xhr.open("GET", "http://localhost:8080/arquivos/"+fk_arquivo);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            var arquivoDown = JSON.parse(resposta);
            var caminhoArquivo = arquivoDown.caminhoArquivo;

            //Faz o download
            downloadFile(caminhoArquivo);
        })
    xhr.send();    
    });   
    
    $( "tbody tr" ).click(function()  { 
        if (!isPassou) {
            var atividadeEscolhida = turmasAtividades[$(this).index()].idAtividade;
            sessionStorage.setItem('idAtividadeEscolhida', atividadeEscolhida);
            sessionStorage.setItem('idAluno', aluno.idAluno);
            window.open ("/frontend/paginas/aluno/aluno-resposta.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2)
            return atividadeEscolhida; 
        } else {
            isPassou = false;
        }  
    });    
}

function downloadFile(url){
    var link=document.createElement('a');
    link.href = url;
    link.download = url.substr(url.lastIndexOf('/') + 1);
    link.click();
}

