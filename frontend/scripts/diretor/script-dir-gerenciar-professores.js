buscarProfessores();
async function buscarProfessores(){
    var professores = await usarApi('GET','http://localhost:8080/api/professores');
    console.log('professores');
    professores = JSON.parse(professores);
    var tb = $('#tbProfessores');
    for(var i = 0; i <professores.length; i++){
        const prof = professores[i];
        console.log(prof);
        tb.append('<tr>'
                    +'<th scope="row">'+prof.idUsuario+'</td>'
                    +'<td>'+prof.nome+' '+prof.sobrenome+'</td>'
                 +'</tr>');
    }
}