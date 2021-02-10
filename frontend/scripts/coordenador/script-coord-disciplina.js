//Dados iniciais 
var fk_escola = sessionStorage.getItem('escolaUsuario');
var idUsuario = sessionStorage.getItem('idUsuario');

padraoDefault();

//Config. iniciais 
function padraoDefault(){
    document.getElementById('idBtnCadastrar').hidden = false;
    document.getElementById('idBtnAtualizar').hidden = true;
    document.getElementById('idBtnExcluir').hidden = true;
    document.getElementById('txtNome').disabled = false;
    document.getElementById('divSelect').hidden = true;
}

//Método para os botões radio
function eventoRadio(radioB){
    var opcaoEscolhida = radioB.value;
    if (opcaoEscolhida == 'cadastrar') {
        //Esconde os botões - config. de cadastro
        document.getElementById('idBtnCadastrar').hidden = false;
        document.getElementById('idBtnAtualizar').hidden = true;
        document.getElementById('idBtnExcluir').hidden = true;
        document.getElementById('txtNome').disabled = false;
        document.getElementById('divSelect').hidden = true;
    }else{
        //Esconde os botões - config. atualizacao
        document.getElementById('idBtnCadastrar').hidden = true;
        document.getElementById('idBtnAtualizar').hidden = false;
        document.getElementById('idBtnExcluir').hidden = false;
        document.getElementById('txtNome').disabled = true;
        document.getElementById('divSelect').hidden = false;
    }
}

//Cadastra uma disciplina no banco 
document.getElementById("idBtnCadastrar").addEventListener("click",function(){
    cadastrar();
})

//Cadastro de disciplina 
async function cadastrar(){

    //Cria a classe disciplina 
    var disciplina = {
        nome: document.getElementById("txtNome").value
    }

    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        //Converte para JSON
        var disciplinaJson = JSON.stringify(disciplina);
        console.log(disciplinaJson);

        //Chama a api para cadastrar a turma
        var insertDisciplina = await usarApi("POST", "http://localhost:8080/api/disciplina/inserir/" + disciplinaJson)

        if (!insertDisciplina) {
            alert("Ocorreu um erro ao cadastrar a disciplina!");
        } else {
            alert("Cadastrado com sucesso!");
            document.getElementById('txtNome').value = '';
        }
    }
}

//Método para selecao da disciplina 
$("#SelectDisciplina").change(function() { 
    var disciplinaEscolhida = $('#SelectDisciplina :selected').val();
    var nomeDisciplinaEscolhida = $('#SelectDisciplina :selected').text();
    console.log(disciplinaEscolhida)
});

//Método para carregar o select com as turmas existentes
async function carregarSelect() {
    //Chama a api e retorna um arrays com as disciplinas pertencentes à escola
    var resposta = await usarApi("GET", "http://localhost:8080/api/turmas/escola/"+fk_escola);
    var turmas = JSON.parse(resposta);
    var select = document.getElementById('SelectTurma');

    //Cria os options do select
    for (let index = 0; index < turmas.length; index++) {
        
        var option = document.createElement('option')
        option.textContent = turmas[index].ano;
        option.value = turmas[index].idTurma;
        option.classList.add('optionTurmas')

        select.append(option);
    }
}

//Método para carregar os campos da turma selecionada
async function carregarCampos(turma) {
    //Busca os dados da turma selecionado no checkbox 
    var resposta = await usarApi("GET", "http://localhost:8080/api/turma/" + turma)
    var turma = JSON.parse(resposta)

    //Dados Turma
    document.getElementById('inputNome').value = turma.ano;
    document.getElementById('InputQtdAlunos').value = turma.qtdAluno
}

//Método para carregar a lista de turmas da disciplina selecionada
async function carregarListaTurmas(idTurma, nomeTurma) {
    //Faz a buscar na API
    var resposta = await usarApi("GET", "http://localhost:8080/api/alunos/" + idTurma);
    var alunos = JSON.parse(resposta);

    
    //Verifica se tem algum aluno no banco de dados
    if(alunos[0] == null){
        var tr = document.createElement("tr");
        var coluna = document.createElement("td");
        coluna.append("Nenhum aluno ligado à essa turma.")
        tr.append(coluna)
        document.getElementById('tbLista').append(tr)
    }else{
        var alunosIndex = []
        for (let i = 0; i < alunos.length; i++) {

            resposta = await usarApi("GET", "http://localhost:8080/api/usuario/" + alunos[i].fk_usuario);
            var usuarioNome = JSON.parse(resposta);

            alunosIndex.push(alunos[i]);

            var linha = document.createElement("tr");
            linha.classList.add("LinhaAlunos")
            var colunaNome = document.createElement("td");
            colunaNome.classList.add("colunaNome")
            var nomeAluno = usuarioNome.nome+" "+usuarioNome.sobrenome;
            colunaNome.append(nomeAluno)
            linha.append(colunaNome);
            var colunaMatricula = document.createElement("td");
            colunaMatricula.classList.add("colunaMatricula")
            colunaMatricula.append(alunos[i].matricula)
            linha.append(colunaMatricula);
            var colunaTurma = document.createElement("td");
            colunaTurma.classList.add("colunaTurma")
            colunaTurma.append(nomeTurma)
            linha.append(colunaTurma);

            document.getElementById('tbLista').append(linha)
        }  
    }
}

