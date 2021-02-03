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

//Evento post It
var ul = document.getElementById("myList");
var li;
var itemId;
var item;
addTask	= function (){
    
    if(document.getElementById("task").value != ""){

        item   = document.getElementById("task");

        itemId = ul.childElementCount;

        li 	   = createItemEl(item.value,itemId);
        li.appendChild(createRemoveTaskBtn(itemId));
        ul.appendChild(li);
        item.value = "";
    }

}

removeTask = function( itemId ){

    for( i = 0 ; i < ul.children.length ; i++){

        if(ul.children[i].getAttribute("index") == itemId ){

            ul.children[i].remove();

        }
    }
}

createItemEl = function(itemValue, itemId){

    let li = document.createElement("li");

    li.setAttribute("index", itemId);

    li.appendChild(document.createTextNode(itemValue));

    return li;
}

createRemoveTaskBtn = function(itemId){
    let btn =  document.createElement("button");
    btn.setAttribute("onclick", "removeTask("+itemId+")"); 
    btn.innerHTML ="X";
    return btn;
}

