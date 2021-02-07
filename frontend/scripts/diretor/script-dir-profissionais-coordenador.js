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
                reject({
                    status: this.status,
                    statusText: xhr.statusText
                });
            }
        };
        xhr.onerror = function () {
            reject({
                status: this.status,
                statusText: xhr.statusText
            });
        };
        xhr.send();
    });
}

//Cria os CheckBox
carregarCheckbox();

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

//Método onclick botão de remover
var btnDeletar = document.getElementById('btnDeletar');
btnDeletar.addEventListener("click", function() {
    remover();
})

//Método para cadastrar
async function cadastrar() {
    //Dados Coordenador
    var nome = document.getElementById('inputNome').value;
    var sobrenome = document.getElementById('inputSobrenome').value;
    var telefone = document.getElementById('inputTelefone').value;
    var celular = document.getElementById('inputCelular').value;
    var cpf = document.getElementById('inputCpf').value;
    var horarioInicial = new Date(document.getElementById('inputHorarioInicial').valueAsDate);
    var horarioFinal = document.getElementById('inputHorarioFinal').valueAsDate;
    //var horarioInicialFormatado = horarioInicial.toString().slice(16,24);
    //var horarioFinalFormatado = horarioFinal.toString().slice(16,24);
    
    
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

    //Verifica os Campos
    if (nome != '' && sobrenome != ''  && telefone != '' && celular != '' && cpf != '' 
    && estado != '' && cidade != '' && bairro != '' && cep != '' && logradouro != '' && numero != '' && tipoLogradouro != ''
    && email != '' && senha != '' && confirmarSenha != '') {

        //Valida a senha
        if (senha != confirmarSenha) {
            alert("As senhas não coincidem!")
        } else {
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
    } else {
        alert("Preencha todos os campos!");
    }
    
}

//Método para carregar a lista no canto direito com os coordenadores existentes
async function carregarCheckbox() {
    var divCoord = document.getElementById('coordExiste');

    var resposta = await usarApi("GET", "http://localhost:8080/api/coordenador/escola/"+usuario)
    var coordenadores =  JSON.parse(resposta);

    //Verifica se existe algum coordenador ja cadastrado
    if (coordenadores != null) {
        var coordenadoresIndex = []
        for (let i = 0; i < coordenadores.length; i++) {
            coordenadoresIndex.push(coordenadores[i]);

            var checkbox = document.createElement("input");
            checkbox.type="checkbox";
            checkbox.name="nmCoordenadores";
            checkbox.value=coordenadores[i].idUsuario;
            var id = "id"+coordenadores[i].nome;
            checkbox.id=id;
           
            var label = document.createElement("label")
            label.htmlFor=id
            label.appendChild(document.createTextNode(coordenadores[i].nome))
                    
           divCoord.appendChild(checkbox);
           divCoord.appendChild(label)
        }    
    }
    /*
    //Retorna o valor da linha da escola clicada
    $( ".LinhaCoordenadores" ).click(function() { 
        var coordenadorEscolhido = coordenadoresIndex[$(this).index()];
        $(".LinhaCoordenadores").css("background-color", "rgba(203, 207, 209)");
        $(".LinhaCoordenadores").css("color", "black");
        $(".LinhaCoordenadores").css("width", "100%")
        //sessionStorage.setItem('idEscolaSelecionada', escolaEscolhida)
        //location.href = "/frontend/paginas/administrador/adm-editar.html";
    });  
   */
}

/*
async function remover() {
    
    //pegar o id pelo coordenador selecionado no checkbox
    
    var confirmar = confirm("Tem certeza de que deseja remover esse coordenador?")

    var removerEndereco = await usarApi("DELETE", "http://localhost:8080/api/endereco/deletar/"+coordenador.fk_escola)

    var removerCoordenador = await usarApi("DELETE", "http://localhost:8080/api/usuario/deletar/" + idCoordenador)
    

    if (confirmar == true) {
        if (removerCoordenador == false) {
            alert("Ocorreu um erro ao remover o coordenador.")
        } else {
            alert("Coordenador removido com sucesso.")
        }
    }
    
}
*/

/*
async function carregarCampos() {
    //Busca os dados do coordenador selecionado no checkbox 
    var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/" + idUsuario)
    var coordenador = JSON.parse(resposta)


    //Dados Coordenador
    document.getElementById('inputNome').value = coordenador.nome;
    document.getElementById('inputSobrenome').value = coordenador.sobrenome;
    document.getElementById('inputTelefone').value = coordenaor.telefone;
    document.getElementById('inputCelular').value = coordenador.celular;
    document.getElementById('inputCpf').value = coordenador.cpf
    
    //var horarioInicial = new Date(document.getElementById('inputHorarioInicial').valueAsDate);
    //var horarioFinal = document.getElementById('inputHorarioFinal').valueAsDate;
    //var horarioInicialFormatado = horarioInicial.toString().slice(16,24);
    //var horarioFinalFormatado = horarioFinal.toString().slice(16,24);
    
    //Dados de Login
    document.getElementById('inputEmail').value = coordenador.email;
    document.getElementById('inputSenha').value = coordenador.senha;
    document.getElementById('inputConfirmSenha').value = coordenador.senha;

    resposta = await usarApi("GET", "http://localhost:8080/api/endereco/"+coordenador.fk_escola);
    var endereco = JSON.parse(resposta);

    //Dados Endereço
    var estado = $("#inputEstado").val(endereco.estado);
    document.getElementById('inputCidade').value = endereco.cidade;
    var bairro = document.getElementById('inputBairro').value = endereco.bairro;
    var cep = document.getElementById('inputCep').value = endereco.cep;
    var logradouro = document.getElementById('inputLogradouro').value = endereco.logradouro;
    var numero = document.getElementById('inputNumero').value = endereco.numero;
    //var tipoLogradouro = document.getElementById('inputTipoLogradouro').value = endereco.tipoLogradouro;  
}
*/

    



