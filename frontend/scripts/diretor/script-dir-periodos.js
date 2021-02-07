consultarPeriodos();
function consultarPeriodos(){

    //Busca dos periodos avaliativos 
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/periodosAvaliacoes");

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            var dados = JSON.parse(resposta);
            
            dados.forEach(element => {
                //Cria uma linha e suas colunas 
                var linha = document.createElement("tr");
                linha.classList.add("linhas");

                //Coluna de dataInicial
                var colunaDataIni = document.createElement("td");
                var data = element.dataInicial;
                var dataInicial = new Date(data);
                colunaDataIni.textContent = dataFormatada1(dataInicial);

                //Coluna de dataFinal
                var colunaDataFin = document.createElement("td");
                var data2 = element.dataFinal;
                var dataFinal = new Date(data2);
                colunaDataFin.textContent = dataFormatada1(dataFinal);

                //Coluna de descricao
                var colunaDes = document.createElement("td");
                colunaDes.textContent = element.descricao;

                //Adiciona a linha na tabela 
                var tabela = document.getElementById("tab");
                linha.appendChild(colunaDataIni);
                linha.appendChild(colunaDataFin);
                linha.appendChild(colunaDes);

                tabela.appendChild(linha);
            });

            $( ".linhas" ).dblclick(function() { 
                var isConfirm = confirm("Deseja apagar o periodo de avaliacao?");

                if(isConfirm){
                    var idPeriodo = dados[$(this).index()-1].idPeriodoAvaliacao;
                    apagar(idPeriodo);
                }
            });
        })

    xhr.send();
}

//Apaga o periodo de avaliacao
async function apagar(idPeriodo){
    var resposta = await usarApi("DELETE", "http://localhost:8080/api/periodoAvaliacao/deletar/"+idPeriodo);
    var isApagou = JSON.parse(resposta);

    if(isApagou){
        alert("Apagado com sucesso!");
        location = "/frontend/paginas/diretor/dir-periodos.html";
    }else{
        alert("Erro ao apagar!");
    }
}

//Formata a data para exibição para (AAAA-MM-DD)
function dataFormatada1(data){
    dia      = data.getDate().toString(),
    diaF     = (dia.length == 1) ? '0'+dia : dia,
    mes      = (data.getMonth()+1).toString(), //+1 pois no getMonth Janeiro começa com zero.
    mesF     = (mes.length == 1) ? '0'+mes : mes,
    anoF     = data.getFullYear();
    return anoF+"-"+mesF+"-"+diaF;
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