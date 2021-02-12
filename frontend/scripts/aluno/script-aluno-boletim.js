//Evento para gerar boletim 
//Evento para gerar boletim 
document.getElementById("gerar-boletim").addEventListener("click", function(){
    gerarBoletim();
})


function gerarBoletim() {
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