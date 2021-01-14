    
    /*************************
    Script - Tela-Principal Diretor 
    **************************/

//const { result } = require("lodash");

    //Abre o menu de opções da tela diretor 
    function abrirMenu(){
        $("#menuOpcoes").css("display","block");
        $("#tituloPrincipal").css("margin-left",280);
    }

    //Fecha o menu de opções da tela diretor 
    function fecharMenu(){
        if((!$("#opcao-01").is(':hover'))&&(!$("#opcao-02").is(':hover'))&&
        (!$("#opcao-03").is(':hover'))&&(!$("#opcao-04").is(':hover'))&&
        (!$('#menuOpcoes').is(':hover')))
        {
            $("#menuOpcoes").css("display","none");
            $("#tituloPrincipal").css("margin-left",180);
        }
    }

    //Entrar na opção 1 do menu 
    function entrarOpcao1(){
        if(location != "http://127.0.0.1:5500/frontend/paginas/diretor/tela-principal.html"){
            location.href = "../diretor/menu-principal.html"; 
        }else{
            $("#menuOpcoes").css("display","none");
            $("#tituloPrincipal").css("margin-left",180);
        }
    }

    //Entrar na opção 2 do menu 
    function entrarOpcao2(){
        location.href = "../diretor/perfil.html"; 
    }

    //Entrar na opção 3 do menu 
    function entrarOpcao3(){
        location.href = "../diretor/escola.html"; 
    }

    //Entrar na opção 4 do menu 
    function entrarOpcao4(){
        location.href = "../diretor/relatorios.html"; 
    }

    //Entrar na opção 5 do menu 
    function entrarOpcao5(){
        location.href = "../diretor/profissionais.html"; 
    }

    //Entrar na opção 6 do menu 
    function entrarOpcao6(){
        location.href = "../diretor/reunioes.html"; 
    }

    //Entrar na opção 7 do menu 
    function entrarOpcao7(){
        location.href = "../diretor/estatisticas.html"; 
    }

    //Volta para a tela de login
    function sair(){
        location.href = "../login/login.html";  
    }

    

    // fetch(`http://localhost:8080/api/usuario/1`, options)
    // .then(response =>{ response.json()
    //     .then(data => showData(data))
    // })
    // .catch(e => console.log('Deu erro ' + e,menssage))

    //const showData = (result)=>{
    //    for(const campo in result){
    //        console.log(result)
    //        $("#tituloPrincipal").html(result[campo]);
    //    }
    //}