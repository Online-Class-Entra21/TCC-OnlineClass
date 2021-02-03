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
var cadalunos, index;

function cadAlunos(nomAlu, matricula, turma) {
    cadalunos = document.getElementById("tbPessoas");    
    var qtdlLinhas = cadalunos.rows.length;
    var linha = cadalunos.insertRow(qtdlLinhas);
    var linhaParam;

    var cellCodigo = linha.insertCell(0);
    var cellTurma = linha.insertCell(1);
    var cellMatricula = linha.insertCell(2);
    var cellNomAlu = linha.insertCell(3);

    cellCodigo.innerHTML = qtdlLinhas;
    cellNomAlu.innerHTML = nomAlu;
    cellMatricula.innerHTML = matricula;
    cellTurma.innerHTML = turma;
    preencheCamposForm();
    

}
//Evento de Alteração
function altPessoa(nomAlu, matricula, turno) {


    cadalunos.rows[index].cells[1].innerHTML = nomAlu ;
    cadalunos.rows[index].cells[2].innerHTML = matricula;
    cadalunos.rows[index].cells[3].innerHTML = turno;
   

}
//Evento de preenchimento
function preencheCamposForm() {

    for(var i = 0; i < cadalunos.rows.length; i++) 
    {

       cadalunos.rows[i].onclick = function() 
        {
            index = this.rowIndex;
            document.getElementById("txtCodigo").value = cadalunos.rows[index].cells[0].innerText;
            document.getElementById("txtNomAlu").value = cadalunos.rows[index].cells[1].innerText;
            document.getElementById("txtMatricula").value = cadalunos.rows[index].cells[2].innerText;
            document.getElementById("txtTurno").value = cadalunos.rows[index].cells[3].innerText;

        }
    }
}


//Evento de delete
function delRegistro() {

    for(var i = 0; i < cadalunos.rows.length; i++) 
    {
        if (index == i) {
            cadalunos.deleteRow(index);
           
            return;
        }
    }
}
