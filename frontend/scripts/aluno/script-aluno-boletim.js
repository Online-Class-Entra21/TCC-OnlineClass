//Evento para gerar boletim 
document.getElementById("gerar-boletim").addEventListener("click", function(){
    criaPDF();
})

function criaPDF() {
    var meuBoletim = document.getElementById('idBoletim').innerHTML;
    var style = "<style>";
    style = style + "table#t {width: 100%;font: 20px Calibri;}";
    style = style + "#t {border: solid 1px #DDD; border-collapse: collapse;";
    style = style + "padding: 2px 3px;text-align: center;}";
    style = style + "table#i {witdh: 100%}; font-size:20px; margin:5%; padding: 2px 3px;";
    style = style + "#i {border: 2px solid gray; border-collapse: collapse; text-align: center;}";
    style = style + "</style>";
    // CRIA UM OBJETO WINDOW
    var win = window.open('', '', 'height=700,width=700');
    win.document.write('<html><head>');
    win.document.write('<title>Boletim</title>');   //<title> CABEÇALHO DO PDF.
    win.document.write(style);            //INCLUI UM ESTILO NA TAB HEAD
    win.document.write('</head>');
    win.document.write('<body>');
    win.document.write(meuBoletim);         //O CONTEUDO DA TABELA DENTRO DA TAG BODY
    win.document.write('</body></html>');
    win.document.close(); 	                 //FECHA A JANELA
    win.print();                     //IMPRIME O CONTEUDO
}