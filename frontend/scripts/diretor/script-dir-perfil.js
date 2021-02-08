// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var senhaSelecionada;

//Verifica se já tem foto do usuario 
var isFotoExistente = false;

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

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
            //Carrega os dados do perfil do diretor 
            document.getElementById("idNome").value = dadosUsuario.nome;
            document.getElementById("idSobrenome").value = dadosUsuario.sobrenome;
            document.getElementById("idEmail").value = dadosUsuario.email;
            document.getElementById("idSenha").value = dadosUsuario.senha;
            document.getElementById("idTelefone").value = dadosUsuario.telefone;
            document.getElementById("idCelular").value = dadosUsuario.celular;
            senhaSelecionada = dadosUsuario.senha;

            //Puxando imagem
            var caminhoImagem = "/imagens-usuarios/"+dadosUsuario.fotoUsuario;
            
            //Verifica se a imagem não é nula 
            if(caminhoImagem != null){
                $("#img_preview").show();
                $("#img_preview").attr("src", caminhoImagem);
                document.getElementById('botao-input').value = "Alterar Imagem";
                document.getElementById('ok').textContent = "Ok"; 
                isFotoExistente = true;
            }
            carregarDadosEscola(dadosUsuario.fk_escola);
        })

    xhr.send();
    
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

//Carrga os dados do perfil do diretor
function carregarDadosEscola(fk_escola){

    //Busca dos dados da escola 
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/escola/"+fk_escola);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosEscola = JSON.parse(resposta);
            document.getElementById('idEscola').textContent = dadosEscola.nome;
        })

    xhr.send();
} 

//Carregamento automático da foto do usuario 
function ImagePreview(input)
{
    if (input.files && input.files[0])
	{
        var r = new FileReader();
        r.onload = function(e)
		{
			$("#img_preview").show();
            $("#img_preview").attr("src", e.target.result);
        }
        r.readAsDataURL(input.files[0]);
    }
}
$().ready(function() {

	hide_empty_image = false;
	set_blank_to_empty_image = false;
	set_image_border = true;

	if (hide_empty_image)
		$("#img_preview").hide();

	if (set_blank_to_empty_image)
		$("#img_preview").attr("src","data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=");

	if (set_image_border)
		$("#img_preview").css("border", "2px solid #ffffff");
  
    $("#img_preview").css("width", "53%");
    $("#img_preview").css("height", "60%");

	$("#imagemInput").change(function(e){
        ImagePreview(this);
        url = URL.createObjectURL(e.target.files[0]);
        $('#imagemInput').html($(this).val());
        document.getElementById('botao-input').value = "Alterar Imagem";
        document.getElementById('ok').textContent = "Ok";
        imagem = this.files;
    });
    $("#botao-salvar").click(function() {
        if (imagem!=undefined) {
            UploadFile(imagem,"http://localhost:8080/api/upload/"+idUsuario);
        }
    });
});
var imagem;

//Eventos de abertura e fechamento do preview
$("#visualizacao").click(function(){
    if($("#imagemInput").val() != "" || isFotoExistente){
        $("#visul-img").css("display", "inline");
    }else{
        alert("insira uma imagem primeiro!");
    }
})
$("#idBotaoFechar").click(function(){
    $("#visul-img").css("display", "none");
})

//Aciona o botao de carregamento de imagens 
document.getElementById('botao-input').onclick = function () {
    document.getElementById('imagemInput').click();
};

//Salvamento das altercoes do perfil
$("#botao-salvar").click(function(){
    
    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{

        //Pede a confirmação da senha 
        if(senhaSelecionada != document.getElementById("idSenha").value){
            isConfirmado = confirm("Deseja mesmo alterar a senha?");

            if(isConfirmado){
                //Altera a imagem
                if (imagem!=undefined) {
                    UploadFile(imagem,"http://localhost:8080/api/upload/"+idUsuario);
                }
                //Altera os dados 
                alterar(); 
            }
        }else{
            //Altera a imagem
            if (imagem!=undefined) {
                UploadFile(imagem,"http://localhost:8080/api/upload/"+idUsuario);
            }
            //Altera os dados 
            alterar(); 
        }
    }
})

//Método de alteracao dos dados do diretor
async function alterar(){

    senhaSelecionada = $("#idSenha").val();

    var perfil = {
        nome: $("#idNome").val(),
        sobrenome: $("#idSobrenome").val(),
        celular: $("#idCelular").val(),
        telefone: $("#idTelefone").val(),
        email: $("#idEmail").val(),
        senha: $("#idSenha").val(),
        idUsuario: idUsuario
    }

    var json = JSON.stringify(perfil);
    var resposta =  await usarApi("PUT", "http://localhost:8080/api/diretor/alterar/" + json); 
    var isCorreto = JSON.parse(resposta);

    if(isCorreto){
        alert('Alterações Salvas com sucesso!')
    }else{
        alert('Erro ao cadastrar!')
    }
}

//Adiciona imagem no arquivo raiz 
function UploadFile(file,url){
    var files = file[0];
    var xhr = new XMLHttpRequest();
    var fd = new FormData();

    fd.append( "foto", files, files.name);
    xhr.open("POST", url, true);
    xhr.send(fd);
}



