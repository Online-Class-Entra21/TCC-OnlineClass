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


//---> Referencia checkbox inside select
//---> https://stackoverflow.com/questions/17714705/how-to-use-checkbox-inside-select-option
//-> Checkbox Inside Select code:

var expanded = false;

function optionPeriodos() {
  var periodos = document.getElementById("periodos");
  if (!expanded) {
    periodos.style.display = "block";
    expanded = true;
  } else {
    periodos.style.display = "none";
    expanded = false;
  }
}

function optionMaterias() {
    var materias = document.getElementById("materias");
    if (!expanded) {
      materias.style.display = "block";
      expanded = true;
    } else {
      materias.style.display = "none";
      expanded = false;
    }
  }

  function optionTurmas() {
    var turmas = document.getElementById("turmas");
    if (!expanded) {
      turmas.style.display = "block";
      expanded = true;
    } else {
      turmas.style.display = "none";
      expanded = false;
    }
  }

