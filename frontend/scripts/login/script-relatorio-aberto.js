var idRelatorio = sessionStorage.getItem("idRelatorio");

var xhr = new XMLHttpRequest(); 

    xhr.open("GET", "http://localhost:8080/relatorios/"+idRelatorio);

    xhr.addEventListener("load", function(){
        var resposta = xhr.responseText; 
        dadosUsuario = JSON.parse(resposta);

        //Adiciona o titulo na pagina 
        document.getElementById("idTitulo").textContent = dadosUsuario.titulo;

        //Adiciona o texto na pagina 
        document.getElementById("idTexto").textContent = dadosUsuario.texto;

        //Adiciona a data na pagina 
        var str = dadosUsuario.dataRelatorio;
        var dataRelatorio = new Date(str);
        document.getElementById("idData").textContent = dataFormatada(dataRelatorio);

        buscarDestinatario();
    })
xhr.send();

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

function buscarDestinatario(){
    var xhr = new XMLHttpRequest(); 

    xhr.open("GET", "http://localhost:8080/usuarios/"+dadosUsuario.destinatario);

    xhr.addEventListener("load", function(){
        var resposta = xhr.responseText; 
        dadosUsuario = JSON.parse(resposta);

        //Adiciona o nome do destinatario na pagina 
        document.getElementById("idDestinatario").textContent = "Destinatário: "+dadosUsuario.nome;
    })
    xhr.send();
}
