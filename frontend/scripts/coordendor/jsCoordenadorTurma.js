
var tb, index;
function cadTurma(turma, turno, numAlunos){

    tb = document.getElementById("tbPessoas");
    var qtdLinhas = tb.rows.length;
    var linha = tb.insertRow(qtdLinhas);

    var cellCodigo = linha.insertCell(0);
    var cellTurma = linha.insertCell(1);
    var cellTurno = linha.insertCell(2);
    var cellNumAlunos = linha.insertCell(3);

    cellCodigo.innerHTML = qtdLinhas;
    cellTurma.innerHTML = turma;
    cellTurno.innerHTML= turno;
    cellNumAlunos.innerHTML = numAlunos;

    preencheCamposForm();
    
}
function altTurma (turma, turno, numAlunos){
    
    tb.rows[index].cells[1].innerHTML= turma;
    tb.rows[index].cells[2].innerHTML= turno;
    tb.rows[index].cells[3].innerHTML= numAlunos;

}

function preencheCamposForm() {

    for(var i = 0; i < tb.rows.length; i++) 
    {
        tb.rows[i].onclick = function() 
        {
            index = this.rowIndex;
            document.getElementById("txtCodigo").value = tb.rows[index].cells[0].innerText;
            document.getElementById("txtTurma").value = tb.rows[index].cells[1].innerText;
            document.getElementById("txtTurno").value = tb.rows[index].cells[2].innerText;
            document.getElementById("txtNumAlunos").value = tb.rows[index].cells[3].innerText;

        }
    }
}