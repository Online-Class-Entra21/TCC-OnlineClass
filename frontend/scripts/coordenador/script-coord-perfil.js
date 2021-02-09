// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var dadosUsuario;
var email;
var cpf;
var cpfPadrao;
var idEndereco;

//Verifica se já tem foto do usuario 
var isFotoExistente = false;

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
            //Adiciona o nome 
            document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome +" "+dadosUsuario.sobrenome;
            //Adiciona a foto de perfil do usuario
            var img = document.querySelector("#idFotoPerfil");
            if(dadosUsuario.fotoUsuario != null){
                img.setAttribute('src', "/imagens-usuarios/"+dadosUsuario.fotoUsuario);
                img.style.borderRadius = "80%";
            }
            email = dadosUsuario.email;

            //Puxa os dados do Coordenador
            document.getElementById('inputNome').value = dadosUsuario.nome;
            document.getElementById('inputSobrenome').value = dadosUsuario.sobrenome;
            document.getElementById('inputTelefone').value = dadosUsuario.telefone;
            document.getElementById('inputCelular').value = dadosUsuario.celular;
            document.getElementById('inputCpf').value = dadosUsuario.cpf;
            cpfPadrao = dadosUsuario.cpf;
            idEndereco = dadosUsuario.fk_endereco;

            document.getElementById('inputHorarioInicial').value = timeFormat(new Date(dadosUsuario.horarioInicioExpediente));
            document.getElementById('inputHorarioFinal').value = timeFormat(new Date(dadosUsuario.horarioFinalExpediente));

            //Dados de Login
            document.getElementById('inputEmail').value = dadosUsuario.email;
            document.getElementById('inputSenha').value = dadosUsuario.senha;
            document.getElementById('inputConfirmSenha').value = dadosUsuario.senha;

            //Puxando imagem
            var caminhoImagem = dadosUsuario.fotoUsuario;
            
            //Verifica se a imagem não é nula 
            if(caminhoImagem != undefined){
                $("#img_preview").show();
                $("#img_preview").attr("src", "/imagens-usuarios/"+caminhoImagem);
                document.getElementById('botao-input').value = "Alterar Imagem";
                document.getElementById('ok').textContent = "Ok"; 
                isFotoExistente = true;
            }

            buscaEndereco(dadosUsuario.fk_endereco);
        })

    xhr.send();
    
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

//Carregamento automático da foto do usuario 
function ImagePreview(input)
{
    if (input.files && input.files[0])
	{
        var r = new FileReader();
        r.onload = function(e)
		{
			$("#img_preview").show();
            $("#img_preview").attr("src", e.target.result);
        }
        r.readAsDataURL(input.files[0]);
    }
}
$().ready(function() {

	hide_empty_image = false;
	set_blank_to_empty_image = false;
	set_image_border = true;

	if (hide_empty_image)
		$("#img_preview").hide();

	if (set_blank_to_empty_image)
		$("#img_preview").attr("src","data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs=");

	if (set_image_border)
		$("#img_preview").css("border", "2px solid #ffffff");
  
    $("#img_preview").css("width", "53%");
    $("#img_preview").css("height", "60%");

	$("#imagemInput").change(function(e){
        ImagePreview(this);
        url = URL.createObjectURL(e.target.files[0]);
        $('#imagemInput').html($(this).val());
        document.getElementById('botao-input').value = "Alterar Imagem";
        document.getElementById('ok').textContent = "Ok";
        imagem = this.files;
    });
});
var imagem;

//Eventos de abertura e fechamento do preview
$("#visualizacao").click(function(){
    if($("#imagemInput").val() != "" || isFotoExistente){
        $("#visul-img").css("display", "inline");
    }else{
        alert("insira uma imagem primeiro!");
    }
})
$("#idBotaoFechar").click(function(){
    $("#visul-img").css("display", "none");
})

//Aciona o botao de carregamento de imagens 
document.getElementById('botao-input').onclick = function () {
    document.getElementById('imagemInput').click();
};

function buscaEndereco(fk_endereco){

    //Busca dos dados do endereco
    var xhr = new XMLHttpRequest(fk_endereco); 

        xhr.open("GET", "http://localhost:8080/api/endereco/"+fk_endereco);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            endereco = JSON.parse(resposta);

            //Busca os dados de Endereço do coordenador 
            $("#inputEstado :selected").val();
            document.getElementById('inputCidade').value = endereco.cidade; 
            document.getElementById('inputBairro').value = endereco.bairro;
            document.getElementById('inputCep').value = endereco.cep;
            document.getElementById('inputLogradouro').value = endereco.rua;
            document.getElementById('inputNumero').value = endereco.numero;

            if(endereco.tipoUsuario != undefined){
                document.getElementById('inputTipoLogradouro').value = endereco.tipoUsuario;
            }
        })

    xhr.send();
}

//Mascara dos inputs 
$("#inputTelefone").mask("(00) 0000-0000");
$("#inputCelular").mask("(00) 00000-0000");
$("#inputCpf").mask("000.000.000-00");
$("#inputCep").mask("00000-000");

//Preenchimento de CEP
document.getElementById("inputCep").addEventListener("blur",function(){
    var cep = document.getElementById("inputCep").value;
    cep = cep.replace("-","");
    buscarCep(cep);
})

