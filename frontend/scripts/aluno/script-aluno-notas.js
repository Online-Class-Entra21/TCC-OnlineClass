// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");
var fk_escola;

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){

    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            var dadosUsuario = JSON.parse(resposta);
            fk_escola = dadosUsuario.fk_escola;
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

buscarNotas();
//Buscar notas do usuario 
async function buscarNotas(){

    //Busca os dados do usuario dono da reuniao
    var resposta = await usarApi("GET", "http://localhost:8080/api/notas/"+idUsuario);
    var dados = JSON.parse(resposta);
    
    for (let i = 0; i < dados.length; i++) {
        const element = dados[i];
        
        //Cria uma nova linha 
        var linha = document.createElement("tr");
        linha.className = "linha";

        //Cria uma nova coluna da linha - part 1 
        var periodo = document.createElement("td");
        periodo.className = "td-lista";
        var tipoPeriodo;

        //Busca os dados do usuario dono da reuniao
        var resposta2 = await usarApi("GET", "http://localhost:8080/api/periodosAvaliacoes/"+fk_escola);
        var periodosBuscados = JSON.parse(resposta2);

        if(periodosBuscados.length == 2){
            tipoPeriodo = 2;
        }else if(periodosBuscados.length == 3){
            tipoPeriodo = 3;
        }else if(periodosBuscados.length == 4){
            tipoPeriodo = 4;
        }else{
            tipoPeriodo = 0;
            periodo.textContent = "Periodo único";
        }
        
        for (let i = 0; i < periodosBuscados.length; i++) {
            const element = periodosBuscados[i];
            
            var dataInicio = element.dataInicial;
            var dataFinal = element.dataFinal;
            now = new Date();
            
            if(now >= dataInicio && now <= dataFinal){
                periodo.textContent = element.descricao;
            }
        }

        //Cria uma nova coluna da linha - part 2
        var materia = document.createElement("td");
        materia.className = "td-lista";
        materia.textContent = element.materia;

        //Cria uma nova coluna da linha - part 3
        var data = document.createElement("td");
        data.className = "td-lista";
        data.textContent = element.dataNota;

        //Cria uma nova coluna da linha - part 4
        var avaliacao = document.createElement("td");
        avaliacao.className = "td-lista";
        avaliacao.textContent = element.tipoAvaliacao;
        
        //Cria uma nova coluna da linha - part 5
        var nota = document.createElement("td");
        nota.className = "td-lista";
        nota.textContent = element.nota;

        var lista = document.getElementById("idTabela");
        
        linha.append(materia);
        linha.append(data);
        linha.append(avaliacao);
        linha.append(nota);

        lista.append(linha);
    }
}