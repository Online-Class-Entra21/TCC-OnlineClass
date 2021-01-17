function usuarioDados(value){

    var idUsuario = value;

    //Metodo de retorno do idUsuario
    this.getIdUsuario = function(){
        return idUsuario;
    }

    //Metodo de insercao do idUsuario
    this.setIdUsuario = function(value){
        this.idUsuario = value;
    }
}