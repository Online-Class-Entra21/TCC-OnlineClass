//Dados iniciais 
var fk_escola = sessionStorage.getItem('escolaUsuario');
var idUsuario = sessionStorage.getItem('idUsuario');
var disciplinaEscolhida;

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
            var resposta = xhr.responseText; 
            dadosUsuario = JSON.parse(resposta);
            var resposta = xhr.responseText; 
            var dadosUsuario = JSON.parse(resposta);
            //Adiciona o nome 
            document.getElementById("idNomeUsuario").textContent = dadosUsuario.nome +" "+dadosUsuario.sobrenome;
            //Adiciona a foto de perfil do usuario
            var img = document.querySelector("#idFotoPerfil");
            if(dadosUsuario.fotoUsuario != null){
                img.setAttribute('src', "/imagens-usuarios/"+dadosUsuario.fotoUsuario);
                img.style.borderRadius = "80%";
            }
            userEmail = dadosUsuario.email;
        })

    xhr.send();
    
}else{
    alert('Sessão expirada - Erro (0002)')
    window.location = "/frontend/index.html";
}

carregarSelect();
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
        $("#carregamento").empty();
        document.getElementById('idBtnCadastrar').hidden = false;
        document.getElementById('idBtnAtualizar').hidden = true;
        document.getElementById('idBtnExcluir').hidden = true;
        document.getElementById('txtNome').disabled = false;
        document.getElementById('txtNome').value = "";
        document.getElementById('divSelect').hidden = true;
    }else{
        //Esconde os botões - config. atualizacao
        document.getElementById('idBtnCadastrar').hidden = true;
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
        nome: document.getElementById("txtNome").value,
        fk_escola: fk_escola
    }

    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{
        //Converte para JSON
        var disciplinaJson = JSON.stringify(disciplina);

        //Chama a api para cadastrar a disciplina
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
    disciplinaEscolhida = $('#SelectDisciplina :selected').val();

    if(disciplinaEscolhida != 'default'){
        document.getElementById('txtNome').disabled = false;
        $("#carregamento").empty();
        document.getElementById('idBtnAtualizar').hidden = false;
        document.getElementById('idBtnExcluir').hidden = false;
        carregarListaDisciplinas(disciplinaEscolhida);
        carregarCampos(disciplinaEscolhida);
    }
});

//Método para carregar o select com as turmas existentes
async function carregarSelect() {
    //Chama a api e retorna um arrays com as disciplinas pertencentes à escola
    var resposta = await usarApi("GET", "http://localhost:8080/api/disciplinas/"+fk_escola);
    var disciplinas = JSON.parse(resposta);
    var select = document.getElementById('SelectDisciplina');

    //Cria os options do select
    for (let index = 0; index < disciplinas.length; index++) {
        
        var option = document.createElement('option');
        option.textContent = disciplinas[index].nome;
        option.value = disciplinas[index].idDisciplina;
        option.classList.add('optionDisciplinas')

        select.append(option);
    }
}

//Método para carregar os campos da disciplina selecionada
async function carregarCampos(disciplina) {
    //Busca os dados da disciplina selecionado no checkbox 
    var resposta = await usarApi("GET", "http://localhost:8080/api/disciplina/" + disciplina)
    var disciplina = JSON.parse(resposta)

    //Dados Disciplina
    document.getElementById('txtNome').value = disciplina.nome;
}

//Método para carregar a lista de turmas da disciplina selecionada
async function carregarListaDisciplinas(disciplinaEscolhida) {
    //Faz a buscar na API
    var resposta = await usarApi("GET", "http://localhost:8080/api/turmas/disciplina/" + disciplinaEscolhida);
    var turmas = JSON.parse(resposta);

    //Verifica se tem alguma turma no banco de dados
    if(turmas[0] == null){
        var tr = document.createElement("tr");
        var coluna = document.createElement("td");
        coluna.append("Nenhuma turma ligado à essa disciplina.")
        tr.append(coluna)
        document.getElementById('carregamento').append(tr)
    }else{

        for (let i = 0; i < turmas.length; i++) {

            //Cria a linha 
            var linha = document.createElement("tr");
            linha.classList.add("LinhaTurmas")

            //Cria a coluna de nome 
            var colunaNome = document.createElement("td");
            colunaNome.classList.add("colunaNome")
            var nomeTurma = turmas[i].ano;
            colunaNome.append(nomeTurma);
            linha.append(colunaNome);

            //Cria a coluna de n° de alunos 
            var colunaNumAlunos = document.createElement("td");
            colunaNumAlunos.classList.add("colunaNumAlunos")
            var numAlunos = turmas[i].qtdAluno;
            colunaNumAlunos.append(numAlunos);
            linha.append(colunaNumAlunos);

            //Cria a coluna de inicio da aula
            var inicioAula = document.createElement("td");
            inicioAula.classList.add("inicioAula")
            var horaFinal = new Date(turmas[i].horarioInicioAula);
            var inicio = timeFormat(horaFinal);
            inicioAula.append(inicio);
            linha.append(inicioAula);

            //Cria a coluna de fim da aula
            var finalAula = document.createElement("td");
            finalAula.classList.add("finalAula")
            var horaInicio = new Date(turmas[i].horarioFinalAula);
            var final = timeFormat(horaInicio);
            finalAula.append(final);
            linha.append(finalAula);

            document.getElementById('carregamento').append(linha)
        }  
    }
}

//Evento de atualizar 
document.getElementById("idBtnAtualizar").addEventListener("click",function (){
    if(disciplinaEscolhida != undefined){
        atualizar(disciplinaEscolhida)
    }else{
        alert("Selecione uma disciplina para atualizar");
    }
})

//Atualiza a disciplina 
async function atualizar(disciplinaEscolhida){

    //Verifica se os campos foram preenchidos 
    var form = $('#formulario');
    if(!form[0].checkValidity()) {
        $('<input type="submit">').hide().appendTo(form).click().remove();
    }else{

        //Cria a classe disciplina 
        var disciplina = {
            idDisciplina: disciplinaEscolhida,
            nome: document.getElementById("txtNome").value,
            fk_escola: fk_escola
        }

        //Converte para JSON
        var disciplinaJson = JSON.stringify(disciplina);

        //Chama a api para editar a disciplina
        var insertDisciplina = await usarApi("PUT", "http://localhost:8080/api/disciplina/alterar/" + disciplinaJson)

        if (!insertDisciplina) {
            alert("Ocorreu um erro ao editar a disciplina!");
        } else {
            alert("Editado com sucesso!");
        }
    }
}

//Evento de deletar 
document.getElementById("idBtnExcluir").addEventListener("click",function (){
    if(disciplinaEscolhida != undefined){
        deletar(disciplinaEscolhida)
    }else{
        alert("Selecione uma disciplina para apagar");
    }
})

//Deleta a disciplina
async function deletar(disciplinaEscolhida){
    //Deletar a disciplina deletar 
    var isDeletado = await usarApi("DELETE", "http://localhost:8080/api/disciplina/deletar/" + disciplinaEscolhida)

    //situacao mensagem 
    if(isDeletado){
        $("#carregamento").empty();
        document.getElementById('idBtnCadastrar').hidden = true;
        document.getElementById('idBtnAtualizar').hidden = false;
        document.getElementById('idBtnExcluir').hidden = false;
        document.getElementById('txtNome').disabled = true;
        document.getElementById('divSelect').hidden = false;
        document.getElementById('txtNome').value = "";
        $("#SelectDisciplina").val("default");
        carregarSelect();
        alert("Excluído com sucesso!");
    }else{
        alert("Erro ao excluír!");
    }
}
