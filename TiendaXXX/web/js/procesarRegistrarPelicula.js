/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ajax(url, datos, rta) {
    var ajax = $.post(url, datos, function(respuesta) {
        $(rta).html(respuesta);
    });
    return ajax;
}
function guardar(){
    var formatoE=document.getElementById("formato").value;
    var precioE=document.getElementById("precio").value;
    var deterioradaE=$('input:checkbox[name=dete]:checked').val();
    if(deterioradaE=='on'){
        deterioradaE="true";
    }else{
        deterioradaE="false";
    }
    $.ajax({
        type: "POST",
        url: "procesarIndex",
        data: {
            "proceso":"guardarCopia",
            "formato": formatoE,
            "deteriorada": deterioradaE,
            "precio": precioE
        },
        cache: false,
        success: function (data) {

            $("#resultado").empty();
            $("#resultado").append(data);

        }
    });
    /*$.post("procesarIndex",{proceso:'guardarCopia', formato:formatoE, precio:precioE, deteriorada:deterioradaE}, function(result, status){
        $("#resultado").html(result);
    });*/
    document.getElementById("formato").value="";
    document.getElementById("precio").value="";
    var deteriorada=$('input:checkbox[name=dete]:checked').val('off');
    alert("Guardado");
    
}
//registra la copia
function  regisrarOtra(){
    alert("hola");
    guardar();
    var deteriorada=$('input:checkbox[name=dete]:checked').val();
    
    if(deteriorada=='on'){
        alert("seleccionada");
    }else{
        alert("deseleccionada");
    }
    
}
function insertarPelicula(){
    var titulo=document.getElementById("titulo").value;
    var anio=document.getElementById("anio").value;
    var critica=document.getElementById("critica").value;
    $.ajax({
        type: "POST",
        url: "procesarIndex",
        data: {
            "proceso":"insertarPelicula",
            "titulo": titulo,
            "anio": anio,
            "critica": critica
        },
        cache: false,
        success: function (data) {

            $("#resultado2").empty();
            $("#resultado2").append(data);

        }
    });
    
}