//Busca o cep altomaticamente
async function buscarCep(cep){
    var resposta = await usarApi("GET", "http://viacep.com.br/ws/"+cep+"/json/");
    var dadosLocalizacao =  JSON.parse(resposta);
    if(resposta != null){
        document.getElementById("inputEstado").value = dadosLocalizacao.uf;
        document.getElementById("inputCidade").value = dadosLocalizacao.localidade;
        document.getElementById("inputBairro").value = dadosLocalizacao.bairro;
        document.getElementById("inputLogradouro").value = dadosLocalizacao.logradouro;
    }else{
        alert("CEP inválido!")
    }
}

//Método onclick botão de cadastrar
var btnCadastrar =  document.getElementById('btnCadastrar');
btnCadastrar.addEventListener("click", function() {
    editar();
})

//Método para cadastrar
async function editar() {

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
        var horarioFinal = new Date(document.getElementById('inputHorarioFinal').valueAsDate);
        horarioInicial.setHours(horarioInicial.getHours()+3);
        horarioFinal.setHours(horarioFinal.getHours()+3);
        console.log(horarioInicial.getHours());
        //Dados Endereço
        var estado = $("#inputEstado :selected").val();
        var cidade = document.getElementById('inputCidade').value;
        var bairro = document.getElementById('inputBairro').value;
        var cep = document.getElementById('inputCep').value;
        var logradouro = document.getElementById('inputLogradouro').value;
        var numero = Number(document.getElementById('inputNumero').value);
        var complemento = document.getElementById('inputTipoLogradouro').value;

        //Dados de Login
        var emailDigitado = document.getElementById('inputEmail').value;
        var senha = document.getElementById('inputSenha').value;
        var confirmarSenha = document.getElementById('inputConfirmSenha').value;

        //Valida a senha
        if (senha != confirmarSenha) {
            alert("As senhas não coincidem!")
        }else{

            //Verifica o email se já está sendo usado 
            var resp = await usarApi("GET", "http://localhost:8080/api/verificar/"+ email);
            var isExisteEmail = JSON.parse(resp);

            if(!isExisteEmail || email == emailDigitado){

                //Verifica se o cpf é válido
                cpfValida = cpf.replace(".", "");
                cpfValida = cpfValida.replace(".", "");
                cpfValida = cpfValida.replace("-", "");

                cpfPadrao = cpfPadrao.replace(".", "");
                cpfPadrao = cpfPadrao.replace(".", "");
                cpfPadrao = cpfPadrao.replace("-", "");

                var isValido = TestaCPF(cpfValida);

                if(isValido){

                    //Verifica se o cpf já está sendo usado  
                    var resp = await usarApi("GET", "http://localhost:8080/api/verificar/cpf/"+ cpf);
                    var isExisteCpf =  JSON.parse(resp);

                    if(!isExisteCpf || (cpfValida == cpfPadrao)){

                        //Verifica se o horário é válido ou não 
                        if(horarioInicial < horarioFinal){
                            
                            //Cria o objeto Endereço
                            var inserirEndereco = {
                                estado: estado,
                                cidade: cidade,
                                bairro: bairro,
                                rua: logradouro,
                                numero: numero,
                                cep: cep,
                                complemento: complemento
                            }

                            //Converte o endereço para JSON
                            var enderecoJson =  JSON.stringify(inserirEndereco);

                            //Chamada da api para registrar o Endereço no banco de dados
                            var insertEndereco = await usarApi("POST", "http://localhost:8080/api/endereco/inserir/"+enderecoJson);

                            //Cria o objeto Coordenador
                            var inserirCoordenador = {
                                idUsuario: idUsuario,
                                nome: nome,
                                sobrenome: sobrenome,
                                cpf: cpf,
                                telefone: telefone,
                                celular: celular,
                                tipoUsuario: 3,
                                email: emailDigitado,
                                senha: senha,
                                horarioFinalExpediente: horarioFinal.toISOString(),
                                horarioInicioExpediente: horarioInicial.toISOString(),
                                fotoUsuario: null,
                                fk_endereco: idEndereco,
                                fk_escola: dadosUsuario.fk_escola
                            }

                            //Converte o coordenador para JSON
                            var coordenadorJson = JSON.stringify(inserirCoordenador);

                            //Chamada da api para registrar o Coordenador no banco de dados
                            var insertUsuario = await usarApi("PUT", "http://localhost:8080/api/usuario/alterar/"+coordenadorJson);
                            
                             //Altera a imagem
                             if (imagem!=undefined) {
                                 UploadFile(imagem,"http://localhost:8080/api/upload/"+idUsuario);
                             }
                            
                            if (!insertUsuario || !insertEndereco) {
                                alert("Ocorreu um erro ao editar coordenador!")
                            } else {
                                alert("Editado com sucesso");
                            }

                        }else{
                            alert("Hora inicial não pode ser maior ou igual ao horario final");
                        }
                    }else{
                        alert("CPF já cadastrado no sistema!")
                    }
                }else{
                    alert("CPF inválido!")
                }
            }else{
                alert("E-mail já cadastrado no sistema!");
            }
        }
    } 
}

    



