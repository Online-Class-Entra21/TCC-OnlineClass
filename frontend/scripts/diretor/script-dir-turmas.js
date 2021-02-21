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

carregarTurmas();

//Carrega as turmas 
async function carregarTurmas(){

    //Inicia o loading 
    document.getElementById("idLoad").style.display = "block";

    //Busca as turmas 
    var resposta = await usarApi("GET", "http://localhost:8080/turmas");
    var turmas = JSON.parse(resposta);
    
    for (let i = 0; i < turmas.length; i++) {
        const element = turmas[i];

        //Cria uma linha e suas colunas 
        var linha = document.createElement("tr");
        linha.classList.add("linhas");

        //Coluna de dataInicial
        var colunaAno = document.createElement("td");
        colunaAno.textContent = element.ano;

        //Busca a quantidade de alunos 
        var resposta2 = await usarApi("GET", "http://localhost:8080/alunos/quantidade/"+element.idTurma);
        var qtdAlunos = JSON.parse(resposta2);

        //Coluna de dataFinal
        var colunaQtdAlunos = document.createElement("td");
        colunaQtdAlunos.textContent = qtdAlunos;

        //Adiciona a linha na tabela 
        var tabela = document.getElementById("turmasExib");
        linha.appendChild(colunaAno);
        linha.appendChild(colunaQtdAlunos);

        tabela.appendChild(linha);
    }

    //Termina o loading de carregamento 
    document.getElementById("idLoad").style.display = "none";

    //Abre uma nova guia para vizualizar turmas e alunos 
    $(".linhas").click(function() { 
        var idTurma = turmas[$(this).index()-1].idTurma;
        console.log(idTurma)
        sessionStorage.setItem("idTurma",idTurma);
        verAlunos();
    });
}

//Abre a nova tela de alunos 
function verAlunos() {
    novaJanela = window.open ("/frontend/paginas/diretor/dir-alunos-exibir.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2)
}

//Expulsa um aluno do sistema 
function expulsarAluno(){
    $('#tbUser').on('click', '.btnExpulsar', function() {
        $(this).closest('tr').remove();
    });
}