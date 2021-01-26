var cadturmas, index;

function cadTurma(turma, turno, numAlu) {
    cadturmas = document.getElementById("tbPessoas");    
    var qtdlLinhas = cadturmas.rows.length;
    var linha = cadturmas.insertRow(qtdlLinhas);
    var linhaParam;

    var cellCodigo = linha.insertCell(0);
    var cellTurma = linha.insertCell(1);
    var cellTurno = linha.insertCell(2);
    var cellNumAlu = linha.insertCell(3);

    cellCodigo.innerHTML = qtdlLinhas;
    cellTurma.innerHTML = turma;
    cellTurno.innerHTML = turno;
    cellNumAlu.innerHTML = numAlu;

    preencheCamposForm();

}

function altPessoa(turma, turno, numAlu) {


    cadturmas.rows[index].cells[1].innerHTML = turma;
    cadturmas.rows[index].cells[2].innerHTML = turno;
    cadturmas.rows[index].cells[3].innerHTML = numAlu;
    preencheCamposForm();

}

function preencheCamposForm() {

    for(var i = 0; i < cadturmas.rows.length; i++) 
    {

       cadturmas.rows[i].onclick = function() 
        {
            index = this.rowIndex;
            document.getElementById("txtCodigo").value = cadturmas.rows[index].cells[0].innerText;
            document.getElementById("txtTurma").value = cadturmas.rows[index].cells[1].innerText;
            document.getElementById("txtTurno").value = cadturmas.rows[index].cells[2].innerText;
            document.getElementById("txtNumAlu").value = cadturmas.rows[index].cells[3].innerText;

        }
    }
}

function delRegistro() {

    for(var i = 0; i < cadturmas.rows.length; i++) 
    {
        if (index == i) {
            cadturmas.deleteRow(index);
           
            return;
        }
    }
   onclick =preencheCamposForm();
}
