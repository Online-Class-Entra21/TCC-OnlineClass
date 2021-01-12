//Verifica as informações e loga no sistema 
function logar(){
    if($("#senha").val() == "123"){
        location.href = "/frontend/paginas/aluno/aluno.html";
    }
    else if($("#senha").val() == "321") {
        location.href = "/frontend/paginas/diretor/tela-principal.html";
    }
    else{
        alert('Negado');
    }
}
    //Muda a senha do login no sistema 
function mudarSenha(){   
    var resultado = confirm('Deseja receber um código de verificação para recuperar a senha?');
    if(resultado){
        alert("Enviou o código")
    }
}