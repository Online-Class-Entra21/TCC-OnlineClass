//Verifica se o email existe antes de enviar o código
function verificarEmail(email){
        fetch('http://localhost:8080/api/usuario/email/' + email)
        .then(function(response) {
            return response
        })
        .catch(function() {
            $('#input-email').css('border', '2px solid red')
            alert('Erro de conexão do sistema!')
        });
}

//Muda a senha do login no sistema 
function mandarCodigo(email){

    var result = verificarEmail(email);

    //Verifica se retornou uma resposta
    if(result != null){
        //Verifica se é verdadeiro ou falso
        if(result){
            var codigo = (function(email){
                fetch('http://localhost:8080/api/codigo/' + email)
                .then(function(response) {
                    return response;
                })
                .catch(function() {
                    $('#input-email').css('border', '2px solid red')
                    alert('Erro de conexão do sistema!')
                })
            });

            //Verifica se deu erro
            if(codigo != null){
                alert('Verifique seu e-mail, para inserir o código corretamente')
                document.getElementById('input-email').remove();
                $('#input-codigo').css('display','none')
                document.getElementById('input-enviar-email').remove();
                $('#input-enviar-codigo').css('display','none')
            }
        }else{
            $('#input-email').css('border', '2px solid red')
            alert('E-mail não cadastrado!')
        }
    }
}

function verificarCodigo(codigo){
    //Verifica se o código é igual ao enviado 
}