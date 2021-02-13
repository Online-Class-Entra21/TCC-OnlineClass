
//Evento para gerar boletim 
document.getElementById("gerar-boletim").addEventListener("click", function(){
    gerarBoletim();
})

async function gerarBoletim() {

    //Primeira parte da tabela - dados importantes

    //Busca os dados do usuario
    var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/"+idUsuario);
    var usuario = JSON.parse(resposta);

    //Busca os dados da escola 
    var resposta = await usarApi("GET", "http://localhost:8080/api/escola/"+usuario.fk_escola);
    var escola = JSON.parse(resposta);

    //Busca os dados da escola 
    var resposta = await usarApi("GET", "http://localhost:8080/api/aluno/usuario/"+idUsuario);
    var aluno = JSON.parse(resposta);

    //Busca os dados da turma
    var resposta = await usarApi("GET", "http://localhost:8080/api/turma/"+aluno.fk_turma);
    var turma = JSON.parse(resposta);

    now = new Date();

    document.getElementById("nome-escola").textContent = escola.nome;
    document.getElementById("turma").textContent = turma.ano;
    document.getElementById("ano").textContent = now.getFullYear();

    //Segunda parte da tabela - notas e periodos 

    //Busca os periodos de avaliacao
    var resposta = await usarApi("GET", "http://localhost:8080/api/periodosAvaliacoes/"+fk_escola);
    var periodosBuscados = JSON.parse(resposta);
    var tipoPeriodo;

    if(periodosBuscados.length == 2){
        tipoPeriodo = 2;
    }else if(periodosBuscados.length == 3){
        tipoPeriodo = 3;
    }else if(periodosBuscados.length == 4){
        tipoPeriodo = 4;
    }else{
        tipoPeriodo = 0;
    }
    
    var lista = document.getElementById("tabela-notas-boletim");
    var linha = document.createElement("tr");

    var media = document.createElement("th");
    media.textContent = "Matéria";
    linha.append(media)

    for (let i = 0; i < tipoPeriodo; i++) {
        const element = periodosBuscados[i];

        var periodo = document.createElement("th");
        periodo.textContent = element.descricao;
        linha.append(periodo)
    }

    if(tipoPeriodo == 0){
        var periodo = document.createElement("th");
        periodo.textContent = "Período único";
        linha.append(periodo)
    }

    var media = document.createElement("th");
    media.textContent = "Média";
    linha.append(media)
    lista.append(linha);

    //Busca os as notas do aluno
    var resposta = await usarApi("GET", "http://localhost:8080/api/notas/"+idUsuario);
    var notas = JSON.parse(resposta);

    dadosNotas = [];
    for (let i = 0; i < notas.length; i++) {
        const element = notas[i];
        
        var nota = {
            
        }
        //Adiciona as medias na tabela nos seus devidos periodos 
        for (let j = 0; j < tipoPeriodo; j++) {
            const periodo = periodosBuscados[j];
        
            if(element.dataInicial >= periodo.dataInicial && element.dataFinal <= periodo.dataFinal){

            }
        }
    }

    var meuBoletim = document.getElementById('idBoletim').innerHTML;
    var style = "<style>";
    style = style + "tr, th, td{    padding: 15px;}";
    style = style + "tr, th, td{     text-transform: uppercase;}";
    style = style + "tr, th, td{    border-top: 1px solid #999;}";
    style = style + "tr, th, td{    border-bottom: 1px solid #111;}";
    style = style + "tr, th, td{    border-right: 1px solid #999;}";
    style = style + "tr, th, td{    border-left: 1px solid #111;}";
    style = style + "tr, th, td{    text-align: left;}";
    style = style + "tr, th, td{    font-size: 100%;}";
    style = style + "tr, th, td{    font-family: cursive;}";
    style = style + "tr, th, td{    letter-spacing: 0.2em;}";
    style = style + "tr, th, td{    width: 100vh;}";
    style = style + "</style>";

    var win = window.open('', '', 'height=700,width=700');
    win.document.write('<html><head>');
    win.document.write('<title>Boletim</title>');   
    win.document.write(style);                                    
    win.document.write('</head>');
    win.document.write('<body>');
    win.document.write(meuBoletim);                         
    win.document.write('</body></html>');
    win.document.close(); 	                                        
    win.print();                                                           
}