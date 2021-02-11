var idUsuario = sessionStorage.getItem('idUsuario');
var isFotoExistente = false;

///Verifica se o idUsuario é válido 
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

            //Puxando imagem
            var caminhoImagem = dadosUsuario.fotoUsuario;
                    
            //Verifica se a imagem não é nula 
            if(caminhoImagem != undefined){
                $("#img_preview").show();
                $("#img_preview").attr("src", "/imagens-usuarios/"+caminhoImagem);
                document.getElementById('botao-input').value = "Alterar Imagem";
                document.getElementById('ok').textContent = "Ok"; 
                isFotoExistente = true;
            }
        })
    xhr.send();
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
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



var idEscola = sessionStorage.getItem('escolaUsuario');
carregarCampos();



//Método onclick do botão atualizar
var btnAtualizar = document.getElementById('botao-salvar');
btnAtualizar.addEventListener("click", function() {
    //atualizar();
    //Altera a imagem
    if (imagem!=undefined) {
        UploadFile(imagem,"http://localhost:8080/api/upload/"+idUsuario);
    }
})

//Método para carregar os campos
async function carregarCampos() {
    //Chama a api para carregar o usuario e escola do banco
    var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/" + idUsuario);
    var professor = JSON.parse(resposta);
    resposta = await usarApi("GET", "http://localhost:8080/api/escola/" + idEscola);
    var escola = JSON.parse(resposta);

    document.getElementById('inputEscola').value = escola.nome;

    //Converte as datas para só pegar o horário
    var horarioInicioExpediente = new Date(professor.horarioInicioExpediente);
    var horas = horarioInicioExpediente.getHours();
    var minutos = horarioInicioExpediente.getMinutes();
    if (horas < 10 && minutos < 10) {
        horas = "0"+horas;
        minutos = "0"+minutos;
    } else if (horas < 10 && minutos >= 10) {
        horas = "0"+horas;
    } else if (horas >= 10 && minutos < 10) {
        minutos = "0"+minutos;
    }
    horarioInicioExpediente = horas+":"+minutos+":00";
    
    var horarioFinalExpediente = new Date(professor.horarioFinalExpediente);
    horas = horarioFinalExpediente.getHours();
    minutos = horarioFinalExpediente.getMinutes();
    if (horas < 10 && minutos < 10) {
        horas = "0"+horas;
        minutos = "0"+minutos;
    } else if (horas < 10 && minutos >= 10) {
        horas = "0"+horas;
    } else if (horas >= 10 && minutos < 10) {
        minutos = "0"+minutos;
    }
    horarioFinalExpediente = horas+":"+minutos+":00";
    document.getElementById('inputHorarioInicial').value = horarioInicioExpediente;
    document.getElementById('inputHorarioFinal').value = horarioFinalExpediente;
    document.getElementById('inputNome').value = professor.nome;
    document.getElementById('inputSobrenome').value = professor.sobrenome;
    document.getElementById('inputEmail').value = professor.email;
    document.getElementById('inputSenha').value = professor.senha;
    document.getElementById('inputCpf').value = professor.cpf;
    document.getElementById('inputCelular').value = professor.celular;
    document.getElementById('inputTelefone').value = professor.telefone;

    //Adiciona a foto de perfil do usuario
    var img = document.querySelector("#idFotoPerfil");
    if(dadosUsuario.fotoUsuario != null){
        img.setAttribute('src', "/imagens-usuarios/"+dadosUsuario.fotoUsuario);
        img.style.borderRadius = "80%";
    }

     

   
}