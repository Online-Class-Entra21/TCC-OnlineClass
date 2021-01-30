//Muda a senha do login no sistema 
function mandarCodigo(email){

    $('#input-email').css('border', 'none')

    if(email != ""){
        //Verifica se o email existe antes de enviar o código
        fetch('http://localhost:8080/api/verificar/' + email)
        .then(function(response) {
            return response.json()
        })
        .then(function(resposta){
            //Verifica se a resposta é true ou false
            if(resposta){

                fetch('http://localhost:8080/api/codigo/' + email)
                .then(function(response) {
                    return response.json()
                })
                .then(function(codigo){
                    //Armazena o código para testar na outra função
                    salvarCodigo = new salvarCodigo(codigo,email);

                    //Muda o design para a segunda etapa 
                    alert('Verifique seu e-mail, para inserir o código corretamente')
                    $('#input-email').css('display','none')
                    $('#input-codigo').css('display','inline')
                    $('#input-enviar-email').css('display','none')
                    $('#input-enviar-codigo').css('display','inline')
                })
                .catch(function() {
                    $('#input-email').css('border', '2px solid red')
                    alert('Erro de conexão do sistema!')
                })

            }else{
                $('#input-email').css('border', '2px solid red')
                alert('E-mail não cadastrado!')
            }
        })
        .catch(function() {
            $('#input-email').css('border', '2px solid red')
            alert('Erro de conexão do sistema!')
        });
    }else{
        $('#input-email').css('border', '2px solid red')
        alert('Digite o e-mail primeiro!')
    }
}

//Verific se o código está correto e altera a senha do usuário
function verificarCodigo(codigo, senha, senhaRepetida){

    $('#input-senha').css('border','none')
    $('#input-senha-repetida').css('border','none')

    //Verifica qual etapa está 
    if(salvarCodigo.getCodigo() != 0){
        //Verifica se o código é igual ao enviado 
        if(codigo == salvarCodigo.getCodigo()){
            $('#caixa-login').css('height','44vh')
            $('#input-codigo').css('display','none')
            $('#input-senha').css('display','inline')
            $('#input-senha-repetida').css('display','inline')
            $('#input-enviar-codigo').css('title','Salva')
            $('#input-enviar-codigo').css('value','Salva')
            salvarCodigo.setCodigo('0');
        }else{
            $('#input-codigo').css('border', '2px solid red')
            alert('Código inválido!')
        }
    }else if(senha == "" && senhaRepetida == ""){
        $('#input-senha').css('border','2px solid red')
        $('#input-senha-repetida').css('border','2px solid red')
        alert('Digite a nova senha!')
    }else if(senha != "" && senhaRepetida == ""){
        $('#input-senha-repetida').css('border','2px solid red')
        alert('Digite a senha novamente abaixo!')
    }else if(senha == "" && senhaRepetida != ""){
        $('#input-senha').css('border','2px solid red')
        alert('Digite a senha novamente acima!')
    }else{
        if(senha != senhaRepetida){
            $('#input-senha').css('border','2px solid red')
            $('#input-senha-repetida').css('border','2px solid red')
            alert('Senhas não compartíveis!')
        }else{
            if(senha.length > 7 && senha.length < 16){
                //Config padrão da consulta na API
                const options = {
                    method: 'PUT',
                    mode: 'cors',
                    cache: 'default'
                }
                console.log(senha)
                //Muda a senha do usuario 
                fetch('http://localhost:8080/api/mudar/senha/'+ salvarCodigo.getEmail() +'/'+ senha,options)
                .then(function() {
                    alert('Senha alterada com sucesso!')
                    window.open('javascript:window.open("", "_self", "");window.close();', '_self');
                })
                .catch(function() {
                    $('#input-senha').css('border','2px solid red')
                    $('#input-senha-repetida').css('border','2px solid red')
                    alert('Erro ao alterar senha, tente novamente!')
                });
            }else{
                $('#input-senha').css('border','2px solid red')
                $('#input-senha-repetida').css('border','2px solid red')
                alert('Digite uma senha entre 8-15 caracteres')
            }
        }
    }
}