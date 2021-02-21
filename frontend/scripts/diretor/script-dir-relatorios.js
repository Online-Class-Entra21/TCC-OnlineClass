// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var userEmail;

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/usuarios/"+idUsuario);

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

document.getElementById("idSalvar").addEventListener("click",function(){
    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        var email = $("#idDestinatario").val();
        verificarEmail(email);
    }
})

//Verifica o email
async function verificarEmail(email){
    
    //insere os relatorios  
    var resposta =  await usarApi("GET", "http://localhost:8080/usuarios/verificar/"+email); 
    var verificacao = JSON.parse(resposta);

    if(email == userEmail){
        alert("Você não pode digitar seu próprio e-mail")
    }else if(verificacao){
        buscarUsuario(email); 
    }else{
        alert("Destinatário não registrado no sistema!")
    }
}

//Buscar usuario pelo email
async function buscarUsuario(email){
    
    //insere os relatorios  
    var resposta =  await usarApi("GET", "http://localhost:8080/usuarios/cosnultaremail/"+email); 
    var usuario = JSON.parse(resposta);

    var idDestinatario = usuario.idUsuario;
    now = new Date();

    var relatorio = {
        titulo: $("#idTitulo").val(),
        destinatario: idDestinatario,
        texto: $("#texto-area").val(),
        dataRelatorio: now,
        fk_usuario: idUsuario
    }
    cadastrar(relatorio);
}

//Cadastrar relatorio
async function cadastrar(relatorio){
    //insere os relatorios  
    var json = JSON.stringify(relatorio);
    var resposta =  await usarApi("POST", "http://localhost:8080/relatorios",json); 
    var isCorreto = JSON.parse(resposta);

    if(isCorreto){
        alert("Enviado com sucesso!");
    }else{
        alert("Erro ao enviar");
    }
}
