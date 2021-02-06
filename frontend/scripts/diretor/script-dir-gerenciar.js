// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
            //Adiciona o nome 
            document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
            //Adiciona a foto de perfil do usuario
            var img = document.querySelector("#idFotoPerfil");
            img.setAttribute('src', dadosUsuario.fotoUsuario);
            img.style.borderRadius = "80%";

            //Carrega os dados da escola 
            carregarDadosEscola(dadosUsuario.fk_escola)
        })

    xhr.send();
    
}else{
    // alert('Sessão expirada - Erro (0002)')
    // window.location = "/frontend/index.html";
}

//Carrga os dados do perfil do diretor
function carregarDadosEscola(fk_escola){

    //Busca dos dados da escola 
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/escola/"+fk_escola);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosEscola = JSON.parse(resposta);

            //Pega o nome da escola 
            document.getElementById('idEditEscola').value = dadosEscola.nome;

            //Pega a data de inicio do ano letivo 
            var dataInicio = dadosEscola.dataInicioLetivo;
            if(dataInicio != null){
                var data = new Date(dataInicio);
                var dataInicioLetivo = dataFormatada(data);
                document.getElementById('idInicioAnoLetivo').value = dataInicioLetivo;
            }

            //Pega a data de fim do ano letivo 
            var dataFinal = dadosEscola.dataFinalLetivo;
            if(dataFinal != null){
                var data = new Date(dataFinal);
                var dataFinalLetivo = dataFormatada(data);
                document.getElementById('idFinalAnoLetivo').value = dataFinalLetivo;
            }
        })

    xhr.send();
}

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

//Alteracao da escola 
document.getElementById("salv-esc").addEventListener("click",function(){

    //Pega os dados da escola 
    var escola = {
        nome: $("#idEditEscola").val(),
        idInicioAnoLetivo: $("#idInicioAnoLetivo").val(),
        idFinalAnoLetivo: $("#idFinalAnoLetivo").val(),
    }
})

//Abre a visualizacao dos periodos de avaliacao 
document.getElementById("img-visualizar").addEventListener("click",function(){
    novaJanela = window.open ("/frontend/paginas/diretor/dir-periodos.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2);
})

document.getElementById("salv-per").addEventListener("click", function(){
    
})





 