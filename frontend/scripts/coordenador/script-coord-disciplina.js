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


//Evento de Cadastro
var cadsalas, index;

function cadSalas(nome, tipo, data, dono) {
    cadsalas = document.getElementById("tbPessoas");    
    var qtdlLinhas = cadsalas.rows.length;
    var linha = cadsalas.insertRow(qtdlLinhas);
    var linhaParam;

    var cellCodigo = linha.insertCell(0);
    var cellNome = linha.insertCell(1);
    var cellTipo = linha.insertCell(2);
    var cellData = linha.insertCell(3);
    var cellDono = linha.insertCell(4);

    cellCodigo.innerHTML = qtdlLinhas;
    cellNome.innerHTML = nome;
    cellTipo.innerHTML = tipo;
    cellData.innerHTML = data;
    cellDono.innerHTML = dono;
    preencheCamposForm();
    

}
//Evento de Alteração
function altPessoa(nome, tipo, data, dono) {


    cadsalas.rows[index].cells[1].innerHTML = nome;
    cadsalas.rows[index].cells[2].innerHTML = tipo;
    cadsalas.rows[index].cells[3].innerHTML = data;
    cadsalas.rows[index].cells[4].innerHTML = dono;
   

}
//Evento de preenchimento
function preencheCamposForm() {

    for(var i = 0; i < cadsalas.rows.length; i++) 
    {

       cadsalas.rows[i].onclick = function() 
        {
            index = this.rowIndex;
            document.getElementById("txtCodigo").value = cadsalas.rows[index].cells[0].innerText;
            document.getElementById("txtNome").value = cadsalas.rows[index].cells[1].innerText;
            document.getElementById("txtTipo").value = cadsalas.rows[index].cells[2].innerText;
            document.getElementById("txtData").value = cadsalas.rows[index].cells[3].innerText;
            document.getElementById("txtDono").value = cadsalas.rows[index].cells[4].innerText;

        }
    }
}

//Evento de delete
function delRegistro() {

    for(var i = 0; i < cadsalas.rows.length; i++) 
    {
        if (index == i) {
            cadsalas.deleteRow(index);
           
            return;
        }
    }
}
