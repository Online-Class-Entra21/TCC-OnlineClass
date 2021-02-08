
/**
 * Funcoes do menu padrao das paginas 
 */

//Evento de abertura do menu 
document.getElementById("mostrar").addEventListener("mouseover", function(){
    abrirMenu();
})
document.getElementById("idImgMenu").addEventListener("mouseover", function(){
    abrirMenu();
})
//Abertura do menu
function abrirMenu(){
    document.getElementById("menu").style.display = "block";
}
//Evento de fechamento do menu 
document.getElementById("menu").addEventListener("mouseleave", function(){
    document.getElementById("menu").style.display = "none";
})

/**
 * Chmada de API no formato async 
 */

//Método para chamada da API async
function usarApi(method, url) {
    return new Promise(function (resolve, reject) {
        let xhr = new XMLHttpRequest();
        xhr.open(method, url);
        xhr.onload = function () {
            if (this.status >= 200 && this.status < 300) {
                resolve(xhr.response);
            } else {
                reject({
                    status: this.status,
                    statusText: xhr.statusText
                });
            }
        };
        xhr.onerror = function () {
            reject({
                status: this.status,
                statusText: xhr.statusText
            });
        };
        xhr.send();
    });
}

//Adiciona imagem no arquivo raiz 
function UploadFile(file,url){
    var size = file[0].size;
    console.log(size)
    if(size < 1048576) { //1MB
      
    } else {           
      alert('Arquivo não enviado maior que 1 MB'); //Acima do limite
      return;
    }
    
    var files = file[0];
    var xhr = new XMLHttpRequest();
    var fd = new FormData();

    fd.append( "foto", files, files.name);
    xhr.open("POST", url, true);
    xhr.send(fd);
}

/**
 * Formatacao de datas 
 */

//Formata a data para exibição para (AAAA-MM-DD)
function dataFormatada1(data){
    dia      = data.getDate().toString(),
    diaF     = (dia.length == 1) ? '0'+dia : dia,
    mes      = (data.getMonth()+1).toString(), //+1 pois no getMonth Janeiro começa com zero.
    mesF     = (mes.length == 1) ? '0'+mes : mes,
    anoF     = data.getFullYear();
    return anoF+"-"+mesF+"-"+diaF;
}

//Formata a data para exibição para (DD/MM/AAAA)
function dataFormatada2(data){
    dia      = data.getDate().toString(),
    diaF     = (dia.length == 1) ? '0'+dia : dia,
    mes      = (data.getMonth()+1).toString(), //+1 pois no getMonth Janeiro começa com zero.
    mesF     = (mes.length == 1) ? '0'+mes : mes,
    anoF     = data.getFullYear();
    return diaF+"/"+mesF+"/"+anoF;
}

//Formata a data para exibição para (AAAA-MM-DD hh:mm:ss-03)
function timeStampFormat(data){
    dia  = data.getDate().toString();
    diaF = (dia.length == 1) ? '0'+dia : dia;
    mes  = (data.getMonth()+1).toString(); //+1 pois no getMonth Janeiro começa com zero.
    mesF = (mes.length == 1) ? '0'+mes : mes;
    anoF = data.getFullYear();
    hora = data.getHours();
    min  = data.getMinutes();
    sec  = data.getSeconds();
    return anoF+"-"+mesF+"-"+diaF+" "+hora+":"+min+":"+sec;
}

//Verifica se o cpf é válido
function TestaCPF(strCPF) {

    var Soma;
    var Resto;
    Soma = 0;

    if (strCPF == "00000000000" || strCPF == "11111111111" || strCPF == "22222222222" || strCPF == "33333333333"
        || strCPF == "44444444444" || strCPF == "55555555555" || strCPF == "66666666666" || strCPF == "77777777777"
        || strCPF == "88888888888" || strCPF == "99999999999"){
        return false;
    } 
    
    for (i=1; i<=9; i++){
        Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (11 - i);
    } 
    Resto = (Soma * 10) % 11;
    
    if ((Resto == 10) || (Resto == 11)){
        Resto = 0;
    } 
    
    if (Resto != parseInt(strCPF.substring(9, 10))){
        return false;
    } 
    Soma = 0;

    for (i = 1; i <= 10; i++){
        Soma = Soma + parseInt(strCPF.substring(i-1, i)) * (12 - i);
    } 
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)){
        Resto = 0;
    } 

    if (Resto != parseInt(strCPF.substring(10, 11)))
    {
        return false;
    } 
    return true;
}