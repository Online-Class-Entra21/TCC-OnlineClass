// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

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
            carregarAulas();
        })
    xhr.send();

    //Reunioes com o dono sendo o usuario 
    function carregarAulas(){
        
        var xhr2 = new XMLHttpRequest(); 
        
        xhr2.open("GET", "http://localhost:8080/api/aulas/"+idUsuario);
       
        xhr2.addEventListener("load", function(){
            var resposta2 = xhr2.responseText; 
            dadosReuniao = JSON.parse(resposta2);

            var reunioes = [];
            for (let i = 0; i < dadosReuniao.length; i++) {
                reunioes.push(dadosReuniao[i]);
            }
            mostrar(reunioes)
        })
        xhr2.send();
    }

    //Método para chamada da API async
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

    //Formata a data para exibição 
    function dataFormatada(data){
            dia      = data.getDate().toString(),
            diaF     = (dia.length == 1) ? '0'+dia : dia,
            mes      = (data.getMonth()+1).toString(), //+1 pois no getMonth Janeiro começa com zero.
            mesF     = (mes.length == 1) ? '0'+mes : mes,
            anoF     = data.getFullYear(),
            hora     = data.getHours().toString(),
            horaF    = (hora.length == 1) ? '0'+hora: hora,
            minutos  = data.getMinutes().toString();
            minutosF = (minutos.length == 1) ? '0'+minutos: minutos;
        return diaF+"/"+mesF+"/"+anoF+" - "+horaF+":"+minutosF;
    }

    //Mostra os resultados na tela 
    function mostrar(reunioes){

        //Ordena a tabela pela data 
        for (var i = 0; i < reunioes.length; i++) {

            var str2 = reunioes[i].dataInicio;
            var dataReuniao2 = new Date(str2.split('/').reverse().join('/'));

            for(let j = 0; j < reunioes.length; j++){
                var str3 = reunioes[j].dataInicio;
                var dataReuniao3 = new Date(str3.split('/').reverse().join('/'));

                if(dataReuniao2 > dataReuniao3){
                    var elemento = reunioes[i];
                    reunioes[i] = reunioes[j];
                    reunioes[j] = elemento;
                }
            }    
        }
        
        var reunioesMarcadas = [];
        for (let i = 0; i < reunioes.length; i++) {

            //Pega a data da reuniao para comparacao
            var str = reunioes[i].dataInicio;
            var dataReuniao = new Date(str)
            var dataAtual = new Date()

            //Diminui os 10 min de flexibilidade da entrada - verificacao de entrada - reunioes futuras 
            if((dataReuniao.setMinutes(dataReuniao.getMinutes() - 10)) > dataAtual){
                reunioesMarcadas.push(reunioes[i]);

            //Verifica se a reuniao ainda está acontecendo 
            }else if((dataAtual >= (dataReuniao.setMinutes(dataReuniao.getMinutes() - 10))) 
                    && (dataAtual <= (dataReuniao.setHours(dataReuniao.getHours() + 1)))){
                reunioesMarcadas.push(reunioes[i]);
            }
        }
        ordenarReunioesMarcadas(reunioesMarcadas)
    }

    //Ordenando e adicionando a tabela de reunioes marcadas
    async function ordenarReunioesMarcadas(reunioesMarcadas){

        //Ordena a tabela pela data 
        for (var i = 0; i < reunioesMarcadas.length; i++) {

            var str2 = reunioesMarcadas[i].dataInicio;
            var dataReuniao2 = new Date(str2.split('/').reverse().join('/'));

            for(let j = 0; j < reunioesMarcadas.length; j++){
                var str3 = reunioesMarcadas[j].dataInicio;
                var dataReuniao3 = new Date(str3.split('/').reverse().join('/'));

                if(dataReuniao2 < dataReuniao3){
                    var elemento = reunioesMarcadas[i];
                    reunioesMarcadas[i] = reunioesMarcadas[j];
                    reunioesMarcadas[j] = elemento;
                }
            }    
        }

        for (let i = 0; i < reunioesMarcadas.length; i++) {

            var lista = document.getElementById("lista-programacao");

            //Cria uma nova linha 
            var linha = document.createElement("tr");
            linha.className = "linha";

            //Verifica se a reuniao ainda vai acontecer 
            linha.classList.add("colunaRen");

            //Cria uma nova coluna da linha - part 1 
            var coluna = document.createElement("td");
            coluna.className = "td-lista foto-usuario";

            //Busca os dados do usuario dono da reuniao
            var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/"+reunioesMarcadas[i].dono);
            var usuario = JSON.parse(resposta);
            
            //Cria a imagem dentro da coluna 1
            var img = document.createElement("img");
            img.className = "img-usuario";
            if(usuario.fotoUsuario != undefined){
                img.src = "/imagens-usuarios/"+usuario.fotoUsuario;
            }else{
                img.src = "/frontend/imagens/perfil.png";
            }
            img.alt="Foto Usuario";
            img.title="Foto do Usuário";

            //Cria uma nova coluna da linha - part 2
            var coluna2 = document.createElement("td");
            coluna2.className = "td-lista dados";

            //Cria uma nova div dentro da coluna 2 
            var div1 = document.createElement("div");
            div1.className = "div-nome";

            //Cria uma nova label dentro da div 1
            var labelNome = document.createElement("label");
            labelNome.className = "nome";
            labelNome.name = "nome";
            labelNome.title = "Nome";
            labelNome.textContent = usuario.nome;
            div1.append(labelNome);

            //Cria uma nova div dentro da coluna 2 
            var div2 = document.createElement("div");
            div2.className = "div-data";

            //Cria uma nova label dentro da div 1
            var labelData = document.createElement("label");
            labelData.className = "data";
            labelData.name = "data";
            labelData.title = "Data";
            
            var str = reunioesMarcadas[i].dataInicio;
            var dataReuniao = new Date(str)

            labelData.textContent = dataFormatada(dataReuniao);
            div2.append(labelData);

            //Adiciona os conteudos nas colunas 
            coluna.append(img)
            coluna2.append(div1);
            coluna2.append(div2);

            //Adiciona as colunas na linha 
            linha.append(coluna);
            linha.append(coluna2);

            //Adiciona a linha na lista - tabela 
            lista.append(linha);
        }
        
        //Abrir reuniao marcada 
        $( ".colunaRen" ).click(function() { 
            var idReuniao = reunioesMarcadas[$(this).index()-1].idReuniao;
        
            //Busca dos reunioes passadas do usuário
            var xhr = new XMLHttpRequest(); 

            xhr.open("GET", "http://localhost:8080/api/reuniao/"+idReuniao);

            xhr.addEventListener("load", function(){
                var resposta = xhr.responseText; 
                dadosReuniao = JSON.parse(resposta);

                //Pega a data da reuniao para comparacao
                var str = dadosReuniao.dataInicio;
                var dataReuniao = new Date(str)
                var dataAtual = new Date()

                //Diminui os 10 min de flexibilidade da entrada - verificacao de entrada 
                if(dataAtual < (dataReuniao.setMinutes(dataReuniao.getMinutes() - 10))){
                    alert('Reunião marcada para: '+dataFormatada(dataReuniao)+'\nVocê poderá entrar 10 min antes');
                    //Verifica se a reuniao ainda está acontecendo 
                }else if((dataAtual >= (dataReuniao.setMinutes(dataReuniao.getMinutes() - 10))) 
                        && (dataAtual <= (dataReuniao.setHours(dataReuniao.getHours() + 1)))){
                    sessionStorage.setItem("idReuniao",idReuniao)
                    location.href = "/frontend/paginas/aluno/aluno-video_chamada.html";
                }
            })
            xhr.send();
        });
    }

}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
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