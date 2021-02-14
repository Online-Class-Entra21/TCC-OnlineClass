$('#customFile').change(function(){
    var nomeArquivo = $(this).val().substring(12);
    console.log(nomeArquivo);
    $('.custom-file-label').text(nomeArquivo);
});

function pegarMaterias(){
    
}