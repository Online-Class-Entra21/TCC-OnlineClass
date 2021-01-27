var altura = document.getElementById('divMain').clientHeight;
document.getElementById("registro-escola-diretor").style.height.value = altura+"px";

var numLinhas = 0;

document.getElementById('btnCadastro').disabled = true;

function criar(){
    numLinhas++;
    var linha = document.createElement("tr");
    var coluna = document.createElement("td");

    var input = $("#idNomeEscola")[0].value;
    console.log(input);
    
    coluna.append(
        input
    )
    linha.append(coluna)
    linha.id = "linha"+numLinhas

    document.getElementById('btnCadastro').disabled = false;
    // document.getElementById('btnCriar').disabled = true;

    document.getElementById('andre').append(linha)

}


function cadastrar(){
    var coluna = document.createElement("td")
    var input = $("#idNomeDiretor")[0].value;
    coluna.append(input)

    document.getElementById('btnCadastro').disabled = true;
    document.getElementById('btnCriar').disabled = false;
    document.getElementById('linha'+numLinhas).append(coluna)               
}