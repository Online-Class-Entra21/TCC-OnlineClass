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
             //Adiciona o nome 
             document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome;
             //Adiciona a foto de perfil do usuario
             var img = document.querySelector("#idFotoPerfil");
             img.setAttribute('src', dadosUsuario.fotoUsuario);
             img.style.borderRadius = "80%";
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

//Método para chamada da api
function usarApi(method, url) {
    return new Promise(function (resolve, reject) {
        let xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.onload = function () {
            if (this.status >= 200 && this.status < 300) {
                resolve(xhr.response);
            } else {
                //document.getElementById("idLoad").style.display = "none";
                //document.getElementById("idErro").textContent = "Sem Conexão com a Base de Dados - Erro (0001)";
                //document.getElementById("idErro").style.display = "block";
                reject({
                    status: this.status,
                    statusText: xhr.statusText
                });
            }
        };
        xhr.onerror = function () {
            //document.getElementById("idLoad").style.display = "none";
            //document.getElementById("idErro").textContent = "Sem Conexão com a Base de Dados - Erro (0001)";
            //document.getElementById("idErro").style.display = "block";
            reject({
                status: this.status,
                statusText: xhr.statusText
            });
        };
        xhr.send();
    });
}

//Métodos onclick dos botões cadastrar e limpar
var btnCadastrar =  document.getElementById('btnCadastrar');
btnCadastrar.addEventListener("click", function() {
    //alert("Entrou btnClick")
    cadastrar();
})
var btnLimpar = document.getElementById('btnLimpar');
btnLimpar.addEventListener("click", function() {

})

//Método para cadastrar
async function cadastrar() {
    var escola = document.getElementById('inputEscola').value;
    var nome = document.getElementById('inputNome').value;
    var sobrenome = document.getElementById('inputSobrenome').value;
    var telefone = document.getElementById('inputTelefone').value;
    var celular = document.getElementById('inputCelular').value;
    var email = document.getElementById('inputEmail').value;
    var senha = document.getElementById('inputSenha').value;
    var confirmarSenha = document.getElementById('inputConfirmSenha').value;
    //var fotoUsuario = document.getElementById('inputFotoUsuario').value;
   

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

$("#telefone").mask("(00) 0000-0000");
$("#celular").mask("(00) 00000-0000");

    //Verifica se todos os campos estão preenchidos
    if (nome != '' && sobrenome != ''  && telefone != '' && celular != '' && email != '' && senha != '' && confirmarSenha != '' && escola != '') {  
        //Valida a senha
        if (senha != confirmarSenha) {
            alert("As senhas não coincidem!")
        } else {

            //Cria o objeto escola com as informações a serem registradas no banco de dados
            var inserirEscola = {
                nome: escola
            }

            //Converte para JSON
            var escolaJson = JSON.stringify(inserirEscola);

            //Chama a api para cadastrar a escola
            var insertEscola = await usarApi("POST", "http://localhost:8080/api/escola/inserir/nome/" + escolaJson);

            //Busca o id da escola cadastrada pelo nome
            var resposta =  await usarApi("GET", "http://localhost:8080/api/escola/nome/" + inserirEscola.nome);
            var idEscolaNome = JSON.parse(resposta);

            //Cria o objeto usuario com as informações a serem registradas no banco de dados
            var inserirUsuario = {
                nome: nome,
                sobrenome: sobrenome,
                telefone: telefone,
                celular: celular,
                tipoUsuario: 2,
                email: email,
                senha: senha,
                fk_escola: idEscolaNome.idEscola
                //fotoUsuario: fotoUsuario
            }
            
            //Converte para JSON
            var usuarioJson = JSON.stringify(inserirUsuario);
            
            //Chama a api para cadastrar o usuário
            var insertUsuario = await usarApi("POST", "http://localhost:8080/api/usuario/inserir/diretor/" + usuarioJson);
            
            if (insertUsuario == false || insertEscola == false) {
                alert("Ocorreu um erro no cadastro do diretor!")
            } else {
                alert("Cadastrado com sucesso");
            }
        }
    } else {
        alert("Preencha todos os campos!");
    }
}

