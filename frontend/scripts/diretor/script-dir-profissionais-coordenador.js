// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var usuario = sessionStorage.getItem("escolaUsuario");

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
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
            if(dadosUsuario.fotoUsuario != null){
                img.setAttribute('src', "/imagens-usuarios/"+dadosUsuario.fotoUsuario);
                img.style.borderRadius = "80%";
            }
        })

    xhr.send();
    
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

//Mascara dos inputs 
$("#inputTelefone").mask("(00) 0000-0000");
$("#inputCelular").mask("(00) 00000-0000");

//Método para pegar a escola Escolhida
var escolaEscolhida = $("#inputEscola").children("option:selected").val();
$("#inputEscola").change(function(){
    escolaEscolhida = $(this).children("option:selected").val();
}); 

//Método onclick botão de cadastrar
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

        //Dados Coordenador
        var nome = document.getElementById('inputNome').value;
        var sobrenome = document.getElementById('inputSobrenome').value;
        var telefone = document.getElementById('inputTelefone').value;
        var celular = document.getElementById('inputCelular').value;
        var cpf = document.getElementById('inputCpf').value;
        var horarioInicial = new Date(document.getElementById('inputHorarioInicial').valueAsDate);
        var horarioFinal = document.getElementById('inputHorarioFinal').valueAsDate;
        
        //Dados Endereço
        var estado = $("#inputEstado :selected").val();
        var cidade = document.getElementById('inputCidade').value;
        var bairro = document.getElementById('inputBairro').value;
        var cep = document.getElementById('inputCep').value;
        var logradouro = document.getElementById('inputLogradouro').value;
        var numero = Number(document.getElementById('inputNumero').value);
        var tipoLogradouro = document.getElementById('inputTipoLogradouro').value;

        //Dados de Login
        var email = document.getElementById('inputEmail').value;
        var senha = document.getElementById('inputSenha').value;
        var confirmarSenha = document.getElementById('inputConfirmSenha').value;

        //Valida a senha
        if (senha != confirmarSenha) {
            alert("As senhas não coincidem!")
        }else{

            //Verifica algum id disponível para ser registrado ao endereço
            var resposta = await usarApi("GET", "http://localhost:8080/api/enderecos");
            var enderecos =  JSON.parse(resposta);
            var ultimoId = Number(enderecos[enderecos.length-1].idEndereco);

            
            //Cria o objeto Endereço
            var inserirEndereco = {
                estado: estado,
                cidade: cidade,
                bairro: bairro,
                rua: logradouro,
                numero: numero,
                cep: cep
                //tipologradouro: tipoLogradouro
            }

            //Converte o endereço para JSON
            var enderecoJson =  JSON.stringify(inserirEndereco);

            //Chamada da api para registrar o Endereço no banco de dados
            var insertEndereco = await usarApi("POST", "http://localhost:8080/api/endereco/inserir/"+enderecoJson);
            
            //Cria o objeto Coordenador
            var inserirCoordenador = {
                nome: nome,
                sobrenome: sobrenome,
                cpf: cpf,
                telefone: telefone,
                celular: celular,
                tipoUsuario: 3,
                email: email,
                senha: senha,
                horarioFinalExpediente: horarioFinal,
                horarioInicioExpediente: horarioInicial,
                fotoUsuario: null,
                fk_endereco: ultimoId + 1,
                fk_escola: usuario
            }

            //Converte o coordenador para JSON
            var coordenadorJson = JSON.stringify(inserirCoordenador);

            //Chamada da api para registrar o Coordenador no banco de dados
            var insertUsuario = await usarApi("POST", "http://localhost:8080/api/usuario/inserir/"+coordenadorJson);
            
            if (insertUsuario == false || insertEndereco == false) {
                alert("Ocorreu um erro no cadastro do coordenador!")
            } else {
                alert("Cadastrado com sucesso");
            }
            
        }    
    }
    } else {
        alert("Preencha todos os campos!");
    }
}

    



