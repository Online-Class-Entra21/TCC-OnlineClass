//Verifica as informações e loga no sistema 
function logar(email, senha) {
    $('#input-email').css('border', 'none')
    $('#input-senha').css('border', 'none')
        //Preenchimento de informações 
    if (email == "" && senha == "") {
        $('#input-email').css('border', '2px solid red')
        $('#input-senha').css('border', '2px solid red')
        alert('Preencha as informações de login!','OnlineClass')
    } else if (email != "" && senha == "") {
        $('#input-senha').css('border', '2px solid red')
        alert('Preencha o campo de senha!')
    } else if (email == "" && senha != "") {
        $('#input-email').css('border', '2px solid red')
        alert('Preencha o campo de e-mail!')
    } else {
        //Consumindo API
        fetch('http://localhost:8080/api/usuario/email/' + email)
            .then(function(response) {
                return response.json()
            })
            .then(function(json) {
                //Verifica se a senha está correta 
                if (json.senha == senha) {

                    //Persistencia de dados para as próximas páginas - ID
                    usuarioDados = new usuarioDados(json.idUsuario);

                    //Redireciona para a pagina correspondente ao tipo do usuário 
                    switch (json.tipoUsuario) {
                        case 1:
                            location.href = "/frontend/paginas/administrador/adm-principal.html"
                            break;
                        case 2:
                            location.href = "/frontend/paginas/diretor/dir-principal.html"
                            break;
                        case 3:
                            location.href = "/frontend/paginas/coordenador/coord-principal.html"
                            break;
                        case 4:
                            location.href = "/frontend/paginas/professor/prof-principal.html"
                            break;
                        case 5:
                            location.href = "/frontend/paginas/aluno/aluno-principal.html"
                            break;
                    }
                } else {
                    $('#input-senha').css('border', '2px solid red')
                    alert('Senha inválida!')
                }
            })
            .catch(function() {
                //Mensagem de erro de login
                $('#input-email').css('border', '2px solid red')
                $('#input-senha').css('border', '2px solid red')
                alert('Senha e/ou e-mail inválidos!')
            });
    }
}

//Abre uma nova guia para digitar o email de recuperação 
function mudarSenha() {
    novaJanela = window.open ("/frontend/paginas/login/login-recuperacao.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2)
}
