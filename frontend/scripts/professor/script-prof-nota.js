// Pegando id do usuário que logou 
var idUsuario = sessionStorage.getItem("idUsuario");

//Verifica se o idUsuario é válido 
if(idUsuario != 0 && idUsuario != null){
    //Busca dos dados do usuário
    var xhr = new XMLHttpRequest(); 

        xhr.open("GET", "http://localhost:8080/api/usuario/"+idUsuario);

        xhr.addEventListener("load", function(){
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
        })

    xhr.send();
    
}else{
    // alert('Sessão expirada - Erro (0002)')
    // window.location = "/frontend/index.html";
}

carregarSelect();


//Método para carregar os selects
async function carregarSelect() {
    var selectDisciplina = document.getElementById('SelectDisciplina');
    var selectTurma = document.getElementById('SelectTurma');
    var selectAluno = document.getElementById('SelectAluno');
    //Carrega o Select das Disciplinas
    var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/disciplinas/" + idUsuario);
    var disciplinas = JSON.parse(resposta);
    for (let index = 0; index < disciplinas.length; index++) {
       var option = document.createElement('option');
       option.textContent = disciplinas[index].nome;
       option.value = disciplinas[index].idDisciplina;

       selectDisciplina.appendChild(option);    
    }
    
    //Carrega o Select das Turmas


}

//Método para carregar a tabela pelo aluno informado
async function carregarTabela() {
    var idAluno = 22;
    var resposta = await usarApi("GET", "http://localhost:8080/api/aluno/notas/" + idAluno);
    var notasAluno = JSON.parse(resposta);

    for (let index = 0; index < notasAluno.length; index++) {

        var linha = document.createElement('tr');
        var colunaAno = document.createElement('td');
        colunaAno.append(notasAluno[index].ano);
        colunaAno.classList.add('tdTabela');
        linha.append(colunaAno);

        var colunaData = document.createElement('td');
        colunaData.append(notasAluno[index].dataEntrefa);
        colunaData.classList.add('tdTabela');
        linha.append(colunaData)

        var colunaTitulo = document.createElement('td');
        colunaTitulo.append(notasAluno[index].titulo);
        colunaTitulo.classList.add('tdTabela');
        linha.append(colunaTitulo);

        var colunaNota = document.createElement('td');
        colunaNota.append(notasAluno[index].nota);
        colunaNota.classList.add('tdTabela');
        linha.append(colunaNota);

        document.getElementById('tabelaAlunos').appendChild(linha);
        
    }
}