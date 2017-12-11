/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function guardar(){
    alert("Guardado");
}

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

