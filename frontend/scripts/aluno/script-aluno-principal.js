// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

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
        })

    xhr.send();
    
}else{
    // alert('Sessão expirada - Erro (0002)')
    // window.location = "/frontend/index.html";
}

//Abre uma nova guia para digitar o email de recuperação 
function answer() {
    answer = window.open ("/frontend/paginas/aluno/aluno-resposta.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2)
}

$('#click').click(answer) 

carregarLinhas();

async function carregarLinhas() {
    var resposta = await usarApi("GET", "http://localhost:8080/api/aluno/usuario/" + idUsuario);
    var aluno = JSON.parse(resposta);
    var idTurma = aluno.fk_turma;

    //Retorna as atividades da turma
    resposta = await usarApi("GET", "http://localhost:8080/api/atividades/turma/" + idTurma);
    var turmasAtividades = JSON.parse(resposta);
    

    //Retorna os dados para popular a tabela
    resposta = await usarApi("GET", "http://localhost:8080/api/turmas/atividades/turma/" + idTurma);
    var dados = JSON.parse(resposta);

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
        dataFinal = timeStampFormat(dataFinal);
        
        


        var linha = document.createElement('tr');
        var colunaDisciplina = document.createElement('td');
        colunaDisciplina.append(turmasAtividades[index].disciplinaNome);
        colunaDisciplina.classList.add('alternado');
        linha.append(colunaDisciplina);

        var colunaTipo = document.createElement('td');
        var br = document.createElement('br')
        colunaTipo.append(turmasAtividades[index].tipoAtividade);
        colunaTipo.append(br)
        colunaTipo.append(dataFinal)
        colunaTipo.classList.add('alternado');
        linha.append(colunaTipo)

        var colunaTitulo = document.createElement('td');
        colunaTitulo.append(turmasAtividades[index].tituloAtividade);
        colunaTitulo.classList.add('alternado');
        linha.append(colunaTitulo);

        document.getElementById('tbAtividades').appendChild(linha);
        
        
    }

    $( "tr" ).click(function() { 
        
        window.open ("/frontend/paginas/aluno/aluno-resposta.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2)
    });  
}
