// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o cep é válido 
if(idUsuario != null){
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
            img.setAttribute('src', "/imagens-usuarios/"+dadosUsuario.fotoUsuario);
            img.style.borderRadius = "80%";
        })

    xhr.send();

}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

//Mascara dos inputs 
$("#inputTelefone").mask("(00) 0000-0000");
$("#inputCelular").mask("(00) 00000-0000");

//Métodos onclick do botao cadastrar
var btnCadastrar =  document.getElementById('btnCadastrar');
btnCadastrar.addEventListener("click", function() {
    cadastrar();
})

//Método para cadastrar
async function cadastrar() {

    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{

        var escola = document.getElementById('inputEscola').value;
        var nome = document.getElementById('inputNome').value;
        var sobrenome = document.getElementById('inputSobrenome').value;
        var telefone = document.getElementById('inputTelefone').value;
        var celular = document.getElementById('inputCelular').value;
        var email = document.getElementById('inputEmail').value;
        var senha = document.getElementById('inputSenha').value;
        var confirmarSenha = document.getElementById('inputConfirmSenha').value;

        if(senha != confirmarSenha){
            alert("Senhas incompatíveis");
        }else{
            
            //Cria o objeto escola com as informações a serem registradas no banco de dados
            var inserirEscola = {
                nome: escola
            }

            //Converte para JSON
            var escolaJson = JSON.stringify(inserirEscola);

            //Chama a api para cadastrar a escola
            var insertEscola = await usarApi("POST", "http://localhost:8080/api/escola/inserir/nome/" + escolaJson);

            //Busca o id da escola cadastrada pelo nome
            var resposta =  await usarApi("GET", "http://localhost:8080/api/escola/buscar/nome/" + inserirEscola.nome);
            var escolaNome = JSON.parse(resposta);

            if(escolaNome != null){
                //Cria o objeto usuario com as informações a serem registradas no banco de dados
                var inserirUsuario = {
                    nome: nome,
                    sobrenome: sobrenome,
                    telefone: telefone,
                    celular: celular,
                    email: email,
                    senha: senha,
                    fk_escola: escolaNome.idEscola
                }
                
                //Converte para JSON
                var usuarioJson = JSON.stringify(inserirUsuario);
                
                //Chama a api para cadastrar o usuário
                var insertUsuario = await usarApi("POST", "http://localhost:8080/api/diretor/inserir/" + usuarioJson);
                
                if (insertUsuario == false || insertEscola == false) {
                    alert("Ocorreu um erro ao cadastrar!");
                } else {
                    alert("Cadastrado com sucesso");
                }
            }else{
                alert("Ocorreu um erro ao cadastrar!")
            }
        }
    } 
}

