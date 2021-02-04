// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

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
            carregarListasTipo1();
        })
    xhr.send();

    //Reunioes com o dono sendo o usuario 
    function carregarListasTipo1(){
        
        var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/reunioes/"+idUsuario);

        xhr2.addEventListener("load", function(){
            var resposta2 = xhr2.responseText; 
            dadosReuniao = JSON.parse(resposta2);

            var reunioes = [];
            for (let i = 0; i < dadosReuniao.length; i++) {
                reunioes.push(dadosReuniao[i]);
            }
            carregarListasTipo2(reunioes)
        })
        xhr2.send();
    }

    //Reunioes onde o usuario participa 
    function carregarListasTipo2(reunioes){

        var xhr2 = new XMLHttpRequest(); 

        xhr2.open("GET", "http://localhost:8080/api/reunioes/participantes/"+idUsuario);

        xhr2.addEventListener("load", function(){
            var resposta2 = xhr2.responseText; 
            dadosReuniao = JSON.parse(resposta2);
           
            for (var i = 0; i < dadosReuniao.length; i++) {
                var passou = false;
                for (let j = 0; j < reunioes.length; j++) {
                    if(dadosReuniao[i].idReuniao == reunioes[j].idReuniao){
                        passou = true;
                    }
                }
                if(!passou){
                    reunioes.push(dadosReuniao[i]);
                }
            }

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

    //Mostra os resultados na tela 
    async function mostrar(reunioes){

        for (let i = 0; i < reunioes.length; i++) {

            //Pega a data da reuniao para comparacao
            var str = reunioes[i].dataInicio;
            var dataReuniao = new Date(str.getFullYear()+"-"+str.getMonth()+"-"+str.getDate());
            var dataAtual = new Date();

            var resp = dataReuniao.compare(dataAtual)
            alert(resp);

            //Verifica em qual lista vai 
            if(dataReuniao > dataAtual){
                var lista = document.getElementById("lista-programacao");
            }else if(dataReuniao == dataAtual){
                
            }else{
                var lista = document.getElementById("lista-historico");
            }

            //Cria uma nova linha 
            var linha = document.createElement("tr");
            linha.className = "linha";
            linha.classList.add("colunaRen");

            //Cria uma nova coluna da linha - part 1 
            var coluna = document.createElement("td");
            coluna.className = "td-lista foto-usuario";

            //Busca os dados do usuario dono da reuniao
            var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/"+reunioes[i].dono);
            var usuario = JSON.parse(resposta);
            
            //Cria a imagem dentro da coluna 1
            var img = document.createElement("img");
            img.className = "img-usuario";
            img.src = usuario.fotoUsuario;
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
            labelData.textContent = reunioes[i].dataInicio;
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
            var idReuniao = reunioes[$(this).index()-1].idReuniao
        
            //Busca dos reunioes passadas do usuário
            var xhr = new XMLHttpRequest(); 

            xhr.open("GET", "http://localhost:8080/api/reuniao/"+idReuniao);

            xhr.addEventListener("load", function(){
                var resposta = xhr.responseText; 
                dadosReuniao = JSON.parse(resposta);

                //Pega a data da reuniao para comparacao
                var str = dadosReuniao.dataInicio;
                var dataReuniao = new Date(str.split('/').reverse().join('/'));
                var dataAtual = new Date();

                // //Verifica em qual lista vai 
                // if(dataReuniao > dataAtual){
                //     alert('Reunião marcada para: '+('0' + dataReuniao.getDate()).slice(-2)+"/"+('0' + dataReuniao.getMonth()).slice(-2)+"/"
                //           +dataReuniao.getFullYear()+" - "+dataReuniao.setHours()+":"+dataReuniao.setMinutes());
                // }else if(dataReuniao == dataAtual){
                //     if((dataReuniao.getHours() - dataAtual.getHours()) <= 1 && (dataReuniao.getHours() - dataAtual.getHours()) > -1){
                //         alert("entrou")
                //     }else{
                //         alert('Reunião marcada para: '+('0' + dataReuniao.getDate()).slice(-2)+"/"+('0' + dataReuniao.getMonth()).slice(-2)+"/"
                //           +dataReuniao.getFullYear()+" - "+dataReuniao.setHours()+":"+dataReuniao.setMinutes());
                //     }
                // }else{
                //     alert('Reunião marcada para: '+('0' + dataReuniao.getDate()).slice(-2)+"/"+('0' + dataReuniao.getMonth()).slice(-2)+"/"
                //           +dataReuniao.getFullYear()+" - "+dataReuniao.setHours()+":"+dataReuniao.setMinutes());
                // }
            })
            xhr.send();
        });
        carregarRelatoriosTipo1();
    }

    //Busca os relatorios no banco enviados
    function carregarRelatoriosTipo1(){
        //Busca dos reunioes passadas do usuário
        var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/relatorios/enviados/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosRelatorio = JSON.parse(resposta);

            var relatorios = [];
            for (let i = 0; i < dadosRelatorio.length; i++) {
                relatorios.push(dadosRelatorio[i]);
            }
            carregarRelatoriosTipo2(relatorios);
        })
        xhr.send();
    }

    //Busca os relatorios no banco recebidos
    function carregarRelatoriosTipo2(relatorios){
        //Busca dos reunioes passadas do usuário
        var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/relatorios/recebidos/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosRelatorio = JSON.parse(resposta);

            for (let i = 0; i < dadosRelatorio.length; i++) {
                relatorios.push(dadosRelatorio[i]);
            }
   
            //Ordena a tabela pela data 
            for (var i = 0; i < relatorios.length; i++) {

                var str = relatorios[i].dataRelatorio;
                var dataRelatorio = new Date(str.split('/').reverse().join('/'));
    
                for(let j = 0; j < relatorios.length; j++){
                    var str2 = relatorios[j].dataRelatorio;
                    var dataRelatorio2 = new Date(str2.split('/').reverse().join('/'));
    
                    if(dataRelatorio > dataRelatorio2){
                        var elemento = relatorios[i];
                        relatorios[i] = relatorios[j];
                        relatorios[j] = elemento;
                    }
                }    
            }
            mostrarRelatorios(relatorios);
        })
        xhr.send();
    }

    //Mostra os resultados na tela 
    async function mostrarRelatorios(relatorios){
        for (let i = 0; i < relatorios.length; i++) {

            //Pega a lista - tabela 
            var lista = document.getElementById("lista-relatorios");

            //Cria uma nova linha 
            var linha = document.createElement("tr");
            linha.className = "linha";
            linha.classList.add("colunaRel");

            //Cria uma nova coluna da linha - part 1 
            var coluna = document.createElement("td");
            coluna.className = "td-lista foto-usuario";

            var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/"+relatorios[i].fk_usuario);
            var usuario = JSON.parse(resposta);
            
            //Cria a imagem dentro da coluna 1
            var img = document.createElement("img");
            img.className = "img-usuario";
            img.src = usuario.fotoUsuario;
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
            labelData.textContent = relatorios[i].dataRelatorio;
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
        
        //Abre o relatorio na tela 
        $( ".colunaRel" ).click(function() { 
            var idRelatorio = relatorios[$(this).index()-1].idRelatorio
            sessionStorage.setItem("idRelatorio",idRelatorio);
            novaJanela = window.open ("/frontend/paginas/diretor/dir-relatorio-aberto.html", "popup", "width="+screen.width/3+", height="+screen.height/1.5+", left="+(screen.width-(screen.width/3))/2+", top="+(screen.height-(screen.height/1.5))/2);
        });
    }

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

//Eventos de click nos botoes 
document.getElementById("criarRelatorios").addEventListener("click", function(){
    location = "/frontend/paginas/diretor/dir-relatorios.html";
})
document.getElementById("criarReunioes").addEventListener("click", function(){
    location = "/frontend/paginas/diretor/dir-reunioes.html";
})