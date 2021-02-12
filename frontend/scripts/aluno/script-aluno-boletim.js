//Evento para gerar boletim 
document.getElementById("gerar-boletim").addEventListener("click", function(){
    gerarBoletim();
})

function gerarBoletim() {
    var meuBoletim = document.getElementById('idBoletim').innerHTML;
    var style = "<style>";
    style = style + "table#t {width: 100%;font: 20px Calibri;}";
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