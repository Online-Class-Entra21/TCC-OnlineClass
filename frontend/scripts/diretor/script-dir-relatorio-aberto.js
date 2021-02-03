var idRelatorio = sessionStorage.getItem("idRelatorio");

var xhr = new XMLHttpRequest(); 

    xhr.open("GET", "http://localhost:8080/api/relatorio/"+idRelatorio);

    xhr.addEventListener("load", function(){
        var resposta = xhr.responseText; 
        dadosUsuario = JSON.parse(resposta);

        //Adiciona o titulo na pagina 
        document.getElementById("idTitulo").textContent = dadosUsuario.titulo;

        //Adiciona o texto na pagina 
        document.getElementById("idTexto").textContent = dadosUsuario.texto;

        //Adiciona a data na pagina 
        document.getElementById("idData").textContent = dadosUsuario.dataRelatorio;

        buscarDestinatario();
    })
xhr.send();

function buscarDestinatario(){
    var xhr = new XMLHttpRequest(); 

    xhr.open("GET", "http://localhost:8080/api/usuario/"+dadosUsuario.destinatario);

    xhr.addEventListener("load", function(){
        var resposta = xhr.responseText; 
        dadosUsuario = JSON.parse(resposta);

        //Adiciona o nome do destinatario na pagina 
        document.getElementById("idDestinatario").textContent = "Destinatário: "+dadosUsuario.nome;
    })
    xhr.send();
}
