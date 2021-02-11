var idUsuario = sessionStorage.getItem('idUsuario');
var idEscola = sessionStorage.getItem('escolaUsuario');
carregarCampos();

//Método para carregar os campos
async function carregarCampos() {
    //Chama a api para carregar o usuario e escola do banco
    var resposta = await usarApi("GET", "http://localhost:8080/api/usuario/" + idUsuario);
    var professor = JSON.parse(resposta);
    resposta = await usarApi("GET", "http://localhost:8080/api/escola/" + idEscola);
    var escola = JSON.parse(resposta);

    document.getElementById('inputEscola').value = escola.nome;

    //Converte as datas para só pegar o horário
    var horarioInicioExpediente = new Date(professor.horarioInicioExpediente);
    var horas = horarioInicioExpediente.getHours();
    var minutos = horarioInicioExpediente.getMinutes();
    if (horas < 10 && minutos < 10) {
        horas = "0"+horas;
        minutos = "0"+minutos;
    } else if (horas < 10 && minutos >= 10) {
        horas = "0"+horas;
    } else if (horas >= 10 && minutos < 10) {
        minutos = "0"+minutos;
    }
    horarioInicioExpediente = horas+":"+minutos+":00";
    
    var horarioFinalExpediente = new Date(professor.horarioFinalExpediente);
    horas = horarioFinalExpediente.getHours();
    minutos = horarioFinalExpediente.getMinutes();
    if (horas < 10 && minutos < 10) {
        horas = "0"+horas;
        minutos = "0"+minutos;
    } else if (horas < 10 && minutos >= 10) {
        horas = "0"+horas;
    } else if (horas >= 10 && minutos < 10) {
        minutos = "0"+minutos;
    }
    horarioFinalExpediente = horas+":"+minutos+":00";
    document.getElementById('inputHorarioInicial').value = horarioInicioExpediente;
    document.getElementById('inputHorarioFinal').value = horarioFinalExpediente;
    document.getElementById('inputNome').value = professor.nome;
    document.getElementById('inputSobrenome').value = professor.sobrenome;
    document.getElementById('inputEmail').value = professor.email;
    document.getElementById()

   
}