// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var idDiretorSelecionado;
var senha;

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

    xhr.send();

}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

//Mascara dos inputs 
$("#inputTelefone").mask("(00) 0000-0000");
$("#inputCelular").mask("(00) 00000-0000");

//Retorna o id da escola a ser editada
var idEscolaSelecionada = sessionStorage.getItem('idEscolaSelecionada')
     
carregarCampos();

//Método para carregar os campos com os atuais dados da escola 
async function carregarCampos() {

    //Busca os dados da escola 
    var resposta = await usarApi("GET", "http://localhost:8080/api/escola/" + idEscolaSelecionada)
    var escola = JSON.parse(resposta)

    document.getElementById('inputEscola').value = escola.nome;

    resposta = await usarApi("GET", "http://localhost:8080/api/diretor/escola/" + idEscolaSelecionada)
    var diretor = JSON.parse(resposta);
 
    if (diretor == null) {
        document.getElementById('inputNome').value = "Nenhum";
    } else {
        idDiretorSelecionado = diretor.idUsuario;
        document.getElementById('inputNome').value = diretor.nome;
        document.getElementById('inputSobrenome').value = diretor.sobrenome;
        document.getElementById('inputCelular').value = diretor.celular;
        document.getElementById('inputTelefone').value = diretor.telefone;
        document.getElementById('inputEmail').value = diretor.email;
        senha = document.getElementById('inputSenha').value = diretor.senha;
    }        
}

//Chama o método editarEscola ao clicar no botão confirmar
$("#btnEditar").click(function() {
    editarEscola();
})
    
//Método para edição da escola  
async function editarEscola(idEscola) {

    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{

        var isConfirmado = false;
        //Pede a confirmação da senha 
        if(senha != document.getElementById("inputSenha").value){
            isConfirmado = confirm("Deseja mesmo alterar a senha?");

            //Confirma a troca de senha 
            if(isConfirmado){
                //Edita os Campos da escola
                var alterarEscola = {
                    nome: document.getElementById('inputEscola').value,
                }
                var escolaJson = JSON.stringify(alterarEscola);
                var updateEscola = await usarApi("PUT", "http://localhost:8080/api/escola/alterar/administrador/"+escolaJson)
                if (updateEscola == false) {
                    alert("Erro ao salvar edição!");
                }else{
                    editarDiretor();
                }
            }

        }else{
            //Edita os Campos da escola
            var alterarEscola = {
                idEscola: idEscolaSelecionada,
                nome: document.getElementById('inputEscola').value
            }
            var escolaJson = JSON.stringify(alterarEscola);
            var updateEscola = await usarApi("PUT", "http://localhost:8080/api/escola/alterar/administrador/"+escolaJson)
            if (updateEscola == false) {
                alert("Erro ao salvar edição!");
            }else{
                editarDiretor();
            }
        }
    }
}   

//Método para edição da escola  
async function editarDiretor() {

    //Edita os Campos da escola
    var alterarDiretor = {
        idUsuario: idDiretorSelecionado,
        nome: document.getElementById('inputNome').value,
        sobrenome: document.getElementById('inputSobrenome').value,
        celular: document.getElementById('inputCelular').value,
        telefone: document.getElementById('inputTelefone').value,
        email: document.getElementById('inputEmail').value,
        senha: document.getElementById('inputSenha').value
    }
    var diretorJson = JSON.stringify(alterarDiretor);
    console.log(diretorJson)

    var updateEscola = await usarApi("PUT", "http://localhost:8080/api/diretor/alterar/"+diretorJson)

    if (updateEscola == false) {
        alert("Erro ao salvar edição!");
    }else{
        alert("Alterado com sucesso!");
    }
}

//Evento de exclusão de escola 
document.getElementById("btnExcluir").addEventListener("click",function(){

    var isConfirm =  confirm("Tem certeza de que deseja excluir a escola "+ document.getElementById('inputNome').value+"?")
    
    if(isConfirm){
        excluirEscola();
    }
});

//Método para deletar a escola
async function excluirEscola() {

    //Exclui o diretor
    if (resposta != null) {
        var diretor = JSON.parse(resposta);
        var excluirDiretor = await usarApi("DELETE", "http://localhost:8080/api/usuario/deletar/" + idDiretorSelecionado);
    }

    //Exclui a escola
    var excluirEscola = await usarApi("DELETE", "http://localhost:8080/api/escola/deletar/" + escolaEscolhida);
    
    //Verificação
    if (!excluirDiretor || !excluirEscola) {
        alert("Ocorreu um erro ao excluir a instituição!")
    }else{
        alert("Excluida com sucesso!")
    }
}

//Email repetido 
//Excluir 
//Revição geral




