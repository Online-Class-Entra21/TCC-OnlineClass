// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var idEscolaSelecionada;

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
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
            idEscolaSelecionada = dadosUsuario.fk_escola;
            //Carrega os dados da escola 
            carregarDadosEscola(dadosUsuario.fk_escola)
        })

    xhr.send();
    
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

//Carrga os dados do perfil do diretor
function carregarDadosEscola(fk_escola){

    //Busca dos dados da escola 
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/escola/"+fk_escola);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosEscola = JSON.parse(resposta);

            //Pega o nome da escola 
            document.getElementById('idEditEscola').value = dadosEscola.nome;

            //Pega a data de inicio do ano letivo 
            var dataInicio = dadosEscola.dataInicioLetivo;
            if(dataInicio != null){
                var data = new Date(dataInicio);
                var dataInicioLetivo = dataFormatada1(data);
                document.getElementById('idInicioAnoLetivo').value = dataInicioLetivo;
            }

            //Pega a data de fim do ano letivo 
            var dataFinal = dadosEscola.dataFinalLetivo;
            if(dataFinal != null){
                var data = new Date(dataFinal);
                var dataFinalLetivo = dataFormatada1(data);
                document.getElementById('idFinalAnoLetivo').value = dataFinalLetivo;
            }
        })

    xhr.send();
}

//Alteracao da escola 
document.getElementById("salv-esc").addEventListener("click",function(){
    atualizaDadosEscola();
})

async function atualizaDadosEscola(){

    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        
        //Verificacao de data
        var dataInicio = document.getElementById('idInicioAnoLetivo').value;
        var str = dataInicio;
        var dataInicio = new Date(str);

        var dataFinal = document.getElementById('idFinalAnoLetivo').value;
        var str = dataFinal;
        var dataFinal = new Date(str);

        if(dataFinal > dataInicio){
            //Pega os dados da escola 
            var escola = {
                idEscola: idEscolaSelecionada,
                nome: $("#idEditEscola").val(),
                dataInicioLetivo: $("#idInicioAnoLetivo").val(),
                dataFinalLetivo: $("#idFinalAnoLetivo").val()
            }

            //Altera os dados da escola 
            var json = JSON.stringify(escola);
            var resposta =  await usarApi("PUT", "http://localhost:8080/api/escola/alterar/"+json); 
            var isCorreto = JSON.parse(resposta);

            if(isCorreto){
                alert("Editado com sucesso!");
            }else{
                alert("Erro ao salvar!");
            }
        }else{
            alert("Data final deve se maior que a inicial!");
        }
    }
}

//Abre a visualizacao dos periodos de avaliacao 
document.getElementById("img-visualizar").addEventListener("click",function(){
    novaJanela = window.open ("/frontend/paginas/diretor/dir-periodos.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2);
})

document.getElementById("salv-per").addEventListener("click", function(){
    inserirPeriodoAvaliativo();
})

async function inserirPeriodoAvaliativo(){

    //Verifica se os campos foram preenchidos 
    var form = $('#formulario2');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        //Verificacao de data 
        var dataInicio = document.getElementById('idInicioPeriodo').value;
        var str = dataInicio;
        var dataInicioConvertida = new Date(str);

        var dataFinal = document.getElementById('idFinalPeriodo').value;
        var str = dataFinal;
        var dataFinalConvertida = new Date(str);

        if(dataFinalConvertida > dataInicioConvertida){
            //dados do periodo avaliativo
            var periodo = {
                dataInicial: dataInicioConvertida,
                datafinal: dataFinalConvertida,
                descricao: $("#idDescricao").val(),
                fk_escola: idEscolaSelecionada
            }
        
            //insere os periodos avaliativos no sistema  
            var json = JSON.stringify(periodo);
            var resposta =  await usarApi("POST", "http://localhost:8080/api/periodoAvaliacao/inserir/"+json); 
            var isCorreto = JSON.parse(resposta);

            if(isCorreto){
                alert("Inserido com sucesso!");
            }else{
                alert("Erro ao inserir!");
            }
        }else{
            alert("Data final deve se maior que a inicial!");
        }
    }
}




 