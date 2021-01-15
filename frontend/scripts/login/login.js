//Config padrão da consulta na API
const options = {
    method: 'GET',
    mode: 'cors',
    cache: 'default'
}

//Verifica as informações e loga no sistema 
function logar(email, senha) {
    $('#email').css('border', 'none')
    $('#senha').css('border', 'none')
        //Preenchimento de informações 
    if ($('#email').val() == "" && $('#senha').val() == "") {
        $('#email').css('border', '2px solid red')
        $('#senha').css('border', '2px solid red')
        alert('Preencha as informações de login!')
    } else if ($('#email').val() != "" && $('#senha').val() == "") {
        $('#senha').css('border', '2px solid red')
        alert('Preencha o campo de senha!')
    } else if ($('#email').val() == "" && $('#senha').val() != "") {
        $('#email').css('border', '2px solid red')
        alert('Preencha o campo de e-mail!')
    } else {
        //Consumindo API
        fetch('http://localhost:8080/api/usuario/email/' + email)
            .then(function(response) {
                return response.json();
            })
            .then(function(json) {
                //Verifica se a senha está correta 
                if (json.senha == senha) {

                    //Redireciona para a pagina correspondente ao tipo do usuário 
                    switch (json.tipoUsuario) {
                        case 1:
                            location.href = "/frontend/paginas/diretor/tela-principal.html"
                            break;
                        case 2:
                            location.href = "/frontend/paginas/coordenador/tela-principal.html"
                            break;
                        case 3:
                            location.href = "/frontend/paginas/professor/tela-principal.html"
                            break;
                        case 4:
                            location.href = "/frontend/paginas/aluno/aluno.html"
                            break;
                    }
                } else {
                    $('#senha').css('border', '2px solid red')
                    alert('Senha inválida!');
                }
            })
            .catch(function() {
                //Mensagem de erro de login
                $('#email').css('border', '2px solid red')
                $('#senha').css('border', '2px solid red')
                alert('Senha e/ou e-mail inválidos!');
            });
    }
}

//Muda a senha do login no sistema 
function mudarSenha() {
    //André - Quinta   
}

//Mostra e oculta a senha digitada 
function mostrarSenha() {
    var x = document.getElementById("input-senha");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
  }

//Breno - Responsividade
//Breno - Manter o ID para as demais pastas 
//André - Mudança de senha
