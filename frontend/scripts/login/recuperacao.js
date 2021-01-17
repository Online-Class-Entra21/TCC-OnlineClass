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
                    salvarCodigo = new salvarCodigo(codigo);
                    console.log(salvarCodigo.getCodigo());

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

function verificarCodigo(codigo){
    //Verifica se o código é igual ao enviado 
}