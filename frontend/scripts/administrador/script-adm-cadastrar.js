// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o cep é válido 
if(idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
            document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
        })
        xhr.onerror = function () {
            alert('Sem Conexão com a Base de Dados - Erro (0001)')
            window.location = "/frontend/index.html";
        }

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

// //Método para chamada da api
// function usarApi(method, url) {
//     return new Promise(function (resolve, reject) {
//         let xhr = new XMLHttpRequest();
//         xhr.open(method, url);
//         xhr.onload = function () {
//             if (this.status >= 200 && this.status < 300) {
//                 resolve(xhr.response);
//             } else {
//                 document.getElementById("idLoad").style.display = "none";
//                 document.getElementById("idErro").textContent = "Sem Conexão com a Base de Dados - Erro (0001)";
//                 document.getElementById("idErro").style.display = "block";
//                 reject({
//                     status: this.status,
//                     statusText: xhr.statusText
//                 });
//             }
//         };
//         xhr.onerror = function () {
//             document.getElementById("idLoad").style.display = "none";
//             document.getElementById("idErro").textContent = "Sem Conexão com a Base de Dados - Erro (0001)";
//             document.getElementById("idErro").style.display = "block";
//             reject({
//                 status: this.status,
//                 statusText: xhr.statusText
//             });
//         };
//         xhr.send();
//     });
// }

// //Métodos onclick dos botões cadastrar e limpar
// var btnCadastrar =  document.getElementById('btnCadastrar');
// btnCadastrar.addEventListener("click", function() {
//     cadastrar();
// })
// var btnLimpar = document.getElementById('btnLimpar');
// btnLimpar.addEventListener("click", function() {

// })

// //Método para cadastrar
// async function cadastrar() {
//     var nome = document.getElementById('inputNome').value;
//     var sobrenome = document.getElementById('inputSobrenome').value;
//     //var cpf = document.getElementById('inputCpf').value;
//     var telefone = document.getElementById('inputTelefone').value;
//     var celular = document.getElementById('inputCelular').value;
//     var email = document.getElementById('inputEmail').value;
//     var senha = document.getElementById('inputSenha').value;
//     var confirmarSenha = document.getElementById('inputConfirmSenha').value;
//     var fotoUsuario = document.getElementById('inputFotoUsuario').value;
   

//     //Verifica se todos os campos estão preenchidos
//     if (nome != '' && sobrenome != ''  && telefone != '' && celular != '' && email != '' && senha != '' && confirmarSenha != '' && fotoUsuario != '') {  
//         //Valida a senha
//         if (senha != confirmarSenha) {
//             alert("As senhas não coincidem!")
//         } else {

//             //Cria o objeto com as informações a serem registradas no banco de dados
//             var inserirUsuario = {
//                 nome: nome,
//                 sobrenome: sobrenome,
//                 telefone: telefone,
//                 celular: celular,
//                 tipoUsuario: 2,
//                 email: email,
//                 senha: senha,
//                 fotoUsuario: fotoUsuario
//             }

//             //Converte para JSON
//             var usuarioJson = JSON.stringify(inserirUsuario);
        
//             //Chama a api para cadastrar o usuário
//             var insertUsuario = await usarApi("POST", "http://localhost:8080/api/usuario/inserir/" + usuarioJson);
//             if (insertUsuario == false) {
//                 alert("Ocorreu um erro no cadastro do diretor!")
//                 break;
//             }
//         }
//     } else {
//         alert("Preencha todos os campos!");
//     }
// }

$("#telefone").mask("(00) 00000-0000");
$("#celular").mask("(00) 0000-0000");

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
		$("#img_preview").css("border", "1px solid #05bbcc");
  
    $("#img_preview").css("width", "%");
    $("#img_preview").css("height", "80%");

	$("#imagemInput").change(function(){
		ImagePreview(this);
	});
});

