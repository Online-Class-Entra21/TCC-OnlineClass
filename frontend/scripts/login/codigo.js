function salvarCodigo(value){

    var codigo = value;

    //Metodo de retorno do idUsuario
    this.getCodigo = function(){
        return codigo;
    }

    //Metodo de insercao do idUsuario
    this.setCodigo = function(value){
        this.codigo = value;
    }
}