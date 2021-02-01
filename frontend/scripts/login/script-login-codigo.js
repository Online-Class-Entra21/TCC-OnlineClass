//Classe para salvar o codigo de verificacao temporariamente 
function salvarCodigo(cod, eml){

    var codigo = cod;
    var email = eml;

    //Metodo de retorno do codigo
    this.getCodigo = function(){
        return codigo;
    }

    //Metodo de insercao do codigo
    this.setCodigo = function(value){
        codigo = value;
    }

    //Metodo de retorno do email
    this.getEmail = function(){
        return email;
    }

    //Metodo de insercao do email
    this.setEmail = function(value){
        email = value;
    }
}