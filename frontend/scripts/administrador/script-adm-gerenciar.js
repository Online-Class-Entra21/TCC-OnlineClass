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


listaEscolas();
        console.log("carregando");
        async function listaEscolas(){
            var resposta = await usarApi("GET", "http://localhost:8080/api/escolas");
            console.log(resposta)
            var escolas = JSON.parse(resposta);

            setTimeout(async function() {
                for (let i = 0; i < escolas.length; i++) {
                    var linha = document.createElement("tr");
                    var coluna = document.createElement("td");
                    var coluna2 = document.createElement("td");
                    var input = escolas[i].nome;
                    
                    coluna.append(input);
                    linha.append(coluna);
                    
                    
                    var diretor = await usarApi("GET","http://localhost:8080/api/diretor/escola/"+escolas[i].idEscola);
                    diretor = JSON.parse(diretor);
                    coluna2.append(diretor.nome);
                    linha.append(coluna2);
                    document.getElementById('tbLista').append(linha)
                }
                document.getElementById("idLoad").style.display = "none";
            }, 3000)
        }

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