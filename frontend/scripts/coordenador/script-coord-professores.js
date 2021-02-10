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
var cadprof, index;

function cadProf(nomProf, disciplina, nturmas) {
    cadprof = document.getElementById("tbPessoas");    
    var qtdlLinhas = cadprof.rows.length;
    var linha = cadprof.insertRow(qtdlLinhas);
    var linhaParam;

    var cellCodigo = linha.insertCell(0);
    var cellNomProf = linha.insertCell(1);
    var cellDisciplina = linha.insertCell(2);
    var cellNturmas = linha.insertCell(3);

    cellCodigo.innerHTML = qtdlLinhas;
    cellNomProf.innerHTML = nomProf;
    cellDisciplina.innerHTML = disciplina;
    cellNturmas.innerHTML = nturmas;
    preencheCamposForm();
    

}
//Evento de Alteração
function altPessoa(nomProf, disciplina, nturmas) {


    cadprof.rows[index].cells[1].innerHTML = nomProf ;
    cadprof.rows[index].cells[2].innerHTML = disciplina;
    cadprof.rows[index].cells[3].innerHTML = nturmas;
   

}
//Evento de preenchimento
function preencheCamposForm() {

    for(var i = 0; i < cadprof.rows.length; i++) 
    {

       cadprof.rows[i].onclick = function() 
        {
            index = this.rowIndex;
            document.getElementById("txtCodigo").value = cadprof.rows[index].cells[0].innerText;
            document.getElementById("txtNomProf").value = cadprof.rows[index].cells[1].innerText;
            document.getElementById("txtDiciplina").value = cadprof.rows[index].cells[2].innerText;
            document.getElementById("txtTurmas").value = cadprof.rows[index].cells[3].innerText;

        }
    }
}


//Evento de delete
function delRegistro() {

    for(var i = 0; i < cadprof.rows.length; i++) 
    {
        if (index == i) {
            cadprof.deleteRow(index);
           
            return;
        }
    }
}
