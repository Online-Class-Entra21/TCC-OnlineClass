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
//Evento de Alteração
function altPessoa(turma, turno, numAlu) {


    cadturmas.rows[index].cells[1].innerHTML = turma;
    cadturmas.rows[index].cells[2].innerHTML = turno;
    cadturmas.rows[index].cells[3].innerHTML = numAlu;
   

}
//Evento de preenchimento
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

//Evento de delete
function delRegistro() {

    for(var i = 0; i < cadturmas.rows.length; i++) 
    {
        if (index == i) {
            cadturmas.deleteRow(index);
           
            return;
        }
    }
}


//Método para o cadastro de uma turma
async function cadastrar() {
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        //Coleta os dados do input
        var turma = document.getElementById('inputNome').value;
        var horaInicioAula = document.getElementById('inputHorarioInicial').valueAsDate;
        var horaFinalAula = document.getElementById('inputHorarioFinal').valueAsDate;
        
        var inserirTurma = {
            ano: turma,
            horainicioaula: horaInicioAula,
            horafinalaula: horafinalaula,
            qtdaluno: null,
            fk_sala: null
        }

        //Converte para JSON
        var turmaJson = JSON.stringify(inserirTurma);

        //Chama a api para cadastrar a turma
        var insertTurma = await usarApi("POST", "http://localhost:8080/api/turma/inserir/" + turmaJson);

        if (insertTurma == false) {
            alert("Ocorreu um erro ao cadastrar a turma.")
        } else {
            alert("Turma cadastrada com sucesso.")
        }
    }
}

//Método para atualizar a turma
async function atualizar() {
    
    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        //Edita os Campos da escola
        var alterarTurma = {
            ano: document.getElementById('inputNome').value,
            horainicioaula: document.getElementById('inputHorarioInicial').valueAsDate,
            horafinalaula: document.getElementById('inputHorarioFinal').valueAsDate,
            qtdaluno: document.getElementById('inputQtdAluno').value,
            fk_sala: document.getElementById('inputFk_Escola').value
        }
        var turmaJson = JSON.stringify(alterarTurma);
        var updateEscola = await usarApi("PUT", "http://localhost:8080/api/turma/alterar/"+codigoEscola+"/"+turmaJson);
        var resposta = JSON.parse(updateEscola)
                    
        if (!resposta) {
            alert("Erro ao salvar edição!");
        }else{
            editarDiretor();
        }
    }

            
}

//Método para carregar os campos da turma selecionada
async function carregarCampos() {
    //Busca os dados da turma selecionado no checkbox 
    var resposta = await usarApi("GET", "http://localhost:8080/api/turma/" + idUsuario)
    var turma = JSON.parse(resposta)

    //Dados Turma
    document.getElementById('inputAno').value = turma.ano;
    document.getElementById('InputQtdAlunos').value = turma.qtdaluno
    document.getElementById('inputHoraInicio').value = turma.horainicioaula;
    document.getElementById('inputHoraFinal').value = turma.horafinalaula;
    
    carregarListaAlunos();
    
}
//Método para carregar a lista de alunos da turma selecionada
async function carregarListaAlunos() {
    //Faz a buscar na API
    var resposta = await usarApi("GET", "http://localhost:8080/api/alunos/" + 3);
    var alunos = JSON.parse(resposta);

    //Verifica se tem alguma escola no banco de dados
    if(alunos[0] == null){
        var tr = document.createElement("tr");
        var coluna = document.createElement("td");
        coluna.append("Nenhum aluno ligado à essa turma.")
        tr.append(coluna)
        document.getElementById('tbLista').append(tr)
    }else{
        var alunosIndex = []
        for (let i = 0; i < alunos.length; i++) {

            alunosIndex.push(alunos[i]);

            var linha = document.createElement("tr");
            linha.classList.add("LinhaAlunos")
            var colunaCod = document.createElement("td");
            colunaCod.classList.add("colunaCodigo");
            colunaCod.append(alunos[i].idaluno);
            linha.append(colunaCod)
            var colunaNome = document.createElement("td");
            colunaNome.classList.add("colunaNome")
            colunaNome.append(alunos[i].nome)
            linha.append(colunaNome);
            var colunaMatricula = document.createElement("td");
            colunaMatricula.classList.add("colunaMatricula")
            colunaMatricula.append(alunos[i].matricula)
            linha.append(colunaMatricula);
            var colunaTurma = document.createElement("td");
            colunaTurma.classList.add("colunaTurma")
           // colunaTurma.append(turma.ano)
           // linha.append(colunaTurma);

            document.getElementById('tbLista').append(linha)
        }  
    }
}

