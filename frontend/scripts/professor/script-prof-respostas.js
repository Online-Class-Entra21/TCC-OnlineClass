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
    turmas = JSON.parse(resposta);
    
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
        buscarRespostas();
    }else{
        alert("Escolha primeiro a turma e a disciplina!");
    }
})

//Buscar resultados 
function buscarRespostas(){
    
}

